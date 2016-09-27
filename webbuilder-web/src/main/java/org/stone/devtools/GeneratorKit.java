package org.stone.devtools;

import javax.sql.DataSource;

import com.jfinal.kit.PathKit;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.jfinal.plugin.activerecord.generator.MappingKitGenerator;
import com.jfinal.plugin.activerecord.generator.ModelGenerator;
import com.jfinal.plugin.druid.DruidPlugin;

/**
 * @Description: Generator data about java file
 * @author Stone shentong33@hotmail.com   
 * @date 2016年4月20日 下午8:21:27
 */
public class GeneratorKit {
	
	/**
	 * @Description: start datapool plugin
	 * @return DataSource
	 */
	public static DataSource getDataSource() {
		Prop p = PropKit.use("config.properties");
		DruidPlugin druidPlugin = new DruidPlugin(p.get("database.url"), p.get("database.user"), p.get("database.password"));
		druidPlugin.start();
		return druidPlugin.getDataSource();
	}
	
	public static void main(String[] args) {
		// base model 所使用的包名
		String baseModelPackageName = "org.stone.model.base";
		// base model 文件保存路径
		String baseModelOutputDir = PathKit.getWebRootPath() + "/src/main/java/org/stone/model/base";
		
		// model 所使用的包名 (MappingKit 默认使用的包名)
		String modelPackageName = "org.stone.model";
		// model 文件保存路径 (MappingKit 与 DataDictionary 文件默认保存路径)
		String modelOutputDir = baseModelOutputDir + "/..";
		
		//Custom MappingKitGenerator Class Name to remove '_' prefix
		MappingKitGenerator mappingKitGenerator = new MappingKitGenerator(modelPackageName, modelOutputDir);
		mappingKitGenerator.setMappingKitClassName("MappingKit");
		
		// 创建生成器
//		Generator gernerator = new Generator(getDataSource(), baseModelPackageName, baseModelOutputDir, modelPackageName, modelOutputDir);
		Generator gernerator = new Generator(getDataSource(), new CustomBaseModelGenerator(baseModelPackageName, baseModelOutputDir),new ModelGenerator(modelPackageName, baseModelPackageName, modelOutputDir));
		// Custom mappingKitGenerator
		gernerator.setMappingKitGenerator(mappingKitGenerator);
		// Custom DataDictionaryFileName
		gernerator.setDataDictionaryFileName("Data.dic");
		// 设置数据库方言
		gernerator.setDialect(new MysqlDialect());
		// 添加不需要生成的表名
		//gernerator.addExcludedTable("adv");
		// 设置是否在 Model 中生成 dao 对象
		gernerator.setGenerateDaoInModel(true);
		// 设置是否生成字典文件
		gernerator.setGenerateDataDictionary(true);
		// 设置需要被移除的表名前缀用于生成modelName。例如表名 "osc_user"，移除前缀 "osc_"后生成的model名为 "User"而非 OscUser
		gernerator.setRemovedTableNamePrefixes("webdb_");
		// 生成
		gernerator.generate();
	}
}
