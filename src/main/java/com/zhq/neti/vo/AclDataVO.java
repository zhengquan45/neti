package com.zhq.neti.vo;

import cn.hutool.core.bean.BeanUtil;
import com.zhq.neti.common.enums.AclDataNextOperationEnum;
import com.zhq.neti.common.enums.AclDataOperationEnum;
import com.zhq.neti.pojo.AclData;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author zhengquan
 */
@Data
public class AclDataVO {
    private Long id;
    @NotNull(message = "必须选择匹配的权限点")
    private Long aclId;
    @NotNull(message = "必须指定数据权限状态")
    @Range(min = 0, max = 2, message = "数据权限状态不合法")
    private Integer status;
    @NotBlank(message = "必须指定限制的参数")
    private String param;
    private AclDataOperationEnum operation;
    private String value1;
    private String value2;
    private AclDataNextOperationEnum nextParamOp;
    @NotNull(message = "必须指定数据权限的展示顺序")
    private Integer sort;

    public AclData adapt() {
        AclData aclData = new AclData();
        BeanUtil.copyProperties(this,aclData);
        return aclData;
    }
}
