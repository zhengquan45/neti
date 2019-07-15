package com.zhq.neti.controller;

import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping
    @ResponseBody
    public ServerResponse login(@RequestParam String username,
                                            @RequestParam String password){
            return sessionService.login(username,password);

    }
}
