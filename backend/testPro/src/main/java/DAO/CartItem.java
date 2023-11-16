package DAO;

//import com.google.gson.Gson;

public class CartItem {
    private int id;
    private int quantity;

    public CartItem() {
        // 默认构造函数
    }

    public CartItem(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    // Getter 和 Setter 方法
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
//    	Gson gson = new Gson();
//
//    	CartItem cartItem = new CartItem(1,2);
//    	String json = gson.toJson(cartItem);
//    	System.out.println(json);
    }
}
