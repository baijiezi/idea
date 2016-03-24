package com.stocks.dao;

import com.stocks.entity.StocksFhsgEntity;
import com.stocks.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import com.stocks.utils.DateUtils;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-3-24
 * Time: 下午4:23
 * To change this template use File | Settings | File Templates.
 */
public class StocksFhsgDao {
    public List<StocksFhsgEntity> getByCode(String code){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            if(code==null || code.equals("")) {
                return null;
            }
            Query query = session.createQuery(" from StocksFhsgEntity s where s.code = '" + code + "'");
            List<StocksFhsgEntity> list = query.list();
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

    public StocksFhsgEntity getByCodeAndGongGaoRi(String code, Date date){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            if(code==null || code.equals("")) {
                return null;
            }
            Query query = session.createQuery(" from StocksFhsgEntity s where s.code = '" + code + "' and s.gongGaoRi = '" + DateUtils.getSimpleDate(date) + "'");
            List<StocksFhsgEntity> list = query.list();
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


    public StocksFhsgEntity getByCodeAndGongGaoRi(String code, String date){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            if(code==null || code.equals("")) {
                return null;
            }
            Query query = session.createQuery(" from StocksFhsgEntity s where s.code = '" + code + "' and s.gongGaoRi = '" + date + "'");
            List<StocksFhsgEntity> list = query.list();
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


    public boolean save(StocksFhsgEntity stocksFhsgEntity, Session session){
        try{
            session.save(stocksFhsgEntity);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }



    public boolean update(StocksFhsgEntity stocksFhsgEntity, Session session){
        try{
            session.update(stocksFhsgEntity);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(List<StocksFhsgEntity> entitys, Session session){
        try{
            for(StocksFhsgEntity entity : entitys){
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
        session.beginTransaction();

        StocksFhsgDao dao = new StocksFhsgDao();
//        StocksFhsgEntity entity = new StocksFhsgEntity();
//        entity.setCode("111");
//        entity.setGongGaoRi(new Date());
//        entity.setName("222");
//        entity.setRemark("====");
//        entity.setCreateAt(new Date());
//        dao.update(entity, session);

//        List<StocksFhsgEntity> list = dao.getByCode("111");
//        for(StocksFhsgEntity entity : list){
//            System.out.println(entity.getName());
//        }

        StocksFhsgEntity entity = dao.getByCodeAndGongGaoRi("111", new Date());
        System.out.println(entity.getName());


        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();



    }

}
