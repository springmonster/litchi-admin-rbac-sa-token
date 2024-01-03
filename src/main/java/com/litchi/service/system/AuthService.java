package com.litchi.service.system;


import com.litchi.vo.system.LoginUserInfoVO;

/**
 * Description:
 * <p>
 * Create by noah
 * Date 2023/10/7 14:00
 */
public interface AuthService {


    /**
     * 登录
     * @param userName String
     * @param pwd String
     */
    String login(String userName, String pwd);

    /**
     * 登出
     */
    void logout();

    /**
     * 获取当前登录用户信息
     * @return LoginUserInfo
     */
    LoginUserInfoVO current();
}
