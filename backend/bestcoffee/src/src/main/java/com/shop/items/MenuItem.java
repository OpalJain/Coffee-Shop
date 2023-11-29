package com.shop.items;

import com.google.gson.Gson;


public class MenuItem {
	private int id;
    private String name;
    private String description;
    private String image;
    private double price;
    
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}


    // Constructors, getters, and setters (generated or manually implemented) go here
    public MenuItem(int id, String name, String description, String image, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
    }
    public MenuItem() {
    	
    }

    
    public String tryJson() {
        Gson gson = new Gson();

        MenuItem menuItem1 = new MenuItem(1, "Coffee Item", "This is a delicious cup of coffee.", "coffee-cup.svg", 10);

        String json = gson.toJson(menuItem1);
        return json;
    }
}

