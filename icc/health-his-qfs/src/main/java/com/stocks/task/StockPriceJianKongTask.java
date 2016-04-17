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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
            MessageService messageService = new MessageService();
            while (now.before(endTime)){
                if(now.before(time1) || now.after(time2)){
                    StocksDao stocksDao = new StocksDao();
                    List<StocksEntity> list = stocksDao.getBuySalePrice();
                    AsyncHttpClientConfig config = new AsyncHttpClientConfig.Builder()
                            .setMaximumConnectionsPerHost(30)
                            .setMaximumConnectionsTotal(300)
                            .setConnectionTimeoutInMs(20*60*1000)
                            .setRequestTimeoutInMs(5*60*1000)
                            .build();
                    AsyncHttpClient asyncHttpClient = new AsyncHttpClient(config);

                    for(StocksEntity stock : list){
                        logger.info("==============================StockPriceJianKongTask:" + stock.getName() + "    " + stock.getCode() + "===============================");
                        //http://qt.gtimg.cn/r=0.9694567599799484q=s_sz002340,s_sh600399,s_sh601919,s_sh600372,s_sh600868,s_sh600030,s_sz002547,s_sz000932,s_sz000089,s_sh601668,s_sh600880,s_sh601633
                        try{
                            StocksPriceDto dto = new StocksPriceDto();
                            if(stock.getPriceTaskType()!=null && stock.getPriceTaskType().equals(Constants.STOCK_PRICS_URL_TYPE_2)){
                                String url = "http://qt.gtimg.cn/r=0.9694567599799484q=s_sh" + stock.getCode();
                                logger.info("url:"+ url);
                                Future r = asyncHttpClient.prepareGet(url).execute();
                                Response response = (Response) r.get();
                                String result = response.getResponseBody();
                                logger.info(result);
                                String str = result.substring(result.indexOf("\"")+1, result.lastIndexOf("\""));
                                String[] temp = str.split("~");
                                for(int v=0; v<temp.length; v++){
                                    logger.info(v + " " + temp[v]);
                                }
                                dto.setShouPan(NumberUtils.toIntMilli(temp[3]));
                            }

                            if(stock.getPriceTaskType()!=null && stock.getPriceTaskType().equals(Constants.STOCK_PRICS_URL_TYPE_3)){
                                String url = "http://qt.gtimg.cn/r=0.9694567599799484q=s_sz" + stock.getCode();
                                logger.info("url:"+ url);
                                Future r = asyncHttpClient.prepareGet(url).execute();
                                Response response = (Response) r.get();
                                String result = response.getResponseBody();
                                logger.info(result);
                                String str = result.substring(result.indexOf("\"")+1, result.lastIndexOf("\""));
                                String[] temp = str.split("~");
                                for(int v=0; v<temp.length; v++){
                                    logger.info(v + " " + temp[v]);
                                }
                                dto.setShouPan(NumberUtils.toIntMilli(temp[3]));
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

                        }catch (Exception e){
                            logger.error("StockPriceJianKongTask远程异常："+stock.getCode(), e);
                        }

                    }
                }
                Thread.sleep(5*60*1000);
            }
        } catch (Exception e){
            logger.error("执行StockDailyTask任务异常：", e);
        }

    }

}
