package com.litchi.convert.system;


import com.litchi.entity.system.SysUserEntity;
import com.litchi.vo.system.LoginUserInfoVO;
import org.mapstruct.Mapper;

/**
 * Description:
 * <p> 登录用户Bean转换
 * Create by noah
 * Date 2023/10/11 14:26
 */
@Mapper(componentModel = "spring")
public interface LoginUserConvert {

    LoginUserInfoVO convert(SysUserEntity entity);
}
