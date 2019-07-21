package com.zhq.neti.service;

import cn.hutool.core.map.MapUtil;
import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.mapper.SkuMapper;
import com.zhq.neti.mapper.SpuMapper;
import com.zhq.neti.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author zhengquan
 * @date 2019/7/21
 */
@Service
public class DashboardService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SpuMapper spuMapper;
    @Autowired
    private SkuMapper skuMapper;

    public ServerResponse data() {
        HashMap<String, Integer> map = MapUtil.newHashMap();
        map.put("userCount",userMapper.selectCount(null));
        map.put("spuCount",spuMapper.selectCount(null));
        map.put("skuCount",skuMapper.selectCount(null));
        return ServerResponse.createBySuccess(map);
    }
}
