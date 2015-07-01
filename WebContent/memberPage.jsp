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
<%	Account member = (Account) session.getAttribute("member");
	String ID = member.getUserName();
	String mail = member.getMail();
	String fb = member.getFacebook();
	String nickName = member.getNickName();
	String gplus = member.getGplus();
	if (fb.equals("")) fb = "Not Specified";
	if (gplus.equals("")) gplus = "Not Specified";
	if (mail.equals("")) mail = "Not Specified";
	int coeffCount = member.getCoeffCount();
	
	double coeffValue = member.getCoeffValue(); %>
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
			<h2>User Info</h2>
			<div class="singup-info">
					<div class="users">
						Nickname:
						<input name="nickname" type="text" class="text" value="<%= nickName %>"readonly>
						MailBox:
						<input name="mail" type="text" class="text" value="<%= mail %>" readonly>
						FaceBook:
						<input name="facebook" type="text" class="text" value="<%= fb %>" readonly>
						Google+:
						<input name="gplus" type="text" class="text" value="<%= gplus %>" readonly>
						<form action="makeFriend" method="get">
							<input type="hidden" value=<%= ID %> name="fruser">
							<input type="submit" value="Add as a friend" >
						</form>
					</div>
					<p> &nbsp;
					</p>
				</div>
		</div>
<script>
function ratingUpdate() {
	var sel = document.getElementById('values');
    var sv = sel.options[sel.selectedIndex].value;
    document.getElementById('rating').value = sv;
}
</script>
		<div class="login">
			<h3>Extra Information</h3>
				<div class="login-info">
					User Friendliness Coefficient: <%= coeffValue %> <br>
					User Friendliness Count: <%= coeffCount %> <br>
				</div>
				<form action="VoteForUser" method="post">
					<input name="userName" value="<%=ID %>" type="hidden">
					Rate <%= nickName %> for 
					<input id="rating" name="rating" type="hidden" value="1">
						<select id="values" onchange="ratingUpdate()">
							<option value="1"> 1 </option>
							<option value="2"> 2 </option>
							<option value="3"> 3 </option>
							<option value="4"> 4 </option>
							<option value="5"> 5 </option> 
						</select>
					</input>
					points
					<input type="submit" value="Rate" >
				</form>
			</div>
		<div class="clear"> </div>
	</div>
</div>
</body>
</html>