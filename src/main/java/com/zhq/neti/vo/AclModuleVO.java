package com.zhq.neti.vo;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.zhq.neti.pojo.AclModule;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class AclModuleVO {
    @TableId(type = IdType.ID_WORKER)
    private Long id;
    @NotBlank(message = "权限模块名称不可以为空")
    @Length(min=1,max = 100,message = "权限模块名称长度需要在1-100个字之内")
    private String name;
    private Long parentId;
    @NotNull(message = "必须指定权限模块的状态")
    @Range(min = 0, max = 1, message = "权限模块状态不合法")
    private Integer status;
    @NotNull(message = "必须指定权限模块的展示顺序")
    private Integer sort;
    @Length(max = 200, message = "权限模块备注长度需要在200个字符以内")
    private String remark;
    private Date createTime;
    @TableLogic
    private Boolean isDeleted;

    public AclModule adapt() {
        AclModule aclModule = new AclModule();
        BeanUtil.copyProperties(this,aclModule);
        return aclModule;
    }
}
