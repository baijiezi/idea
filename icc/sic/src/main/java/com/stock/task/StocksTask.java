package com.stock.task;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.CssSelectorNodeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-2-19
 * Time: 下午12:57
 * To change this template use File | Settings | File Templates.
 */
public class StocksTask {

    public void execute(){
        System.out.println(new Date() + "  StocksTask  execute");

        try{
            Parser parser = new Parser( (HttpURLConnection) (new URL("http://bbs.10jqka.com.cn/codelist.html")).openConnection() );
            CssSelectorNodeFilter divFilter = new CssSelectorNodeFilter("div[class='bbsilst_wei3']");      //  "div[id='someid'] .className a")       "div[class='dd']"
            NodeList list = parser.extractAllNodesThatMatch(divFilter);
            for(NodeIterator i = list.elements(); i.hasMoreNodes(); ){
                Node node = i.nextNode();

                Parser parser1 = new Parser(node.toHtml());
                NodeFilter filter = new TagNameFilter("a");
                NodeList list2 = parser1.extractAllNodesThatMatch(filter);
                System.out.println(list2.size());
                for(NodeIterator j = list2.elements(); j.hasMoreNodes(); ){
                    Node n = j.nextNode();
                    System.out.println(n.toPlainTextString());
//                    System.out.println("-------------------------------------");
                }


//                NodeList li = node.getChildren();
//                for(NodeIterator j = li.elements(); j.hasMoreNodes(); ){
//                    Node n = j.nextNode();
//                    System.out.println(n.getText());
//                    System.out.println("-------------------------------------");
//                }

//                System.out.println(node.getClass());
//                System.out.println(node.getText());
//                System.out.println(node.toPlainTextString());
//                System.out.println(node.toHtml());
//                System.out.println(node.toHtml(true));
//                System.out.println(node.toHtml(false));
//                System.out.println(node.toString());
                System.out.println("======================aa=================================");
            }
        }catch (Exception e){
            e.printStackTrace();
        }






    }


}
