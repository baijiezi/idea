package com.stocks.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-3-18
 * Time: 下午2:43
 * To change this template use File | Settings | File Templates.
 */
public class StockShouYiTask {


    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args){
        StockShouYiTask stockShouYiTask = new StockShouYiTask();
        stockShouYiTask.execute();

    }

    public void execute(){
        logger.info("StockPriceTask  execute");
    }
}
