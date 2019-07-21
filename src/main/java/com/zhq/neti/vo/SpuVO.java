package com.zhq.neti.vo;

import cn.hutool.core.bean.BeanUtil;
import com.zhq.neti.pojo.Spu;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author zhengquan
 * @date 2019/7/21
 */
@Data
public class SpuVO {

    private Long id;
    @NotBlank(message = "产品名称不可以为空")
    @Length(min=1,max = 100,message = "产品名称长度需要在1-100个字之内")
    private String title;
    private String subTitle;
    @NotNull(message = "必须选择匹配的分类")
    private Long categoryId;
    private Long brandId;
    @NotNull(message = "必须选择匹配的品类")
    private Long spgId;
    @NotNull(message = "必须选择售卖状态")
    private Boolean saleable;
    @NotNull(message = "必须选择产品状态")
    private Boolean valid;

    public Spu adapt(){
        Spu spu = new Spu();
        BeanUtil.copyProperties(this,spu);
        return spu;
    }
}
