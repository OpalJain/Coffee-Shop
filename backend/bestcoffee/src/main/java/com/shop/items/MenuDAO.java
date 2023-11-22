package com.shop.items;

import java.util.List;

import com.google.gson.Gson;

/*
 * GetMenuData() 
 * 
 * GetMenuProductById(id)
 * 
 */
public class MenuDAO extends BaseDAO{

	
	public MenuObjs GetMenuData() throws Exception  {
    	String sqlString = "SELECT * FROM menu;";
    	List<MenuItem> menuItems = executeQuery(MenuItem.class, sqlString);
    	
    	MenuObjs menuObjs = new MenuObjs(menuItems);
		return menuObjs;
	}
	
	public MenuItem GetMenuProductById(int id) throws Exception {
    	String sqlString = "SELECT * FROM menu where id = ?;";
    	List<MenuItem> menuItems = executeQuery(MenuItem.class, sqlString, id);
    	
    	return menuItems.get(0);
	}
	
	
}
