package com.zhq.neti.vo;

import cn.hutool.core.bean.BeanUtil;
import com.zhq.neti.pojo.Role;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author zhengquan
 */
@Data
public class RoleVO {
    private Long id;
    @NotBlank(message = "角色名称不可以为空")
    @Length(min=1,max = 100,message = "角色名称长度需要在1-100个字之内")
    private String name;
    private String desc;

    public Role adapt() {
        Role role = new Role();
        BeanUtil.copyProperties(this,role);
        return role;
    }
}
