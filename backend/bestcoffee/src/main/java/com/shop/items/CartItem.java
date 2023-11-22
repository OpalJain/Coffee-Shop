package com.shop.items;

public class CartItem {
	private int id;
    private int quantity;

    public CartItem() {
    }

    public CartItem(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
