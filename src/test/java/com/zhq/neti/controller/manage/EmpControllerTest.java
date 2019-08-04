package com.zhq.neti.controller.manage;

import com.zhq.neti.common.Const;
import lombok.extern.slf4j.Slf4j;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author zhengquan
 * @date 2019/8/4
 */
@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpControllerTest extends BaseLoginTest {


    @Test
    public void A_save() throws Exception {
        String result = mockMvc.perform(post("/manage/emp")
                .header(Const.TOKEN,token)
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
    public void find() {
    }
}