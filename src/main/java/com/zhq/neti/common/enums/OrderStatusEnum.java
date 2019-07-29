package com.zhq.neti.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum OrderStatusEnum {
    UNPAID(1, "未付款"),  PAID(2, "已付款"), SHIPPED(3, "已发货"),  ACCEPTED(4, "已签收");

    @EnumValue//标记数据库存的值是code
    private final int code;
    private final String descp;

    OrderStatusEnum(int code, String descp) {
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
