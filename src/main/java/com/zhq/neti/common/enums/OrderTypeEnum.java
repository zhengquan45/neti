package com.zhq.neti.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum OrderTypeEnum implements CodeEnum{
    ENTITY_SHOP(1, "实体销售"),  ONLINE_SHOP(2, "网络销售");

    @EnumValue//标记数据库存的值是code
    private final int code;
    private final String descp;

    OrderTypeEnum(int code, String descp) {
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
