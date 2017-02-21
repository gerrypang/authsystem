package com.gerry.authsystem.dao;

import com.gerry.authsystem.entity.SysUser;

public interface SysUserDao {
	
	public SysUser findById(String usercode);
	
	public SysUser findBySysUser(SysUser sysuser);
	
	public long findAllCount(SysUser sysuser);
	
}
