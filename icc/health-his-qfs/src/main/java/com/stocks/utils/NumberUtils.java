package com.stocks.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-5
 * Time: 下午3:31
 * To change this template use File | Settings | File Templates.
 */
public class NumberUtils {

    //单位：个，元
    public static int toInt(String str){
        if(str==null || str.equals("") || str.equals("null") || str.equals("--")){
            return 0;
        }
        str = str.replace("%", "");
        str = str.replace(",", "");
        if(str.equals("")){
            return 0;
        }
        if(str.contains("万")){
            String s = str.replace("万", "");
            BigDecimal b = new BigDecimal(s);
            BigDecimal v = b.multiply(new BigDecimal(10000));
            return v.intValue();
        }
        BigDecimal b = new BigDecimal(str);
        return b.intValue();
    }

    //单位：个，元
    public static long toLong(String str){
        if(str==null || str.equals("") || str.equals("null")){
            return 0;
        }
        str = str.replace("%", "");
        str = str.replace(",", "");
        if(str.equals("")){
            return 0;
        }
        if(str.contains("万")){
            String s = str.replace("万", "");
            BigDecimal bigDecimal = new BigDecimal(s);
            return bigDecimal.multiply(new BigDecimal(10000)).longValue();
        }
        if(str.contains("亿")){
            String s = str.replace("亿", "");
            BigDecimal bigDecimal = new BigDecimal(s);
            return bigDecimal.multiply(new BigDecimal(100000000)).longValue();
        }
        BigDecimal b = new BigDecimal(str);
        return b.longValue();
    }

    //单位：角， 十分之一
    public static int toIntDeci(String str){
        if(str==null || str.equals("") || str.equals("null") || str.equals("--")){
            return 0;
        }
        str = str.replace("%", "");
        str = str.replace(",", "");
        if(str.equals("")){
            return 0;
        }
        if(str.contains("万")){
            String s = str.replace("万", "");
            BigDecimal b = new BigDecimal(s);
            BigDecimal v = b.multiply(new BigDecimal(10000).multiply(new BigDecimal(10)));
            return v.intValue();
        }
        BigDecimal b = new BigDecimal(str);
        BigDecimal v = b.multiply(new BigDecimal(10));
        return v.intValue();
    }

    //单位：角， 十分之一
    public static long toLongDeci(String str){
        if(str==null || str.equals("") || str.equals("null")){
            return 0;
        }
        str = str.replace("%", "");
        str = str.replace(",", "");
        if(str.equals("")){
            return 0;
        }
        if(str.contains("万")){
            String s = str.replace("万", "");
            BigDecimal bigDecimal = new BigDecimal(s);
            return bigDecimal.multiply(new BigDecimal(10000)).multiply(new BigDecimal(10)).longValue();
        }
        if(str.contains("亿")){
            String s = str.replace("亿", "");
            BigDecimal bigDecimal = new BigDecimal(s);
            return bigDecimal.multiply(new BigDecimal(100000000)).multiply(new BigDecimal(10)).longValue();
        }
        BigDecimal b = new BigDecimal(str);
        BigDecimal v = b.multiply(new BigDecimal(10));
        return v.longValue();
    }


    //单位：分，百分之一
    public static int toIntCenti(String str){
        if(str==null || str.equals("") || str.equals("null") || str.equals("--")){
            return 0;
        }
        str = str.replace("%", "");
        str = str.replace(",", "");
        if(str.equals("")){
            return 0;
        }
        if(str.contains("万")){
            String s = str.replace("万", "");
            BigDecimal b = new BigDecimal(s);
            BigDecimal v = b.multiply(new BigDecimal(10000).multiply(new BigDecimal(100)));
            return v.intValue();
        }
        BigDecimal b = new BigDecimal(str);
        BigDecimal v = b.multiply(new BigDecimal(100));
        return v.intValue();
    }


    //单位：分，百分之一
    public static long toLongCenti(String str){
        if(str==null || str.equals("") || str.equals("null")){
            return 0;
        }
        str = str.replace("%", "");
        str = str.replace(",", "");
        if(str.equals("")){
            return 0;
        }
        if(str.contains("万")){
            String s = str.replace("万", "");
            BigDecimal bigDecimal = new BigDecimal(s);
            return bigDecimal.multiply(new BigDecimal(10000)).multiply(new BigDecimal(100)).longValue();
        }
        if(str.contains("亿")){
            String s = str.replace("亿", "");
            BigDecimal bigDecimal = new BigDecimal(s);
            return bigDecimal.multiply(new BigDecimal(100000000)).multiply(new BigDecimal(100)).longValue();
        }
        BigDecimal b = new BigDecimal(str);
        BigDecimal v = b.multiply(new BigDecimal(100));
        return v.longValue();
    }

    //单位：毫，千分之一
    public static int toIntMilli(String str){
        if(str==null || str.equals("") || str.equals("null") || str.equals("--")){
            return 0;
        }
        str = str.replace("%", "");
        str = str.replace(",", "");
        if(str.equals("")){
            return 0;
        }
        if(str.contains("万")){
            String s = str.replace("万", "");
            BigDecimal b = new BigDecimal(s);
            BigDecimal v = b.multiply(new BigDecimal(10000).multiply(new BigDecimal(1000)));
            return v.intValue();
        }
        BigDecimal b = new BigDecimal(str);
        BigDecimal v = b.multiply(new BigDecimal(1000));
        return v.intValue();
    }


    //单位：毫，千分之一
    public static long toLongMilli(String str){
        System.out.println("str:" + str);
        if(str==null || str.equals("") || str.equals("null") || str.equals("-")){
            return 0;
        }
        str = str.replace("%", "");
        str = str.replace(",", "");
        if(str.equals("")){
            return 0;
        }
        if(str.contains("万")){
            String s = str.replace("万", "");
            BigDecimal bigDecimal = new BigDecimal(s);
            return bigDecimal.multiply(new BigDecimal(10000)).multiply(new BigDecimal(1000)).longValue();
        }
        if(str.contains("亿")){
            String s = str.replace("亿", "");
            BigDecimal bigDecimal = new BigDecimal(s);
            return bigDecimal.multiply(new BigDecimal(100000000)).multiply(new BigDecimal(1000)).longValue();
        }
        BigDecimal b = new BigDecimal(str);
        BigDecimal v = b.multiply(new BigDecimal(1000));
        return v.longValue();
    }


    public static int getZhenFu(int zuiGao, int zuiDi, int zuoShou){
        if(zuoShou==0){
            return 0;
        }
        System.out.println(zuiGao);
        System.out.println(zuiDi);
        System.out.println(zuoShou);
        BigDecimal gao = new BigDecimal(zuiGao);
        BigDecimal di = new BigDecimal(zuiDi);
        BigDecimal zuoS = new BigDecimal(zuoShou);
        BigDecimal c = gao.subtract(di).multiply(new BigDecimal(1000)).multiply(new BigDecimal(100));
        BigDecimal zhenFu = c.divide(zuoS, 0, RoundingMode.HALF_DOWN);
        return zhenFu.intValue();

    }

    //获取百分比小数点后三位如 1% 显示为 1000
    public static int getBiLv(long p, long t){
        if(p==0 || t==0){
            return 0;
        }
        BigDecimal part = new BigDecimal(p);
        BigDecimal total = new BigDecimal(t);
        BigDecimal part2 = part.multiply(new BigDecimal(1000)).multiply(new BigDecimal(100));
        BigDecimal biLv = part2.divide(total, 0, RoundingMode.HALF_DOWN);
        return biLv.intValue();

    }

    //获取百分比，不包含小数点后面，如 1% 显示为 1
    public static int getBiLv2(long p, long t){
        if(p==0 || t==0){
            return 0;
        }
        BigDecimal part = new BigDecimal(p);
        BigDecimal total = new BigDecimal(t);
        BigDecimal part2 = part.multiply(new BigDecimal(100));
        BigDecimal biLv = part2.divide(total, 0, RoundingMode.HALF_DOWN);
        return biLv.intValue();

    }

    public static void main(String[] args){
//        System.out.println(NumberUtils.getZhenFu(10490, 9690, 10030));

        System.out.println(NumberUtils.getBiLv2(1, 6));

    }

}
