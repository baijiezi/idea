package com.stock.utils;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-21
 * Time: 下午1:53
 * To change this template use File | Settings | File Templates.
 */
public class Utils {

    //将指定byte数组以16进制的形式打印到控制台
    public static void printHexString( byte[] b) {
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            System.out.print(hex.toUpperCase() );
        }
        System.out.println();
    }

}
