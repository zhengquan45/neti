package com.zhq.neti.common.valid.anno;


import com.zhq.neti.common.valid.MobileValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MobileValidator.class)
public @interface Mobile {
    String message() default "手机号不合法";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
