package com.stocks.task;

import com.stocks.dao.StocksDao;
import com.stocks.dao.StocksFhsgDao;
import com.stocks.entity.StocksEntity;
import com.stocks.statistics.filters.api.IStockChooseFilter;
import com.stocks.statistics.filters.impl.ShiYingFilter;
import com.stocks.utils.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-3-25
 * Time: 上午10:49
 * To change this template use File | Settings | File Templates.
 */
public class StockChooseTask {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args){
        StockChooseTask stockChooseTask = new StockChooseTask();
        stockChooseTask.execute();
    }

    public void execute(){
        logger.info("StockChooseTask  execute");
        try{
            List data = new ArrayList<StocksEntity>();
            StocksDao stocksDao = new StocksDao();
            List<StocksEntity> list = stocksDao.getAll();
            Date date = new Date();
            ShiYingFilter shiYingFilter = new ShiYingFilter();

            String packageName = "com.stocks.statistics.filters.impl";
            List<Object> filters = getFilters(packageName);




            for(StocksEntity stock : list){
                logger.info("==============================StockChooseTask:" + stock.getName() + "    " + stock.getCode() + "===============================");
                if(!stock.getCode().equals("600887")){
                    continue;
                }
                try{
                    boolean isOk = true;
                    for(Object obj : filters){
                        IStockChooseFilter filter = (IStockChooseFilter)obj;
                        if(!filter.doFilt(stock)){
                            isOk = false;
                            break;
                        }
                    }
                    if(isOk){
                        data.add(stock);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            updateData(data);
            logger.info("完成" + data.size() + " 条");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private void updateData(List<StocksEntity> data){
        if(data==null || data.size()==0){
            return;
        }
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        StocksFhsgDao dao = new StocksFhsgDao();
        for(StocksEntity stock : data){

        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }


    private static List<Object> getFilters(String packageName) {
        List<Object> filters = new ArrayList<Object>();
        try{
            String path = packageName.replace(".", "/");
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            Enumeration<URL> resources = classLoader.getResources(path);
            URL resource = resources.nextElement();
            File directory = new File(resource.getFile());
            File[] files = directory.listFiles();
            for(File file:files){
                filters.add(Class.forName(packageName+"."+file.getName().substring(0,file.getName().length()-6)).newInstance());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return filters;
    }

}
