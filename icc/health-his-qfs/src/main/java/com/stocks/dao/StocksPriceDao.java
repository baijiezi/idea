package com.stocks.dao;

import com.stocks.entity.StocksPriceEntity;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-3-3
 * Time: 下午6:54
 * To change this template use File | Settings | File Templates.
 */
public class StocksPriceDao {

    public List<StocksPriceEntity> queryByCode(String code, Session session){
        try{
            if(code==null || code.equals("")) {
                return null;
            }
            Query query = session.createQuery(" from StocksPriceEntity s where s.code = '" + code + "'");
            List<StocksPriceEntity> list = query.list();
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

    public void save(StocksPriceEntity stocksDailyEntity, Session session){
        try{
            session.save(stocksDailyEntity);
        }catch(Exception e){
            e.printStackTrace();
        }

    }



    public void update(StocksPriceEntity stocksDailyEntity, Session session){
        try{
            session.update(stocksDailyEntity);
        }catch(Exception e){
            e.printStackTrace();
        }

    }


}
