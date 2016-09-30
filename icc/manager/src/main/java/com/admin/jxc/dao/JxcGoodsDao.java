package com.admin.jxc.dao;

import com.admin.jxc.entity.JxcGoodsEntity;
import com.admin.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-9-21
 * Time: 下午4:09
 * To change this template use File | Settings | File Templates.
 */
public class JxcGoodsDao {

    public JxcGoodsEntity findByCode(String code){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            Query query = session.createQuery(" from JxcGoodsEntity s where s.code = " + code);
            List<JxcGoodsEntity> list = query.list();
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

    public List<JxcGoodsEntity> getAll(){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            Query query = session.createQuery(" from JxcGoodsEntity s where s.status = 0");
            List<JxcGoodsEntity> list = query.list();
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

    public void save(JxcGoodsEntity entity){
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


    public static void main(String[] args){
        JxcGoodsDao dao = new JxcGoodsDao();

//        Session session = HibernateUtil.getOpenSession();
//        session.beginTransaction();
//        try{
//            JxcGoodsEntity entity = new JxcGoodsEntity();
//            entity.setCode("111111112221");
//            entity.setName("name");
//            entity.setStatus(0);
//            entity.setCreateTime(new Date());
//            dao.save(entity, session);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        session.getTransaction().commit();
//        session.close();
//        HibernateUtil.closeSessionFactory();





        List<JxcGoodsEntity> list = dao.getAll();
        System.out.println(list.size());
        for(JxcGoodsEntity entity1 : list){
            System.out.print(entity1.getCode() + "  " + entity1.getName());
            System.out.println();
        }
    }
    
}
