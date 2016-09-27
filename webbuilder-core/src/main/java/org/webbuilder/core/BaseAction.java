package org.webbuilder.core;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

/**
 * @Description: Basic Action
 * @author Stone shentong33@hotmail.com   
 * @date 2016年4月19日 下午2:33:58
 */
public abstract class BaseAction extends Controller{

	/**
	 * @Description: use default Jfinal index method by eclipse to auto complete
	 * @return void
	 */
	abstract public void index();
	
	/**
	 * entity
	 */
	private Class<?> clazz;

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public void getByPage() {
		Page<Record> list = Db.paginate(getParaToInt("pageNumber"), getParaToInt("pageSize"), "select *",
				"from " + getClazz().getSimpleName() + " order by id desc");
		renderJson(list);
	}

	public void getAll() {
		renderJson(Db.find("select * from " + getClazz().getSimpleName()));
	}

	public void getById() {
		renderJson(Db.find("select * from " + getClazz().getSimpleName() + " where id = " + getParaToInt("id")));
	}

	public void save() throws Exception {
		renderText(String.valueOf(getModel(((Model<?>) Class.forName(clazz.getName()).newInstance()).getClass()).save()));
	}

	public void update() throws Exception {
		renderText(String.valueOf(getModel(((Model<?>) Class.forName(clazz.getName()).newInstance()).getClass()).update()));
	}

	public void delete() throws Exception {
		renderText(String.valueOf(getModel(((Model<?>) Class.forName(clazz.getName()).newInstance()).getClass()).delete()));
	}
}
