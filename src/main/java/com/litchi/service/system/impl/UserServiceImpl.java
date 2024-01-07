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
import com.litchi.convert.system.UserConvert;
import com.litchi.entity.system.User;
import com.litchi.mapper.system.UserMapper;
import com.litchi.param.system.cmd.UserModifyCmd;
import com.litchi.param.system.cmd.UserSaveCmd;
import com.litchi.param.system.query.UserListQuery;
import com.litchi.service.system.IUserService;
import com.litchi.vo.system.UserVO;
import jakarta.annotation.Resource;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserConvert userConvert;

    @Override
    public PageResp<UserVO> page(UserListQuery userListQuery) {
        IPage<User> page = baseMapper.selectPage(new Page<>(userListQuery.getPageNo(), userListQuery.getPageSize()), getWrapper(userListQuery));
        List<UserVO> userVOS = userConvert.convertList(page.getRecords());
        return new PageResp<>(page.getTotal(),page.getSize(),page.getCurrent(), userVOS);
    }

    /**
     * 构造查询条件
     * @param userListQuery UserListQuery
     * @return LambdaQueryWrapper<User>
     */
    private LambdaQueryWrapper<User> getWrapper(UserListQuery userListQuery){
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(StringUtils.isNotEmpty(userListQuery.getUserName()), User::getUserName, userListQuery.getUserName());
        wrapper.eq(StringUtils.isNotEmpty(userListQuery.getPhone()), User::getPhone, userListQuery.getPhone());
        wrapper.eq(StringUtils.isNotEmpty(userListQuery.getEmail()), User::getEmail, userListQuery.getEmail());
        return wrapper;
    }

    @Override
    public String save(UserSaveCmd userSaveCmd) {
        User entity = userConvert.convert(userSaveCmd);
        Long userId = IdUtil.getSnowflakeNextId();
        entity.setId(userId);
        baseMapper.insert(entity);
        return String.valueOf(userId);
    }

    @Override
    public Boolean update(UserModifyCmd userModifyCmd) {
        User sysUserEntity = baseMapper.selectById(userModifyCmd.getId());
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