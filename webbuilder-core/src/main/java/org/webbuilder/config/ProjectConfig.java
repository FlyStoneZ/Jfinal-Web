package org.webbuilder.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import org.webbuilder.config.DefaultArgs;
import org.webbuilder.utils.StringKit;

/**
 * @Description: projects init config
 * @author Stone shentong33@hotmail.com
 * @date 2016年4月17日 上午10:52:44
 */
public class ProjectConfig extends JFinalConfig {
	
	/**	
	 * step.1
	 * @Description: Constant
	 * @param cons
	 */
	@Override
	public void configConstant(Constants cons) {
		loadPropertyFile("config.properties");
		ConfigFactory.configConstant.config(cons,StringKit.withDefault(prop.get(DefaultArgs.CONSTANT_CLASS), DefaultArgs.CONSTANT_CLASS_DV) );
	}

	/**	
	 * step.2
	 * @Description: Route
	 * @param rt
	 */
	@Override
	public void configRoute(Routes rt) {
		ConfigFactory.configRoute.config(rt,StringKit.withDefault(prop.get(DefaultArgs.ROUTES_CLASS),DefaultArgs.ROUTES_CLASS_DV));
	}
	
	/** 
	 * step.3
	 * @Description: Plugin
	 * @param plugin
	 */
	@Override
	public void configPlugin(Plugins plugin) {
		ConfigFactory.configPlugin.config(plugin,StringKit.withDefault(prop.get(DefaultArgs.PLUGINS_CLASS),DefaultArgs.PLUGINS_CLASS_DV));
	}
	
	/**	
	 * step.4
	 * @Description: Interceptor
	 * @param inter
	 */
	@Override
	public void configInterceptor(Interceptors inter) {
		ConfigFactory.configInterceptor.config(inter,StringKit.withDefault(prop.get(DefaultArgs.INTERCEPTORS_CLASS),DefaultArgs.INTERCEPTORS_CLASS_DV));
	}
	
	/**	
	 * step.5
	 * @Description: Handler load no.5
	 * @param handler
	 */
	@Override
	public void configHandler(Handlers handler) {
		ConfigFactory.configHandler.config(handler,StringKit.withDefault(prop.get(DefaultArgs.HANDLER_CLASS),DefaultArgs.HANDLER_CLASS_DV));
	}
}
