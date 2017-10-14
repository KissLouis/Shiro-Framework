package com.louis.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.louis.shiro.entity.User;
import com.louis.shiro.service.UserService;

public class ShiroRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	/**
	 * 登陆成功了后为当前登陆成功的用户授予权限和角色
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// TODO Auto-generated method stub
		System.out.println("查询认证信息");
		String username = (String) principals.getPrimaryPrincipal(); // 获取用户名
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		try {
			authorizationInfo.setRoles(userService.getRoles(username)); // 设置角色
			authorizationInfo.setStringPermissions(userService
					.getPermission(username)); // 设置权限
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return authorizationInfo;
	}

	/**
	 * 用来验证当前登录的用户，获取认证信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		System.out.println("进入认证信息");
		String userName = (String) token.getPrincipal(); // 获取用户名
		try {
			User user = userService.getUserName(userName); // 仅仅是根据用户名查出的用户信息，不涉及到密码
			if (user != null) {
				AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(
						user.getName(), user.getPwd(), user.getName());
				return authcInfo;
			} else {
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
