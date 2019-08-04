package com.zhq.neti.controller.manage;

import com.zhq.neti.common.Const;
import com.zhq.neti.util.MockUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author zhengquan
 * @date 2019/8/4
 */
@Slf4j
public class UserControllerTest extends BaseLoginTest{

    @Test
    public void save() throws Exception {
        String result = mockMvc.perform(post("/manage/user")
                .header(Const.TOKEN,token)
                .param("username", MockUtil.name())
                .param("password","123456")
                .param("status","1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info("result:{}",result);
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }

    @Test
    public void find() throws Exception {
//        mockMvc.perform(get("/user")
//                .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.length()").value(3));

    }

    @Test
    public void findListByCondition() {
    }
}