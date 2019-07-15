package com.zhq.neti.controller;

import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.service.BrandService;
import com.zhq.neti.vo.BrandVO;
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
    @ResponseBody
    public ServerResponse save(BrandVO brandVO){
        return brandService.save(brandVO);
    }

    @DeleteMapping
    @ResponseBody
    public ServerResponse delete(@RequestParam("ids") List<Long> ids){
        return brandService.delete(ids);
    }
}
