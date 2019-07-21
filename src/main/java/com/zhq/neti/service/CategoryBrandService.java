package com.zhq.neti.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.mapper.CategoryBrandMapper;
import com.zhq.neti.pojo.CategoryBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhengquan
 * @date 2019/7/21
 */
@Service
public class CategoryBrandService {

    @Autowired
    private CategoryBrandMapper categoryBrandMapper;

    @Transactional(rollbackFor = Exception.class)
    public ServerResponse upsert(CategoryBrand categoryBrand) {
        categoryBrandMapper.delete(Wrappers.<CategoryBrand>lambdaQuery().eq(CategoryBrand::getCategoryId, categoryBrand.getCategoryId()));
        categoryBrandMapper.insert(categoryBrand);
        return ServerResponse.createBySuccess();
    }
}
