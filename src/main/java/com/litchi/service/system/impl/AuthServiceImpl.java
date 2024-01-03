package com.litchi.service.system.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.litchi.common.base.BizException;
import com.litchi.common.constant.BmsConstant;
import com.litchi.common.enums.ResultCodeEnum;
import com.litchi.convert.system.LoginUserConvert;
import com.litchi.dao.system.SysUserDao;
import com.litchi.entity.system.SysUserEntity;
import com.litchi.service.system.AuthService;
import com.litchi.vo.system.LoginUserInfoVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Description:
 * <p>
 * Create by noah
 * Date 2023/10/7 14:02
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    private SysUserDao userDao;

    @Resource
    private LoginUserConvert loginUserConvert;

    @Override
    public String login(String userName, String pwd) {
        SysUserEntity sysUserEntity = userDao.selectByNameAndPwd(userName, pwd);
        if (Objects.isNull(sysUserEntity)){
            throw new BizException(ResultCodeEnum.NAME_OR_PWD_ERROR);
        }
        StpUtil.login(sysUserEntity.getId());
        LoginUserInfoVO loginUserInfo = loginUserConvert.convert(sysUserEntity);
        StpUtil.getSession().set(BmsConstant.CURRENT_USER,loginUserInfo);
        return StpUtil.getTokenValue();
    }

    @Override
    public void logout() {
        StpUtil.logout();
    }

    @Override
    public LoginUserInfoVO current() {
        return (LoginUserInfoVO) StpUtil.getSession().get(BmsConstant.CURRENT_USER);
    }

}
