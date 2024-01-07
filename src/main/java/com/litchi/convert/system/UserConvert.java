package com.litchi.convert.system;

import com.litchi.entity.system.User;
import com.litchi.param.system.cmd.UserModifyCmd;
import com.litchi.param.system.cmd.UserSaveCmd;
import com.litchi.vo.system.UserVO;
import org.mapstruct.Mapper;

import java.util.List;

/**
* 用户Bean转换
*
* @author Noah gby_dev@163.com
* @since 1.0.0 2023-09-26
*/
@Mapper(componentModel = "spring")
public interface UserConvert {

    User convert(UserSaveCmd userSaveCmd);

    User convert(UserModifyCmd userModifyCmd);

    List<UserVO> convertList(List<User> list);

}