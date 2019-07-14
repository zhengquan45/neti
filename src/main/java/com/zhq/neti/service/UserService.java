package com.zhq.neti.service;

import cn.hutool.core.bean.BeanUtil;
import com.zhq.neti.common.BeanValidator;
import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.mapper.UserMapper;
import com.zhq.neti.pojo.User;
import com.zhq.neti.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhengquan
 * @date 2019/7/14
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public ServerResponse save(UserVO userVO){
        BeanValidator.check(userVO);
        User user = userVO.adapt();
        if(userMapper.insert(user) > 0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }
}
