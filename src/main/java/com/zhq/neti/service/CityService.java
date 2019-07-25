package com.zhq.neti.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.mapper.CityMapper;
import com.zhq.neti.pojo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CityService {

    @Autowired
    private CityMapper cityMapper;

    public ServerResponse findAllProvince(){
        return ServerResponse.createBySuccess(cityMapper.selectList(Wrappers.<City>lambdaQuery().eq(City::getPid,0)));
    }

    public ServerResponse findAllCityByProvinceId(Integer pid){
        return ServerResponse.createBySuccess(cityMapper.selectList(Wrappers.<City>lambdaQuery().eq(City::getPid,pid)));
    }

    public ServerResponse findAllCity(){
        return ServerResponse.createBySuccess(cityMapper.findAllCity());
    }
}
