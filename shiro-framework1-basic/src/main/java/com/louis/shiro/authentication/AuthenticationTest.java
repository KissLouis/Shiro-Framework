package com.louis.shiro.authentication;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @Title: AuthenticationTest
 * @Description: Shiro认证
 * @author Louis
 * @date 2017年10月9日
 */
public class AuthenticationTest {
	
	private static final transient Logger log = LoggerFactory.getLogger(AuthenticationTest.class);
	
	@Test
	public void login() {
		
		 log.info("My First Apache Shiro Application");
		
		// 创建SecurityManager工厂，通过init配置文件构造
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
 
        // 创建SecurityManager
        SecurityManager securityManager = factory.createInstance();
 
        // 将SecurityManager设置到当前运行环境
        SecurityUtils.setSecurityManager(securityManager);
 
        // 从SecurityUtils里创建Subject
        Subject subject = SecurityUtils.getSubject();
 
        // 认证提交前准备token
        UsernamePasswordToken token = new UsernamePasswordToken("louis","123456");
 
        try{
            // 执行认证提交
            subject.login(token);
        }catch(Exception e){
            e.printStackTrace();
        }
 
        // 是否认证通过
        boolean isAuthenticated = subject.isAuthenticated();
        System.out.println("是否认证通过: " + isAuthenticated);

        // 退出操作
        subject.logout();
 
        isAuthenticated = subject.isAuthenticated();
        System.out.println("是否认证通过: " + isAuthenticated);
	}

}
