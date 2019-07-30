package com.zhq.neti.vo;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.zhq.neti.common.enums.AclTypeEnum;
import com.zhq.neti.pojo.Acl;
import com.zhq.neti.util.EnumUtil;
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
    @TableId(type = IdType.ID_WORKER)
    private Long id;
    @NotNull(message = "权限码不能为空")
    private Integer code;
    @NotBlank(message = "权限名称不可以为空")
    @Length(min=1,max = 100,message = "权限名称长度需要在1-100个字之内")
    private String name;
    @NotNull(message = "必须选择匹配的权限模块")
    private Long aclModuleId;
    @NotBlank(message = "权限url不能为空")
    private String url;
    @NotNull(message = "必须选择权限类型 1->菜单 2->按钮")
    @Range(min = 1, max = 2, message = "权限点类型不合法")
    private Integer type;
    @NotNull(message = "必须指定权限点的状态")
    @Range(min = 0, max = 1, message = "权限点状态不合法")
    private Integer status;
    @NotNull(message = "必须指定权限点的展示顺序")
    private Integer sort;
    @Length(min = 0, max = 200, message = "权限点备注长度需要在200个字符以内")
    private String remark;

    public Acl adapt() {
        Acl acl = new Acl();
        BeanUtil.copyProperties(this,acl);
        acl.setType(EnumUtil.getEnumByCode(this.type, AclTypeEnum.class));
        return acl;
    }
}
