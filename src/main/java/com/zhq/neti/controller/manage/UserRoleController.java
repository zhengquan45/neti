package com.zhq.neti.controller.manage;

import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.pojo.UserRole;
import com.zhq.neti.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengquan
 * @date 2019/7/20
 */
@RestController
@RequestMapping("/manage/userRole")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @PostMapping
    public ServerResponse upsert(UserRole userRole){
        return userRoleService.upsert(userRole);
    }
}
