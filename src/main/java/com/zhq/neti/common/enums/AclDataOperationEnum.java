package com.zhq.neti.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum  AclDataOperationEnum {
    EQ(0, "等于"),GT(1, "大于"),LT(2, "小于"),GE(3, "大于等于"),LE(4, "小于等于"),IN(5, "包含"),BETWEEN(6, "小于");

    @EnumValue//标记数据库存的值是code
    private final int code;
    private final String descp;

    AclDataOperationEnum(int code, String descp) {
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
