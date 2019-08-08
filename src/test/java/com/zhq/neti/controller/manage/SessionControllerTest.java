package com.zhq.neti.controller.manage;

import com.zhq.neti.common.Const;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
public class SessionControllerTest extends BaseLoginTest{

    @Test
    public void menu() throws Exception{
        String result = mockMvc.perform(get("/manage/session/menu")
                .header(Const.TOKEN,token)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info("result:{}",result);
    }
}