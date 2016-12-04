package com.stocks.task;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.Response;
import com.stocks.dao.StocksDao;
import com.stocks.dao.StocksFhsgDao;
import com.stocks.dao.StocksGuDongDao;
import com.stocks.dto.StocksFhsgDto;
import com.stocks.entity.StocksEntity;
import com.stocks.entity.StocksGuDongEntity;
import com.stocks.entity.StocksGuDongEntity;
import com.stocks.utils.DateUtils;
import com.stocks.utils.HibernateUtil;
import com.stocks.utils.NumberUtils;
import org.hibernate.Session;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.CssSelectorNodeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.Div;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-11-22
 * Time: 上午10:42
 * To change this template use File | Settings | File Templates.
 */
public class StockGuDongTask {


    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args){
        StockGuDongTask StockGuDongTask = new StockGuDongTask();
        StockGuDongTask.execute();
    }

    public void execute(){
        logger.info("StockGuDongTask  execute");
        try{
            List data = new ArrayList<StocksGuDongEntity>();
            StocksDao stocksDao = new StocksDao();
            List<StocksEntity> list = stocksDao.getAll();
            StocksFhsgDao dao = new StocksFhsgDao();
            Date dt = DateUtils.addDate(new Date(), -180);
            AsyncHttpClientConfig config = new AsyncHttpClientConfig.Builder()
                    .setMaximumConnectionsPerHost(30)
                    .setMaximumConnectionsTotal(300)
                    .setConnectionTimeoutInMs(30*60*1000)
                    .setRequestTimeoutInMs(30*60*1000)
                    .build();
            AsyncHttpClient asyncHttpClient = new AsyncHttpClient(config);

            for(StocksEntity stock : list){
//                logger.info("==============================StockGuDongTask:" + stock.getName() + "    " + stock.getCode() + "===============================");
                try{
                    if(!stock.getCode().equals("002304")){
                        continue;
                    }
                    String url = "http://f10.eastmoney.com/f10_v2/ShareholderResearch.aspx?code=sz002304";
                    Parser parser = new Parser( (HttpURLConnection) (new URL(url)).openConnection() );
//                    parser.setEncoding("GB2312");
                    CssSelectorNodeFilter filter = new CssSelectorNodeFilter("div[class='section']");
                    NodeList li = parser.extractAllNodesThatMatch(filter);

//                    TagNameFilter filter = new TagNameFilter("div");
//                    NodeList li = parser.extractAllNodesThatMatch(filter);
                    System.out.println("list.size: " + li.size());
                    for(NodeIterator i = li.elements(); i.hasMoreNodes(); ){
                        Div node = (Div) i.nextNode();

                        TagNameFilter filter4 = new TagNameFilter("table");
                        Parser parser1 = new Parser(node.toHtml());
                        NodeList tableList = parser1.extractAllNodesThatMatch(filter4);
                        for(int j=0; j<tableList.size(); j++){
                            TableTag tableNode = (TableTag)tableList.elementAt(j);
                            TableRow[] rows = tableNode.getRows();
                            for(int k=0; k<rows.length; k++){
                                if(k == 0){
                                    continue;
                                }
                                TableRow row = rows[k];
                                TableColumn[] columns = row.getColumns();
                                if(columns==null || columns.length < 1){
                                    continue;
                                }
                                StocksGuDongEntity entity = new StocksGuDongEntity();
                                entity.setCode(stock.getCode());
                                entity.setName(stock.getName());
                                entity.setGdName(columns[1].toPlainTextString());
                                data.add(entity);
                            }
                        }

//                        Parser parser1 = new Parser(node.toHtml());
//                        CssSelectorNodeFilter filter1 = new CssSelectorNodeFilter("div[class='name']");
//                        NodeList list1 = parser1.extractAllNodesThatMatch(filter1);
//                        System.out.println(list1.elementAt(0).toPlainTextString().trim());
//
//
//                        Parser parser2 = new Parser(node.toHtml());
//                        CssSelectorNodeFilter filter2 = new CssSelectorNodeFilter("div[class='tab']");
//                        NodeList list2 = parser2.extractAllNodesThatMatch(filter2);
//                        Div tabNode = (Div)list2.elementAt(0);
//                        Parser parser3 = new Parser(tabNode.toHtml());
//                        NodeFilter filter3 = new TagNameFilter("span");
//                        NodeList dateList = parser3.extractAllNodesThatMatch(filter3);
//                        System.out.println(dateList.elementAt(0).toPlainTextString());



                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            asyncHttpClient.close();
            updateData(data);
            logger.info("完成更新GD数据 " + data.size() + " 条");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private void updateData(List<StocksGuDongEntity> data){
        if(data==null || data.size()==0){
            return;
        }
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        StocksGuDongDao dao = new StocksGuDongDao();
        for(StocksGuDongEntity entity : data){
            dao.save(entity, session);
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }
}
