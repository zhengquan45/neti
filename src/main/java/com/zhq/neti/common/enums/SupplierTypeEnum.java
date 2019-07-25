package com.zhq.neti.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum SupplierTypeEnum {
    FACTORY(1, "厂家"),  AGENT(2, "代理商"),PERSONAL(3, "个人");

    @EnumValue//标记数据库存的值是code
    private final int code;
    private final String descp;

    SupplierTypeEnum(int code, String descp) {
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
