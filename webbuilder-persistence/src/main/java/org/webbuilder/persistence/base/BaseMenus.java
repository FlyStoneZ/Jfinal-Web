package org.webbuilder.persistence.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseMenus<M extends BaseMenus<M>> extends Model<M> implements IBean {

	public static final String tableName = "webdb_menus";

	public void setGuid(java.lang.String guid) {
		set("guid", guid);
	}

	public java.lang.String getGuid() {
		return get("guid");
	}

	public void setName(java.lang.String name) {
		set("name", name);
	}

	public java.lang.String getName() {
		return get("name");
	}

	public void setColor(java.lang.String color) {
		set("color", color);
	}

	public java.lang.String getColor() {
		return get("color");
	}

	public void setIcon(java.lang.String icon) {
		set("icon", icon);
	}

	public java.lang.String getIcon() {
		return get("icon");
	}

	public void setHref(java.lang.String href) {
		set("href", href);
	}

	public java.lang.String getHref() {
		return get("href");
	}

	public void setParent(java.lang.String parent) {
		set("parent", parent);
	}

	public java.lang.String getParent() {
		return get("parent");
	}

	public void setTopnode(java.lang.String topnode) {
		set("topnode", topnode);
	}

	public java.lang.String getTopnode() {
		return get("topnode");
	}

	public void setOrderNum(java.lang.Integer orderNum) {
		set("orderNum", orderNum);
	}

	public java.lang.Integer getOrderNum() {
		return get("orderNum");
	}

}