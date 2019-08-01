package com.zhq.neti;

import com.zhq.neti.mapper.AclMapper;
import com.zhq.neti.pojo.Acl;
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
    private AclMapper aclMapper;


    @Test
    public void test2() {
        List<Acl> list = aclMapper.selectList(null);
        for (Acl acl : list) {
            System.out.println(acl.toString());
        }
    }


}
