package com.stocks.dao;

import com.stocks.entity.StocksZjlxDfcfEntity;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-2
 * Time: 下午11:41
 * To change this template use File | Settings | File Templates.
 */
public class StocksZjlxDfcfDao {
    public List<StocksZjlxDfcfEntity> queryByCode(String code, Session session){
        try{
            if(code==null || code.equals("")) {
                return null;
            }
            Query query = session.createQuery(" from StocksZjlxDfcfEntity s where s.code = '" + code + "'");
            List<StocksZjlxDfcfEntity> list = query.list();
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

    public boolean save(StocksZjlxDfcfEntity entity, Session session){
        try{
            session.save(entity);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;

    }



    public void update(StocksZjlxDfcfEntity entity, Session session){
        try{
            session.update(entity);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}