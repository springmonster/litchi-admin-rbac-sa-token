package com.litchi.convert.system;

import org.mapstruct.Mapper;
import com.litchi.entity.system.SysUserEntity;
import com.litchi.param.system.cmd.UserModifyCmd;
import com.litchi.param.system.cmd.UserSaveCmd;
import com.litchi.vo.system.SysUserVO;

import java.util.List;

/**
* 用户Bean转换
*
* @author Noah gby_dev@163.com
* @since 1.0.0 2023-09-26
*/
@Mapper(componentModel = "spring")
public interface SysUserConvert {

    SysUserEntity convert(UserSaveCmd userSaveCmd);

    SysUserEntity convert(UserModifyCmd userModifyCmd);

    SysUserVO convert(SysUserEntity entity);

    List<SysUserVO> convertList(List<SysUserEntity> list);

}