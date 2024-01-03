package com.litchi.convert.system;

import com.litchi.entity.system.SysUserEntity;
import com.litchi.param.system.cmd.UserModifyCmd;
import com.litchi.param.system.cmd.UserSaveCmd;
import com.litchi.vo.system.SysUserVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-03T22:24:39+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
@Component
public class SysUserConvertImpl implements SysUserConvert {

    @Override
    public SysUserEntity convert(UserSaveCmd userSaveCmd) {
        if ( userSaveCmd == null ) {
            return null;
        }

        SysUserEntity sysUserEntity = new SysUserEntity();

        sysUserEntity.setUserName( userSaveCmd.getUserName() );
        sysUserEntity.setPassword( userSaveCmd.getPassword() );
        sysUserEntity.setPhone( userSaveCmd.getPhone() );
        sysUserEntity.setEmail( userSaveCmd.getEmail() );
        sysUserEntity.setImgUrl( userSaveCmd.getImgUrl() );
        sysUserEntity.setRole( userSaveCmd.getRole() );

        return sysUserEntity;
    }

    @Override
    public SysUserEntity convert(UserModifyCmd userModifyCmd) {
        if ( userModifyCmd == null ) {
            return null;
        }

        SysUserEntity sysUserEntity = new SysUserEntity();

        if ( userModifyCmd.getId() != null ) {
            sysUserEntity.setId( Long.parseLong( userModifyCmd.getId() ) );
        }
        sysUserEntity.setUserName( userModifyCmd.getUserName() );
        sysUserEntity.setPassword( userModifyCmd.getPassword() );
        sysUserEntity.setPhone( userModifyCmd.getPhone() );
        sysUserEntity.setEmail( userModifyCmd.getEmail() );
        sysUserEntity.setImgUrl( userModifyCmd.getImgUrl() );
        sysUserEntity.setRole( userModifyCmd.getRole() );

        return sysUserEntity;
    }

    @Override
    public SysUserVO convert(SysUserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SysUserVO sysUserVO = new SysUserVO();

        if ( entity.getId() != null ) {
            sysUserVO.setId( String.valueOf( entity.getId() ) );
        }
        sysUserVO.setUserName( entity.getUserName() );
        sysUserVO.setPassword( entity.getPassword() );
        sysUserVO.setPhone( entity.getPhone() );
        sysUserVO.setEmail( entity.getEmail() );
        sysUserVO.setImgUrl( entity.getImgUrl() );
        sysUserVO.setRole( entity.getRole() );
        sysUserVO.setStatus( entity.getStatus() );

        return sysUserVO;
    }

    @Override
    public List<SysUserVO> convertList(List<SysUserEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<SysUserVO> list1 = new ArrayList<SysUserVO>( list.size() );
        for ( SysUserEntity sysUserEntity : list ) {
            list1.add( convert( sysUserEntity ) );
        }

        return list1;
    }
}
