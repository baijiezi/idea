package com.stocks.task;

import com.message.dao.MessageDao;
import com.message.service.MessageService;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.Response;
import com.stocks.dao.StocksDao;
import com.stocks.dao.StocksPriceDao;
import com.stocks.dao.StocksPriceSimpleDao;
import com.stocks.dao.StocksQuanZhongDao;
import com.stocks.entity.StocksEntity;
import com.stocks.entity.StocksPriceSimpleEntity;
import com.stocks.entity.StocksQuanZhongEntity;
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
 * User: Administrator
 * Date: 17-2-21
 * Time: 下午3:12
 * To change this template use File | Settings | File Templates.
 */
public class StockPriceSimpleTask {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args){
        StockPriceSimpleTask stockDailyTask2 = new StockPriceSimpleTask();
        stockDailyTask2.execute();
    }

    public void execute(){
        logger.info("StockPriceSimpleTask  execute");

        try{
            Map<String, Integer> map = new HashMap<String, Integer>();
            StocksQuanZhongDao quanZhongDao = new StocksQuanZhongDao();
            List<StocksQuanZhongEntity> li = quanZhongDao.getAll();
            for(StocksQuanZhongEntity entity : li){
                map.put(entity.getType()+entity.getKeyName(), entity.getValue());
            }

            List<StocksPriceSimpleEntity> data = new ArrayList<StocksPriceSimpleEntity>();
            StocksPriceDao priceDao = new StocksPriceDao();
            StocksDao stocksDao = new StocksDao();
            StringBuffer content = new StringBuffer("");
            Session session = HibernateUtil.getOpenSession();
            List<StocksEntity> list = stocksDao.getAll();

//            StocksEntity ent = stocksDao.getByCode("600418");
//            List<StocksEntity> list = new ArrayList<StocksEntity>();
//            list.add(ent);

            Date date = new Date();
            AsyncHttpClientConfig config = new AsyncHttpClientConfig.Builder()
                    .setMaximumConnectionsPerHost(30)
                    .setMaximumConnectionsTotal(300)
                    .setConnectionTimeoutInMs(20*60*1000)
                    .setRequestTimeoutInMs(5 * 1000 * 60)
                    .build();
            AsyncHttpClient asyncHttpClient = new AsyncHttpClient(config);

            for(StocksEntity stock : list){
                logger.info("==============================StockPriceSimpleTask:" + stock.getName() + "    " + stock.getCode() + "===============================");
                try{
                    StocksPriceSimpleEntity entity = null;
                    //已指定Url
                    if(stock.getPriceTaskType()!=null && stock.getPriceTaskType().equals(Constants.STOCK_PRICS_URL_TYPE_1)){
                        String url = "http://nufm2.dfcfw.com/EM_Finance2014NumericApplication/JS.aspx?type=CT&cmd=0000011,3990012&sty=DFPIU&st=z&sr=&p=&ps=&cb=&js=var%20C1Cache=&token=44c9d251add88e27b65ed86506f6e5da&0.9730612772982568";
                        Future r = asyncHttpClient.prepareGet(url).execute();
                        Response response = (Response) r.get();
                        String result = response.getResponseBody();
                        String str = result.substring(result.lastIndexOf("[")+1, result.lastIndexOf("]")).replace("\"","");
                        String[] temp = str.split(",");
                        entity = new StocksPriceSimpleEntity();
                        entity.setCode(stock.getCode());
                        entity.setName(stock.getName());
                        entity.setDate(date);
                        if(stock.getName().equals("上证指数")){
                            entity.setShouPan(NumberUtils.toInt(temp[2]));
                            entity.setZhangFu(NumberUtils.toIntMilli(temp[5]));
                            entity.setZhangDie(NumberUtils.toIntMilli(temp[4]));
                        }
                        else if(stock.getName().equals("深证成指")){
                            entity.setShouPan(NumberUtils.toInt(temp[10]));
                            entity.setZhangFu(NumberUtils.toIntMilli(temp[13]));
                            entity.setZhangDie(NumberUtils.toIntMilli(temp[12]));
                        }
                    }

                    if(stock.getPriceTaskType()!=null && stock.getPriceTaskType().equals(Constants.STOCK_PRICS_URL_TYPE_2)){
                        String url = "http://nuff.eastmoney.com/EM_Finance2015TradeInterface/JS.ashx?id=" + stock.getCode() + "1&token=beb0a0047196124721f56b0f0ff5a27c&cb=callback08470946825109422&callback=callback08470946825109422&_=1457240176741";
                        Future r = asyncHttpClient.prepareGet(url).execute();
                        Response response = (Response) r.get();
                        String result = response.getResponseBody();
                        String str = result.substring(result.lastIndexOf("[")+1, result.lastIndexOf("]")).replace("\"","");
                        String[] temp = str.split(",");
                        entity = new StocksPriceSimpleEntity();
                        entity.setCode(stock.getCode());
                        entity.setName(stock.getName());
                        entity.setDate(date);
                        entity.setShouPan(NumberUtils.toIntMilli(temp[25]));
                        entity.setZhangFu(NumberUtils.toIntMilli(temp[29]));
                        entity.setZhangDie(NumberUtils.toIntMilli(temp[27]));
                    }

                    //格林美 已测试
                    if(stock.getPriceTaskType()!=null && stock.getPriceTaskType().equals(Constants.STOCK_PRICS_URL_TYPE_3)){
                        String url = "http://nuff.eastmoney.com/EM_Finance2015TradeInterface/JS.ashx?id=" + stock.getCode() + "2&token=beb0a0047196124721f56b0f0ff5a27c&cb=callback08212962551042438&callback=callback08212962551042438&_=1457186982524";
                        Future r = asyncHttpClient.prepareGet(url).execute();
                        Response response = (Response) r.get();
                        String result = response.getResponseBody();
                        String str = result.substring(result.lastIndexOf("[")+1, result.lastIndexOf("]")).replace("\"","");
                        String[] temp = str.split(",");
                        entity = new StocksPriceSimpleEntity();
                        entity.setCode(stock.getCode());
                        entity.setName(stock.getName());
                        entity.setDate(date);
                        entity.setShouPan(NumberUtils.toIntMilli(temp[25]));
                        entity.setZhangFu(NumberUtils.toIntMilli(temp[29]));
                        entity.setZhangDie(NumberUtils.toIntMilli(temp[27]));
                    }

                    if(entity!=null && entity.getShouPan()!=null && entity.getShouPan()!=0){
                        Integer sum4 = priceDao.getSUM4(stock.getCode(), DateUtils.getSimpleDate(date), session);
                        entity.setShouPanMa5( (sum4 + entity.getShouPan() ) / 5 );
                        Integer sum9 = priceDao.getSUM9(stock.getCode(), DateUtils.getSimpleDate(date), session);
                        entity.setShouPanMa10( (sum9 + entity.getShouPan() ) / 10 );
                        Integer sum19 = priceDao.getSUM19(stock.getCode(), DateUtils.getSimpleDate(date), session);
                        entity.setShouPanMa20( (sum19 + entity.getShouPan() ) / 20 );
                        Integer sum29 = priceDao.getSUM29(stock.getCode(), DateUtils.getSimpleDate(date), session);
                        entity.setShouPanMa30( (sum29 + entity.getShouPan() ) / 30 );
                        Integer sum59 = priceDao.getSUM59(stock.getCode(), DateUtils.getSimpleDate(date), session);
                        entity.setShouPanMa60( (sum59 + entity.getShouPan() ) / 60 );
                        Integer jxpl = jxpl(entity.getShouPan(), entity.getShouPanMa5(), entity.getShouPanMa10(), entity.getShouPanMa20(), entity.getShouPanMa30(), entity.getShouPanMa60());
                        entity.setJunXianPaiLie(jxpl);
                        data.add(entity);

                        Integer sumzhangDie4 = priceDao.getSUMZhangDie4(stock.getCode(), DateUtils.getSimpleDate(date), session);
                        Integer sumzhangDie9 = priceDao.getSUMZhangDie9(stock.getCode(), DateUtils.getSimpleDate(date), session);
                        Integer sumzhangDie19 = priceDao.getSUMZhangDie19(stock.getCode(), DateUtils.getSimpleDate(date), session);
                        Integer sumzhangDie29 = priceDao.getSUMZhangDie29(stock.getCode(), DateUtils.getSimpleDate(date), session);
                        Integer sumzhangDie59 = priceDao.getSUMZhangDie59(stock.getCode(), DateUtils.getSimpleDate(date), session);
                        Integer jxzx = jxzx(entity.getZhangFu(), sumzhangDie4 + entity.getZhangFu(), sumzhangDie9 + entity.getZhangFu(),
                                sumzhangDie19 + entity.getZhangFu(), sumzhangDie29 + entity.getZhangFu(), sumzhangDie59 + entity.getZhangFu());
                        entity.setJunXianZouXiang(jxzx);

                        String code = entity.getCode();
                        if((code.startsWith("600")||code.startsWith("601")) && map.get("jxpl_600.601_6"+jxpl)>50000 && map.get("jxzx_600.601_6"+jxzx)>50000){
                            content.append(entity.getCode()).append(map.get("jxpl_600.601_6"+jxpl)).append(" ").append(map.get("jxzx_600.601_6"+jxzx)).append(",");
                        }
                        if((code.startsWith("000")||code.startsWith("002")) && map.get("jxpl_000.002_6"+jxpl)>50000 && map.get("jxzx_000.002_6"+jxzx)>50000){
                            content.append(entity.getCode()).append(map.get("jxpl_000.002_6"+jxpl)).append(" ").append(map.get("jxzx_000.002_6"+jxzx)).append(",");
                        }
                    }

                }catch (Exception e){
                    logger.error("StockPriceSimpleTask远程异常："+stock.getCode(), e);
                }

            }
            asyncHttpClient.close();
            if(!content.toString().equals("")){
                logger.info("开始发送信息：" + content);
                MessageService messageService = new MessageService();
                messageService.send("18825187648", content.toString(), Constants.MESSAGE_TYPE_JXPL);
            }
            updateData(data);
            logger.info("共完成获取StockPriceSimpleTask数据" + data.size() + " 条");
        } catch (Exception e){
            logger.error("执行StockPriceSimpleTask任务异常：", e);
        }

    }



    private void updateData(List<StocksPriceSimpleEntity> data){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        StocksPriceSimpleDao dao = new StocksPriceSimpleDao();
        for(StocksPriceSimpleEntity entity : data){
            dao.save(entity, session);
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }

    private Integer jxpl(Integer shouPan, Integer ma5, Integer ma10, Integer ma20, Integer ma30, Integer ma60){
        int[] a = new int[6];
        a[0] = shouPan * 10 + 1;
        a[1] = ma5 * 10 + 2;
        a[2] = ma10 * 10 + 3;
        a[3] = ma20 * 10 + 4;
        a[4] = ma30 * 10 + 5;
        a[5] = ma60 * 10 + 6;
        selectSort(a);
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<a.length; i++){
            String s = String.valueOf(a[i]);
            sb.append(s.substring(s.length()-1));
        }
        return Integer.parseInt(sb.toString());
    }

    // 选择排序法   将要排序的对象分作两部份，一个是已排序的，一个是未排序的，从后端未排序部份选择一个最小值，并放入前端已排序部份的最后一个。
    public void selectSort(int[] a){
        int position=0;
        for(int i=0;i<a.length;i++){

            int j=i+1;
            position=i;
            int temp=a[i];
            for(;j<a.length;j++){
                if(a[j]>temp){
                    temp=a[j];
                    position=j;
                }
            }
            a[position]=a[i];
            a[i]=temp;
        }
    }

    private Integer jxzx(Integer zhangFu, Integer zhangFuMa5, Integer zhangFuMa10, Integer zhangFuMa20, Integer zhangFuMa30, Integer zhangFuMa60){
        StringBuffer sb = new StringBuffer();
        if (zhangFu > 0){
            sb.append("1");
        } else{
            sb.append("2");
        }
        if (zhangFuMa5 > 0){
            sb.append("1");
        } else{
            sb.append("2");
        }
        if (zhangFuMa10 > 0){
            sb.append("1");
        } else{
            sb.append("2");
        }
        if (zhangFuMa20 > 0){
            sb.append("1");
        } else{
            sb.append("2");
        }
        if (zhangFuMa30 > 0){
            sb.append("1");
        } else{
            sb.append("2");
        }
        if (zhangFuMa60 > 0){
            sb.append("1");
        } else{
            sb.append("2");
        }
        return Integer.parseInt(sb.toString());
    }
}
