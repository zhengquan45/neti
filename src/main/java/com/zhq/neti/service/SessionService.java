package com.zhq.neti.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.collect.Lists;
import com.zhq.neti.common.RequestHolder;
import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.common.SessionCache;
import com.zhq.neti.mapper.AclMapper;
import com.zhq.neti.mapper.RoleAclMapper;
import com.zhq.neti.mapper.UserMapper;
import com.zhq.neti.mapper.UserRoleMapper;
import com.zhq.neti.pojo.Acl;
import com.zhq.neti.pojo.RoleAcl;
import com.zhq.neti.pojo.User;
import com.zhq.neti.pojo.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static org.springframework.util.ObjectUtils.isEmpty;

/**
 * @author zhengquan
 */
@Service
public class SessionService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AclMapper aclMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleAclMapper roleAclMapper;

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

    private  boolean isSuperAdmin(){
        User currentUser = RequestHolder.getCurrentUser();
        if(currentUser.getRoleId()==0){
            return true;
        }
        return false;
    }

    public List<Acl> getCurrentUserAclList() {
        Long userId = RequestHolder.getCurrentUser().getId();
        return getUserAclList(userId);
    }



    public List<Acl> getUserAclList(Long userId) {
        if (isSuperAdmin()) {
            return aclMapper.selectList(null);
        }
        List<Object> userRoleIdList = userRoleMapper.selectObjs(Wrappers.<UserRole>lambdaQuery().select(UserRole::getRoleId).eq(UserRole::getUserId,userId));
        if (CollUtil.isEmpty(userRoleIdList)) {
            return Lists.newArrayList();
        }
        List<Object> userAclIdList = roleAclMapper.selectObjs(Wrappers.<RoleAcl>lambdaQuery().select(RoleAcl::getAclId).in(RoleAcl::getRoleId,userRoleIdList));
        if (CollUtil.isEmpty(userAclIdList)) {
            return Lists.newArrayList();
        }
        return aclMapper.selectList(Wrappers.<Acl>lambdaQuery().in(Acl::getId,userAclIdList));
    }

    public List<Acl> getRoleAclList(int roleId) {
        List<Object> aclIdList = roleAclMapper.selectObjs(Wrappers.<RoleAcl>lambdaQuery().select(RoleAcl::getAclId).eq(RoleAcl::getRoleId,roleId));
        if (CollUtil.isEmpty(aclIdList)) {
            return Lists.newArrayList();
        }
        return aclMapper.selectList(Wrappers.<Acl>lambdaQuery().in(Acl::getId,aclIdList));
    }


}
