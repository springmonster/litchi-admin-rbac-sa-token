package com.litchi.common.base;


import com.litchi.common.enums.ResultCodeEnum;

/**
 * Description:
 * <p>
 * Create by noah
 * Date 2023/9/21 11:12
 */
public class BizException extends RuntimeException{

    private Integer errorCode;

    private String message;

    /**
     * 自定义异常构造方法
     * @param resultCodeEnum ResultCodeEnum
     */
    public BizException(ResultCodeEnum resultCodeEnum) {
        this.errorCode = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMsg();
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
