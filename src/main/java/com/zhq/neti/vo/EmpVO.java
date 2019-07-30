package com.zhq.neti.vo;

import cn.hutool.core.bean.BeanUtil;
import com.zhq.neti.common.enums.EduEnum;
import com.zhq.neti.common.enums.GenderEnum;
import com.zhq.neti.pojo.Emp;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
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
    private Boolean married;
    private EduEnum education;
    private String tel;
    private String email;
    private String address;
    private Long jobId;
    private Long deptId;
    private Long mgrId;
    private Date hiredate;
    private Date termdate;
    private Integer status;

    public Emp adapt() {
        Emp emp = new Emp();
        BeanUtil.copyProperties(this,emp);
        return emp;
    }
}
