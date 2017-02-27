package com.gerry.authsystem.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gerry.authsystem.dao.ISysUserDao;
import com.gerry.authsystem.dao.SysUserDao;
import com.gerry.authsystem.entity.SysUser;
import com.gerry.authsystem.service.ISysUserService;

@Service("sysUserService")
public class SysUserServiceImpl implements ISysUserService {

	@Resource
	private ISysUserDao sysUserDao;
	
	@Override
	public SysUser getUserByObject(String usercode) {
		return this.sysUserDao.selectByPrimaryKey(usercode)
	}

}
