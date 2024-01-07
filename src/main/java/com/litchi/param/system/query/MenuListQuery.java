package com.litchi.param.system.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 * <p> 菜单列表查询参数
 * Create by noah
 * Date 2024/1/6 00:00
 */
@Data
@Schema(description = "菜单列表查询参数")
public class MenuListQuery implements Serializable {

    /**
     * 菜单名称
     */
    @Schema(description = "菜单名称")
    private String menuName;

}
