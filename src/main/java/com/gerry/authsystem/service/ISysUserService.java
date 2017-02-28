package com.gerry.authsystem.service;

import com.gerry.authsystem.entity.SysUser;

public interface ISysUserService{
	
	public SysUser getUserById(String usercode);
}
