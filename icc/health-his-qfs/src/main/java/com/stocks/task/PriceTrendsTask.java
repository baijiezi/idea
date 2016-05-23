package com.stocks.task;

import com.stocks.dao.StocksPriceDao;
import com.stocks.entity.StocksPriceEntity;
import com.stocks.utils.DateUtils;
import com.stocks.utils.HibernateUtil;
import com.stocks.utils.NumberUtils;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-5-23
 * Time: 下午2:51
 * To change this template use File | Settings | File Templates.
 */
public class PriceTrendsTask {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args){
        PriceTrendsTask priceTrendsTask = new PriceTrendsTask();
        priceTrendsTask.execute();
    }

    public void execute(){
        logger.info("PriceTrendsTask  execute");
        try{
            Session session = HibernateUtil.getOpenSession();
            session.beginTransaction();

//            Date date = new Date();
            Date date = DateUtils.strToDate("2016-03-07");
            StocksPriceDao priceDao = new StocksPriceDao();
            List<StocksPriceEntity> list =  priceDao.getByDate(date);
            for(StocksPriceEntity entity : list){
                List<StocksPriceEntity> recentRecords = priceDao.getRecentRecords(date, entity.getCode(), session);
                for(StocksPriceEntity record : recentRecords){
                    String trends = record.getPriceTrends();
                    if(trends!=null && !trends.equals("")){
                        trends = trends + ",";
                    }
                    record.setPriceTrends(trends + NumberUtils.getBiLv(entity.getShouPan()-record.getShouPan(), record.getShouPan()));
                    session.update(record);
                }
            }

            session.getTransaction().commit();
            session.close();
            HibernateUtil.closeSessionFactory();

            logger.info("PriceTrendsTask  finish");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
