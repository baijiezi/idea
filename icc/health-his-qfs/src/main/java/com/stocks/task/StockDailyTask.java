package com.stocks.task;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.Response;
import com.stocks.dao.StocksDailyDao;
import com.stocks.dao.StocksDao;
import com.stocks.dto.StocksDailyDto;
import com.stocks.entity.StocksDailyEntity;
import com.stocks.entity.StocksEntity;
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
 * Date: 16-2-27
 * Time: 下午2:07
 * To change this template use File | Settings | File Templates.
 */
public class StockDailyTask {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args){

        StockDailyTask stockDailyTask = new StockDailyTask();
        stockDailyTask.execute();

    }

    public void execute(){
        logger.info("StockDailyTask  execute");

        try{
            List data = new ArrayList<StocksDailyDto>();
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

                if(stock.getUrl2Type()!=null && stock.getUrl2Type()==Constants.DETAIL_URL_TYPE_1){
                    String url = stock.getDetailUrl2();
                    Future r = asyncHttpClient.prepareGet(url).execute();
                    Response response = (Response) r.get();
                    String result = response.getResponseBody();
                    logger.info(result);
                    String str = result.substring(result.lastIndexOf("[")+1, result.lastIndexOf("]")).replace("\"","");
                    String[] temp = str.split(",");
                    StocksDailyDto stocksDailyDto = new StocksDailyDto();
                    stocksDailyDto.setCode(stock.getCode());
                    stocksDailyDto.setName(stock.getName());
                    stocksDailyDto.setDate(date);
                    if(stock.getName().equals("上证指数")){
                        stocksDailyDto.setShouPan(toInt(temp[2]));
                    }
                    else if(stock.getName().equals("深证成指")){
                        stocksDailyDto.setShouPan(toInt(temp[10]));
                    }
                    data.add(stocksDailyDto);
                }


                //http://nuff.eastmoney.com/EM_Finance2015TradeInterface/JS.ashx?id=0023402&token=beb0a0047196124721f56b0f0ff5a27c&cb=callback08984737466089427&callback=callback08984737466089427&_=1456623860821
                if(stock.getUrl2Type()!=null && stock.getUrl2Type()==Constants.DETAIL_URL_TYPE_2){
                    String url = stock.getDetailUrl2();
                    Future r = asyncHttpClient.prepareGet(url).execute();
                    Response response = (Response) r.get();
                    String result = response.getResponseBody();
                    logger.info(result);
                    String str = result.substring(result.lastIndexOf("[")+1, result.lastIndexOf("]")).replace("\"","");
                    String[] temp = str.split(",");
                    StocksDailyDto stocksDailyDto = new StocksDailyDto();
                    stocksDailyDto.setCode(stock.getCode());
                    stocksDailyDto.setName(stock.getName());
                    stocksDailyDto.setDate(date);
                    stocksDailyDto.setShouPan(toInt(temp[3]));
                    stocksDailyDto.setJunJia(toInt(temp[26]));
                    stocksDailyDto.setZhangFu(toInt(temp[29]));
                    stocksDailyDto.setZhangDie(toInt(temp[27]));
                    stocksDailyDto.setChengJiaoLiang(toLong(temp[31]));
                    stocksDailyDto.setChengJiaoE(toLong(temp[35]));
                    stocksDailyDto.setHuanShou(toInt(temp[37]));
                    stocksDailyDto.setLiangBi(toInt(temp[36]));
                    stocksDailyDto.setZuiGao(toInt(temp[30]));
                    stocksDailyDto.setZuiDi(toInt(temp[24]));
                    stocksDailyDto.setJinKai(toInt(temp[28]));
                    stocksDailyDto.setZuoShou(toInt(temp[34]));
                    stocksDailyDto.setZhangTing(toInt(temp[23]));
                    stocksDailyDto.setDieTing(toInt(temp[24]));
                    stocksDailyDto.setWaiPan(toInt(temp[39]));
                    stocksDailyDto.setNeiPan(toInt(temp[40]));
                    stocksDailyDto.setShiYing(toInt(temp[38]));
                    stocksDailyDto.setShiJing(toInt(temp[43]));
                    stocksDailyDto.setZongShiZhi(Long.parseLong(temp[46]));
                    stocksDailyDto.setLiuTongShiZhi(Long.parseLong(temp[45]));
                    data.add(stocksDailyDto);
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

    private void updateData(List<StocksDailyDto> data){
        if(data==null || data.size()==0){
            return;
        }
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        for(StocksDailyDto dto : data){
            StocksDailyEntity entity = new StocksDailyEntity();
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

            StocksDailyDao dao = new StocksDailyDao();
            dao.save(entity, session);
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }

}
