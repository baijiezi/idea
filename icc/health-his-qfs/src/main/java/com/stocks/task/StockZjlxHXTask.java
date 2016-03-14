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
public class StockZjlxHXTask {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args){

        StockZjlxHXTask stockZjlxHXTask = new StockZjlxHXTask();
        stockZjlxHXTask.execute();

    }

    public void execute(){
        logger.info("StockZJLXTask  execute");

        try{
            List data = new ArrayList<StocksZjlxHXDto>();
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
//                            Map<String, String> map = (HashMap<String, String>)li.get(i);
                            JSONObject object = (JSONObject)li.get(i);
                            System.out.println(object.get("date0"));
                        }

                        StocksZjlxHXDto zjlxDto = new StocksZjlxHXDto();
                        zjlxDto.setCode(stock.getCode());
                        zjlxDto.setName(stock.getName());
                        zjlxDto.setDate(date);



                        data.add(zjlxDto);
                    }
                }catch (Exception e){
                    logger.error("StockZJLXTask远程异常：" + stock.getCode());
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
