package com.stocks.dao;

import com.stocks.entity.StocksZJLXEntity;
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
public class StocksZJLXDao {
    public List<StocksZJLXEntity> queryByCode(String code, Session session){
        try{
            if(code==null || code.equals("")) {
                return null;
            }
            Query query = session.createQuery(" from StocksZJLXEntity s where s.code = '" + code + "'");
            List<StocksZJLXEntity> list = query.list();
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

    public void save(StocksZJLXEntity entity, Session session){
        try{
            session.save(entity);
        }catch(Exception e){
            e.printStackTrace();
        }

    }



    public void update(StocksZJLXEntity entity, Session session){
        try{
            session.update(entity);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
