package com.message.service;

import com.message.entity.MessageEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import com.shcm.bean.BalanceResultBean;
//import com.shcm.bean.SendResultBean;
//import com.shcm.send.DataApi;
//import com.shcm.send.OpenApi;
//import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-3-15
 * Time: 下午7:27
 * To change this template use File | Settings | File Templates.
 */
public class MessageService {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

//    private static String sOpenUrl = "http://smsapi.c123.cn/OpenPlatform/OpenApi";
//    private static String sDataUrl = "http://smsapi.c123.cn/DataPlatform/DataApi";
//
//    // 接口帐号
//    private static final String account = "1001@501274430001";
//    // 接口密钥
//    private static final String authkey = "3A8DBE91FB10B5A663991B6F093466A4";
//    // 通道组编号
//    private static final int cgid = 52;
//    // 默认使用的签名编号(未指定签名编号时传此值到服务器)
//    private static final int csid = 0;
//
//    public static List<SendResultBean> sendOnce(String mobile, String content) throws Exception
//    {
//        // 发送短信
//        return OpenApi.sendOnce(mobile, content, 0, 0, null);
//    }
//
//    public MessageEntity send(MessageEntity entity){
//        try{
//            // 发送参数
//            OpenApi.initialzeAccount(sOpenUrl, account, authkey, cgid, csid);
//            // 状态及回复参数
//            DataApi.initialzeAccount(sDataUrl, account, authkey);
//            // 取帐户余额
//            BalanceResultBean br = OpenApi.getBalance();
//            if(br == null)
//            {
//                logger.info("获取可用余额时发生异常!");
//                entity.setRemark("获取可用余额时发生异常!");
//                return entity;
//            }
//
//            if(br.getResult() < 1)
//            {
//                logger.info("获取可用余额失败: " + br.getErrMsg());
//                entity.setRemark("获取可用余额失败: " + br.getErrMsg());
//                return entity;
//            }
//            logger.info("可用条数: " + br.getRemain());
//            entity.setRemark("可用条数: " + br.getRemain());
//
//            List<SendResultBean> listItem = sendOnce(entity.getMobile(), entity.getContent());
//            if(listItem != null)
//            {
//                for(SendResultBean t:listItem)
//                {
//                    if(t.getResult() < 1)
//                    {
//                        logger.info("发送提交失败: " + t.getErrMsg());
//                        entity.setRemark("发送提交失败: " + t.getErrMsg());
//                        return entity;
//                    }
//                    logger.info("发送成功: 消息编号<" + t.getMsgId() + "> 总数<" + t.getTotal() + "> 余额<" + t.getRemain() + ">");
//                    entity.setRemark("发送成功: 消息编号<" + t.getMsgId() + "> 总数<" + t.getTotal() + "> 余额<" + t.getRemain() + ">");
//                    entity.setStatus(0);
//                }
//            }
//        }catch(Exception e){
//            logger.error("发送信息异常：", e);
//            entity.setRemark("发送信息异常："+e.getMessage());
//        }
//        return entity;
//
//    }

}
