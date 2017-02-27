package com.gerry.authsystem.dao;

import com.gerry.authsystem.entity.SysUser;

public interface ISysUserDao {
    int deleteByPrimaryKey(String usercode);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String usercode);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}