<%@page import="core.DataBase"%>
<%@page import="core.Server"%>
<%@page import="core.Account"%>
<%@page import="core.Category"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Spectating In Progress</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
		<script src="js/jquery.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/skel-layers.min.js"></script>
		<script src="js/init.js"></script>
			<link rel="stylesheet" href="css/skel.css" />
			<link rel="stylesheet" href="css/style.css" />
			<link rel="stylesheet" href="css/style-xlarge.css" />
			<link rel="stylesheet" href="css/gen.css" />
			
		<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
	</head>
	<body>

		<!-- Header -->
		<% 	
			Server serv = (Server) session.getServletContext().getAttribute("server");
			DataBase db = serv.getDB();
			String cur = (String) session.getAttribute("spectAccountID");
			if(cur==null)
				response.sendRedirect("index.jsp");
			else{
				List<Category> categories=db.getAllCategory();
		%>
			<header id="header">
				<h1><a href="settings.jsp"><%=(String) session.getAttribute("name")%></a></h1>
				<nav id="nav">
					<ul>
						<li><a href="index.jsp">Home</a></li>
					</ul>
				</nav>
			</header>

		
		<div class="categories">
					  	   <h3>Categories</h3>
						   <table>
						   
						   <%for(int i=0; i<categories.size()&& i<4; i++){
							   
							   Category cat= categories.get(i);
							   
							   %>
						   
						  	   <tr>
							      <td><a href="RoomList?category=<%=cat.getID() %>"><%=cat.getName() %></a></td>
							      </tr>
							    <%} %>  
							    <tr>
							      <td><a href="#">All</a></td>
							      </tr>
							      </table>
						</div>	
				
			
			<script type="text/javascript">
							function DropDown(el) {
								this.dd = el;
								this.initEvents();
							}
							DropDown.prototype = {
								initEvents : function() {
									var obj = this;
				
									obj.dd.on('click', function(event){
										$(this).toggleClass('active');
										event.stopPropagation();
									});	
								}
							}
							$(function() {
				
								var dd = new DropDown( $('#dd') );
				
								$(document).click(function() {
									// all dropdowns
									$('.wrapper-dropdown-2').removeClass('active');
								});
				
							});
			</script>
			
			
		<!-- Footer -->
		
			
				<div class="ft">
					
						
						
							<h3>Contact Us</h3>
							<ul class="icons">
								<li><a href="#" class="icon rounded fa-twitter"><span class="label">Twitter</span></a></li>
								<li><a href="#" class="icon rounded fa-facebook"><span class="label">Facebook</span></a></li>
								<li><a href="#" class="icon rounded fa-pinterest"><span class="label">Pinterest</span></a></li>
								<li><a href="#" class="icon rounded fa-google-plus"><span class="label">Google+</span></a></li>
								<li><a href="#" class="icon rounded fa-linkedin"><span class="label">LinkedIn</span></a></li>
							</ul>
							
						
					
					
				</div>
			
			
			

		
	<%} %>
	</body>
</html>