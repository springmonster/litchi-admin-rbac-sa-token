package com.litchi.controller.system;

import com.litchi.common.base.Result;
import com.litchi.param.system.cmd.MenuModifyCmd;
import com.litchi.param.system.cmd.MenuSaveCmd;
import com.litchi.param.system.query.MenuListQuery;
import com.litchi.service.system.IMenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

import static com.litchi.common.base.Result.ok;

/**
 * <p>
 * 菜单信息表 前端控制器
 * </p>
 *
 * @author Noah
 * @since 2024-01-04
 */
@Tag(name = "菜单管理")
@RestController
@RequestMapping("/system/menu")
public class MenuController {

    @Resource
    private IMenuService menuService;

    @Operation(summary = "菜单列表")
    @GetMapping("/list")
    public Result list(@Validated MenuListQuery menuListQuery){
        return ok(menuService.list(menuListQuery));
    }

    @Operation(summary = "保存菜单")
    @PostMapping("/save")
    public Result save(@Validated @RequestBody MenuSaveCmd menuSaveCmd){
        return ok(menuService.save(menuSaveCmd));
    }

    @Operation(summary = "修改菜单")
    @PutMapping("/modify")
    public Result modify(@Validated @RequestBody MenuModifyCmd menuModifyCmd){
        return ok(menuService.update(menuModifyCmd));
    }

    @Operation(summary = "删除菜单")
    @DeleteMapping("/remove")
    public Result remove(@NotBlank(message = "ID不能为空") @Parameter(description = "菜单ID") String id){
        return ok(menuService.delete(Collections.singletonList(Long.parseLong(id))));
    }
}
