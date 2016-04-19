package com.message.task;

import com.message.dao.MessageDao;
import com.message.entity.MessageEntity;
import com.message.service.MessageService;
import com.stocks.dao.StocksDao;
import com.stocks.dao.StocksPriceDao;
import com.stocks.dto.StocksPriceDto;
import com.stocks.entity.StocksEntity;
import com.stocks.entity.StocksPriceEntity;
import com.stocks.utils.Constants;
import com.stocks.utils.DateUtils;
import com.stocks.utils.HibernateUtil;
import com.stocks.utils.LunarCalendar;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-3-11
 * Time: 上午9:43
 * To change this template use File | Settings | File Templates.
 */
public class MessageTask {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args){
        MessageTask messageTask = new MessageTask();
        messageTask.execute();
    }

    public void execute(){
        logger.info("MessageTask  execute");

        try{
            insertMessages();

            MessageDao dao = new MessageDao();
            List<MessageEntity> list = dao.getToSends(DateUtils.getSimpleDateTime(new Date()));
            MessageService service = new MessageService();
            Session session = HibernateUtil.getOpenSession();
            session.beginTransaction();
            for(MessageEntity entity : list){
                logger.info("==============================MessageTask===============================");
                try{
                    service.send(entity);
                }catch (Exception e){
                    logger.error("MessageTask 异常：", e);
                }
                entity.setSendTime(new Date());
                dao.update(entity, session);
            }
            session.getTransaction().commit();
            session.close();
            HibernateUtil.closeSessionFactory();
            logger.info("共发 " + list.size() + " 条");
        } catch (Exception e){
            logger.error("MessageTask 任务异常：", e);
        }

    }


    public void insertMessages(){
        Date now = new Date();
        MessageDao dao = new MessageDao();
        String yyyy_MM_ = DateUtils.getYearMonth(now);

        List<MessageEntity> list = dao.getByTypeAndToSendTime(Constants.MESSAGE_TYPE_XINGYONGKA, yyyy_MM_+"01");
        if(list==null || list.size()==0){
            MessageEntity entity = new MessageEntity("18825187648", "银行卡", Constants.MESSAGE_TYPE_XINGYONGKA, yyyy_MM_+"01");
            dao.save(entity);
            MessageEntity entity1 = new MessageEntity("18825187648", "银行卡", Constants.MESSAGE_TYPE_XINGYONGKA, yyyy_MM_+"25");
            dao.save(entity1);
        }

        list = dao.getByTypeAndToSendTime(Constants.MESSAGE_TYPE_TEHUIHAOMA, yyyy_MM_+"01");
        if(list==null || list.size()==0){
            MessageEntity entity = new MessageEntity("18825187648", "TeHuiHaoMa", Constants.MESSAGE_TYPE_TEHUIHAOMA, yyyy_MM_+"01");
            dao.save(entity);
        }


        LunarCalendar lunarCalendar = new LunarCalendar();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        long[] longs = lunarCalendar.calElement(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH));
        if(longs[2] == 14){
            MessageEntity entity = new MessageEntity("18825187648", "14", Constants.MESSAGE_TYPE_NONGLI, DateUtils.getSimpleDate(now));
            dao.save(entity);
        }
        if(longs[2] == 29){
            cal.add(Calendar.DAY_OF_MONTH, 1);
            long[] longs2 = lunarCalendar.calElement(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH));
            if(longs2[2] == 1){
                MessageEntity entity = new MessageEntity("18825187648", "29", Constants.MESSAGE_TYPE_NONGLI, DateUtils.getSimpleDate(now));
                dao.save(entity);
            }
        }

    }

}
