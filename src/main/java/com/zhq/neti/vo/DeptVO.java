package com.zhq.neti.vo;

import cn.hutool.core.bean.BeanUtil;
import com.zhq.neti.pojo.Dept;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Data
public class DeptVO {
    private Long id;
    @NotBlank(message = "部门名称不可以为空")
    @Length(min=1,max = 100,message = "部门名称长度需要在1-100个字之内")
    private String name;
    @NotBlank(message = "部门缩写不可以为空")
    @Length(min=1,max =5,message = "部门缩写名称长度需要在1-5个字之内")
    @Pattern(regexp = "[A-Z]+",message = "部门缩写名称只能是大写字母")
    private String alias;

    public Dept adapt(){
        Dept dept = new Dept();
        BeanUtil.copyProperties(this,dept);
        return dept;
    }
}
