package com.zhq.neti.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zhq.neti.common.enums.AclTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("t_acl")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Acl {
    @TableId(type = IdType.ID_WORKER)
    private Long id;
    private Long parentId;
    private String level;
    private Integer code;
    private String name;
    private String icon;
    private String url;
    private AclTypeEnum type;
    private Integer status;
    private Integer sort;
    private String remark;
    private Date createTime;
    @TableLogic
    private Boolean isDeleted;
}
