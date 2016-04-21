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

    /**
     * 把 Date 对象转成 yyyy-MM-dd hh:mm:ss
     */
    public static String getStrTime(Date date) {
        if (date == null) {
            return "";
        }
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                preTime = sdf.parse(dateStr);
            }
            return preTime;
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取某天 0时0分0秒的时间
     */
    public static Date getDateStartTime(Date date) {
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

    /**
     * 获取日期的年份和月份
     */
    public static String getYearMonth(Date date) {
        try{
            if (date == null) {
                return null;
            }
            DateFormat format = new SimpleDateFormat("yyyy-MM-");
            String dt = format.format(date);
            return dt;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取某月1号0时0分0秒的时间
     */
    public static Date getMonthStartTime(Date date) {
        try{
            if (date == null) {
                return null;
            }
            DateFormat format = new SimpleDateFormat("yyyy-MM");
            String dt = format.format(date);
            Date date1 = format.parse(dt);
            return date1;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 日期计算
     */
    public static Date addDate(Date date, int d) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, d);
        Date dt = calendar.getTime();
        return dt;
    }

}
