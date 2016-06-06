package com.stocks.task.choose;

import com.stocks.dao.StocksPriceDao;
import com.stocks.entity.StocksPriceEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-5-27
 * Time: 上午10:32
 * To change this template use File | Settings | File Templates.
 */
public class ChooseIndex {

    public static void main(String[] args){
        ChooseIndex chooseIndex = new ChooseIndex();
        chooseIndex.niZhang();

    }

    public String niZhang(){
        StocksPriceDao dao = new StocksPriceDao();
        List<StocksPriceEntity> list = dao.getByCode("000001_2");
        for(StocksPriceEntity entity : list){
            if(entity.getZhangFu()!=null && entity.getZhangFu()<-2000){
                List<StocksPriceEntity> data = dao.getByDate(entity.getDate());
                for(StocksPriceEntity priceEntity : data){
                    if(priceEntity.getZhangFu()>=5000 && priceEntity.getCode().startsWith("600")){
                        System.out.println(priceEntity.getCode() + "  " + priceEntity.getDate() + "  " + priceEntity.getPriceTrends());
                    }
                }
            }
        }
        return null;


    }

}
