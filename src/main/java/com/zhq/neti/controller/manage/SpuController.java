package com.zhq.neti.controller.manage;

import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.service.SpuService;
import com.zhq.neti.vo.PageQuery;
import com.zhq.neti.vo.SpuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhengquan
 * @date 2019/7/21
 */
@RestController
@RequestMapping("/manage/spu")
public class SpuController {


    @Autowired
    private SpuService spuService;

    @PostMapping
    public ServerResponse save(SpuVO spuVO){
        return spuService.save(spuVO);
    }

    @DeleteMapping
    public ServerResponse delete(@RequestParam("ids") List<Long> ids){
        return spuService.delete(ids);
    }

    @PutMapping
    public ServerResponse update(SpuVO spuVO){
        return spuService.update(spuVO);
    }

    @GetMapping
    public ServerResponse find(@RequestParam Long id){
        return spuService.find(id);
    }

    @GetMapping("/list")
    public ServerResponse findListByCondition(String title, Long brandId, PageQuery pageQuery){
        return spuService.findListByCondition(title,brandId,pageQuery);
    }
}
