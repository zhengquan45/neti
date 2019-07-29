package com.zhq.neti.controller.manage;

import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.service.AclModuleService;
import com.zhq.neti.vo.AclModuleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manage/aclModule")
public class AclModuleController {

    @Autowired
    private AclModuleService aclModuleService;

    @PostMapping
    public ServerResponse save(AclModuleVO aclModuleVO){
        return aclModuleService.save(aclModuleVO);
    }

    @DeleteMapping
    public ServerResponse delete(@RequestParam("ids") List<Long> ids){
        return aclModuleService.delete(ids);
    }

    @PutMapping
    public ServerResponse update(AclModuleVO aclModuleVO){
        return  aclModuleService.update(aclModuleVO);
    }

    @GetMapping
    public ServerResponse find(@RequestParam Long id){
        return aclModuleService.find(id);
    }

}
