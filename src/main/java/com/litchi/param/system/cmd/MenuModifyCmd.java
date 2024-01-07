package com.litchi.param.system.cmd;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 * <p> 菜单保存参数
 * Create by noah
 * Date 2024/1/5 22:43
 */
@Data
@Schema(description = "菜单修改参数")
public class MenuModifyCmd implements Serializable {

    @Schema(description = "菜单ID")
    private Long id;

    @Schema(description = "菜单名称")
    private String menuName;

    @Schema(description = "父菜单ID")
    private Long parentId;

    @Parameter(description = "显示顺序")
    private Integer sort;

    @Schema(description = "请求地址")
    private String url;

    @Schema(description = "菜单类型: M-目录; C-菜单; F-按钮")
    private String menuType;

    @Schema(description = "菜单可见：0-显示;1-隐藏")
    private Boolean visible;

    @Schema(description = "菜单图标")
    private String icon;

    @Schema(description = "备注")
    private String remark;

}
