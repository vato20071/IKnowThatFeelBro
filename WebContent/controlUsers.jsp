<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<title>Admin Panel</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Copyright" content="arirusmanto.com">
<meta name="description" content="Admin MOS Template">
<meta name="keywords" content="Admin Page">
<meta name="author" content="Ari Rusmanto">
<meta name="language" content="Bahasa Indonesia">

<link rel="stylesheet" type="text/css" href="css/mos-style.css"> <!--pemanggilan file css-->
</head>

<% if(request.getSession().getAttribute("adminLet")==null || 
	(int)request.getSession().getAttribute("adminLet") != 121314){ response.sendRedirect("adminPanel.jsp"); } %>
<body>
<div id="header">
	<div class="inHeader">
		<div class="mosAdmin">
		Hello, My Lord<br>
		<a href="index.jsp">Visit Website</a>|
		<form action="adminLoggedOut" method=get>
			<input type="submit" value= "Log Out" >		
		</form>
		</div>
	<div class="clear"></div>
	</div>
</div>

<div id="wrapper">
	<div id="leftBar">
	<ul>
		<li><a href="adminLoggedIn.jsp">Dashboard</a></li>
		<li><a href="controlUsers.jsp">Users</a></li>
	</ul>
	</div>
	<div id="rightContent">
	<h3>Search And Manage Users</h3>
	<br>
	<form action="findUser" method=get>
		Enter Username Of A Person You Want To Search: <input type=text id="username" name="username">
		<br>
		<div id="button">
		<input type="submit" class="btn3" value="Search">
		</div>
	</form>
	</div>
<div class="clear"></div>
<div id="footer">
	&copy; 2015 Vortex Team |GM CORP <a href="" target="_blank">Inc</a>
</div>
</div>
</body>
</html>