package com.litchi.controller.system;


import cn.dev33.satoken.annotation.SaIgnore;
import com.litchi.common.base.Result;
import com.litchi.param.system.cmd.LoginUserCmd;
import com.litchi.service.system.AuthService;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.litchi.common.base.Result.*;

/**
 * Description:
 * <p>
 * Create by noah
 * Date 2023/10/7 11:21
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Resource
    private AuthService authService;

    @SaIgnore
    @PostMapping("/login")
    public Result login(@Validated @RequestBody LoginUserCmd loginUser) {
        String token = authService.login(loginUser.getUserName(), loginUser.getPassword());
        return ok(token);
    }

    @GetMapping("/current")
    public Result current() {
        return ok(authService.current());
    }

    @GetMapping("/logout")
    public Result logout() {
        authService.logout();
        return ok();
    }

}
