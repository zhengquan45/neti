package com.zhq.neti.vo;

import cn.hutool.core.bean.BeanUtil;
import com.zhq.neti.common.enums.EduEnum;
import com.zhq.neti.common.enums.EmpStatusEnum;
import com.zhq.neti.common.enums.GenderEnum;
import com.zhq.neti.common.valid.anno.Mobile;
import com.zhq.neti.pojo.Emp;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
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
    private GenderEnum sex;
    @NotNull(message = "必须选择已婚或未婚")
    private Boolean married;
    private EduEnum education;
    @NotBlank(message = "联系电话不可以为空")
    @Mobile
    private String tel;
    @Email
    private String email;
    private String address;
    @NotNull(message = "职务不可以为空")
    private Long jobId;
    @NotNull(message = "部门不可以为空")
    private Long deptId;
    private Long mgrId;
    @NotNull(message = "入职时间不能为空")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date hiredate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date termdate;
    @NotNull(message = "用户状态不能为空")
    private EmpStatusEnum status;

    public Emp adapt() {
        Emp emp = new Emp();
        BeanUtil.copyProperties(this,emp);
        return emp;
    }
}
