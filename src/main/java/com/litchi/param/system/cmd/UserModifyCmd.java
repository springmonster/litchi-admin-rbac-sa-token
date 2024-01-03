package com.litchi.param.system.cmd;

import com.litchi.common.annotation.PhoneNo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * Description:
 * <p> 用户修改参数
 * Create by noah
 * Date 2023/9/22 16:49
 */
@Data
public class UserModifyCmd {

    /**
     * ID
     */
    @NotNull(message = "ID不能为空")
    private String id;

    /**
     * 用户名
     */
    @NotBlank(message = "姓名不能为空")
    @Length(min = 1,max = 50,message = "字段长度要在1-50内")
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    @PhoneNo
    private String phone;

    /**
     * 邮箱
     */
    @Email(message = "邮箱格式不正确")
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

}
