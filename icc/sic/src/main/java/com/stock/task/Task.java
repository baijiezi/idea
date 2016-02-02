package com.stock.task;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.Div;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-2-1
 * Time: 下午4:32
 * To change this template use File | Settings | File Templates.
 */
public class Task {

    public void execute(){
        System.out.println(new Date() + "  Task  execute");








    }


    public String Hi(){
        return "hi";
    }


    public static void main(String[] args){
        try{
            Parser parser = new Parser( (HttpURLConnection) (new URL("http://localhost:8080/")).openConnection() );

            NodeFilter filter = new TagNameFilter("div");
            NodeList list=parser.extractAllNodesThatMatch(filter);
            for(NodeIterator i = list.elements(); i.hasMoreNodes(); ){
                Node node = i.nextNode();
                System.out.println(node.getText());
                System.out.println(node.toPlainTextString());
                System.out.println(node.toHtml());
                System.out.println(node.toHtml(true));
                System.out.println(node.toHtml(false));
                System.out.println(node.toString());
                System.out.println("======================aa=================================");

            }


//            for (NodeIterator i = parser.elements (); i.hasMoreNodes(); ) {
//                Node node = i.nextNode();
//                System.out.println(node.getText());
//                System.out.println(node.toPlainTextString());
//                System.out.println(node.toHtml());
//                System.out.println(node.toHtml(true));
//                System.out.println(node.toHtml(false));
//                System.out.println(node.toString());
//                System.out.println("=================================================");
//            }






        } catch (Exception e){
            e.printStackTrace();
        }






    }

}
