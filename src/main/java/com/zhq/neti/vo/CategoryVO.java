package com.zhq.neti.vo;

import cn.hutool.core.bean.BeanUtil;
import com.zhq.neti.pojo.Category;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author zhengquan
 * @date 2019/7/20
 */
@Data
public class CategoryVO {

    private Long id;
    @NotBlank(message = "品牌名称不可以为空")
    @Length(min=1,max = 100,message = "品牌名称长度需要在1-100个字之内")
    private String name;
    private Long parentId;
    private Boolean ifParent;
    private Integer sort;

    public Category adapt(){
        Category category = new Category();
        BeanUtil.copyProperties(this,category);
        return category;
    }
}
