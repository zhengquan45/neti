package com.zhq.neti.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("t_acl_module")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AclModule {
    @TableId(type = IdType.ID_WORKER)
    private Long id;
    private String name;
    private Long parentId;
    private String level;
    private Integer sort;
    private Integer status;
    private String remark;
    private Date createTime;
    @TableLogic
    private Boolean isDeleted;
}
