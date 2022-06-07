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
			conn = SingletonConnection.getSingletonConnection();
			
			String uri = request.getRequestURI();
			String[] arrOfStr = uri.split("/");
			String val = arrOfStr[arrOfStr.length-1];
			
			String queryOne = "DELETE FROM MEDIHOPE_BOOK_HOS WHERE H_NAME=?";
			psmt = conn.prepareStatement(queryOne);
			psmt.setString(1, val);
			psmt.executeUpdate();
			
			String queryTwo = "DELETE FROM MEDIHOPE_BOOK_AMB WHERE VL_NO=?";
			psmt = conn.prepareStatement(queryTwo);
			psmt.setString(1, val);
			psmt.executeUpdate();
			
			String query = "DELETE FROM MEDIHOPE_CART WHERE NAME=?";
			psmt = conn.prepareStatement(query);
			psmt.setString(1, val);
			
			int rn = psmt.executeUpdate();
			if(rn>0)
			{
				response.sendRedirect("../PAGES/home.jsp");
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
