package com.zhq.neti.service;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhq.neti.common.BeanValidator;
import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.mapper.JobMapper;
import com.zhq.neti.pojo.Dept;
import com.zhq.neti.pojo.Job;
import com.zhq.neti.vo.DeptVO;
import com.zhq.neti.vo.JobVO;
import com.zhq.neti.vo.PageQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobMapper jobMapper;

    public ServerResponse save(JobVO jobVO) {
        BeanValidator.check(jobVO);
        Job job = jobVO.adapt();
        if(jobMapper.insert(job)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse delete(List<Long> ids) {
        if(CollUtil.isEmpty(ids)){
            return ServerResponse.createByErrorMessage("请选择移除的部门");
        }
        if(jobMapper.deleteBatchIds(ids)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse update(JobVO jobVO) {
        if(jobVO.getId()==null){
            return ServerResponse.createByErrorMessage("请选择要修改的部门");
        }
        BeanValidator.check(jobVO);
        Job job = jobVO.adapt();
        if(jobMapper.updateById(job)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse find(Long id) {
        Job job = jobMapper.selectById(id);
        if(job!=null){
            return ServerResponse.createBySuccess(job);
        }
        return ServerResponse.createByErrorMessage("未找到该部门");
    }

    public ServerResponse findList(PageQuery pageQuery) {
        BeanValidator.check(pageQuery);
        IPage<Job> page = jobMapper.selectPage(pageQuery.adapt(), null);
        return  ServerResponse.createBySuccess(page);
    }
}
