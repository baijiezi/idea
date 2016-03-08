package com.stocks.task;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.Response;
import com.stocks.dao.StocksDao;
import com.stocks.dao.StocksZJLXDao;
import com.stocks.dto.StocksZJLXDto;
import com.stocks.entity.StocksEntity;
import com.stocks.entity.StocksZJLXEntity;
import com.stocks.utils.Constants;
import com.stocks.utils.HibernateUtil;
import com.stocks.utils.NumberUtils;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-2
 * Time: 下午10:29
 * To change this template use File | Settings | File Templates.
 */
public class StockZJLXTask {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args){

        StockZJLXTask stockZJLXTask = new StockZJLXTask();
        stockZJLXTask.execute();

    }

    public void execute(){
        logger.info("StockZJLXTask  execute");

        try{
            List data = new ArrayList<StocksZJLXDto>();
            StocksDao stocksDao = new StocksDao();
            List<StocksEntity> list = stocksDao.getAll();
            Date date = new Date();
            AsyncHttpClientConfig config = new AsyncHttpClientConfig.Builder()
                    .setMaximumConnectionsPerHost(30)
                    .setMaximumConnectionsTotal(300)
                    .setConnectionTimeoutInMs(3000)
                    .setRequestTimeoutInMs(5 * 1000 * 60)
                    .build();
            AsyncHttpClient asyncHttpClient = new AsyncHttpClient(config);

            for(StocksEntity stock : list){
                logger.info("StockZJLXTask:" + stock.getCode());
                if(stock.getCode().equals("002340")){
                    logger.info("");
                }

                try{
                    if(stock.getUrl3Type()!=null && stock.getUrl3Type()==Constants.ZJLX_URL_TYPE_1){
                        String url = stock.getDetailUrl3();
                        Future r = asyncHttpClient.prepareGet(url).execute();
                        Response response = (Response) r.get();
                        String result = response.getResponseBody();
                        logger.info(result);
                        System.out.println(result.indexOf("\""));
                        System.out.println(result.indexOf("\"", 2));
                        int idx1 = result.indexOf("\"");
                        int idx2 = result.indexOf("\"", idx1+1);
                        String str = result.substring(idx1+1, idx2);
                        logger.info(str);
                        String[] temp = str.split(",");
                        for(int l=0; l<temp.length; l++){
                            logger.info(l + " " + temp[l]);
                        }
                        StocksZJLXDto zjlxDto = new StocksZJLXDto();
                        zjlxDto.setCode(stock.getCode());
                        zjlxDto.setName(stock.getName());
                        zjlxDto.setDate(date);
                        zjlxDto.setZongLiuRu(NumberUtils.toLong(temp[12] + "万")+NumberUtils.toLong(temp[14]+"万")+NumberUtils.toLong(temp[16]+"万")+NumberUtils.toLong(temp[18]+"万"));
                        zjlxDto.setZongLiuChu(NumberUtils.toLong(temp[13]+"万")+NumberUtils.toLong(temp[15]+"万")+NumberUtils.toLong(temp[17]+"万")+NumberUtils.toLong(temp[19]+"万"));
                        zjlxDto.setZongJing(NumberUtils.toLong(temp[2]+"万")+NumberUtils.toLong(temp[4]+"万")+NumberUtils.toLong(temp[6]+"万")+NumberUtils.toLong(temp[8]+"万"));
                        zjlxDto.setZhuLiLiuRu(NumberUtils.toLong(temp[12] + "万") + NumberUtils.toLong(temp[14] + "万"));
                        zjlxDto.setZhuLiLiuChu(NumberUtils.toLong(temp[13]+"万") + NumberUtils.toLong(temp[15]+"万"));
                        zjlxDto.setZhuLiJingLiuRu(NumberUtils.toLong(temp[0]+"万"));
                        zjlxDto.setZhuLiJingBi(NumberUtils.toInt(temp[1]));
                        zjlxDto.setChaoDaDanLiuRu(NumberUtils.toLong(temp[12]+"万"));
                        zjlxDto.setChaoDaDanLiuChu(NumberUtils.toLong(temp[13]+"万"));
                        zjlxDto.setChaoDaDanJingLiuRu(NumberUtils.toLong(temp[2]+"万"));
                        zjlxDto.setChaoDaDanJingBi(NumberUtils.toInt(temp[3]));
                        zjlxDto.setDaDanLiuRu(NumberUtils.toLong(temp[14]+"万"));
                        zjlxDto.setDaDanLiuChu(NumberUtils.toLong(temp[15]+"万"));
                        zjlxDto.setDaDanJingLiuRu(NumberUtils.toLong(temp[4]+"万"));
                        zjlxDto.setDaDanJingBi(NumberUtils.toInt(temp[5]));
                        zjlxDto.setZhongDanLiuRu(NumberUtils.toLong(temp[16]+"万"));
                        zjlxDto.setZhongDanLiuChu(NumberUtils.toLong(temp[17]+"万"));
                        zjlxDto.setZhongDanJingLiuRu(NumberUtils.toLong(temp[6]+"万"));
                        zjlxDto.setZhongDanJingBi(NumberUtils.toInt(temp[7]));
                        zjlxDto.setXiaoDanLiuRu(NumberUtils.toLong(temp[18]+"万"));
                        zjlxDto.setXiaoDanLiuChu(NumberUtils.toLong(temp[19]+"万"));
                        zjlxDto.setXiaoDanJingLiuRu(NumberUtils.toLong(temp[8]+"万"));
                        zjlxDto.setXiaoDanJingBi(NumberUtils.toInt(temp[9]));
                        data.add(zjlxDto);
                    }
                }catch (Exception e){
                    logger.error("StockZJLXTask远程异常：" + stock.getCode());
                    logger.error(e.getMessage());
                    e.printStackTrace();
                }
            }
            updateData(data);
        } catch (Exception e){
            logger.error("执行StockZJLXTask任务异常：" + e.getMessage());
            e.printStackTrace();
        }

    }


    private void updateData(List<StocksZJLXDto> data){
        if(data==null || data.size()==0){
            return;
        }
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        for(StocksZJLXDto dto : data){
            StocksZJLXEntity entity = new StocksZJLXEntity();
            entity.setCode(dto.getCode());
            entity.setName(dto.getName());
            entity.setDate(dto.getDate());
            entity.setZongLiuRu(dto.getZongLiuRu());
            entity.setZongLiuChu(dto.getZongLiuChu());
            entity.setZongJing(dto.getZongJing());
            entity.setZhuLiLiuRu(dto.getZhuLiLiuRu());
            entity.setZhuLiLiuChu(dto.getZhuLiLiuChu());
            entity.setZhuLiJingLiuRu(dto.getZhuLiJingLiuRu());
            entity.setZhuLiJingBi(dto.getZhuLiJingBi());
            entity.setChaoDaDanLiuRu(dto.getChaoDaDanLiuRu());
            entity.setChaoDaDanLiuChu(dto.getChaoDaDanLiuChu());
            entity.setChaoDaDanJingLiuRu(dto.getChaoDaDanJingLiuRu());
            entity.setChaoDaDanJingBi(dto.getChaoDaDanJingBi());
            entity.setDaDanLiuRu(dto.getDaDanLiuRu());
            entity.setDaDanLiuChu(dto.getDaDanLiuChu());
            entity.setDaDanJingLiuRu(dto.getDaDanJingLiuRu());
            entity.setDaDanJingBi(dto.getDaDanJingBi());
            entity.setZhongDanLiuRu(dto.getZhongDanLiuRu());
            entity.setZhongDanLiuChu(dto.getZhongDanLiuChu());
            entity.setZhongDanJingLiuRu(dto.getZhongDanJingLiuRu());
            entity.setZhongDanJingBi(dto.getZhongDanJingBi());
            entity.setXiaoDanLiuRu(dto.getXiaoDanLiuRu());
            entity.setXiaoDanLiuChu(dto.getXiaoDanLiuChu());
            entity.setXiaoDanJingLiuRu(dto.getXiaoDanJingLiuRu());
            entity.setXiaoDanJingBi(dto.getXiaoDanJingBi());

            StocksZJLXDao dao = new StocksZJLXDao();
            dao.save(entity, session);
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }



}