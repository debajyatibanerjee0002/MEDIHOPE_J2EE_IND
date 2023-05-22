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

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DashboardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try{
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/blood_finder?useSLL=false","root","");
		 	String bank_id=request.getParameter("bank_id");
		 	System.out.println("This is bank ID "+bank_id);
			String apos=request.getParameter("a+");
			String bpos=request.getParameter("b+"); 
			String opos=request.getParameter("o+");
			String abpos=request.getParameter("ab+"); 
			String aneg=request.getParameter("a-");
			String bneg=request.getParameter("b-"); 
			String oneg=request.getParameter("o-");
			String abneg=request.getParameter("ab-");  
			RequestDispatcher dispatcher=null;
			
			String query = "insert into blood_details(bank_id,APOS,BPOS,OPOS,ABPOS,ANEG,BNEG,ONEG,ABNEG) values(?,?,?,?,?,?,?,?,?)";
		 PreparedStatement pst=con.prepareStatement(query);
		 pst.setString(1,bank_id);
		 pst.setString(2,apos);
		 pst.setString(3,bpos);
		 pst.setString(4,opos);
		 pst.setString(5,abpos);
		 pst.setString(6,aneg);
		 pst.setString(7,bneg);
		 pst.setString(8,oneg);
		 pst.setString(9,abneg);
		 int result = pst.executeUpdate();
		 dispatcher =request.getRequestDispatcher("dashboard.jsp");
		 if(result>0){
			 request.setAttribute("status","success");
		 }
		 else{
			 request.setAttribute("status","failed"); 
		 }
		 dispatcher.forward(request, response);
		 con.close();
		}
		catch(Exception e){
			out.print(e);
		}

	}

}
