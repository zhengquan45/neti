package com.zhq.neti.service;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhq.neti.common.BeanValidator;
import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.mapper.LevelMapper;
import com.zhq.neti.pojo.Job;
import com.zhq.neti.pojo.Level;
import com.zhq.neti.vo.JobVO;
import com.zhq.neti.vo.LevelVO;
import com.zhq.neti.vo.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelService {

    @Autowired
    private LevelMapper levelMapper;

    public ServerResponse save(LevelVO levelVO) {
        BeanValidator.check(levelVO);
        Level level = levelVO.adapt();
        if(levelMapper.insert(level)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse delete(List<Long> ids) {
        if(CollUtil.isEmpty(ids)){
            return ServerResponse.createByErrorMessage("请选择移除的会员等级");
        }
        if(levelMapper.deleteBatchIds(ids)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse update(LevelVO levelVO) {
        if(levelVO.getId()==null){
            return ServerResponse.createByErrorMessage("请选择要修改的会员等级");
        }
        BeanValidator.check(levelVO);
        Level level = levelVO.adapt();
        if(levelMapper.updateById(level)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse find(Long id) {
        Level level = levelMapper.selectById(id);
        if(level!=null){
            return ServerResponse.createBySuccess(level);
        }
        return ServerResponse.createByErrorMessage("未找到该会员等级");
    }

    public ServerResponse findList(PageQuery pageQuery) {
        BeanValidator.check(pageQuery);
        IPage<Level> page = levelMapper.selectPage(pageQuery.adapt(), null);
        return  ServerResponse.createBySuccess(page);
    }
}
