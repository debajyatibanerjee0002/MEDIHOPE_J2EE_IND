package com.ambulance.ambulanceBook;

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


//@WebServlet("/AmbulanceBook")
public class AmbulanceBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AmbulanceBook() {
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
			
			String vlno = request.getParameter("vlno");
			String phno = request.getParameter("phno");
			String splace = request.getParameter("splace");
			String dplace = request.getParameter("dplace");
			
			String vl_no,ph_no,zip;
			
			String queryOne = "SELECT * FROM MEDIHOPE_REG_AMB WHERE VL_NO=?";
			psmt = conn.prepareStatement(queryOne);
			psmt.setString(1, vlno);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				vl_no = rs.getString("VL_NO");
				ph_no = rs.getString("PH_NO");
				zip = rs.getString("ZIP");
				
				String queryTwo = "INSERT INTO MEDIHOPE_CART VALUES(?,?,?)";
				psmt = conn.prepareStatement(queryTwo);
				psmt.setString(1, vl_no);
				psmt.setString(2, ph_no);
				psmt.setString(3, zip);
				
				psmt.executeUpdate();
			}
			
			
			
			String query = "INSERT INTO MEDIHOPE_BOOK_AMB VALUES(?,?,?,?)";
			psmt = conn.prepareStatement(query);
			psmt.setString(1, phno);
			psmt.setString(2, splace);
			psmt.setString(3, dplace);
			psmt.setString(4, vlno);
			
			int rn = psmt.executeUpdate();
			if(rn>0)
			{
				response.sendRedirect("PAGES/home.jsp");
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
