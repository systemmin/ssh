package com.min.biz;

import com.min.entity.SysEmployee;

public interface SysEmployeeBiz {

	/**
	 * 用户登陆
	 * @param sysEmployee 传入用户名和密码
	 * @return 返回用户对象
	 */
	public SysEmployee checkLogin(SysEmployee sysEmployee);
}
