package com.zhq.neti.controller.manage;

import com.zhq.neti.common.Const;
import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.service.SessionService;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhengquan
 */
@RestController
@RequestMapping("/manage/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping
    @ApiImplicitParam(name = "token", value = "token", dataType = "String",paramType="header")
    public ServerResponse login(String username, String password){
        return sessionService.login(username, password);
    }

    @DeleteMapping
    public ServerResponse logout(@RequestHeader HttpHeaders headers){
        String token = headers.getFirst(Const.TOKEN);
        sessionService.logout(token);
        return ServerResponse.createBySuccess();
    }

    @GetMapping("/user")
    public ServerResponse getUserInfo(){
        return sessionService.getUserInfo();
    }

    @GetMapping("/menu")
    public ServerResponse menu(){
        return sessionService.menu();
    }

}
