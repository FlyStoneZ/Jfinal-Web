package org.webbuilder.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import com.jfinal.plugin.activerecord.Model;

/** 
 * @Description: database utils
 * @author Stone shentong33@hotmail.com   
 * @date 2016年5月17日 下午2:07:07 
 */
public class DataUtils {
	
	private static final String SelectBasic = "select %s from %s where 1=1 %s";
	private static String Columns = "*";
	private static String Tables = "dual";
	private static String Condition = "";
	
	private static String TableField = "tableName";
	private static String DaoField = "dao";
	
	/**
	 * build a simple SQL
	 * 
	 * @param table
	 * @param column
	 * @param condition
	 * @return String
	 */
	public static final String buildSQL(Class<? extends Model<?>> c, String[] column, String condition){
		if(c == null)
			throw new IllegalArgumentException("Class is must be not null!");
		if(column != null && column.length > 0)
			Columns = ArrayUtils.toString(column).replace("{", "").replace("}", "");
		if(StringUtils.isNotBlank(condition))	
			Condition = condition;
		Tables = getTableName(c);
		return String.format(SelectBasic, Columns,Tables,Condition);
	}
	
	/**
	 * get tableName by generate BaseModel
	 * 
	 * @param c
	 * @return 
	 * @return String
	 */
	public static final String getTableName(Class<? extends Model<?>> c){
		try {
			return c.getField(TableField).get(c).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * get DaoObject's dao field , so if you generate model, dao field by default name dao
	 * 
	 * @param t
	 * @return 
	 * @return T
	 */
	@SuppressWarnings("unchecked")
	public static final <T extends Model<T>> T getDaoObject(Class<? extends Model<T>> t){
		try {
			return (T) FieldUtils.readStaticField(t, DaoField);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
