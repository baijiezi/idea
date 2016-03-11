package com.message.dao;

import com.message.entity.MessageEntity;
import com.stocks.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-3-11
 * Time: 上午10:22
 * To change this template use File | Settings | File Templates.
 */
public class MessageDao {

    public List<MessageEntity> getByStatus(Integer status){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            Query query = session.createQuery(" from MessageEntity s where s.status = " + status);
            List<MessageEntity> list = query.list();
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

    public void save(MessageEntity entity, Session session){
        try{
            session.save(entity);
        }catch(Exception e){
            e.printStackTrace();
        }

    }



    public void update(MessageEntity entity, Session session){
        try{
            session.update(entity);
        }catch(Exception e){
            e.printStackTrace();
        }

    }



    public static void main(String[] args){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();

        MessageEntity entity = new MessageEntity();
        entity.setMobile("222");
        entity.setContent("aaa");

        MessageDao dao = new MessageDao();
//        dao.save(entity, session);
        List list = dao.getByStatus(0);
        System.out.println(list.size());


        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();


    }



}
