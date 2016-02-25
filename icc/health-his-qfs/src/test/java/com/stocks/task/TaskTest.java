package com.stocks.task;

import com.stocks.dao.StocksDao;
import com.stocks.dto.StocksDto;
import com.stocks.entity.StocksEntity;
import com.stocks.utils.HibernateUtil;
import junit.framework.TestCase;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-2-1
 * Time: 下午4:33
 * To change this template use File | Settings | File Templates.
 */
public class TaskTest extends TestCase {

    public void testHi(){
        StocksTask stocksTask = new StocksTask();
        List list = new ArrayList<StocksDto>();
        StocksEntity dto = new StocksEntity();
        dto.setCode("000607");
        list.add(dto);

        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        StocksDao dao = new StocksDao();
        dao.query(dto, session);
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();



    }
}
