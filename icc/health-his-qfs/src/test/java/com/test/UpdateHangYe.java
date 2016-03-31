package com.test;

import com.stocks.dao.StocksDao;
import com.stocks.dao.StocksFhsgDao;
import com.stocks.entity.StocksEntity;
import com.stocks.utils.HibernateUtil;
import org.hibernate.Session;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-3-30
 * Time: 下午4:42
 * To change this template use File | Settings | File Templates.
 */
public class UpdateHangYe {

    public static void main(String[] args){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        StocksDao dao = new StocksDao();
        String hangYe = "f";
        String codes = "";
        int n = codes.length()/6;
        System.out.println("length：" + codes.length());
        System.out.println("需要更新行数：" + n);
        for(int i=0; i<n; i++){
            try{
                String code = codes.substring(i*6, (i+1)*6);
                System.out.println(code);
                StocksEntity entity = dao.getByCode(code);
                entity.setHangYe( (entity.getHangYe()==null || entity.equals("")) ? hangYe : entity.getHangYe()+","+hangYe);
                dao.update(entity, session);
            }catch (Exception e){
                System.out.println("更新异常：");
                e.printStackTrace();
            }
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();




    }
}
