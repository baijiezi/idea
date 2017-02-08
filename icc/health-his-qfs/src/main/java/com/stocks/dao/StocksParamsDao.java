package com.stocks.dao;

import com.stocks.entity.StocksParamsEntity;
import com.stocks.entity.StocksParamsEntity;
import com.stocks.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-1-30
 * Time: 上午11:58
 * To change this template use File | Settings | File Templates.
 */
public class StocksParamsDao {

    public StocksParamsEntity getByParam(String param){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            Query query = session.createQuery(" from StocksParamsEntity s where s.param = '" + param + "'");
            List<StocksParamsEntity> list = query.list();
            if(list!=null && list.size()>0) {
                return list.get(0);
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
    
    public void save(StocksParamsEntity entity, Session session){
        try{
            session.save(entity);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void save(StocksParamsEntity entity){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            session.save(entity);
        }catch(Exception e){
            e.printStackTrace();
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }

    public void update(StocksParamsEntity entity){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            session.update(entity);
        }catch(Exception e){
            e.printStackTrace();
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }

    public void update(StocksParamsEntity entity, Session session){
        try{
            session.update(entity);
        }catch(Exception e){
            e.printStackTrace();
        }
    }



    public static void main(String[] args){
        StocksParamsDao dao = new StocksParamsDao();
        StocksParamsEntity entity = dao.getByParam("priceTrends");
        System.out.println(entity.getValue());
        entity.setValue("2016-12-30");
        dao.update(entity);

//        Session session = HibernateUtil.getOpenSession();
//        session.beginTransaction();
//        StocksParamsEntity entity = new StocksParamsEntity();
//        StocksParamsDao dao = new StocksParamsDao();
//        entity.setParam("666");
//        entity.setValue("v");
//        dao.save(entity, session);
//        session.getTransaction().commit();
//        session.close();
//        HibernateUtil.closeSessionFactory();
    }
}
