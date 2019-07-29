package com.zhq.neti.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_supplier_sku")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplierSku {
    @TableId
    private Long supplierId;
    @TableId
    private Long skuId;
    @TableLogic
    private Boolean isDeleted;
}
