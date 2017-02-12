package com.stocks.dao;

import com.stocks.entity.*;
import com.stocks.utils.DateUtils;
import com.stocks.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-3-3
 * Time: 下午6:54
 * To change this template use File | Settings | File Templates.
 */
public class StocksPriceDao implements IBaseDao{

    public List<StocksPriceEntity> getByCode(String code){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            if(code==null || code.equals("")) {
                return null;
            }
            Query query = session.createQuery(" from StocksPriceEntity s where s.code = '" + code + "'");
            List<StocksPriceEntity> list = query.list();
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

    public List<StocksPriceEntity> getTopByCodeAndDate(String code, String date, Integer limit){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            if(code==null || code.equals("")) {
                return null;
            }
            Query query = session.createQuery(" from StocksPriceEntity s where s.code = '" + code + "' and s.date <= '" + date + "' order by s.id desc ");
            query.setMaxResults(limit);
            List<StocksPriceEntity> list = query.list();
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

    public List<StocksPriceEntity> getByDate(Date date){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        List<StocksPriceEntity> list = new ArrayList<StocksPriceEntity>();
        try{
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dt = format.format(date);
            Query query = session.createQuery(" from StocksPriceEntity s where s.date = '" + dt + "'");
            list = query.list();
            if(list!=null && list.size()>0) {
                return list;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
        return list;

    }

    public List<StocksPriceEntity> getByDate(String date){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            Query query = session.createQuery(" from StocksPriceEntity s where s.date = '" + date + "'");
            List<StocksPriceEntity> list = query.list();
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

    public StocksPriceEntity getByDateAndCode(Date date, String code){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dt = format.format(date);
            Query query = session.createQuery(" from StocksPriceEntity s where s.date = '" + dt + "' and s.code = '" + code + "'");
            List<StocksPriceEntity> list = query.list();
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

    public StocksPriceEntity getByDateAndCode(Date date, String code, Session session){

        try{
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dt = format.format(date);
            Query query = session.createQuery(" from StocksPriceEntity s where s.date = '" + dt + "' and s.code = '" + code + "'");
            List<StocksPriceEntity> list = query.list();
            if(list!=null && list.size()>0) {
                return list.get(0);
            }
            else{
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;

    }

    public StocksPriceEntity getByDateAndCode(String date, String code){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            Query query = session.createQuery(" from StocksPriceEntity s where s.date = '" + date + "' and s.code = '" + code + "'");
            List<StocksPriceEntity> list = query.list();
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

    public  List<StocksPriceEntity> getRecentRecords(String code, Session session, Integer minId){
        List<StocksPriceEntity> list = new ArrayList<StocksPriceEntity>();
        try{
            Query query = session.createQuery(" from StocksPriceEntity s where s.code = '" + code + "' and s.id > " + minId);
            list = query.list();
            if(list!=null && list.size()>0){
                return list;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;

    }

    public  List<StocksPriceEntity> getById(Session session, Integer minId, Integer maxId){
        List<StocksPriceEntity> list = new ArrayList<StocksPriceEntity>();
        Query query = session.createQuery(" from StocksPriceEntity s where s.id > " + minId + " and s.id <= " + maxId);
        list = query.list();
        if(list!=null && list.size()>0){
            return list;
        }
        return list;

    }


    public StocksDailyKLineMA5Entity getMA5(String code, String date, Session session){
        try{
            Query query = session.createSQLQuery("SELECT code, name, date, AVG(shouPan), AVG(junJia), AVG(zhangFu), AVG(zhangDie), AVG(chengJiaoLiang), AVG(ChengJiaoE), AVG(huanShou),AVG(liangBi),MAX(zuiGao)," +
                    "MIN(zuiDi), AVG(zhenFu), AVG(waiPan), AVG(neiPan), AVG(panCha), AVG(panBi), AVG(weiBi), AVG(weiCha) FROM (SELECT * FROM sic_stocks_price p where p.code='" + code + "' and p.date<='" + date + "' ORDER BY p.date DESC LIMIT 5) as A");
            List<Object> list = query.list();
            if(list!=null && list.size()>0) {
                Object[] temp = (Object[])list.get(0);
                Date d = (Date)temp[2];
                if(!DateUtils.getSimpleDate(d).equals(date)){
                    return null;
                }
                StocksDailyKLineMA5Entity entity = new StocksDailyKLineMA5Entity();
                entity.setCode((String)temp[0]);
                entity.setName((String) temp[1]);
                entity.setDate((Date) temp[2]);
                entity.setShouPan(temp[3]==null ? null : ((BigDecimal)temp[3]).intValue());
                entity.setJunJia(temp[4]==null ? null : ((BigDecimal)temp[4]).intValue());
                entity.setZhangFu(temp[5]==null ? null : ((BigDecimal)temp[5]).intValue());
                entity.setZhangDie(temp[6]==null ? null : ((BigDecimal)temp[6]).intValue());
                entity.setChengJiaoLiang(temp[7]==null ? null : ((BigDecimal)temp[7]).longValue());
                entity.setChengJiaoE(temp[8]==null ? null : ((BigDecimal)temp[8]).longValue());
                entity.setHuanShou(temp[9]==null ? null : ((BigDecimal)temp[9]).intValue());
                entity.setLiangBi(temp[10]==null ? null : ((BigDecimal)temp[10]).intValue());
                entity.setZuiGao(temp[11]==null ? null : (Integer)temp[11]);
                entity.setZuiDi(temp[12]==null ? null : (Integer)temp[12]);
                entity.setZhenFu(temp[13]==null ? null : ((BigDecimal)temp[13]).intValue());
                entity.setWaiPan(temp[14]==null ? null : ((BigDecimal)temp[14]).intValue());
                entity.setNeiPan(temp[15]==null ? null : ((BigDecimal)temp[15]).intValue());
                entity.setPanCha(temp[16]==null ? null : ((BigDecimal)temp[16]).intValue());
                entity.setPanBi(temp[17]==null ? null : ((BigDecimal)temp[17]).intValue());
                entity.setWeiBi(temp[18]==null ? null : ((BigDecimal)temp[18]).intValue());
                entity.setWeiCha(temp[19]==null ? null : ((BigDecimal)temp[19]).intValue());
                return entity;
            }

            return null;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;

    }


    public StocksDailyKLineMA10Entity getMA10(String code, String date, Session session){
        try{
            Query query = session.createSQLQuery("SELECT code, name, date, AVG(shouPan), AVG(junJia), AVG(zhangFu), AVG(zhangDie), AVG(chengJiaoLiang), AVG(ChengJiaoE), AVG(huanShou),AVG(liangBi),MAX(zuiGao)," +
                    "MIN(zuiDi), AVG(zhenFu), AVG(waiPan), AVG(neiPan), AVG(panCha), AVG(panBi), AVG(weiBi), AVG(weiCha) FROM (SELECT * FROM sic_stocks_price p where p.code='" + code + "' and p.date<='" + date + "' ORDER BY p.date DESC LIMIT 10) as A");
            List<Object> list = query.list();
            if(list!=null && list.size()>0) {
                Object[] temp = (Object[])list.get(0);
                Date d = (Date)temp[2];
                if(!DateUtils.getSimpleDate(d).equals(date)){
                    return null;
                }
                StocksDailyKLineMA10Entity entity = new StocksDailyKLineMA10Entity();
                entity.setCode((String)temp[0]);
                entity.setName((String) temp[1]);
                entity.setDate((Date) temp[2]);
                entity.setShouPan(temp[3]==null ? null : ((BigDecimal)temp[3]).intValue());
                entity.setJunJia(temp[4]==null ? null : ((BigDecimal)temp[4]).intValue());
                entity.setZhangFu(temp[5]==null ? null : ((BigDecimal)temp[5]).intValue());
                entity.setZhangDie(temp[6]==null ? null : ((BigDecimal)temp[6]).intValue());
                entity.setChengJiaoLiang(temp[7]==null ? null : ((BigDecimal)temp[7]).longValue());
                entity.setChengJiaoE(temp[8]==null ? null : ((BigDecimal)temp[8]).longValue());
                entity.setHuanShou(temp[9]==null ? null : ((BigDecimal)temp[9]).intValue());
                entity.setLiangBi(temp[10]==null ? null : ((BigDecimal)temp[10]).intValue());
                entity.setZuiGao(temp[11]==null ? null : (Integer)temp[11]);
                entity.setZuiDi(temp[12]==null ? null : (Integer)temp[12]);
                entity.setZhenFu(temp[13]==null ? null : ((BigDecimal)temp[13]).intValue());
                entity.setWaiPan(temp[14]==null ? null : ((BigDecimal)temp[14]).intValue());
                entity.setNeiPan(temp[15]==null ? null : ((BigDecimal)temp[15]).intValue());
                entity.setPanCha(temp[16]==null ? null : ((BigDecimal)temp[16]).intValue());
                entity.setPanBi(temp[17]==null ? null : ((BigDecimal)temp[17]).intValue());
                entity.setWeiBi(temp[18]==null ? null : ((BigDecimal)temp[18]).intValue());
                entity.setWeiCha(temp[19]==null ? null : ((BigDecimal)temp[19]).intValue());
                return entity;
            }

            return null;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;

    }


    public StocksDailyKLineMA20Entity getMA20(String code, String date, Session session){
        try{
            Query query = session.createSQLQuery("SELECT code, name, date, AVG(shouPan), AVG(junJia), AVG(zhangFu), AVG(zhangDie), AVG(chengJiaoLiang), AVG(ChengJiaoE), AVG(huanShou),AVG(liangBi),MAX(zuiGao)," +
                    "MIN(zuiDi), AVG(zhenFu), AVG(waiPan), AVG(neiPan), AVG(panCha), AVG(panBi), AVG(weiBi), AVG(weiCha) FROM (SELECT * FROM sic_stocks_price p where p.code='" + code + "' and p.date<='" + date + "' ORDER BY p.date DESC LIMIT 20) as A");
            List<Object> list = query.list();
            if(list!=null && list.size()>0) {
                Object[] temp = (Object[])list.get(0);
                Date d = (Date)temp[2];
                if(!DateUtils.getSimpleDate(d).equals(date)){
                    return null;
                }
                StocksDailyKLineMA20Entity entity = new StocksDailyKLineMA20Entity();
                entity.setCode((String)temp[0]);
                entity.setName((String) temp[1]);
                entity.setDate((Date) temp[2]);
                entity.setShouPan(temp[3]==null ? null : ((BigDecimal)temp[3]).intValue());
                entity.setJunJia(temp[4]==null ? null : ((BigDecimal)temp[4]).intValue());
                entity.setZhangFu(temp[5]==null ? null : ((BigDecimal)temp[5]).intValue());
                entity.setZhangDie(temp[6]==null ? null : ((BigDecimal)temp[6]).intValue());
                entity.setChengJiaoLiang(temp[7]==null ? null : ((BigDecimal)temp[7]).longValue());
                entity.setChengJiaoE(temp[8]==null ? null : ((BigDecimal)temp[8]).longValue());
                entity.setHuanShou(temp[9]==null ? null : ((BigDecimal)temp[9]).intValue());
                entity.setLiangBi(temp[10]==null ? null : ((BigDecimal)temp[10]).intValue());
                entity.setZuiGao(temp[11]==null ? null : (Integer)temp[11]);
                entity.setZuiDi(temp[12]==null ? null : (Integer)temp[12]);
                entity.setZhenFu(temp[13]==null ? null : ((BigDecimal)temp[13]).intValue());
                entity.setWaiPan(temp[14]==null ? null : ((BigDecimal)temp[14]).intValue());
                entity.setNeiPan(temp[15]==null ? null : ((BigDecimal)temp[15]).intValue());
                entity.setPanCha(temp[16]==null ? null : ((BigDecimal)temp[16]).intValue());
                entity.setPanBi(temp[17]==null ? null : ((BigDecimal)temp[17]).intValue());
                entity.setWeiBi(temp[18]==null ? null : ((BigDecimal)temp[18]).intValue());
                entity.setWeiCha(temp[19]==null ? null : ((BigDecimal)temp[19]).intValue());
                return entity;
            }

            return null;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;

    }


    public StocksDailyKLineMA30Entity getMA30(String code, String date, Session session){
        try{
            Query query = session.createSQLQuery("SELECT code, name, date, AVG(shouPan), AVG(junJia), AVG(zhangFu), AVG(zhangDie), AVG(chengJiaoLiang), AVG(ChengJiaoE), AVG(huanShou),AVG(liangBi),MAX(zuiGao)," +
                    "MIN(zuiDi), AVG(zhenFu), AVG(waiPan), AVG(neiPan), AVG(panCha), AVG(panBi), AVG(weiBi), AVG(weiCha) FROM (SELECT * FROM sic_stocks_price p where p.code='" + code + "' and p.date<='" + date + "' ORDER BY p.date DESC LIMIT 30) as A");
            List<Object> list = query.list();
            if(list!=null && list.size()>0) {
                Object[] temp = (Object[])list.get(0);
                Date d = (Date)temp[2];
                if(!DateUtils.getSimpleDate(d).equals(date)){
                    return null;
                }
                StocksDailyKLineMA30Entity entity = new StocksDailyKLineMA30Entity();
                entity.setCode((String)temp[0]);
                entity.setName((String) temp[1]);
                entity.setDate((Date) temp[2]);
                entity.setShouPan(temp[3]==null ? null : ((BigDecimal)temp[3]).intValue());
                entity.setJunJia(temp[4]==null ? null : ((BigDecimal)temp[4]).intValue());
                entity.setZhangFu(temp[5]==null ? null : ((BigDecimal)temp[5]).intValue());
                entity.setZhangDie(temp[6]==null ? null : ((BigDecimal)temp[6]).intValue());
                entity.setChengJiaoLiang(temp[7]==null ? null : ((BigDecimal)temp[7]).longValue());
                entity.setChengJiaoE(temp[8]==null ? null : ((BigDecimal)temp[8]).longValue());
                entity.setHuanShou(temp[9]==null ? null : ((BigDecimal)temp[9]).intValue());
                entity.setLiangBi(temp[10]==null ? null : ((BigDecimal)temp[10]).intValue());
                entity.setZuiGao(temp[11]==null ? null : (Integer)temp[11]);
                entity.setZuiDi(temp[12]==null ? null : (Integer)temp[12]);
                entity.setZhenFu(temp[13]==null ? null : ((BigDecimal)temp[13]).intValue());
                entity.setWaiPan(temp[14]==null ? null : ((BigDecimal)temp[14]).intValue());
                entity.setNeiPan(temp[15]==null ? null : ((BigDecimal)temp[15]).intValue());
                entity.setPanCha(temp[16]==null ? null : ((BigDecimal)temp[16]).intValue());
                entity.setPanBi(temp[17]==null ? null : ((BigDecimal)temp[17]).intValue());
                entity.setWeiBi(temp[18]==null ? null : ((BigDecimal)temp[18]).intValue());
                entity.setWeiCha(temp[19]==null ? null : ((BigDecimal)temp[19]).intValue());
                return entity;
            }

            return null;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;

    }

    public StocksDailyKLineMA60Entity getMA60(String code, String date, Session session){
        try{
            Query query = session.createSQLQuery("SELECT code, name, date, AVG(shouPan), AVG(junJia), AVG(zhangFu), AVG(zhangDie), AVG(chengJiaoLiang), AVG(ChengJiaoE), AVG(huanShou),AVG(liangBi),MAX(zuiGao)," +
                    "MIN(zuiDi), AVG(zhenFu), AVG(waiPan), AVG(neiPan), AVG(panCha), AVG(panBi), AVG(weiBi), AVG(weiCha) FROM (SELECT * FROM sic_stocks_price p where p.code='" + code + "' and p.date<='" + date + "' ORDER BY p.date DESC LIMIT 60) as A");
            List<Object> list = query.list();
            if(list!=null && list.size()>0) {
                Object[] temp = (Object[])list.get(0);
                Date d = (Date)temp[2];
                if(!DateUtils.getSimpleDate(d).equals(date)){
                    return null;
                }
                StocksDailyKLineMA60Entity entity = new StocksDailyKLineMA60Entity();
                entity.setCode((String)temp[0]);
                entity.setName((String) temp[1]);
                entity.setDate((Date) temp[2]);
                entity.setShouPan(temp[3]==null ? null : ((BigDecimal)temp[3]).intValue());
                entity.setJunJia(temp[4]==null ? null : ((BigDecimal)temp[4]).intValue());
                entity.setZhangFu(temp[5]==null ? null : ((BigDecimal)temp[5]).intValue());
                entity.setZhangDie(temp[6]==null ? null : ((BigDecimal)temp[6]).intValue());
                entity.setChengJiaoLiang(temp[7]==null ? null : ((BigDecimal)temp[7]).longValue());
                entity.setChengJiaoE(temp[8]==null ? null : ((BigDecimal)temp[8]).longValue());
                entity.setHuanShou(temp[9]==null ? null : ((BigDecimal)temp[9]).intValue());
                entity.setLiangBi(temp[10]==null ? null : ((BigDecimal)temp[10]).intValue());
                entity.setZuiGao(temp[11]==null ? null : (Integer)temp[11]);
                entity.setZuiDi(temp[12]==null ? null : (Integer)temp[12]);
                entity.setZhenFu(temp[13]==null ? null : ((BigDecimal)temp[13]).intValue());
                entity.setWaiPan(temp[14]==null ? null : ((BigDecimal)temp[14]).intValue());
                entity.setNeiPan(temp[15]==null ? null : ((BigDecimal)temp[15]).intValue());
                entity.setPanCha(temp[16]==null ? null : ((BigDecimal)temp[16]).intValue());
                entity.setPanBi(temp[17]==null ? null : ((BigDecimal)temp[17]).intValue());
                entity.setWeiBi(temp[18]==null ? null : ((BigDecimal)temp[18]).intValue());
                entity.setWeiCha(temp[19]==null ? null : ((BigDecimal)temp[19]).intValue());
                return entity;
            }

            return null;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;

    }

    public boolean save(StocksPriceEntity stocksPriceEntity, Session session){
        try{
            session.save(stocksPriceEntity);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }



    public boolean update(StocksPriceEntity stocksPriceEntity, Session session){
        try{
            session.update(stocksPriceEntity);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(List<StocksPriceEntity> entitys, Session session){
        try{
            for(StocksPriceEntity entity : entitys){
                session.update(entity);
            }

            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }



    public static void main(String[] args){
        Session session = HibernateUtil.getOpenSession();
        StocksPriceDao dao = new StocksPriceDao();

        List<StocksPriceEntity> list = dao.getByCode("002340");
        System.out.println(list.size());
//        StocksPriceEntity entity = list.get(0);
//        System.out.println(entity.getShouPan());
//        System.out.println(entity.getStocksEntity());
//        System.out.println(entity.getStocksEntity().getDetailUrl1());
//        System.out.println(entity.getStocksEntity().getCode());
//        HibernateUtil.closeSessionFactory();


//        List<StocksPriceEntity> list = dao.getByDate("2016-03-08");
//        System.out.println(list.size());
//        StocksPriceEntity entity = list.get(0);
//        System.out.println(entity.getShouPan());
//        System.out.println(entity.getStocksEntity());
//        System.out.println(entity.getStocksEntity().getDetailUrl());
//        HibernateUtil.closeSessionFactory();

//        dao.getMA5("002340", "2016-04-01", session);






    }


    @Override
    public List exports(Date createAt) {
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        try{
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dt = format.format(createAt);
            Query query = session.createQuery(" from StocksPriceEntity s where s.createTime >= '" + dt + "'");
            List<StocksPriceEntity> list = query.list();
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
            Query query = session.createQuery(" from StocksPriceEntity s where s.createTime >= '" + createAt + "'");
            List<StocksPriceEntity> list = query.list();
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
}
