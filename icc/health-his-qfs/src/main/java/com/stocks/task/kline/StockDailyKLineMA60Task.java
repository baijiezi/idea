package com.stocks.task.kline;

import com.stocks.dao.StocksDailyKLineMA60Dao;
import com.stocks.dao.StocksDao;
import com.stocks.dao.StocksPriceDao;
import com.stocks.entity.StocksDailyKLineMA60Entity;
import com.stocks.entity.StocksEntity;
import com.stocks.utils.DateUtils;
import com.stocks.utils.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-12-7
 * Time: 下午3:05
 * To change this template use File | Settings | File Templates.
 */
public class StockDailyKLineMA60Task {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args){
        StockDailyKLineMA60Task stockDailyKLineMA60Task = new StockDailyKLineMA60Task();
        stockDailyKLineMA60Task.execute();
    }

    public void execute(){
        logger.info("StockDailyKLineMA60Task  execute");
        try{
            Date date = new Date();
            Date endDate = DateUtils.strToDate(DateUtils.getSimpleDate(date) + " 23:59:59");
            InetAddress localHost = InetAddress.getLocalHost();
            if(localHost.getHostAddress().equals("192.168.200.27")){
//            if(true){
                date = DateUtils.strToDate("2016-12-10");
                endDate = DateUtils.strToDate("2016-12-14 23:59:59");
            }

            StocksDao stocksDao = new StocksDao();
            StocksPriceDao priceDao = new StocksPriceDao();
            List<StocksEntity> list = stocksDao.getAll();
            while(date.before(endDate)){
                System.out.println(DateUtils.getSimpleDate(date));
                List data = new ArrayList<StocksDailyKLineMA60Entity>();
                Session session = HibernateUtil.getOpenSession();
                for(StocksEntity stock : list){
//                    logger.info("==============================StockDailyKLineMA60Task:" + stock.getName() + "    " + stock.getCode() + "  " + DateUtils.getSimpleDate(date) +"===============================");
                    try{
                        StocksDailyKLineMA60Entity entity = priceDao.getMA60(stock.getCode(), DateUtils.getSimpleDate(date), session);
                        if(entity == null){
                            continue;
                        }
                        data.add(entity);
                    }catch (Exception e){
                        logger.error("StockDailyKLineMA60Task异常："+stock.getCode(), e);
                    }
                }
                session.close();
                updateData(data);
                logger.info(DateUtils.getSimpleDate(date) + " 共完成DailyKLineMA60 数据" + data.size() + " 条");
                date.setDate(date.getDate()+1);
            }
        } catch (Exception e){
            logger.error("执行StockDailyKLineMA60Task任务异常：", e);
        }
    }


    private void updateData(List<StocksDailyKLineMA60Entity> data){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        StocksDailyKLineMA60Dao dao = new StocksDailyKLineMA60Dao();
        for(StocksDailyKLineMA60Entity entity : data){
            entity.setCreateTime(new Date());
            dao.save(entity, session);
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }
}
