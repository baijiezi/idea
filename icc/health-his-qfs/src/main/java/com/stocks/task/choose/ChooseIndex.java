package com.stocks.task.choose;

import com.stocks.dao.StocksPriceDao;
import com.stocks.entity.StocksPriceEntity;
import com.stocks.utils.DateUtils;
import com.stocks.utils.HibernateUtil;
import com.stocks.utils.NumberUtils;
import org.hibernate.Session;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-5-27
 * Time: 上午10:32
 * To change this template use File | Settings | File Templates.
 */
public class ChooseIndex {

    public static void main(String[] args){
        ChooseIndex chooseIndex = new ChooseIndex();
        chooseIndex.priceTrends();

    }

    public String niZhang(){
        StocksPriceDao dao = new StocksPriceDao();
        List<StocksPriceEntity> list = dao.getByCode("000001_2");
        for(StocksPriceEntity entity : list){
            if(entity.getZhangFu()!=null && entity.getZhangFu()<-2000){
                List<StocksPriceEntity> data = dao.getByDate(entity.getDate());
                for(StocksPriceEntity priceEntity : data){
                    if(priceEntity.getZhangFu()>=5000 && priceEntity.getCode().startsWith("600")){
                        System.out.println(priceEntity.getCode() + "  " + priceEntity.getDate() + "  " + priceEntity.getPriceTrends());
                    }
                }
            }
        }
        return null;
    }


//    2-3 add:2 desc:4
//    3-4 add:8 desc:15
//    4 add:17 desc:35
//    5 add:20 desc:43
//    6 add:49 desc:49
//    7 add:52 desc:37
//    8 add:38 desc:39
//    9 add:49 desc:36
//    10 add:61 desc:33
//    11 add:47 desc:41
//    12 add:42 desc:37
//    13 add:44 desc:30
//    14 add:29 desc:24
//    15 add:42 desc:20
//    16 add:21 desc:16
//    17 add:22 desc:16
//    18 add:20 desc:18
//    19 add:21 desc:7
//    20 add:10 desc:5
//    21 add:12 desc:9
//    22 add:13 desc:12
//    23 add:10 desc:11
//    24 add:13 desc:9
//    25 add:8 desc:4
//    26 add:10 desc:10
//    27 add:14 desc:7
    public void jiaGeYuZengZhangLv(){
        Date date1 = DateUtils.strToDate("2016-03-10");
        Date date2 = DateUtils.strToDate("2016-05-19");
        StocksPriceDao dao = new StocksPriceDao();
        List<StocksPriceEntity> list = dao.getByDate(date1);
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        int add=0, desc=0;
        for(StocksPriceEntity entity : list){
            if(entity.getShouPan()>0){
                StocksPriceEntity entity2 = dao.getByDateAndCode(date2, entity.getCode(), session);
                if(entity2!=null && entity2.getShouPan()>0){
                    int biLv = NumberUtils.getBiLv(entity2.getShouPan() - entity.getShouPan(), entity.getShouPan());
                    if(biLv > 0){
                        add++;
                    }
                    if(biLv < 0){
                        desc++;
                    }

                }
            }
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();

        System.out.println("add:" + add);
        System.out.println("desc:" + desc);
    }


    public void priceTrends(){
        Date date = DateUtils.strToDate("2016-05-31");
        StocksPriceDao dao = new StocksPriceDao();
        List<StocksPriceEntity> list = dao.getByDate(date);
        for(StocksPriceEntity entity : list){
            String priceTrends = entity.getPriceTrends();
            if(priceTrends!=null && !priceTrends.equals("")){
                String[] temps = priceTrends.split(",");
                int i = Integer.parseInt(temps[0]);
                int j = Integer.parseInt(temps[1]);
                int k = Integer.parseInt(temps[2]);
                if(k>j && j>i){
                    System.out.println(entity.getCode() + "  " + entity.getDate() + "  " + entity.getPriceTrends());
                }
            }
        }
    }
}
