package com.litchi.param.system.query;

import com.litchi.common.base.PageReq;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Description:
 * <p> 用户查询参数
 * Create by noah
 * Date 2023/9/22 16:15
 */
@Data
@Schema(description = "用户查询参数")
@EqualsAndHashCode(callSuper = true)
public class UserListQuery extends PageReq implements Serializable {

    @Schema(description = "姓名")
    private String userName;

    @Schema(description = "手机号")
    private String phone;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "角色ID")
    private String roleId;


}
