package com.zhq.neti.vo;

import cn.hutool.core.bean.BeanUtil;
import com.zhq.neti.pojo.Level;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class LevelVO {
    private Long id;
    @NotBlank(message = "会员等级名称不可以为空")
    @Length(min=1,max = 100,message = "会员等级名称长度需要在1-100个字之内")
    private String level;
    @NotNull(message = "折扣不可以为空")
    private BigDecimal discount;

    public Level adapt() {
        Level level = new Level();
        BeanUtil.copyProperties(this,level);
        return level;
    }
}
