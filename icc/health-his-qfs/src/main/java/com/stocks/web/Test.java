package com.stocks.web;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.CssSelectorNodeFilter;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-2-1
 * Time: 下午4:29
 * To change this template use File | Settings | File Templates.
 */
public class Test {

    public static void main(String[] args){
        try{
            Parser parser = new Parser( (HttpURLConnection) (new URL("http://localhost:8080/")).openConnection() );

//            NodeFilter filter = new TagNameFilter("div");
//            NodeList list=parser.extractAllNodesThatMatch(filter);
//            for(NodeIterator i = list.elements(); i.hasMoreNodes(); ){
//                Node node = i.nextNode();
//                System.out.println(node.getClass());
//                System.out.println(node.getText());
//                System.out.println(node.toPlainTextString());
//                System.out.println(node.toHtml());
//                System.out.println(node.toHtml(true));
//                System.out.println(node.toHtml(false));
//                System.out.println(node.toString());
//                System.out.println("======================aa=================================");
//            }


            CssSelectorNodeFilter divFilter=new CssSelectorNodeFilter("div[class='dd']");      //  "div[id='someid'] .className a")       "div[class='dd']"
            NodeList list=parser.extractAllNodesThatMatch(divFilter);
            for(NodeIterator i = list.elements(); i.hasMoreNodes(); ){
                Node node = i.nextNode();
                System.out.println(node.getClass());
                System.out.println(node.getText());
                System.out.println(node.toPlainTextString());
                System.out.println(node.toHtml());
                System.out.println(node.toHtml(true));
                System.out.println(node.toHtml(false));
                System.out.println(node.toString());
                System.out.println("======================aa=================================");
            }




        } catch (Exception e){
            e.printStackTrace();
        }






    }
}
