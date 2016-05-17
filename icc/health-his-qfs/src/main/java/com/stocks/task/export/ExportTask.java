package com.stocks.task.export;

import com.stocks.dao.IBaseDao;
import com.stocks.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-5-16
 * Time: 下午2:26
 * To change this template use File | Settings | File Templates.
 */
public class ExportTask {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args){
        ExportTask task = new ExportTask();
        task.execute();

    }

    public void execute(){


        Map<String, String> map = new HashMap<String, String>();
        map.put("sic_stocks", "com.stocks.dao.StocksDao");
        map.put("sic_stocks_fhsg", "com.stocks.dao.StocksFhsgDao");
        map.put("sic_stocks_price", "com.stocks.dao.StocksPriceDao");
        map.put("sic_stocks_zjlx_dfcf", "com.stocks.dao.StocksZjlxDfcfDao");
        map.put("sic_stocks_zjlx_hx", "com.stocks.dao.StocksZjlxHXDao");
        map.put("sic_stocks_zjlx_zjlx_ths", "com.stocks.dao.StocksZjlxTHSDao");
        map.put("sic_stocks_daily_kline_ma5", "com.stocks.dao.StocksDailyKLineMA5Dao");
        map.put("sic_stocks_daily_kline_ma10", "com.stocks.dao.StocksDailyKLineMA10Dao");
        map.put("sic_stocks_daily_kline_ma20", "com.stocks.dao.StocksDailyKLineMA20Dao");
        map.put("sic_stocks_daily_kline_ma30", "com.stocks.dao.StocksDailyKLineMA30Dao");
        for(String key : map.keySet()){
            try{
                logger.info("==========" + key);
                String daoName = map.get(key);
                IBaseDao dao = (IBaseDao)Class.forName(daoName).newInstance();
                List list = dao.exports(DateUtils.strToDate("2016-05-13"));
                for(Object obj : list){
                    Method method = obj.getClass().getMethod("toSql");
                    String sql = (String)method.invoke(obj, null);
                    logger.info(sql);

//                    Method[] methods = obj.getClass().getMethods();
//                    StringBuffer sb = new StringBuffer("INSERT INTO `" + key + "` VALUES (");
//                    for(Method method : methods)
//                    {
//                        try
//                        {
//                            String methodName = method.getName();
//                            logger.info("-------" + methodName);
//                            if(methodName.startsWith("get") && !methodName.equals("getClass") && !methodName.equals("getStocksEntity"))
//                            {
//                                Object value = method.invoke(obj, null);
//                                if(value == null) {
//                                    sb.append("null").append(",");
//                                }
//                                else{
//                                    sb.append("'").append(value).append("',");
//                                }
//                            }
//                        }
//                        catch (Exception e)
//                        {
//                            e.printStackTrace();
//                        }
//                    }
//                    String str = sb.substring(0, sb.length()-1);
//                    str = str + ");";
//                    logger.info(str);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
