package com.shop.items;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuObjsTest {
    @Test
    public void testMenuObjsConstructor() {
        MenuItem item1 = new MenuItem(1, "Coffee Item", "This is a delicious cup of coffee.", "coffee-cup.svg", 10);
        MenuItem item2 = new MenuItem(2, "Tea Item", "This is a delicious cup of tea.", "tea-cup.svg", 12);
        List<MenuItem> menuItems = Arrays.asList(item1, item2);

        MenuObjs menuObjs = new MenuObjs(menuItems);

        assertEquals(menuItems, menuObjs.getMenu());
    }

    @Test
    public void testMenuObjsToString() {
        MenuItem item1 = new MenuItem(1, "Coffee Item", "This is a delicious cup of coffee.", "coffee-cup.svg", 10);
        MenuItem item2 = new MenuItem(2, "Tea Item", "This is a delicious cup of tea.", "tea-cup.svg", 12);
        List<MenuItem> menuItems = Arrays.asList(item1, item2);

        MenuObjs menuObjs = new MenuObjs(menuItems);

        String expectedJson = "[{\"id\":1,\"name\":\"Coffee Item\",\"description\":\"This is a delicious cup of coffee.\",\"image\":\"coffee-cup.svg\",\"price\":10.0},{\"id\":2,\"name\":\"Tea Item\",\"description\":\"This is a delicious cup of tea.\",\"image\":\"tea-cup.svg\",\"price\":12.0}]";
        assertEquals(expectedJson, menuObjs.toString());
    }
}