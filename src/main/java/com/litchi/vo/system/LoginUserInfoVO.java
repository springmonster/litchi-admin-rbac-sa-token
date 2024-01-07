package com.litchi.vo.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 * <p> 登录用户信息
 * Create by noah
 * Date 2023/10/11 14:23
 */
@Data
@Schema(description = "登录用户信息")
public class LoginUserInfoVO implements Serializable {

    @Schema(description = "用户ID")
    private String id;

    @Schema(description = "用户名称")
    private String userName;

    @Schema(description = "手机号")
    private String phone;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "昵称")
    private String nickName;

    @Schema(description = "性别")
    private Integer sex;

    @Schema(description = "头像")
    private String avatar;

    @Schema(description = "账号状态：0-正常，1-禁用")
    private Integer status;
}
