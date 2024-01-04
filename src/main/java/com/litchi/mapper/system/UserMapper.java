package com.litchi.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.litchi.entity.system.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Description:
 * <p> 用户Dao
 * Create by noah
 * Date 2023/9/28 11:37
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户名和密码查询
     * @param userName String
     * @param pwd String
     * @return SysUserEntity
     */
    User selectByNameAndPwd(@Param("userName") String userName, @Param("pwd") String pwd);
}
