package com.litchi.param.system.query;

import com.litchi.common.base.PageReq;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Description:
 * <p> 用户查询参数
 * Create by noah
 * Date 2023/9/22 16:15
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserListQuery extends PageReq implements Serializable {


    /**
     * 姓名
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
     * 角色
     */
    private String role;


}
