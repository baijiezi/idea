package com.test;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;


/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-28
 * Time: 上午10:05
 * To change this template use File | Settings | File Templates.
 */
public class HtmlparserTest {

    public static void main(String[] args){

        try{
            Parser parser = new Parser("http://www.chinanews.com/gj/2011/09-22/3347124.shtml");//要解析的网页
            parser.setEncoding("gb2312");//设置编码

            //按标签名称过滤
            NodeFilter filter_title = new TagNameFilter("title");//title节点过滤
            NodeList nodelist1 = parser.extractAllNodesThatMatch(filter_title);

            //组合过滤
            NodeFilter filter_text = new AndFilter(new TagNameFilter("div"),new HasAttributeFilter("class","left_zw"));
            NodeList nodelist2 = parser.parse(filter_text);



        }catch (Exception e){
            e.printStackTrace();
        }




    }
}
