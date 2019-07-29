package com.zhq.neti.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum  EmpStatusEnum implements CodeEnum{

    ON(1, "在职"),QUIT(2, "离职"),VACATION(3, "休假"),DEAD(4, "死亡");

    @EnumValue//标记数据库存的值是code
    private final int code;
    private final String descp;

    EmpStatusEnum(int code, String descp) {
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
