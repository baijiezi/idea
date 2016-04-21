package com.stocks.choose;

import com.stocks.dao.*;
import com.stocks.entity.*;
import com.stocks.utils.DateUtils;
import junit.framework.TestCase;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-4-20
 * Time: 上午10:02
 * To change this template use File | Settings | File Templates.
 */
public class KLineChoose extends TestCase {

    public void testGetTT(){
        Date date = DateUtils.strToDate("2016-03-31");
        StocksPriceDao priceDao = new StocksPriceDao();
        StocksDailyKLineMA5Dao kLineMA5Dao = new StocksDailyKLineMA5Dao();
        StocksDailyKLineMA10Dao kLineMA10Dao = new StocksDailyKLineMA10Dao();
        StocksDailyKLineMA20Dao kLineMA20Dao = new StocksDailyKLineMA20Dao();
        StocksDailyKLineMA30Dao kLineMA30Dao = new StocksDailyKLineMA30Dao();
        List<StocksPriceEntity> data = new ArrayList<StocksPriceEntity>();
        List<StocksPriceEntity> list = priceDao.getByDate(date);

        List<StocksPriceEntity> list2 = priceDao.getByDate(DateUtils.strToDate("2016-04-07"));
        Map priceMap = new HashMap<String, StocksPriceEntity>();
        for(StocksPriceEntity entity : list2){
            priceMap.put(entity.getCode(), entity);
        }

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

//        List<StocksDailyKLineMA30Entity> ma30List = kLineMA30Dao.getByDate(date);
//        Map ma30Map = new HashMap<String, StocksDailyKLineMA30Entity>();
//        for(StocksDailyKLineMA30Entity entity : ma30List){
//            ma30Map.put(entity.getCode(), entity);
//        }
        for(StocksPriceEntity entity : list){
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

            if(entity.getShiYing()>20000 || entity.getShiYing()<0){
                continue;
            }

//            if(entity.getHuanShou() == 0){
//                continue;
//            }

            StocksPriceEntity priceEntity = (StocksPriceEntity)priceMap.get(entity.getCode());
            //过滤减的
            if(priceEntity==null || priceEntity.getShouPan()<entity.getShouPan()){
                continue;
            }

            //过滤增的
//            if(priceEntity!=null && priceEntity.getShouPan()>=entity.getShouPan()){
//                continue;
//            }

            data.add(entity);

        }

        System.out.println(data.size());
        for(StocksPriceEntity entity : data){
            System.out.print("'"+entity.getCode()+"',");
        }
        System.out.println();

    }











}
