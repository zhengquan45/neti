package com.zhq.neti.controller.manage;

import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.service.AclDataService;
import com.zhq.neti.vo.AclDataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhengquan
 */
@RestController
@RequestMapping("/manage/aclData")
public class AclDataController {

    @Autowired
    private AclDataService aclDataService;

    @PostMapping
    public ServerResponse save(AclDataVO aclDataVO){
        return aclDataService.save(aclDataVO);
    }

    @DeleteMapping
    public ServerResponse delete(@RequestParam("ids") List<Long> ids){
        return aclDataService.delete(ids);
    }

    @PutMapping
    public ServerResponse update(AclDataVO aclDataVO){
        return  aclDataService.update(aclDataVO);
    }

    @GetMapping
    public ServerResponse find(@RequestParam Long id){
        return aclDataService.find(id);
    }

}
