package com.stocks.task;

import com.message.service.MessageService;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.Response;
import com.stocks.dao.StocksDao;
import com.stocks.dao.StocksPriceDao;
import com.stocks.dto.StocksPriceDto;
import com.stocks.entity.StocksEntity;
import com.stocks.entity.StocksPriceEntity;
import com.stocks.utils.Constants;
import com.stocks.utils.DateUtils;
import com.stocks.utils.HibernateUtil;
import com.stocks.utils.NumberUtils;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-4-11
 * Time: 下午2:03
 * To change this template use File | Settings | File Templates.
 */
public class StockPriceJianKongTask {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args){
        StockPriceJianKongTask stockPriceJianKongTask = new StockPriceJianKongTask();
        stockPriceJianKongTask.execute();
    }

    public void execute(){
        logger.info("StockPriceJianKongTask  execute");

        try{
            Date now = new Date();
            Date time1 = DateUtils.strToDate(DateUtils.getSimpleDate(now) + " 11:30:00");
            Date time2 = DateUtils.strToDate(DateUtils.getSimpleDate(now) + " 13:00:00");
            Date endTime = DateUtils.strToDate(DateUtils.getSimpleDate(now) + " 15:00:00");
            StocksDao stocksDao = new StocksDao();
            List<StocksEntity> list = stocksDao.getBuySalePrice();
            MessageService messageService = new MessageService();
            while (now.before(endTime)){
                now = new Date();
                if(now.before(time1) || now.after(time2)){
                    AsyncHttpClientConfig config = new AsyncHttpClientConfig.Builder()
                            .setMaximumConnectionsPerHost(30)
                            .setMaximumConnectionsTotal(300)
                            .setConnectionTimeoutInMs(30*60*1000)
                            .setRequestTimeoutInMs(30*60*1000)
                            .build();
                    AsyncHttpClient asyncHttpClient = new AsyncHttpClient(config);
                    StringBuffer sb = new StringBuffer("http://qt.gtimg.cn/r=0.9694567599799484q=");
                    for(StocksEntity stock : list){
                        //http://qt.gtimg.cn/r=0.9694567599799484q=s_sz002340,s_sh600399,s_sh601919,s_sh600372,s_sh600868,s_sh600030,s_sz002547,s_sz000932,s_sz000089,s_sh601668,s_sh600880,s_sh601633
                        if(stock.getExchange().startsWith("沪")){
                            sb.append("s_sh").append(stock.getCode()).append(",");
                        }
                        if(stock.getExchange().startsWith("深")){
                            sb.append("s_sz").append(stock.getCode()).append(",");
                        }
                    }

                    String url = sb.substring(0, sb.length()-1);
                    logger.info("url:"+ url);
                    Future r = asyncHttpClient.prepareGet(url).execute();
                    Response response = (Response) r.get();
                    String result = response.getResponseBody();
                    logger.info(result);
                    String[] results = result.split(";");
                    Map map = new HashMap<String, StocksPriceDto>();
                    for(String rs : results){
                        if(rs.trim().equals("")){
                            continue;
                        }
                        String str = rs.substring(rs.indexOf("\"")+1, rs.lastIndexOf("\""));
                        String[] temp = str.split("~");
                        StocksPriceDto dto = new StocksPriceDto();
                        dto.setShouPan(NumberUtils.toIntMilli(temp[3]));
                        map.put(temp[2], dto);
                    }

                    for(StocksEntity stock : list){
                        StocksPriceDto dto = (StocksPriceDto)map.get(stock.getCode());
                        if(dto == null){
                            logger.info("StockPriceJianKong数据为空: " + stock.getCode());
                            continue;
                        }
                        if(stock.getBuyPrice()!=null && stock.getBuyPrice()>0){
                            if(dto.getShouPan() < stock.getBuyPrice()){
                                messageService.send("18825187648", stock.getCode());
                            }
                        }
                        if(stock.getSalePrice()!=null && stock.getSalePrice()>0){
                            if(dto.getShouPan() > stock.getSalePrice()){
                                messageService.send("18825187648", stock.getCode());
                            }
                        }
                    }
                }
                Thread.sleep(2*60*1000);
            }
        } catch (Exception e){
            logger.error("执行StockPriceJianKongTask任务异常：", e);
        }

    }

}
