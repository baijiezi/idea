package com.stocks.task;

import com.stocks.dao.*;
import com.stocks.entity.*;
import com.stocks.utils.DateUtils;
import com.stocks.utils.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-11-17
 * Time: 下午9:14
 * To change this template use File | Settings | File Templates.
 */
public class StockJxzxTask {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args){

        StockJxzxTask stockJxzxTask = new StockJxzxTask();
        stockJxzxTask.execute();

    }

    public void execute(){
        logger.info("StokJxplTask  execute");

        try{
            Date date = new Date();
            Date endDate = DateUtils.strToDate(DateUtils.getSimpleDate(date) + " 23:59:59");
            InetAddress localHost = InetAddress.getLocalHost();
//            if(localHost.getHostAddress().equals("192.168.200.27")){
            if(true){
                date = DateUtils.strToDate("2016-04-14");
                endDate = DateUtils.strToDate("2016-06-17 23:59:59");
            }

            while (date.before(endDate)){
                logger.info("start StockJxzxTask, Date = " + DateUtils.getSimpleDate(date));

                StocksPriceDao priceDao = new StocksPriceDao();
                List<StocksPriceEntity> priceList = priceDao.getByDate(date);

                StocksDailyKLineMA5Dao kLineMA5Dao = new StocksDailyKLineMA5Dao();
                List<StocksDailyKLineMA5Entity> ma5List = kLineMA5Dao.getByDate(date);
                Map<String, StocksDailyKLineMA5Entity> ma5Map = new HashMap<String, StocksDailyKLineMA5Entity>();
                for(StocksDailyKLineMA5Entity entity : ma5List){
                    ma5Map.put(entity.getCode(), entity);
                }

                StocksDailyKLineMA10Dao kLineMA10Dao = new StocksDailyKLineMA10Dao();
                List<StocksDailyKLineMA10Entity> ma10List = kLineMA10Dao.getByDate(date);
                Map<String, StocksDailyKLineMA10Entity> ma10Map = new HashMap<String, StocksDailyKLineMA10Entity>();
                for(StocksDailyKLineMA10Entity entity : ma10List){
                    ma10Map.put(entity.getCode(), entity);
                }

                StocksDailyKLineMA20Dao kLineMA20Dao = new StocksDailyKLineMA20Dao();
                List<StocksDailyKLineMA20Entity> ma20List = kLineMA20Dao.getByDate(date);
                Map<String, StocksDailyKLineMA20Entity> ma20Map = new HashMap<String, StocksDailyKLineMA20Entity>();
                for(StocksDailyKLineMA20Entity entity : ma20List){
                    ma20Map.put(entity.getCode(), entity);
                }

                StocksDailyKLineMA30Dao kLineMA30Dao = new StocksDailyKLineMA30Dao();
                List<StocksDailyKLineMA30Entity> ma30List = kLineMA30Dao.getByDate(date);
                Map<String, StocksDailyKLineMA30Entity> ma30Map = new HashMap<String, StocksDailyKLineMA30Entity>();
                for(StocksDailyKLineMA30Entity entity : ma30List){
                    ma30Map.put(entity.getCode(), entity);
                }

                Session session = HibernateUtil.getOpenSession();
                session.beginTransaction();
                for(StocksPriceEntity entity : priceList){
                    String code = entity.getCode();
                    if(ma5Map.get(code)!=null && ma10Map.get(code)!=null && ma20Map.get(code)!=null && ma30Map.get(code)!=null){
                        StringBuffer sb = new StringBuffer();
                        if (entity.getZhangDie() > 0){
                            sb.append("1");
                        } else{
                            sb.append("2");
                        }
                        if (ma5Map.get(code).getZhangDie() > 0){
                            sb.append("1");
                        } else{
                            sb.append("2");
                        }
                        if (ma10Map.get(code).getZhangDie() > 0){
                            sb.append("1");
                        } else{
                            sb.append("2");
                        }
                        if (ma20Map.get(code).getZhangDie() > 0){
                            sb.append("1");
                        } else{
                            sb.append("2");
                        }
                        if (ma30Map.get(code).getZhangDie() > 0){
                            sb.append("1");
                        } else{
                            sb.append("2");
                        }
                        entity.setJunXianZouXiang(Integer.parseInt(sb.toString()));
                        session.update(entity);
                    }
                }
                session.getTransaction().commit();
                session.close();
                HibernateUtil.closeSessionFactory();

                date = DateUtils.addDate(date, 1);
            }
        } catch (Exception e){
            logger.error("执行StokJxplTask任务异常：" + e.getMessage());
            e.printStackTrace();
        }
    }

}
