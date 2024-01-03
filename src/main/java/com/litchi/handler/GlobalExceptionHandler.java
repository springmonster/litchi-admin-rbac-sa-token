package com.litchi.handler;

import cn.dev33.satoken.exception.NotLoginException;
import com.litchi.common.base.BizException;
import com.litchi.common.base.Result;
import com.litchi.common.enums.ResultCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

import static com.litchi.common.base.Result.*;

/**
 * Description:
 * <p>
 * Create by noah
 * Date 2023/9/21 11:06
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = BizException.class)
    public Result handler(BizException cspException) {
        log.error("业务异常",cspException);
        return fail(cspException.getErrorCode(), cspException.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result handler(MethodArgumentNotValidException methodArgumentNotValidException) {
        log.error("参数校验异常",methodArgumentNotValidException);
        return fail(methodArgumentNotValidException.getStatusCode().value(), Objects.requireNonNull(methodArgumentNotValidException.getFieldError()).getDefaultMessage());
    }

    @ExceptionHandler(value = NotLoginException.class)
    public Result handler(NotLoginException notLoginException) {
        log.error("用户未登录",notLoginException);
        return fail(ResultCodeEnum.NOT_LOGIN.getCode(), ResultCodeEnum.NOT_LOGIN.getMsg());
    }

    @ExceptionHandler(value = RuntimeException.class)
    public Result handler(RuntimeException runtimeException) {
        log.error("系统异常", runtimeException);
        return fail(ResultCodeEnum.UNKNOWN.getCode(), runtimeException.getLocalizedMessage());
    }
}
