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
//        map.put("health_sic_stocks", "com.stocks.dao.StocksDao");
//        map.put("health_sic_fhsg", "com.stocks.dao.StocksFhsgDao");
        map.put("sic_stocks_price", "com.stocks.dao.StocksPriceDao");
//        map.put("health_sic_zjlx_dfcf", "com.stocks.dao.StocksZjlxDfcfDao");
//        map.put("health_sic_zjlx_hx", "com.stocks.dao.StocksZjlxHXDao");
//        map.put("health_sic_zjlx_zjlx_ths", "com.stocks.dao.StocksZjlxTHSDao");
        for(String key : map.keySet()){
            try{
                String daoName = map.get(key);
                IBaseDao dao = (IBaseDao)Class.forName(daoName).newInstance();
                List list = dao.exports(DateUtils.strToDate("2016-05-13"));
                for(Object obj : list){
                    Method[] methods = obj.getClass().getMethods();
                    StringBuffer result = new StringBuffer("INSERT INTO `" + key + "` VALUES (");
                    for(Method method : methods)
                    {
                        try
                        {
                            String methodName = method.getName();
                            if(methodName.startsWith("get") && !methodName.equals("getClass"))
                            {
                                String fieldName = methodName.substring(3, 4).toUpperCase() + methodName.substring(4, methodName.length());
                                Object value = method.invoke(obj, null);
                                if(value == null) {
                                    result.append("null").append(",");
                                }
                                else{
                                    result.append("'").append(value).append("',");
                                }
                            }
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                    logger.info(result.toString());
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
