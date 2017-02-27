package com.gerry.authsystem.service;

import com.gerry.authsystem.entity.SysUser;

public interface ISysUserService{
	
	public SysUser getUserByObject(String usercode);
}
