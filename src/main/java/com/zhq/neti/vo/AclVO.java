package com.zhq.neti.vo;

import cn.hutool.core.bean.BeanUtil;
import com.zhq.neti.common.enums.AclTypeEnum;
import com.zhq.neti.pojo.Acl;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author zhengquan
 */
@Data
public class AclVO {
    private Long id;
    @NotNull(message = "权限码不能为空")
    private Integer code;
    private Long parentId =0L;
    private String level;
    @NotBlank(message = "权限名称不可以为空")
    @Length(min=1,max = 50,message = "权限名称长度需要在1-50个字之内")
    private String name;
    @NotBlank(message = "菜单名称不可以为空")
    @Length(min=1,max = 20,message = "菜单名称长度需要在1-20个字之内")
    private String title;
    @NotNull(message = "必须选择菜单图标")
    private String icon;
    @NotBlank(message = "前端组件名称不可以为空")
    @Length(min=1,max = 100,message = "前端组件名称长度需要在1-100个字之内")
    private String component;
    @NotBlank(message = "权限url不能为空")
    private String url;
    private AclTypeEnum type;
    @NotNull(message = "必须指定权限点的状态")
    @Range(max = 1, message = "权限点状态不合法")
    private Integer status;
    @NotNull(message = "必须指定权限点的隐藏状态")
    private Boolean hidden;
    @NotNull(message = "必须指定权限点的展示顺序")
    private Integer sort;
    @Length(max = 200, message = "权限点备注长度需要在200个字符以内")
    private String remark;

    public Acl adapt() {
        Acl acl = new Acl();
        BeanUtil.copyProperties(this,acl);
        return acl;
    }
}
