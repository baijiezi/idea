package com.test;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-13
 * Time: 下午6:20
 * To change this template use File | Settings | File Templates.
 */
public class HtmlparserTest {

    public static void main(String[] args){
        try{
            String url = "http://vol.stock.hexun.com/603000.shtm";
            Parser parser = new Parser( (HttpURLConnection) (new URL(url)).openConnection() );
            //设置Parser对象的字符编码,一般与网页的字符编码保持一致
            parser.setEncoding("GB2312");
            NodeFilter filter = new TagNameFilter("body");
            NodeList list = parser.extractAllNodesThatMatch(filter);
            System.out.println(list.size());



        }catch (Exception e){
            e.printStackTrace();
        }





    }






}
