package com.stocks.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.Response;
import com.stocks.dao.StocksDao;
import com.stocks.dao.StocksZjlxTHSDao;
import com.stocks.dto.StocksZjlxTHSDto;
import com.stocks.entity.StocksEntity;
import com.stocks.entity.StocksZjlxTHSEntity;
import com.stocks.utils.Constants;
import com.stocks.utils.HibernateUtil;
import com.stocks.utils.NumberUtils;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-3-15
 * Time: 下午4:16
 * To change this template use File | Settings | File Templates.
 */
public class StockZjlxThsTask {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args){

        StockZjlxThsTask stockZjlxThsTask = new StockZjlxThsTask();
        stockZjlxThsTask.execute();

    }

    public void execute(){
        logger.info("StockZjlxTHSTask  execute");

        try{
            List data = new ArrayList<StocksZjlxTHSDto>();
            StocksDao stocksDao = new StocksDao();
            List<StocksEntity> list = stocksDao.getAll();
            Date date = new Date();
            AsyncHttpClientConfig config = new AsyncHttpClientConfig.Builder()
                    .setMaximumConnectionsPerHost(30)
                    .setMaximumConnectionsTotal(300)
                    .setConnectionTimeoutInMs(25*60*1000)
                    .setRequestTimeoutInMs(5 * 1000 * 60)
                    .build();
            AsyncHttpClient asyncHttpClient = new AsyncHttpClient(config);

            for(StocksEntity stock : list){
                logger.info("StockZjlxThsTask:" + stock.getCode());
                if(!stock.getCode().equals("002550")){
                    continue;
                }

                try{
                    if(stock.getZjlsThsTaskType()!=null && stock.getZjlsThsTaskType().equals(Constants.ZJLX_THS_URL_TYPE_1)){

                        String url = "http://stockpage.10jqka.com.cn/spService/" + stock.getCode() + "/Funds/realFunds";
                        logger.info("url:" + url);
                        Future r = asyncHttpClient.prepareGet(url).execute();
                        Response response = (Response) r.get();
                        String result = response.getResponseBody();
                        logger.info("result:" + result);
                        JSONObject jsonObject = JSON.parseObject(result);
                        JSONObject title = (JSONObject)jsonObject.get("title");
                        JSONArray flashArray = (JSONArray)jsonObject.get("flash");
                        StocksZjlxTHSDto dto = new StocksZjlxTHSDto();
                        dto.setCode(stock.getCode());
                        dto.setName(stock.getName());
                        dto.setDate(date);
                        dto.setZongLiuRu(NumberUtils.toLong(title.getString("zlr")+"万"));
                        dto.setZongLiuChu(NumberUtils.toLong(title.getString("zlc")+"万"));
                        dto.setChengJiaoE(dto.getZongLiuRu()+dto.getZongLiuChu());
                        dto.setJingLiuRu(NumberUtils.toLong(title.getString("je")+"万"));
                        dto.setJingLiuRuZhanBi(NumberUtils.getBiLv(dto.getJingLiuRu(), dto.getChengJiaoE()));
                        dto.setDaDanLiuRu(NumberUtils.toLong(((JSONObject)flashArray.get(5)).getString("sr")+"万"));
                        dto.setDaDanLiuRuZhanBi(NumberUtils.getBiLv(dto.getDaDanLiuRu(), dto.getChengJiaoE()));
                        dto.setDaDanLiuChu(NumberUtils.toLong(((JSONObject)flashArray.get(0)).getString("sr")+"万"));
                        dto.setDaDanLiuChuZhanBi(NumberUtils.getBiLv(dto.getDaDanLiuChu(), dto.getChengJiaoE()));
                        dto.setZhongDanLiuRu(NumberUtils.toLong(((JSONObject)flashArray.get(4)).getString("sr")+"万"));
                        dto.setZhongDanLiuRuZhanBi(NumberUtils.getBiLv(dto.getZhongDanLiuRu(), dto.getChengJiaoE()));
                        dto.setZhongDanLiuChu(NumberUtils.toLong(((JSONObject)flashArray.get(1)).getString("sr")+"万"));
                        dto.setZhongDanLiuChuZhanBi(NumberUtils.getBiLv(dto.getZhongDanLiuChu(), dto.getChengJiaoE()));
                        dto.setXiaoDanLiuRu(NumberUtils.toLong(((JSONObject)flashArray.get(3)).getString("sr")+"万"));
                        dto.setXiaoDanLiuRuZhanBi(NumberUtils.getBiLv(dto.getXiaoDanLiuRu(), dto.getChengJiaoE()));
                        dto.setXiaoDanLiuChu(NumberUtils.toLong(((JSONObject)flashArray.get(2)).getString("sr")+"万"));
                        dto.setXiaoDanLiuChuZhanBi(NumberUtils.getBiLv(dto.getXiaoDanLiuChu(), dto.getChengJiaoE()));

                        data.add(dto);
                    }
                }catch (Exception e){
                    logger.error("StockZjlxTHSTask 远程异常：" + stock.getCode() , e);
                }
            }
            List codes = updateData(data);
            updateTime(codes);
            logger.info("共完成获取资金流向" + codes.size() + " 条");
        } catch (Exception e){
            logger.error("执行StockZJLXTask任务异常：" + e.getMessage());
            e.printStackTrace();
        }

    }


    private List updateData(List<StocksZjlxTHSDto> data){
        List codes = new ArrayList<String>();
        if(data==null || data.size()==0){
            return codes;
        }
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        StocksZjlxTHSDao dao = new StocksZjlxTHSDao();
        for(StocksZjlxTHSDto dto : data){
            StocksZjlxTHSEntity entity = new StocksZjlxTHSEntity();
            entity.setCode(dto.getCode());
            entity.setName(dto.getName());
            entity.setDate(dto.getDate());
            entity.setChengJiaoE(dto.getChengJiaoE());
            entity.setZongLiuRu(dto.getZongLiuRu());
            entity.setZongLiuChu(dto.getZongLiuChu());
            entity.setJingLiuRu(dto.getJingLiuRu());
            entity.setJingLiuRuZhanBi(dto.getJingLiuRuZhanBi());
            entity.setDaDanLiuRu(dto.getDaDanLiuRu());
            entity.setDaDanLiuRuZhanBi(dto.getDaDanLiuRuZhanBi());
            entity.setDaDanLiuChu(dto.getDaDanLiuChu());
            entity.setDaDanLiuChuZhanBi(dto.getDaDanLiuChuZhanBi());
            entity.setZhongDanLiuRu(dto.getZhongDanLiuRu());
            entity.setZhongDanLiuRuZhanBi(dto.getZhongDanLiuRuZhanBi());
            entity.setZhongDanLiuChu(dto.getZhongDanLiuChu());
            entity.setZhongDanLiuChuZhanBi(dto.getZhongDanLiuChuZhanBi());
            entity.setXiaoDanLiuRu(dto.getXiaoDanLiuRu());
            entity.setXiaoDanLiuRuZhanBi(dto.getXiaoDanLiuRuZhanBi());
            entity.setXiaoDanLiuChu(dto.getXiaoDanLiuChu());
            entity.setXiaoDanLiuChuZhanBi(dto.getXiaoDanLiuChuZhanBi());
            entity.setCreateAt(new Date());

            if(dao.save(entity, session)){
                codes.add(entity.getCode());
            }
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
        return codes;
    }

    private void updateTime(List<String> codes){
        if(codes==null || codes.size()==0){
            return;
        }
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        StocksDao dao = new StocksDao();
        Date date = new Date();
        for(String code : codes){
            StocksEntity entity = dao.getByCode(code, session);
            entity.setZjlsThsUpdate(date);
            dao.update(entity, session);

        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }

}
