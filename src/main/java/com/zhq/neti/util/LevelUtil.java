package com.zhq.neti.util;

import cn.hutool.core.util.StrUtil;

public class LevelUtil {

    public final static String SEPARATOR = ".";

    public final static String ROOT = "0";

    public static String calculateLevel(String parentLevel, Long parentId) {
        if (StrUtil.isBlank(parentLevel)) {
            return ROOT;
        } else {
            return StrUtil.join(parentLevel, SEPARATOR, parentId);
        }
    }
}
