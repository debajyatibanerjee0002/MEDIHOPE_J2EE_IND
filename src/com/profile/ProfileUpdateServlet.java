package com.profile;

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


@WebServlet("/ProfileUpdateServlet")
public class ProfileUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ProfileUpdateServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		PreparedStatement psmt;
		
		try
		{
			Connection conn = SingletonConnection.getSingletonConnection();
			String email = request.getParameter("email");
			String name = request.getParameter("name");
			String password = request.getParameter("password"); //MN==
			String oldPass = null;
			
			
			
//			PasswordEncodingDecoding passDecoded = new PasswordEncodingDecoding();
//			passDe = passDecoded.decoding(password);  // 12
//			
//			String querySearch = "SELECT * FROM MEDIHOPE_USER WHERE EMAIL=?";
//			psmt = conn.prepareStatement(querySearch);
//			psmt.setString(1, email);
//			
//			ResultSet rs = psmt.executeQuery();
//			while(rs.next())
//			{
//				oldPass = rs.getString("PASSWORD");  //MN==  ||  NM==
//				PasswordEncodingDecoding oldPassDecoded = new PasswordEncodingDecoding();
//				newPass = oldPassDecoded.decoding(oldPass);  //12  || 21
//			}
			
//			if(password.length()<=4) //12 != 21 (1) 
//			{
//				PasswordEncodingDecoding passEncoded = new PasswordEncodingDecoding();
//				oldPass = passEncoded.encoding(password);
//			}
//			else
//			{
//				oldPass = password;
//			}
				
			
			
			String query = "UPDATE MEDIHOPE_USER SET NAME=? WHERE EMAIL=?";
			psmt = conn.prepareStatement(query);
			
			psmt.setString(1, name);
//			psmt.setString(2, oldPass);
			psmt.setString(2, email);
			
			int rn = psmt.executeUpdate();
			if(rn>0)
			{
				HttpSession session = request.getSession();
				session.setAttribute("name", name);
				response.sendRedirect("PAGES/home.jsp");
				RequestDispatcher dispatcher = request.getRequestDispatcher("PAGES/home.jsp");
		        dispatcher.forward(request, response);
			}
			
			conn.close();
			
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
