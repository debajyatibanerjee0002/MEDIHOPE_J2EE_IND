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

@WebServlet("/BankLoginServlet")
public class BankLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BankLoginServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		PrintWriter out=response.getWriter();
		RequestDispatcher dispatcher=null;
		HttpSession session=request.getSession();
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/blood_finder","root","");
			String query = "select * from blood_bank where email_id = ? and password = ?";
			 PreparedStatement pst=con.prepareStatement(query);
			 pst.setString(1,email);
			 pst.setString(2,password);
			 ResultSet rs =pst.executeQuery();
			if(rs.next()){
				String bank_id=rs.getString("bank_id");
				String bankname=rs.getString("bank_name");
				request.setAttribute("bank_id", bank_id);
				request.setAttribute("bank_name", bankname);
				 dispatcher = request.getRequestDispatcher("dashboard.jsp");
			}
			else{
				request.setAttribute("status","failed");
				dispatcher=request.getRequestDispatcher("BankLogin.jsp");
				
			}
			dispatcher.forward(request, response);
			//con.close();
		}
		catch(Exception e){
			out.print(e);
		}
	}

}
