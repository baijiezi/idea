package com.stocks.dao;

import com.stocks.entity.StocksPriceEntity;
import com.stocks.entity.StocksZjlxDfcfEntity;
import com.stocks.utils.DateUtils;
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
 * Date: 16-3-2
 * Time: 下午11:41
 * To change this template use File | Settings | File Templates.
 */
public class StocksZjlxDfcfDao implements IBaseDao {
    public List<StocksZjlxDfcfEntity> getByCode(String code, Session session){
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

    public List<StocksZjlxDfcfEntity> getByZhuLiJingBi(String date, int zhuLiJingBi){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            if(date==null || date.equals("")) {
                return null;
            }
            Query query = session.createQuery(" from StocksZjlxDfcfEntity s where s.date = '" + date + "' and s.zhuLiJingBi > " + zhuLiJingBi);
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
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
        return null;

    }

    public List<StocksZjlxDfcfEntity> getByZhuLiJingBi(Date date, int zhuLiJingBi){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            if(date==null) {
                return null;
            }
            String dt = DateUtils.getSimpleDate(date);
            Query query = session.createQuery(" from StocksZjlxDfcfEntity s where s.date = '" + dt + "' and s.zhuLiJingBi >= " + zhuLiJingBi);
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
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
        return null;

    }

    public List<StocksZjlxDfcfEntity> getByChaoDaDanJingBi(String date, int zhuLiJingBi){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            if(date==null || date.equals("")) {
                return null;
            }
            Query query = session.createQuery(" from StocksZjlxDfcfEntity s where s.date = '" + date + "' and s.chaoDaDanJingBi > " + zhuLiJingBi);
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
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
        return null;

    }

    public List<StocksZjlxDfcfEntity> getByChaoDaDanJingBi(Date date, int zhuLiJingBi){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            if(date==null) {
                return null;
            }
            String dt = DateUtils.getSimpleDate(date);
            Query query = session.createQuery(" from StocksZjlxDfcfEntity s where s.date = '" + dt + "' and s.chaoDaDanJingBi >= " + zhuLiJingBi);
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
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
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

    @Override
    public List exports(Date createAt) {
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dt = format.format(createAt);
            Query query = session.createQuery(" from StocksZjlxDfcfEntity s where s.createAt >= '" + dt + "'");
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
            Query query = session.createQuery(" from StocksZjlxDfcfEntity s where s.createAt >= '" + createAt + "'");
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
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
        return null;
    }

}
