package com.stocks.dao;

import com.stocks.entity.StocksEntity;
import com.stocks.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-21
 * Time: 上午11:42
 * To change this template use File | Settings | File Templates.
 */
public class StocksDao implements IBaseDao {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public List<StocksEntity> getAll(){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();

        try{
            Query query = session.createQuery(" from StocksEntity s where s.status = 0");
            List<StocksEntity> list = query.list();
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

    public List<StocksEntity> getBuySalePrice(){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();

        try{
            Query query = session.createQuery(" from StocksEntity s where s.buyPrice > 0 or s.salePrice > 0");
            List<StocksEntity> list = query.list();
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

    public StocksEntity getByCode(String code){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            if(code==null || code.equals("")) {
                return null;
            }
            Query query = session.createQuery(" from StocksEntity s where s.code = '" + code + "'");
            List<StocksEntity> list = query.list();
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

    public StocksEntity getByCode(String code, Session session){
        try{
            if(code==null || code.equals("")) {
                return null;
            }
            Query query = session.createQuery(" from StocksEntity s where s.code = '" + code + "'");
            List<StocksEntity> list = query.list();
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

    public void save(StocksEntity entity, Session session){
        try{
            session.save(entity);
        }catch(Exception e){
            e.printStackTrace();
        }

    }



    public void update(StocksEntity entity, Session session){
        try{
            session.update(entity);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args){
        StocksDao dao = new StocksDao();
        List<StocksEntity> list = dao.getAll();
        System.out.println(list.size());
        for(StocksEntity entity : list){
            String exchange = entity.getExchange() == null ? "" : entity.getExchange();
            Integer buyPrice = entity.getBuyPrice() == null ? 0 : entity.getBuyPrice();
            Integer salePrice = entity.getSalePrice() == null ? 0 : entity.getSalePrice();
            System.out.print(entity.getCode() + "," + exchange + "," + buyPrice + "," + salePrice);
            System.out.println();
        }
    }

    @Override
    public List exports(Date createAt) {
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dt = format.format(createAt);
            Query query = session.createQuery(" from StocksEntity s where s.createAt >= '" + dt + "'");
            List<StocksEntity> list = query.list();
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
            Query query = session.createQuery(" from StocksEntity s where s.createAt >= '" + createAt + "'");
            List<StocksEntity> list = query.list();
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
