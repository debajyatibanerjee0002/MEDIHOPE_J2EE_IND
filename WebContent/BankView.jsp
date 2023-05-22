<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>




<%@page import="com.*"%>

<%@page import="java.util.*"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
	<% ArrayList<String> obj1= (ArrayList<String>)request.getAttribute("bank_data");%>
	
	<h1><%=obj1.get(0)%></h1>
	<div class="container">
		<div class="row row-cols-2">
			<div>
				<div><%=obj1.get(1)%></div>
				<form action="UpdatePage.jsp" method="post">
					<input type="submit" value="Edit">
					<input type="hidden" value="<%=obj1.get(5) %>" name="bank_id">
					<input type="hidden" value="phone" name="attribute_name">
					<input type="hidden" value="blood_bank" name="table_name">
				</form>
			</div>
			<div>
				<div><%=obj1.get(2)%></div>
				<form action="UpdatePage.jsp" method="post">
					<input type="submit" value="Edit">
					<input type="hidden" value="<%=obj1.get(5) %>" name="bank_id">
					<input type="hidden" value="email" name="attribute_name">
					<input type="hidden" value="blood_bank" name="table_name">
				</form>
			</div>
			<div>
				<div><%=obj1.get(3)%></div>
				<form action="UpdatePage.jsp" method="post">
					<input type="submit" value="Edit">
					<input type="hidden" value="<%=obj1.get(5)%>" name="bank_id">
					<input type="hidden" value="location" name="attribute_name">
					<input type="hidden" value="blood_bank" name="table_name">
				</form>
			</div>
			<div>
				<div><%=obj1.get(4)%></div>
				<form action="UpdatePage.jsp" method="post">
					<input type="submit" value="Edit">
					<input type="hidden" value="<%=obj1.get(5)%>" name="bank_id">
					<input type="hidden" value="pin" name="attribute_name">
					<input type="hidden" value="blood_bank" name="table_name">
				</form>
			</div>
			<div>
			</div>
		</div>
	</div>
	
	<table border='1' width='800' align='center'>
				<tr>
				    <th>Blood Group</th>
				    <th>Quantity</th>
				    <th>Action</th>
				</tr>
				
				<%
				String[] a={"A+","B+","O+","AB+","A-","B-","O-","AB-"};
				ArrayList<String> obj2= (ArrayList<String>)request.getAttribute("blood_data");
				for(int i=0;i<obj2.size();i++){%>
				<tr>
					<td><%=a[i] %></td>
					<td><%=obj2.get(i) %></td>
					<td>
						<form action="UpdatePage.jsp" method="post">
							<input type="submit" value="Edit">
							<input type="hidden" value="<%=obj1.get(5) %>" name="bank_id">
							<input type="hidden" value="<%=i %>" name="attribute_name">
							<input type="hidden" value="blood_details" name="table_name">
						</form>
					</td>
				</tr>
				<%} %>
	</table>
</body>
</html>