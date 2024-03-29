package com.zhq.neti.controller.manage;

import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.service.AclService;
import com.zhq.neti.vo.AclVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhengquan
 */
@RestController
@RequestMapping("/manage/acl")
public class AclController {

    @Autowired
    private AclService aclService;

    @PostMapping
    public ServerResponse save(AclVO aclVO){
        return aclService.save(aclVO);
    }

    @DeleteMapping
    public ServerResponse delete(@RequestParam Long id){
        return aclService.delete(id);
    }

    @PutMapping
    public ServerResponse update(AclVO aclVO){
        return  aclService.update(aclVO);
    }

    @GetMapping
    public ServerResponse find(@RequestParam Long id){
        return aclService.find(id);
    }

    @GetMapping("/list")
    public ServerResponse findList(){
        return aclService.findList();
    }

}
