package com.zhq.neti.controller.manage;

import com.zhq.neti.common.Const;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class SessionControllerTest extends BaseLoginTest{

    @Test
    public void menu() throws Exception{
        mockMvc.perform(get("/manage/session/menu")
                .header(Const.TOKEN,token)
                .contentType(MediaType.APPLICATION_JSON_UTF8));
    }
}