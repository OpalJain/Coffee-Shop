package com.shop.items;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class CartOrders {
    private List<CartItem> cartOrders;
    private Gson gson;
    
    public CartOrders() {
    	gson = new Gson();
    }

    public CartOrders(List<CartItem> cartOrders) {
    	this();
        this.cartOrders = cartOrders;
    }

    public List<CartItem> getCartOrders() {
        return this.cartOrders;
    }

    public void setCartOrders(List<CartItem> cartOrders) {
        this.cartOrders = cartOrders;
    }

    @Override
    public String toString() {
    	JsonElement obj =  gson.toJsonTree(this.cartOrders);
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("cart-orders", obj);
        //return jsonObject.toString();
        return gson.toJson(this.cartOrders);
    }
}
