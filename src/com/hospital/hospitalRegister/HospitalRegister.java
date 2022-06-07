package com.hospital.hospitalRegister;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.SingletonConnection;
import com.passwordEncodingDecoding.PasswordEncodingDecoding;


@WebServlet("/HospitalRegister")
public class HospitalRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public HospitalRegister() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		PreparedStatement psmt;
		
		try
		{
			Connection conn = SingletonConnection.getSingletonConnection();
			String hName = request.getParameter("hName");
			String phno = request.getParameter("phno");
			String place = request.getParameter("place");
			String zip = request.getParameter("zip");
			
			String query = "INSERT INTO MEDIHOPE_REG_HOS VALUES(?,?,?,?)";
			psmt = conn.prepareStatement(query);
			
			psmt.setString(1, hName);
			psmt.setString(2, phno);
			psmt.setString(3, place);
			psmt.setString(4, zip);
			
			int rn = psmt.executeUpdate();
			
			if(rn>0)
			{
				response.sendRedirect("PAGES/home.jsp");
			}
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
