package com.zhq.neti.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhengquan
 * @date 2019/7/24
 */
@TableName("t_warehouse_sku")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WareHouseSku {
    private Long wareHouseId;
    private Long skuId;
    private Integer num;
    private String unit;
}
