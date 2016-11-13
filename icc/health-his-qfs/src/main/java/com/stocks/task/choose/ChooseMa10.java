package com.stocks.task.choose;

import com.ning.http.util.DateUtil;
import com.stocks.dao.StocksDailyKLineMA10Dao;
import com.stocks.dao.StocksPriceDao;
import com.stocks.entity.StocksDailyKLineMA10Entity;
import com.stocks.entity.StocksPriceEntity;
import com.stocks.utils.DateUtils;
import com.stocks.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-11-5
 * Time: 下午1:57
 * To change this template use File | Settings | File Templates.
 */
public class ChooseMa10 {
    public static void main(String[] args){
        ChooseMa10 chooseMa10 = new ChooseMa10();
        chooseMa10.doChoose();

    }

    public void doChoose(){
        Date date = DateUtils.strToDate("2016-09-06");
        StocksPriceDao priceDao = new StocksPriceDao();
        List<StocksPriceEntity> li = priceDao.getTopByCodeAndDate("000001_2", DateUtils.getSimpleDate(date), 10);
        Date date1 = li.get(5).getDate();

        StocksDailyKLineMA10Dao kLineMA10Dao = new StocksDailyKLineMA10Dao();
        List<StocksDailyKLineMA10Entity> ma5List = kLineMA10Dao.getByDate(date);

        List<StocksDailyKLineMA10Entity> ma5List1 = kLineMA10Dao.getByDate(date1);
        Map ma5Map1 = new HashMap<String, StocksDailyKLineMA10Entity>();
        for(StocksDailyKLineMA10Entity entity : ma5List1){
            ma5Map1.put(entity.getCode(), entity);
        }

        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        List<StocksDailyKLineMA10Entity> data = new ArrayList<StocksDailyKLineMA10Entity>();
        for(StocksDailyKLineMA10Entity entity : ma5List){
            if(entity.getZhangFu() > 0){
                StocksDailyKLineMA10Entity entity1 = (StocksDailyKLineMA10Entity)ma5Map1.get(entity.getCode());
                if(entity1!=null && entity1.getZhangFu()<0){
                    StocksPriceEntity priceEntity = priceDao.getByDateAndCode(entity.getDate(), entity.getCode(), session);
                    System.out.println(priceEntity.getCode() + "      " + priceEntity.getPriceTrends());
                }
            }
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }
}
