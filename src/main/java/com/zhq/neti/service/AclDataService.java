package com.zhq.neti.service;

import cn.hutool.core.collection.CollUtil;
import com.zhq.neti.common.BeanValidator;
import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.mapper.AclDataMapper;
import com.zhq.neti.mapper.AclMapper;
import com.zhq.neti.pojo.Acl;
import com.zhq.neti.pojo.AclData;
import com.zhq.neti.vo.AclDataVO;
import com.zhq.neti.vo.AclVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhengquan
 * @date 2019/7/15
 */
@Service
public class AclDataService {

    @Autowired
    private AclDataMapper aclDataMapper;

    public ServerResponse save(AclDataVO aclDataVO) {
        BeanValidator.check(aclDataVO);
        AclData aclData = aclDataVO.adapt();
        if(aclDataMapper.insert(aclData)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse delete(List<Long> ids) {
        if(CollUtil.isEmpty(ids)){
            return ServerResponse.createByErrorMessage("请选择移除的数据权限");
        }
        if(aclDataMapper.deleteBatchIds(ids)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse update(AclDataVO aclDataVO) {
        if(aclDataVO.getId()==null){
            return ServerResponse.createByErrorMessage("请选择要修改的数据权限");
        }
        BeanValidator.check(aclDataVO);
        AclData aclData = aclDataVO.adapt();
        if(aclDataMapper.updateById(aclData)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse find(Long id) {
        AclData aclData = aclDataMapper.selectById(id);
        if(aclData!=null){
            return ServerResponse.createBySuccess(aclData);
        }
        return ServerResponse.createByErrorMessage("未找到该数据权限");
    }


}
