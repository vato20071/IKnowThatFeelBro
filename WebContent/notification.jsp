<%@page import="core.Notification"%>
<%@page import="core.DataBase"%>
<%@page import="core.Server"%>
<%@page import="core.Account"%>

<%@page import="java.util.List"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Notifications</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
		
			<link rel="stylesheet" href="css/skel.css" />
			<link rel="stylesheet" href="css/style.css" />
			<link rel="stylesheet" href="css/style-xlarge.css" />
			<link rel="stylesheet" href="css/gen.css" />
			<link rel="stylesheet" href="css/notification.css" />
			
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
				cur.setNotifications(db.getNotifications(cur.getUserName()));
				List<Notification> not=cur.getNotifications();
		%>
			<header id="header">
				<h4><a href="settings.jsp" ><%=cur.getNickName()%></a></h4>
				<nav id="nav">
					<ul>
						
						<li style="color: '#123451'" ><a href="generic.jsp">Home</a></li>
						<li><a href="Settings">Settings</a></li>
						<li><a href="LogOut">Sign out</a></li>
					</ul>
				</nav>
			</header>

		
		<div class="notifications">
					  	   <h3>Notifications</h3>
						   <table>
						   
						   <%	System.out.println(not.size());
						   		for(int i=not.size()-1; i>=0 && i<10; i--){
							   
							  	Notification nt= not.get(i);
							   
							   %>
						   
						  	   <tr>
						  	   <% if(nt.isSeen()){ %>
						  	   <td style="opacity: 0.5" ><div class="text" ><a href="#" style="color: #696969" ><%=nt.getMessage() %></a><h1 style="color: #696969"><%=nt.getDate() %></h1> </div></td>
						  	   		<td style="opacity: 0.4"><a  > </a></td>
							      
							      
							    <% }else{ %>
							    	<td style="background-color: #9C9C9C"><div class="text"  ><a href="#" style="color: #bdbdbd"><%=nt.getMessage() %></a><h1 style="color: #bdbdbd"><%=nt.getDate() %></h1></td>
							    
							   <% }
							    }%>  
							    </tr>
							    
							      </table>
						</div>	
		
		<% for(int i=0; i<not.size(); i++){
				not.get(i).setSeen(true);	
				db.updateNotification(cur.getUserName(), not.get(i));
		}%>
		
		
		<!--aqq--> 
		
		
		
			
				<div class="not-ft">
					
						
						
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