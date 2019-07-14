package com.zhq.neti.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zhengquan
 * @date 2019/7/14
 */
@TableName("t_user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @TableId(type = IdType.ID_WORKER)
    private Long id;
    private String username;
    private String password;
    private Long empId;
    private Long roleId;
    private Integer status;
    private Date createTime;
    private Date lastUpdateTime;
    @TableLogic
    private Boolean isDeleted;
}
