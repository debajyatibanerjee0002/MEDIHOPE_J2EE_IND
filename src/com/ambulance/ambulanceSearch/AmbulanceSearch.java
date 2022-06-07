package com.ambulance.ambulanceSearch;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ambulance.ambulanceClass.AmbulanceClass;
import com.connection.SingletonConnection;
import com.passwordEncodingDecoding.PasswordEncodingDecoding;


@WebServlet("/AmbulanceSearch")
public class AmbulanceSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AmbulanceSearch() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		PreparedStatement psmt;
		ArrayList<AmbulanceClass> ambulanceClass = new ArrayList<AmbulanceClass>();
		try
		{
			Connection conn = SingletonConnection.getSingletonConnection();
			String searchVal = "";
			searchVal=request.getParameter("searchVal");
			
			String query = "SELECT * FROM MEDIHOPE_REG_AMB WHERE PLACE=? OR ZIP=?";
			psmt = conn.prepareStatement(query);
			
			psmt.setString(1, searchVal);
			psmt.setString(2, searchVal);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				AmbulanceClass obj = new AmbulanceClass();
				obj.setVlno(rs.getString("VL_NO"));
				obj.setPhno(rs.getString("PH_NO"));
				ambulanceClass.add(obj);
			}
			if(searchVal.equals(""))
			{
				response.sendRedirect("PAGES/AMBULANCE/amb-search.jsp");
			}
//			HttpSession session = request.getSession();
//			session.setAttribute("ambulanceData", ambulanceClass);
			request.setAttribute("ambulanceData", ambulanceClass);
//			response.sendRedirect("PAGES/AMBULANCE/amb-search-result.jsp");
			request.getRequestDispatcher("PAGES/AMBULANCE/amb-search-result.jsp").forward(request, response);
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
