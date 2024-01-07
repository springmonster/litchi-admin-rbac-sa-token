package com.litchi.param.system.cmd;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * Description:
 * <p>
 * Create by noah
 * Date 2023/10/7 11:24
 */
@Data
@Schema(description = "用户登录参数")
public class LoginUserCmd implements Serializable {

    @Schema(description = "用户名")
    @NotBlank(message = "姓名不能为空")
    @Length(min = 1,max = 50,message = "字段长度要在1-50内")
    private String userName;

    @Schema(description = "密码")
    private String password;

}
