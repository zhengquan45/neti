package com.zhq.neti.controller.manage;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhq.neti.common.Const;
import com.zhq.neti.mapper.DeptMapper;
import com.zhq.neti.mapper.JobMapper;
import com.zhq.neti.pojo.Dept;
import com.zhq.neti.pojo.Job;
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
public class EmpControllerTest extends BaseLoginTest {

    private List<String> jobIdList;

    private List<String> deptIdList;
    @Autowired
    private JobMapper jobMapper;
    @Autowired
    private DeptMapper deptMapper;

    @Before
    public void setup(){
        jobIdList = jobMapper.selectList(Wrappers.<Job>lambdaQuery().select(Job::getId)).stream().map(job -> job.getId().toString()).collect(Collectors.toList());
        deptIdList = deptMapper.selectList(Wrappers.<Dept>lambdaQuery().select(Dept::getId)).stream().map(dept -> dept.getId().toString()).collect(Collectors.toList());
    }

    @Test
    public void A_save() throws Exception {
        String result = mockMvc.perform(post("/manage/emp")
                .param("name", MockUtil.cname())
                .param("code", RandomUtil.randomNumbers(8))
                .param("sex",MockUtil.integer(1,2).toString())
                .param("married",MockUtil.bool()+"")
                .param("education",MockUtil.integer(1,8).toString())
                .param("tel",MockUtil.tel())
                .param("email",MockUtil.email())
                .param("address",MockUtil.county(true))
                .param("jobId",MockUtil.pick(jobIdList))
                .param("deptId",MockUtil.pick(deptIdList))
                .param("hiredate",MockUtil.date("yyyy-MM-dd"))
                .param("status","1")
                .header(Const.TOKEN,token)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info("result:{}",result);
    }

    @Test
    public void B_findListByCondition() throws Exception {
        String result = mockMvc.perform(get("/manage/emp/list")
                .header(Const.TOKEN,token)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info("result:{}",result);
    }

    @Test
    public void C_find() throws Exception {
        String result = mockMvc.perform(get("/manage/emp")
                .param("id","1158933145043668994")
                .header(Const.TOKEN,token)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info("result:{}",result);
    }



    @Test
    public void D_update() throws Exception {
        String result = mockMvc.perform(put("/manage/emp")
                .param("id","1158933145043668994")
                .param("name", MockUtil.cname())
                .param("code", RandomUtil.randomNumbers(8))
                .param("sex",MockUtil.integer(1,2).toString())
                .param("married",MockUtil.bool()+"")
                .param("education",MockUtil.integer(1,8).toString())
                .param("tel",MockUtil.tel())
                .param("email",MockUtil.email())
                .param("address",MockUtil.county(true))
                .param("jobId",MockUtil.pick(jobIdList))
                .param("deptId",MockUtil.pick(deptIdList))
                .param("hiredate",MockUtil.date("yyyy-MM-dd"))
                .param("status","1")
                .header(Const.TOKEN,token)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info("result:{}",result);
    }

    @Test
    public void E_delete() throws Exception {
        String result = mockMvc.perform(delete("/manage/emp")
                .param("ids","1158933145043668994")
                .header(Const.TOKEN,token)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info("result:{}",result);

    }




}