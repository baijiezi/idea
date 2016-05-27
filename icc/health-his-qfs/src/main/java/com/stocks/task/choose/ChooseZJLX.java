package com.stocks.task.choose;

import com.stocks.dao.*;
import com.stocks.entity.*;
import com.stocks.utils.DateUtils;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-5-27
 * Time: 上午10:31
 * To change this template use File | Settings | File Templates.
 */
public class ChooseZJLX {


    public static void main(String[] args){
        ChooseZJLX chooseZJLX = new ChooseZJLX();
//        chooseZJLX.getT();
        chooseZJLX.getDuoKong();
//        chooseZJLX.getDuoTou();


    }

    public void getT(){
        String startDate = "2016-03-04";
        String endDate = "2016-05-25";
        StocksZjlxDfcfDao dao = new StocksZjlxDfcfDao();
        StocksPriceDao priceDao = new StocksPriceDao();
        List<StocksZjlxDfcfEntity> list = dao.getByChaoDaDanJingBi(startDate, endDate, 50000);
        for(StocksZjlxDfcfEntity entity : list){
            StocksPriceEntity priceEntity = priceDao.getByDateAndCode(entity.getDate(), entity.getCode());
            System.out.println(priceEntity.getCode() + "  " + priceEntity.getDate() + "  " + priceEntity.getPriceTrends());
        }
    }

    public void getDuoKong(){
//        Date date = new Date();
        Date date = DateUtils.strToDate("2016-04-20");
        Date endDate = DateUtils.strToDate("2016-05-20 23:59:59");
        StocksPriceDao priceDao = new StocksPriceDao();
        StocksZjlxDfcfDao dfcfDao = new StocksZjlxDfcfDao();
        List<StocksPriceEntity> data = new ArrayList<StocksPriceEntity>();
        while(date.before(endDate)){
            System.out.println(DateUtils.getSimpleDate(date));
            StocksDailyKLineMA5Dao kLineMA5Dao = new StocksDailyKLineMA5Dao();
            StocksDailyKLineMA10Dao kLineMA10Dao = new StocksDailyKLineMA10Dao();
            StocksDailyKLineMA20Dao kLineMA20Dao = new StocksDailyKLineMA20Dao();
            StocksDailyKLineMA30Dao kLineMA30Dao = new StocksDailyKLineMA30Dao();
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

            List<StocksZjlxDfcfEntity> dfcfList = dfcfDao.getByDate(DateUtils.getSimpleDate(date));
            Map dfcfMap = new HashMap<String, StocksZjlxDfcfEntity>();
            for(StocksZjlxDfcfEntity entity : dfcfList){
                dfcfMap.put(entity.getCode(), entity);
            }


            for(StocksPriceEntity entity : list){
                StocksDailyKLineMA5Entity ma5Entity = (StocksDailyKLineMA5Entity)ma5Map.get(entity.getCode());
                if(ma5Entity!=null && entity.getShouPan()<ma5Entity.getShouPan()){
                    StocksDailyKLineMA10Entity ma10Entity = (StocksDailyKLineMA10Entity)ma10Map.get(entity.getCode());
                    if(ma10Entity!=null && ma5Entity.getShouPan()<ma10Entity.getShouPan()){
                        StocksDailyKLineMA20Entity ma20Entity = (StocksDailyKLineMA20Entity)ma20Map.get(entity.getCode());
                        if(ma20Entity!=null && ma10Entity.getShouPan()<ma20Entity.getShouPan()){
                            StocksDailyKLineMA30Entity ma30Entity = (StocksDailyKLineMA30Entity)ma30Map.get(entity.getCode());
                            if(ma30Entity!=null && ma20Entity.getShouPan()<ma30Entity.getShouPan()){
//                                if(entity.getZhenFu()==null || ma20Entity.getZhenFu()<4000){
//                                    continue;
//                                }
//                                if(entity.getShiYing()==null || entity.getShiYing()>20000 || entity.getShiYing()<=0){
//                                    continue;
//                                }
                                if(entity.getHuanShou()==null || entity.getHuanShou()<=ma5Entity.getHuanShou()){
                                    continue;
                                }
                                StocksZjlxDfcfEntity dfcfEntity = (StocksZjlxDfcfEntity)dfcfMap.get(entity.getCode());
                                if(dfcfEntity==null || dfcfEntity.getChaoDaDanJingBi()<10000){
                                    continue;
                                }
                                data.add(entity);
                            }
                        }
                    }
                }
            }
            date = DateUtils.addDate(date, 1);
        }

        System.out.println(data.size());
        for(StocksPriceEntity entity : data){
            System.out.println(entity.getCode() + "  " + entity.getDate() + "  " + entity.getHuanShou() + "  " + entity.getPriceTrends());
        }
    }


    public void getDuoTou(){
//        Date date = new Date();
        Date date = DateUtils.strToDate("2016-04-20");
        Date endDate = DateUtils.strToDate("2016-05-20 23:59:59");
        List<StocksPriceEntity> data = new ArrayList<StocksPriceEntity>();
        while(date.before(endDate)){
            System.out.println(DateUtils.getSimpleDate(date));
            StocksPriceDao priceDao = new StocksPriceDao();
            StocksDailyKLineMA5Dao kLineMA5Dao = new StocksDailyKLineMA5Dao();
            StocksDailyKLineMA10Dao kLineMA10Dao = new StocksDailyKLineMA10Dao();
            StocksDailyKLineMA20Dao kLineMA20Dao = new StocksDailyKLineMA20Dao();
            StocksDailyKLineMA30Dao kLineMA30Dao = new StocksDailyKLineMA30Dao();
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
                StocksDailyKLineMA5Entity ma5Entity = (StocksDailyKLineMA5Entity)ma5Map.get(entity.getCode());
                if(ma5Entity!=null && entity.getShouPan()>ma5Entity.getShouPan()){
                    StocksDailyKLineMA10Entity ma10Entity = (StocksDailyKLineMA10Entity)ma10Map.get(entity.getCode());
                    if(ma10Entity!=null && ma5Entity.getShouPan()>ma10Entity.getShouPan()){
                        StocksDailyKLineMA20Entity ma20Entity = (StocksDailyKLineMA20Entity)ma20Map.get(entity.getCode());
                        if(ma20Entity!=null && ma10Entity.getShouPan()>ma20Entity.getShouPan()){
                            StocksDailyKLineMA30Entity ma30Entity = (StocksDailyKLineMA30Entity)ma30Map.get(entity.getCode());
                            if(ma30Entity!=null && ma20Entity.getShouPan()>ma30Entity.getShouPan()){
                                if(entity.getZhenFu()==null || ma20Entity.getZhenFu()<4000){
                                    continue;
                                }
                                if(entity.getShiYing()==null || entity.getShiYing()>20000 || entity.getShiYing()<=0){
                                    continue;
                                }
                                data.add(entity);
                            }
                        }
                    }
                }
            }
            date = DateUtils.addDate(date, 1);
        }

        System.out.println(data.size());
        for(StocksPriceEntity entity : data){
            System.out.println(entity.getCode() + "  " + entity.getDate() + "  " + entity.getPriceTrends());
        }
    }
}
