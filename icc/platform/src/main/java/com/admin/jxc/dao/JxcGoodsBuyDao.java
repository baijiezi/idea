package com.admin.jxc.dao;

import com.admin.jxc.entity.JxcGoodsBuyEntity;
import com.admin.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-9-21
 * Time: 下午4:09
 * To change this template use File | Settings | File Templates.
 */
public class JxcGoodsBuyDao {
    public List<JxcGoodsBuyEntity> getAll(){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            Query query = session.createQuery(" from JxcGoodsBuyEntity s where 1 = 1");
            List<JxcGoodsBuyEntity> list = query.list();
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

    public void save(JxcGoodsBuyEntity entity){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            session.save(entity);
        }catch(Exception e){
            e.printStackTrace();
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }
}
