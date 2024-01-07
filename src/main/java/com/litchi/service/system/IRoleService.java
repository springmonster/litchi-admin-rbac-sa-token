package com.litchi.service.system;

import com.baomidou.mybatisplus.extension.service.IService;
import com.litchi.common.base.PageResp;
import com.litchi.entity.system.Role;
import com.litchi.param.system.cmd.RoleModifyCmd;
import com.litchi.param.system.cmd.RoleSaveCmd;
import com.litchi.param.system.query.RoleListQuery;
import com.litchi.vo.system.RoleVO;

import java.util.List;

/**
 * <p>
 * 角色信息表 服务类
 * </p>
 *
 * @author Noah
 * @since 2024-01-04
 */
public interface IRoleService extends IService<Role> {


    /**
     * 分页查询
     * @param roleListQuery RoleListQuery
     * @return PageResp<RoleVO>
     */
    PageResp<RoleVO> page(RoleListQuery roleListQuery);

    /**
     * 保存
     * @param roleSaveCmd RoleSaveCmd
     * @return String
     */
    String save(RoleSaveCmd roleSaveCmd);

    /**
     * 修改
     * @param roleModifyCmd RoleModifyCmd
     * @return Boolean
     */
    Boolean update(RoleModifyCmd roleModifyCmd);

    /**
     * 删除
     * @param idList List<Long>
     * @return Boolean
     */
    Boolean delete(List<Long> idList);

}
