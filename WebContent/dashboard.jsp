<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Bank Dashboard Page</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">

 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp"><img src="images/logo.png" width="90" height="20"></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
        <h2> <b><i><%=request.getAttribute("bank_name")%></i><b> </b>
        </li>
        <li><a href="./BankViewServlet?val=<%=request.getAttribute("bank_id")%>">View</a></li>
        </ul>
       
      
    </div>
  </div>
</nav>
 

<input type="hidden" id="status" value="<%= request.getAttribute("status")%>">
	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Enter Blood Details</h2>
					
						<form method="post" action="DashboardServlet" class="register-form"
							id="register-form">
							<div class="form-group">
								<label for="bank_id"><i
									class="zmdi zmdi-lock-outline"></i></label> <input
									type=hidden name="bank_id" id="bank_id" value="${bank_id}" />
							</div>
							<div class="form-group">
								<label for="A+ Blood Group"></label>
								<input type="text" name="a+" id="a+" placeholder="Enter A+ Blood Group Units" />
							</div>
							<div class="form-group">
								<label for="B+ Blood Group"></label>
								<input type="text" name="b+" id="b+" placeholder="Enter B+ Blood Group Units" />
							</div>
							<div class="form-group">
								<label for="O+ Blood Group"></i></label>
								<input type="text" name="o+" id="o+" placeholder="Enter O+ Blood Group Units" />
							</div>
							<div class="form-group">
								<label for="AB+ Blood Group"></i></label>
								<input type="text" name="ab+" id="ab+" placeholder="Enter AB+ Blood Group Units" />
							</div>
							<div class="form-group">
								<label for="A- Blood Group"></label>
								<input type="text" name="a-" id="a-" placeholder="Enter A- Blood Group Units" />
							</div>
							<div class="form-group">
								<label for="B- Blood Group"></label>
								<input type="text" name="b-" id="b-" placeholder="Enter B- Blood Group Units" />
							</div>
							<div class="form-group">
								<label for="O- Blood Group"></label>
								<input type="text" name="o-" id="o-" placeholder="Enter O- Blood Group Units" />
							</div>
							<div class="form-group">
								<label for="AB- Blood Group"></label>
								<input type="text" name="ab-" id="ab-" placeholder="Enter AB- Blood Group Units" />
							</div>
							
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Submit" />
							</div>
						</form>
					</div>
					<div class="signup-image">
						<figure>
							<img src="https://www.thenews.com.pk/assets/uploads/akhbar/2020-02-02/607787_060719_updates.jpg" alt="">
						</figure>
						
					</div>
				</div>
			</div>
		</section>


	</div>
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	<script type="text/javascript">
	
	 var obj=document.getElementById("status").value;
	 if(obj=="success"){
		 swal("Congratualation","Your Account Created","success");
	 }
	</script>

</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>