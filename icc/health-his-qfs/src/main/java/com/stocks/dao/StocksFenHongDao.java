package com.stocks.dao;

import com.stocks.entity.StocksFenHongEntity;
import com.stocks.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-3-21
 * Time: 下午3:44
 * To change this template use File | Settings | File Templates.
 */
public class StocksFenHongDao {


    public List<StocksFenHongEntity> getByCode(String code){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            if(code==null || code.equals("")) {
                return null;
            }
            Query query = session.createQuery(" from StocksFenHongEntity s where s.code = '" + code + "'");
            List<StocksFenHongEntity> list = query.list();
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

    public static void main(String[] args){
        StocksFenHongDao dao = new StocksFenHongDao();
        List<StocksFenHongEntity> list = dao.getByCode("222222");
        System.out.println(list.size());

    }
}
