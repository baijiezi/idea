package com.stocks.task;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.Response;
import com.stocks.dao.StocksDao;
import com.stocks.dao.StocksPriceDao;
import com.stocks.dto.StocksPriceDto;
import com.stocks.entity.StocksEntity;
import com.stocks.entity.StocksPriceEntity;
import com.stocks.utils.Constants;
import com.stocks.utils.HibernateUtil;
import com.stocks.utils.NumberUtils;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;

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
            List<StocksEntity> list = dao.getByDate(new Date(), session);
            Date date = new Date();

            for(StocksEntity stock : list){
                logger.info("==============================StockIndexTask:" + stock.getName() + "    " + stock.getCode() + "===============================");

                try{






                }catch (Exception e){
                    logger.error("StockIndexTask异常："+stock.getCode(), e);
                }

            }
            List codes = updateData(data);
            updateTime(codes);
            logger.info("共完成" + codes.size() + " 条");
        } catch (Exception e){
            logger.error("执行StockIndexTask任务异常：", e);
        }

    }



    private List updateData(List<StocksPriceDto> data){
        List codes = new ArrayList<String>();
        if(data==null || data.size()==0){
            return codes;
        }
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        StocksPriceDao dao = new StocksPriceDao();
        for(StocksPriceDto dto : data){
            StocksPriceEntity entity = new StocksPriceEntity();
            entity.setCode(dto.getCode());
            entity.setName(dto.getName());
            entity.setDate(dto.getDate());
            entity.setShouPan(dto.getShouPan());
            entity.setJunJia(dto.getJunJia());
            entity.setZhangFu(dto.getZhangFu());
            entity.setZhangDie(dto.getZhangDie());
            entity.setChengJiaoLiang(dto.getChengJiaoLiang());
            entity.setChengJiaoE(dto.getChengJiaoE());
            entity.setHuanShou(dto.getHuanShou());
            entity.setLiangBi(dto.getLiangBi());
            entity.setZuiGao(dto.getZuiGao());
            entity.setZuiDi(dto.getZuiDi());
            entity.setZhenFu(dto.getZhenFu());
            entity.setJinKai(dto.getJinKai());
            entity.setZuoShou(dto.getZuoShou());
            entity.setZhangTing(dto.getZhangTing());
            entity.setDieTing(dto.getDieTing());
            entity.setWaiPan(dto.getWaiPan());
            entity.setNeiPan(dto.getNeiPan());
            entity.setShiYing(dto.getShiYing());
            entity.setShiJing(dto.getShiJing());
            entity.setZongShiZhi(dto.getZongShiZhi());
            entity.setLiuTongShiZhi(dto.getLiuTongShiZhi());
            entity.setWeiBi(dto.getWeiBi());
            entity.setWeiCha(dto.getWeiCha());
            entity.setBuyOne1(dto.getBuyOne1());
            entity.setBuyOne2(dto.getBuyOne2());
            entity.setBuyTwo1(dto.getBuyTwo1());
            entity.setBuyTwo2(dto.getBuyTwo2());
            entity.setBuyThree1(dto.getBuyThree1());
            entity.setBuyThree2(dto.getBuyThree2());
            entity.setBuyFour1(dto.getBuyFour1());
            entity.setBuyFour2(dto.getBuyFour2());
            entity.setBuyFive1(dto.getBuyFive1());
            entity.setBuyFive2(dto.getBuyFive2());
            entity.setSaleOne1(dto.getSaleOne1());
            entity.setSaleOne2(dto.getSaleOne2());
            entity.setSaleTwo1(dto.getSaleTwo1());
            entity.setSaleTwo2(dto.getSaleTwo2());
            entity.setSaleThree1(dto.getSaleThree1());
            entity.setSaleThree2(dto.getSaleThree2());
            entity.setSaleFour1(dto.getSaleFour1());
            entity.setSaleFour2(dto.getSaleFour2());
            entity.setSaleFive1(dto.getSaleFive1());
            entity.setSaleFive2(dto.getSaleFive2());
            entity.setCreateTime(new Date());

            if(dao.save(entity, session)){
                codes.add(entity.getCode());
            }
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();

        return codes;
    }

    private void updateTime(List<String> codes){
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
