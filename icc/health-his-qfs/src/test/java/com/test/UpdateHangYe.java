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
        String hangYe = "纺织服装";
        String codes = "002634002776002494002239000779000971603001002687600370600626002503002761601599002699002656002674300005600398002763002780002034002193600156002517000158600987002144002397601339603555603808002269600630603518600070603116002486601718600152600448600272002003002154600493002394002563600510002029002036600137601556000850002083002293002327002404603558600689600220002516002425002087002640002098002291002042600177600107600232000726600400002762002612002569002485002072002070002044000982000955603889600233";
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
