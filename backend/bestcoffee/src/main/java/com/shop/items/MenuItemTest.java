package com.shop.items;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuItemTest {
    @Test
    public void testMenuItemConstructor() {
        MenuItem menuItem = new MenuItem(1, "Coffee Item", "This is a delicious cup of coffee.", "coffee-cup.svg", 10);

        assertEquals(1, menuItem.getId());
        assertEquals("Coffee Item", menuItem.getName());
        assertEquals("This is a delicious cup of coffee.", menuItem.getDescription());
        assertEquals("coffee-cup.svg", menuItem.getImage());
        assertEquals(10, menuItem.getPrice());
    }

    @Test
    public void testTryJson() {
        MenuItem menuItem = new MenuItem(1, "Coffee Item", "This is a delicious cup of coffee.", "coffee-cup.svg", 10);

        String expectedJson = "{\"id\":1,\"name\":\"Coffee Item\",\"description\":\"This is a delicious cup of coffee.\",\"image\":\"coffee-cup.svg\",\"price\":10.0}";
        assertEquals(expectedJson, menuItem.tryJson());
    }
}