package com.test;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.CssSelectorNodeFilter;
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
            String url = "http://stock.quote.stockstar.com/dividend/bonus_600887.shtml";
            Parser parser = new Parser( (HttpURLConnection) (new URL(url)).openConnection() );
            parser.setEncoding("GB2312");
//            NodeFilter filter = new TagNameFilter("tbody");

            CssSelectorNodeFilter filter = new CssSelectorNodeFilter("tbody[class='tbody_right']");
            NodeList list = parser.extractAllNodesThatMatch(filter);
            System.out.println(list.size());



        }catch (Exception e){
            e.printStackTrace();
        }





    }






}
