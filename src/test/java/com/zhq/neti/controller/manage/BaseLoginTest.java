package com.zhq.neti.controller.manage;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * @author zhengquan
 * @date 2019/8/4
 */
@Slf4j
public class BaseLoginTest extends BaseTest{

    protected String token;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        token = getToken();
    }

    private String getToken() throws Exception {
        String result = getLoginResult();
        JSONObject jsonObject = JSONUtil.parseObj(result);
        JSONObject data = JSONUtil.parseObj(jsonObject.get("data").toString());
        String token = data.get("token").toString();
        log.info("token:{}",token);
        return token;
    }

    private String getLoginResult() throws Exception {
        String result = mockMvc.perform(post("/manage/session")
                .param("username","zhengquan")
                .param("password","123456")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andReturn().getResponse().getContentAsString();
        return result;
    }
}
