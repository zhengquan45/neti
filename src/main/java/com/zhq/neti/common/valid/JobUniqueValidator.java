package com.zhq.neti.common.valid;

import com.zhq.neti.common.ApplicationContextHelper;
import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.common.valid.anno.JobUnique;
import com.zhq.neti.service.JobService;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class JobUniqueValidator implements ConstraintValidator<JobUnique,String> {

    private JobService jobService = ApplicationContextHelper.popBean(JobService.class);

    @Override
    public void initialize(JobUnique constraintAnnotation) {
        log.info("验证职务唯一");
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext){
        ServerResponse response = jobService.checkValid(s);
        return response.isSuccess();
    }
}
