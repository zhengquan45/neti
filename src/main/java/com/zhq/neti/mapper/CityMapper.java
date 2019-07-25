package com.zhq.neti.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhq.neti.pojo.City;

import java.util.List;

public interface CityMapper extends BaseMapper<City> {

    List<City> findAllCity();
}
