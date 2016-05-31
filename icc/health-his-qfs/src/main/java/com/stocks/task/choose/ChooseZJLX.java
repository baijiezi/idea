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

}
