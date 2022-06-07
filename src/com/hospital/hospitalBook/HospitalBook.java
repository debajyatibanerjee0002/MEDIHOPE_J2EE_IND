package com.hospital.hospitalBook;

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


@WebServlet("/HospitalBook")
public class HospitalBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HospitalBook() {
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
			
			String hname = request.getParameter("hname");
			String phno = request.getParameter("phno");
			String pname = request.getParameter("pname");
			String age = request.getParameter("age");
			
			String name,ph_no,zip;
			
			String queryOne = "SELECT * FROM MEDIHOPE_REG_HOS WHERE NAME=?";
			psmt = conn.prepareStatement(queryOne);
			psmt.setString(1, hname);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				name = rs.getString("NAME");
				ph_no = rs.getString("PH_NO");
				zip = rs.getString("ZIP");
				
				String queryTwo = "INSERT INTO MEDIHOPE_CART VALUES(?,?,?)";
				psmt = conn.prepareStatement(queryTwo);
				psmt.setString(1, name);
				psmt.setString(2, ph_no);
				psmt.setString(3, zip);
				
				psmt.executeUpdate();
			}
			
			String query = "INSERT INTO MEDIHOPE_BOOK_HOS VALUES(?,?,?,?)";
			psmt = conn.prepareStatement(query);
			psmt.setString(1, phno);
			psmt.setString(2, pname);
			psmt.setString(3, age);
			psmt.setString(4, hname);
			
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
