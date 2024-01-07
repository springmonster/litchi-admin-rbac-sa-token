package com.litchi.param.system.query;

import com.litchi.common.base.PageReq;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Description:
 * <p>
 * Create by noah
 * Date 2024/1/7 19:43
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "角色列表查询参数")
public class RoleListQuery extends PageReq implements Serializable {

    /**
     * 菜单名称
     */
    @Schema(description = "角色名称")
    private String roleName;

    @Schema(description = "角色状态:0-正常; 1-禁用")
    private Integer status;
}
