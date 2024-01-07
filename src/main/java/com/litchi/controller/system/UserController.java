package com.litchi.controller.system;


import com.litchi.common.base.Result;
import com.litchi.param.system.cmd.UserModifyCmd;
import com.litchi.param.system.cmd.UserSaveCmd;
import com.litchi.param.system.query.UserListQuery;
import com.litchi.service.system.IUserService;
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
 * Description:
 * <p>
 * Create by noah
 * Date 2023/9/22 16:14
 */
@Tag(name = "用户管理")
@Validated
@RestController
@RequestMapping("/system/user")
public class UserController {

    @Resource
    private IUserService userService;

    @Operation(summary = "用户分页列表")
    @GetMapping("/page")
    public Result page(@Validated UserListQuery userListQuery){
        return ok(userService.page(userListQuery));
    }

    @Operation(summary = "保存用户")
    @PostMapping("/save")
    public Result save(@Validated @RequestBody UserSaveCmd userSaveCmd){
        return ok(userService.save(userSaveCmd));
    }

    @Operation(summary = "修改用户")
    @PutMapping("/modify")
    public Result modify(@Validated @RequestBody UserModifyCmd userModifyCmd){
        return ok(userService.update(userModifyCmd));
    }

    @Operation(summary = "删除用户")
    @DeleteMapping("/remove")
    public Result remove(@NotBlank(message = "ID不能为空") @Parameter(description = "用户ID") String id){
        return ok(userService.delete(Collections.singletonList(Long.parseLong(id))));
    }

}
