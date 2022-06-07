<%
	String name = (String)request.getAttribute("name");
	String email = (String)request.getAttribute("email");
	String pass = (String)request.getAttribute("pass");
	
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="../STYLE/home-page.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
<style>
.form
{
	display: flex;
}
.img-con
{
	height: 100px;
	width: 100px;
	margin: 20px;
}
.form-container
{
	margin-left: 20px;
	text-align: -webkit-center;
	margin-top: -40px;
}
.btn-cus
{
	margin: 5px !important;
}
h4
{
	color: black;
	padding-right: 5px;
	margin-top: 7px !important;
}
a
{
	text-decoration: none;
	color: white;
	font-size: 15px;
}
a:hover
{
	text-decoration: none;
	color: white;
}
h5
{
	color: black;
	padding-right: 5px;
	margin-top: 8px !important;
	margin-right: 10px;
	cursor: pointer;
	font-weight: 600 !important;
	font-style: italic !important;
	font-family: 'Prompt', sans-serif !important;
}
h5:hover
{
	color: #12cc94;
}
i
{
	color: black;
	padding: 4px;
}
i:hover
{
	color: white;
}
button:hover
{
	color: white !important;
}
.cart
{
	margin-right: 10px; 
}

</style>
<title>Home</title>
</head>
<body>

<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
      <a class="navbar-brand" href="#">MEDIHOPE</a>
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="./home.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#about">About Us</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#contact">Contact Us</a>
        </li>
      </ul>
      <h4>Hello,</h4>
      <a href="./PROFILE/profile.jsp"><h5>${name}</h5></a>
      <a href="/MEDIHOPE/CartServlet" class="btn btn-outline-primary cart">CART</a>
      <a href="./logout.jsp" class="btn btn-outline-danger margin-left margin-right">LOG OUT</a>
    </div>
  </div>
</nav>

<div class="logo" id="fade_out">
	<img class="top" src="../IMAGES/logo2.png" alt="">
	<img class="buttom" src="../IMAGES/logo1.png" alt="">


<div class="container-fluid form">
		<div class="col-md-6 col-sm-4 col-xs-12">
			<div class="col-md-6 col-sm-4 col-xs-12" style="margin-left:150px;">HOSPITAL</div>
			<form class="form-container">
			  <img class="img-con" src="../IMAGES/hospital.png" alt="">
			  <a href="HOSPITAL/hos-search.jsp" class="btn btn-success btn-cus">BOOK</a>
			  <a href="HOSPITAL/hos-reg.jsp" class="btn btn-danger btn-cus">REG</a>
			</form>
		</div>
		<div class="col-md-6 col-sm-4 col-xs-12">
			<div class="col-md-6 col-sm-4 col-xs-12" style="margin-left:150px;">AMBULANCE</div>
			<form class="form-container">
			  <img class="img-con" src="../IMAGES/amb.png" alt="">
			  <a href="AMBULANCE/amb-search.jsp" class="btn btn-success btn-cus">BOOK</a>
			  <a href="AMBULANCE/amb-reg.jsp" class="btn btn-danger btn-cus">REG</a>
			</form>
		</div>
</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>