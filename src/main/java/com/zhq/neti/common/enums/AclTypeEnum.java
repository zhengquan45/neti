package com.zhq.neti.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum AclTypeEnum {

    MENU(1, "菜单"),BUTTON(2, "按钮"),OTHER(3, "其他");

    @EnumValue//标记数据库存的值是code
    private final int code;
    private final String descp;

    AclTypeEnum(int code, String descp) {
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
