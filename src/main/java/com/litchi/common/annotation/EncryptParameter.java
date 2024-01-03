package com.litchi.common.annotation;

import java.lang.annotation.*;

/**
 * Description:
 * <p> 加密注解
 * Create by noah
 * Date 2023/9/25 10:36
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EncryptParameter {
}
