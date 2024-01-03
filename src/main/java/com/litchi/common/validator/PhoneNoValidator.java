package com.litchi.common.validator;

import com.litchi.common.annotation.PhoneNo;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:
 * <p> 手机号校验器
 * Create by noah
 * Date 2023/9/25 10:18
 */
public class PhoneNoValidator implements ConstraintValidator<PhoneNo,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if ((value == null)) {
            return false;
        }
        String regex = "^1[3-9]\\d{9}$";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(value);
        return m.matches();
    }
}
