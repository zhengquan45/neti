package com.zhq.neti.controller.manage;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhq.neti.common.Const;
import com.zhq.neti.mapper.EmpMapper;
import com.zhq.neti.mapper.RoleMapper;
import com.zhq.neti.pojo.Emp;
import com.zhq.neti.pojo.Role;
import com.zhq.neti.util.MockUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author zhengquan
 * @date 2019/8/4
 */
@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserControllerTest extends BaseLoginTest{

    private List<String> empIdList;

    private List<String> roleIdList;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Before
    public void setup(){
        empIdList = empMapper.selectList(Wrappers.<Emp>lambdaQuery().select(Emp::getId)).stream().map(emp -> emp.getId().toString()).collect(Collectors.toList());
        roleIdList =  roleMapper.selectList(Wrappers.<Role>lambdaQuery().select(Role::getId)).stream().map(role -> role.getId().toString()).collect(Collectors.toList());
    }
    @Test
    public void A_save() throws Exception {
        String result = mockMvc.perform(post("/manage/user")
                .header(Const.TOKEN,token)
                .param("username", MockUtil.word())
                .param("password","123456")
                .param("empId",MockUtil.pick(empIdList))
                .param("roleId",MockUtil.pick(roleIdList))
                .param("status","1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info("result:{}",result);
    }

    @Test
    public void B_findListByCondition() throws Exception {
        String result = mockMvc.perform(get("/manage/user/list")
                .header(Const.TOKEN,token)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info("result:{}",result);
    }

    @Test
    public void C_find() throws Exception {
        String result = mockMvc.perform(get("/manage/user")
                .param("id","1158944991863668737")
                .header(Const.TOKEN,token)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info("result:{}",result);

    }

    @Test
    public void D_update()throws Exception  {
        String result = mockMvc.perform(put("/manage/user")
                .param("id","1158944991863668737")
                .param("roleId",MockUtil.pick(roleIdList))
                .header(Const.TOKEN,token)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info("result:{}",result);
    }



    @Test
    public void E_delete() throws Exception {
        String result = mockMvc.perform(delete("/manage/user")
                .param("ids","1158944991863668737")
                .header(Const.TOKEN,token)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info("result:{}",result);
    }


}