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
			conn = SingletonConnection.getSingletonConnection("medi_hope");
			
			String email = request.getParameter("email");
//			System.out.println(email);
			
			String hname = request.getParameter("hname");
			String phno = request.getParameter("phno");
			String pname = request.getParameter("pname");
			String age = request.getParameter("age");
			
			String name,ph_no,zip;
			int beds;
			
			
			String queryOne = "SELECT * FROM medihope_reg_hos WHERE NAME=?";
			psmt = conn.prepareStatement(queryOne);
			psmt.setString(1, hname);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				name = rs.getString("NAME");
				ph_no = rs.getString("PH_NO");
				beds = rs.getInt("BEDS")-1;
				zip = rs.getString("ZIP");
				
				String queryThree = "UPDATE medihope_reg_hos SET BEDS=? WHERE NAME=?";
				psmt = conn.prepareStatement(queryThree);
				psmt.setInt(1, beds);
				psmt.setString(2, name);
				
				psmt.executeUpdate();
				
				String queryTwo = "INSERT INTO medihope_cart VALUES(?,?,?,?)";
				psmt = conn.prepareStatement(queryTwo);
				psmt.setString(1, name);
				psmt.setString(2, ph_no);
				psmt.setString(3, zip);
				psmt.setString(4, email);
				
				psmt.executeUpdate();
			}
			
			
			String query = "INSERT INTO medihope_book_hos VALUES(?,?,?,?)";
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
