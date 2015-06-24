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
<% 	Category cat = (Category) session.getAttribute("category"); 
	Account acc = (Account) session.getAttribute("account");
	List<Room> rooms = cat.getRoomList();
	%>
<title>Choose Room: <%= cat.getName() %></title>
<!---- start-smoth-scrolling---->
</head>
<body>
	<!----start-header---->
	<div class="header" id="home">
		<div class="container">
			<div class="logo">
				<a href="index.jsp"><img src="images/pic09.jpg" alt=""></a>
			</div>
			<div class="navigation">
			 <span class="menu"></span> 
				<ul class="navig">
					<li><a href="generic.jsp">Home</a><span> </span></li>
					<li><a href="about.html">About</a><span> </span></li>
					<li><a href="blog.html">Blog</a><span> </span></li>
					<li><a href="pages.html">Pages</a><span> </span></li>
					<li><a href="gallery.html">Gallery</a><span> </span></li>
					<li><a href="contact.html">Contact</a><span> </span></li>
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
						<%	System.out.println(rooms.size());
							for (int i=0; i<rooms.size(); i++) {
								Room room = rooms.get(i); 
								boolean printLi = i % 6 == 0;
								boolean printDiv = i % 3 == 0;
								int whichBanner = i / 3 % 2; 
								if (printLi) {
									out.println("<li>");
								}
								if (printDiv)
									if (whichBanner == 0) out.println("<div class=\"banner-top\">");
									else out.println("<div class=\"banner-center\">");
								%>
								<div class="col-md-4 banner-left">
									<div class="bnr-one">
										<img src="images/b-3.jpg" alt="" />
										<h3>Quisque pharetra</h3>
										<a href="#">Read More</a>
									</div>
								</div>
							<%
								if (printDiv) out.println("</div>");
								if (printLi) out.println("</li>");
							}
							%>
						}
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
					<button type="button" class="btn btn-primary btn-lg" onclick="console.log('here');">Create new room</button>
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