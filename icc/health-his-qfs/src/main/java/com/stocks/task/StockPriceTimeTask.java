package com.stocks.task;

import com.message.dao.MessageDao;
import com.message.service.MessageService;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.Response;
import com.stocks.dao.*;
import com.stocks.dto.StocksPriceDto;
import com.stocks.entity.*;
import com.stocks.utils.DateUtils;
import com.stocks.utils.HibernateUtil;
import com.stocks.utils.NumberUtils;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-11-20
 * Time: 下午3:34
 * To change this template use File | Settings | File Templates.
 */
public class StockPriceTimeTask {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args){
        StockPriceTimeTask stockPriceTimeTask = new StockPriceTimeTask();
        stockPriceTimeTask.execute();

    }

    public void execute(){
        logger.info("StockPriceTimeTask  execute");

        try{
            Date now = new Date();
            Date time1 = DateUtils.strToDate(DateUtils.getSimpleDate(now) + " 11:30:00");
            Date time2 = DateUtils.strToDate(DateUtils.getSimpleDate(now) + " 13:00:00");
            Date endTime = DateUtils.strToDate(DateUtils.getSimpleDate(now) + " 15:02:00");

            AsyncHttpClientConfig config = new AsyncHttpClientConfig.Builder()
                    .setMaximumConnectionsPerHost(30)
                    .setMaximumConnectionsTotal(300)
                    .setConnectionTimeoutInMs(30*60*1000)
                    .setRequestTimeoutInMs(30*60*1000)
                    .build();
            AsyncHttpClient asyncHttpClient = new AsyncHttpClient(config);
            Session session = HibernateUtil.getOpenSession();
            session.beginTransaction();
            StocksPriceTimeDao dao = new StocksPriceTimeDao();

            while (now.before(endTime)){
                System.out.println(DateUtils.getStrTime(new Date()));
                now = new Date();
                if(now.before(time1) || now.after(time2)){
                    String url = "http://qt.gtimg.cn/r=0.9694567599799484q=s_sh000001,s_sz399001";
                    Future r = asyncHttpClient.prepareGet(url).execute();
                    Response response = (Response) r.get();
                    String result = response.getResponseBody();
                    String[] results = result.split(";");
                    for(String rs : results){
                        if(rs.trim().equals("")){
                            continue;
                        }
                        String str = rs.substring(rs.indexOf("\"")+1, rs.lastIndexOf("\""));
                        String[] temp = str.split("~");
                        StocksPriceTimeEntity timeEntity = new StocksPriceTimeEntity();
                        timeEntity.setCode(temp[2]);
                        if(temp[1].equals("上证指数")){
                            timeEntity.setCode("000001_2");
                        }
                        timeEntity.setPrice(NumberUtils.toIntMilli(temp[3]));
                        timeEntity.setCreateTime(new Date());
                        session.beginTransaction();
                        dao.save(timeEntity, session);
                        session.getTransaction().commit();
                    }


                }
                int seconds = new Date().getSeconds();
                Thread.sleep((60-seconds)*1000);
            }

            session.close();
            HibernateUtil.closeSessionFactory();
            asyncHttpClient.close();
        } catch (Exception e){
            logger.error("执行StockPriceTimeTask任务异常：", e);
        }
        logger.info("执行StockPriceTimeTask任务结束");
    }
}
