package com.stocks.task;

import com.message.dao.MessageDao;
import com.message.entity.MessageEntity;
import com.stocks.dao.IBaseDao;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-5-12
 * Time: 下午5:32
 * To change this template use File | Settings | File Templates.
 */
public class DeptTaskTest {
    public static void main(String[] args){

        Map<String, String> map = new HashMap<String, String>();
        map.put("health_sic_stocks", "com.stocks.dao.StocksDao");
        map.put("health_sic_fhsg", "com.stocks.dao.StocksFhsgDao");
        map.put("health_sic_price", "com.stocks.dao.StocksPriceDao");
        map.put("health_sic_zjlx_dfcf", "com.stocks.dao.StocksZjlxDfcfDao");
        map.put("health_sic_zjlx_hx", "com.stocks.dao.StocksZjlxHXDao");
        map.put("health_sic_zjlx_zjlx_ths", "com.stocks.dao.StocksZjlxTHSDao");
        for(String key : map.keySet()){
            try{
                String daoName = map.get(key);
                IBaseDao dao = (MessageDao)Class.forName(daoName).newInstance();
                List list = dao.exports();
                for(Object obj : list){
                    Method[] methods = obj.getClass().getMethods();
                    StringBuffer result = new StringBuffer(obj.getClass().getName());
                    result.append("[");
                    int i = 0;
                    for(Method method : methods)
                    {
                        try
                        {
                            String methodName = method.getName();
                            System.out.println(methodName);
                            if(methodName.startsWith("get") && !methodName.equals("getClass"))
                            {
                                String fieldName = methodName.substring(3, 4).toUpperCase() + methodName.substring(4, methodName.length());
                                Object value = method.invoke(obj, null);
                                if(i > 0)
                                    result.append(", ");
                                result.append(fieldName).append("=").append(value);
                                i++;
                            }
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                    result.append("]");
                    System.out.println(result);

                }

            } catch (Exception e){
                e.printStackTrace();
            }





        }




    }


}
