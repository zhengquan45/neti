package com.zhq.neti.vo;

import cn.hutool.core.bean.BeanUtil;
import com.zhq.neti.common.valid.anno.JobUnique;
import com.zhq.neti.pojo.Job;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class JobVO {
    private Long id;
    @NotBlank(message = "职务名称不可以为空")
    @Length(min=1,max = 100,message = "职务名称长度需要在1-100个字之内")
    @JobUnique
    private String name;

    public Job adapt() {
        Job job = new Job();
        BeanUtil.copyProperties(this,job);
        return job;
    }
}
