package com.litchi.service.system.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.litchi.common.base.BizException;
import com.litchi.common.enums.ResultCodeEnum;
import com.litchi.convert.system.MenuConvert;
import com.litchi.entity.system.Menu;
import com.litchi.mapper.system.MenuMapper;
import com.litchi.param.system.cmd.MenuModifyCmd;
import com.litchi.param.system.cmd.MenuSaveCmd;
import com.litchi.param.system.query.MenuListQuery;
import com.litchi.service.system.IMenuService;
import com.litchi.vo.system.MenuVO;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 菜单信息表 服务实现类
 * </p>
 *
 * @author Noah
 * @since 2024-01-04
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
    @Resource
    private MenuConvert menuConvert;

    @Override
    public List<MenuVO> list(MenuListQuery menuListQuery) {
        List<Menu> menuList = baseMapper.selectList(getWrapper(menuListQuery));
        return menuConvert.convertList(menuList);
    }

    /**
     * 构造查询条件
     * @param menuListQuery MenuListQuery
     * @return LambdaQueryWrapper<SysUserEntity>
     */
    private LambdaQueryWrapper<Menu> getWrapper(MenuListQuery menuListQuery){
        LambdaQueryWrapper<Menu> wrapper = Wrappers.lambdaQuery();
        wrapper.like(StringUtils.isNotEmpty(menuListQuery.getMenuName()), Menu::getMenuName, menuListQuery.getMenuName());
        return wrapper;
    }

    @Override
    public String save(MenuSaveCmd menuSaveCmd) {
        Menu menu = menuConvert.convert(menuSaveCmd);
        Long userId = IdUtil.getSnowflakeNextId();
        menu.setId(userId);
        baseMapper.insert(menu);
        return String.valueOf(userId);
    }

    @Override
    public Boolean update(MenuModifyCmd menuModifyCmd) {
        Menu menu = baseMapper.selectById(menuModifyCmd.getId());
        if(Objects.isNull(menu)){
            throw new BizException(ResultCodeEnum.USER_NOT_EXITS);
        }
        menu = menuConvert.convert(menuModifyCmd);
        updateById(menu);
        return Boolean.TRUE;
    }

    @Override
    public Boolean delete(List<Long> idList) {
        removeByIds(idList);
        return Boolean.TRUE;
    }
}
