package com.zhq.neti.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zhq.neti.common.enums.BackStockEnum;
import com.zhq.neti.common.enums.PaymentTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@TableName("t_backstock")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BackStock {
    @TableId(type = IdType.ID_WORKER)
    private Long id;
    private Long orderId;
    private String sku;
    private String reason;
    private Long qaId;
    private BigDecimal payment;
    private PaymentTypeEnum paymentType;
    private BackStockEnum status;
    private Date createTime;
}
