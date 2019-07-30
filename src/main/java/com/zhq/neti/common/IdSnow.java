package com.zhq.neti.common;

import cn.hutool.core.util.IdUtil;

public class IdSnow {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(IdUtil.getSnowflake(1L, 1L).nextId());
        }
    }
}
