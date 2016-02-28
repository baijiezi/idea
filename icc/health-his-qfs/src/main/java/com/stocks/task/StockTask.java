package com.stocks.task;

import com.stocks.dao.StocksDao;
import com.stocks.dto.StocksDto;
import com.stocks.entity.StocksEntity;
import com.stocks.utils.HibernateUtil;
import org.hibernate.Session;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
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
public class StockTask {
    public static void main(String[] args){
        StockTask stockTask = new StockTask();
        stockTask.execute();
    }

    public void execute(){
        System.out.println(new Date() + "  StockTask  execute");
        try{
            Parser parser = new Parser( (HttpURLConnection) (new URL("http://quote.eastmoney.com/stocklist.html")).openConnection() );
            //设置Parser对象的字符编码,一般与网页的字符编码保持一致
            parser.setEncoding("GB2312");
            NodeFilter filter = new TagNameFilter("ul");
            NodeList list = parser.extractAllNodesThatMatch(filter);
            System.out.println(list.size());
            List data = new ArrayList<StocksDto>();
            for(NodeIterator i = list.elements(); i.hasMoreNodes(); ){
                Node node = i.nextNode();
                Parser parser1 = new Parser(node.toHtml());
                NodeFilter filter2 = new TagNameFilter("a");
                NodeList list2 = parser1.extractAllNodesThatMatch(filter2);
                System.out.println(list2.size());
                if(list2.size() > 1000){
                    String exchange = "";
                    for(NodeIterator k = list2.elements(); k.hasMoreNodes(); ){
                        LinkTag n = (LinkTag) k.nextNode();
                        if(n.getAttribute("href")!=null && !n.getAttribute("href").equals("")){
                            String text = n.toPlainTextString();
                            if(text==null || text.equals("") || !text.contains("(")){
                                continue;
                            }
                            int idx = text.indexOf("(");
                            int idx2 = text.indexOf(")");
                            String href = n.getAttribute("href");
                            if(href.contains("sh")){
                                exchange = "沪市";
                            }
                            if(href.contains("sz")){
                                exchange = "深市";
                            }
                            StocksDto stocksDto = new StocksDto();
                            stocksDto.setName(text.substring(0, idx));
                            stocksDto.setCode(text.substring(idx+1, idx2));
                            stocksDto.setExchange(exchange);
                            stocksDto.setDetailUrl1(href);
                            data.add(stocksDto);
                        }
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
            StocksDao dao = new StocksDao();
            List<StocksEntity> list = dao.queryByCode(stocksDto.getCode(), session);
            if(list!=null && list.size()>0){
                StocksEntity stocksEntity = list.get(0);
                stocksEntity.setDetailUrl1(stocksDto.getDetailUrl1());
                dao.update(stocksEntity, session);
            }
            else{
                StocksEntity stocksEntity = new StocksEntity();
                stocksEntity.setName(stocksDto.getName());
                stocksEntity.setCode(stocksDto.getCode());
                stocksEntity.setExchange(stocksDto.getExchange());
                stocksEntity.setDetailUrl1(stocksDto.getDetailUrl1());
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
