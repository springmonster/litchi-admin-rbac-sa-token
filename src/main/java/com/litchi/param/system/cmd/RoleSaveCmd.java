package com.litchi.param.system.cmd;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 * <p> 角色保存参数
 * Create by noah
 * Date 2024/1/7 20:01
 */
@Data
@Schema(description = "菜单修改参数")
public class RoleSaveCmd implements Serializable {

    @Schema(description = "角色名称")
    private String roleName;

    @Schema(description = "角色状态:0-正常; 1-禁用")
    private Integer status;

    @Schema(description = "备注")
    private String remark;
}
