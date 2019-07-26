package com.zhq.neti.pojo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_productin_purchase")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductInPurchase {
    private Long productInId;
    private Long purchaseId;
    @TableLogic
    private Boolean isDeleted;
}
