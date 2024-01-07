package com.litchi.service.system.impl;


import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.litchi.common.base.BizException;
import com.litchi.common.base.PageResp;
import com.litchi.common.enums.ResultCodeEnum;
import com.litchi.convert.system.RoleConvert;
import com.litchi.entity.system.Role;
import com.litchi.mapper.system.RoleMapper;
import com.litchi.param.system.cmd.RoleModifyCmd;
import com.litchi.param.system.cmd.RoleSaveCmd;
import com.litchi.param.system.query.RoleListQuery;
import com.litchi.service.system.IRoleService;
import com.litchi.vo.system.RoleVO;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    @Resource
    private RoleConvert roleConvert;
    @Override
    public PageResp<RoleVO> page(RoleListQuery roleListQuery) {
        IPage<Role> page = baseMapper.selectPage(new Page<>(roleListQuery.getPageNo(), roleListQuery.getPageSize()), getWrapper(roleListQuery));
        List<RoleVO> userVOS = roleConvert.convertList(page.getRecords());
        return new PageResp<>(page.getTotal(),page.getSize(),page.getCurrent(), userVOS);
    }

    /**
     * 构造查询条件
     * @param roleListQuery RoleListQuery
     * @return LambdaQueryWrapper<Role>
     */
    private LambdaQueryWrapper<Role> getWrapper(RoleListQuery roleListQuery){
        LambdaQueryWrapper<Role> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(StringUtils.isNotEmpty(roleListQuery.getRoleName()), Role::getRoleName, roleListQuery.getRoleName());
        wrapper.eq(Objects.nonNull(roleListQuery.getStatus()), Role::getStatus, roleListQuery.getStatus());
        return wrapper;
    }


    @Override
    public String save(RoleSaveCmd roleSaveCmd) {
        Role entity = roleConvert.convert(roleSaveCmd);
        Long roleId = IdUtil.getSnowflakeNextId();
        entity.setId(roleId);
        baseMapper.insert(entity);
        return String.valueOf(roleId);
    }

    @Override
    public Boolean update(RoleModifyCmd roleModifyCmd) {
        Role role = baseMapper.selectById(roleModifyCmd);
        if(Objects.isNull(role)){
            throw new BizException(ResultCodeEnum.USER_NOT_EXITS);
        }
        role = roleConvert.convert(roleModifyCmd);
        updateById(role);
        return Boolean.TRUE;
    }

    @Override
    public Boolean delete(List<Long> idList) {
        removeByIds(idList);
        return Boolean.TRUE;
    }
}
