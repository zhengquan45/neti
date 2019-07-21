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
 * @date 2019/7/20
 */
@TableName("t_spec_param")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpecParam {

    @TableId(type = IdType.ID_WORKER)
    private Long id;
    private Long sppId;
    private Long spgId;
    private String name;
    private Boolean numeric;
    private String unit;
    private Boolean generic;
    private Boolean searching;
    private String segments;
}
