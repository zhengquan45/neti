package com.zhq.neti.controller.manage;

import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.pojo.RoleAcl;
import com.zhq.neti.service.RoleAclService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengquan
 * @date 2019/7/20
 */
@RestController
@RequestMapping("/manage/roleAcl")
public class RoleAclController {

    @Autowired
    private RoleAclService roleAclService;

    @PostMapping
    public ServerResponse upsert(RoleAcl roleAcl){
        return roleAclService.upsert(roleAcl);
    }
}
