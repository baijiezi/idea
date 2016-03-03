package com.stocks.task;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.Response;
import com.stocks.dao.StocksPriceDao;
import com.stocks.dao.StocksDao;
import com.stocks.dto.StocksPriceDto;
import com.stocks.entity.StocksEntity;
import com.stocks.entity.StocksPriceEntity;
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
 * User: BaiJiezi
 * Date: 16-3-3
 * Time: 下午6:42
 * To change this template use File | Settings | File Templates.
 */
public class StockPriceTask {


    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args){

        StockPriceTask stockDailyTask = new StockPriceTask();
        stockDailyTask.execute();

    }

    public void execute(){
        logger.info("StockDailyTask  execute");

        try{
            List data = new ArrayList<StocksPriceDto>();
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
                logger.info("开始StockDailyTask:" + stock.getCode());
                if(stock.getCode().equals("399001")){
                    logger.info("");
                }

                try{
                    if(stock.getUrl2Type()!=null && stock.getUrl2Type()== Constants.DETAIL_URL_TYPE_1){
                        String url = stock.getDetailUrl2();
                        Future r = asyncHttpClient.prepareGet(url).execute();
                        Response response = (Response) r.get();
                        String result = response.getResponseBody();
                        logger.info(result);
                        String str = result.substring(result.lastIndexOf("[")+1, result.lastIndexOf("]")).replace("\"","");
                        String[] temp = str.split(",");
                        StocksPriceDto stocksPriceDto = new StocksPriceDto();
                        stocksPriceDto.setCode(stock.getCode());
                        stocksPriceDto.setName(stock.getName());
                        stocksPriceDto.setDate(date);
                        if(stock.getName().equals("上证指数")){
                            stocksPriceDto.setShouPan(toInt(temp[2]));
                        }
                        else if(stock.getName().equals("深证成指")){
                            stocksPriceDto.setShouPan(toInt(temp[10]));
                        }
                        data.add(stocksPriceDto);
                    }


                    if(stock.getUrl2Type()!=null && stock.getUrl2Type()==Constants.DETAIL_URL_TYPE_2){
                        String url = stock.getDetailUrl2();
                        Future r = asyncHttpClient.prepareGet(url).execute();
                        Response response = (Response) r.get();
                        String result = response.getResponseBody();
                        logger.info(result);
                        String str = result.substring(result.lastIndexOf("[")+1, result.lastIndexOf("]")).replace("\"","");
                        String[] temp = str.split(",");
                        StocksPriceDto stocksPriceDto = new StocksPriceDto();
                        stocksPriceDto.setCode(stock.getCode());
                        stocksPriceDto.setName(stock.getName());
                        stocksPriceDto.setDate(date);
                        stocksPriceDto.setShouPan(toInt(temp[3]));
                        stocksPriceDto.setJunJia(toInt(temp[26]));
                        stocksPriceDto.setZhangFu(toInt(temp[29]));
                        stocksPriceDto.setZhangDie(toInt(temp[27]));
                        stocksPriceDto.setChengJiaoLiang(toLong(temp[31]));
                        stocksPriceDto.setChengJiaoE(toLong(temp[35]));
                        stocksPriceDto.setHuanShou(toInt(temp[37]));
                        stocksPriceDto.setLiangBi(toInt(temp[36]));
                        stocksPriceDto.setZuiGao(toInt(temp[30]));
                        stocksPriceDto.setZuiDi(toInt(temp[32]));
                        stocksPriceDto.setJinKai(toInt(temp[28]));
                        stocksPriceDto.setZuoShou(toInt(temp[34]));
                        stocksPriceDto.setZhangTing(toInt(temp[23]));
                        stocksPriceDto.setDieTing(toInt(temp[24]));
                        stocksPriceDto.setWaiPan(toInt(temp[39]));
                        stocksPriceDto.setNeiPan(toInt(temp[40]));
                        stocksPriceDto.setShiYing(toInt(temp[38]));
                        stocksPriceDto.setShiJing(toInt(temp[43]));
                        stocksPriceDto.setZongShiZhi(toLong(temp[46]));
                        stocksPriceDto.setLiuTongShiZhi(toLong(temp[45]));
                        data.add(stocksPriceDto);
                    }


                }catch (Exception e){
                    logger.error("StockDailyTask远程异常：" + stock.getCode());
                    logger.error(e.getMessage());
                }

            }
            updateData(data);
        } catch (Exception e){
            logger.error("执行StockDailyTask任务异常：" + e.getMessage());
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

    private void updateData(List<StocksPriceDto> data){
        if(data==null || data.size()==0){
            return;
        }
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
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

            StocksPriceDao dao = new StocksPriceDao();
            dao.save(entity, session);
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }


}
