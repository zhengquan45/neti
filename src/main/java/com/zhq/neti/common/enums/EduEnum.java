package com.zhq.neti.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum EduEnum implements CodeEnum{

    PRIMARY(1, "小学"),JUNIOR(2, "初中"),SENIOR(3, "高中"),COLLEGE(4, "大专"),  UNIVERSITY(5, "本科"),PG(6, "研究生"),DR(7, "博士"),OTHER(8, "其他");

    @EnumValue//标记数据库存的值是code
    private final int code;
    private final String descp;

    EduEnum(int code, String descp) {
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
