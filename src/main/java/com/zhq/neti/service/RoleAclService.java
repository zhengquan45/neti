package com.zhq.neti.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.mapper.RoleAclMapper;
import com.zhq.neti.pojo.RoleAcl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleAclService {

    @Autowired
    private RoleAclMapper roleAclMapper;

    @Transactional(rollbackFor = Exception.class)
    public ServerResponse upsert(RoleAcl roleAcl) {
        roleAclMapper.delete(Wrappers.<RoleAcl>lambdaQuery().eq(RoleAcl::getRoleId, roleAcl.getRoleId()));
        roleAclMapper.insert(roleAcl);
        return ServerResponse.createBySuccess();
    }
}
