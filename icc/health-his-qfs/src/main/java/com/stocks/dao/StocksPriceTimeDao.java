package com.stocks.dao;

import com.stocks.entity.*;
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
 * Date: 16-11-20
 * Time: 下午3:31
 * To change this template use File | Settings | File Templates.
 */
public class StocksPriceTimeDao implements IBaseDao{

    public List<StocksPriceTimeEntity> getByCode(String code){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            if(code==null || code.equals("")) {
                return null;
            }
            Query query = session.createQuery(" from StocksPriceTimeEntity s where s.code = '" + code + "'");
            List<StocksPriceTimeEntity> list = query.list();
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

    public boolean save(StocksPriceTimeEntity StocksPriceTimeEntity, Session session){
        try{
            session.save(StocksPriceTimeEntity);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }



    public boolean update(StocksPriceTimeEntity StocksPriceTimeEntity, Session session){
        try{
            session.update(StocksPriceTimeEntity);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(List<StocksPriceTimeEntity> entitys, Session session){
        try{
            for(StocksPriceTimeEntity entity : entitys){
                session.update(entity);
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }



    public static void main(String[] args){
        Session session = HibernateUtil.getOpenSession();
        StocksPriceDao dao = new StocksPriceDao();

//        List<StocksPriceTimeEntity> list = dao.getByCode("002340");
//        System.out.println(list.size());
//        StocksPriceTimeEntity entity = list.get(0);
//        System.out.println(entity.getShouPan());
//        System.out.println(entity.getStocksEntity());
//        System.out.println(entity.getStocksEntity().getDetailUrl1());
//        System.out.println(entity.getStocksEntity().getCode());
//        HibernateUtil.closeSessionFactory();


//        List<StocksPriceTimeEntity> list = dao.getByDate("2016-03-08");
//        System.out.println(list.size());
//        StocksPriceTimeEntity entity = list.get(0);
//        System.out.println(entity.getShouPan());
//        System.out.println(entity.getStocksEntity());
//        System.out.println(entity.getStocksEntity().getDetailUrl());
//        HibernateUtil.closeSessionFactory();

        dao.getMA5("002340", "2016-04-01", session);






    }


    @Override
    public List exports(Date createAt) {
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dt = format.format(createAt);
            Query query = session.createQuery(" from StocksPriceTimeEntity s where s.createTime >= '" + dt + "'");
            List<StocksPriceTimeEntity> list = query.list();
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
            Query query = session.createQuery(" from StocksPriceTimeEntity s where s.createTime >= '" + createAt + "'");
            List<StocksPriceTimeEntity> list = query.list();
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
