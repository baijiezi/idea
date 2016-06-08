package com.stocks.task;

import com.message.dao.MessageDao;
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
            MessageDao messageDao = new MessageDao();
            List<StocksEntity> list = getStocks();
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
                    for(StocksEntity entity : list){
                        //http://qt.gtimg.cn/r=0.9694567599799484q=s_sz002340,s_sh600399,s_sh601919,s_sh600372,s_sh600868,s_sh600030,s_sz002547,s_sz000932,s_sz000089,s_sh601668,s_sh600880,s_sh601633
                        if(entity.getExchange().equals("sh") || entity.getExchange().startsWith("沪")){
                            sb.append("s_sh").append(entity.getCode()).append(",");
                        }
                        if(entity.getExchange().equals("sz") || entity.getExchange().startsWith("深")){
                            sb.append("s_sz").append(entity.getCode()).append(",");
                        }
                    }

                    String url = sb.substring(0, sb.length()-1);
                    Future r = asyncHttpClient.prepareGet(url).execute();
                    Response response = (Response) r.get();
                    String result = response.getResponseBody();
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
                        dto.setName(temp[1]);
                        map.put(temp[2], dto);
                    }

                    for(StocksEntity entity : list){
                        StocksPriceDto dto = (StocksPriceDto)map.get(entity.getCode());
                        if(dto == null){
                            logger.info("StockPriceJianKong数据为空: " + entity.getCode());
                            continue;
                        }
                        if(entity.getBuyPrice()!=null && entity.getBuyPrice()>0){
                            if(dto.getShouPan()>0 && dto.getShouPan()<entity.getBuyPrice()){
                                List messageList = messageDao.getByTypeAndSendTime(entity.getCode(), DateUtils.getSimpleDate(new Date()));
                                if(messageList==null || messageList.size()==0){
                                    messageService.send("18825187648", dto.getName().substring(0,1)+entity.getCode()+"B"+dto.getShouPan(), entity.getCode());
                                }
                            }
                        }
                        if(entity.getSalePrice()!=null && entity.getSalePrice()>0){
                            if(dto.getShouPan() > entity.getSalePrice()){
                                List messageList = messageDao.getByTypeAndSendTime(entity.getCode(), DateUtils.getSimpleDate(new Date()));
                                if(messageList==null || messageList.size()==0){
                                    messageService.send("18825187648", dto.getName().substring(0,1)+entity.getCode()+"S"+dto.getShouPan(), entity.getCode());
                                }
                            }
                        }
                    }
                    asyncHttpClient.close();
                }
                Thread.sleep(1*60*1000);
            }
        } catch (Exception e){
            logger.error("执行StockPriceJianKongTask任务异常：", e);
        }
        logger.info("执行StockPriceJianKongTask任务结束");
    }

    public List<StocksEntity> getStocks(){
        //从数据库获取
//        StocksDao stocksDao = new StocksDao();
//        return stocksDao.getBuySalePrice();


        //从文件读取
        List<StocksEntity> data = new ArrayList<StocksEntity>();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("file/a.txt").getFile());
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.trim().equals("")){
                    continue;
                }
                String[] temp = line.split(",");
                if(!temp[2].equals("0") || !temp[3].equals("0")){
                    StocksEntity entity = new StocksEntity();
                    entity.setCode(temp[0]);
                    entity.setExchange(temp[1]);
                    entity.setBuyPrice(Integer.valueOf(temp[2]));
                    entity.setSalePrice(Integer.valueOf(temp[3]));
                    data.add(entity);
                }
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;

    }

}
