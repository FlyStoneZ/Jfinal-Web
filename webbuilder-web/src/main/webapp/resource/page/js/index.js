//on load
$(function(){
	var _full = $('body').height();
	var _top = $('.am-g').height();
	var _menu = $('.am-g.blue').height();
	var _contop = $('.am-tabs-nav.am-nav.am-nav-tabs').height();
	console.log("_full== "+_full);
	console.log("_top== "+_top);
	console.log("_menu== "+_menu);
	console.log("_contop== "+_contop);
	initTab(_full-_top-_menu-_contop-_contop,$('.am-tabs-bd .am-tab-panel'));
})