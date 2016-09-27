package org.webbuilder.webconfig;

import org.beetl.core.GroupTemplate;
import org.beetl.ext.jfinal.BeetlRenderFactory;
import org.webbuilder.config.DefaultArgs;
import org.webbuilder.config.IProjectConfig;
import org.webbuilder.tag.TestTag;
import org.webbuilder.utils.StringKit;

import com.jfinal.config.Constants;
import com.jfinal.render.ViewType;

/**
 * Constants Config
 * @author Stone
 *
 * Date: 2016年7月27日  上午11:06:06
 * Email: shentong33@hotmail.com
 */
public class ConstantsConfig implements IProjectConfig<Constants> {
	
	@Override
	public void config(Constants cons) {
		cons.setDevMode(true);
		cons.setBaseViewPath(StringKit.withDefault(prop.get(DefaultArgs.BASEVIEWPATH), DefaultArgs.BASEVIEWPATH_DV));
		cons.setViewType(ViewType.OTHER);
		cons.setMainRenderFactory(new BeetlRenderFactory());
		cons.setError500View("/404.html");
		GroupTemplate gt = BeetlRenderFactory.groupTemplate;
		gt.registerTag("test", TestTag.class);
	}
}
