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
     * 把  yyyy-MM-dd HH:mm:ss的格式转成 Date
     */
    public static Date stringToDate(String source) {
        if(source==null || source.equals("")){
            return null;
        }
        if (source.length() == 10) {
            source = source + " 00:00:00";
        }
        if (source.length() == 16) {
            source = source + ":00";
        }
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 把  yyyy-MM-dd HH:mm:ss的格式转成 Date
     */
    public static Date stringToDate2(String source) {
        if(source==null || source.equals("")){
            return null;
        }
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        try {
            date = format.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 把  yyyy-MM-dd HH:mm:ss的格式转成 Date
     */
    public static Date stringToDate(String source,String pattern) {
        DateFormat format = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = format.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date xmlDateStringtoDate(String source) {
        //2014-04-28T00:00:00+08:00
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 把  Date 的格式转成 yyyy-MM-dd HH:mm:ss
     */
    public static String dateToString(Date date) {
        String str = null;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            str = format.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 把  Date 的格式转成 fmt 格式
     */
    public static String dateToString(Date date, String fmt) {
        String str = null;
        DateFormat format = new SimpleDateFormat(fmt);
        try {
            str = format.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 返回两个日期之间所有日期的连续字符串
     */
    public static String getStringDate(String startdate, String enddate) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        StringBuffer strDate = new StringBuffer(startdate);
        try {
            Calendar calendar = GregorianCalendar.getInstance();
            calendar.setTime(format.parse(startdate));
            Date endTime = format.parse(enddate);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            while (!calendar.getTime().after(endTime)) {
                strDate.append(",").append(format.format(calendar.getTime()));
                calendar.add(Calendar.DAY_OF_MONTH, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strDate.toString();
    }

    public static boolean sameDate(Date date, Date otherDate) {
        Calendar calendar = GregorianCalendar.getInstance();
        Calendar otherCalendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        otherCalendar.setTime(otherDate);

        return (calendar.get(Calendar.DAY_OF_YEAR) == otherCalendar.get(Calendar.DAY_OF_YEAR));
    }

    public static boolean isShortDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            sdf.parse(dateStr);
            return Boolean.TRUE;
        } catch (ParseException e) {
            return Boolean.FALSE;
        }

    }

    public static boolean isShortMonth(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        try {
            sdf.parse(dateStr);
            return Boolean.TRUE;
        } catch (ParseException e) {
            return Boolean.FALSE;
        }

    }

    public static String getNextDay(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date preTime = sdf.parse(dateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(preTime);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            return sdf.format(calendar.getTime());
        } catch (ParseException e) {
            return dateStr;
        }
    }


    public static String getAddNumberDay(String dateStr,Integer number) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date preTime = sdf.parse(dateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(preTime);
            calendar.add(Calendar.DAY_OF_MONTH, number);
            return sdf.format(calendar.getTime());
        } catch (ParseException e) {
            return dateStr;
        }
    }

    public static String getNextDay() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            return sdf.format(calendar.getTime());
        } catch (Exception e) {
            return null;
        }
    }



    public static String getNextMonTH(String monthStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        try {
            Date preTime = sdf.parse(monthStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(preTime);
            calendar.add(Calendar.MONTH, 1);
            return sdf.format(calendar.getTime());
        } catch (ParseException e) {
            return monthStr;
        }
    }

    public static Date getToDay(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date preTime = sdf.parse(dateStr);
            return preTime;
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date getStrToDay(String dateStr, String fmt) {
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        try {
            return sdf.parse(dateStr);
        } catch (Exception e) {
            return new Date();
        }
    }

    public static String addDay(String dateStr, int days) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date preTime = sdf.parse(dateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(preTime);
            calendar.add(Calendar.DAY_OF_MONTH, days);
            return sdf.format(calendar.getTime());
        } catch (ParseException e) {
            return dateStr;
        }
    }

    public static String formatDate(Date date, String fmt) {
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        try {
            return sdf.format(date);
        } catch (Exception e) {
            return sdf.format(new Date());
        }
    }

    /**
     * 字符串的日期格式的计算
     */
    public static int daysBetween(String smdate, String bdate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(smdate));
            long time1 = cal.getTimeInMillis();
            cal.setTime(sdf.parse(bdate));
            long time2 = cal.getTimeInMillis();
            long between_days = (time2 - time1) / (1000 * 3600 * 24);

            return Integer.parseInt(String.valueOf(between_days));
        } catch (ParseException e) {
            return 7;
        }
    }

    /**
     * 获取当前日期是星期几<br>
     *
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;

        return weekDays[w];
    }

    /**
     * 根据用户生日计算年龄
     */
    public static int getAgeByBirthday(Date birthday) {
        if(birthday==null){
            return 0;
        }
        Calendar cal = Calendar.getInstance();

        if (cal.before(birthday)) {
            return 0;
        }

        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

        cal.setTime(birthday);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                // monthNow==monthBirth
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }
            } else {
                // monthNow>monthBirth
                age--;
            }
        }
        return age;
    }

    /**
     * 把 yyyy-MM-dd转成 yyyyMMdd 的格式
     */
    public static String getSimpleDate(String date) {
        String result = "";
        try{
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date d = format.parse(date);

            DateFormat format2 = new SimpleDateFormat("yyyyMMdd");
            result = format2.format(d);
        }catch (Exception e){

        }

        return result;
    }

    /**
     * 判断两个日期是否同一天
     * @param date1
     * @param date2
     * @return
     */
    public  static boolean isSameDate(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
                && cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
    }
}
