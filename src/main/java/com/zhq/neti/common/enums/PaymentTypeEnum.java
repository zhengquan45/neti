package com.zhq.neti.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum  PaymentTypeEnum implements CodeEnum{

    CASH_CARD(1, "借记卡"),CREDIT_CARD(2, "信用卡"),CASH(3, "现金"),WECHAT(4, "微信"),ALIPAY(5, "支付宝");

    @EnumValue//标记数据库存的值是code
    private final int code;
    private final String descp;

    PaymentTypeEnum(int code, String descp) {
        this.code = code;
        this.descp = descp;
    }

    public int getCode() {
        return code;
    }

    public String getDescp() {
        return descp;
    }
}
