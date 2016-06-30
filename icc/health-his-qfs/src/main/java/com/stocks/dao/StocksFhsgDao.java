package com.stocks.dao;

import com.stocks.dto.StocksFhsgDto;
import com.stocks.entity.StocksFhsgEntity;
import com.stocks.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import com.stocks.utils.DateUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-3-24
 * Time: 下午4:23
 * To change this template use File | Settings | File Templates.
 */
public class StocksFhsgDao implements IBaseDao {

    public List<StocksFhsgEntity> getAll(){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            List<StocksFhsgEntity> list = new ArrayList<StocksFhsgEntity>();
            Query query = session.createQuery(" from StocksFhsgEntity s where 1 = 1");
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

    public List<StocksFhsgEntity> getByCode(String code){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            if(code==null || code.equals("")) {
                return null;
            }
            Query query = session.createQuery(" from StocksFhsgEntity s where s.code = '" + code + "'");
            List<StocksFhsgEntity> list = query.list();
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

    public StocksFhsgEntity getByCodeAndGongGaoRi(String code, Date date){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            if(code==null || code.equals("")) {
                return null;
            }
            Query query = session.createQuery(" from StocksFhsgEntity s where s.code = '" + code + "' and s.gongGaoRi = '" + DateUtils.getSimpleDate(date) + "'");
            List<StocksFhsgEntity> list = query.list();
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


    public StocksFhsgEntity getByCodeAndGongGaoRi(String code, String date){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            if(code==null || code.equals("")) {
                return null;
            }
            Query query = session.createQuery(" from StocksFhsgEntity s where s.code = '" + code + "' and s.gongGaoRi = '" + date + "'");
            List<StocksFhsgEntity> list = query.list();
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

    public boolean isExit(StocksFhsgDto dto){
        String code = dto.getCode();
        Date gongGaoRi = dto.getGongGaoRi();
        Integer fenHong = dto.getFenHong();
        Integer songGu = dto.getSongGu();
        Integer zhuanZeng = dto.getZhuanZeng();
        Date dengJiRi = dto.getDengJiRi();
        Date chuQuanRi = dto.getChuQuanRi();
        String remark = dto.getRemark();

        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            StringBuffer sb = new StringBuffer(" from StocksFhsgEntity s where s.code = '" + code + "' and s.fenHong = " + fenHong + " and s.songGu = " + songGu + " and s.zhuanZeng = " + zhuanZeng);
            if(gongGaoRi != null){
                sb.append(" and s.gongGaoRi = '" + DateUtils.getSimpleDate(gongGaoRi) + "'");
            }
            if(dengJiRi != null){
                sb.append(" and s.dengJiRi = '" + DateUtils.getSimpleDate(dengJiRi) + "'");
            }
            if(dengJiRi != null){
                sb.append(" and s.chuQuanRi = '" + DateUtils.getSimpleDate(chuQuanRi) + "'");
            }
            if(remark!=null && !remark.equals("")){
                sb.append(" and s.remark = '" + remark + "'");
            }
            Query query = session.createQuery(sb.toString());
            List<StocksFhsgEntity> list = query.list();
            if(list!=null && list.size()>0) {
                return true;
            }
            else{
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
        return false;

    }


    public boolean save(StocksFhsgEntity stocksFhsgEntity, Session session){
        try{
            session.save(stocksFhsgEntity);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }



    public boolean update(StocksFhsgEntity stocksFhsgEntity, Session session){
        try{
            session.update(stocksFhsgEntity);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(List<StocksFhsgEntity> entitys, Session session){
        try{
            for(StocksFhsgEntity entity : entitys){
                session.update(entity);
            }

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
            Query query = session.createQuery(" from StocksFhsgEntity s where s.createAt >= '" + dt + "'");
            List<StocksFhsgEntity> list = query.list();
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
            Query query = session.createQuery(" from StocksFhsgEntity s where s.createAt >= '" + createAt + "'");
            List<StocksFhsgEntity> list = query.list();
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

    public List<StocksFhsgEntity> getByShouYiLvAndGongGaoRi(String gongGaoRi, Integer shouYiLv){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            List<StocksFhsgEntity> list = new ArrayList<StocksFhsgEntity>();
            Query query = session.createQuery(" from StocksFhsgEntity s where s.gongGaoRi >= '" + gongGaoRi + "' and s.shouYiLv >= " + shouYiLv);
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

    public List<StocksFhsgEntity> getBySongGuAndGongGaoRi(String gongGaoRi, Integer songGu){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            List<StocksFhsgEntity> list = new ArrayList<StocksFhsgEntity>();
            Query query = session.createQuery(" from StocksFhsgEntity s where s.gongGaoRi >= '" + gongGaoRi + "' and (s.songGu >= " + songGu + " or s.zhuanZeng >= " + songGu + ")");
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

    public List<StocksFhsgEntity> getByShouYiLvAndDengJiRi(String dengJiRi, Integer shouYiLv){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            List<StocksFhsgEntity> list = new ArrayList<StocksFhsgEntity>();
            Query query = session.createQuery(" from StocksFhsgEntity s where s.dengJiRi >= '" + dengJiRi + "' and s.shouYiLv >= " + shouYiLv + " order by s.shouYiLv desc");
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

    public List<StocksFhsgEntity> getBySongGuAndDengJiRi(String dengJiRi, Integer songGu){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            List<StocksFhsgEntity> list = new ArrayList<StocksFhsgEntity>();
            Query query = session.createQuery(" from StocksFhsgEntity s where s.dengJiRi >= '" + dengJiRi + "' and (s.songGu >= " + songGu + " or s.zhuanZeng >= " + songGu + ")");
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

    public List<StocksFhsgEntity> getByShouYiLvAndChuQuanRi(String chuQuanRi, Integer shouYiLv){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            List<StocksFhsgEntity> list = new ArrayList<StocksFhsgEntity>();
            Query query = session.createQuery(" from StocksFhsgEntity s where s.chuQuanRi >= '" + chuQuanRi + "' and s.shouYiLv >= " + shouYiLv + " order by s.shouYiLv");
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

    public List<StocksFhsgEntity> getByShouYiLvAndDengJiRiAndCreateAt(Integer shouYiLv, String dengJiRi, String createAt){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            List<StocksFhsgEntity> list = new ArrayList<StocksFhsgEntity>();
            Query query = session.createQuery(" from StocksFhsgEntity s where s.createAt >= '" + createAt + "' and s.shouYiLv >= " + shouYiLv + " and s.dengJiRi >= '" + dengJiRi + "'");
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

    public List<StocksFhsgEntity> getBySongGuAndChuQuanRi(String chuQuanRi, Integer songGu){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            List<StocksFhsgEntity> list = new ArrayList<StocksFhsgEntity>();
            Query query = session.createQuery(" from StocksFhsgEntity s where s.chuQuanRi >= '" + chuQuanRi + "' and s.fenHong = 0 and (s.songGu >= " + songGu + " or s.zhuanZeng >= " + songGu + ")");
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


    public List<StocksFhsgEntity> getByChuQuanRi(String chuQuanRi){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            List<StocksFhsgEntity> list = new ArrayList<StocksFhsgEntity>();
            Query query = session.createQuery(" from StocksFhsgEntity s where s.chuQuanRi = '" + chuQuanRi + "' ");
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

    public static void main(String[] args){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();

        StocksFhsgDao dao = new StocksFhsgDao();
        List list = dao.getByShouYiLvAndDengJiRi("2016-04-01", 3000);
        System.out.println(list.size());



        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();



    }

}
