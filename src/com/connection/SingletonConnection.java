package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
	private static Connection conn=null;
	
	private SingletonConnection()
	{}
	
	public static Connection getSingletonConnection(String database)
	{
		String url="";
		if(database.equals("blood_finder"))
			url="jdbc:mysql://localhost:3306/blood_finder?useSLL=false";
		else
			url="jdbc:mysql://localhost:3306/medi_hope?useSLL=false";
		String driver = "com.mysql.cj.jdbc.Driver";
		String userid = "root";
		String password = "";
		
		try
		{
			if(conn == null || conn.isClosed())
			{
				Class.forName(driver);
				conn = DriverManager.getConnection(url, userid, password);
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return conn;
	}
}
