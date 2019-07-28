package com.zhq.neti.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhq.neti.common.BeanValidator;
import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.mapper.UserMapper;
import com.zhq.neti.pojo.User;
import com.zhq.neti.vo.PageQuery;
import com.zhq.neti.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        user.setPassword(SecureUtil.md5(user.getPassword()));
        if(userMapper.insert(user) > 0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse delete(List<Long> ids){
        if(CollUtil.isEmpty(ids)){
            return ServerResponse.createByErrorMessage("请选择要移除的用户");
        }
        if(userMapper.deleteBatchIds(ids)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse update(UserVO userVO){
        if(userVO.getId()==null){
            return ServerResponse.createByErrorMessage("请选择要修改的用户");
        }
        BeanValidator.check(userVO);
        User user = userVO.adapt();
        if(userMapper.updateById(user)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse find(Long id){
        User user = userMapper.selectById(id);
        if(user!=null){
            user.setPassword(null);
            return ServerResponse.createBySuccess(user);
        }
       return ServerResponse.createByErrorMessage("未找到该用户");
    }

    public ServerResponse findListByCondition(String username, Integer status, PageQuery pageQuery){
        BeanValidator.check(pageQuery);
        Wrapper<User> wrapper = Wrappers.<User>lambdaQuery().like(StrUtil.isNotEmpty(username),User::getUsername, username).eq(status!=null,User::getStatus, status);
        IPage<User> page = userMapper.selectPage(pageQuery.adapt(), wrapper);
        return ServerResponse.createBySuccess(page);
    }

    public ServerResponse checkValid(String name) {
        int resultCount = userMapper.selectCount(Wrappers.<User>lambdaQuery().eq(User::getUsername, name));
        if (resultCount > 0) {
            return ServerResponse.createByErrorMessage("用户名已被占用");
        }
        return ServerResponse.createBySuccess();
    }

}
