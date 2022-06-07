package com.signup;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.SingletonConnection;
import com.passwordEncodingDecoding.PasswordEncodingDecoding;


@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SignupServlet() {
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
			String password = request.getParameter("password");
			PasswordEncodingDecoding passEncoded = new PasswordEncodingDecoding();
			String pass = passEncoded.encoding(password);
			
			String query = "INSERT INTO MEDIHOPE_USER VALUES(?,?,?)";
			psmt = conn.prepareStatement(query);
			
			psmt.setString(1, email);
			psmt.setString(2, name);
			psmt.setString(3, pass);
			
			int rn=psmt.executeUpdate();
			
			if(rn>0)
			{
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				session.setAttribute("name", name);
				session.setAttribute("pass", pass);
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
