package com.zhq.neti.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum BackStockEnum {
    SUCCESS(1, "退货成功"),  FAIL(0, "无法退货");

    @EnumValue//标记数据库存的值是code
    private final int code;
    private final String descp;

    BackStockEnum(int code, String descp) {
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
