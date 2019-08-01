package com.zhq.neti.common;

import cn.hutool.crypto.SecureUtil;

public class IdSnow {

    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            System.out.println(IdUtil.getSnowflake(1L, 1L).nextId());
//        }

        System.out.println(SecureUtil.md5("123456"));
    }
}
