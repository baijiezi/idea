package com.stocks.statistics;

import com.stocks.dao.StocksPriceDao;
import com.stocks.entity.StocksPriceEntity;
import com.stocks.utils.DateUtils;
import com.stocks.utils.MapValueComparator;
import com.stocks.utils.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-11-19
 * Time: 下午11:33
 * To change this template use File | Settings | File Templates.
 */
public class WeeklyStatistics {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args){

        WeeklyStatistics statistics = new WeeklyStatistics();
        statistics.execute();
    }

    public void execute(){
        logger.info("ChooseJXPL  execute");

        try{
            Map<Integer, Integer> shouPanMap = new HashMap<Integer, Integer>();
            Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
            StocksPriceDao priceDao = new StocksPriceDao();
            List<StocksPriceEntity> priceList = priceDao.getByCode("399001");     //399001         000001_2
            for(StocksPriceEntity entity : priceList){
                Integer key =  entity.getDate().getDay();

                Integer shouPan = entity.getShouPan();
                if(shouPanMap.get(key) != null){
                    shouPan = shouPanMap.get(key) + shouPan;
                }
                shouPanMap.put(key, shouPan);

                Integer count = 1;
                if(countMap.get(key) != null){
                    count = countMap.get(key) +1;
                }
                countMap.put(key, count);
            }

            for(Map.Entry<Integer, Integer> entry  : shouPanMap.entrySet()){
                int sp = entry.getValue() / countMap.get(entry.getKey());
               System.out.println(entry.getKey() + "--->" + sp + "    " + countMap.get(entry.getKey()));
            }

        } catch (Exception e){
            logger.error("执行ChooseJXPL任务异常：" + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 使用 Map按value进行排序
     * @param
     * @return
     */
    public static Map<Integer, Integer> sortMapByValue(Map<Integer, Integer> oriMap) {
        if (oriMap == null || oriMap.isEmpty()) {
            return null;
        }
        Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<Map.Entry<Integer, Integer>>(
                oriMap.entrySet());
        Collections.sort(entryList, new MapValueComparator());

        Iterator<Map.Entry<Integer, Integer>> iter = entryList.iterator();
        Map.Entry<Integer, Integer> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        return sortedMap;
    }

}
