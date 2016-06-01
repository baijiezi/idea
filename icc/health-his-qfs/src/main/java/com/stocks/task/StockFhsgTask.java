package com.stocks.task;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.stocks.dao.StocksDao;
import com.stocks.dao.StocksFhsgDao;
import com.stocks.dto.StocksFhsgDto;
import com.stocks.entity.StocksEntity;
import com.stocks.entity.StocksFhsgEntity;
import com.stocks.utils.DateUtils;
import com.stocks.utils.HibernateUtil;
import com.stocks.utils.NumberUtils;
import org.hibernate.Session;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ning.http.client.Response;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.concurrent.Future;

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
            List data = new ArrayList<StocksFhsgDto>();
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
                logger.info("==============================StockFhsgTask:" + stock.getName() + "    " + stock.getCode() + "===============================");
                try{
//                    if(!stock.getCode().equals("000776")){
//                        continue;
//                    }
                    String url = "http://stock.quote.stockstar.com/dividend/bonus_"+stock.getCode()+".shtml";
                    Parser parser = new Parser( (HttpURLConnection) (new URL(url)).openConnection() );
                    parser.setEncoding("GB2312");
                    TagNameFilter filter = new TagNameFilter("table");
                    NodeList li = parser.extractAllNodesThatMatch(filter);
                    System.out.println("list.size: " + li.size());
                    for(NodeIterator i = li.elements(); i.hasMoreNodes(); ){
                        TableTag node = (TableTag) i.nextNode();
                        if(node.getAttribute("class")==null || !node.getAttribute("class").equals("globalTable trHover")){
                            continue;
                        }
                        System.out.println(node.toHtml());
                        Parser parser1 = new Parser(node.toHtml());
                        NodeFilter filter2 = new TagNameFilter("tr");
                        NodeList list2 = parser1.extractAllNodesThatMatch(filter2);
                        System.out.println("list2.size: " + list2.size());
                        int j = 0;
                        for(NodeIterator k = list2.elements(); k.hasMoreNodes(); ){
                            try{
                                if(++j > 3){
                                    break;
                                }
                                Node n = k.nextNode();
                                Parser parser3 = new Parser(n.toHtml());
                                NodeFilter filter3 = new TagNameFilter("td");
                                NodeList list3 = parser3.extractAllNodesThatMatch(filter3);
                                StocksFhsgDto dto = new StocksFhsgDto();
                                dto.setCode(stock.getCode());
                                dto.setName(stock.getName());
                                dto.setGongGaoRi(DateUtils.strToDate(list3.elementAt(1).toPlainTextString()));
                                if(dto.getGongGaoRi()==null || dto.getGongGaoRi().before(dt) || dao.isExit(dto)){
                                    continue;
                                }
                                dto.setFenHong(NumberUtils.toIntMilli(list3.elementAt(2).toPlainTextString()));
                                dto.setSongGu(NumberUtils.toInt(list3.elementAt(3).toPlainTextString()));
                                dto.setZhuanZeng(NumberUtils.toInt(list3.elementAt(4).toPlainTextString()));
                                dto.setDengJiRi(DateUtils.strToDate(list3.elementAt(5).toPlainTextString()));
                                dto.setChuQuanRi(DateUtils.strToDate(list3.elementAt(6).toPlainTextString()));
                                dto.setRemark(list3.elementAt(7).toPlainTextString());
                                dto.setMeiGuFenHong(dto.getFenHong()/10);
                                if(dto.getMeiGuFenHong()!=null && dto.getMeiGuFenHong()>0){
                                    StringBuffer sb = new StringBuffer("http://qt.gtimg.cn/r=0.9694567599799484q=");
                                    if(stock.getExchange().equals("sh") || stock.getExchange().startsWith("沪")){
                                        sb.append("s_sh").append(stock.getCode());
                                    }
                                    if(stock.getExchange().equals("sz") || stock.getExchange().startsWith("深")){
                                        sb.append("s_sz").append(stock.getCode());
                                    }

                                    logger.info("url:"+ sb.toString());
                                    Future r = asyncHttpClient.prepareGet(sb.toString()).execute();
                                    Response response = (Response) r.get();
                                    String rs = response.getResponseBody();
                                    logger.info(rs);
                                    String str = rs.substring(rs.indexOf("\"")+1, rs.lastIndexOf("\""));
                                    String[] temp = str.split("~");

                                    dto.setDangQianGuJia(NumberUtils.toIntMilli(temp[3]));
                                    dto.setShouYiLv(NumberUtils.getBiLv(dto.getMeiGuFenHong(), dto.getDangQianGuJia()));
                                }
                                data.add(dto);
                            }catch (Exception e){
                                logger.info("StockFhsgTask异常:", e);
                            }
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            asyncHttpClient.close();
            List<StocksFhsgEntity> list1 = updateData(data);
            logger.info("完成更新FHSG数据 " + list1.size() + " 条");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private List<StocksFhsgEntity> updateData(List<StocksFhsgDto> data){
        List list = new ArrayList<StocksFhsgEntity>();
        if(data==null || data.size()==0){
            return list;
        }
        Date date = new Date();
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        StocksFhsgDao dao = new StocksFhsgDao();
        for(StocksFhsgDto dto : data){
            StocksFhsgEntity  entity = new StocksFhsgEntity();
            entity.setCode(dto.getCode());
            entity.setName(dto.getName());
            entity.setGongGaoRi(dto.getGongGaoRi());
            entity.setFenHong(dto.getFenHong());
            entity.setSongGu(dto.getSongGu());
            entity.setZhuanZeng(dto.getZhuanZeng());
            entity.setDengJiRi(dto.getDengJiRi());
            entity.setChuQuanRi(dto.getChuQuanRi());
            entity.setRemark(dto.getRemark());
            entity.setMeiGuFenHong(dto.getMeiGuFenHong());
            entity.setDangQianGuJia(dto.getDangQianGuJia());
            entity.setShouYiLv(dto.getShouYiLv());
            entity.setCreateAt(date);
            dao.save(entity, session);
            list.add(entity);
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
        return list;
    }
}
