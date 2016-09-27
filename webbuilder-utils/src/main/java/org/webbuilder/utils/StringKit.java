package org.webbuilder.utils;

/**
 * StringKit
 * @author Stone
 *
 * Date: 2016年7月27日  下午3:32:59
 * Email: shentong33@hotmail.com
 */
public class StringKit {
	
	/**
	 * if CharSequence is null return str
	 * @param cs
	 * @param str
	 * @return
	 */
	public static final String withDefault(final CharSequence cs,String str){
		if(cs == null || cs.length()==0 || cs.equals("")){
			return str;
		}
		return cs.toString();
	}
}
