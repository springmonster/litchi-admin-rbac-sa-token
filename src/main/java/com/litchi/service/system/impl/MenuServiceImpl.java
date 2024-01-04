package com.litchi.service.system.impl;

import com.litchi.entity.system.Menu;
import com.litchi.mapper.system.MenuMapper;
import com.litchi.service.system.IMenuService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

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

}
