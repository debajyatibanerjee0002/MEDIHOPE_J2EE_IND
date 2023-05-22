<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="UpdateBankView" method="post">
		<div class="form-group">
			<label for="new"><i class="zmdi zmdi-lock-outline"></i></label>
			<input type="text" name="new" id="contact" placeholder="Enter new data" />
		</div>
		<input type="submit" value="Edit">
		<div>
			<div><%=request.getAttribute("bank_id") %>"</div>
			<div><%=request.getAttribute("attribute_name") %>"</div>
			<div><%=request.getAttribute("table_name") %>"</div>
		</div>
		<input type="hidden" value="<%=request.getAttribute("bank_id") %>" name="bank_id">
		<input type="hidden" value="<%=request.getAttribute("attribute_name") %>" name="attribute_name">
		<input type="hidden" value="<%=request.getAttribute("table_name") %>" name="table_name">
	</form>
</body>
</html>