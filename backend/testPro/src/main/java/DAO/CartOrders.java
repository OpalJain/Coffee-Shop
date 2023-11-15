package DAO;

import java.util.List;

public class CartOrders {
    private List<CartItem> cartOrders;

    public CartOrders(List<CartItem> cartOrders) {
        this.cartOrders = cartOrders;
    }

    public List<CartItem> getCartOrders() {
        return cartOrders;
    }

    public void setCartOrders(List<CartItem> cartOrders) {
        this.cartOrders = cartOrders;
    }

    @Override
    public String toString() {
        return "CartOrders{" +
                "cartOrders=" + cartOrders +
                '}';
    }
}
