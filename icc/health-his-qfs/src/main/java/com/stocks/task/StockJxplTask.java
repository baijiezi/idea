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
 * Date: 16-11-15
 * Time: 下午10:04
 * To change this template use File | Settings | File Templates.
 */
public class StockJxplTask{

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args){

        StockJxplTask stockJxplTask = new StockJxplTask();
        stockJxplTask.execute();

    }

    public void execute(){
        logger.info("StokJxplTask  execute");

        try{
            Date date = new Date();
            Date endDate = DateUtils.strToDate(DateUtils.getSimpleDate(date) + " 23:59:59");
            InetAddress localHost = InetAddress.getLocalHost();
            if(localHost.getHostAddress().equals("192.168.200.27")){
//            if(true){
                date = DateUtils.strToDate("2016-12-12");
                endDate = DateUtils.strToDate("2016-12-14 23:59:59");
            }

            while (date.before(endDate)){
                logger.info("start StokJxplTask, Date = " + DateUtils.getSimpleDate(date));

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

                StocksDailyKLineMA60Dao kLineMA60Dao = new StocksDailyKLineMA60Dao();
                List<StocksDailyKLineMA60Entity> ma60List = kLineMA60Dao.getByDate(date);
                Map<String, StocksDailyKLineMA60Entity> ma60Map = new HashMap<String, StocksDailyKLineMA60Entity>();
                for(StocksDailyKLineMA60Entity entity : ma60List){
                    ma60Map.put(entity.getCode(), entity);
                }


                Session session = HibernateUtil.getOpenSession();
                session.beginTransaction();
                for(StocksPriceEntity entity : priceList){
                    String code = entity.getCode();
                    //更新均线排列
                    if(ma5Map.get(code)!=null && ma10Map.get(code)!=null && ma20Map.get(code)!=null && ma30Map.get(code)!=null && ma60Map.get(code)!=null){
                        int[] a = new int[6];
                        a[0] = entity.getShouPan() * 10 + 1;
                        a[1] = ma5Map.get(code).getShouPan() * 10 + 2;
                        a[2] = ma10Map.get(code).getShouPan() * 10 + 3;
                        a[3] = ma20Map.get(code).getShouPan() * 10 + 4;
                        a[4] = ma30Map.get(code).getShouPan() * 10 + 5;
                        a[5] = ma60Map.get(code).getShouPan() * 10 + 6;
                        selectSort(a);
                        StringBuffer sb = new StringBuffer();
                        for(int i=0; i<a.length; i++){
                            String s = String.valueOf(a[i]);
                            sb.append(s.substring(s.length()-1));
                        }
                        entity.setJunXianPaiLie(Integer.parseInt(sb.toString()));
//                        session.update(entity);
                    }
                    //更新均线走向
                    if(ma5Map.get(code)!=null && ma10Map.get(code)!=null && ma20Map.get(code)!=null && ma30Map.get(code)!=null && ma60Map.get(code)!=null){
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
                        if (ma60Map.get(code).getZhangDie() > 0){
                            sb.append("1");
                        } else{
                            sb.append("2");
                        }
                        entity.setJunXianZouXiang(Integer.parseInt(sb.toString()));
//                        session.update(entity);
                    }
                    //更新成交量均线排列
                    if(entity.getChengJiaoLiang()!=null && ma5Map.get(code)!=null && ma10Map.get(code)!=null && ma20Map.get(code)!=null && ma30Map.get(code)!=null && ma60Map.get(code)!=null){
                        long[] a = new long[6];
                        a[0] = entity.getChengJiaoLiang() * 10 + 1;
                        a[1] = ma5Map.get(code).getChengJiaoLiang() * 10 + 2;
                        a[2] = ma10Map.get(code).getChengJiaoLiang() * 10 + 3;
                        a[3] = ma20Map.get(code).getChengJiaoLiang() * 10 + 4;
                        a[4] = ma30Map.get(code).getChengJiaoLiang() * 10 + 5;
                        a[5] = ma60Map.get(code).getChengJiaoLiang() * 10 + 6;
                        selectSortLong(a);
                        StringBuffer sb = new StringBuffer();
                        for(int i=0; i<a.length; i++){
                            String s = String.valueOf(a[i]);
                            sb.append(s.substring(s.length()-1));
                        }
                        entity.setJunXianPaiLieCJL(Integer.parseInt(sb.toString()));
                    }

                    session.update(entity);
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

    // 选择排序法   将要排序的对象分作两部份，一个是已排序的，一个是未排序的，从后端未排序部份选择一个最小值，并放入前端已排序部份的最后一个。
    public void selectSort(int[] a){
        int position=0;
        for(int i=0;i<a.length;i++){

            int j=i+1;
            position=i;
            int temp=a[i];
            for(;j<a.length;j++){
                if(a[j]>temp){
                    temp=a[j];
                    position=j;
                }
            }
            a[position]=a[i];
            a[i]=temp;
        }
    }

    // 选择排序法   将要排序的对象分作两部份，一个是已排序的，一个是未排序的，从后端未排序部份选择一个最小值，并放入前端已排序部份的最后一个。
    public void selectSortLong(long[] a){
        int position=0;
        for(int i=0;i<a.length;i++){

            int j=i+1;
            position=i;
            long temp=a[i];
            for(;j<a.length;j++){
                if(a[j]>temp){
                    temp=a[j];
                    position=j;
                }
            }
            a[position]=a[i];
            a[i]=temp;
        }
    }
}
