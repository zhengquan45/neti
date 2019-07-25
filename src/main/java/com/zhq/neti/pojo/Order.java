package com.zhq.neti.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@TableName("t_order")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @TableId(type = IdType.ID_WORKER)
    private Long id;
    private String code;
    private Integer type;
    private Long shopId;
    private Long customerId;
    private BigDecimal amount;
    private Integer paymentType;
    private Integer status;
    private BigDecimal postage;
    private Integer weight;
    private Long voucherId;
    private Date createTime;
    @TableLogic
    private Boolean isDeleted;

}
