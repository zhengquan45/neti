package com.zhq.neti.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("t_role_acl")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleAcl {
    @TableId(type = IdType.ID_WORKER)
    private Long id;
    private Long roleId;
    private Long aclId;
    private Date createTime;
}
