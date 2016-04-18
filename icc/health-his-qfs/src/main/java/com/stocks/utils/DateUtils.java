package com.stocks.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    /**
     * 把 Date 对象转成 yyyy-MM-dd 的格式
     */
    public static String getSimpleDate(Date date) {
        if (date == null) {
            return "";
        }
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(date);
        return result;
    }

    public static Date strToDate(String dateStr) {
        try {
            Date preTime = null;
            if(dateStr.length() == 10){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                preTime = sdf.parse(dateStr);
            }
            else if(dateStr.length() == 19){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                preTime = sdf.parse(dateStr);
            }
            return preTime;
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 将一个日期设置成时间是 0时 0分 0秒 的日期
     */
    public static Date getDate(Date date) {
        try{
            if (date == null) {
                return null;
            }
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dt = format.format(date);
            Date date1 = format.parse(dt);
            return date1;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
