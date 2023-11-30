package com.shop.server;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.gson.Gson;
import com.shop.items.MenuDAO;
import com.shop.items.MenuItem;
import com.shop.items.MenuObjs;

/**
 * Servlet implementation class MenuMangeServlet
 */
@WebServlet(urlPatterns = {"/menu/*"})
public class MenuMangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MenuDAO menuDAO = new MenuDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuMangeServlet() {
        // TODO Auto-generated constructor stub
    }
    public String getJSONFromReque(HttpServletRequest request) {
        String reString = "";
    	// Read the requested input stream
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
            StringBuilder requestBody = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                requestBody.append(line);
            }

            // requestBody.toString() Contains JSON data sent from the client
            reString = requestBody.toString();
            System.out.println("Received JSON data: " + reString);
        } catch (IOException e) {
            e.printStackTrace();
        }
		return reString;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getJSONFromReque(request);
        String pathInfo = request.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            try {
				MenuObjs menuObjs = menuDAO.GetMenuData();
				String responseData = menuObjs.toString();
		         // Set the content type of the response
		         response.setContentType("application/json");
		         // Set response status code
		         response.setStatus(HttpServletResponse.SC_OK);
		         // Write JSON data to the response stream
		         response.getWriter().write(responseData);
		         response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
		         response.setHeader("Access-Control-Allow-Credentials", "true");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
            
        } else {
            // Extract path parameters for "/menu/{id}"
            String[] pathParts = pathInfo.split("/");
            if (pathParts.length >= 2) {
				try {
	                String id = pathParts[1];
	                int index = Integer.parseInt(id);
					MenuItem menuItem = menuDAO.GetMenuProductById(index);
					Gson gson = new Gson();
					String responseData = gson.toJson(menuItem);
			         // Set the content type of the response
			         response.setContentType("application/json");
			         // Set response status code
			         response.setStatus(HttpServletResponse.SC_OK);
			         // Write JSON data to the response stream
			         response.getWriter().write(responseData);
			         response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
			         response.setHeader("Access-Control-Allow-Credentials", "true");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid path format");
            }
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String jsonString = getJSONFromReque(request);
		try {
			Gson gson = new Gson();
			MenuItem menuItem = gson.fromJson(jsonString, MenuItem.class);
			MenuDAO menuDAO = new MenuDAO();
		
			menuDAO.addOrderToMenu(menuItem);
	         // Set the content type of the response
	         response.setContentType("application/json");
	         // Set response status code
	         response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

}
