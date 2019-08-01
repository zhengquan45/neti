package com.zhq.neti;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhq.neti.mapper.BackStockMapper;
import com.zhq.neti.mapper.CityMapper;
import com.zhq.neti.mapper.UserRoleMapper;
import com.zhq.neti.pojo.City;
import com.zhq.neti.pojo.UserRole;
import com.zhq.neti.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NetiApplicationTests {


    @Autowired
    private UserRoleMapper userRoleMapper;


    @Test
    public void test2() {
        List<Object> list = userRoleMapper.selectObjs(Wrappers.<UserRole>lambdaQuery().select(UserRole::getRoleId,UserRole::getUserId));
        for (Object integer : list) {
            System.out.println(integer);
        }
    }


}
