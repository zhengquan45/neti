package com.zhq.neti.common.valid;

import com.zhq.neti.common.ApplicationContextHelper;
import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.common.valid.anno.RoleUnique;
import com.zhq.neti.service.RoleService;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class RoleUniqueValidator implements ConstraintValidator<RoleUnique,String> {

    private RoleService roleService = ApplicationContextHelper.popBean(RoleService.class);

    @Override
    public void initialize(RoleUnique constraintAnnotation) {
        log.info("验证角色唯一");
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext){
        ServerResponse response = roleService.checkValid(s);
        return response.isSuccess();
    }
}
