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
 * Date: 16-2-27
 * Time: 下午2:05
 * To change this template use File | Settings | File Templates.
 */


public class StockTast2 {



    public static void main(String[] args){
        StockTast2 stockTask2 = new StockTast2();
        stockTask2.execute();
    }

    public void execute(){
        System.out.println(new Date() + "  StockTast2  execute");

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
                String exchange = "";
                for(NodeIterator j = childs.elements(); j.hasMoreNodes(); ){
                    Node child = j.nextNode();
                    if(child.getText()!=null && child.getText().equals("h2")){
                        exchange = child.toPlainTextString();
                    }
                }
                //去除基金部分
                if(exchange!=null &&exchange.equals("基金")){
                    continue;
                }

                Parser parser1 = new Parser(node.toHtml());
                NodeFilter filter = new TagNameFilter("a");
                NodeList list2 = parser1.extractAllNodesThatMatch(filter);
                System.out.println(list2.size());
                for(NodeIterator k = list2.elements(); k.hasMoreNodes(); ){
                    LinkTag n = (LinkTag) k.nextNode();
                    if(n.getAttribute("title")!=null && !n.getAttribute("title").equals("")){
                        String text = n.toPlainTextString();
                        int index = text.lastIndexOf(" ");
                        StocksDto stocksDto = new StocksDto();
                        stocksDto.setName(text.substring(0, index).replace(" ", ""));
                        stocksDto.setCode(text.substring(index+1));
                        stocksDto.setExchange(exchange);
                        stocksDto.setDetailUrl2("");
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


    public void updateData(List<StocksDto> data){
        if(data==null || data.size()==0){
            return;
        }
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        for(StocksDto stocksDto : data){
            StocksDao dao = new StocksDao();
            List<StocksEntity> list = dao.queryByCode(stocksDto.getCode(), session);
            if(list!=null && list.size()>0){
                StocksEntity stocksEntity = list.get(0);
                stocksEntity.setDetailUrl2(stocksDto.getDetailUrl2());
                dao.update(stocksEntity, session);
            }
            else{
                StocksEntity stocksEntity = new StocksEntity();
                stocksEntity.setName(stocksDto.getName());
                stocksEntity.setCode(stocksDto.getCode());
                stocksEntity.setExchange(stocksDto.getExchange());
                stocksEntity.setDetailUrl2(stocksDto.getDetailUrl2());
                stocksEntity.setType(stocksDto.getType());
                stocksEntity.setSubType(stocksDto.getSubType());
                stocksEntity.setCreateAt(new Date());
                dao.save(stocksEntity, session);
            }
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }




}
