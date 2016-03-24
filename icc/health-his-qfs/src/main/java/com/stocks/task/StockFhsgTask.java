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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-3-24
 * Time: 上午11:53
 * To change this template use File | Settings | File Templates.
 */
public class StockFhsgTask {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args){
        StockFhsgTask stockFhsgTask = new StockFhsgTask();
        stockFhsgTask.execute();
    }

    public void execute(){
        logger.info("StockFhsgTask  execute");

        try{
            String url = "http://stock.quote.stockstar.com/dividend/bonus_600887.shtml";
            Parser parser = new Parser( (HttpURLConnection) (new URL(url)).openConnection() );
            parser.setEncoding("GB2312");
//            CssSelectorNodeFilter filter = new CssSelectorNodeFilter("tbody[class='tbody_right']");
            TagNameFilter filter = new TagNameFilter("table");
            NodeList list = parser.extractAllNodesThatMatch(filter);
            System.out.println("list.size: " + list.size());
            List data = new ArrayList<StocksDto>();
            for(NodeIterator i = list.elements(); i.hasMoreNodes(); ){
                Node node = i.nextNode();
                System.out.println(node.toHtml());
                Parser parser1 = new Parser(node.toHtml());
                NodeFilter filter2 = new TagNameFilter("tr");
                NodeList list2 = parser1.extractAllNodesThatMatch(filter2);
                System.out.println("list2.size: " + list2.size());
//                for(NodeIterator k = list2.elements(); k.hasMoreNodes(); ){
//                    System.out.println("==");
//                }
            }
//            updateData(data);
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
            StocksEntity entity = dao.getByCode(stocksDto.getCode(), session);
            if(entity!=null){
                entity.setDetailUrl(stocksDto.getDetailUrl());
                dao.update(entity, session);
            }
            else{
                StocksEntity stocksEntity = new StocksEntity();
                stocksEntity.setName(stocksDto.getName());
                stocksEntity.setCode(stocksDto.getCode());
                stocksEntity.setExchange(stocksDto.getExchange());
                stocksEntity.setDetailUrl(stocksDto.getDetailUrl());
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
