package com.stocks.dao;

import com.stocks.entity.StocksPriceEntity;
import com.stocks.entity.StocksPriceSimpleEntity;
import com.stocks.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-2-21
 * Time: 下午3:21
 * To change this template use File | Settings | File Templates.
 */
public class StocksPriceSimpleDao implements IBaseDao {

    public List<StocksPriceSimpleEntity> getByCode(String code){
        Session session = HibernateUtil.getOpenSession();
//        session.beginTransaction();
        try{
            if(code==null || code.equals("")) {
                return null;
            }
            Query query = session.createQuery(" from StocksPriceSimpleEntity s where s.code = '" + code + "'");
            List<StocksPriceSimpleEntity> list = query.list();
            if(list!=null && list.size()>0) {
                return list;
            }
            else{
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
//        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
        return null;

    }

    public List<StocksPriceSimpleEntity> getTopByCodeAndDate(String code, String date, Integer limit){
        Session session = HibernateUtil.getOpenSession();
//        session.beginTransaction();
        try{
            if(code==null || code.equals("")) {
                return null;
            }
            Query query = session.createQuery(" from StocksPriceSimpleEntity s where s.code = '" + code + "' and s.date <= '" + date + "' order by s.id desc ");
            query.setMaxResults(limit);
            List<StocksPriceSimpleEntity> list = query.list();
            if(list!=null && list.size()>0) {
                return list;
            }
            else{
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
//        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
        return null;

    }

    public List<StocksPriceSimpleEntity> getByDate(Date date){
        Session session = HibernateUtil.getOpenSession();
//        session.beginTransaction();
        List<StocksPriceSimpleEntity> list = new ArrayList<StocksPriceSimpleEntity>();
        try{
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dt = format.format(date);
            Query query = session.createQuery(" from StocksPriceSimpleEntity s where s.date = '" + dt + "'");
            list = query.list();
            if(list!=null && list.size()>0) {
                return list;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
//        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
        return list;

    }

    public List<StocksPriceSimpleEntity> getByDate(String date){
        Session session = HibernateUtil.getOpenSession();
//        session.beginTransaction();
        try{
            Query query = session.createQuery(" from StocksPriceSimpleEntity s where s.date = '" + date + "'");
            List<StocksPriceSimpleEntity> list = query.list();
            if(list!=null && list.size()>0) {
                return list;
            }
            else{
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
//        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
        return null;

    }

    public StocksPriceSimpleEntity getByDateAndCode(Date date, String code){
        Session session = HibernateUtil.getOpenSession();
//        session.beginTransaction();
        try{
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dt = format.format(date);
            Query query = session.createQuery(" from StocksPriceSimpleEntity s where s.date = '" + dt + "' and s.code = '" + code + "'");
            List<StocksPriceSimpleEntity> list = query.list();
            if(list!=null && list.size()>0) {
                return list.get(0);
            }
            else{
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
//        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
        return null;

    }

    public StocksPriceSimpleEntity getByDateAndCode(Date date, String code, Session session){

        try{
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dt = format.format(date);
            Query query = session.createQuery(" from StocksPriceSimpleEntity s where s.date = '" + dt + "' and s.code = '" + code + "'");
            List<StocksPriceSimpleEntity> list = query.list();
            if(list!=null && list.size()>0) {
                return list.get(0);
            }
            else{
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;

    }

    public StocksPriceSimpleEntity getByDateAndCode(String date, String code){
        Session session = HibernateUtil.getOpenSession();
//        session.beginTransaction();
        try{
            Query query = session.createQuery(" from StocksPriceSimpleEntity s where s.date = '" + date + "' and s.code = '" + code + "'");
            List<StocksPriceSimpleEntity> list = query.list();
            if(list!=null && list.size()>0) {
                return list.get(0);
            }
            else{
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
//        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
        return null;

    }

    public void save(StocksPriceSimpleEntity entity, Session session){
        session.save(entity);
    }

    @Override
    public List exports(Date createAt) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List exports(String createAt) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


    public static void main(String[] args){
        Session session = HibernateUtil.getOpenSession();
        StocksPriceSimpleDao dao = new StocksPriceSimpleDao();
        StocksPriceSimpleEntity entity = new StocksPriceSimpleEntity();
        entity.setCode("111111");
        entity.setName("");
        dao.save(entity, session);


    }
}
