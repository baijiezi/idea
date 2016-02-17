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




}
