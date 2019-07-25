package com.zhq.neti.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@TableName("t_customer_address")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddress {
    @TableId(type = IdType.ID_WORKER)
    private Long id;
    private Long customerId;
    private String name;
    private String tel;
    private String address;
    private Boolean prime;
    @TableLogic
    private Boolean isDeleted;

}
