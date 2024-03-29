package com.zhq.neti.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zhq.neti.common.enums.PaymentTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@TableName("t_productin")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductIn {
    @TableId(type = IdType.ID_WORKER)
    private Long id;
    private Long storekeeperId;
    private BigDecimal amount;
    private Long supplierId;
    private BigDecimal payment;
    private PaymentTypeEnum paymentType;
    private Boolean invoice;
    private String remark;
    private Date createTime;
    @TableLogic
    private Boolean isDeleted;
}
