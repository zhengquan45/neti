package com.zhq.neti.service;

import com.zhq.neti.mapper.AclMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreeService {

    @Autowired
    private AclMapper aclMapper;


}
