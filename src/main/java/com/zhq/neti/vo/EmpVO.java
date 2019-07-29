package com.zhq.neti.vo;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.zhq.neti.common.enums.GenderEnum;
import com.zhq.neti.pojo.Emp;
import com.zhq.neti.util.EnumUtil;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 * @author zhengquan
 */
@Data
public class EmpVO {
    private Long id;
    private String code;
    @NotBlank(message = "姓名不可以为空")
    @Length(min=1,max = 100,message = "姓名长度需要在1-100个字之内")
    private String name;
    @NotNull(message = "性别不能为空 1->男 2->女")
    @Range(min = 1, max = 2, message = "性别不合法")
    private Integer sex;
    private Boolean married;
    private Integer education;
    private String tel;
    private String email;
    private String address;
    private Long jobId;
    private Long deptId;
    private Long mgrId;
    private Date hiredate;
    private Date termdate;
    private Integer status;
    @TableLogic
    private Boolean isDeleted;

    public Emp adapt() {
        Emp emp = new Emp();
        BeanUtil.copyProperties(this,emp);
        emp.setSex(EnumUtil.getEnumByCode(this.sex, GenderEnum.class));
        return emp;
    }
}
