package com.gerry.authsystem.controller.login;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gerry.authsystem.entity.SysUser;
import com.gerry.authsystem.service.ISysUserService;

@Controller
@RequestMapping("/user")
public class LoginController {
	
	@Resource
	private ISysUserService sysUserService;
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model){
		String usercode = "admin";
		SysUser sysUser = sysUserService.getUserById(usercode);
		model.addAttribute("sysUser",sysUser);
		return "home";
	}
	
}
