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

@WebServlet("/PincodeSearch")
public class PincodeSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public PincodeSearch() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Connection con;
		PreparedStatement psmt;
		ResultSet rs;
		
		try
		{
			String driver="com.mysql.jdbc.Driver";
			Class.forName(driver);
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/blood_finder?useSLL=false","root","");
			
			String pincode=request.getParameter("pincode");
			String query = "select * from blood_bank where pin=?";
			psmt=con.prepareStatement(query);
			psmt.setString(1,pincode);
			
			rs=psmt.executeQuery();
//			RequestDispatcher requestDispatcher = request.getRequestDispatcher("debug1.jsp");
//			requestDispatcher.forward(request, response);
			
			out.print("<html>"
					+ "<head><title></title></head>"
					+ "<body>"
					+ "<table border='1' width='800' align='center'>"
					+ "<tr>"
					+ "<th>BANK NAME</th>"
					+ "</tr>"
					);
			while(rs.next())
			{
				out.print("<tr>"
						+ "<td>"+rs.getString("bank_name")+"</td>"
						+ "<td>"
						+ "<a href='/Todo_List/#/"+rs.getString("bank_id")+"' style='margin-right:20px'>"
								+ "DETAILS</a>"
						+ "</td>"
						+ "</tr>");
			}
			out.print("</table>"
					+ "</body>"
					+ "</html>");
			
			
			con.close();
			
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

}
