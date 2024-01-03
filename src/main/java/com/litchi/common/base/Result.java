package com.litchi.common.base;


import com.litchi.common.enums.ResultCodeEnum;

import java.io.Serializable;

/**
 * Description:
 * <p> 统一结果封装
 * Create by noah
 * Date 2023/9/20 15:35
 */
public class Result<T> implements Serializable {
    private Result() {
    }

    /**
     * success
     */
    private Boolean success;

    /**
     * code
     */
    private Integer code;

    /**
     * msg
     */
    private String msg;

    /**
     * data
     */
    private T data;


    public static Result ok() {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
        return result;
    }

    public static <T> Result ok(T data) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
        result.setData(data);
        return result;
    }

    public static Result fail() {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(ResultCodeEnum.UNKNOWN.getCode());
        result.setMsg(ResultCodeEnum.UNKNOWN.getMsg());
        return result;
    }

    public static Result fail(ResultCodeEnum resultCodeEnum) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(resultCodeEnum.getCode());
        result.setMsg(resultCodeEnum.getMsg());
        return result;
    }

    public static Result fail(Integer code,String msg) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
