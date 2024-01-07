package com.litchi.service.system;


import com.baomidou.mybatisplus.extension.service.IService;
import com.litchi.entity.system.Menu;
import com.litchi.param.system.cmd.MenuModifyCmd;
import com.litchi.param.system.cmd.MenuSaveCmd;
import com.litchi.param.system.query.MenuListQuery;
import com.litchi.vo.system.MenuVO;

import java.util.List;

/**
 * <p>
 * 菜单信息表 服务类
 * </p>
 *
 * @author Noah
 * @since 2024-01-04
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 菜单列表查询
     * @param menuListQuery MenuListQuery
     * @return List<MenuVO>
     */
    List<MenuVO> list(MenuListQuery menuListQuery);

    /**
     * 菜单保存
     * @param menuSaveCmd MenuSaveCmd
     * @return String
     */
    String save(MenuSaveCmd menuSaveCmd);

    /**
     * 菜单修改
     * @param menuModifyCmd MenuModifyCmd
     * @return Boolean
     */
    Boolean update(MenuModifyCmd menuModifyCmd);

    /**
     * 删除
     * @param idList List<Long>
     * @return Boolean
     */
    Boolean delete(List<Long> idList);
}
