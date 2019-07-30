package com.zhq.neti.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("t_role_user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {
    @TableId(type = IdType.ID_WORKER)
    private Long id;
    private Long roleId;
    private Long userId;
    private Date createTime;
}
