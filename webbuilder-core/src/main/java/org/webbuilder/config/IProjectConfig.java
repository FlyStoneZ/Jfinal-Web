package org.webbuilder.config;

import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;

/**
 * Project config interface
 * @author Stone
 *
 * Date: 2016年7月27日  上午11:04:51
 * Email: shentong33@hotmail.com
 */
public interface IProjectConfig<T> {
	void config(T o);
	Prop prop = PropKit.use("config.properties");
}
