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
//            Date date = new Date();
//            Date endDate = DateUtils.strToDate(DateUtils.getSimpleDate(date) + " 23:59:59");
            Date date = DateUtils.strToDate("2016-03-12");
            Date endDate = DateUtils.strToDate("2016-03-14 23:59:59");
            while (date.before(endDate)){
                logger.info("start PriceTrendsTask, Date = " + DateUtils.getSimpleDate(date));
                Session session = HibernateUtil.getOpenSession();
                session.beginTransaction();
                StocksPriceDao priceDao = new StocksPriceDao();
                List<StocksPriceEntity> list =  priceDao.getByDate(date);
                for(StocksPriceEntity entity : list){
//                if(!entity.getCode().equals("600136")){
//                    continue;
//                }
                    List<StocksPriceEntity> recentRecords = priceDao.getRecentRecords(date, entity.getCode(), session);
                    for(StocksPriceEntity record : recentRecords){
                        String trends = record.getPriceTrends();
                        String biLv = "0";
                        if(entity.getShouPan()!=0 && record.getShouPan()!=0){
                            biLv = String.valueOf(NumberUtils.getBiLv2(entity.getShouPan()-record.getShouPan(), record.getShouPan()));
                        }
                        if(trends==null || trends.equals("")){
                            record.setPriceTrends(biLv);
                        }
                        else{
                            record.setPriceTrends(trends + "," + biLv);
                        }
                        session.update(record);
                    }
                }

                session.getTransaction().commit();
                session.close();
                HibernateUtil.closeSessionFactory();

                date = DateUtils.addDate(date, 1);
            }
            logger.info("PriceTrendsTask  finish");
        }catch (Exception e){
            logger.error("PriceTrendsTask异常：", e);
            e.printStackTrace();
        }
    }


}
