package com.shop.items;

import java.util.List;

/*
 * AddOrderToCart(id)
 * 
 * RemoveOrderFromCart(id) 
 * 
 * DecreaseOrderQuantity(id)
 * 
 * IncreaseOrderQuantity(id) 
 * 
 * GetCartOrders()
 * 
 */
public class CartDAO extends BaseDAO{
	
    public void addOrderToCart(int orderId) throws Exception {
    	String sqlString = "INSERT INTO cart_orders (id, quantity) VALUES (?, 1);";
    	int i = excuteUpdate(sqlString, orderId);
    }

    public void removeOrderFromCart(int orderId) throws Exception {
    	String sqlString = "DELETE FROM cart_orders WHERE id = ?;";
    	int i = excuteUpdate(sqlString, orderId);
    	System.out.printf("removeOrderFromCart result is %d \n", i);
    }

    public void decreaseOrderQuantity(int orderId) throws Exception {
    	String sqlString = "UPDATE cart_orders SET quantity = quantity - 1 WHERE id = ?;";
    	int i = excuteUpdate(sqlString, orderId);
    }

    public void increaseOrderQuantity(int orderId) throws Exception {
    	String sqlString = "UPDATE cart_orders SET quantity = quantity + 1 WHERE id = ?;";
    	int i = excuteUpdate(sqlString, orderId);
    	if (i == 0) {
			System.out.println("Fail at increaseOrderQuantity!!!");
		}
    }
    
    public CartOrders getCartOrders() throws Exception {
    	String sqlString = "SELECT * FROM cart_orders;";
    	List<CartItem> cartOrdersList = executeQuery(CartItem.class, sqlString);
    	
    	CartOrders cartOrders = new CartOrders(cartOrdersList);
		return cartOrders;
    }
    


}
