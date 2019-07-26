package com.zhq.neti.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId
    private Long wareHouseId;
    @TableId
    private Long skuId;
    private Integer num;
    private String unit;
}
