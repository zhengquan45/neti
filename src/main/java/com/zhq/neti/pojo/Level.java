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

/**
 * @author zhengquan
 * @date 2019/7/24
 */
@TableName("t_level")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Level {
    @TableId(type = IdType.ID_WORKER)
    private Long id;
    private String level;
    private BigDecimal discount;
    @TableLogic
    private Boolean isDeleted;
}
