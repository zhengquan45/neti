package com.zhq.neti.common;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;
import com.zhq.neti.pojo.User;

/**
 * @author zhengquan
 * @date 2019/7/27
 */
public class SessionCache {

    private static final long EXPIRE = 30 * 60 * 1000;

    private static TimedCache<String, User> cache = CacheUtil.newTimedCache(EXPIRE);

    public static void save(String token,User user){
        cache.put(token,user);
    }

    public static void remove(String token){
        cache.remove(token);
    }

    public static User get(String token){
        return cache.get(token,true);
    }

}
