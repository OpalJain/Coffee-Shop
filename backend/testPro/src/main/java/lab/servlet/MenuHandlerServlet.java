package lab.servlet;

import java.io.IOException;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import DAO.*;

/**
 * Servlet implementation class MenuHandlerServlet
 */
@WebServlet("/menu")
public class MenuHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MenuHandlerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	       Gson gson = new Gson();

	        MenuItem menuItem1 = new MenuItem(1, "Coffee Item", "This is a delicious cup of coffee.", "coffee-cup.svg", 10);
	        MenuItem menuItem2 = new MenuItem(2, "Coffee Item", "This is a delicious cup of coffee.", "coffee-cup.svg", 20);
	        MenuItem menuItem3 = new MenuItem(3, "Coffee Item", "This is a delicious cup of coffee.", "coffee-cup.svg", 30);
	        MenuItem menuItem4 = new MenuItem(4, "Coffee Item", "This is a delicious cup of coffee.", "coffee-cup.svg", 40);
	        MenuItem menuItem5 = new MenuItem(5, "Coffee Item", "This is a delicious cup of coffee.", "coffee-cup.svg", 50);
	        MenuItem menuItem6 = new MenuItem(6, "Coffee Item", "This is a delicious cup of coffee.", "coffee-cup.svg", 60);

	        MenuObjs menu = new MenuObjs(Arrays.asList(menuItem1, menuItem2, menuItem3, menuItem4, menuItem5, menuItem6));
	        
	        String testString = menuItem1.tryJson();

	        String json = gson.toJson(menu);
	        // Set response content type
	        response.setContentType("application/json");

	        // Set response status code
	        response.setStatus(HttpServletResponse.SC_OK);

	        // Write the JSON string to the response output stream
	        response.getWriter().write(json);
	        System.out.println(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
