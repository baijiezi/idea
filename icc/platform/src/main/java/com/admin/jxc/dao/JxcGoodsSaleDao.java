package com.admin.jxc.dao;

import com.admin.jxc.entity.JxcGoodsSaleEntity;
import com.admin.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-9-21
 * Time: 下午4:10
 * To change this template use File | Settings | File Templates.
 */
public class JxcGoodsSaleDao {

    public List<JxcGoodsSaleEntity> getAll(){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        List<JxcGoodsSaleEntity> list = new ArrayList<JxcGoodsSaleEntity>();
        try{
            Query query = session.createQuery(" from JxcGoodsSaleEntity s where 1 = 1");
            list = query.list();
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
        return list;
    }

    public void save(JxcGoodsSaleEntity entity){
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
