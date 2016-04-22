package com.stocks.choose;

import com.stocks.dao.StocksDailyKLineMA20Dao;
import com.stocks.dao.StocksPriceDao;
import com.stocks.entity.StocksDailyKLineMA20Entity;
import com.stocks.entity.StocksPriceEntity;
import com.stocks.utils.DateUtils;
import junit.framework.TestCase;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-4-20
 * Time: 上午10:01
 * To change this template use File | Settings | File Templates.
 */
public class IndexChoose extends TestCase {

    public void testT(){
        Date date = DateUtils.strToDate("2016-03-31");
        StocksPriceDao priceDao = new StocksPriceDao();
        List<StocksPriceEntity> list = priceDao.getByDate(date);
        List<StocksPriceEntity> list2 = priceDao.getByDate(DateUtils.strToDate("2016-04-07"));
        Map priceMap = new HashMap<String, StocksPriceEntity>();
        for(StocksPriceEntity entity : list2){
            priceMap.put(entity.getCode(), entity);
        }
        int i=0,j=0,k=0;
        for(StocksPriceEntity entity : list){
            StocksPriceEntity entity1 = (StocksPriceEntity)priceMap.get(entity.getCode());
            if(entity1 == null){
                continue;
            }
            if(entity.getShouPan() < entity1.getShouPan()){
                i++;
            }
            if(entity.getShouPan() > entity1.getShouPan()){
                j++;
            }
            if(entity.getShouPan() == entity1.getShouPan()){
                k++;
            }
        }

        System.out.println("总数：" + list.size());
        System.out.println("总数2：" + list2.size());
        System.out.println("增：" + i);
        System.out.println("减：" + j);
        System.out.println("平：" + k);
    }


    public void testTT(){
        Date date = DateUtils.strToDate("2016-04-07");
        StocksPriceDao priceDao = new StocksPriceDao();
        List<StocksPriceEntity> list = priceDao.getByDate(date);
        StocksDailyKLineMA20Dao ma20Dao = new StocksDailyKLineMA20Dao();
        List<StocksDailyKLineMA20Entity> ma20List = ma20Dao.getByDate(date);
        Map ma20Map = new HashMap<String, StocksPriceEntity>();
        for(StocksDailyKLineMA20Entity entity : ma20List){
            ma20Map.put(entity.getCode(), entity);
        }
        List<StocksPriceEntity> data = new ArrayList<StocksPriceEntity>();
        for(StocksPriceEntity entity : list){
            if(entity.getShiYing()>20000 || entity.getShiYing()<=0){
                continue;
            }
            StocksDailyKLineMA20Entity ma20Entity = (StocksDailyKLineMA20Entity)ma20Map.get(entity.getCode());
            if(ma20Entity.getZhenFu() < 4000){
                continue;
            }
            data.add(entity);
        }
        System.out.println(data.size());
        StringBuffer sb = new StringBuffer();
        for(StocksPriceEntity entity : data){
            sb.append("'"+entity.getCode()+"',");
        }
        System.out.println(sb.substring(0, sb.length()-1));


    }
}
