package com.zhq.neti.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.mapper.UserRoleMapper;
import com.zhq.neti.pojo.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Transactional(rollbackFor = Exception.class)
    public ServerResponse upsert(UserRole userRole) {
        userRoleMapper.delete(Wrappers.<UserRole>lambdaQuery().eq(UserRole::getUserId, userRole.getUserId()));
        userRoleMapper.insert(userRole);
        return ServerResponse.createBySuccess();
    }
}
