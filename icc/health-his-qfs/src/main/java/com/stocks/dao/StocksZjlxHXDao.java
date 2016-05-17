package com.stocks.dao;

import com.stocks.entity.StocksZjlxHXEntity;
import com.stocks.entity.StocksZjlxHXEntity;
import com.stocks.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-14
 * Time: 下午10:02
 * To change this template use File | Settings | File Templates.
 */
public class StocksZjlxHXDao implements IBaseDao {
    public List<StocksZjlxHXEntity> queryByCode(String code, Session session){
        try{
            if(code==null || code.equals("")) {
                return null;
            }
            Query query = session.createQuery(" from StocksZjlxHXEntity s where s.code = '" + code + "'");
            List<StocksZjlxHXEntity> list = query.list();
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

    public boolean save(StocksZjlxHXEntity entity, Session session){
        try{
            session.save(entity);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;

    }



    public void update(StocksZjlxHXEntity entity, Session session){
        try{
            session.update(entity);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public List exports(Date createAt) {
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dt = format.format(createAt);
            Query query = session.createQuery(" from StocksZjlxHXEntity s where s.createAt >= '" + dt + "'");
            List<StocksZjlxHXEntity> list = query.list();
            if(list!=null && list.size()>0) {
                return list;
            }
            else{
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
        return null;
    }

    @Override
    public List exports(String createAt) {
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            Query query = session.createQuery(" from StocksZjlxHXEntity s where s.createAt >= '" + createAt + "'");
            List<StocksZjlxHXEntity> list = query.list();
            if(list!=null && list.size()>0) {
                return list;
            }
            else{
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
        return null;
    }
}
