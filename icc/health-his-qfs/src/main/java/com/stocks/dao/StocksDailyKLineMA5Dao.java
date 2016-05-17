package com.stocks.dao;

import com.stocks.entity.StocksDailyKLineMA5Entity;
import com.stocks.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-4-13
 * Time: 下午10:04
 * To change this template use File | Settings | File Templates.
 */
public class StocksDailyKLineMA5Dao implements IBaseDao {

    public boolean save(StocksDailyKLineMA5Entity entity, Session session){
        try{
            session.save(entity);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public List<StocksDailyKLineMA5Entity> getByDate(Date date){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dt = format.format(date);
            Query query = session.createQuery(" from StocksDailyKLineMA5Entity s where s.date = '" + dt + "'");
            List<StocksDailyKLineMA5Entity> list = query.list();
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

    public List<StocksDailyKLineMA5Entity> getByDate(String date){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            Query query = session.createQuery(" from StocksDailyKLineMA5Entity s where s.date = '" + date + "'");
            List<StocksDailyKLineMA5Entity> list = query.list();
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

    public StocksDailyKLineMA5Entity getByDateAndCode(Date date, String code){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dt = format.format(date);
            Query query = session.createQuery(" from StocksDailyKLineMA5Entity s where s.date = '" + dt + "' and s.code = '" + code + "'");
            List<StocksDailyKLineMA5Entity> list = query.list();
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

    public StocksDailyKLineMA5Entity getByDateAndCode(String date, String code){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            Query query = session.createQuery(" from StocksDailyKLineMA5Entity s where s.date = '" + date + "' and s.code = '" + code + "'");
            List<StocksDailyKLineMA5Entity> list = query.list();
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

    @Override
    public List exports(Date createAt) {
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dt = format.format(createAt);
            Query query = session.createQuery(" from StocksDailyKLineMA5Entity s where s.createTime >= '" + dt + "'");
            List<StocksDailyKLineMA5Entity> list = query.list();
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
            Query query = session.createQuery(" from StocksDailyKLineMA5Entity s where s.createTime >= '" + createAt + "'");
            List<StocksDailyKLineMA5Entity> list = query.list();
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
