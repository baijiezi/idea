package com.stocks.dao;

import com.stocks.dto.StocksFhsgDto;
import com.stocks.entity.StocksQuanZhongEntity;
import com.stocks.utils.DateUtils;
import com.stocks.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-11-30
 * Time: 下午6:17
 * To change this template use File | Settings | File Templates.
 */
public class StocksQuanZhongDao implements IBaseDao {

    public List<StocksQuanZhongEntity> getAll(){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            List<StocksQuanZhongEntity> list = new ArrayList<StocksQuanZhongEntity>();
            Query query = session.createQuery(" from StocksQuanZhongEntity s where 1 = 1");
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

    public List<StocksQuanZhongEntity> getByType(String type){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            if(type==null || type.equals("")) {
                return null;
            }
            Query query = session.createQuery(" from StocksQuanZhongEntity s where s.type = '" + type + "'");
            List<StocksQuanZhongEntity> list = query.list();
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

    public boolean save(StocksQuanZhongEntity entity, Session session){
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
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dt = format.format(createAt);
            Query query = session.createQuery(" from StocksQuanZhongEntity s where s.createAt >= '" + dt + "'");
            List<StocksQuanZhongEntity> list = query.list();
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

    @Override
    public List exports(String createAt) {
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            Query query = session.createQuery(" from StocksQuanZhongEntity s where s.createAt >= '" + createAt + "'");
            List<StocksQuanZhongEntity> list = query.list();
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
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        StocksQuanZhongDao dao = new StocksQuanZhongDao();

        ClassLoader classLoader = dao.getClass().getClassLoader();
        File file = new File(classLoader.getResource("file/a.txt").getFile());
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }






        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();



    }

}
