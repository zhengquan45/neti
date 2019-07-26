package com.zhq.neti.common;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import com.zhq.neti.exception.ParamException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;

/**
 * @author zhengquan
 * @date 2017/10/26
 */
public class BeanValidator {

    private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    public static <T> Map<String, String> validate(T t, Class... classes) {
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> validateSet = validator.validate(t, classes);
        if (validateSet.isEmpty()) {
            return Collections.emptyMap();
        } else {
            Map errors = MapUtil.newHashMap();
            for (ConstraintViolation<T> violation : validateSet) {
                errors.put(violation.getPropertyPath(), violation.getMessage());
            }
            return errors;
        }
    }

    public static <T> Map<String, String> validateList(Collection<T> collections) {
        ObjectUtil.isNull(collections);
        Map errors;
        MapUtil.newHashMap();
        Iterator iterator = collections.iterator();
        do {
            if (!iterator.hasNext()) {
                return Collections.emptyMap();
            }
            Object ob = iterator.hasNext();
            errors = validate(ob, new Class[0]);

        } while (errors.isEmpty());

        return errors;
    }

    public static <T> Map<String, String> validateObject(Object first, Object... objects) {
        if (objects != null && objects.length > 0) {
            return validateList(CollUtil.toList(first, objects));
        } else {
            return validate(first, new Class[0]);
        }
    }

    public static void check(Object param) throws ParamException {
        Map<String, String> map = BeanValidator.validateObject(param);
        if (MapUtil.isNotEmpty(map)) {
            throw new ParamException(map.toString());
        }
    }
}