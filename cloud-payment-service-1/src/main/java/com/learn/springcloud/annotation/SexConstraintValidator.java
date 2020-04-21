package com.learn.springcloud.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author ct
 * @date 2020/4/10 12:55 下午
 */
public class SexConstraintValidator implements ConstraintValidator<Sex, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && (value.equals("男") || value.equals("女"));
    }
}
