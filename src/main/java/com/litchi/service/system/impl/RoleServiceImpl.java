package com.litchi.service.system.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.litchi.entity.system.Role;
import com.litchi.mapper.system.RoleMapper;
import com.litchi.service.system.IRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author Noah
 * @since 2024-01-04
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
