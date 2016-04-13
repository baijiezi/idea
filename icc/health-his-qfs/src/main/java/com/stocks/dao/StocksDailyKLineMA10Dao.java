package com.stocks.dao;

import com.stocks.entity.StocksDailyKLineMA10Entity;
import org.hibernate.Session;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-4-13
 * Time: 下午11:07
 * To change this template use File | Settings | File Templates.
 */
public class StocksDailyKLineMA10Dao {
    public boolean save(StocksDailyKLineMA10Entity entity, Session session){
        try{
            session.save(entity);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
