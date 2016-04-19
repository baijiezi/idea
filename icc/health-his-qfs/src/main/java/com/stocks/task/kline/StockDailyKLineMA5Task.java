package com.stocks.task.kline;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.Response;
import com.stocks.dao.StocksDailyKLineMA5Dao;
import com.stocks.dao.StocksDao;
import com.stocks.dao.StocksPriceDao;
import com.stocks.dto.StocksPriceDto;
import com.stocks.entity.StocksDailyKLineMA5Entity;
import com.stocks.entity.StocksEntity;
import com.stocks.entity.StocksPriceEntity;
import com.stocks.utils.Constants;
import com.stocks.utils.DateUtils;
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
 * User: Administrator
 * Date: 16-4-12
 * Time: 下午4:48
 * To change this template use File | Settings | File Templates.
 */
public class StockDailyKLineMA5Task {


    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args){
        StockDailyKLineMA5Task stockDailyKLineMA5Task = new StockDailyKLineMA5Task();
        stockDailyKLineMA5Task.execute();
    }

    public void execute(){
        logger.info("StockDailyKLineMA5Task  execute");
        try{
            StocksDao stocksDao = new StocksDao();
            StocksPriceDao priceDao = new StocksPriceDao();
            List<StocksEntity> list = stocksDao.getAll();
            Date date = new Date();
//            Date date = DateUtils.strToDate("2016-03-10");
            while(DateUtils.getDateStartTime(date).before(new Date())){
                List data = new ArrayList<StocksDailyKLineMA5Entity>();
                Session session = HibernateUtil.getOpenSession();
                for(StocksEntity stock : list){
                    logger.info("==============================StockDailyKLineMA5Task:" + stock.getName() + "    " + stock.getCode() + "  " + DateUtils.getSimpleDate(date) +"===============================");
                    try{
                        StocksDailyKLineMA5Entity entity = priceDao.getMA5(stock.getCode(), DateUtils.getSimpleDate(date), session);
                        if(entity == null){
                            continue;
                        }
                        data.add(entity);
                    }catch (Exception e){
                        logger.error("StockDailyKLineMA5Task异常："+stock.getCode(), e);
                    }
                }
                session.close();
                HibernateUtil.closeSessionFactory();
                updateData(data);
                logger.info(DateUtils.getSimpleDate(date) + " 共完成DailyKLineMA5 数据" + data.size() + " 条");
                date.setDate(date.getDate()+1);
            }
        } catch (Exception e){
            logger.error("执行StockDailyKLineMA5Task任务异常：", e);
        }

    }


    private void updateData(List<StocksDailyKLineMA5Entity> data){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        StocksDailyKLineMA5Dao dao = new StocksDailyKLineMA5Dao();
        for(StocksDailyKLineMA5Entity entity : data){
            entity.setCreateTime(new Date());
            dao.save(entity, session);
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }

}
