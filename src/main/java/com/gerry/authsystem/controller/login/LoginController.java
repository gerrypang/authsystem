package com.gerry.authsystem.controller.login;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.gerry.authsystem.entity.SysUser;
import com.gerry.authsystem.service.ISysUserService;

@Controller
@RequestMapping("/user")
public class LoginController {
	
	@Resource
	private ISysUserService sysUserService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(SysUser sysUser, Model model){
		String usercode = sysUser.getUsercode();
		String password = sysUser.getPassword();
		SysUser getSysUser = sysUserService.getUserById(usercode);
		model.addAttribute("sysUser",getSysUser);
		return "system/index";
	}
	
}
