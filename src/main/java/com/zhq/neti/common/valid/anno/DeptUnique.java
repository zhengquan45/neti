package com.zhq.neti.common.valid.anno;


import com.zhq.neti.common.valid.DeptUniqueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DeptUniqueValidator.class)
public @interface DeptUnique {
    String message() default "部门已存在";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
