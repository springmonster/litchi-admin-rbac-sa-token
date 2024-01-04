package com.litchi.service.system;


import com.baomidou.mybatisplus.extension.service.IService;
import com.litchi.common.base.PageResp;
import com.litchi.entity.system.User;
import com.litchi.param.system.cmd.UserModifyCmd;
import com.litchi.param.system.cmd.UserSaveCmd;
import com.litchi.param.system.query.UserListQuery;
import com.litchi.vo.system.SysUserVO;

import java.util.List;

/**
 * 用户表
 *
 * @author Noah gby_dev@163.com
 * @since 1.0.0 2023-09-26
 */
public interface IUserService extends IService<User> {

    /**
     * 分页查询
     * @param userListQuery UserListQuery
     * @return PageResult<SysUserVO>
     */
    PageResp<SysUserVO> page(UserListQuery userListQuery);

    /**
     * 保存
     * @param userSaveCmd UserSaveCmd
     * @return String
     */
    String save(UserSaveCmd userSaveCmd);

    /**
     * 修改
     * @param userModifyCmd UserModifyCmd
     * @return Boolean
     */
    Boolean update(UserModifyCmd userModifyCmd);

    /**
     * 删除
     * @param idList List<Long>
     * @return Boolean
     */
    Boolean delete(List<Long> idList);

}