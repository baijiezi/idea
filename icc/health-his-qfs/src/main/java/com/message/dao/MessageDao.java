package com.message.dao;

import com.message.entity.MessageEntity;
import com.stocks.dao.IBaseDao;
import com.stocks.utils.DateUtils;
import com.stocks.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-3-11
 * Time: 上午10:22
 * To change this template use File | Settings | File Templates.
 */
public class MessageDao {

    public List<MessageEntity> getToSends(String toSendTime){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            Query query = session.createQuery(" from MessageEntity s where s.status in(1,2) and s.toSendTime <  '" + toSendTime + "'");
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

    public List<MessageEntity> getByTypeAndSendTime(String type, String date){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            Query query = session.createQuery(" from MessageEntity s where s.type = '" + type + "' and s.sendTime >= '" + date + "'");
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

    public List<MessageEntity> getByTypeAndToSendTime(String type, String date){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            Query query = session.createQuery(" from MessageEntity s where s.type = '" + type + "' and s.toSendTime >= '" + date + "'");
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

    public void save(MessageEntity entity){
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

//        MessageEntity entity = new MessageEntity();
//        entity.setMobile("222");
//        entity.setContent("aaa");

        MessageDao dao = new MessageDao();
//        dao.save(entity, session);
//        List list = dao.getByStatus(0);
//        List list = dao.getByTypeAndSendTime("111", DateUtils.getSimpleDate(new Date()));

        List list = dao.getToSends(DateUtils.getStrTime(new Date()));
        System.out.println(list.size());


        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();


    }

}
