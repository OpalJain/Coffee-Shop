package com.shop.items;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CartOrdersTest {

    @Test
    public void testConstructor() {
        List<CartItem> cartOrders = new ArrayList<>();
        CartOrders orders = new CartOrders(cartOrders);
        assertEquals(cartOrders, orders.getCartOrders());
    }

    @Test
    public void testGettersAndSetters() {
        CartOrders orders = new CartOrders();

        List<CartItem> cartOrders = new ArrayList<>();
        orders.setCartOrders(cartOrders);
        assertEquals(cartOrders, orders.getCartOrders());
    }

    @Test
    public void testToString() {
        List<CartItem> cartOrders = new ArrayList<>();
        CartItem item1 = new CartItem(1, 2);
        CartItem item2 = new CartItem(3, 4);
        cartOrders.add(item1);
        cartOrders.add(item2);

        CartOrders orders = new CartOrders(cartOrders);
        String expectedJson = "[{\"id\":1,\"quantity\":2},{\"id\":3,\"quantity\":4}]";
        assertEquals(expectedJson, orders.toString());
    }
}