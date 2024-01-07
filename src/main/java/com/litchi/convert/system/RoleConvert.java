package com.litchi.convert.system;

import com.litchi.entity.system.Role;
import com.litchi.param.system.cmd.RoleModifyCmd;
import com.litchi.param.system.cmd.RoleSaveCmd;
import com.litchi.vo.system.RoleVO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Description:
 * <p> 角色转换器
 * Create by noah
 * Date 2024/1/7 20:34
 */
@Mapper(componentModel = "spring")
public interface RoleConvert {

    Role convert(RoleSaveCmd roleSaveCmd);

    Role convert(RoleModifyCmd roleModifyCmd);

    List<RoleVO> convertList(List<Role> list);
}
