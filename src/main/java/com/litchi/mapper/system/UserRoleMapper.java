package com.litchi.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.litchi.entity.system.UserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户和角色关联表 Mapper 接口
 * </p>
 *
 * @author Noah
 * @since 2024-01-04
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

}
