package com.zhq.neti.common.valid;

import com.zhq.neti.common.valid.anno.Mobile;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class MobileValidator implements ConstraintValidator<Mobile,String> {

    @Override
    public void initialize(Mobile constraintAnnotation) {
        log.info("验证手机号合法性");
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Pattern p = Pattern.compile("^((13[0-9])|(14[5,7])|(15[^4,\\D])|(17[0,1,3,6-8])|(18[0-9])|(19[8,9])|(166))[0-9]{8}$");
        Matcher m = p.matcher(s);
        return m.matches();
    }
}
