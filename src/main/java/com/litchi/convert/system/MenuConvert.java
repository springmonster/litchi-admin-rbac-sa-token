package com.litchi.convert.system;

import com.litchi.entity.system.Menu;
import com.litchi.param.system.cmd.MenuModifyCmd;
import com.litchi.param.system.cmd.MenuSaveCmd;
import com.litchi.vo.system.MenuVO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Description:
 * <p> 菜单对象转换
 * Create by noah
 * Date 2024/1/5 23:18
 */
@Mapper(componentModel = "spring")
public interface MenuConvert {

    Menu convert(MenuSaveCmd menuSaveCmd);

    Menu convert(MenuModifyCmd menuModifyCmd);

    List<MenuVO> convertList(List<Menu> list);
}
