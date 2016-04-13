package com.stocks.dao;

import com.stocks.entity.StocksDailyKLineMA5Entity;
import org.hibernate.Session;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-4-13
 * Time: 下午10:04
 * To change this template use File | Settings | File Templates.
 */
public class StocksDailyKLineMA5Dao {

    public boolean save(StocksDailyKLineMA5Entity entity, Session session){
        try{
            session.save(entity);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }



}
