<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<%@page import="core.Account"%>
<html>	
<head>
<%	Account current = (Account) session.getAttribute("account");
	String ID = current.getUserName();
	String mail = current.getMail();
	String fb = current.getFacebook();
	String nickName = current.getNickName();
	String gplus = current.getGplus();
	if (fb.equals("")) fb = "Not Specified";
	if (gplus.equals("")) gplus = "Not Specified";
	if (mail.equals("")) mail = "Not Specified";
	int coeffCount = current.getCoeffCount();
	
	double coeffValue = current.getCoeffValue(); %>
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<meta name="keywords" content="Transparent Organic Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
<link href="css/settings.css" rel='stylesheet' type='text/css' />
<!--web-fonts-->
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<!--/web-fonts-->
</head>
<body>
	<h1><%= nickName + "'s Profile Information" %></h1>
<div class="two-forms">
	<div class="wrap">
		<div class="signup">
			<h2>Change Account Info</h2>
			<div class="singup-info">
					<form action="SaveData" method="post">
						<div class="users">
							Nickname:
							<input name="nickname" type="text" class="text" value="<%= nickName %>"
								onfocus="this.value = '';"
								onblur="if (this.value == '') {this.value = '<%= nickName %>';}">
							MailBox:
							<input name="mail" type="text" class="text" value="<%= mail %>"
								onfocus="this.value = '';"
								onblur="if (this.value == '') {this.value = '<%= mail %>';}">
							FaceBook:
							<input name="facebook" type="text" class="text" value="<%= fb %>"
								onfocus="this.value = '';"
								onblur="if (this.value == '') {this.value = '<%= fb %>';}">
							Google+:
							<input name="gplus" type="text" class="text" value="<%= gplus %>"
								onfocus="this.value = '';"
								onblur="if (this.value == '') {this.value = '<%= gplus %>';}">
							<input type="submit" value="Save Updated Info" >
						</div>
					</form>
					<p> &nbsp;
					</p>
				</div>
		</div>
		<div class="login">
			<h3>Extra Information</h3>
				<div class="login-info">
					Register ID: <%= ID %> <br>
					User Friendliness Coefficient: <%= coeffValue %> <br>
					User Friendliness Count: <%= coeffCount %> <br>
				</div>
			</div>
		<div class="clear"> </div>
	</div>
</div>
</body>
</html>