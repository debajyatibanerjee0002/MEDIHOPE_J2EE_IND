package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateBankView")
public class UpdateBankView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateBankView() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Connection con;
		PreparedStatement psmt;
		int rs;
		
		try
		{
			String driver="com.mysql.jdbc.Driver";
			Class.forName(driver);
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/blood_finder?useSLL=false","root","");
			
			String new_data=request.getParameter("new");
			String bank_id=request.getParameter("bank_id");
			String table_name=request.getParameter("table_name");
			String attribute_name=request.getParameter("attribute_name");
			
			System.out.println(new_data+"  "+bank_id+"  "+table_name+"  "+attribute_name);
			
			
			String[] a={"apos","bpos","opos","abpos","aneg","bneg","oneg","abneg"};
			for(int i=0;i<8;i++)
			{
				if(attribute_name.equals(String.valueOf(i)))
				{
					attribute_name=a[i];
				}
			}
			if(table_name.equals("blood_bank"))
			{
				String query="update blood_bank set"+attribute_name+"='?' where bank_id=?";
				psmt=con.prepareStatement(query);
//				psmt.setString(1, attribute_name);
				psmt.setString(0, new_data);
				psmt.setInt(1, Integer.parseInt(bank_id));
			}
			else
			{
				String query="update blood_details set"+attribute_name+"='?' where bank_id='?'";
				psmt=con.prepareStatement(query);
//				psmt.setString(1, attribute_name);
				psmt.setString(0, new_data);
				psmt.setString(1, bank_id);
			}
			rs=psmt.executeUpdate();
			RequestDispatcher dispatcher =request.getRequestDispatcher("BankView.jsp");
			 if(rs>0){
				 request.setAttribute("status","success");
			 }
			 else{
				 request.setAttribute("status","failed"); 
			 }
			 dispatcher.forward(request, response);
			 con.close();
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Connection con;
		PreparedStatement psmt;
		int rs;
		
		try
		{
			String driver="com.mysql.jdbc.Driver";
			Class.forName(driver);
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/blood_finder?useSLL=false","root","");
			
			String new_data=request.getParameter("new");
			String bank_id=request.getParameter("bank_id");
			String table_name=request.getParameter("table_name");
			String attribute_name=request.getParameter("attribute_name");
			
			System.out.println(new_data+"  "+bank_id+"  "+table_name+"  "+attribute_name);
			
			
			String[] a={"apos","bpos","opos","abpos","aneg","bneg","oneg","abneg"};
			for(int i=0;i<8;i++)
			{
				if(attribute_name.equals(String.valueOf(i)))
				{
					attribute_name=a[i];
				}
			}
			if(table_name.equals("blood_bank"))
			{
				String query="update blood_bank set"+attribute_name+"='?' where bank_id=?";
				psmt=con.prepareStatement(query);
//				psmt.setString(1, attribute_name);
				psmt.setString(0, new_data);
				psmt.setInt(1, Integer.parseInt(bank_id));
			}
			else
			{
				String query="update blood_details set"+attribute_name+"='?' where bank_id='?'";
				psmt=con.prepareStatement(query);
//				psmt.setString(1, attribute_name);
				psmt.setString(0, new_data);
				psmt.setString(1, bank_id);
			}
			rs=psmt.executeUpdate();
			RequestDispatcher dispatcher =request.getRequestDispatcher("BankView.jsp");
			 if(rs>0){
				 request.setAttribute("status","success");
			 }
			 else{
				 request.setAttribute("status","failed"); 
			 }
			 dispatcher.forward(request, response);
			 con.close();
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}