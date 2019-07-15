package com.zhq.neti.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.service.UserService;
import com.zhq.neti.vo.PageQuery;
import com.zhq.neti.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping
    @ResponseBody
    public ServerResponse delete(@RequestParam("ids") List<Long> ids){
        return userService.delete(ids);
    }

    @PutMapping
    @ResponseBody
    public ServerResponse update(UserVO userVO){
        return userService.update(userVO);
    }

    @GetMapping
    @ResponseBody
    public ServerResponse find(@RequestParam Long id){
        return userService.find(id);
    }

    @GetMapping("/list")
    @ResponseBody
    public ServerResponse findlistByCondition(String username,Integer status,PageQuery pageQuery){
        return userService.findlistByCondition(username,status,pageQuery);
    }
}
