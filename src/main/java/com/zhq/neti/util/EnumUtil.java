package com.zhq.neti.util;

import com.zhq.neti.common.enums.CodeEnum;

/**
 * @author zhengquan
 * @date 2019/7/29
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getEnumByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if(code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
