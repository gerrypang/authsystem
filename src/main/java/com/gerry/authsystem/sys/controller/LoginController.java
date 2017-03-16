package com.gerry.authsystem.sys.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gerry.authsystem.sys.entity.SysUser;
import com.gerry.authsystem.sys.service.ISysUserService;
import com.gerry.common.controller.BaseController;

@Controller
@RequestMapping("/sys")
public class LoginController extends BaseController{
	
	@Resource
	private ISysUserService sysUserService;
	
	/**
	 * 登录前异步验证用户
	 * @param sysUser
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/checkUser", method=RequestMethod.POST)
	public String checkUser(SysUser sysUser, Model model){
		String usercode = sysUser.getUsercode();
		String password = sysUser.getPassword();
		SysUser getUser = sysUserService.getUserById(usercode);
		if (getUser != null) {
			if (!password.equals(getUser.getPassword())) {
				return "passwordError";
			} else {
				return "success";
			}
		} else {
			return "userNotExist";
		}
	}
	
	/**
	 * 系统登录
	 * @param sysUser
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(SysUser sysUser, Model model){
		
		return "system/index";
	}
}
