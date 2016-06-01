package com.stocks.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.Response;
import com.stocks.dao.StocksDao;
import com.stocks.dao.StocksZjlxHXDao;
import com.stocks.dto.StocksZjlxHXDto;
import com.stocks.entity.StocksEntity;
import com.stocks.entity.StocksZjlxHXEntity;
import com.stocks.utils.Constants;
import com.stocks.utils.HibernateUtil;
import com.stocks.utils.NumberUtils;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-2
 * Time: 下午10:29
 * To change this template use File | Settings | File Templates.
 */
public class StockZjlxHxTask {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args){

        StockZjlxHxTask stockZjlxHxTask = new StockZjlxHxTask();
        stockZjlxHxTask.execute();

    }

    public void execute(){
        logger.info("StockZjlxHXTask  execute");

        try{
            List data = new ArrayList<StocksZjlxHXDto>();
            StocksDao stocksDao = new StocksDao();
            List<StocksEntity> list = stocksDao.getAll();
            Date date = new Date();
//            date.setDate(date.getDate()-1);
            AsyncHttpClientConfig config = new AsyncHttpClientConfig.Builder()
                    .setMaximumConnectionsPerHost(30)
                    .setMaximumConnectionsTotal(300)
                    .setConnectionTimeoutInMs(25*60*1000)
                    .setRequestTimeoutInMs(5 * 1000 * 60)
                    .build();
            AsyncHttpClient asyncHttpClient = new AsyncHttpClient(config);

            for(StocksEntity stock : list){
                logger.info("StockZJLXTask:" + stock.getCode());
//                if(!stock.getCode().equals("002340")){
//                    continue;
//                }

                try{
                    if(stock.getZjlsHxTaskType()!=null && stock.getZjlsHxTaskType().equals(Constants.ZJLX_HX_URL_TYPE_1)){

                        String url = "http://vol.stock.hexun.com/Data/Stock/SMinData.ashx?code=" + stock.getCode() + "&count=20&page=1&callback=hx_json14579481800134419886";
                        logger.info("url:" + url);
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

                        StocksZjlxHXDto dto = new StocksZjlxHXDto();
                        dto.setCode(stock.getCode());
                        dto.setName(stock.getName());
                        dto.setDate(date);
                        dto.setHeJiChengJiao(NumberUtils.toLong(getText(((JSONObject) li.get(13)).getString("date1"))+"万"));
                        dto.setChaoDaDanLiuRu(NumberUtils.toLong(getText(((JSONObject) li.get(10)).getString("date1"))+"万"));
                        dto.setChaoDaDanLiuRuZhanBi(NumberUtils.toIntMilli(getText(((JSONObject) li.get(10)).getString("date2"))));
                        dto.setChaoDaDanLiuRuZengZhangLv(NumberUtils.toIntMilli(getText(((JSONObject)li.get(10)).getString("date3"))));
                        dto.setChaoDaDanLiuChu(NumberUtils.toLong(getText(((JSONObject)li.get(11)).getString("date1"))+"万"));
                        dto.setChaoDaDanLiuChuZhanBi(NumberUtils.toIntMilli(getText(((JSONObject)li.get(11)).getString("date2"))));
                        dto.setChaoDaDanLiuChuZengZhangLv(NumberUtils.toIntMilli(getText(((JSONObject)li.get(11)).getString("date3"))));
                        dto.setDaDanLiuRu(NumberUtils.toLong(getText(((JSONObject)li.get(7)).getString("date1"))+"万"));
                        dto.setDaDanLiuRuZhanBi(NumberUtils.toIntMilli(getText(((JSONObject)li.get(7)).getString("date2"))));
                        dto.setDaDanLiuRuZengZhangLv(NumberUtils.toIntMilli(getText(((JSONObject)li.get(7)).getString("date3"))));
                        dto.setDaDanLiuChu(NumberUtils.toLong(getText(((JSONObject)li.get(8)).getString("date1"))+"万"));
                        dto.setDaDanLiuChuZhanBi(NumberUtils.toIntMilli(getText(((JSONObject)li.get(8)).getString("date2"))));
                        dto.setDaDanLiuChuZengZhangLv(NumberUtils.toIntMilli(getText(((JSONObject)li.get(8)).getString("date3"))));
                        dto.setXiaoDanLiuRu(NumberUtils.toLong(getText(((JSONObject)li.get(4)).getString("date1"))+"万"));
                        dto.setXiaoDanLiuRuZhanBi(NumberUtils.toIntMilli(getText(((JSONObject)li.get(4)).getString("date2"))));
                        dto.setXiaoDanLiuRuZengZhangLv(NumberUtils.toIntMilli(getText(((JSONObject)li.get(4)).getString("date3"))));
                        dto.setXiaoDanLiuChu(NumberUtils.toLong(getText(((JSONObject)li.get(5)).getString("date1"))+"万"));
                        dto.setXiaoDanLiuChuZhanBi(NumberUtils.toIntMilli(getText(((JSONObject)li.get(5)).getString("date2"))));
                        dto.setXiaoDanLiuChuZengZhangLv(NumberUtils.toIntMilli(getText(((JSONObject)li.get(5)).getString("date3"))));
                        dto.setSanDanLiuRu(NumberUtils.toLong(getText(((JSONObject)li.get(1)).getString("date1"))+"万"));
                        dto.setSanDanLiuRuZhanBi(NumberUtils.toIntMilli(getText(((JSONObject)li.get(1)).getString("date2"))));
                        dto.setSanDanLiuRuZengZhangLv(NumberUtils.toIntMilli(getText(((JSONObject)li.get(1)).getString("date3"))));
                        dto.setSanDanLiuChu(NumberUtils.toLong(getText(((JSONObject)li.get(2)).getString("date1"))+"万"));
                        dto.setSanDanLiuChuZhanBi(NumberUtils.toIntMilli(getText(((JSONObject)li.get(2)).getString("date2"))));
                        dto.setSanDanLiuChuZengZhangLv(NumberUtils.toIntMilli(getText(((JSONObject)li.get(2)).getString("date3"))));
                        dto.setQiTaChengJiaoJinE(NumberUtils.toLong(getText(((JSONObject)li.get(12)).getString("date1"))+"万"));
                        dto.setQiTaZhanBi(NumberUtils.toIntMilli(getText(((JSONObject)li.get(12)).getString("date2"))));
                        dto.setQiTaZengZhanLv(NumberUtils.toIntMilli(getText(((JSONObject)li.get(12)).getString("date3"))));
                        dto.setJingLiuRu(dto.getChaoDaDanLiuRu() + dto.getDaDanLiuRu() + dto.getXiaoDanLiuRu() + dto.getSanDanLiuRu()
                                - dto.getChaoDaDanLiuChu() - dto.getDaDanLiuChu() + dto.getXiaoDanLiuChu() + dto.getSanDanLiuChu());
                        dto.setJingLiuRuLv(NumberUtils.toIntMilli(""));

                        data.add(dto);
                    }
                }catch (Exception e){
                    logger.error("StockZJLXTask远程异常：" + stock.getCode(), e);
                }
            }
            asyncHttpClient.close();
            List codes = updateData(data);
            updateTime(codes);
            logger.info("共完成获取资金流向" + codes.size() + " 条");
        } catch (Exception e){
            logger.error("执行StockZJLXTask任务异常：" + e.getMessage());
            e.printStackTrace();
        }

    }


    private List updateData(List<StocksZjlxHXDto> data){
        List codes = new ArrayList<String>();
        if(data==null || data.size()==0){
            return codes;
        }
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        StocksZjlxHXDao dao = new StocksZjlxHXDao();
        for(StocksZjlxHXDto dto : data){
            StocksZjlxHXEntity entity = new StocksZjlxHXEntity();
            entity.setCode(dto.getCode());
            entity.setName(dto.getName());
            entity.setDate(dto.getDate());
            entity.setHeJiChengJiao(dto.getHeJiChengJiao());
            entity.setJingLiuRu(dto.getJingLiuRu());
            entity.setJingLiuRuLv(dto.getJingLiuRuLv());
            entity.setChaoDaDanLiuRu(dto.getChaoDaDanLiuRu());
            entity.setChaoDaDanLiuRuZhanBi(dto.getChaoDaDanLiuRuZhanBi());
            entity.setChaoDaDanLiuRuZengZhangLv(dto.getChaoDaDanLiuRuZengZhangLv());
            entity.setChaoDaDanLiuChu(dto.getChaoDaDanLiuChu());
            entity.setChaoDaDanLiuChuZhanBi(dto.getChaoDaDanLiuChuZhanBi());
            entity.setChaoDaDanLiuChuZengZhangLv(dto.getChaoDaDanLiuChuZengZhangLv());
            entity.setDaDanLiuRu(dto.getDaDanLiuRu());
            entity.setDaDanLiuRuZhanBi(dto.getDaDanLiuRuZhanBi());
            entity.setDaDanLiuRuZengZhangLv(dto.getDaDanLiuRuZengZhangLv());
            entity.setDaDanLiuChu(dto.getDaDanLiuChu());
            entity.setDaDanLiuChuZhanBi(dto.getDaDanLiuChuZhanBi());
            entity.setDaDanLiuChuZengZhangLv(dto.getDaDanLiuChuZengZhangLv());
            entity.setXiaoDanLiuRu(dto.getXiaoDanLiuRu());
            entity.setXiaoDanLiuRuZhanBi(dto.getXiaoDanLiuRuZhanBi());
            entity.setXiaoDanLiuRuZengZhangLv(dto.getXiaoDanLiuRuZengZhangLv());
            entity.setXiaoDanLiuChu(dto.getXiaoDanLiuChu());
            entity.setXiaoDanLiuChuZhanBi(dto.getXiaoDanLiuChuZhanBi());
            entity.setXiaoDanLiuChuZengZhangLv(dto.getXiaoDanLiuChuZengZhangLv());
            entity.setSanDanLiuRu(dto.getSanDanLiuRu());
            entity.setSanDanLiuRuZhanBi(dto.getSanDanLiuRuZhanBi());
            entity.setSanDanLiuRuZengZhangLv(dto.getSanDanLiuRuZengZhangLv());
            entity.setSanDanLiuChu(dto.getSanDanLiuChu());
            entity.setSanDanLiuChuZhanBi(dto.getSanDanLiuChuZhanBi());
            entity.setSanDanLiuChuZengZhangLv(dto.getSanDanLiuChuZengZhangLv());
            entity.setQiTaChengJiaoJinE(dto.getQiTaChengJiaoJinE());
            entity.setQiTaZhanBi(dto.getQiTaZhanBi());
            entity.setQiTaZengZhanLv(dto.getQiTaZengZhanLv());
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
            entity.setZjlsHxUpdate(date);
            dao.update(entity, session);

        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }

    public String getText(String html){
        if(html==null || html.equals("") || html.trim().equals("")){
            return "";
        }
        int idx1 = html.indexOf(">");
        int idx2 = html.lastIndexOf("<");
        return html.substring(idx1+1, idx2);
    }

}
