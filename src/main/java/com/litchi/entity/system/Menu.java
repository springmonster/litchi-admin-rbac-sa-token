package com.litchi.entity.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>
 * 菜单信息表
 * </p>
 *
 * @author Noah
 * @since 2024-01-04
 */
@Data
@TableName("sys_menu")
public class Menu {

    /**
     * 菜单ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 父菜单ID
     */
    private Long parentId;

    /**
     * 显示顺序
     */
    private Integer sort;

    /**
     * 请求地址
     */
    private String url;

    /**
     * 菜单类型: M-目录; C-菜单; F-按钮
     */
    private String menuType;

    /**
     * 菜单可见：0-显示;1-隐藏
     */
    private Boolean visible;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人
     */
    private String createId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private String updateId;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
