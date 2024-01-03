package com.litchi.controller.system;


import com.litchi.common.base.Result;
import com.litchi.param.system.cmd.UserModifyCmd;
import com.litchi.param.system.cmd.UserSaveCmd;
import com.litchi.param.system.query.UserListQuery;
import com.litchi.service.system.SysUserService;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

import static com.litchi.common.base.Result.*;


/**
 * Description:
 * <p>
 * Create by noah
 * Date 2023/9/22 16:14
 */
@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private SysUserService userService;

    @GetMapping("/page")
    public Result page(@Validated UserListQuery userListQuery){
        return ok(userService.page(userListQuery));
    }

    @PostMapping("/save")
    public Result save(@Validated @RequestBody UserSaveCmd userSaveCmd){
        return ok(userService.save(userSaveCmd));
    }

    @PutMapping("/modify")
    public Result modify(@Validated @RequestBody UserModifyCmd userModifyCmd){
        return ok(userService.update(userModifyCmd));
    }

    @DeleteMapping("/remove")
    public Result remove(@NotBlank(message = "ID不能为空") String id){
        return ok(userService.removeByIds(Collections.singletonList(id)));
    }

}
