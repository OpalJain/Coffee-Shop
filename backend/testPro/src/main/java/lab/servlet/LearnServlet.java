package lab.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DAO.*;

/**
 * Servlet implementation class LearnServlet
 */
@WebServlet("/LearnServlet")
public class LearnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LearnServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String json = "  \"cart-orders\": [\n"
        		+ "    {\n"
        		+ "      \"id\": 6,\n"
        		+ "      \"quantity\": 1\n"
        		+ "    },\n"
        		+ "    {\n"
        		+ "      \"id\": 2,\n"
        		+ "      \"quantity\": 1\n"
        		+ "    }";
        // Set response content type
        response.setContentType("application/json");

        // Set response status code
        response.setStatus(HttpServletResponse.SC_OK);

        // Write the JSON string to the response output stream
        response.getWriter().write(json);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
