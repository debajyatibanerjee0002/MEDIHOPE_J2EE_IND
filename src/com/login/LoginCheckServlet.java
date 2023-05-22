package com.login;

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


@WebServlet("/LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginCheckServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		PreparedStatement psmt;
		
		try
		{
			Connection conn = SingletonConnection.getSingletonConnection("medi_hope");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			PasswordEncodingDecoding passEncoded = new PasswordEncodingDecoding();
			String pass = passEncoded.encoding(password);
			String query="";
			
			if(email.equals("admin@gmail.com")) {
				query = "SELECT * FROM medihope_admin WHERE ADMIN_ID=?";
				psmt = conn.prepareStatement(query);
				
				psmt.setString(1, email);
				
				ResultSet rs = psmt.executeQuery();
				if(rs.next())
				{					
//					log("email :"+email+" == "+"emailDB :"+emailDB);
					String emailDB = rs.getString("ADMIN_ID");
					String passDB = rs.getString("ADMIN_PASS");
					
//					System.out.println(emailDB + " " + passDB);
					
					if(pass.equals(passDB) && emailDB.equals(email))
					{
						HttpSession session = request.getSession();
						session.setAttribute("email", email);
						response.sendRedirect("PAGES/ADMIN/booking-display-admin.jsp");
						RequestDispatcher dispatcher = request.getRequestDispatcher("PAGES/home.jsp");
				        dispatcher.forward(request, response);
					}
					else
					{
						response.sendRedirect("PAGES/login_error.jsp");
					}
					
				}
				
				
			}
			else {
				query = "SELECT * FROM medihope_user WHERE EMAIL=?";
				psmt = conn.prepareStatement(query);
				
				psmt.setString(1, email);
				
				ResultSet rs = psmt.executeQuery();
				if(rs.next())
				{
					String emailDB = rs.getString("EMAIL");
					String name = rs.getString("NAME");
					String passDB = rs.getString("PASSWORD");
					
//					System.out.println(emailDB + " " + passDB);
										
					if(pass.equals(passDB) && emailDB.equals(email))
					{
						HttpSession session = request.getSession();
						session.setAttribute("name", name);
						session.setAttribute("email", email);
						session.setAttribute("pass", pass);
						response.sendRedirect("PAGES/home.jsp");
						RequestDispatcher dispatcher = request.getRequestDispatcher("PAGES/home.jsp");
				        dispatcher.forward(request, response);
					}
					else
					{
						response.sendRedirect("PAGES/login_error.jsp");
					}
					
				}
			}
			
			
//			psmt = conn.prepareStatement(query);
//			
//			psmt.setString(1, email);
//			psmt.setString(2, password);
//			
//			ResultSet rs = psmt.executeQuery();
//			while(rs.next())
//			{
//				String emailDB = rs.getString("EMAIL");
//				String name = rs.getString("NAME");
//				String passDB = rs.getString("PASSWORD");
//				
////				log("email :"+email+" == "+"emailDB :"+emailDB);
//				
//				if(pass.equals(passDB) && emailDB.equals(email))
//				{
//					HttpSession session = request.getSession();
//					session.setAttribute("name", name);
//					session.setAttribute("email", email);
//					session.setAttribute("pass", pass);
//					response.sendRedirect("PAGES/home.jsp");
//					RequestDispatcher dispatcher = request.getRequestDispatcher("PAGES/home.jsp");
//			        dispatcher.forward(request, response);
//				}
//				else
//				{
//					response.sendRedirect("PAGES/login_error.jsp");
//				}
//				
//			}
//			response.sendRedirect("PAGES/login_error.jsp");
			
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
