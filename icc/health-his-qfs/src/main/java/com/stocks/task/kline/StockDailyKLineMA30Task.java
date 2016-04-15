package com.stocks.task.kline;

import com.stocks.dao.StocksDailyKLineMA30Dao;
import com.stocks.dao.StocksDao;
import com.stocks.dao.StocksPriceDao;
import com.stocks.entity.StocksDailyKLineMA30Entity;
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
 * User: BaiJiezi
 * Date: 16-4-13
 * Time: 下午11:11
 * To change this template use File | Settings | File Templates.
 */
public class StockDailyKLineMA30Task {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args){
        StockDailyKLineMA30Task stockDailyKLineMA30Task = new StockDailyKLineMA30Task();
        stockDailyKLineMA30Task.execute();
    }

    public void execute(){
        logger.info("StockDailyKLineMA30Task  execute");
        try{
            StocksDao stocksDao = new StocksDao();
            StocksPriceDao priceDao = new StocksPriceDao();
            List<StocksEntity> list = stocksDao.getAll();
//            Date date = new Date();
            Date date = DateUtils.strToDate("2016-04-14");
            while(date.before(new Date())){
                List data = new ArrayList<StocksDailyKLineMA30Entity>();
                Session session = HibernateUtil.getOpenSession();
                for(StocksEntity stock : list){
                    logger.info("==============================StockDailyKLineMA30Task:" + stock.getName() + "    " + stock.getCode() + "  " + DateUtils.getSimpleDate(date) +"===============================");
                    try{
                        StocksDailyKLineMA30Entity entity = priceDao.getMA30(stock.getCode(), DateUtils.getSimpleDate(date), session);
                        if(entity == null){
                            continue;
                        }
                        data.add(entity);
                    }catch (Exception e){
                        logger.error("StockDailyKLineMA30Task异常："+stock.getCode(), e);
                    }
                }
                session.close();
                updateData(data);
                logger.info(DateUtils.getSimpleDate(date) + " 共完成DailyKLineMA30 数据" + data.size() + " 条");
                date.setDate(date.getDate()+1);
            }
        } catch (Exception e){
            logger.error("执行StockDailyKLineMA30Task任务异常：", e);
        }
    }


    private void updateData(List<StocksDailyKLineMA30Entity> data){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        StocksDailyKLineMA30Dao dao = new StocksDailyKLineMA30Dao();
        for(StocksDailyKLineMA30Entity entity : data){
            entity.setCreateTime(new Date());
            dao.save(entity, session);
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }
}
