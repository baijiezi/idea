package com.stocks.dao;

import com.stocks.entity.StocksDailyEntity;
import com.stocks.entity.StocksEntity;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-2-23
 * Time: 下午4:53
 * To change this template use File | Settings | File Templates.
 */
public class StocksDailyDao {


    public List<StocksDailyEntity> queryByCode(String code, Session session){
        try{
            if(code==null || code.equals("")) {
                return null;
            }
            Query query = session.createQuery(" from StocksDailyEntity s where s.code = '" + code + "'");
            List<StocksDailyEntity> list = query.list();
            if(list!=null && list.size()>0) {
                return list;
            }
            else{
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;

    }

    public void save(StocksDailyEntity stocksDailyEntity, Session session){
        try{
            session.save(stocksDailyEntity);
        }catch(Exception e){
            e.printStackTrace();
        }

    }



    public void update(StocksDailyEntity stocksDailyEntity, Session session){
        try{
            session.update(stocksDailyEntity);
        }catch(Exception e){
            e.printStackTrace();
        }

    }




}
