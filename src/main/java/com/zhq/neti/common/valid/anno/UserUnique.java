package com.zhq.neti.common.valid.anno;


import com.zhq.neti.common.valid.UserUniqueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserUniqueValidator.class)
public @interface UserUnique {
    String message() default "用户名已存在";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
