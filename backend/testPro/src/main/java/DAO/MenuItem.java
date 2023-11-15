package DAO;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;


public class MenuItem {
    private int id;
    private String name;
    private String description;
    private String image;
    private int price;

    // Constructors, getters, and setters (generated or manually implemented) go here
    public MenuItem(int id, String name, String description, String image, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                '}';
    }
    
    public String tryJson() {
        Gson gson = new Gson();

        MenuItem menuItem1 = new MenuItem(1, "Coffee Item", "This is a delicious cup of coffee.", "coffee-cup.svg", 10);

        String json = gson.toJson(menuItem1);
        return json;
    }
}
