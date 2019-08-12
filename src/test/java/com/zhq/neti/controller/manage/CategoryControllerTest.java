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
 * @date 2019/8/11
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CategoryControllerTest extends BaseLoginTest {

    @Test
    public void A_save() throws Exception {
         mockMvc.perform(post("/manage/category")
                .header(Const.TOKEN,token)
                .param("name", MockUtil.ctitle())
                .param("ifParent","true")
                .param("sort","0")
                .contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void B_findListByCondition() throws Exception {
        mockMvc.perform(get("/manage/category/list")
                .header(Const.TOKEN,token)
                .contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void C_find() throws Exception {
        mockMvc.perform(get("/manage/category")
                .header(Const.TOKEN,token)
                .param("id","1160231126772174849")
                .contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void D_update() throws Exception {
        mockMvc.perform(put("/manage/category")
                .header(Const.TOKEN,token)
                .param("id","1160231126772174849")
                .param("name", MockUtil.ctitle())
                .param("ifParent","true")
                .param("sort","0")
                .contentType(MediaType.APPLICATION_JSON_UTF8));

    }

    @Test
    public void E_delete() throws Exception {
        mockMvc.perform(delete("/manage/category")
                .header(Const.TOKEN,token)
                .param("ids","1160231126772174849")
                .contentType(MediaType.APPLICATION_JSON_UTF8));
    }


}