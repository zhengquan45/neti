package com.zhq.neti.controller.manage;

import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.service.CategoryService;
import com.zhq.neti.vo.CategoryVO;
import com.zhq.neti.vo.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhengquan
 * @date 2019/7/20
 */
@RestController
@RequestMapping("/manage/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ServerResponse save(CategoryVO categoryVO){
        return categoryService.save(categoryVO);
    }

    @DeleteMapping
    public ServerResponse delete(@RequestParam("ids") List<Long> ids){
        return categoryService.delete(ids);
    }

    @PutMapping
    public ServerResponse update(CategoryVO categoryVO){
        return  categoryService.update(categoryVO);
    }

    @GetMapping
    public ServerResponse find(@RequestParam Long id){
        return categoryService.find(id);
    }

    @GetMapping("/list")
    public ServerResponse findListByCondition(String name,PageQuery pageQuery){
        return categoryService.findListByCondition(name,pageQuery);
    }
}
