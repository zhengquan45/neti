package com.zhq.neti.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhq.neti.pojo.Acl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AclMapper extends BaseMapper<Acl> {
    void batchUpdateLevel(@Param("aclList")List<Acl> aclList);
}
