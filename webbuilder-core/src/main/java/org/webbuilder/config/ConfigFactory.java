package org.webbuilder.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;

/**
 * Config Factory
 * @author Stone
 *
 * Date: 2016年7月27日  下午1:48:14
 * Email: shentong33@hotmail.com
 */
@SuppressWarnings("unchecked")
public enum ConfigFactory {
	
	configConstant{

		
		@Override
		void config(Object o, String className) {
			Object newInstance = null;
			try {
				newInstance = Class.forName(className).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			if(newInstance != null && newInstance instanceof IProjectConfig)
				((IProjectConfig<Constants>)newInstance).config((Constants) o);
			else
				throw new IllegalArgumentException("Illegal class Name: " + className);
		}
		
	},
	
	configRoute{
		
		@Override
		void config(Object o, String className)  {
			Object newInstance = null;
			try {
				newInstance = Class.forName(className).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			if(newInstance != null && newInstance instanceof IProjectConfig)
				((IProjectConfig<Routes>)newInstance).config((Routes) o);
			else
				throw new IllegalArgumentException("Illegal class Name: " + className);
		}
		
	},
	
	configPlugin{
		
		@Override
		void config(Object o, String className) {
			Object newInstance = null;
			try {
				newInstance = Class.forName(className).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			if(newInstance != null && newInstance instanceof IProjectConfig)
				((IProjectConfig<Plugins>)newInstance).config((Plugins) o);
			else
				throw new IllegalArgumentException("Illegal class Name: " + className);
		}
		
	},
	
	configInterceptor{

		@Override
		void config(Object o, String className) {
			Object newInstance = null;
			try {
				newInstance = Class.forName(className).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			if(newInstance != null && newInstance instanceof IProjectConfig)
				((IProjectConfig<Interceptors>)newInstance).config((Interceptors) o);
			else
				throw new IllegalArgumentException("Illegal class Name: " + className);
		}
		
	},
	
	configHandler{

		@Override
		void config(Object o, String className) {
			Object newInstance = null;
			try {
				newInstance = Class.forName(className).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			if(newInstance != null && newInstance instanceof IProjectConfig)
				((IProjectConfig<Handlers>)newInstance).config((Handlers) o);
			else
				throw new IllegalArgumentException("Illegal class Name: " + className);
		}
		
	};
	
	abstract void config(Object o, String className);
}
