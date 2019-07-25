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

@TableName("t_customer")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @TableId(type = IdType.ID_WORKER)
    private Long id;
    private String username;
    private String password;
    private String wechat;
    private String tel;
    private Long levelId;
    private Date createTime;
    private Date lastUpdateTime;
    @TableLogic
    private Boolean isDeleted;
}
