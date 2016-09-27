package org.webbuilder.action;

import java.util.List;

import org.webbuilder.core.BaseAction;
import org.webbuilder.core.BaseService;
import org.webbuilder.persistence.Menus;

/** 
 * @Description: index page
 * @author Stone shentong33@hotmail.com   
 * @date 2016年4月17日 下午12:51:26 
 */
public class FrameAction extends BaseAction{
	
	private BaseService baseService = new BaseService();

	@Override
	public void index() {
		List<Menus> selectAll = baseService.selectCondition(Menus.class, "order by orderNum desc");
		setAttr("menus", selectAll);
		render("frame.html");
	}
	
	public void index2() throws Throwable{
		render("frame.html#as");
	}
}
