package com.litchi.vo.system;

import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 * <p> 登录用户信息
 * Create by noah
 * Date 2023/10/11 14:23
 */
@Data
public class LoginUserInfoVO implements Serializable {

    /**
     * 主键
     */
    private String id;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 账号状态：0-正常，1-禁用
     */
    private Integer status;
}
