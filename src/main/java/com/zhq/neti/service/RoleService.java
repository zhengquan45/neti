package com.zhq.neti.service;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhq.neti.common.BeanValidator;
import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.mapper.RoleMapper;
import com.zhq.neti.pojo.Brand;
import com.zhq.neti.pojo.Role;
import com.zhq.neti.vo.PageQuery;
import com.zhq.neti.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public ServerResponse save(RoleVO roleVO) {
        BeanValidator.check(roleVO);
        Role role = roleVO.adapt();
        if(roleMapper.insert(role)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse delete(List<Long> ids) {
        if(CollUtil.isEmpty(ids)){
            return ServerResponse.createByErrorMessage("请选择移除的角色");
        }
        if(roleMapper.deleteBatchIds(ids)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse update(RoleVO roleVO) {
        if(roleVO.getId()==null){
            return ServerResponse.createByErrorMessage("请选择要修改的角色");
        }
        Role role = roleVO.adapt();
        if(roleMapper.updateById(role)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse find(Long id) {
        Role role = roleMapper.selectById(id);
        if(role!=null){
            return ServerResponse.createBySuccess(role);
        }
        return ServerResponse.createByErrorMessage("未找到该角色");
    }

    public ServerResponse findList(PageQuery pageQuery) {
        IPage<Role> page = roleMapper.selectPage(pageQuery.adapt(), null);
        return ServerResponse.createBySuccess(page);
    }

    public ServerResponse checkValid(String name) {
        int resultCount = roleMapper.selectCount(Wrappers.<Role>lambdaQuery().eq(Role::getName, name));
        if (resultCount > 0) {
            return ServerResponse.createByErrorMessage("角色名称已被占用");
        }
        return ServerResponse.createBySuccess();
    }
}
