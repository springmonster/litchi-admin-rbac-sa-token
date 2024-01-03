package com.litchi.common.enums;

/**
 * Description:
 * <p> 返回码枚举
 * Create by noah
 * Date 2023/9/20 16:54
 */
public enum ResultCodeEnum {

    /**
     * 请求成功
     */
    SUCCESS(200,"请求成功"),

    /**
     * 未知异常
     */
    UNKNOWN(500,"系统异常"),

    /**
     * 用户未登录
     */
    NOT_LOGIN(401,"用户未登录"),

    /**
     * 用户名或密码错误
     */
    NAME_OR_PWD_ERROR(100000,"用户名或密码错误"),

    /**
     * 权限不足
     */
    PERMISSION_DENIED(100001,"权限不足"),

    /**
     * 用户不存在
     */
    USER_NOT_EXITS(100002,"用户不存在"),

    ;

    final Integer code;

    final String msg;


    ResultCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
