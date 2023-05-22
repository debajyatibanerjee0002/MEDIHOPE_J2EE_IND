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
		
		String email = request.getParameter("email");
		
		PreparedStatement psmt;
		ArrayList<AmbulanceClass> ambulanceClass = new ArrayList<AmbulanceClass>();
		try
		{
			Connection conn = SingletonConnection.getSingletonConnection("medi_hope");
			String searchVal = "";
			searchVal=request.getParameter("searchVal");
			
			String query = "SELECT * FROM medihope_reg_amb WHERE AVAILABLE=? AND (PLACE=? OR ZIP=?)";
			psmt = conn.prepareStatement(query);
			psmt.setInt(1,1);
			psmt.setString(2, searchVal);
			psmt.setString(3, searchVal);
			
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
			request.setAttribute("email", email);
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
