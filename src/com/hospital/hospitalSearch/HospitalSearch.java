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
		
		PreparedStatement psmt;
		ArrayList<HospitalClass> hospitalClass = new ArrayList<HospitalClass>();
		try
		{
			Connection conn = SingletonConnection.getSingletonConnection();
			String searchVal = "";
			searchVal=request.getParameter("searchVal");
			
			String query = "SELECT * FROM MEDIHOPE_REG_HOS WHERE PLACE=? OR ZIP=?";
			psmt = conn.prepareStatement(query);
			
			psmt.setString(1, searchVal);
			psmt.setString(2, searchVal);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				HospitalClass obj = new HospitalClass();
				obj.setName(rs.getString("NAME"));
				obj.setPhno(rs.getString("PH_NO"));
				hospitalClass.add(obj);
			}
			if(searchVal.equals(""))
			{
				response.sendRedirect("PAGES/AMBULANCE/amb-search.jsp");
			}
//			HttpSession session = request.getSession();
//			session.setAttribute("ambulanceData", ambulanceClass);
			request.setAttribute("hospitalData", hospitalClass);
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
