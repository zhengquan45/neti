package com.zhq.neti.common.valid;

import com.zhq.neti.common.ApplicationContextHelper;
import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.common.valid.anno.BrandUnique;
import com.zhq.neti.service.BrandService;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author zhengquan
 */
@Slf4j
public class BrandUniqueValidator implements ConstraintValidator<BrandUnique,String> {

    private BrandService brandService = ApplicationContextHelper.popBean(BrandService.class);

    @Override
    public void initialize(BrandUnique constraintAnnotation) {
        log.info("验证品牌唯一");
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext){
        ServerResponse response = brandService.checkValid(s);
        return response.isSuccess();
    }


}
