package com.stocks.task;

import com.stocks.dao.StocksParamsDao;
import com.stocks.dao.StocksPriceDao;
import com.stocks.entity.StocksParamsEntity;
import com.stocks.entity.StocksPriceEntity;
import com.stocks.utils.DateUtils;
import com.stocks.utils.HibernateUtil;
import com.stocks.utils.NumberUtils;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.*;

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
        System.out.println(new Date());
        logger.info("PriceTrendsTask  execute");
        try{
            StocksParamsDao paramsDao = new StocksParamsDao();
            StocksParamsEntity paramsEntity = paramsDao.getByParam("priceTrends");
            Date date = DateUtils.strToDate(paramsEntity.getValue());
            Date endDate = new Date();

            while (date.before(endDate)){
                logger.info("start PriceTrendsTask, Date = " + DateUtils.getSimpleDate(date));
                Session session = HibernateUtil.getOpenSession();
                session.beginTransaction();
                Integer maxId = (Integer)session.createQuery("select max(p.id) from StocksPriceEntity p " ).uniqueResult();

                StocksPriceDao priceDao = new StocksPriceDao();
                List<StocksPriceEntity> list =  priceDao.getByDate(date);
                logger.info("size:" + list.size());
                Map<String, Integer> map = new HashMap<String, Integer>();
                for(StocksPriceEntity entity : list){
                    map.put(entity.getCode(), entity.getShouPan());
                }
                List<StocksPriceEntity> recentRecords = null;
                for(int i=0; i<600; i++){
                    Integer idMax = maxId - i * 500;
                    Integer idMin = maxId - (i+1)*500;
                    logger.info(i + "  " + idMax + "  " + DateUtils.getStrTime(new Date()));
                    recentRecords = priceDao.getById(session, idMin, idMax);
                    logger.info(i + "  " + idMin + "  " + DateUtils.getStrTime(new Date()));
                    logger.info("" + recentRecords.size());

                    for(StocksPriceEntity record : recentRecords){
                        String trends = record.getPriceTrends();
                        if((trends!=null && trends.length()>=248) || record.getDate().compareTo(date)>=0){
                            continue;
                        }
                        String code = record.getCode();
                        String biLv = "0";
                        if(map.get(code)!=null && map.get(code)!=0 && record.getShouPan()!=0){
                            biLv = String.valueOf(NumberUtils.getBiLv2(map.get(code)-record.getShouPan(), record.getShouPan()));
                        }
                        if(trends==null || trends.equals("")){
                            record.setPriceTrends(biLv);
                        }
                        else{
                            record.setPriceTrends(trends + "," + biLv);
                        }
                        session.update(record);
                    }
                    recentRecords = null;
                }
                logger.info("开始提交事务" + DateUtils.getStrTime(new Date()));
                session.getTransaction().commit();
                session.close();
                logger.info("完成提交事务" + DateUtils.getStrTime(new Date()));
                HibernateUtil.closeSessionFactory();
                date = DateUtils.addDate(date, 1);
                paramsEntity.setParam(DateUtils.getSimpleDate(date));
                paramsDao.update(paramsEntity);
            }
            logger.info("PriceTrendsTask  finish");
        }catch (Exception e){
            logger.error("PriceTrendsTask异常：", e);
            e.printStackTrace();
        }
    }


    public void execute2(){
        System.out.println(new Date());
        logger.info("PriceTrendsTask  execute");
        try{
            Date date = new Date();
            Date endDate = DateUtils.strToDate(DateUtils.getSimpleDate(date) + " 23:59:59");
            InetAddress localHost = InetAddress.getLocalHost();
//            if(localHost.getHostAddress().equals("192.168.200.27")){
            if(true){
                date = DateUtils.strToDate("2016-12-14");
                endDate = DateUtils.strToDate("2016-12-14 23:59:59");
            }

            while (date.before(endDate)){
                System.out.println(new Date());
                logger.info("start PriceTrendsTask, Date = " + DateUtils.getSimpleDate(date));
                Session session = HibernateUtil.getOpenSession();
                session.beginTransaction();
                Integer maxId = (Integer)session.createQuery("select max(p.id) from StocksPriceEntity p " ).uniqueResult();
                Integer minId = maxId - 2748 * 100;

                StocksPriceDao priceDao = new StocksPriceDao();
                List<StocksPriceEntity> list =  priceDao.getByDate(date);
                List<StocksPriceEntity> recentRecords = null;
                for(StocksPriceEntity entity : list){
                    System.out.println(entity.getCode() + "  " + DateUtils.getStrTime(new Date()));
                    recentRecords = priceDao.getRecentRecords(entity.getCode(), session, minId);
                    System.out.println(entity.getCode() + "  " + DateUtils.getStrTime(new Date()));
                    for(StocksPriceEntity record : recentRecords){
                        String trends = record.getPriceTrends();
//                        if(trends!=null && trends.length()>=248){
                        if((trends!=null && trends.length()>=248) || record.getDate().compareTo(date)>=0){
                            continue;
                        }
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
            System.out.println(new Date());
        }catch (Exception e){
            logger.error("PriceTrendsTask异常：", e);
            e.printStackTrace();
        }
    }
}
