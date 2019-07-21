package com.zhq.neti.controller.manage;

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
@RequestMapping("/manage/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ServerResponse save(UserVO userVO) {
        return userService.save(userVO);
    }

    @DeleteMapping
    public ServerResponse delete(@RequestParam("ids") List<Long> ids){
        return userService.delete(ids);
    }

    @PutMapping
    public ServerResponse update(UserVO userVO){
        return userService.update(userVO);
    }

    @GetMapping
    public ServerResponse find(@RequestParam Long id){
        return userService.find(id);
    }

    @GetMapping("/list")
    public ServerResponse findlistByCondition(String username,Integer status,PageQuery pageQuery){
        return userService.findListByCondition(username,status,pageQuery);
    }
}
