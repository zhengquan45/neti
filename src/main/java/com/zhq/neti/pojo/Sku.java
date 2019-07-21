package com.zhq.neti.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhengquan
 * @date 2019/7/21
 */
@TableName("t_sku")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sku {

    @TableId(type = IdType.ID_WORKER)
    private Long id;
    private Long spuId;
    private String title;
    private String images;
    private BigDecimal price;
    private String param;
    private Boolean saleable;
    private Boolean valid;
    private Date createTime;
    private Date lastUpdateTime;
}
