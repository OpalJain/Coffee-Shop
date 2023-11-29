package com.shop.items;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCartItem {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testCartItem() {

		        List<CartItem> cartItems = Arrays.asList(
		            new CartItem(1, 2),
		            new CartItem(2,4)
		        );
		        CartOrders cartOrders = new CartOrders(cartItems);
		        String expectedResult = "[" +
		            "{" +
		                "\"id\":1," +
		                "\"quantity\":2" +
		            "}," +
		            "{" +
		                "\"id\":2," +
		                "\"quantity\":4" +
		            "}" +
		        "]";

		        // Act
		        String result = cartOrders.toString();

		        // Assert
		        assertEquals(expectedResult, result);
		    }
		
	

//	@Test
//	void testCartItemIntInt() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetId() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSetId() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetQuantity() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSetQuantity() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testToString() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testMain() {
//		fail("Not yet implemented");
//	}

}
