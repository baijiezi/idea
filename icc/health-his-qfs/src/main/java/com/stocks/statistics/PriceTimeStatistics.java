package com.stocks.statistics;

import com.stocks.dao.StocksPriceDao;
import com.stocks.dao.StocksPriceTimeDao;
import com.stocks.entity.StocksPriceTimeEntity;
import com.stocks.entity.StocksPriceTimeEntity;
import com.stocks.utils.DateUtils;
import com.stocks.utils.MapValueComparator;
import com.stocks.utils.MapValueComparator2;
import com.stocks.utils.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-2-19
 * Time: 下午5:17
 * To change this template use File | Settings | File Templates.
 */
public class PriceTimeStatistics {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args){

        PriceTimeStatistics statistics = new PriceTimeStatistics();
        statistics.execute();
    }

    public void execute(){
        logger.info("PriceTimeStatistics  execute");

        try{
            Date date = DateUtils.strToDate("2016-11-21");
            Date endDate = new Date();
            Map<String, Integer> map = new HashMap<String, Integer>();
            Map<String, Integer> countMap = new HashMap<String, Integer>();
            Map<String, Integer> biLvMap = new HashMap<String, Integer>();
            while (date.before(endDate)){
                logger.info("start PriceTimeStatistics, Date = " + DateUtils.getSimpleDate(date));
                StocksPriceTimeDao priceDao = new StocksPriceTimeDao();
                List<StocksPriceTimeEntity> list = priceDao.getByCodeAndDate("000001_2", DateUtils.getSimpleDate(date));
                logger.info("" + list.size());
                for(StocksPriceTimeEntity entity : list){
                    String key = DateUtils.getStrTime(entity.getCreateTime()).substring(11,16);
                    if(map.get(key) != null){
                        map.put(key, map.get(key)+entity.getPrice()/1000);
                        countMap.put(key, countMap.get(key)+1);
                    }
                    else{
                        map.put(key, entity.getPrice()/1000);
                        countMap.put(key, 1);
                    }
                }
                date = DateUtils.addDate(date, 1);
            }

            for(Map.Entry<String, Integer> entry  : map.entrySet()){
                biLvMap.put(entry.getKey(), NumberUtils.getBiLv(entry.getValue(), countMap.get(entry.getKey())));
            }

            Map<String, Integer> sortedMap = sortMapByValue(biLvMap);

            for(Map.Entry<String, Integer> entry  : sortedMap.entrySet()){
                logger.info(entry.getKey()+" ---> " + entry.getValue() + " " + countMap.get(entry.getKey()));
            }

        } catch (Exception e){
            logger.error("执行PriceTimeStatistics任务异常：" + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 使用 Map按value进行排序
     * @param
     * @return
     */
    public static Map<String, Integer> sortMapByValue(Map<String, Integer> oriMap) {
        if (oriMap == null || oriMap.isEmpty()) {
            return null;
        }
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(
                oriMap.entrySet());
        Collections.sort(entryList, new MapValueComparator2());

        Iterator<Map.Entry<String, Integer>> iter = entryList.iterator();
        Map.Entry<String, Integer> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        return sortedMap;
    }

}
