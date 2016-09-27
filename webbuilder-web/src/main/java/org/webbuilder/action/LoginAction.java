package org.webbuilder.action;

import org.webbuilder.core.BaseAction;

/** 
 * @Description: Login page
 * @author Stone shentong33@hotmail.com   
 * @date 2016年4月17日 下午12:51:26 
 */
public class LoginAction extends BaseAction{
	
	@Override
	public void index() {
		render("login.html");  
	}
}
