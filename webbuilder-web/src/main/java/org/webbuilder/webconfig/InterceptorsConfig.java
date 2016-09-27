package org.webbuilder.webconfig;

import org.webbuilder.config.IProjectConfig;
import org.webbuilder.security.SecurityInterceptor;

import com.jfinal.config.Interceptors;

/**
 * InterceptorsConfig
 * @author Stone
 *
 * Date: 2016年7月27日  上午11:14:25
 * Email: shentong33@hotmail.com
 */
public class InterceptorsConfig implements IProjectConfig<Interceptors> {

	@Override
	public void config(Interceptors interceptors) {
		interceptors.add(new SecurityInterceptor());
	}

}
