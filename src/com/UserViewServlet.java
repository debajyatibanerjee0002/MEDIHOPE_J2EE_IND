package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserViewServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Connection con;
		PreparedStatement psmt1,psmt2;
		ResultSet rs1,rs2;
		
		try
		{
			String driver="com.mysql.jdbc.Driver";
			Class.forName(driver);
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/blood_finder?useSLL=false","root","");
			
			 String bank_id=request.getParameter("val");
				
			String query1 = "select * from blood_bank where bank_id=?";
			psmt1=con.prepareStatement(query1);
			psmt1.setInt(1,Integer.parseInt(bank_id));
			rs1=psmt1.executeQuery();
			
			String query2 = "select * from blood_details where bank_id=?";
			psmt2=con.prepareStatement(query2);
			psmt2.setString(1,bank_id);
			rs2=psmt2.executeQuery();
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("UserView.jsp");
			
			ArrayList<String> obj1=new ArrayList<String>();
			while(rs1.next()){
				obj1.add(rs1.getString("bank_name"));
				obj1.add(rs1.getString("phone"));
				obj1.add(rs1.getString("email_id"));
				obj1.add(rs1.getString("location"));
				obj1.add(rs1.getString("pin"));
			} 
			request.setAttribute("bank_data", obj1);
	        
	        ArrayList<String> obj2=new ArrayList<String>();
			while(rs2.next()){
				obj2.add(rs2.getString("apos"));
				obj2.add(rs2.getString("bpos"));
				obj2.add(rs2.getString("opos"));
				obj2.add(rs2.getString("abpos"));
				obj2.add(rs2.getString("aneg"));
				obj2.add(rs2.getString("bneg"));
				obj2.add(rs2.getString("oneg"));
				obj2.add(rs2.getString("abneg"));
			}
	        request.setAttribute("blood_data", obj2);
			
			requestDispatcher.forward(request, response);
			con.close();
			
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
