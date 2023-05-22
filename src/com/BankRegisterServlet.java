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


@WebServlet("/BankRegisterServlet")
public class BankRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BankRegisterServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name"); 
		String contact=request.getParameter("contact");
		String email=request.getParameter("email"); 
		String password=request.getParameter("password");
		String area=request.getParameter("area"); 
		String pincode=request.getParameter("pincode"); 
		String address=request.getParameter("address"); 
		PrintWriter out=response.getWriter();
		RequestDispatcher dispatcher=null;
		try{
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/blood_finder?useSLL=false","root","");
			String query = "insert into blood_bank(bank_name,phone,email_id,location,address,pin,password) values(?,?,?,?,?,?,?)";
		 PreparedStatement pst=con.prepareStatement(query);
		 pst.setString(1,name);
		 pst.setString(2,contact);
		 pst.setString(3,email);
		 pst.setString(4,area);
		 pst.setString(5,address);
		 pst.setString(6,pincode);
		 pst.setString(7,password);
		 int result = pst.executeUpdate();
		 dispatcher =request.getRequestDispatcher("BankRegistration.jsp");
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
