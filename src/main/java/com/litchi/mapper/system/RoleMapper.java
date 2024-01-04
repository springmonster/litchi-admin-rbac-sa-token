package com.litchi.mapper.system;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.litchi.entity.system.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色信息表 Mapper 接口
 * </p>
 *
 * @author Noah
 * @since 2024-01-04
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

}
