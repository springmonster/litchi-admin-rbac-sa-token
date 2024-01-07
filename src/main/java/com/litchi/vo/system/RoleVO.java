package com.litchi.vo.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Description:
 * <p>
 * Create by noah
 * Date 2024/1/7 20:21
 */
@Data
@Schema(description = "角色信息")
public class RoleVO implements Serializable {

    @Schema(description = "角色ID")
    private Long id;

    @Schema(description = "角色名称")
    private String roleName;

    @Schema(description = "角色状态:0-正常; 1-禁用")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;
}
