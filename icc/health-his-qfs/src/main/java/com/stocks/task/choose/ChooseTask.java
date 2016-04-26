package com.stocks.task.choose;

import com.stocks.dao.*;
import com.stocks.entity.*;
import com.stocks.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-4-26
 * Time: 下午3:16
 * To change this template use File | Settings | File Templates.
 */
public class ChooseTask {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args){
        ChooseTask chooseTask = new ChooseTask();
        chooseTask.execute();

    }

    public void execute(){
        logger.info("ChooseTask  execute");
        getT();

    }



     public void getT(){
         StocksZjlxDfcfDao dao = new StocksZjlxDfcfDao();
         List<StocksZjlxDfcfEntity> list = dao.getByZhuLiJingBi("2016-04-06", 50000);
         if(list!=null && list.size()>0){
             //发送通知
             System.out.println(list.size());
         }




     }












    public void getTT(){
        Date date = DateUtils.strToDate("2016-04-20");
        StocksPriceDao priceDao = new StocksPriceDao();
        StocksDailyKLineMA5Dao kLineMA5Dao = new StocksDailyKLineMA5Dao();
        StocksDailyKLineMA10Dao kLineMA10Dao = new StocksDailyKLineMA10Dao();
        StocksDailyKLineMA20Dao kLineMA20Dao = new StocksDailyKLineMA20Dao();
        StocksDailyKLineMA30Dao kLineMA30Dao = new StocksDailyKLineMA30Dao();
        List<StocksPriceEntity> data = new ArrayList<StocksPriceEntity>();
        List<StocksPriceEntity> list = priceDao.getByDate(date);

        List<StocksDailyKLineMA5Entity> ma5List = kLineMA5Dao.getByDate(date);
        Map ma5Map = new HashMap<String, StocksDailyKLineMA5Entity>();
        for(StocksDailyKLineMA5Entity entity : ma5List){
            ma5Map.put(entity.getCode(), entity);
        }

        List<StocksDailyKLineMA10Entity> ma10List = kLineMA10Dao.getByDate(date);
        Map ma10Map = new HashMap<String, StocksDailyKLineMA10Entity>();
        for(StocksDailyKLineMA10Entity entity : ma10List){
            ma10Map.put(entity.getCode(), entity);
        }

        List<StocksDailyKLineMA20Entity> ma20List = kLineMA20Dao.getByDate(date);
        Map ma20Map = new HashMap<String, StocksDailyKLineMA20Entity>();
        for(StocksDailyKLineMA20Entity entity : ma20List){
            ma20Map.put(entity.getCode(), entity);
        }

        List<StocksDailyKLineMA30Entity> ma30List = kLineMA30Dao.getByDate(date);
        Map ma30Map = new HashMap<String, StocksDailyKLineMA30Entity>();
        for(StocksDailyKLineMA30Entity entity : ma30List){
            ma30Map.put(entity.getCode(), entity);
        }

        for(StocksPriceEntity entity : list){
            if(entity.getCode().equals("002424")){
                System.out.print("");
            }
            StocksDailyKLineMA5Entity ma5Entity = (StocksDailyKLineMA5Entity)ma5Map.get(entity.getCode());
            if(ma5Entity==null || entity.getShouPan()>ma5Entity.getShouPan()){
                continue;
            }
            StocksDailyKLineMA10Entity ma10Entity = (StocksDailyKLineMA10Entity)ma10Map.get(entity.getCode());
            if(ma10Entity==null || entity.getShouPan()>ma10Entity.getShouPan()){
                continue;
            }
            StocksDailyKLineMA20Entity ma20Entity = (StocksDailyKLineMA20Entity)ma20Map.get(entity.getCode());
            if(ma20Entity==null || entity.getShouPan()>ma20Entity.getShouPan()){
                continue;
            }
            StocksDailyKLineMA30Entity ma30Entity = (StocksDailyKLineMA30Entity)ma30Map.get(entity.getCode());
            if(ma30Entity==null || entity.getShouPan()>ma30Entity.getShouPan()){
                continue;
            }

            if(entity.getZhenFu()==null || ma20Entity.getZhenFu()<4000){
                continue;
            }

            if(entity.getShiYing()==null || entity.getShiYing()>20000 || entity.getShiYing()<=0){
                continue;
            }

            data.add(entity);

        }

        System.out.println(data.size());
        StringBuffer sb = new StringBuffer(" ");
        for(StocksPriceEntity entity : data){
            sb.append("'"+entity.getCode()+"',");
        }
        System.out.println(sb.substring(0, sb.length()-1));

    }



}