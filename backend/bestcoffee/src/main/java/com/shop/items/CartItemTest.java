package com.shop.items;

import org.junit.Test;
import static org.junit.Assert.*;

public class CartItemTest {

    @Test
    public void testConstructor() {
        int id = 1;
        int quantity = 5;
        CartItem item = new CartItem(id, quantity);
        assertEquals(id, item.getId());
        assertEquals(quantity, item.getQuantity());
    }

    @Test
    public void testGettersAndSetters() {
        CartItem item = new CartItem();

        int id = 2;
        item.setId(id);
        assertEquals(id, item.getId());

        int quantity = 3;
        item.setQuantity(quantity);
        assertEquals(quantity, item.getQuantity());
    }

    @Test
    public void testToString() {
        int id = 4;
        int quantity = 7;
        CartItem item = new CartItem(id, quantity);
        assertEquals("MenuItem{id=" + id + ", quantity=" + quantity + '}', item.toString());
    }
}