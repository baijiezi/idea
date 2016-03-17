package com.stocks.statistics;

import com.stocks.dao.StocksPriceDao;
import com.stocks.entity.StocksPriceEntity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-3-17
 * Time: 上午11:58
 * To change this template use File | Settings | File Templates.
 */
public class IndexStatistics {
    public static void main(String[] args){
        try{
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse("2016-03-10");
            StocksPriceDao dao  = new StocksPriceDao();
            List<StocksPriceEntity> list = dao.getByDate(date);
            date.setDate(date.getDate()+1);
            int total=0, rise=0, desc=0;
            for(StocksPriceEntity entity : list){
                if(entity.getZhangFu()>-6000){
                    continue;
                }
                StocksPriceEntity entity1 = dao.getByDateAndCode(date, entity.getCode());
                if(entity1==null){
                    continue;
                }
                if(entity1.getZhangFu()>0){
                    rise++;
                }
                else if(entity1.getZhangFu()<0){
                    desc++;
                }
                total++;
            }
            System.out.println("total:" + total);
            System.out.println("rise:" + rise);
            System.out.println("desc:" + desc);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
