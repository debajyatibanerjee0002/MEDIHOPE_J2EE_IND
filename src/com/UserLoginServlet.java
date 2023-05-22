package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.sql.RowSet;

import com.mysql.cj.protocol.Resultset;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserLoginServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		PrintWriter out=response.getWriter();
		RequestDispatcher dispatcher=null;
		HttpSession session=request.getSession();
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/blood_finder","root","");
			String query = "select * from user_table where user_name = ? and password = ?";
			 PreparedStatement pst=con.prepareStatement(query);
			 pst.setString(1,name);
			 pst.setString(2,password);
			 ResultSet rs =pst.executeQuery();
			if(rs.next()){
				session.setAttribute("name", rs.getString("user_name"));
				 dispatcher = request.getRequestDispatcher("home.jsp");
			}
			else{
				request.setAttribute("status","failed");
				dispatcher=request.getRequestDispatcher("UserLogin.jsp");
				
			}
			dispatcher.forward(request, response);
			//con.close();
		}
		catch(Exception e){
			out.print(e);
		}
	}

}
