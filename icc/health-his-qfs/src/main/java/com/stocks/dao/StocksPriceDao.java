package com.stocks.dao;

import com.stocks.entity.StocksEntity;
import com.stocks.entity.StocksPriceEntity;
import com.stocks.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-3-3
 * Time: 下午6:54
 * To change this template use File | Settings | File Templates.
 */
public class StocksPriceDao {

    public List<StocksPriceEntity> getByCode(String code, Session session){
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

    public List<StocksPriceEntity> getByDate(Date date, Session session){
        try{
            if(date==null) {
                return null;
            }
            Query query = session.createQuery(" from StocksPriceEntity s where s.date = '2016-03-08'");
            List<StocksPriceEntity> list = query.list();
            System.out.println("list:" + list.size());
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

    public boolean save(StocksPriceEntity stocksDailyEntity, Session session){
        try{
            session.save(stocksDailyEntity);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }



    public boolean update(StocksPriceEntity stocksDailyEntity, Session session){
        try{
            session.update(stocksDailyEntity);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }



    public static void main(String[] args){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        StocksPriceDao dao = new StocksPriceDao();
        List<StocksPriceEntity> list = dao.getByCode("002340", session);
        System.out.println(list.size());
        StocksPriceEntity entity = list.get(0);
        System.out.println(entity.getShouPan());
        System.out.println(entity.getStocksEntity());
        System.out.println(entity.getStocksEntity().getDetailUrl1());
        System.out.println(entity.getStocksEntity().getCode());
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();


//        Session session = HibernateUtil.getOpenSession();
//        session.beginTransaction();
//        StocksPriceDao dao = new StocksPriceDao();
//        List<StocksPriceEntity> list = dao.getByDate(new Date(), session);
//        System.out.println(list.size());
//        StocksPriceEntity entity = list.get(0);
//        System.out.println(entity.getShouPan());
//        System.out.println(entity.getStocksEntity());
//        System.out.println(entity.getStocksEntity().getDetailUrl1());
//        session.getTransaction().commit();
//        session.close();
//        HibernateUtil.closeSessionFactory();






    }







}
