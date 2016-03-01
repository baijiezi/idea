package com.stocks.dao;

import com.mysql.jdbc.log.LogFactory;
import com.stocks.entity.StocksEntity;
import com.stocks.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.LoggerFactory;

import java.util.List;
import org.slf4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-21
 * Time: 上午11:42
 * To change this template use File | Settings | File Templates.
 */
public class StocksDao {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public List<StocksEntity> getAll(){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();

        try{
            Query query = session.createQuery(" from StocksEntity ");
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

    public List<StocksEntity> queryByCodeAndExchange(String code, String exchange, Session session){
        try{
            if(code==null || code.equals("")) {
                return null;
            }
            Query query = session.createQuery(" from StocksEntity s where s.code = '" + code + "' and s.exchange = '" + exchange + "'");
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
        return null;

    }

    public void save(StocksEntity stock, Session session){
        try{
            List<StocksEntity> list = queryByCodeAndExchange(stock.getCode(), stock.getExchange(), session);
            if(list!=null && list.size()>0){
                logger.error("入库异常，已存在相同的代码:" + stock.getCode());
                throw new Exception("入库异常，已存在相同的代码:" + stock.getCode());
            }
            else{
                session.save(stock);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }



    public void update(StocksEntity stock, Session session){
        try{
            session.update(stock);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
