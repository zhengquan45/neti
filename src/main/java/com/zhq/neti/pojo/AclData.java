package com.zhq.neti.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zhq.neti.common.enums.AclDataNextOperationEnum;
import com.zhq.neti.common.enums.AclDataOperationEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("t_acl_data")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AclData {
    @TableId(type = IdType.ID_WORKER)
    private Long id;
    private Long aclId;
    private Integer status;
    private String param;
    private AclDataOperationEnum operation;
    private String value1;
    private String value2;
    private AclDataNextOperationEnum nextParamOp;
    private Integer sort;
    private Date createTime;
    @TableLogic
    private Boolean isDeleted;
}
