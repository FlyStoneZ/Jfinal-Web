package org.stone.devtools;

import com.jfinal.plugin.activerecord.generator.BaseModelGenerator;
import com.jfinal.plugin.activerecord.generator.ColumnMeta;
import com.jfinal.plugin.activerecord.generator.TableMeta;

/**
 * @Description: CustomBaseModelGenerator
 * @author Stone shentong33@hotmail.com
 * @date 2016年5月16日 上午10:51:34
 */
public class CustomBaseModelGenerator extends BaseModelGenerator {

	public CustomBaseModelGenerator(String baseModelPackageName, String baseModelOutputDir) {
		super(baseModelPackageName, baseModelOutputDir);
	}
	
	@Override
	protected void genBaseModelContent(TableMeta tableMeta) {
		StringBuilder ret = new StringBuilder();
		genPackage(ret);
		genImport(ret);
		genClassDefine(tableMeta, ret);
		ret.append(String.format("\tpublic static final String tableName = \"%s\";%n%n", tableMeta.name));
		for (ColumnMeta columnMeta : tableMeta.columnMetas) {
			genSetMethodName(columnMeta, ret);
			genGetMethodName(columnMeta, ret);
		}
		ret.append(String.format("}%n"));
		tableMeta.baseModelContent = ret.toString();
	}
}
