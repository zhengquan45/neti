package com.zhq.neti.controller.manage;

import com.zhq.neti.common.Const;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * @author zhengquan
 * @date 2019/8/14
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AclControllerTest extends BaseLoginTest {

    @Test
    public void A_save() throws Exception {
        mockMvc.perform(post("/manage/acl")
                .header(Const.TOKEN,token)
                .param("code", "1")
                .param("parentId","1161459876992430081")
                .param("name","aclManage")
                .param("title","权限管理")
                .param("icon","")
                .param("component","acl")
                .param("url","acl")
                .param("type","2")
                .param("status","1")
                .param("hidden","false")
                .param("sort","1")
                .param("remark","权限管理")
                .contentType(MediaType.APPLICATION_JSON_UTF8));
    }





}