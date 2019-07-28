package com.zhq.neti.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhq.neti.common.BeanValidator;
import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.mapper.SkuMapper;
import com.zhq.neti.pojo.Sku;
import com.zhq.neti.pojo.Spu;
import com.zhq.neti.vo.PageQuery;
import com.zhq.neti.vo.SkuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhengquan
 * @date 2019/7/21
 */
@Service
public class SkuService {

    @Autowired
    private SkuMapper skuMapper;

    public ServerResponse save(SkuVO skuVO) {
        BeanValidator.check(skuVO);
        Sku sku = skuVO.adapt();
        if (skuMapper.insert(sku) > 0) {
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse delete(List<Long> ids) {
        if(CollUtil.isEmpty(ids)){
            return ServerResponse.createByErrorMessage("请选择要移除的商品");
        }
        if(skuMapper.deleteBatchIds(ids)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse update(SkuVO skuVO) {
        if(skuVO.getId()==null){
            return ServerResponse.createByErrorMessage("请选择要修改的商品");
        }
        Sku sku = skuVO.adapt();
        if(skuMapper.updateById(sku)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse find(Long id) {
        Sku sku = skuMapper.selectById(id);
        if(sku!=null){
            return ServerResponse.createBySuccess(sku);
        }
        return ServerResponse.createByErrorMessage("未找到该产品");
    }

    public ServerResponse findListByCondition(String title, Long spuId, PageQuery pageQuery) {
        BeanValidator.check(pageQuery);
        Wrapper<Sku> wrapper = Wrappers.<Sku>lambdaQuery().like(StrUtil.isNotEmpty(title),Sku::getTitle, title).eq(spuId!=null,Sku::getSpuId, spuId);
        IPage<Sku> page = skuMapper.selectPage(pageQuery.adapt(), wrapper);
        return ServerResponse.createBySuccess(page);
    }
}
