package com.stocks.dao;

import com.stocks.entity.StocksDailyKLineMA20Entity;
import org.hibernate.Session;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-4-15
 * Time: 上午10:20
 * To change this template use File | Settings | File Templates.
 */
public class StocksDailyKLineMA20Dao {
    public boolean save(StocksDailyKLineMA20Entity entity, Session session){
        try{
            session.save(entity);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
