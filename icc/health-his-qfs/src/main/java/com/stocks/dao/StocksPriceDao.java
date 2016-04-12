package com.stocks.dao;

import com.stocks.entity.StocksEntity;
import com.stocks.entity.StocksPriceEntity;
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
 * Date: 16-3-3
 * Time: 下午6:54
 * To change this template use File | Settings | File Templates.
 */
public class StocksPriceDao {

    public List<StocksPriceEntity> getByCode(String code){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
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
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
        return null;

    }

    public List<StocksPriceEntity> getByDate(Date date){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dt = format.format(date);
            Query query = session.createQuery(" from StocksPriceEntity s where s.date = '" + dt + "'");
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

    public List<StocksPriceEntity> getByDate(String date){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            Query query = session.createQuery(" from StocksPriceEntity s where s.date = '" + date + "'");
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

    public StocksPriceEntity getByDateAndCode(Date date, String code){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dt = format.format(date);
            Query query = session.createQuery(" from StocksPriceEntity s where s.date = '" + dt + "' and s.code = '" + code + "'");
            List<StocksPriceEntity> list = query.list();
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

    public StocksPriceEntity getByDateAndCode(String date, String code){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            Query query = session.createQuery(" from StocksPriceEntity s where s.date = '" + date + "' and s.code = '" + code + "'");
            List<StocksPriceEntity> list = query.list();
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


    //SELECT AVG(shouPan) FROM (SELECT * FROM sic_stocks_price p where p.`code`='002340' ORDER BY p.date DESC LIMIT 5) as A
    public StocksPriceEntity getMA5(String code){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            Query query = session.createSQLQuery("SELECT code, name, date, AVG(shouPan), AVG(junJia), AVG(zhangFu), AVG(zhangDie), AVG(chengJiaoLiang), AVG(ChengJiaoE), AVG(huanShou),AVG(liangBi),MAX(zuiGao)," +
                    "MIN(zuiDi), AVG(zhenFu), AVG(weiBi), AVG(weiCha) FROM (SELECT * FROM sic_stocks_price p where p.`code`='002340' ORDER BY p.date DESC LIMIT 5) as A");
            List<StocksPriceEntity> list = query.list();
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

    public boolean update(List<StocksPriceEntity> entitys, Session session){
        try{
            for(StocksPriceEntity entity : entitys){
                session.update(entity);
            }

            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }



    public static void main(String[] args){
        StocksPriceDao dao = new StocksPriceDao();

//        List<StocksPriceEntity> list = dao.getByCode("002340");
//        System.out.println(list.size());
//        StocksPriceEntity entity = list.get(0);
//        System.out.println(entity.getShouPan());
//        System.out.println(entity.getStocksEntity());
//        System.out.println(entity.getStocksEntity().getDetailUrl1());
//        System.out.println(entity.getStocksEntity().getCode());
//        HibernateUtil.closeSessionFactory();


//        List<StocksPriceEntity> list = dao.getByDate("2016-03-08");
//        System.out.println(list.size());
//        StocksPriceEntity entity = list.get(0);
//        System.out.println(entity.getShouPan());
//        System.out.println(entity.getStocksEntity());
//        System.out.println(entity.getStocksEntity().getDetailUrl());
//        HibernateUtil.closeSessionFactory();

        dao.getMA5("");






    }







}
