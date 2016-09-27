package org.webbuilder.routes;

import org.webbuilder.action.FrameAction;
import org.webbuilder.action.LoginAction;

import com.jfinal.config.Routes;

/** 
 * @Description: Route
 * @author Stone shentong33@hotmail.com   
 * @date 2016年4月17日 下午12:47:58 
 */
public class RoutesAdmin extends Routes {

	@Override
	public void config() {
		add("/",FrameAction.class,"/");
		add("login", LoginAction.class,"/");
	}
}
