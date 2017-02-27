package com.gerry.authsystem.controller.login;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gerry.authsystem.entity.SysUser;
import com.gerry.authsystem.service.SysUserService;

@Controller
@RequestMapping("/user")
public class LoginController {
	
	@Resource
	private SysUserService sysUserService;
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model){
		String usercode = request.getParameter("usercode");
		String password = request.getParameter("password");
		SysUser sysUser = new SysUser();
		sysUser.setUserCode(usercode);
		sysUser.setPassword(password);
		sysUserService.findBySysUser(sysUser);
		model.addAttribute("sysUser",sysUser);
		return "home";
	}
	
}
