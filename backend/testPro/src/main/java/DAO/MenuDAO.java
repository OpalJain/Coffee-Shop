package DAO;

import java.util.List;

import org.junit.jupiter.api.Test;

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
	
	@Test
	public void testMenu() {
		MenuDAO menuDAO = new MenuDAO();
		MenuObjs menuObjs;
		try {
			menuObjs = menuDAO.GetMenuData();
			
			Gson gson = new Gson();
			String jsonString = gson.toJson(menuObjs);
			System.out.println(jsonString);
			
			MenuItem menuItem = menuDAO.GetMenuProductById(1);
			jsonString = gson.toJson(menuItem);
			System.out.println(jsonString);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
