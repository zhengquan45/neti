package com.zhq.neti.controller.manage;

import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.service.SkuService;
import com.zhq.neti.vo.PageQuery;
import com.zhq.neti.vo.SkuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhengquan
 * @date 2019/7/21
 */
@RestController
@RequestMapping("/manage/sku")
public class SkuController {

    @Autowired
    private SkuService skuService;

    @PostMapping
    public ServerResponse save(SkuVO skuVO){
        return skuService.save(skuVO);
    }

    @DeleteMapping
    public ServerResponse delete(@RequestParam("ids") List<Long> ids){
        return skuService.delete(ids);
    }

    @PutMapping
    public ServerResponse update(SkuVO skuVO){
        return skuService.update(skuVO);
    }

    @GetMapping
    public ServerResponse find(@RequestParam Long id){
        return skuService.find(id);
    }

    @GetMapping("/list")
    public ServerResponse findListByCondition(String title, Long spuId, PageQuery pageQuery){
        return skuService.findListByCondition(title,spuId,pageQuery);
    }

}
