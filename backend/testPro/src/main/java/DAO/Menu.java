package DAO;

import java.util.List;
import com.google.gson.Gson;

public class Menu {
    private List<MenuItem> menu;

    // Constructors, getters, and setters (generated or manually implemented) go here


    public Menu(List<MenuItem> menu) {
        this.menu = menu;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuItem> menu) {
        this.menu = menu;
    }

	@Override
    public String toString() {
        return "Menu{" +
                "menu=" + menu +
                '}';
    }
}
