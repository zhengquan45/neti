package com.zhq.neti.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum PurchaseStatusEnum implements CodeEnum{
    UNCOMPLETE(1, "未完成"),  COMPLETE(2, "已完成");

    @EnumValue//标记数据库存的值是code
    private final int code;
    private final String descp;

    PurchaseStatusEnum(int code, String descp) {
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
