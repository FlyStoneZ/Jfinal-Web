package org.webbuilder.webconfig;

import org.webbuilder.config.DefaultArgs;
import org.webbuilder.config.IProjectConfig;
import org.webbuilder.persistence.MappingKit;
import org.webbuilder.utils.StringKit;

import com.jfinal.config.Plugins;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;

/**
 * PluginsConfig
 * @author Stone
 *
 * Date: 2016年7月27日  上午11:13:37
 * Email: shentong33@hotmail.com
 */
public class PluginsConfig implements IProjectConfig<Plugins> {

	@Override
	public void config(Plugins plugins) {
		DruidPlugin druidPlugin = new DruidPlugin(prop.get(DefaultArgs.DATABASE_URL), prop.get(DefaultArgs.DATABASE_USER), prop.get(DefaultArgs.DATABASE_PASSWORD),prop.get(DefaultArgs.DATABASE_DRIVER));
		druidPlugin.setFilters("stat,wall");
		ActiveRecordPlugin arp = new ActiveRecordPlugin(StringKit.withDefault(prop.get(DefaultArgs.DATASOURCE_NAME), DefaultArgs.DATASOURCE_NAME_DV), druidPlugin);
		plugins.add(druidPlugin);
		plugins.add(arp);
		MappingKit.mapping(arp);
	}
}
