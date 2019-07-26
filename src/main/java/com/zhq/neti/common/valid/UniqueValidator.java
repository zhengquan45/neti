package com.zhq.neti.common.valid;

import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.common.valid.anno.Unique;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class UniqueValidator implements ConstraintValidator<Unique,String> {


    @Override
    public void initialize(Unique constraintAnnotation) {
        log.info("验证字段数据库唯一");

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext){
        ServerResponse response = userService.checkValid(s);
        return response.isSuccess();
    }


}
