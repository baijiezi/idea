package com.message.enums;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-3-11
 * Time: 上午10:23
 * To change this template use File | Settings | File Templates.
 */
public enum  MessageStatusEnum {
    发送成功(0),
    等待发送(1),
    发送失败(2);

    private int status;

    public int getValue() {
        return status;
    }

    private MessageStatusEnum(int status) {
        this.status = status;
    }

    public static MessageStatusEnum getMessageStatusEnum(int status) {
        switch (status) {
            case 0:
                return 发送成功;
            case 1:
                return 等待发送;
            case 2:
                return 发送失败;
            default:
                return null;
        }
    }

}
