package com.zhq.neti.vo;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.SecureUtil;
import com.zhq.neti.pojo.User;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author zhengquan
 * @date 2019/7/14
 */
@Data
public class UserVO {
    @NotBlank(message = "用户名不可以为空")
    @Length(min=1,max = 40,message = "用户名长度需要在1-40个字之内")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
    @NotNull(message = "必须选择匹配的职员")
    private Long empId;
    @NotNull(message = "必须选择匹配的角色")
    private Long roleId;
    @NotNull(message = "必须指定用户的状态")
    @Range(min = 0, max = 2, message = "用户状态不合法")
    private Integer status;

    public User adapt(){
        User user = new User();
        BeanUtil.copyProperties(this,user);
        user.setPassword(SecureUtil.md5(this.password));
        return user;
    }
}
