package com.stocks.dao;

import com.stocks.entity.StocksEntity;
import com.stocks.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-21
 * Time: 上午11:42
 * To change this template use File | Settings | File Templates.
 */
public class StocksDao {

    public void saveOrUpdate(StocksEntity stock){
        try{
            Session session = HibernateUtil.getOpenSession();
            session.beginTransaction();

            Query query = session.createQuery("from StocksEntity s where s.code = " + stock.getCode());
            List<StocksEntity> list = query.list();
            System.out.println(list.size());
            if(list.size() > 0){
                StocksEntity sck = list.get(0);
                sck.setName(stock.getName());
                session.update(sck);
            }else{
                session.save(stock);
            }
            session.getTransaction().commit();
            session.close();
            HibernateUtil.closeSessionFactory();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void saveOrUpdate(StocksEntity stock, Session session){
        try{
            Query query = session.createQuery("from StocksEntity s where s.code = " + stock.getCode());
            List<StocksEntity> list = query.list();
            System.out.println(list.size());
            if(list.size() > 0){
                StocksEntity sck = list.get(0);
                sck.setName(stock.getName());
                session.update(sck);
            }else{
                session.save(stock);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
