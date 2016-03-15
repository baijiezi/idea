package com.stocks.task;

import com.alibaba.fastjson.JSON;
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
public class StockZjlxTHSTask {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args){

        StockZjlxTHSTask stockZjlxTHSTask = new StockZjlxTHSTask();
        stockZjlxTHSTask.execute();

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
                logger.info("StockZJLXTask:" + stock.getCode());
                if(!stock.getCode().equals("002340")){
                    continue;
                }
                if(stock.getUrl4Type() == null){
                    stock.setUrl4Type("1");
                }

                try{
                    if(stock.getUrl4Type()!=null && stock.getUrl4Type().equals(Constants.ZJLX_HX_URL_TYPE_1)){

                        String url = "http://vol.stock.hexun.com/Data/Stock/SMinData.ashx?code=" + stock.getCode() + "&count=20&page=1&callback=hx_json14579481800134419886";
                        Future r = asyncHttpClient.prepareGet(url).execute();
                        Response response = (Response) r.get();
                        String result = response.getResponseBody();
                        logger.info("result:" + result);
                        int idx1 = result.indexOf("{");
                        int idx2 = result.lastIndexOf("}");
                        System.out.println(result.indexOf("{"));
                        System.out.println(result.lastIndexOf("}"));
                        String rs = result.substring(idx1, idx2+1);
                        logger.info(rs);
                        JSONObject jsonObject = JSON.parseObject(rs);
                        List li = (List)jsonObject.get("list");
                        for(int i=0; i<li.size(); i++){
                            System.out.println(i + "  " + li.get(i));
                            JSONObject object = (JSONObject)li.get(i);
                            System.out.println(object.get("date0"));
                        }

                        StocksZjlxTHSDto dto = new StocksZjlxTHSDto();
                        dto.setCode(stock.getCode());
                        dto.setName(stock.getName());
                        dto.setDate(date);
                        dto.setHeJiChengJiao(NumberUtils.toLong(""));
                        dto.setJingLiuRu(NumberUtils.toLong(""));
                        dto.setJingLiuRuLv(NumberUtils.toIntMilli(""));
                        dto.setChaoDaDanLiuRu(NumberUtils.toLong(""));
                        dto.setChaoDaDanLiuRuZhanBi(NumberUtils.toIntMilli(""));
                        dto.setChaoDaDanLiuRuZengZhangLv(NumberUtils.toIntMilli(""));
                        dto.setChaoDaDanLiuChu(NumberUtils.toLong(""));
                        dto.setChaoDaDanLiuChuZhanBi(NumberUtils.toIntMilli(""));
                        dto.setChaoDaDanLiuChuZengZhangLv(NumberUtils.toIntMilli(""));
                        dto.setDaDanLiuRu(NumberUtils.toLong(""));
                        dto.setDaDanLiuRuZhanBi(NumberUtils.toIntMilli(""));
                        dto.setDaDanLiuRuZengZhangLv(NumberUtils.toIntMilli(""));
                        dto.setDaDanLiuChu(NumberUtils.toLong(""));
                        dto.setDaDanLiuChuZhanBi(NumberUtils.toIntMilli(""));
                        dto.setDaDanLiuChuZengZhangLv(NumberUtils.toIntMilli(""));
                        dto.setXiaoDanLiuRu(NumberUtils.toLong(""));
                        dto.setXiaoDanLiuRuZhanBi(NumberUtils.toIntMilli(""));
                        dto.setXiaoDanLiuRuZengZhangLv(NumberUtils.toIntMilli(""));
                        dto.setXiaoDanLiuChu(NumberUtils.toLong(""));
                        dto.setXiaoDanLiuChuZhanBi(NumberUtils.toIntMilli(""));
                        dto.setXiaoDanLiuChuZengZhangLv(NumberUtils.toIntMilli(""));
                        dto.setSanDanLiuRu(NumberUtils.toLong(""));
                        dto.setSanDanLiuRuZhanBi(NumberUtils.toIntMilli(""));
                        dto.setSanDanLiuRuZengZhangLv(NumberUtils.toIntMilli(""));
                        dto.setSanDanLiuChu(NumberUtils.toLong(""));
                        dto.setSanDanLiuChuZhanBi(NumberUtils.toIntMilli(""));
                        dto.setSanDanLiuChuZengZhangLv(NumberUtils.toIntMilli(""));
                        dto.setQiTaChengJiaoJinE(NumberUtils.toLong(""));
                        dto.setQiTaZhanBi(NumberUtils.toIntMilli(""));
                        dto.setQiTaZengZhanLv(NumberUtils.toIntMilli(""));


                        data.add(dto);
                    }
                }catch (Exception e){
                    logger.error("StockZjlxTHSTask 远程异常：" + stock.getCode());
                    logger.error(e.getMessage());
                    e.printStackTrace();
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
            entity.setZjlsUpdate(date);
            dao.update(entity, session);

        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }

}
