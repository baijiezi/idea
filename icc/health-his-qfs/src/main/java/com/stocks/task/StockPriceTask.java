package com.stocks.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
import com.stocks.utils.NumberUtils;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
        logger.info("StockPriceTask  execute");

        try{
            List data = new ArrayList<StocksPriceDto>();
            StocksDao stocksDao = new StocksDao();
            List<StocksEntity> list = stocksDao.getAll();
            Date date = new Date();
//            date.setDate(date.getDate()-1);
            AsyncHttpClientConfig config = new AsyncHttpClientConfig.Builder()
                    .setMaximumConnectionsPerHost(30)
                    .setMaximumConnectionsTotal(300)
                    .setConnectionTimeoutInMs(20*60*1000)
                    .setRequestTimeoutInMs(5 * 1000 * 60)
                    .build();
            AsyncHttpClient asyncHttpClient = new AsyncHttpClient(config);

            for(StocksEntity stock : list){
                logger.info("==============================StockPriceTask:" + stock.getName() + "    " + stock.getCode() + "===============================");
//                if(!stock.getCode().equals("002340")){
//                    continue;
//                }

                try{
                    //已指定Url
                    if(stock.getPriceTaskType()!=null && stock.getPriceTaskType().equals(Constants.STOCK_PRICS_URL_TYPE_1)){
                        String url = "http://nufm2.dfcfw.com/EM_Finance2014NumericApplication/JS.aspx?type=CT&cmd=0000011,3990012&sty=DFPIU&st=z&sr=&p=&ps=&cb=&js=var%20C1Cache=&token=44c9d251add88e27b65ed86506f6e5da&0.9730612772982568";
                        Future r = asyncHttpClient.prepareGet(url).execute();
                        Response response = (Response) r.get();
                        String result = response.getResponseBody();
                        String str = result.substring(result.lastIndexOf("[")+1, result.lastIndexOf("]")).replace("\"","");
                        String[] temp = str.split(",");
                        StocksPriceDto stocksPriceDto = new StocksPriceDto();
                        stocksPriceDto.setCode(stock.getCode());
                        stocksPriceDto.setName(stock.getName());
                        stocksPriceDto.setDate(date);
                        if(stock.getName().equals("上证指数")){
                            stocksPriceDto.setShouPan(NumberUtils.toInt(temp[2]));
                            stocksPriceDto.setChengJiaoE(NumberUtils.toLong(temp[3]));
                            stocksPriceDto.setZhangDie(NumberUtils.toIntMilli(temp[4]));
                            stocksPriceDto.setZhangFu(NumberUtils.toIntMilli(temp[5]));
                        }
                        else if(stock.getName().equals("深证成指")){
                            stocksPriceDto.setShouPan(NumberUtils.toInt(temp[10]));
                            stocksPriceDto.setChengJiaoE(NumberUtils.toLong(temp[11]));
                            stocksPriceDto.setZhangDie(NumberUtils.toIntMilli(temp[12]));
                            stocksPriceDto.setZhangFu(NumberUtils.toIntMilli(temp[13]));
                        }
                        data.add(stocksPriceDto);
                    }



                    if(stock.getPriceTaskType()!=null && stock.getPriceTaskType().equals(Constants.STOCK_PRICS_URL_TYPE_2)){
                        String url = "http://nuff.eastmoney.com/EM_Finance2015TradeInterface/JS.ashx?id=" + stock.getCode() + "1&token=beb0a0047196124721f56b0f0ff5a27c&cb=callback08470946825109422&callback=callback08470946825109422&_=1457240176741";
                        Future r = asyncHttpClient.prepareGet(url).execute();
                        Response response = (Response) r.get();
                        String result = response.getResponseBody();
                        String str = result.substring(result.lastIndexOf("[")+1, result.lastIndexOf("]")).replace("\"","");
                        String[] temp = str.split(",");
                        StocksPriceDto dto = new StocksPriceDto();
                        dto.setCode(stock.getCode());
                        dto.setName(stock.getName());
                        dto.setDate(date);
                        dto.setShouPan(NumberUtils.toIntMilli(temp[25]));
                        dto.setJunJia(NumberUtils.toIntMilli(temp[26]));
                        dto.setZhangFu(NumberUtils.toIntMilli(temp[29]));
                        dto.setZhangDie(NumberUtils.toIntMilli(temp[27]));
                        dto.setChengJiaoLiang(NumberUtils.toLongCenti(temp[31]));
                        dto.setChengJiaoE(NumberUtils.toLong(temp[35]));
                        dto.setHuanShou(NumberUtils.toIntMilli(temp[37]));
                        dto.setLiangBi(NumberUtils.toIntMilli(temp[36]));
                        dto.setZuiGao(NumberUtils.toIntMilli(temp[30]));
                        dto.setZuiDi(NumberUtils.toIntMilli(temp[32]));
                        dto.setJinKai(NumberUtils.toIntMilli(temp[28]));
                        dto.setZuoShou(NumberUtils.toIntMilli(temp[34]));
//                        dto.setZhenFu(NumberUtils.getZhenFu(dto.getZuiGao(), dto.getZuiDi(), dto.getZuoShou()));
                        dto.setZhenFu(NumberUtils.toIntMilli(temp[50]));
                        dto.setZhangTing(NumberUtils.toIntMilli(temp[23]));
                        dto.setDieTing(NumberUtils.toIntMilli(temp[24]));
                        dto.setWaiPan(NumberUtils.toIntCenti(temp[39]));
                        dto.setNeiPan(NumberUtils.toIntCenti(temp[40]));
                        dto.setPanCha(dto.getNeiPan()-dto.getWaiPan());
                        dto.setPanBi(NumberUtils.getBiLv(dto.getPanCha(), dto.getNeiPan()+dto.getWaiPan()));
                        dto.setShiYing(NumberUtils.toLongMilli(temp[38]));
                        dto.setShiJing(NumberUtils.toLongMilli(temp[43]));
                        dto.setZongShiZhi(NumberUtils.toLong(temp[46]));
                        dto.setLiuTongShiZhi(NumberUtils.toLong(temp[45]));
                        dto.setWeiBi(NumberUtils.toIntMilli(temp[41]));
                        dto.setWeiCha(NumberUtils.toIntCenti(temp[42]));
                        data.add(dto);
                    }




                    //格林美 已测试
                    if(stock.getPriceTaskType()!=null && stock.getPriceTaskType().equals(Constants.STOCK_PRICS_URL_TYPE_3)){
                        String url = "http://nuff.eastmoney.com/EM_Finance2015TradeInterface/JS.ashx?id=" + stock.getCode() + "2&token=beb0a0047196124721f56b0f0ff5a27c&cb=callback08212962551042438&callback=callback08212962551042438&_=1457186982524";
                        Future r = asyncHttpClient.prepareGet(url).execute();
                        Response response = (Response) r.get();
                        String result = response.getResponseBody();
                        String str = result.substring(result.lastIndexOf("[")+1, result.lastIndexOf("]")).replace("\"","");
                        String[] temp = str.split(",");
                        StocksPriceDto dto = new StocksPriceDto();
                        dto.setCode(stock.getCode());
                        dto.setName(stock.getName());
                        dto.setDate(date);
                        dto.setShouPan(NumberUtils.toIntMilli(temp[25]));
                        dto.setJunJia(NumberUtils.toIntMilli(temp[26]));
                        dto.setZhangFu(NumberUtils.toIntMilli(temp[29]));
                        dto.setZhangDie(NumberUtils.toIntMilli(temp[27]));
                        dto.setChengJiaoLiang(NumberUtils.toLongCenti(temp[31]));
                        dto.setChengJiaoE(NumberUtils.toLong(temp[35]));
                        dto.setHuanShou(NumberUtils.toIntMilli(temp[37]));
                        dto.setLiangBi(NumberUtils.toIntMilli(temp[36]));
                        dto.setZuiGao(NumberUtils.toIntMilli(temp[30]));
                        dto.setZuiDi(NumberUtils.toIntMilli(temp[32]));
                        dto.setJinKai(NumberUtils.toIntMilli(temp[28]));
                        dto.setZuoShou(NumberUtils.toIntMilli(temp[34]));
//                        dto.setZhenFu(NumberUtils.getZhenFu(dto.getZuiGao(), dto.getZuiDi(), dto.getZuoShou()));
                        dto.setZhenFu(NumberUtils.toIntMilli(temp[50]));
                        dto.setZhangTing(NumberUtils.toIntMilli(temp[23]));
                        dto.setDieTing(NumberUtils.toIntMilli(temp[24]));
                        dto.setWaiPan(NumberUtils.toIntCenti(temp[39]));
                        dto.setNeiPan(NumberUtils.toIntCenti(temp[40]));
                        dto.setShiYing(NumberUtils.toLongMilli(temp[38]));
                        dto.setShiJing(NumberUtils.toLongMilli(temp[43]));
                        dto.setZongShiZhi(NumberUtils.toLong(temp[46]));
                        dto.setLiuTongShiZhi(NumberUtils.toLong(temp[45]));
                        dto.setWeiBi(NumberUtils.toIntMilli(temp[41]));
                        dto.setWeiCha(NumberUtils.toIntCenti(temp[42]));
                        dto.setPanCha(dto.getNeiPan()-dto.getWaiPan());
                        dto.setPanBi(NumberUtils.getBiLv(dto.getPanCha(), dto.getNeiPan()+dto.getWaiPan()));

                        data.add(dto);
                    }

                }catch (Exception e){
                    logger.error("StockDailyTask远程异常："+stock.getCode(), e);
                }

            }
            asyncHttpClient.close();
            List codes = updateData(data);
            updateTime(codes);
            logger.info("共完成获取价格数据" + codes.size() + " 条");
        } catch (Exception e){
            logger.error("执行StockDailyTask任务异常：", e);
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
            entity.setPanCha(dto.getPanCha());
            entity.setPanBi(dto.getPanBi());
            entity.setShiYing(dto.getShiYing());
            entity.setShiJing(dto.getShiJing());
            entity.setZongShiZhi(dto.getZongShiZhi());
            entity.setLiuTongShiZhi(dto.getLiuTongShiZhi());
            entity.setWeiBi(dto.getWeiBi());
            entity.setWeiCha(dto.getWeiCha());
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
