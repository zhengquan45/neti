package com.zhq.neti.controller.manage;

import com.zhq.neti.common.Const;
import com.zhq.neti.util.MockUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BrandControllerTest extends BaseLoginTest{

    @Test
    public void A_save() throws Exception {
        mockMvc.perform(post("/manage/brand")
                .header(Const.TOKEN,token)
                .param("name", MockUtil.pick(MockUtil.brands))
                .param("images",MockUtil.image("300x250"))
                .param("letter",MockUtil.character("upper").toString())
                .contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void B_findListByCondition() throws Exception  {
        mockMvc.perform(get("/manage/brand/list")
                .header(Const.TOKEN,token)
                .contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void C_find()  throws Exception {
        mockMvc.perform(get("/manage/brand")
                .param("id","1159277282376814593")
                .header(Const.TOKEN,token)
                .contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void D_update()  throws Exception {
        String result = mockMvc.perform(put("/manage/brand")
                .param("id","1159277282376814593")
                .param("name", MockUtil.pick(MockUtil.brands))
                .param("letter",MockUtil.character("upper").toString())
                .header(Const.TOKEN,token)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info("result:{}",result);
    }


    @Test
    public void E_delete()  throws Exception {
        String result = mockMvc.perform(delete("/manage/brand")
                .param("ids","1159277282376814593")
                .header(Const.TOKEN,token)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info("result:{}",result);
    }

}