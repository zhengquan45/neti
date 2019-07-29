package com.zhq.neti.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @author zhengquan
 */

public enum AclDataNextOperationEnum implements CodeEnum{
    NONE(0, "没其他参数控制"),AND(1, "与"),OR(2, "或");

    @EnumValue//标记数据库存的值是code
    private final int code;
    private final String descp;

    AclDataNextOperationEnum(int code, String descp) {
        this.code = code;
        this.descp = descp;
    }

    @Override
    public int getCode() {
        return code;
    }

    public String getDescp() {
        return descp;
    }
}
