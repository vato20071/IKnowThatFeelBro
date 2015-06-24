<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="core.Account" %>
<%@ page import="core.Server" %>
<%@ page import="core.DataBaseInterface" %>
<%@ page import="core.DataBase" %>

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
	<h3>Dashboard</h3>
	
		<div class="informasi">
		Total Accounts registered:  
		<%	
		Server serv = (Server) request.getSession().getServletContext().getAttribute("server");
		String name = request.getParameter("username");
		DataBase db = serv.getDB();
		Account acc = db.getAccountByName(name); 
		int amount = db.getTotalAccount();
		int online = serv.getCountActiveUsers();
		request.getSession().setAttribute("amount", amount);
		request.getSession().setAttribute("online", online);
		%>
		<%= amount %>
		</div>
		
		<div class="sukses">
		Online Users: <%= online %>
		</div>
		<div>
		<h3 id="parag">Manage Categories</h3>
		</div>
		<div>
		<form action="" method=get>
			<a class="btn1" href="addNewCategory.jsp" style="float: left;">Add Category</a>		
		</form>
		<form action="" method=get>
			<a class="btn" href="deleteCategory.jsp" style="float: right;">Remove Category</a>
		</form>
		<br>
		<br>
		</div>
	</div>
<div class="clear"></div>
<div id="footer">
	&copy; 2015 Vortex Team |GM CORP <a href="" target="_blank">Inc</a>
</div>
</div>
</body>
</html>