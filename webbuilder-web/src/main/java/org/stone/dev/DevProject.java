package org.stone.dev;

import com.jfinal.core.JFinal;

/**
 * @Description: 用于项目开发阶段的jetty内置启动
 * @author Stone shentong33@hotmail.com   
 * @date 2016年4月17日 上午12:46:14
 */
public class DevProject{

	public static void main(String[] args) {
		JFinal.start("src/main/webapp", 80, "/", 1);  
	}

}
