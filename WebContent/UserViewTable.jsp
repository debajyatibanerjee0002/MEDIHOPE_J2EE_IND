
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.AreaSearchNew"%>
<%@page import="com.SetGet"%>
<%@page import="java.util.*"%>



<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<style>
	
*{
	text-align: center;
	align: center;
}

body
{
	color: #fff;
	background: linear-gradient(rgba(0, 0, 0, 0.527),rgba(0, 0, 0, 0.7)),url(./IMAGES/background.png);
	background-size: cover;
	background-blend-mode: darken;
	background-repeat: no-repeat;
	height: 100vh;
}


th{
	width: 33%;
	background-color: #B799FF;
	text-align: center !important;
    padding: 5px !important;
}

tr{
	height: 20px !important;
	padding: 10px !important;
}
h1{
	font-weight: 700;
	color:  #B799FF;
	margin-top: 1.5rem;
	padding: 2px;
	box-shadow: 0px 5px 5px;
}
.blood-info{
	padding: 10px;
	text-align: left !important;
}
button{
	background-color: #B799FF;
}

a{
	display: block;
	margin: 10px !important;
	padding: 10px 10px !important;
	background-color: #B799FF !important;
	text-decoration: none !important;
	color: white !important;
}

tr:nth-child(even) {
color: black;
background-color: #f2f2f2;}

</style>

</head>
<body>

	

	
	

<div  style="margin:auto;  width:80%; padding-top: 15%" >
	<table border='1' width='100%' align='center'>
	
				<thead>
				<tr>
				    <th style="font-size: 3rem">Bank Name</th>				
      			</tr>
				</thead>
				
				<tbody>
				<% ArrayList<String> obj= (ArrayList<String>)request.getAttribute("data");
				 ArrayList<String> obj2= (ArrayList<String>)request.getAttribute("data2");

				 SetGet ob=new SetGet();
				for(int i=0;i<obj.size();i++){%>
				<tr>
				<td>
				<a href="/Blood_Finder/UserViewServlet?val=<%=obj2.get(i) %>" style="font-size: 2rem">
				<%=obj.get(i) %></a>
				</td>
				</tr>
				<%} %>
				</tbody>
	</table>
</div>
</body>
</html>