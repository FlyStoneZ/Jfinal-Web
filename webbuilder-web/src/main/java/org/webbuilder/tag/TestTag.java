package org.webbuilder.tag;

import java.io.IOException;
import org.beetl.core.Tag;

/** 
 * @Description: TODO
 * @author Stone shentong33@hotmail.com   
 * @date 2016年5月13日 下午2:12:08 
 */
public class TestTag extends Tag {

	@Override
	public void render() {
		String tagName = (String) args[0];
		//Map<String, String> attr = (Map<String, String>) args[1];
		//String value = attr.get("aaa");
		try {
			this.ctx.byteWriter.write(getBodyContent());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
