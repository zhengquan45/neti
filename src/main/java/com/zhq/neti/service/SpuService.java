package com.zhq.neti.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhq.neti.common.BeanValidator;
import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.mapper.SpuMapper;
import com.zhq.neti.pojo.Spu;
import com.zhq.neti.pojo.User;
import com.zhq.neti.vo.BrandVO;
import com.zhq.neti.vo.PageQuery;
import com.zhq.neti.vo.SpuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhengquan
 * @date 2019/7/21
 */
@Service
public class SpuService {

    @Autowired
    private SpuMapper spuMapper;

    public ServerResponse save(SpuVO spuVO) {
        BeanValidator.check(spuVO);
        Spu spu = spuVO.adapt();
        if(spuMapper.insert(spu)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse delete(List<Long> ids) {
        if(CollUtil.isEmpty(ids)){
            return ServerResponse.createByErrorMessage("请选择要移除的产品");
        }
        if(spuMapper.deleteBatchIds(ids)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse update(SpuVO spuVO) {
        if(spuVO.getId()==null){
            return ServerResponse.createByErrorMessage("请选择要修改的产品");
        }
        Spu spu = spuVO.adapt();
        if(spuMapper.updateById(spu)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse find(Long id) {
        Spu spu = spuMapper.selectById(id);
        if(spu!=null){
            return ServerResponse.createBySuccess(spu);
        }
        return ServerResponse.createByErrorMessage("未找到该产品");
    }

    public ServerResponse findListByCondition(String title, Long brandId, PageQuery pageQuery) {
        BeanValidator.check(pageQuery);
        Wrapper<Spu> wrapper = Wrappers.<Spu>lambdaQuery().like(StrUtil.isNotBlank(title),Spu::getTitle, title).eq(brandId!=null,Spu::getBrandId, brandId);
        IPage<Spu> page = spuMapper.selectPage(pageQuery.adapt(), wrapper);
        return ServerResponse.createBySuccess(page);
    }
}
