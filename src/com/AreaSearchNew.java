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

import com.connection.SingletonConnection;

@WebServlet("/AreaSearchNew")
public class AreaSearchNew extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AreaSearchNew() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Connection conn;
		PreparedStatement psmt;
		ResultSet rs;
		System.out.print(10);
		try{
			
			String driver="com.mysql.jdbc.Driver";
			Class.forName(driver);
			conn = SingletonConnection.getSingletonConnection("blood_finder");
			
			String keyword=request.getParameter("keyword");
			String query = "select * from blood_bank where location=? or pin=?";
			psmt=conn.prepareStatement(query);
			psmt.setString(1,keyword);
			psmt.setString(2,keyword);
			
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("UserViewTable.jsp");
			rs=psmt.executeQuery();
			ArrayList<String> obj=new ArrayList<String>();
			ArrayList<String> obj2=new ArrayList<String>();
			System.out.print(10);
			while(rs.next()){
				obj.add(rs.getString("bank_name"));
				obj2.add(String.valueOf(rs.getInt("bank_id")));
			}
			request.setAttribute("data", obj);
			request.setAttribute("data2", obj2);
			requestDispatcher.forward(request, response);
			conn.close();
		}
		catch(Exception e){
			out.print(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Connection conn;
		PreparedStatement psmt;
		ResultSet rs;
		System.out.print(10);
		try{
			
			String driver="com.mysql.jdbc.Driver";
			Class.forName(driver);
			conn = SingletonConnection.getSingletonConnection("blood_finder");
			
			String keyword=request.getParameter("keyword");
			String query = "select * from blood_bank where location=? or pin=?";
			psmt=conn.prepareStatement(query);
			psmt.setString(1,keyword);
			psmt.setString(2,keyword);
			
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("UserViewTable.jsp");
			rs=psmt.executeQuery();
			ArrayList<String> obj=new ArrayList<String>();
			ArrayList<String> obj2=new ArrayList<String>();
			System.out.print(10);
			while(rs.next()){
				obj.add(rs.getString("bank_name"));
				obj2.add(String.valueOf(rs.getInt("bank_id")));
			}
			request.setAttribute("data", obj);
			request.setAttribute("data2", obj2);
			requestDispatcher.forward(request, response);
			conn.close();
		}
		catch(Exception e){
			out.print(e);
		}
	}

}
