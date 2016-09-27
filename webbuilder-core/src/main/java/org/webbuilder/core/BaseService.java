package org.webbuilder.core;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.webbuilder.config.DefaultArgs;
import org.webbuilder.utils.DataUtils;
import org.webbuilder.utils.StringKit;

import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.Config;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.DbKit;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.druid.DruidPlugin;

/**
 * @Description: BaseService
 * @author Stone shentong33@hotmail.com
 * @date 2016年5月16日 下午2:12:12
 */
public class BaseService extends Db {
	
	/**
	 * Default no-arg constructor
	 */
	public BaseService() {
		use(StringKit.withDefault(PropKit.get(DefaultArgs.DATASOURCE_NAME), DefaultArgs.DATASOURCE_NAME_DV));
	}
	
	/**
	 * constructor by dataSourceName
	 * 
	 * @param dataSourceName
	 */
	public BaseService(String dataSourceName) {
		use(dataSourceName);
	}

	/**
	 * init service by args
	 * 
	 * @param jdbcUrl
	 * @param user
	 * @param password
	 */
	public BaseService(String jdbcUrl, String user, String password) {
		new BaseService(UUID.randomUUID().toString(),jdbcUrl,user,password);
	}
	
	/**
	 * init service and specified dsName
	 * 
	 * @param dataSourceName
	 * @param jdbcUrl
	 * @param user
	 * @param password
	 */
	public BaseService(String dataSourceName, String jdbcUrl, String user, String password) {
		if (StringUtils.isBlank(dataSourceName) || StringUtils.isBlank(jdbcUrl) || StringUtils.isBlank(user) || StringUtils.isBlank(password))
			throw new RuntimeException("invalid args, it is must be not null");
		DruidPlugin druidPlugin = new DruidPlugin(jdbcUrl, user, password);
		Config config = new Config(UUID.randomUUID().toString(), druidPlugin.getDataSource());
		DbKit.addConfig(config);
		use(dataSourceName);
	}
	
	
	/*******************************************************
	 ***************  make a simple SQL kit  ***************  
	 *******************************************************/        
	public <T extends Model<T>> List<T> selectAll(Class<? extends Model<T>> t){
		return selectCheck(t,null);
	}
	
	public <T extends Model<T>> List<T> selectColumns(Class<? extends Model<T>> t, String... column){
		return selectCheck(t,null,column);
	}
	
	public <T extends Model<T>> List<T> selectCondition(Class<? extends Model<T>> t, String condition){
		return selectCheck(t,condition);
	}	
	
	public <T extends Model<T>> List<T> selectCheck(Class<? extends Model<T>> t, String condition, String... column){
		return DataUtils.getDaoObject(t).find(DataUtils.buildSQL(t, column, condition));
	}	
}
