package lab.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DAO.CartItem;
import DAO.CartOrders;

/**
 * Servlet implementation class CartOrderServlet
 */
@WebServlet("/cart-orders")
public class CartOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public CartOrderServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        // 处理 GET 请求的逻辑
        // 这里可以调用你的数据获取逻辑，生成响应数据

        // 模拟响应数据
         Gson gson = new Gson();

         CartItem cartItem1 = new CartItem(1, 2);
         CartItem cartItem2 = new CartItem(3, 2);
 
         List<CartItem> listCartItems = new ArrayList<>();
         listCartItems.add(cartItem1);
         listCartItems.add(cartItem2);
 
         CartOrders cartOrders = new CartOrders(listCartItems);

         String json = gson.toJson(cartOrders);
         String responseData = gson.toJson(cartOrders);

        // 设置响应的内容类型
        response.setContentType("application/json");
        // 设置响应状态码
        response.setStatus(HttpServletResponse.SC_OK);
        // 将 JSON 数据写入响应流
        response.getWriter().write(responseData);
        System.out.print(responseData);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
