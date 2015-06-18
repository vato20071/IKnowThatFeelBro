<%@page import="core.DataBase"%>
<%@page import="core.Server"%>
<%@page import="core.Account"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>next page</title>
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
			
		<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
	</head>
	<body>

		<!-- Header -->
		<% 	
			Server serv = (Server) session.getServletContext().getAttribute("server");
			DataBase db = serv.getDB();
			Account cur = db.getAccountByName((String) session.getAttribute("accountID"));
			if(cur==null)
				response.sendRedirect("index.jsp");
			else{
		%>
			<header id="header">
				<h1><a href="settings.jsp"><%=cur.getNickName()%></a></h1>
				<nav id="nav">
					<ul>
						<li><a href="generic.jsp">Home</a></li>
						<li><a href="Settings">Settings</a></li>
						<li><a href="LogOut">Sign out</a></li>
					</ul>
				</nav>
			</header>

		
		<div class="categories">
					  	   <h3>Categories</h3>
						   <table>
						  	   <tr>
							      <td><a href="#">All</a></td>
							      </tr>
							      <tr>
							      <td><a href="#">Hindi</a></td>
							      </tr>
							      <tr>
							      <td><a href="#">Telugu</a></td>
							      </tr>
							      <tr>
							      <td><a href="#">English</a></td>
							      </tr>
							      </table>
						</div>	
		
		
		
		<!--aqq--> 
		
		
		
		<div class="wrapper-demo" >
				
				<!--start-wrapper-dropdown-2-->
					<div id="dd" class="wrapper-dropdown-2">Friends<i><img class="menu" src="images/menu.png"/></i>
									 <!-- start search-->
				    <div class="search-box">
					    <div id="sb-search" class="sb-search">
							<form>
								<input class="sb-search-input" placeholder="Search" type="search" name="search" id="search">
								<input class="sb-search-submit" type="submit" value="">
								<span class="sb-icon-search"> </span>
							</form>
							
						</div>
				    </div>
				    <!-- search-scripts -->
					<script src="js/classie.js"></script>
					<script src="js/uisearch.js"></script>
						<script>
							new UISearch( document.getElementById( 'sb-search' ) );
						</script>
					<!-- /search-scripts -->
 				<!-- end search-->
							<ul class="dropdown">	
												
								<div class="friends-grids" id="grid">
									<div class="grids-left">
										<img src="images/a1.png" />
									</div>	
									
									<div class="grids-right">
										<h2>Name</h2>
										<!--<img src="images/heart.png" />-->
									<ul class="grids-right-info">
											<li class="user">category</li>
											</ul>
									</div>
									
								</div>
							<div class="friends-grids" >
									<div class="grids-left">
										<img src="images/a1.png" />
									</div>	
									
									<div class="grids-right">
										<h2>Category</h2>
										<!--<img src="images/heart.png" />-->
									<ul class="grids-right-info">
											<li class="user">Name</li>
											
										
									</ul>
									</div>
									
								</div>					
							</ul>
							
												
								
												
							
					</div>
			</div>
			
			<!--aqq-->
			
			
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