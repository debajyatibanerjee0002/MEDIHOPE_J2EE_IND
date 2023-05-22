package com.hospital.hospitalSearch;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.SingletonConnection;
import com.hospital.hospitalClass.HospitalClass;


@WebServlet("/HospitalSearch")
public class HospitalSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public HospitalSearch() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
//		System.out.println(email);
		
		PreparedStatement psmt;
		ArrayList<HospitalClass> hospitalClass = new ArrayList<HospitalClass>();
		try
		{
			Connection conn = SingletonConnection.getSingletonConnection("medi_hope");
			String searchVal = "";
			searchVal=request.getParameter("searchVal");
			
			String query = "SELECT * FROM medihope_reg_hos WHERE BEDS>? AND (PLACE=? OR ZIP=?)";
			psmt = conn.prepareStatement(query);
			
			psmt.setInt(1, 0);
			psmt.setString(2, searchVal);
			psmt.setString(3, searchVal);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				HospitalClass obj = new HospitalClass();
				obj.setName(rs.getString("NAME"));
				obj.setPhno(rs.getString("PH_NO"));
				obj.setBeds(rs.getInt("BEDS"));
				hospitalClass.add(obj);
			}
			
			
			
			if(searchVal.equals(""))
			{
				response.sendRedirect("PAGES/AMBULANCE/amb-search.jsp");
			}
//			HttpSession session = request.getSession();
//			session.setAttribute("ambulanceData", ambulanceClass);
			request.setAttribute("hospitalData", hospitalClass);
			request.setAttribute("email", email);
//			response.sendRedirect("PAGES/AMBULANCE/amb-search-result.jsp");
			request.getRequestDispatcher("PAGES/HOSPITAL/hos-search-result.jsp").forward(request, response);
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
