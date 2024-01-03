package com.litchi.vo.system;

//import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
* 用户表
*
* @author Noah gby_dev@163.com
* @since 1.0.0 2023-09-26
*/
@Data
//@Schema(description = "用户表")
public class SysUserVO implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	//@Schema(description = "主键")
	private String id;

	//@Schema(description = "用户名称")
	private String userName;

	//@Schema(description = "密码")
	private String password;

	//@Schema(description = "手机号")
	private String phone;

	//@Schema(description = "邮箱")
	private String email;

	//@Schema(description = "头像")
	private String avatar;

	/**
	 * 昵称
	 */
	private String nickName;

	/**
	 * 性别
	 */
	private Integer sex;

	//@Schema(description = "账号状态：0-正常，1-禁用")
	private Integer status;


}