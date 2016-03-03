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
                        zjlxDto.setZhuLiLiuRu(toLong(temp[12] + "万") + toLong(temp[14] + "万"));
                        zjlxDto.setZhuLiLiuChu(toLong(temp[13]+"万") + toLong(temp[15]+"万"));
                        zjlxDto.setZhuLiJingLiuRu(toLong(temp[0]+"万"));
                        zjlxDto.setChaoDaLiuRu(toLong(temp[12]+"万"));
                        zjlxDto.setChaoDaLiuChu(toLong(temp[13]+"万"));
                        zjlxDto.setJingChaoDa(toLong(temp[2]+"万"));
                        zjlxDto.setDaDanLiuRu(toLong(temp[14]+"万"));
                        zjlxDto.setDaDanLiuChu(toLong(temp[15]+"万"));
                        zjlxDto.setJingDaDan(toLong(temp[4]+"万"));
                        zjlxDto.setZhongDanLiuRu(toLong(temp[16]+"万"));
                        zjlxDto.setZhongDanLiuChu(toLong(temp[17]+"万"));
                        zjlxDto.setJingZhongDan(toLong(temp[6]+"万"));
                        zjlxDto.setXiaoDanLiuRu(toLong(temp[18]+"万"));
                        zjlxDto.setXiaoDanLiuChu(toLong(temp[19]+"万"));
                        zjlxDto.setJingXiaoDan(toLong(temp[8]+"万"));
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

    public int toInt(String str){
        if(str==null || str.equals("")){
            return 0;
        }
        if(str.contains("万")){
            String s = str.replace("万", "");
            BigDecimal b = new BigDecimal(s);
            BigDecimal v = b.multiply(new BigDecimal(10000));
            return v.intValue();
        }
        BigDecimal b = new BigDecimal(str);
        BigDecimal v = b.multiply(new BigDecimal(100));
        return v.intValue();
    }


    public long toLong(String str){
        if(str==null || str.equals("")){
            return 0;
        }
        if(str.contains("万")){
            String s = str.replace("万", "");
            BigDecimal bigDecimal = new BigDecimal(s);
            return bigDecimal.multiply(new BigDecimal(10000)).multiply(new BigDecimal(100)).longValue();
        }
        if(str.contains("亿")){
            String s = str.replace("亿", "");
            BigDecimal bigDecimal = new BigDecimal(s);
            return bigDecimal.multiply(new BigDecimal(100000000)).multiply(new BigDecimal(100)).longValue();
        }
        BigDecimal b = new BigDecimal(str);
        BigDecimal v = b.multiply(new BigDecimal(100));
        return v.longValue();
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
            entity.setZhuLiLiuRu(dto.getZhuLiLiuRu());
            entity.setZhuLiLiuChu(dto.getZhuLiLiuChu());
            entity.setZhuLiJingLiuRu(dto.getZhuLiJingLiuRu());
            entity.setChaoDaLiuRu(dto.getChaoDaLiuRu());
            entity.setChaoDaLiuChu(dto.getChaoDaLiuChu());
            entity.setJingChaoDa(dto.getJingChaoDa());
            entity.setDaDanLiuRu(dto.getDaDanLiuRu());
            entity.setDaDanLiuChu(dto.getDaDanLiuChu());
            entity.setJingDaDan(dto.getJingDaDan());
            entity.setZhongDanLiuRu(dto.getZhongDanLiuRu());
            entity.setZhongDanLiuChu(dto.getZhongDanLiuChu());
            entity.setJingZhongDan(dto.getJingZhongDan());
            entity.setXiaoDanLiuRu(dto.getXiaoDanLiuRu());
            entity.setXiaoDanLiuChu(dto.getXiaoDanLiuChu());
            entity.setJingXiaoDan(dto.getJingXiaoDan());

            StocksZJLXDao dao = new StocksZJLXDao();
            dao.save(entity, session);
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }



}
