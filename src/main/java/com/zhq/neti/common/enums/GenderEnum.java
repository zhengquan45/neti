package com.zhq.neti.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum GenderEnum implements CodeEnum{
    MALE(1, "男"),  FEMALE(2, "女");

    @EnumValue//标记数据库存的值是code
    private final int code;
    private final String descp;

    GenderEnum(int code, String descp) {
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
