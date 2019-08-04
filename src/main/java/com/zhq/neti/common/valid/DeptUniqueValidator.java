package com.zhq.neti.common.valid;

import com.zhq.neti.common.ApplicationContextHelper;
import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.common.valid.anno.DeptUnique;
import com.zhq.neti.service.DeptService;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class DeptUniqueValidator implements ConstraintValidator<DeptUnique,String> {

    private DeptService deptService = ApplicationContextHelper.popBean(DeptService.class);

    @Override
    public void initialize(DeptUnique constraintAnnotation) {
        log.info("验证职务唯一");
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext){
        ServerResponse response = deptService.checkValid(s);
        return response.isSuccess();
    }
}
