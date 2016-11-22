package com.stocks.dao;

import com.stocks.entity.StocksGuDongEntity;
import com.stocks.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-11-22
 * Time: 上午10:10
 * To change this template use File | Settings | File Templates.
 */
public class StocksGuDongDao implements IBaseDao{

    public List<StocksGuDongEntity> getAll(){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            List<StocksGuDongEntity> list = new ArrayList<StocksGuDongEntity>();
            Query query = session.createQuery(" from StocksGuDongEntity s where 1 = 1");
            list = query.list();
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
        return null;

    }

    public List<StocksGuDongEntity> getByCode(String code){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            if(code==null || code.equals("")) {
                return null;
            }
            Query query = session.createQuery(" from StocksGuDongEntity s where s.code = '" + code + "'");
            List<StocksGuDongEntity> list = query.list();
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

    public boolean save(StocksGuDongEntity entity, Session session){
        try{
            session.save(entity);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
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
        session.beginTransaction();

        StocksGuDongEntity entity = new StocksGuDongEntity();
        entity.setCode("111111");
        entity.setName("name");
        entity.setGdName("gdName");
        StocksGuDongDao dao = new StocksGuDongDao();
        dao.save(entity, session);

        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }
}
