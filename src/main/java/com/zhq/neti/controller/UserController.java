package com.zhq.neti.controller;

import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.service.UserService;
import com.zhq.neti.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengquan
 * @date 2019/7/14
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseBody
    public ServerResponse save(UserVO userVO) {
        return userService.save(userVO);
    }
}
