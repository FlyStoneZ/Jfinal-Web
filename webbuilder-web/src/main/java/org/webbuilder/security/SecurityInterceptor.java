package org.webbuilder.security;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/** 
 * @Description: Security Interceptor
 * @author Stone shentong33@hotmail.com   
 * @date 2016年4月26日 上午10:09:55 
 */
public class SecurityInterceptor implements Interceptor {
	/*
	 * 菜单表 
	 * 角色表
	 * 用户表
	 * 权限表
	 * 
	 * 角色权限视图
	 * 角色菜单视图
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	@Override
	public void intercept(Invocation inv) {
		try {
			inv.invoke();
		} catch (Exception e) {
			System.out.println("==================================");
		}
	}
}