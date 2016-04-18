package com.stocks.task.kline;

import com.stocks.dao.StocksDailyKLineMA10Dao;
import com.stocks.dao.StocksDao;
import com.stocks.dao.StocksPriceDao;
import com.stocks.entity.StocksDailyKLineMA10Entity;
import com.stocks.entity.StocksEntity;
import com.stocks.utils.DateUtils;
import com.stocks.utils.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-4-12
 * Time: 下午4:48
 * To change this template use File | Settings | File Templates.
 */
public class StockDailyKLineMA10Task {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args){
        StockDailyKLineMA10Task stockDailyKLineMA10Task = new StockDailyKLineMA10Task();
        stockDailyKLineMA10Task.execute();
    }

    public void execute(){
        logger.info("StockDailyKLineMA10Task  execute");
        try{
            StocksDao stocksDao = new StocksDao();
            StocksPriceDao priceDao = new StocksPriceDao();
            List<StocksEntity> list = stocksDao.getAll();
            Date date = new Date();
//            Date date = DateUtils.strToDate("2016-03-17");
            while(DateUtils.getDate(date).before(new Date())){
                List data = new ArrayList<StocksDailyKLineMA10Entity>();
                Session session = HibernateUtil.getOpenSession();
                for(StocksEntity stock : list){
                    logger.info("==============================StockDailyKLineMA10Task:" + stock.getName() + "    " + stock.getCode() + "  " + DateUtils.getSimpleDate(date) +"===============================");
                    try{
                        StocksDailyKLineMA10Entity entity = priceDao.getMA10(stock.getCode(), DateUtils.getSimpleDate(date), session);
                        if(entity == null){
                            continue;
                        }
                        data.add(entity);
                    }catch (Exception e){
                        logger.error("StockDailyKLineMA10Task异常："+stock.getCode(), e);
                    }
                }
                session.close();
                HibernateUtil.closeSessionFactory();
                updateData(data);
                logger.info(DateUtils.getSimpleDate(date)+ " 共完成DailyKLineMA10 数据" + data.size() + " 条");
                date.setDate(date.getDate()+1);
            }
        } catch (Exception e){
            logger.error("执行StockDailyKLineMA10Task任务异常：", e);
        }
    }


    private void updateData(List<StocksDailyKLineMA10Entity> data){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        StocksDailyKLineMA10Dao dao = new StocksDailyKLineMA10Dao();
        for(StocksDailyKLineMA10Entity entity : data){
            entity.setCreateTime(new Date());
            dao.save(entity, session);
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }
}
