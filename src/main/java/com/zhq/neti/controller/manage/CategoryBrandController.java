package com.zhq.neti.controller.manage;

import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.pojo.CategoryBrand;
import com.zhq.neti.service.CategoryBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengquan
 * @date 2019/7/20
 */
@RestController
@RequestMapping("/manage/categoryBrand")
public class CategoryBrandController {

    @Autowired
    private CategoryBrandService categoryBrandService;

    @PostMapping
    public ServerResponse upsert(CategoryBrand categoryBrand){
        return categoryBrandService.upsert(categoryBrand);
    }
}
