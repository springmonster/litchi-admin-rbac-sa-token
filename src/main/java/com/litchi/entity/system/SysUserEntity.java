package com.litchi.entity.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 用户表
 *
 * @author Noah gby_dev@163.com
 * @since 1.0.0 2023-09-26
 */

@Data
@TableName("sys_user")
public class SysUserEntity {
	/**
	* 主键
	*/
	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	* 用户名称
	*/
	private String userName;

	/**
	* 密码
	*/
	private String password;

	/**
	* 手机号
	*/
	private String phone;

	/**
	* 邮箱
	*/
	private String email;

	/**
	 * 昵称
	 */
	private String nickName;

	/**
	 * 性别
	 */
	private Integer sex;

	/**
	* 头像
	*/
	private String avatar;

	/**
	* 账号状态：0-正常，1-禁用
	*/
	private Integer status;

	/**
	* 创建人
	*/
	private Long createId;

	/**
	* 创建时间
	*/
	private Date createTime;

	/**
	* 修改人
	*/
	private Long updateId;

	/**
	* 修改时间
	*/
	private Date updateTime;

}