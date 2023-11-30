package com.shop.server;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.google.gson.Gson;
import com.shop.items.CartItem;

import com.shop.items.CartDAO;
import com.shop.items.CartOrders;

/**
 * Servlet implementation class CartOrderServlet
 */
@WebServlet(urlPatterns = {"/cart-orders/*"})
public class CartOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartDAO cartDAO = new CartDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		Gson gson = new Gson();
		
        CartOrders cartOrders;
		try {
			cartOrders = cartDAO.getCartOrders();
	        String responseData = cartOrders.toString();

	         // 设置响应的内容类型
	         response.setContentType("application/json");
	         // 设置响应状态码
	         response.setStatus(HttpServletResponse.SC_OK);
	         // 将 JSON 数据写入响应流
	         response.getWriter().write(responseData);
	         System.out.println(responseData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().write("Tryed to read data in Cart-orders but failed!!");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		String pathInfo = request.getPathInfo();
		
        if (pathInfo != null) {
            // Remove leading "/" and split the path by "/"
            String[] pathParts = pathInfo.substring(1).split("/");

            if (pathParts.length == 2 && pathParts[1].equals("add")) {
                String id = pathParts[0];

                // Now you have the 'id' and 'increment' values
                System.out.println("ID: " + id);
                
                try {
                    int index = Integer.parseInt(id);
                    cartDAO.addOrderToCart(index);    
                    response.setStatus(HttpServletResponse.SC_OK);
                    System.out.printf("doPost cart adding %s", id);
                } catch (Exception e) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid id format");
                }              

                // Use the values as needed, for example, pass them to a service, etc.
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid path format");
            }
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Path not specified");
        }
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, PATCH, DELETE");
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		String pathInfo = request.getPathInfo();
		
        if (pathInfo != null) {
            // Remove leading "/" and split the path by "/"
            String[] pathParts = pathInfo.substring(1).split("/");

            if (pathParts.length == 2) {
                String id = pathParts[0];
                String state = pathParts[1];

                // Now you have the 'id' and 'increment' values
                System.out.println("ID: " + id);
                System.out.println("Increment: " + state);
                
                try {
                    int index = Integer.parseInt(id);
                    if (state.equals("increment")) {
						cartDAO.increaseOrderQuantity(index);
					}else if (state.equals("decrement")) {
						cartDAO.decreaseOrderQuantity(index);
					}
                    
                    response.setStatus(HttpServletResponse.SC_OK);
                    System.out.printf("doPut %s, %s","doPut", state);
                } catch (Exception e) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid id format");
                    System.out.println("doPut is failed!!!");
                    System.out.println(state);
                }              

                // Use the values as needed, for example, pass them to a service, etc.
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid path format");
            }
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Path not specified");
        }
    }
	
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Your implementation for handling DELETE requests
    	System.out.println("----------doDelete-------------");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        response.setHeader("Access-Control-Allow-Credentials", "true");
		String pathInfo = request.getPathInfo();
		
        if (pathInfo != null) {
            // Remove leading "/" and split the path by "/"
            String[] pathParts = pathInfo.substring(1).split("/");

            if (pathParts.length == 2 && pathParts[1].equals("remove")) {
                String id = pathParts[0];
                // Now you have the 'id' and 'increment' values
                
                try {
                    int index = Integer.parseInt(id);
                    cartDAO.removeOrderFromCart(index);  
                    response.setStatus(HttpServletResponse.SC_OK);
                    System.out.printf("doDelet remove %s", id);
                } catch (Exception e) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid id format");
                }              

                // Use the values as needed, for example, pass them to a service, etc.
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid path format");
            }
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Path not specified");
        }

    }
    
    protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set CORS header information
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        // End preflight request
        response.setStatus(HttpServletResponse.SC_OK);
        System.out.println("-----------doOptions----------------");
    }

}
