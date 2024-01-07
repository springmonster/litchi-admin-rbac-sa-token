package com.litchi.vo.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Description:
 * <p>
 * Create by noah
 * Date 2024/1/6 14:11
 */
@Data
@Schema(description = "菜单信息")
public class MenuVO implements Serializable {

    @Schema(description = "菜单ID")
    private String id;

    @Schema(description = "菜单名称")
    private String menuName;

    @Schema(description = "父菜单ID")
    private String parentId;

    @Schema(description = "父级菜单名称")
    private String parentName;

    @Schema(description = "显示顺序")
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

    @Schema(description = "创建人")
    private String createId;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;
}
