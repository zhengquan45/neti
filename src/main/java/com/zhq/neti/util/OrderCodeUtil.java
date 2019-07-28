package com.zhq.neti.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author zhengquan
 * @date 2019/7/27
 */
public class OrderCodeUtil {

    public static String createOrderCode(String type,String organizationId,String spgId,String date){
        StringBuffer sb = new StringBuffer();
        sb.append(type);
        sb.append(organizationId);
        sb.append(spgId);
        sb.append(date);
        ThreadLocalRandom.current().ints(0,9).limit(10).forEach(one->{
            sb.append(one);
        });

        return sb.toString();
    }

}
