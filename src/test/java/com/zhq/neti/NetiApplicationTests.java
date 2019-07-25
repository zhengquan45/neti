package com.zhq.neti;

import cn.hutool.core.util.IdUtil;
import com.zhq.neti.mapper.CityMapper;
import com.zhq.neti.mapper.UserMapper;
import com.zhq.neti.pojo.City;
import com.zhq.neti.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NetiApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CityMapper cityMapper;


    @Test
    public void contextLoads() {
        userMapper.insert(User.builder().empId(1L).username("zhen1gquan").password("123").roleId(1L).status(1).createTime(new Date()).lastUpdateTime(new Date()).isDeleted(false).build());
        userMapper.insert(User.builder().id(IdUtil.createSnowflake(1L,1L).nextId()).empId(1L).username("zhengqua").password("123").roleId(1L).status(1).createTime(new Date()).lastUpdateTime(new Date()).isDeleted(false).build());
        //userMapper.insert(User.builder().empId(1L).username("zhengquan").password("123").roleId(1L).status(1).createTime(new Date()).lastUpdateTime(new Date()).isDeleted(false).build());

    }

    @Test
    public void test1() {
        List<City> allCity = cityMapper.findAllCity();
    }


}
