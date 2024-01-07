package com.litchi.controller.system;

import com.litchi.common.base.Result;
import com.litchi.param.system.cmd.RoleModifyCmd;
import com.litchi.param.system.cmd.RoleSaveCmd;
import com.litchi.param.system.query.RoleListQuery;
import com.litchi.service.system.IRoleService;
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
 * 角色信息表 前端控制器
 * </p>
 *
 * @author Noah
 * @since 2024-01-04
 */
@Tag(name = "角色管理")
@RestController
@RequestMapping("/system/role")
public class RoleController {

    @Resource
    private IRoleService roleService;

    @Operation(summary = "角色分页列表")
    @GetMapping("/page")
    public Result page(@Validated RoleListQuery roleListQuery){
        return ok(roleService.page(roleListQuery));
    }

    @Operation(summary = "保存角色")
    @PostMapping("/save")
    public Result save(@Validated @RequestBody RoleSaveCmd roleSaveCmd){
        return ok(roleService.save(roleSaveCmd));
    }

    @Operation(summary = "修改角色")
    @PutMapping("/modify")
    public Result modify(@Validated @RequestBody RoleModifyCmd roleModifyCmd){
        return ok(roleService.update(roleModifyCmd));
    }

    @Operation(summary = "删除角色")
    @DeleteMapping("/remove")
    public Result remove(@NotBlank(message = "ID不能为空") @Parameter(description = "角色ID") String id){
        return ok(roleService.delete(Collections.singletonList(Long.parseLong(id))));
    }

}
