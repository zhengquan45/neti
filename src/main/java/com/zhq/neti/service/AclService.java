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
import com.zhq.neti.util.LevelUtil;
import com.zhq.neti.vo.AclVO;
import com.zhq.neti.vo.BrandVO;
import com.zhq.neti.vo.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        //添加层级关系
        acl.setLevel(LevelUtil.calculateLevel(getLevel(acl.getParentId()),acl.getParentId()));
        if(aclMapper.insert(acl)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    private String getLevel(Long parentId) {
        Acl acl = aclMapper.selectById(parentId);
        if(acl==null){
            return null;
        }
        return acl.getLevel();
    }

    public ServerResponse delete(Long id) {
        if(id==null){
            return ServerResponse.createByErrorMessage("请选择移除的权限点");
        }
        if(aclMapper.selectCount(Wrappers.<Acl>lambdaQuery().eq(Acl::getId,id)) ==0) {
            return ServerResponse.createByErrorMessage("该权限点不存在");
        }
        if(aclMapper.selectCount(Wrappers.<Acl>lambdaQuery().eq(Acl::getParentId,id)) > 0) {
            return ServerResponse.createByErrorMessage("该权限点下有子权限无法删除");
        }
        if(aclMapper.deleteById(id)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse update(AclVO aclVO) {
        if(aclVO.getId()==null){
            return ServerResponse.createByErrorMessage("请选择要修改的权限点");
        }
        Acl acl = aclVO.adapt();
        acl.setLevel(LevelUtil.calculateLevel(getLevel(acl.getParentId()),acl.getParentId()));
        Acl oldAcl = aclMapper.selectById(acl.getId());
        if(updateWithChild(oldAcl, acl)){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();

    }

    @Transactional(rollbackFor = Exception.class)
    public boolean updateWithChild(Acl oldAcl, Acl newAcl) {
        String newLevelPrefix = oldAcl.getLevel();
        String oldLevelPrefix = newAcl.getLevel();
        if (!oldAcl.getLevel().equals(newAcl.getLevel())) {
            String curLevel = oldAcl.getLevel() + "." + oldAcl.getId();
            List<Acl> aclList = aclMapper.selectList(Wrappers.<Acl>lambdaQuery().likeRight(Acl::getLevel,curLevel));
            if (CollUtil.isNotEmpty(aclList)) {
                for (Acl acl : aclList) {
                    String level = acl.getLevel();
                    if (level.equals(curLevel) || level.indexOf(curLevel + ".") == 0) {
                        // getChildAclModuleListByLevel可能会取出多余的内容，因此需要加个判断
                        // 比如0.1* 可能取出0.1、0.1.3、0.11、0.11.3，而期望取出  0.1、0.1.3， 因此呢需要判断等于0.1或者以0.1.为前缀才满足条件
                        level = newLevelPrefix + level.substring(oldLevelPrefix.length());
                        acl.setLevel(level);
                    }
                }
                aclMapper.batchUpdateLevel(aclList);
            }
        }
        aclMapper.updateById(newAcl);
        return true;
    }

    public ServerResponse find(Long id) {
        Acl acl = aclMapper.selectById(id);
        if(acl!=null){
            return ServerResponse.createBySuccess(acl);
        }
        return ServerResponse.createByErrorMessage("未找到该权限点");
    }


}
