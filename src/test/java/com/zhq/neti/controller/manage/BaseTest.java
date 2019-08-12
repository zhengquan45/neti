package com.zhq.neti.controller.manage;

import cn.hutool.json.JSONUtil;
import com.zhq.neti.filter.SessionFilter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author zhengquan
 * @date 2019/8/4
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BaseTest {
    @Autowired
    protected WebApplicationContext wac;

    protected MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .addFilters(new SessionFilter())
                .alwaysExpect(status().isOk())
                .alwaysDo(mvcResult -> log.info("result:{}",JSONUtil.formatJsonStr(mvcResult.getResponse().getContentAsString()))).build();
    }
}
