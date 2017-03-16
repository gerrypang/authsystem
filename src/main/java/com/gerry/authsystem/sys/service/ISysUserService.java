package com.gerry.authsystem.sys.service;

import com.gerry.authsystem.sys.entity.SysUser;

public interface ISysUserService{
	
	public SysUser getUserById(String usercode);
	
	public int delUserById(String usercode);
}
