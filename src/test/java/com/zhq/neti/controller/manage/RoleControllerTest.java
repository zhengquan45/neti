package com.zhq.neti.controller.manage;

import com.zhq.neti.common.Const;
import com.zhq.neti.util.MockUtil;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

/**
 * @author zhengquan
 * @date 2019/8/4
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoleControllerTest extends BaseLoginTest{


    @Test
    public void A_save() throws Exception {
        mockMvc.perform(post("/manage/role")
                .header(Const.TOKEN,token)
                .param("name", MockUtil.pick(MockUtil.roles))
                .param("remark",MockUtil.cparagraph())
                .contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void B_findList() throws Exception {
        mockMvc.perform(get("/manage/role/list")
                .header(Const.TOKEN,token)
                .contentType(MediaType.APPLICATION_JSON_UTF8));
    }
    @Test
    public void C_find() throws Exception {
         mockMvc.perform(get("/manage/role")
                .header(Const.TOKEN,token)
                .param("id", "1157942363786182658")
                .contentType(MediaType.APPLICATION_JSON_UTF8));
    }


    @Test
    public void D_update() throws Exception {
        mockMvc.perform(put("/manage/role")
                .header(Const.TOKEN,token)
                .param("id", "1157942363786182658")
                .param("name", MockUtil.pick(MockUtil.roles))
                .param("remark",MockUtil.cparagraph())
                .contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void E_del() throws Exception {
        mockMvc.perform(delete("/manage/role")
                .header(Const.TOKEN,token)
                .param("ids", "1157942363786182658")
                .contentType(MediaType.APPLICATION_JSON_UTF8));
    }


}