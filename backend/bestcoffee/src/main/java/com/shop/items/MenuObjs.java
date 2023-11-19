package com.shop.items;

import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class MenuObjs {
    private List<MenuItem> menu;
    Gson gson;

    // Constructors, getters, and setters (generated or manually implemented) go here


    public MenuObjs(List<MenuItem> menu) {
    	gson = new Gson();
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
        return gson.toJson(this.menu);
    }
}
