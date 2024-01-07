package com.litchi.controller.system;


import cn.dev33.satoken.annotation.SaIgnore;
import com.litchi.common.base.Result;
import com.litchi.param.system.cmd.LoginUserCmd;
import com.litchi.service.system.IAuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.litchi.common.base.Result.ok;

/**
 * Description:
 * <p>
 * Create by noah
 * Date 2023/10/7 11:21
 */
@Tag(name = "授权管理")
@RestController
@RequestMapping("/system/auth")
public class AuthController {

    @Resource
    private IAuthService IAuthService;

    @SaIgnore
    @Operation(summary = "登陆接口")
    @PostMapping("/login")
    public Result login(@Validated @RequestBody LoginUserCmd loginUser) {
        String token = IAuthService.login(loginUser.getUserName(), loginUser.getPassword());
        return ok(token);
    }

    @Operation(summary = "获取当前登陆用户信息接口")
    @GetMapping("/current")
    public Result current() {
        return ok(IAuthService.current());
    }

    @Operation(summary = "登出借口")
    @GetMapping("/logout")
    public Result logout() {
        IAuthService.logout();
        return ok();
    }

}
