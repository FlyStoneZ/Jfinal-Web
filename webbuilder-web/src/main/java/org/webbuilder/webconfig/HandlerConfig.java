package org.webbuilder.webconfig;

import javax.servlet.http.HttpServletRequest;

import org.webbuilder.config.IProjectConfig;

import com.jfinal.config.Handlers;
import com.jfinal.plugin.druid.DruidStatViewHandler;
import com.jfinal.plugin.druid.IDruidStatViewAuth;

/**
 * HandlerConfig
 * @author Stone
 *
 * Date: 2016年7月27日  上午11:15:07
 * Email: shentong33@hotmail.com
 */
public class HandlerConfig implements IProjectConfig<Handlers> {

	@Override
	public void config(Handlers handler) {
		//druid view
		handler.add(new DruidStatViewHandler("/druid",new IDruidStatViewAuth() {
			//check user
			@Override
			public boolean isPermitted(HttpServletRequest request) {
				return true;
			}
		}));
	}
}
