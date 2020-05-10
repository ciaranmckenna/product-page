package com.ciaranmckenna.servlets.prepardedstatement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateProductServlet
 */
@WebServlet("/ProductServlet")
public class CreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private PreparedStatement prepareStatement;
       
    public void init(ServletConfig config) {
    	System.out.println("reached");
    	try {
    		ServletContext context = config.getServletContext();
    		Class.forName("com.mysql.jdbc.Driver");
    		connection = DriverManager.getConnection(context.getInitParameter("dbUrl"),
    				context.getInitParameter("dbUser"), context.getInitParameter("dbPassword"));
    		prepareStatement = connection.prepareStatement("insert into product values(?,?,?,?)");
    		System.out.println("test i got here");
    	}catch (ClassNotFoundException e) {
    		e.printStackTrace();
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			int price = Integer.parseInt(request.getParameter("price"));
	
			try {
				prepareStatement.setInt(1, id);
				prepareStatement.setString(2, name);
				prepareStatement.setString(3, description);
				prepareStatement.setInt(4, price);
				
				int result = prepareStatement.executeUpdate();
				
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("<b>" + result + " Products Created</b>");
			} catch (SQLException e) {
				e.printStackTrace();
			}	
	}
	
	public void destroy() {
		try {
			prepareStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
