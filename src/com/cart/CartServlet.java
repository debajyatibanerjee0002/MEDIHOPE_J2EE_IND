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
import javax.servlet.http.HttpSession;

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
		
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		
		PreparedStatement psmt;
		ArrayList<CartClass> cartClass = new ArrayList<CartClass>();
		try
		{
			Connection conn = SingletonConnection.getSingletonConnection("medi_hope");
			
			String query = "SELECT * FROM medihope_cart WHERE EMAIL=?";
			psmt = conn.prepareStatement(query);
			psmt.setString(1, email);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				out.println(rs.getString("NAME")+" "+rs.getString("PH_NO")+" "+rs.getString("ZIP"));
				CartClass obj = new CartClass();
				obj.setName(rs.getString("NAME"));
				obj.setPhno(rs.getString("PH_NO"));
				obj.setZip(rs.getString("ZIP"));
				obj.setEmail(rs.getString("EMAIL"));
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
