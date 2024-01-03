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
import com.litchi.convert.system.SysUserConvert;
import com.litchi.dao.system.SysUserDao;
import com.litchi.entity.system.SysUserEntity;
import com.litchi.param.system.cmd.UserModifyCmd;
import com.litchi.param.system.cmd.UserSaveCmd;
import com.litchi.param.system.query.UserListQuery;
import com.litchi.service.system.SysUserService;
import com.litchi.vo.system.SysUserVO;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * 用户表
 *
 * @author Noah gby_dev@163.com
 * @since 1.0.0 2023-09-26
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    @Resource
    private SysUserConvert userConvert;


    @Override
    public PageResp<SysUserVO> page(UserListQuery userListQuery) {
        IPage<SysUserEntity> page = baseMapper.selectPage(new Page<>(userListQuery.getPageNo(), userListQuery.getPageSize()), getWrapper(userListQuery));
        List<SysUserVO> sysUserVOS = userConvert.convertList(page.getRecords());
        return new PageResp<>(page.getTotal(),page.getSize(),page.getCurrent(),sysUserVOS);
    }

    /**
     * 构造查询条件
     * @param userListQuery UserListQuery
     * @return LambdaQueryWrapper<SysUserEntity>
     */
    private LambdaQueryWrapper<SysUserEntity> getWrapper(UserListQuery userListQuery){
        LambdaQueryWrapper<SysUserEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(StringUtils.isNotEmpty(userListQuery.getUserName()), SysUserEntity::getUserName, userListQuery.getUserName());
        wrapper.eq(StringUtils.isNotEmpty(userListQuery.getPhone()), SysUserEntity::getPhone, userListQuery.getPhone());
        wrapper.eq(StringUtils.isNotEmpty(userListQuery.getEmail()), SysUserEntity::getEmail, userListQuery.getEmail());
        return wrapper;
    }

    @Override
    public String save(UserSaveCmd userSaveCmd) {
        SysUserEntity entity = userConvert.convert(userSaveCmd);
        long userId = IdUtil.getSnowflakeNextId();
        entity.setId(userId);
        baseMapper.insert(entity);
        return String.valueOf(userId);
    }

    @Override
    public Boolean update(UserModifyCmd userModifyCmd) {
        SysUserEntity sysUserEntity = baseMapper.selectById(userModifyCmd.getId());
        if(Objects.isNull(sysUserEntity)){
            throw new BizException(ResultCodeEnum.USER_NOT_EXITS);
        }
        sysUserEntity = userConvert.convert(userModifyCmd);
        updateById(sysUserEntity);
        return Boolean.TRUE;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(List<Long> idList) {
        removeByIds(idList);
        return Boolean.TRUE;
    }



}