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
	
    public void removeItemFromMenu(int orderId) throws Exception {
    	String sqlString = "DELETE FROM menu WHERE id = ?;";
    	int i = excuteUpdate(sqlString, orderId);
    	System.out.printf("removeItemFromMenu result is %d \n", i);
    }
    
    public void addOrderToMenu(MenuItem menuItem) throws Exception {
    	String sqlString = "INSERT INTO menu (id, name, description, image, price) VALUES (?,?,?,?,?);";
    	
    	int i = excuteUpdate(sqlString, 
    			menuItem.getId(), 
    			menuItem.getName(), 
    			menuItem.getDescription(),
    			menuItem.getImage(),
    			menuItem.getPrice());
    }
	
	
}
