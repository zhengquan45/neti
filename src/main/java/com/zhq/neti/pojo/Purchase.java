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

@TableName("t_purchase")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {
    @TableId(type = IdType.ID_WORKER)
    private Long id;
    private Long skuId;
    private Integer num;
    private Long warehouseId;
    private BigDecimal inPrice;
    private BigDecimal outPrice;
    private Long buyerId;
    private Integer status;
    private Date createTime;
    @TableLogic
    private Boolean isDeleted;

}
