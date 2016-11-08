package com.stocks.task.choose;

import com.stocks.dao.*;
import com.stocks.entity.*;
import com.stocks.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.InetAddress;
import java.util.*;

/**
 * Created by sunshine-health-his on 2016/11/7.
 */
public class ChooseJXPL {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args){

        ChooseJXPL chooseJXPL = new ChooseJXPL();
        chooseJXPL.execute();
    }

    public void execute(){
        logger.info("ChooseJXPL  execute");

        try{
            Date date = new Date();
            Date endDate = DateUtils.strToDate(DateUtils.getSimpleDate(date) + " 23:59:59");
            InetAddress localHost = InetAddress.getLocalHost();
            if(localHost.getHostAddress().equals("192.168.200.27")){
                date = DateUtils.strToDate("2016-04-14");
                endDate = DateUtils.strToDate("2016-04-14 23:59:59");
            }

            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            while (date.before(endDate)){
                logger.info("start PriceTrendsTask, Date = " + DateUtils.getSimpleDate(date));
                StocksPriceDao priceDao = new StocksPriceDao();
                List<StocksPriceEntity> priceList = priceDao.getByDate(date);
                for(StocksPriceEntity entity : priceList){
                    Integer zhangDie = entity.getZhangDie();
                    if(map.get(entity.getJunXianPaiLie()) != null){
                        zhangDie = zhangDie + map.get(entity.getJunXianPaiLie());
                    }
                    map.put(entity.getJunXianPaiLie(), zhangDie);
                }
                date = DateUtils.addDate(date, 1);
            }

            for(Map.Entry<Integer, Integer> entry  :map.entrySet()){
                System.out.println(entry.getKey()+"--->"+entry.getValue());
            }

        } catch (Exception e){
            logger.error("执行ChooseJXPL任务异常：" + e.getMessage());
            e.printStackTrace();
        }
    }

}
