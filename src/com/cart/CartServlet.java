package com.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.SingletonConnection;


@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		PreparedStatement psmt;
		ArrayList<CartClass> cartClass = new ArrayList<CartClass>();
		try
		{
			Connection conn = SingletonConnection.getSingletonConnection();
			
			String query = "SELECT * FROM MEDIHOPE_CART";
			psmt = conn.prepareStatement(query);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				out.println(rs.getString("NAME")+" "+rs.getString("PH_NO")+" "+rs.getString("ZIP"));
				CartClass obj = new CartClass();
				obj.setName(rs.getString("NAME"));
				obj.setPhno(rs.getString("PH_NO"));
				obj.setZip(rs.getString("ZIP"));
				cartClass.add(obj);
			}
			request.setAttribute("cartData", cartClass);
			request.getRequestDispatcher("PAGES/BOOKING/booking-display.jsp").forward(request, response);
			conn.close();
		}
		catch(Exception e)
		{
			out.print(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
