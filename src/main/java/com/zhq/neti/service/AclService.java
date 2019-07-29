package com.zhq.neti.service;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhq.neti.common.BeanValidator;
import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.mapper.AclMapper;
import com.zhq.neti.pojo.Acl;
import com.zhq.neti.pojo.Brand;
import com.zhq.neti.vo.AclVO;
import com.zhq.neti.vo.BrandVO;
import com.zhq.neti.vo.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhengquan
 * @date 2019/7/15
 */
@Service
public class AclService {

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
