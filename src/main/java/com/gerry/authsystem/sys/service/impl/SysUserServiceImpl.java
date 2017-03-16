package com.gerry.authsystem.sys.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.gerry.authsystem.sys.dao.ISysUserDao;
import com.gerry.authsystem.sys.entity.SysUser;
import com.gerry.authsystem.sys.service.ISysUserService;

@Service("sysUserService")
public class SysUserServiceImpl implements ISysUserService {

	@Resource
	private ISysUserDao sysUserDao;

	public SysUser getUserById(String usercode) {
		return this.sysUserDao.selectByPrimaryKey(usercode);
	}
	
	public int delUserById(String usercode) {
		return this.sysUserDao.deleteByPrimaryKey(usercode);
	}
}
