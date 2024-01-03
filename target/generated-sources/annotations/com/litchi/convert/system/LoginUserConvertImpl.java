package com.litchi.convert.system;

import com.litchi.entity.system.SysUserEntity;
import com.litchi.vo.system.LoginUserInfoVO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-03T22:24:39+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
@Component
public class LoginUserConvertImpl implements LoginUserConvert {

    @Override
    public LoginUserInfoVO convert(SysUserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        LoginUserInfoVO loginUserInfoVO = new LoginUserInfoVO();

        if ( entity.getId() != null ) {
            loginUserInfoVO.setId( String.valueOf( entity.getId() ) );
        }
        loginUserInfoVO.setUserName( entity.getUserName() );
        loginUserInfoVO.setPassword( entity.getPassword() );
        loginUserInfoVO.setPhone( entity.getPhone() );
        loginUserInfoVO.setEmail( entity.getEmail() );
        loginUserInfoVO.setImgUrl( entity.getImgUrl() );
        loginUserInfoVO.setRole( entity.getRole() );
        loginUserInfoVO.setStatus( entity.getStatus() );

        return loginUserInfoVO;
    }
}
