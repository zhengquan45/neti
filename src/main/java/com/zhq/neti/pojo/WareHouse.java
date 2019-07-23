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
@TableName("t_warehouse")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WareHouse {
    @TableId(type = IdType.ID_WORKER)
    private Long id;
    private Integer cityId;
    private String address;
    private String tel;
}
