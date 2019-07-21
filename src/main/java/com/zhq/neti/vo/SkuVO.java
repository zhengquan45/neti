package com.zhq.neti.vo;

import cn.hutool.core.bean.BeanUtil;
import com.zhq.neti.pojo.Sku;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author zhengquan
 * @date 2019/7/21
 */
@Data
public class SkuVO {

    private Long id;
    @NotNull(message = "必须选择匹配的产品")
    private Long spuId;
    @NotBlank(message = "商品名称不可以为空")
    @Length(min=1,max = 100,message = "商品名称长度需要在1-100个字之内")
    private String title;
    private String images;
    @NotNull(message = "必须填写价格信息")
    private BigDecimal price;
    @NotBlank(message = "必须填写参数信息")
    private String param;
    @NotNull(message = "必须选择售卖状态")
    private Boolean saleable;
    @NotNull(message = "必须选择产品状态")
    private Boolean valid;

    public Sku adapt(){
        Sku sku = new Sku();
        BeanUtil.copyProperties(this,sku);
        return sku;
    }
}
