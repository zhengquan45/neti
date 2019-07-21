package com.zhq.neti.service;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhq.neti.common.BeanValidator;
import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.mapper.CategoryMapper;
import com.zhq.neti.pojo.Brand;
import com.zhq.neti.pojo.Category;
import com.zhq.neti.vo.CategoryVO;
import com.zhq.neti.vo.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhengquan
 * @date 2019/7/20
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public ServerResponse save(CategoryVO categoryVO) {
        BeanValidator.check(categoryVO);
        Category category = categoryVO.adapt();
        if (categoryMapper.insert(category) > 0) {
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse delete(List<Long> ids) {
        if(CollUtil.isEmpty(ids)){
            return ServerResponse.createByErrorMessage("请选择移除的品类");
        }
        if(categoryMapper.deleteBatchIds(ids)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse update(CategoryVO categoryVO) {
        if(categoryVO.getId()==null){
            return ServerResponse.createByErrorMessage("请选择要修改的品类");
        }
        Category category = categoryVO.adapt();
        if(categoryMapper.updateById(category)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();

    }

    public ServerResponse find(Long id) {
        Category category = categoryMapper.selectById(id);
        if(category!=null){
            return ServerResponse.createBySuccess(category);
        }
        return ServerResponse.createByErrorMessage("未找到改品类");
    }

    public ServerResponse findListByCondition(String name, PageQuery pageQuery) {
        Wrapper<Category> wrapper = Wrappers.<Category>lambdaQuery().like(Category::getName, name);
        IPage<Category> page = categoryMapper.selectPage(pageQuery.adapt(), wrapper);
        return ServerResponse.createBySuccess(page);

    }
}
