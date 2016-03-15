package com.message.task;

import com.message.dao.MessageDao;
import com.message.entity.MessageEntity;
import com.message.service.MessageService;
import com.stocks.dao.StocksDao;
import com.stocks.dao.StocksPriceDao;
import com.stocks.dto.StocksPriceDto;
import com.stocks.entity.StocksEntity;
import com.stocks.entity.StocksPriceEntity;
import com.stocks.utils.HibernateUtil;
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
            MessageDao dao = new MessageDao();
            List<MessageEntity> list = dao.getByStatus(1);
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
            logger.info("共发送信息 " + list.size() + " 条");
        } catch (Exception e){
            logger.error("MessageTask 任务异常：", e);
        }

    }

}
