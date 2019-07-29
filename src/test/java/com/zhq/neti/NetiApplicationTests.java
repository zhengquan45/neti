package com.zhq.neti;

import com.zhq.neti.mapper.BackStockMapper;
import com.zhq.neti.mapper.CityMapper;
import com.zhq.neti.pojo.City;
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
    private UserService userService;

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private BackStockMapper backStockMapper;


    @Test
    public void contextLoads() {


    }

    @Test
    public void test1() {
        List<City> allCity = cityMapper.findAllCity();
    }


    @Test
    public void test2() {

    }


}
