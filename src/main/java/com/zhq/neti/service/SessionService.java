package com.zhq.neti.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.zhq.neti.common.RequestHolder;
import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.common.SessionCache;
import com.zhq.neti.common.enums.AclTypeEnum;
import com.zhq.neti.dto.MenuDto;
import com.zhq.neti.mapper.AclMapper;
import com.zhq.neti.mapper.RoleAclMapper;
import com.zhq.neti.mapper.UserMapper;
import com.zhq.neti.mapper.UserRoleMapper;
import com.zhq.neti.pojo.Acl;
import com.zhq.neti.pojo.RoleAcl;
import com.zhq.neti.pojo.User;
import com.zhq.neti.pojo.UserRole;
import com.zhq.neti.util.LevelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        if (user != null) {
            user.setPassword(null);
            String token = IdUtil.fastSimpleUUID();
            SessionCache.save(token, user);
            Map<String, Object> result = MapUtil.newHashMap();
            result.put("user", user);
            result.put("token", token);
            return ServerResponse.createBySuccess(result);
        }
        return ServerResponse.createByErrorMessage("账号或密码错误");
    }

    public void logout(String token) {
        SessionCache.remove(token);
    }

    private boolean isSuperAdmin() {
        User currentUser = RequestHolder.getCurrentUser();
        if (currentUser.getRoleId() == 0) {
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
        List<Object> userRoleIdList = userRoleMapper.selectObjs(Wrappers.<UserRole>lambdaQuery().select(UserRole::getRoleId).eq(UserRole::getUserId, userId));
        if (CollUtil.isEmpty(userRoleIdList)) {
            return Lists.newArrayList();
        }
        List<Object> userAclIdList = roleAclMapper.selectObjs(Wrappers.<RoleAcl>lambdaQuery().select(RoleAcl::getAclId).in(RoleAcl::getRoleId, userRoleIdList));
        if (CollUtil.isEmpty(userAclIdList)) {
            return Lists.newArrayList();
        }
        return aclMapper.selectList(Wrappers.<Acl>lambdaQuery().in(Acl::getId, userAclIdList));
    }

    public List<Acl> getRoleAclList(int roleId) {
        List<Object> aclIdList = roleAclMapper.selectObjs(Wrappers.<RoleAcl>lambdaQuery().select(RoleAcl::getAclId).eq(RoleAcl::getRoleId, roleId));
        if (CollUtil.isEmpty(aclIdList)) {
            return Lists.newArrayList();
        }
        return aclMapper.selectList(Wrappers.<Acl>lambdaQuery().in(Acl::getId, aclIdList));
    }


    public ServerResponse menu() {
        List<Acl> currentUserAclList = getCurrentUserAclList();
        List<Acl> aclList = currentUserAclList.stream().filter(acl -> !acl.getType().equals(AclTypeEnum.OTHER)).collect(Collectors.toList());
        if (CollUtil.isEmpty(aclList)) {
            return ServerResponse.createBySuccess(CollUtil.newArrayList());
        }
        List<MenuDto> menuDtoList= aclList.stream().map(acl-> MenuDto.adapt(acl)).collect(Collectors.toList());
        Multimap<String, MenuDto> levelMenuMap = ArrayListMultimap.create();
        List<MenuDto>rootList = CollUtil.newArrayList();
        for (MenuDto menuDto : menuDtoList) {
            levelMenuMap.put(menuDto.getLevel(),menuDto);
            if(StrUtil.equals(LevelUtil.ROOT,menuDto.getLevel())){
                rootList.add(menuDto);
            }
        }
        Collections.sort(rootList, Comparator.comparingInt(MenuDto::getSort));
        transformMenuTree(rootList, LevelUtil.ROOT, levelMenuMap);
        return ServerResponse.createBySuccess(rootList);
    }

    private void transformMenuTree(List<MenuDto> rootList, String level, Multimap<String, MenuDto> levelMenuMap) {
        for (int i = 0; i < rootList.size(); i++) {
            MenuDto dto = rootList.get(i);
            String nextLevel = LevelUtil.calculateLevel(level, dto.getId());
            List<MenuDto> tempList = (List<MenuDto>) levelMenuMap.get(nextLevel);
            if (CollUtil.isNotEmpty(tempList)) {
                Collections.sort(tempList, Comparator.comparingInt(MenuDto::getSort));
                dto.setChildren(tempList);
                transformMenuTree(tempList, nextLevel, levelMenuMap);
            }
        }
    }
}
