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

@TableName("t_delivery")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Delivery {
    @TableId(type = IdType.ID_WORKER)
    private Long id;
    private Long orderId;
    private String sku;
    private Long qaId;
    private Long deId;
    private Long postId;
    private BigDecimal price;
    private Long addressId;
    private Long warehouseId;
    private Integer ecp;
    private Date createTime;
    @TableLogic
    private Boolean isDeleted;
}
