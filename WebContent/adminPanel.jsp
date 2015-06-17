<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Admin Panel</title>
<!-- Custom Theme files -->
<link href="css/styleAdminLogin.css" rel="stylesheet" type="text/css" media="all"/>
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="keywords" content="Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<!--Google Fonts-->
<link href='http://fonts.googleapis.com/css?family=Roboto:500,900italic,900,400italic,100,700italic,300,700,500italic,100italic,300italic,400' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
<!--Google Fonts-->
</head>
	<% if(request.getSession().getAttribute("alreadyLogged") != null){
			response.sendRedirect("adminLoggedIn.jsp");
		}
	%>
<body>
<!--login form start here-->
<h1>Log In Admin Panel</h1>
<div class="login">
	    <div class="rib"> </div>
	    <form action="AdminLogin" method=get>
			<input type="text" value="username" name="username" id="username" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'username';}">
			<input type="password" value="password" name="password" id="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'password';}">
			<input type="submit" value="SIGN IN" >			
	    </form>
</div>
<div class="copyright">
	<p>All In Your Hands </p>
</div>
<!--login form end here-->	
</body>
</html>