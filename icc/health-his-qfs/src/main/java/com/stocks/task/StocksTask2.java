package com.stocks.task;

import com.stocks.dao.StocksDao;
import com.stocks.dto.StocksDto;
import com.stocks.entity.StocksEntity;
import com.stocks.utils.HibernateUtil;
import org.hibernate.Session;
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
 * User: Administrator
 * Date: 16-2-25
 * Time: 下午8:44
 * To change this template use File | Settings | File Templates.
 */
public class StocksTask2 {
    public static void main(String[] args){
        StocksTask2 stocksTask2 = new StocksTask2();
        stocksTask2.execute();
    }

    public void execute(){
        System.out.println(new Date() + "  StocksTask2  execute");

        try{
            Parser parser = new Parser( (HttpURLConnection) (new URL("http://quote.eastmoney.com/stocklist.html")).openConnection() );
            //设置Parser对象的字符编码,一般与网页的字符编码保持一致
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

                Parser parser1 = new Parser(node.toHtml());
                NodeFilter filter = new TagNameFilter("a");
                NodeList list2 = parser1.extractAllNodesThatMatch(filter);
                System.out.println(list2.size());
                for(NodeIterator k = list2.elements(); k.hasMoreNodes(); ){
                    LinkTag n = (LinkTag) k.nextNode();
                    if(n.getAttribute("title")!=null && !n.getAttribute("title").equals("")){
                        String[] temp = n.toPlainTextString().split(" ");
                        StocksDto stocksDto = new StocksDto();
                        stocksDto.setName(temp[0]);
                        stocksDto.setCode(temp[1]);
                        stocksDto.setBelongTo(belongTo);
                        stocksDto.setDetailUrl(n.getAttribute("href"));
                        data.add(stocksDto);
                    }
                }
                System.out.println("======================aa=================================");

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
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        for(StocksDto stocksDto : data){
            StocksEntity stocksEntity = new StocksEntity();
            stocksEntity.setName(stocksDto.getName());
            stocksEntity.setCode(stocksDto.getCode());
            stocksEntity.setBelongTo(stocksDto.getBelongTo());
            stocksEntity.setDetailUrl(stocksDto.getDetailUrl());
            stocksEntity.setType(stocksDto.getType());
            stocksEntity.setSubType(stocksDto.getSubType());
            stocksEntity.setCreateAt(new Date());
            StocksDao dao = new StocksDao();
            dao.saveOrUpdate(stocksEntity, session);
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }





}
