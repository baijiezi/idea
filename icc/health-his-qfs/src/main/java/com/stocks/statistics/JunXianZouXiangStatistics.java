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
 * User: BaiJiezi
 * Date: 16-11-18
 * Time: 上午10:57
 * To change this template use File | Settings | File Templates.
 */
public class JunXianZouXiangStatistics {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args){

        JunXianZouXiangStatistics junXianZouXiangStatistics = new JunXianZouXiangStatistics();
        junXianZouXiangStatistics.execute();
    }

    public void execute(){
        logger.info("JunXianZouXiangStatistics  execute");

        try{
            Date date = DateUtils.strToDate("2016-11-14");
            Date endDate = DateUtils.strToDate("2017-02-16 23:59:59");

            Map<Integer, Integer> zhangFuMap = new HashMap<Integer, Integer>();
            Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
            Map<Integer, Integer> biLvMap = new HashMap<Integer, Integer>();
            while (date.before(endDate)){
                logger.info("start PriceTrendsTask, Date = " + DateUtils.getSimpleDate(date));
                StocksPriceDao priceDao = new StocksPriceDao();
                List<StocksPriceEntity> priceList = priceDao.getByDate(date);
                for(StocksPriceEntity entity : priceList){
                    if(!entity.getCode().startsWith("600") && !entity.getCode().startsWith("601")){
                        continue;
                    }
                    if(entity.getChengJiaoLiang()==null || entity.getChengJiaoLiang()<=0 || entity.getLiuTongShiZhi()==null || entity.getLiuTongShiZhi() <= 0 ){
                        continue;
                    }
                    Integer key = entity.getJunXianZouXiang();
                    Integer zhangFu = 0;
                    String trends = entity.getPriceTrends();
                    String[] trendsArray = trends.split(",");
                    if(trendsArray.length >=10){
                        zhangFu = Integer.parseInt(trendsArray[0]);
                    }
                    if(zhangFuMap.get(key) != null){
                        zhangFu = zhangFuMap.get(key) + zhangFu;
                    }
                    zhangFuMap.put(key, zhangFu);

                    Integer count = 1;
                    if(countMap.get(key) != null){
                        count = countMap.get(key) +1;
                    }
                    countMap.put(key, count);
                }
                date = DateUtils.addDate(date, 1);
            }

            for(Map.Entry<Integer, Integer> entry  : zhangFuMap.entrySet()){
                biLvMap.put(entry.getKey(), NumberUtils.getBiLv(entry.getValue(), countMap.get(entry.getKey())));
            }

            Map<Integer, Integer> sortedMap = sortMapByValue(biLvMap);

            for(Map.Entry<Integer, Integer> entry  : sortedMap.entrySet()){
                logger.info(entry.getKey()+" ---> " + entry.getValue() + " " + countMap.get(entry.getKey()));
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
