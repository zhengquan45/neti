package com.zhq.neti.service;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhq.neti.common.BeanValidator;
import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.mapper.BrandMapper;
import com.zhq.neti.pojo.Brand;
import com.zhq.neti.vo.BrandVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhengquan
 * @date 2019/7/15
 */
@Service
public class BrandService {

    @Autowired
    private BrandMapper brandMapper;


    public ServerResponse save(BrandVO brandVO) {
        BeanValidator.check(brandVO);
        Brand brand = brandVO.adapt();
        ServerResponse response = checkValid(brand.getName());
        if(!response.isSuccess()){
            return response;
        }
        if(brandMapper.insert(brand)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    private ServerResponse checkValid(String name) {
        int resultCount = brandMapper.selectCount(Wrappers.<Brand>lambdaQuery().eq(Brand::getName, name));
        if (resultCount > 0) {
            return ServerResponse.createByErrorMessage("品牌名称已被占用");
        }
        return ServerResponse.createBySuccess();
    }

    public ServerResponse delete(List<Long> ids) {
        if(CollUtil.isEmpty(ids)){
            return ServerResponse.createByErrorMessage("请选择移除的品牌");
        }
        if(brandMapper.deleteBatchIds(ids)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }
}
