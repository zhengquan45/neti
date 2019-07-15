package com.zhq.neti.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.mapper.UserMapper;
import com.zhq.neti.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhengquan
 */
@Service
public class SessionService {

    @Autowired
    private UserMapper userMapper;

    public ServerResponse<User> login(String username, String password) {

        User user = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, username).eq(User::getPassword, password));
        if(user!=null){
            user.setPassword(null);
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByErrorMessage("账号或密码错误");
    }
}
