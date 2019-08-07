package com.zhq.neti.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhq.neti.common.BeanValidator;
import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.mapper.BrandMapper;
import com.zhq.neti.mapper.EmpMapper;
import com.zhq.neti.pojo.Brand;
import com.zhq.neti.pojo.Emp;
import com.zhq.neti.vo.BrandVO;
import com.zhq.neti.vo.EmpVO;
import com.zhq.neti.vo.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhengquan
 * @date 2019/7/15
 */
@Service
public class EmpService {

    @Autowired
    private EmpMapper empMapper;


    public ServerResponse save(EmpVO empVO) {
        BeanValidator.check(empVO);
        Emp emp = empVO.adapt();
        if(empMapper.insert(emp)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse delete(List<Long> ids) {
        if(CollUtil.isEmpty(ids)){
            return ServerResponse.createByErrorMessage("请选择移除的员工信息");
        }
        if(empMapper.deleteBatchIds(ids)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse update(EmpVO empVO) {
        if(empVO.getId()==null){
            return ServerResponse.createByErrorMessage("请选择要修改的员工信息");
        }
        BeanValidator.check(empVO);
        Emp emp = empVO.adapt();
        if(empMapper.updateById(emp)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse find(Long id) {
        Emp emp = empMapper.selectById(id);
        if(emp!=null){
            return ServerResponse.createBySuccess(emp);
        }
        return ServerResponse.createByErrorMessage("未找到该员工信息");
    }


    public ServerResponse findListByCondition(String name, String tel, PageQuery pageQuery) {
        BeanValidator.check(pageQuery);
        Wrapper<Emp> wrapper = Wrappers.<Emp>lambdaQuery().like(StrUtil.isNotBlank(name),Emp::getName, name).like(StrUtil.isNotBlank(tel),Emp::getTel, tel);
        IPage<Emp> page = empMapper.selectPage(pageQuery.adapt(), wrapper);
        return ServerResponse.createBySuccess(page);
    }
}
