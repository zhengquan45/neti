package com.zhq.neti.vo;

import cn.hutool.core.bean.BeanUtil;
import com.zhq.neti.pojo.Brand;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author zhengquan
 * @date 2019/7/15
 */
@Data
public class BrandVO {
    private Long id;
    @NotBlank(message = "品牌名称不可以为空")
    @Length(min=1,max = 100,message = "品牌名称长度需要在1-100个字之内")
    private String name;
    private String image;
    @NotNull(message = "品牌首字母不可以为空")
    private Character letter;

    public Brand adapt(){
        Brand brand = new Brand();
        BeanUtil.copyProperties(this,brand);
        return brand;
    }
}
