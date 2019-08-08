package com.zhq.neti.controller.manage;

import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.service.BrandService;
import com.zhq.neti.vo.BrandVO;
import com.zhq.neti.vo.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhengquan
 * @date 2019/7/15
 */
@RestController
@RequestMapping("/manage/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping
    public ServerResponse save(BrandVO brandVO){
        return brandService.save(brandVO);
    }

    @DeleteMapping
    public ServerResponse delete(@RequestParam("ids") List<Long> ids){
        return brandService.delete(ids);
    }

    @PutMapping
    public ServerResponse update(BrandVO brandVO){
        return  brandService.update(brandVO);
    }

    @GetMapping
    public ServerResponse find(@RequestParam Long id){
        return brandService.find(id);
    }

    @GetMapping("/list")
    public ServerResponse findListByCondition(String name, String letter, PageQuery pageQuery){
        return brandService.findListByCondition(name,letter,pageQuery);
    }
}
