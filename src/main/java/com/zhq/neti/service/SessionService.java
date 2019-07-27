package com.zhq.neti.service;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.common.SessionCache;
import com.zhq.neti.mapper.UserMapper;
import com.zhq.neti.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author zhengquan
 */
@Service
public class SessionService {

    @Autowired
    private UserMapper userMapper;

    public ServerResponse login(String username, String password) {

        User user = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, username).eq(User::getPassword, SecureUtil.md5(password)));
        if(user!=null){
            user.setPassword(null);
            String token = IdUtil.fastSimpleUUID();
            SessionCache.save(token,user);
            Map<String,Object> result = MapUtil.newHashMap();
            result.put("user",user);
            result.put("token",token);
            return ServerResponse.createBySuccess(result);
        }
        return ServerResponse.createByErrorMessage("账号或密码错误");
    }

    public void logout(String token) {
        SessionCache.remove(token);
    }
}
