package com.stocks.task;

import com.stocks.dao.StocksDao;
import com.stocks.dto.StocksDailyDto;
import com.stocks.dto.StocksDto;
import com.stocks.entity.StocksEntity;
import com.stocks.utils.HibernateUtil;
import org.hibernate.Session;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
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
 * Time: 下午2:07
 * To change this template use File | Settings | File Templates.
 */
public class StockDailyTask {

    public static void main(String[] args){
        StockDailyTask stockDailyTask = new StockDailyTask();
        stockDailyTask.execute();
    }


    public void execute(){
        System.out.println(new Date() + "  StockDailyTask  execute");

        try{
            StocksDao stocksDao = new StocksDao();
            List<StocksEntity> stocks = stocksDao.getAll();
            System.out.println(stocks.size());
            List data = new ArrayList<StocksDailyDto>();
            int v = 0;
            for(StocksEntity stock : stocks){
                String url = stock.getDetailUrl1();
                System.out.println(url);
                Parser parser = new Parser( (HttpURLConnection) (new URL("http://quote.eastmoney.com/sz002340.html")).openConnection() );
                //设置Parser对象的字符编码,一般与网页的字符编码保持一致
                parser.setEncoding("GB2312");

                NodeFilter hasAttributeFilter = new HasAttributeFilter( "id", "rgt1" );
                NodeList list = parser.extractAllNodesThatMatch(hasAttributeFilter);
                System.out.println(list.size());
                System.out.println(list.elementAt(0).toHtml());
//                updateData(data);
                v++;
                if(v > 0){
                    break;
                }
            }
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
