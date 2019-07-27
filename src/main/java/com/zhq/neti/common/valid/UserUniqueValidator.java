package com.zhq.neti.common.valid;

import com.zhq.neti.common.ApplicationContextHelper;
import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.common.valid.anno.UserUnique;
import com.zhq.neti.service.UserService;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author zhengquan
 */
@Slf4j
public class UserUniqueValidator implements ConstraintValidator<UserUnique,String> {

    private UserService userService = ApplicationContextHelper.popBean(UserService.class);

    @Override
    public void initialize(UserUnique constraintAnnotation) {
        log.info("验证用户名唯一");
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext){
        ServerResponse response = userService.checkValid(s);
        return response.isSuccess();
    }


}
