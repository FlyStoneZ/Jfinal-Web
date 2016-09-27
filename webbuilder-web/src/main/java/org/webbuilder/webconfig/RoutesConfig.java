package org.webbuilder.webconfig;

import org.webbuilder.config.IProjectConfig;
import org.webbuilder.routes.RoutesAdmin;

import com.jfinal.config.Routes;

/**
 * RoutesConfig
 * @author Stone
 *
 * Date: 2016年7月27日  上午11:11:00
 * Email: shentong33@hotmail.com
 */
public class RoutesConfig implements IProjectConfig<Routes> {

	@Override
	public void config(Routes rt) {
		rt.add(new RoutesAdmin());
	}
}
