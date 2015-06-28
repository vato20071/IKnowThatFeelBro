<%@page import="servlets.RoomList"%>
<%@page import="core.Room"%>
<%@page import="core.Account"%>
<%@page import="core.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Majestic Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="https://dl.dropboxusercontent.com/s/a2nj2f0htzb29dx/bootstrap.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link href="css/roomList.css" rel='stylesheet' type='text/css' />
<link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,200italic,300,300italic,400italic,600,600italic,700,700italic,900' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
<script src="js/jquery-1.11.0.min.js"></script>

<!---- start-smoth-scrolling---->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
				});
			});
		</script>
<% 
	System.out.println((String)session.getAttribute("spectAccountID"));
	if(session.getAttribute("spectAccountID") == null){
		response.sendRedirect("index.jsp");
		return;
	}
	Category cat = (Category) session.getAttribute("category"); 
	List<Room> rooms = cat.getRoomList();
	%>
<title>Choose Room: <%= cat.getName() %></title>
<!---- start-smoth-scrolling---->
</head>
<body>
	<!----start-header---->
	<div class="header" id="home">
		<div class="container" align = "center">
			<div class="logo">
				<a href="Settings"> <h3 style="color:white"> <%=(String)session.getAttribute("name") %> </h3> </a>
			</div>
			<div class="navigation">
			 <span class="menu"></span> 
				<ul class="navig">
					<li><a style="color:green" href="RoomList?category=<%=cat.getID()%>"><%=cat.getName() %></a></li>
					<li><a href="index.jsp">Home</a><span> </span></li>
					<li><a href="spectCategories.jsp">Back</a><span> </span></li>
				</ul>
			</div>
				 <!-- script-for-menu -->
		 <script>
				$("span.menu").click(function(){
					$(" ul.navig").slideToggle("slow" , function(){
					});
				});
		 </script>
		 <!-- script-for-menu -->
		</div>
	</div>	
	<!----end-header---->
	<!--banner-starts-->
	<div class="banner" id="home">
	<%if (rooms.size() > 0) { %>
		<div class="container">
			<section class="slider">
                <div class="flexslider">
                    <ul class="slides">
						<%	for (int i=0; i<Math.ceil(rooms.size()/6.0); i++) {
								out.println("<li style=\"display: list-item\">");
								out.println("<div class=\"banner-top\">");
								for (int j=0; j<3 && (i*6 + j) < rooms.size() ; j++) { %>
									<div class="col-md-4 banner-left">
										<div class="bnr-one">
											<img src="images/bg.jpg" alt="" />
											<h3><%=rooms.get(i*6+j).getRoomName() %></h3>
											<h4><%="Online: " + rooms.get(i*6+j).membersCount() %></h4>
											<a href="ChatRoom?category=<%=cat.getID() %>&roomID=<%=rooms.get(i*6+j).getRoomID()%>">Enter Room</a>
										</div>
									</div>
							<%	} %>
							<%	out.println("</div>");
								out.println("<div class=\"banner-center\">");
								for (int j=0; j<3 && (i*6 + 3 + j) < rooms.size(); j++) { %>
									<div class="col-md-4 banner-left">
										<div class="bnr-one">
											<img src="images/bg.jpg" alt="" />
											<h3><%=rooms.get(i*6+j+3).getRoomName() %></h3>
											<h4><%="Online: " + rooms.get(i*6+j+3).membersCount() %></h4>
											<a href="ChatRoom?category=<%=cat.getID() %>&roomID=<%=rooms.get(i*6+j+3).getRoomID()%>">Enter Room</a>
										</div>
									</div>
							<%	}
								out.println("</div>");
								out.println("</li>");
							} %>
						</ul>
				</div>
			</section>
		</div>
	<% } else { %>
		<div class = "row" align = "center">
			<div class="buttonRow">
				<div class="col-sm-4"></div>
				<div class = "col-sm-4" align="center">
					<h4> Whoops, no rooms found. </h4> <br>
					<button type="button" class="btn btn-primary btn-lg" onclick="window.location.href= 'NewRoom?category=<%=cat.getID() %>';">Create new room</button>
				</div>
				<div class="col-sm-4"></div>
			</div>
		</div>
	<% } %>
	</div>
	<!--banner-ends--> 
	<!--FlexSlider-->
	
	<script defer src="js/jquery.flexslider.js"></script>
	<script type="text/javascript">
    $(window).load(function(){
      $('.flexslider').flexslider({
        animation: "slide",
        start: function(slider){
          $('body').removeClass('loading');
        }
      });
    });
  </script>
</div>
</body>
</html>