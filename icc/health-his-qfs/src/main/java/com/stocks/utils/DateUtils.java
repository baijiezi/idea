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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date preTime = sdf.parse(dateStr);
            return preTime;
        } catch (ParseException e) {
            return null;
        }
    }
}
