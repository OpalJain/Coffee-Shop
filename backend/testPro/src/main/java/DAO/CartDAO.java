package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
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
    }

    public void decreaseOrderQuantity(int orderId) throws Exception {
    	String sqlString = "UPDATE cart_orders SET quantity = quantity - 1 WHERE id = ?;";
    	int i = excuteUpdate(sqlString, orderId);
    }

    public void increaseOrderQuantity(int orderId) throws Exception {
    	String sqlString = "UPDATE cart_orders SET quantity = quantity + 1 WHERE id = ?;";
    	int i = excuteUpdate(sqlString, orderId);
    }
    
    public CartOrders getCartOrders() throws Exception {
    	String sqlString = "SELECT * FROM cart_orders;";
    	List<CartItem> cartOrdersList = executeQuery(CartItem.class, "SELECT * FROM cart_orders;");
        // 处理 cartOrdersList
    	
    	CartOrders cartOrders = new CartOrders(cartOrdersList);
		return cartOrders;
    }


}
