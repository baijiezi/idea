package com.stocks.task;

import com.message.dao.MessageDao;
import com.message.entity.MessageEntity;

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
        map.put("sic_message", "com.message.dao.MessageDao");
        for(String entityName : map.keySet()){
            try{
                String daoName = map.get(entityName);
                MessageDao dao = (MessageDao)Class.forName(daoName).newInstance();
                List<MessageEntity> list = dao.getByStatus(0);
                for(MessageEntity entity : list){
                    Method[] methods = entity.getClass().getMethods();
                    StringBuffer result = new StringBuffer(entity.getClass().getName());
                    result.append("[");
                    int i = 0;
                    for(Method method : methods)
                    {
                        try
                        {
                            String methodName = method.getName();
                            if(methodName.startsWith("get") && !methodName.equals("getClass"))
                            {
                                String fieldName = methodName.substring(3, 4).toUpperCase() + methodName.substring(4, methodName.length());
                                String value = method.invoke(entity, null).toString();
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
