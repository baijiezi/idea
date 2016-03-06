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
            DateFormat format = new SimpleDateFormat("yyyy-DD-mm");
//            Date date = format.parse("2016-03-04");
            Date date = new Date();
            date.setDate(date.getDate()-2);
            AsyncHttpClientConfig config = new AsyncHttpClientConfig.Builder()
                    .setMaximumConnectionsPerHost(30)
                    .setMaximumConnectionsTotal(300)
                    .setConnectionTimeoutInMs(3000000)
                    .setRequestTimeoutInMs(5 * 1000 * 60)
                    .build();
            AsyncHttpClient asyncHttpClient = new AsyncHttpClient(config);

            for(StocksEntity stock : list){
                logger.info("==============================开始StockDailyTask:" + stock.getName() + "    " + stock.getCode() + "===============================");
//                if(!stock.getCode().equals("000001_2")){
//                    continue;
//                }

//                if(stock.getUrl2Type() == null){
//                    stock.setUrl2Type(Constants.STOCK_PRICS_URL_TYPE_4);
//                }

                try{
                    //已指定Url
                    if(stock.getUrl2Type()!=null && stock.getUrl2Type().equals(Constants.STOCK_PRICS_URL_TYPE_1)){
                        String url = stock.getDetailUrl2();
                        logger.info("url: " + url);
                        Future r = asyncHttpClient.prepareGet(url).execute();
                        Response response = (Response) r.get();
                        String result = response.getResponseBody();
                        logger.info("result: " + result);
                        String str = result.substring(result.lastIndexOf("[")+1, result.lastIndexOf("]")).replace("\"","");
                        String[] temp = str.split(",");
                        StocksPriceDto stocksPriceDto = new StocksPriceDto();
                        stocksPriceDto.setCode(stock.getCode());
                        stocksPriceDto.setName(stock.getName());
                        stocksPriceDto.setDate(date);
                        if(stock.getName().equals("上证指数")){
                            stocksPriceDto.setShouPan(NumberUtils.toInt(temp[2]));
                        }
                        else if(stock.getName().equals("深证成指")){
                            stocksPriceDto.setShouPan(NumberUtils.toInt(temp[10]));
                        }
                        data.add(stocksPriceDto);
                    }



                    if(stock.getUrl2Type()!=null && stock.getUrl2Type().equals(Constants.STOCK_PRICS_URL_TYPE_2)){
                        String url = "http://nuff.eastmoney.com/EM_Finance2015TradeInterface/JS.ashx?id=" + stock.getCode() + "1&token=beb0a0047196124721f56b0f0ff5a27c&cb=callback08470946825109422&callback=callback08470946825109422&_=1457240176741";
                        logger.info("url:"+ url);
                        Future r = asyncHttpClient.prepareGet(url).execute();
                        Response response = (Response) r.get();
                        String result = response.getResponseBody();
                        logger.info(result);
                        String str = result.substring(result.lastIndexOf("[")+1, result.lastIndexOf("]")).replace("\"","");
                        String[] temp = str.split(",");
                        for(int v=0; v<temp.length; v++){
                            logger.info(v + " " + temp[v]);
                        }
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
                        dto.setShiYing(NumberUtils.toIntMilli(temp[38]));
                        dto.setShiJing(NumberUtils.toIntMilli(temp[43]));
                        dto.setZongShiZhi(NumberUtils.toLong(temp[46]));
                        dto.setLiuTongShiZhi(NumberUtils.toLong(temp[45]));
                        dto.setWeiBi(NumberUtils.toIntMilli(temp[41]));
                        dto.setWeiCha(NumberUtils.toIntCenti(temp[42]));
                        dto.setBuyOne1(NumberUtils.toIntMilli(temp[3]));
                        dto.setBuyOne2(NumberUtils.toIntCenti(temp[13]));
                        dto.setBuyTwo1(NumberUtils.toIntMilli(temp[4]));
                        dto.setBuyTwo2(NumberUtils.toIntCenti(temp[14]));
                        dto.setBuyThree1(NumberUtils.toIntMilli(temp[5]));
                        dto.setBuyThree2(NumberUtils.toIntCenti(temp[15]));
                        dto.setBuyFour1(NumberUtils.toIntMilli(temp[6]));
                        dto.setBuyFour2(NumberUtils.toIntCenti(temp[16]));
                        dto.setBuyFive1(NumberUtils.toIntMilli(temp[7]));
                        dto.setBuyFive2(NumberUtils.toIntCenti(temp[17]));
                        dto.setSaleOne1(NumberUtils.toIntMilli(temp[8]));
                        dto.setSaleOne2(NumberUtils.toIntCenti(temp[18]));
                        dto.setSaleTwo1(NumberUtils.toIntMilli(temp[9]));
                        dto.setSaleTwo2(NumberUtils.toIntCenti(temp[19]));
                        dto.setSaleThree1(NumberUtils.toIntMilli(temp[10]));
                        dto.setSaleThree2(NumberUtils.toIntCenti(temp[20]));
                        dto.setSaleFour1(NumberUtils.toIntMilli(temp[11]));
                        dto.setSaleFour2(NumberUtils.toIntCenti(temp[21]));
                        dto.setSaleFive1(NumberUtils.toIntMilli(temp[12]));
                        dto.setSaleFive2(NumberUtils.toIntCenti(temp[22]));

                        data.add(dto);
                    }




                    //格林美 已测试
                    if(stock.getUrl2Type()!=null && stock.getUrl2Type().equals(Constants.STOCK_PRICS_URL_TYPE_3)){
                        String url = "http://nuff.eastmoney.com/EM_Finance2015TradeInterface/JS.ashx?id=" + stock.getCode() + "2&token=beb0a0047196124721f56b0f0ff5a27c&cb=callback08212962551042438&callback=callback08212962551042438&_=1457186982524";
                        logger.info("url:"+ url);
                        Future r = asyncHttpClient.prepareGet(url).execute();
                        Response response = (Response) r.get();
                        String result = response.getResponseBody();
                        logger.info(result);
                        String str = result.substring(result.lastIndexOf("[")+1, result.lastIndexOf("]")).replace("\"","");
                        String[] temp = str.split(",");
                        for(int v=0; v<temp.length; v++){
                            logger.info(v + " " + temp[v]);
                        }
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
                        dto.setShiYing(NumberUtils.toIntMilli(temp[38]));
                        dto.setShiJing(NumberUtils.toIntMilli(temp[43]));
                        dto.setZongShiZhi(NumberUtils.toLong(temp[46]));
                        dto.setLiuTongShiZhi(NumberUtils.toLong(temp[45]));
                        dto.setWeiBi(NumberUtils.toIntMilli(temp[41]));
                        dto.setWeiCha(NumberUtils.toIntCenti(temp[42]));
                        dto.setBuyOne1(NumberUtils.toIntMilli(temp[3]));
                        dto.setBuyOne2(NumberUtils.toIntCenti(temp[13]));
                        dto.setBuyTwo1(NumberUtils.toIntMilli(temp[4]));
                        dto.setBuyTwo2(NumberUtils.toIntCenti(temp[14]));
                        dto.setBuyThree1(NumberUtils.toIntMilli(temp[5]));
                        dto.setBuyThree2(NumberUtils.toIntCenti(temp[15]));
                        dto.setBuyFour1(NumberUtils.toIntMilli(temp[6]));
                        dto.setBuyFour2(NumberUtils.toIntCenti(temp[16]));
                        dto.setBuyFive1(NumberUtils.toIntMilli(temp[7]));
                        dto.setBuyFive2(NumberUtils.toIntCenti(temp[17]));
                        dto.setSaleOne1(NumberUtils.toIntMilli(temp[8]));
                        dto.setSaleOne2(NumberUtils.toIntCenti(temp[18]));
                        dto.setSaleTwo1(NumberUtils.toIntMilli(temp[9]));
                        dto.setSaleTwo2(NumberUtils.toIntCenti(temp[19]));
                        dto.setSaleThree1(NumberUtils.toIntMilli(temp[10]));
                        dto.setSaleThree2(NumberUtils.toIntCenti(temp[20]));
                        dto.setSaleFour1(NumberUtils.toIntMilli(temp[11]));
                        dto.setSaleFour2(NumberUtils.toIntCenti(temp[21]));
                        dto.setSaleFive1(NumberUtils.toIntMilli(temp[12]));
                        dto.setSaleFive2(NumberUtils.toIntCenti(temp[22]));

                        data.add(dto);
                    }





//                    if(stock.getUrl2Type()!=null && stock.getUrl2Type()==Constants.STOCK_PRICS_URL_TYPE_4){
//                        String url = "http://hqdigi2.eastmoney.com/EM_Quote2010NumericApplication/CompatiblePage.aspx?Type=fs&jsName=js&stk="+stock.getCode()+"1&Reference=xml&rt=0.33757628477178514";
//                        logger.info("url:"+ url);
//                        Future r = asyncHttpClient.prepareGet(url).execute();
//                        Response response = (Response) r.get();
//                        String result = response.getResponseBody();
//                        logger.info("result: " + result);
//                        int idx1 = result.indexOf("{");
//                        int idx2 = result.lastIndexOf("}");
//                        String rs = result.substring(idx1, idx2+1);
//                        System.out.println(rs);
//                        JSONObject jsonObject = JSON.parseObject(rs);
//                        String[] skif = jsonObject.get("skif").toString().split(",");
//                        List<String> bsif = (List<String>)jsonObject.get("bsif");
//                        List dtif = (List)jsonObject.get("dtif");
//                        for(int i=0; i<skif.length; i++){
//                            logger.info(i + "  " + skif[i]);
//                        }
//
//                        StocksPriceDto stocksPriceDto = new StocksPriceDto();
//                        stocksPriceDto.setCode(stock.getCode());
//                        stocksPriceDto.setName(stock.getName());
//                        stocksPriceDto.setDate(date);
//                        stocksPriceDto.setShouPan(NumberUtils.toIntMilli(skif[3]));
//                        stocksPriceDto.setJunJia(NumberUtils.toIntMilli(skif[16]));
//                        stocksPriceDto.setZhangFu(NumberUtils.toIntMilli(skif[5]));
//                        stocksPriceDto.setZhangDie(NumberUtils.toIntMilli(skif[4]));
//                        stocksPriceDto.setChengJiaoLiang(NumberUtils.toLongCenti(skif[17]));
//                        stocksPriceDto.setChengJiaoE(NumberUtils.toLong(skif[19]+"万"));
//                        stocksPriceDto.setHuanShou(NumberUtils.toIntMilli(skif[12]));
//                        stocksPriceDto.setLiangBi(NumberUtils.toIntMilli(skif[14]));
//                        stocksPriceDto.setZuiGao(NumberUtils.toIntMilli(skif[10]));
//                        stocksPriceDto.setZuiDi(NumberUtils.toIntMilli(skif[11]));
//                        stocksPriceDto.setZhenFu(NumberUtils.toIntMilli(skif[15]));
//                        stocksPriceDto.setJinKai(NumberUtils.toIntMilli(skif[8]));
//                        stocksPriceDto.setZuoShou(NumberUtils.toIntMilli(skif[9]));
//                        stocksPriceDto.setZhangTing(NumberUtils.toIntMilli(""));
//                        stocksPriceDto.setDieTing(NumberUtils.toIntMilli(""));
//                        stocksPriceDto.setWaiPan(NumberUtils.toIntCenti(skif[23]));
//                        stocksPriceDto.setNeiPan(NumberUtils.toIntCenti(skif[22]));
//                        stocksPriceDto.setShiYing(NumberUtils.toIntMilli(""));
//                        stocksPriceDto.setShiJing(NumberUtils.toIntMilli(""));
//                        stocksPriceDto.setZongShiZhi(NumberUtils.toLong(""));
//                        stocksPriceDto.setLiuTongShiZhi(NumberUtils.toLong(""));
//                        stocksPriceDto.setWeiBi(NumberUtils.toIntMilli(skif[24]));
//                        stocksPriceDto.setWeiCha(NumberUtils.toIntCenti(skif[25]));
//                        stocksPriceDto.setBuyOne1(NumberUtils.toIntMilli(bsif.get(5).split(",")[0]));
//                        stocksPriceDto.setBuyOne2(NumberUtils.toIntCenti(bsif.get(5).split(",")[1]));
//                        stocksPriceDto.setBuyTwo1(NumberUtils.toIntMilli(bsif.get(6).split(",")[0]));
//                        stocksPriceDto.setBuyTwo2(NumberUtils.toIntCenti(bsif.get(6).split(",")[1]));
//                        stocksPriceDto.setBuyThree1(NumberUtils.toIntMilli(bsif.get(7).split(",")[0]));
//                        stocksPriceDto.setBuyThree2(NumberUtils.toIntCenti(bsif.get(7).split(",")[1]));
//                        stocksPriceDto.setBuyFour1(NumberUtils.toIntMilli(bsif.get(8).split(",")[0]));
//                        stocksPriceDto.setBuyFour2(NumberUtils.toIntCenti(bsif.get(8).split(",")[1]));
//                        stocksPriceDto.setBuyFive1(NumberUtils.toIntMilli(bsif.get(9).split(",")[0]));
//                        stocksPriceDto.setBuyFive2(NumberUtils.toIntCenti(bsif.get(9).split(",")[1]));
//                        stocksPriceDto.setSaleOne1(NumberUtils.toIntMilli(bsif.get(4).split(",")[0]));
//                        stocksPriceDto.setSaleOne2(NumberUtils.toIntCenti(bsif.get(4).split(",")[1]));
//                        stocksPriceDto.setSaleTwo1(NumberUtils.toIntMilli(bsif.get(3).split(",")[0]));
//                        stocksPriceDto.setSaleTwo2(NumberUtils.toIntCenti(bsif.get(3).split(",")[1]));
//                        stocksPriceDto.setSaleThree1(NumberUtils.toIntMilli(bsif.get(2).split(",")[0]));
//                        stocksPriceDto.setSaleThree2(NumberUtils.toIntCenti(bsif.get(2).split(",")[1]));
//                        stocksPriceDto.setSaleFour1(NumberUtils.toIntMilli(bsif.get(1).split(",")[0]));
//                        stocksPriceDto.setSaleFour2(NumberUtils.toIntCenti(bsif.get(1).split(",")[1]));
//                        stocksPriceDto.setSaleFive1(NumberUtils.toIntCenti(bsif.get(0).split(",")[0]));
//                        stocksPriceDto.setSaleFive2(NumberUtils.toIntMilli(bsif.get(0).split(",")[1]));
//
//                        data.add(stocksPriceDto);
//                    }





                }catch (Exception e){
                    logger.error("StockDailyTask远程异常："+stock.getCode(), e);
                }

            }
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
