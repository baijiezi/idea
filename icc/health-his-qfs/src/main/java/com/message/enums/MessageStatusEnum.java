package com.message.enums;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-3-11
 * Time: 上午10:23
 * To change this template use File | Settings | File Templates.
 */
public enum  MessageStatusEnum {
    等待支付(0),
    支付中(1),
    部分支付(2),
    获取订单信息不成功(3),
    支付成功(4),
    支付失败(5),
    HIS已支付(6),
    已申请退款(7),
    退款成功(8);

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
                return 等待支付;
            case 1:
                return 支付中;
            case 2:
                return 部分支付;
            case 3:
                return 获取订单信息不成功;         //等待HIS同步
            case 4:
                return 支付成功;
            case 5:
                return 支付失败;
            case 6:
                return HIS已支付;
            case 7:
                return 已申请退款;
            case 8:
                return 退款成功;
            default:
                return null;
        }
    }

}
