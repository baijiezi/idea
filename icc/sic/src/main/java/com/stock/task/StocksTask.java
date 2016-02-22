package com.stock.task;

import com.stock.dao.StocksDao;
import com.stock.dto.StocksDto;
import com.stock.entity.StocksEntity;
import com.stock.utils.Utils;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.CssSelectorNodeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-2-19
 * Time: 下午12:57
 * To change this template use File | Settings | File Templates.
 */
//沪市
public class StocksTask {

    public void execute(){
        System.out.println(new Date() + "  StocksTask  execute");

        try{
            Parser parser = new Parser( (HttpURLConnection) (new URL("http://bbs.10jqka.com.cn/codelist.html")).openConnection() );
            //设置Parser对象的字符编码,一般与网页的字符编码保持一致
            parser.setEncoding("gbk");
            CssSelectorNodeFilter divFilter = new CssSelectorNodeFilter("div[class='bbsilst_wei3']");      //  "div[id='someid'] .className a")       "div[class='dd']"
            NodeList list = parser.extractAllNodesThatMatch(divFilter);
            List data = new ArrayList<StocksDto>();
            for(NodeIterator i = list.elements(); i.hasMoreNodes(); ){
                Node node = i.nextNode();
                NodeList childs = node.getChildren();
                String belongTo = "";
                for(NodeIterator j = childs.elements(); j.hasMoreNodes(); ){
                    Node child = j.nextNode();
                    if(child.getText()!=null && child.getText().equals("h2")){
                        belongTo = child.toPlainTextString();
                    }

                }
                System.out.println(belongTo);
                Utils.printHexString(new String(belongTo.getBytes("GBK"), "UTF-8").getBytes());
                Utils.printHexString(new String(belongTo.getBytes("GBK"), "GBK").getBytes());
                Utils.printHexString(new String(belongTo.getBytes("UTF-8"), "UTF-8").getBytes());
                Utils.printHexString(new String(belongTo.getBytes("UTF-8"), "GBK").getBytes());
                System.out.println(new String(belongTo.getBytes("GBK"), "UTF-8"));
                System.out.println(new String(belongTo.getBytes("GBK"), "GBK"));
                System.out.println(new String(belongTo.getBytes("UTF-8"), "UTF-8"));
                System.out.println(new String(belongTo.getBytes("UTF-8"), "GBK"));
                System.out.println();

                String a = new String(belongTo.getBytes());
                String b = new String(belongTo.getBytes(), "GBK");
                String c = new String(belongTo.getBytes(), "UTF-8");
                String d = new String(belongTo.getBytes(), "Unicode");

                String e = new String(belongTo.getBytes("GBK"));
                String f = new String(belongTo.getBytes("GBK"), "GBK");
                String g = new String(belongTo.getBytes("GBK"), "UTF-8");
                String h = new String(belongTo.getBytes("GBK"), "Unicode");

                String ii = new String(belongTo.getBytes("UTF-8"));
                String jj = new String(belongTo.getBytes("UTF-8"), "GBK");
                String kk = new String(belongTo.getBytes("UTF-8"), "UTF-8");
                String l = new String(belongTo.getBytes("UTF-8"), "Unicode");

                String m = new String(belongTo.getBytes("Unicode"));
                String nn = new String(belongTo.getBytes("Unicode"), "GBK");
                String o = new String(belongTo.getBytes("Unicode"), "UTF-8");
                String p = new String(belongTo.getBytes("Unicode"), "Unicode");


                belongTo = b;

                Parser parser1 = new Parser(node.toHtml());
                NodeFilter filter = new TagNameFilter("a");
                NodeList list2 = parser1.extractAllNodesThatMatch(filter);
                System.out.println(list2.size());
                int y = 0;
                for(NodeIterator k = list2.elements(); k.hasMoreNodes(); ){
                    LinkTag n = (LinkTag) k.nextNode();
                    System.out.println(n.toPlainTextString());
                    System.out.println(n.getAttribute("href"));
                    if(n.getAttribute("title")!=null && !n.getAttribute("title").equals("")){
                        String[] temp = n.toPlainTextString().split(" ");
                        StocksDto stocksDto = new StocksDto();
                        stocksDto.setName(temp[0]);
                        stocksDto.setCode(temp[1]);
                        stocksDto.setBelongTo(belongTo);
                        stocksDto.setDetailUrl(n.getAttribute("href"));
                        data.add(stocksDto);
                    }
                    y++;
                    if(y==2){
                        break;
                    }
                }
                System.out.println("======================aa=================================");

                break;
            }

            updateData(data);

        }catch (Exception e){
            e.printStackTrace();
        }






    }


    private void updateData(List<StocksDto> data){
        if(data==null || data.size()==0){
            return;
        }
        for(StocksDto stocksDto : data){
            StocksEntity stocksEntity = new StocksEntity();
            stocksEntity.setName(stocksDto.getName());
            stocksEntity.setCode(stocksDto.getCode());
            stocksEntity.setBelongTo(stocksDto.getBelongTo());
            stocksEntity.setDetailUrl(stocksDto.getDetailUrl());
            stocksEntity.setType(stocksDto.getType());
            stocksEntity.setSubType(stocksDto.getSubType());
            StocksDao dao = new StocksDao();
            dao.saveOrUpdate(stocksEntity);
        }
    }


}
