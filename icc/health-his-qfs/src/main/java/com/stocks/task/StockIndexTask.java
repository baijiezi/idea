package com.stocks.task;

import com.stocks.dao.StocksDao;
import com.stocks.dao.StocksPriceDao;
import com.stocks.dto.StocksPriceDto;
import com.stocks.entity.StocksEntity;
import com.stocks.entity.StocksPriceEntity;
import com.stocks.utils.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-3-10
 * Time: 上午11:58
 * To change this template use File | Settings | File Templates.
 */
public class StockIndexTask {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args){
        StockIndexTask stockIndexTask = new StockIndexTask();
        stockIndexTask.execute();
    }

    public void execute(){
        logger.info("StockIndexTask  execute");

        try{
            List data = new ArrayList<StocksPriceDto>();
            StocksPriceDao dao = new StocksPriceDao();
            Map<String, StocksPriceEntity> map = new HashMap<String, StocksPriceEntity>();
            map.put("0000001_2", dao.getByDateAndCode(new Date(), "000001_2"));
            map.put("009988", dao.getByDateAndCode(new Date(), "009988"));
            List<StocksPriceEntity> list = dao.getByDate(new Date());
            Date date = new Date();

            for(StocksPriceEntity entity : list){
                logger.info("==============================StockIndexTask:" + entity.getName() + "    " + entity.getCode() + "===============================");

                try{
//                    if(entity.getStocksEntity().getExchange().equals("hs")){
//                        StocksPriceEntity sz = map.get("0000001_2");
//                        sz.setShouPan(sz.getShouPan()+entity.getShouPan());
//
//                    }
//                    else if(entity.getStocksEntity().getExchange().equals("ss")){
//                        StocksPriceEntity ss = map.get("009988");
//                        ss.setShouPan(ss.getShouPan()+entity.getShouPan());
//
//                    }






                }catch (Exception e){
                    logger.error("StockIndexTask异常："+entity.getCode(), e);
                }

            }




            Session session = HibernateUtil.getOpenSession();
            session.beginTransaction();
            dao.update((List<StocksPriceEntity>)map.values(), session);

            session.getTransaction().commit();
            session.close();
            HibernateUtil.closeSessionFactory();

            updateTime(map.keySet());

            logger.info("共完成 " + map.size() + " 条");
        } catch (Exception e){
            logger.error("执行StockIndexTask任务异常：", e);
        }

    }


    private void updateTime(Set<String> codes){
        if(codes==null || codes.size()==0){
            return;
        }
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        StocksDao dao = new StocksDao();
        Date date = new Date();
        for(String code : codes){
            StocksEntity entity = dao.getByCode(code, session);
            entity.setPriceUpdate(date);
            dao.update(entity, session);

        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }






}
