package com.zhq.neti.service;

import cn.hutool.core.collection.CollUtil;
import com.zhq.neti.common.BeanValidator;
import com.zhq.neti.common.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhengquan
 */
@Service
public class AclModuleService {

    @Autowired
    private AclModuleMapper aclModuleMapper;

    public ServerResponse save(AclModuleVO aclModuleVO) {
        BeanValidator.check(aclModuleVO);
        AclModule aclModule = aclModuleVO.adapt();
        if(aclModuleMapper.insert(aclModule)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse delete(List<Long> ids) {
        if(CollUtil.isEmpty(ids)){
            return ServerResponse.createByErrorMessage("请选择移除的权限模块");
        }
        if(aclModuleMapper.deleteBatchIds(ids)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse update(AclModuleVO aclModuleVO) {
        if(aclModuleVO.getId()==null){
            return ServerResponse.createByErrorMessage("请选择要修改的权限模块");
        }
        BeanValidator.check(aclModuleVO);
        AclModule aclModule = aclModuleVO.adapt();
        if(aclModuleMapper.updateById(aclModule)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse find(Long id) {
        AclModule aclModule = aclModuleMapper.selectById(id);
        if(aclModule!=null){
            return ServerResponse.createBySuccess(aclModule);
        }
        return ServerResponse.createByErrorMessage("未找到该权限模块");
    }

}
