package com.zhq.neti.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zhq.neti.common.enums.EduEnum;
import com.zhq.neti.common.enums.EmpStatusEnum;
import com.zhq.neti.common.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@TableName("t_emp")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Emp {

    @TableId(type = IdType.ID_WORKER)
    private Long id;
    private String code;
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
    private EmpStatusEnum status;
    @TableLogic
    private Boolean isDeleted;
}
