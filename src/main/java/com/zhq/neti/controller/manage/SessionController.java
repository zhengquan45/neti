package com.zhq.neti.controller.manage;

import com.zhq.neti.common.Const;
import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.pojo.User;
import com.zhq.neti.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author zhengquan
 */
@RestController
@RequestMapping("/manage/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping
    public ServerResponse login(@RequestParam String username, @RequestParam String password, HttpSession session){
        ServerResponse<User> response = sessionService.login(username, password);
        if(response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }
        return response;
    }

    @DeleteMapping
    public ServerResponse logout(HttpSession session){
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }
}
