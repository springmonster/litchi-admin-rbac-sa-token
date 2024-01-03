package com.litchi.param.system.cmd;

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
public class LoginUserCmd implements Serializable {

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

}
