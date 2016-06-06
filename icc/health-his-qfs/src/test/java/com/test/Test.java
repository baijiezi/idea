package com.test;

import com.stocks.dao.StocksFhsgDao;
import com.stocks.dao.StocksZjlxHXDao;
import com.stocks.entity.StocksFhsgEntity;
import com.stocks.entity.StocksZjlxHXEntity;
import com.stocks.utils.DateUtils;
import com.stocks.utils.HibernateUtil;
import com.stocks.utils.NumberUtils;
import org.hibernate.Session;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-6-3
 * Time: 上午10:47
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    public static void main(String[] args){
        Test test = new Test();
//        test.jiSuanJingLiuRuLv();
    }

    public void jiSuanJingLiuRuLv(){
        try{
            Date date = DateUtils.strToDate("2016-03-16");
            Date endDate = DateUtils.strToDate("2016-06-03 23:59:59");

            while (date.before(endDate)){
                System.out.println(DateUtils.getSimpleDate(date));
                Session session = HibernateUtil.getOpenSession();
                session.beginTransaction();
                StocksZjlxHXDao dao = new StocksZjlxHXDao();
                List<StocksZjlxHXEntity> list =  dao.getByDate(date);
                for(StocksZjlxHXEntity entity : list){
                    entity.setJingLiuRuLv(NumberUtils.getBiLv(entity.getJingLiuRu(), entity.getHeJiChengJiao()));
                    session.update(entity);
                }
                session.getTransaction().commit();
                session.close();
                HibernateUtil.closeSessionFactory();

                date = DateUtils.addDate(date, 1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
