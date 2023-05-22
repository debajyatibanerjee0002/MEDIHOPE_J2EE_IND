package com.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.SingletonConnection;


//@WebServlet("/CartDeleteServlet")
public class CartDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CartDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Connection conn;
		PreparedStatement psmt;
		
		try
		{
			conn = SingletonConnection.getSingletonConnection("medi_hope");
			
			String uri = request.getRequestURI();
			String[] arrOfStr = uri.split("/");
			String val = arrOfStr[arrOfStr.length-1];
			String adminOrUser = arrOfStr[arrOfStr.length-2];
			
			String queryOne = "DELETE FROM medihope_book_hos WHERE H_NAME=?";
			psmt = conn.prepareStatement(queryOne);
			psmt.setString(1, val);
			psmt.executeUpdate();
			
			String queryTwo = "DELETE FROM medihope_book_amb WHERE VL_NO=?";
			psmt = conn.prepareStatement(queryTwo);
			psmt.setString(1, val);
			psmt.executeUpdate();
			
			int beds;
			String queryThree = "SELECT * FROM medihope_reg_hos WHERE NAME=?";
			psmt = conn.prepareStatement(queryThree);
			psmt.setString(1, val);
			ResultSet rs = psmt.executeQuery();
			if(rs.next())
			{
				beds=rs.getInt("BEDS")+1;
				String q = "UPDATE medihope_reg_hos SET BEDS=? WHERE NAME=?";
				psmt = conn.prepareStatement(q);
				psmt.setInt(1, beds);
				psmt.setString(2, val);
				
				psmt.executeUpdate();
			}

			int available;
			String queryFour = "SELECT * FROM medihope_reg_amb WHERE VL_NO=?";
			psmt = conn.prepareStatement(queryFour);
			psmt.setString(1, val);
			rs = psmt.executeQuery();
			if(rs.next())
			{
				available=rs.getInt("AVAILABLE")+1;
				String q = "UPDATE medihope_reg_amb SET AVAILABLE=? WHERE VL_NO=?";
				psmt = conn.prepareStatement(q);
				psmt.setInt(1, available);
				psmt.setString(2, val);
				
				psmt.executeUpdate();
			}
			
			
			
			String query = "DELETE FROM medihope_cart WHERE NAME=?";
			psmt = conn.prepareStatement(query);
			psmt.setString(1, val);
			
			int rn = psmt.executeUpdate();
			if(rn>0)
			{
				if(adminOrUser.equals("admin")) {
					response.sendRedirect("../../PAGES/ADMIN/booking-display-admin.jsp");
				}else {
					response.sendRedirect("../../PAGES/home.jsp");
				}
//				request.getRequestDispatcher("PAGES/BOOKING/booking-display.jsp").forward(request, response);
			}
			
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
