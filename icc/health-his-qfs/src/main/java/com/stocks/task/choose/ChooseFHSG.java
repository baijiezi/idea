package com.stocks.task.choose;

import com.stocks.dao.StocksFhsgDao;
import com.stocks.dao.StocksPriceDao;
import com.stocks.entity.StocksFhsgEntity;
import com.stocks.entity.StocksPriceEntity;
import com.stocks.utils.DateUtils;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-5-30
 * Time: 上午9:31
 * To change this template use File | Settings | File Templates.
 */
public class ChooseFHSG {
    public static void main(String[] args){
        ChooseFHSG chooseFHSG = new ChooseFHSG();
        chooseFHSG.shouYiLvAndChuQuanRi2();


    }


    public void shouYiLvAndChuQuanRi(){
        StocksFhsgDao fhsgDao = new StocksFhsgDao();
        StocksPriceDao priceDao = new StocksPriceDao();
        String chuQuanRi = "2016-01-01";
        Integer shouYiLv = 2000;
        List<StocksFhsgEntity> list = fhsgDao.getByShouYiLvAndChuQuanRi(chuQuanRi, shouYiLv);
        System.out.println(list.size());
        for(StocksFhsgEntity entity : list){
            StocksPriceEntity priceEntity = priceDao.getByDateAndCode(entity.getChuQuanRi(), entity.getCode());
            if(priceEntity != null){
                System.out.println(priceEntity.getCode() + "  " + priceEntity.getDate() + "  " + priceEntity.getPriceTrends());
            }

        }
    }

    //  26/46=56%
    public void shouYiLvAndChuQuanRi2(){
        StocksFhsgDao fhsgDao = new StocksFhsgDao();
        StocksPriceDao priceDao = new StocksPriceDao();
        String chuQuanRi = "2016-01-01";
        Integer shouYiLv = 2000;
        List<StocksFhsgEntity> list = fhsgDao.getByShouYiLvAndChuQuanRi(chuQuanRi, shouYiLv);
        System.out.println(list.size());
        for(StocksFhsgEntity entity : list){
            //提前两周
            StocksPriceEntity priceEntity = priceDao.getByDateAndCode(DateUtils.addDate(entity.getChuQuanRi(), -14), entity.getCode());
            if(priceEntity != null){
                System.out.println(priceEntity.getCode() + "  " + priceEntity.getDate() + "  " + priceEntity.getPriceTrends());
            }

        }
    }

    public void shouYiLvAndGongGaoRi(){
        StocksFhsgDao fhsgDao = new StocksFhsgDao();
        StocksPriceDao priceDao = new StocksPriceDao();
        String gongGaoRi = "2016-01-01";
        Integer shouYiLv = 4000;
        List<StocksFhsgEntity> list = fhsgDao.getByShouYiLvAndGongGaoRi(gongGaoRi, shouYiLv);
        System.out.println(list.size());
        for(StocksFhsgEntity entity : list){
            StocksPriceEntity priceEntity = priceDao.getByDateAndCode(entity.getGongGaoRi(), entity.getCode());
            if(priceEntity != null){
                System.out.println(priceEntity.getCode() + "  " + priceEntity.getDate() + "  " + priceEntity.getPriceTrends());
            }

        }
    }

    public void songGuAndChuQuanRi(){
        StocksFhsgDao fhsgDao = new StocksFhsgDao();
        StocksPriceDao priceDao = new StocksPriceDao();
        String chuQuanRi = "2016-01-01";
        Integer songGu = 10;
        List<StocksFhsgEntity> list = fhsgDao.getBySongGuAndChuQuanRi(chuQuanRi, songGu);
        System.out.println(list.size());
        for(StocksFhsgEntity entity : list){
            StocksPriceEntity priceEntity = priceDao.getByDateAndCode(entity.getChuQuanRi(), entity.getCode());
            if(priceEntity != null){
                System.out.println(priceEntity.getCode() + "  " + priceEntity.getDate() + "  " + priceEntity.getPriceTrends());
            }

        }
    }

    public void songGuAndChuQuanRi2(){
        StocksFhsgDao fhsgDao = new StocksFhsgDao();
        StocksPriceDao priceDao = new StocksPriceDao();
        String chuQuanRi = "2016-01-01";
        Integer songGu = 10;
        List<StocksFhsgEntity> list = fhsgDao.getBySongGuAndChuQuanRi(chuQuanRi, songGu);
        System.out.println(list.size());
        for(StocksFhsgEntity entity : list){
            //提前两周
            StocksPriceEntity priceEntity = priceDao.getByDateAndCode(DateUtils.addDate(entity.getChuQuanRi(), -21), entity.getCode());
            if(priceEntity != null){
                System.out.println(priceEntity.getCode() + "  " + priceEntity.getDate() + "  " + priceEntity.getPriceTrends());
            }

        }
    }
}
