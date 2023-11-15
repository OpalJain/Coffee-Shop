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

import DAO.CartDAO;
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
 
         CartDAO cartDAO = new CartDAO();
         CartOrders cartOrders;
		try {
			cartOrders = cartDAO.getCartOrders();
	        String responseData = gson.toJson(cartOrders);

	         // 设置响应的内容类型
	         response.setContentType("application/json");
	         // 设置响应状态码
	         response.setStatus(HttpServletResponse.SC_OK);
	         // 将 JSON 数据写入响应流
	         response.getWriter().write(responseData);
	         System.out.print(responseData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().write("Tryed to read data in Cart-orders but failed!!");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * /cart-orders/:id/decrement
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the URI of the request
        String uri = request.getRequestURI();
        System.out.println(uri);

        // Split the URI based on the '/' delimiter
        String[] uriParts = uri.split("/");

        // Extract the values to get the id
        if (uriParts.length >= 4) {
            String value1 = uriParts[2]; // This will be "2"
            String value2 = uriParts[3]; // This will be "decrement"

            // Now you can use value1 and value2 as needed
            // ...
        } else {
            // Handle the case where the URI doesn't have enough parts
            // ...
        }
	}
	
   @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // DELETE 
    }

}
