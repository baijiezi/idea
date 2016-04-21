package com.stocks.choose;

import com.stocks.dao.StocksPriceDao;
import com.stocks.entity.StocksPriceEntity;
import com.stocks.utils.DateUtils;
import junit.framework.TestCase;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
