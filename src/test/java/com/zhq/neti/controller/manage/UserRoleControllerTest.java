package com.zhq.neti.controller.manage;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhq.neti.common.Const;
import com.zhq.neti.mapper.RoleMapper;
import com.zhq.neti.mapper.UserMapper;
import com.zhq.neti.pojo.Role;
import com.zhq.neti.pojo.User;
import com.zhq.neti.util.MockUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import javax.script.ScriptException;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * @author zhengquan
 * @date 2019/8/11
 */
public class UserRoleControllerTest extends BaseLoginTest {

    private List<String> userIdList;
    private List<String>roleIdList;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        userIdList = userMapper.selectList(Wrappers.<User>lambdaQuery().select(User::getId)).stream().map(user -> user.getId().toString()).collect(Collectors.toList());
        roleIdList = roleMapper.selectList(Wrappers.<Role>lambdaQuery().select(Role::getId)).stream().map(role -> role.getId().toString()).collect(Collectors.toList());
        System.out.println(MockUtil.pick(roleIdList));
    }

    @Test
    public void upsert() throws Exception {

        mockMvc.perform(post("/manage/userRole")
                .header(Const.TOKEN,token)
                .param("roleId", MockUtil.pick(roleIdList))
                .param("userId",MockUtil.pick(userIdList))
                .contentType(MediaType.APPLICATION_JSON_UTF8));

    }
}