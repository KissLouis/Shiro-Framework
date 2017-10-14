package com.louis.shiro.action;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.louis.shiro.entity.User;

@Controller
public class LoginAction {

	@RequestMapping("login")
	public String loginIn(User user) throws Exception {
		// 1.创建当前登录操作用户
		Subject subject = SecurityUtils.getSubject();
		// 2.创建token令牌，token中有用户提交的认证信息即账号和密码
		UsernamePasswordToken token = new UsernamePasswordToken(user.getName(),
				user.getPwd());
		try {
			subject.login(token);
			System.out.println("chengg");
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return "redirect:/login.jsp";
		}
	}

	
	@RequestMapping("logout")
	public String logout() {
		SecurityUtils.getSubject().logout();
		return "login";
	}

	@RequestMapping("admin")
	@RequiresRoles({ "admin" })
	public String admin() {
		System.out.println("admin doGet");
		return "success";
	}

}
