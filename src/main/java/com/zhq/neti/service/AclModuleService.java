package com.zhq.neti.service;

import cn.hutool.core.collection.CollUtil;
import com.zhq.neti.common.BeanValidator;
import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.mapper.AclMapper;
import com.zhq.neti.pojo.Acl;
import com.zhq.neti.vo.AclVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AclModuleService {

    @Autowired
    private AclMapper aclMapper;

    public ServerResponse save(AclVO aclVO) {
        BeanValidator.check(aclVO);
        Acl acl = aclVO.adapt();
        if(aclMapper.insert(acl)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse delete(List<Long> ids) {
        if(CollUtil.isEmpty(ids)){
            return ServerResponse.createByErrorMessage("请选择移除的权限点");
        }
        if(aclMapper.deleteBatchIds(ids)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse update(AclVO aclVO) {
        if(aclVO.getId()==null){
            return ServerResponse.createByErrorMessage("请选择要修改的权限点");
        }
        Acl acl = aclVO.adapt();
        if(aclMapper.updateById(acl)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse find(Long id) {
        Acl acl = aclMapper.selectById(id);
        if(acl!=null){
            return ServerResponse.createBySuccess(acl);
        }
        return ServerResponse.createByErrorMessage("未找到该权限点");
    }

}
