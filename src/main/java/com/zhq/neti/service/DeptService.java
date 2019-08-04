package com.zhq.neti.service;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhq.neti.common.BeanValidator;
import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.mapper.DeptMapper;
import com.zhq.neti.pojo.Brand;
import com.zhq.neti.pojo.Dept;
import com.zhq.neti.pojo.Job;
import com.zhq.neti.vo.DeptVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {

    @Autowired
    private DeptMapper deptMapper;

    public ServerResponse save(DeptVO deptVO) {
        BeanValidator.check(deptVO);
        Dept dept = deptVO.adapt();
        if(deptMapper.insert(dept)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse delete(List<Long> ids) {
        if(CollUtil.isEmpty(ids)){
            return ServerResponse.createByErrorMessage("请选择移除的部门");
        }
        if(deptMapper.deleteBatchIds(ids)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse update(DeptVO deptVO) {
        if(deptVO.getId()==null){
            return ServerResponse.createByErrorMessage("请选择要修改的部门");
        }
        Dept dept = deptVO.adapt();
        if(deptMapper.updateById(dept)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse find(Long id) {
        Dept dept = deptMapper.selectById(id);
        if(dept!=null){
            return ServerResponse.createBySuccess(dept);
        }
        return ServerResponse.createByErrorMessage("未找到该部门");
    }

    public ServerResponse findList() {
        List<Dept> list = deptMapper.selectList(null);
        return  ServerResponse.createBySuccess(list);
    }

    public ServerResponse checkValid(String name) {
        Integer resultCount = deptMapper.selectCount(Wrappers.<Dept>lambdaQuery().eq(Dept::getName, name));
        if (resultCount > 0) {
            return ServerResponse.createByErrorMessage("部门名称已被占用");
        }
        return ServerResponse.createBySuccess();
    }
}
