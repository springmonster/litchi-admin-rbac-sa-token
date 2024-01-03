package com.litchi.common.annotation;

import com.litchi.common.validator.PhoneNoValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * Description:
 * <p> 手机号注解
 * Create by noah
 * Date 2023/9/25 10:16
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {PhoneNoValidator.class})
public @interface PhoneNo {

    String message() default "请输入正确的手机号";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
