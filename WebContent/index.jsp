<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="UTF-8">
<title>Get Revived</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="Life Support" />
<meta name="keywords" content="Support,Psychological Help,Life Problems" />
<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
<script src="js/jquery.min.js"></script>
<script src="js/skel.min.js"></script>
<script src="js/skel-layers.min.js"></script>
<script src="js/init.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/jquery.leanModal.min.js"></script>
<script src="js/loadJS.js"></script>
<script src="https://apis.google.com/js/client:platform.js" async defer></script>
<meta name="google-signin-clientid"
	content="781668877526-hv8h62fo4jv5vtctdp4au87foc259s1f.apps.googleusercontent.com" />
<meta name="google-signin-scope"
	content="https://www.googleapis.com/auth/plus.login" />
<meta name="google-signin-requestvisibleactions"
	content="http://schema.org/AddAction" />
<meta name="google-signin-cookiepolicy" content="single_host_origin" />
<script
	src="https://apis.google.com/js/client:platform.js?onload=render" async
	defer></script>
<script>
		</script>
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" />
<link rel="stylesheet" href="css/skel.css" />
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/style-xlarge.css" />
<link rel="stylesheet" href="css/SpectateSkeleton.css" />
<link rel="stylesheet" href="css/SpectateStyle.css" />
<link type="text/css" rel="stylesheet" href="css/PopUpStyle.css" />
<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
</head>
<body class="landing">

	<div id="fb-root"></div>
	<script>(function(d, s, id) {
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id)) return;
		js = d.createElement(s); js.id = id;
		js.src = "//connect.facebook.net/en_GB/sdk.js#xfbml=1&version=v2.3&appId=442331189280338";
		fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));</script>

	<!-- Header -->
	<header id="header">
		<h4>
			<a href="index.jsp">Home</a>
		</h4>
		<nav id="nav">
			<ul>
				<li><a href="index.jsp">Learn More</a></li>
				<li><a href="index.jsp">Contact Us</a></li>
			</ul>
		</nav>
	</header>

	<!-- Banner -->
	<section id="banner">
		<h2>We Know That Feel Bro</h2>
		<p>Getting Support Has Never Been So Easy.</p>
		<div class="container">
			<a id="modal_trigger" href="#modal" class="btn">Login / Register</a>
			<form action="spectateServlet" method="get">
				<input type="submit" value="Spectate" class="midnight-blue-flat-button">
			</form>
			<div id="modal" class="popupContainer" style="display: none;">
				<header class="popupHeader">
					<span class="header_title">Login</span> <span class="modal_close"><i
						class="fa fa-times"></i></span>
				</header>

				<section class="popupBody">
					<!-- Social Login -->
					<div class="social_login">
						<div class="">
							<a href="#" class="social_box fb" onclick="return fbAuth();">
								<span class="icon"><i class="fa fa-facebook"></i></span> <span
								class="icon_title">Connect with Facebook</span>
							</a> <a href="#" class="social_box google" id="signinButton"> <span
								class="icon"><i class="fa fa-google-plus"></i></span> <span
								class="icon_title">Connect with Google</span>
							</a>
						</div>
						<div class="action_btns">
							<div class="one_half">
								<a href="#" id="login_form" class="btn">Login</a>
							</div>
							<div class="one_half last">
								<a href="#" id="register_form" class="btn">Sign up</a>
							</div>
						</div>
					</div>

					<!-- Username & Password Login form -->
					<div class="user_login">
						<form id="loginForm" action="NormalLogIn" method="post">
							<label>Email / Username</label> <input type="text"
								name="log_user" /> <br /> <label>Password</label> <input
								type="password" name="log_pass" /> <br />

							<div class="action_btns">
								<div class="one_half">
									<a href="#" class="btn back_btn"><i
										class="fa fa-angle-double-left"></i> Back</a>
								</div>
								<div class="one_half last">
									<a href="#" class="btn btn_red"
										onclick="document.getElementById('loginForm').submit()">Login</a>
								</div>
							</div>
						</form>

						<a href="#" class="forgot_password">Forgot password?</a>
					</div>

					<!-- Register Form -->
					<div class="user_register">
						<form id="myform" action="NormalSignUp" method="post">
							<label>User Name</label> <input type="text" name="reg_username" />
							<br /> <label>Nick Name</label> <input type="text"
								name="reg_nickname" /> <br /> <label>Password</label> <input
								type="password" name="reg_pass" id="reg_pass" /> <br />

							<div class="checkbox">
								<input id="checkBox" type="checkbox" onclick="swapIt()" /> <label
									for="checkBox">Show Password</label>
							</div>

							<div class="action_btns">
								<div class="one_half">
									<a href="#" class="btn back_btn"><i
										class="fa fa-angle-double-left"></i> Back</a>
								</div>
								<div class="one_half last">
									<a href="#" class="btn btn_red"
										onclick="document.getElementById('myform').submit()">Register</a>
								</div>
							</div>
						</form>
					</div>
				</section>
			</div>
		</div>

		<script type="text/javascript">
				$("#modal_trigger").leanModal({top : 200, overlay : 0.6, closeButton: ".modal_close"});
			
			</script>
	</section>

	<!-- One -->
	<section id="one" class="wrapper style1 align-center">
		<div class="container">
			<header>
				<h2>What Is This Website About</h2>
				<p>Get An Online Support From New Friends Anytime You Want.</p>
			</header>
			<div class="row 200%">
				<section class="4u 12u$(small)">
					<i class="icon big rounded fa-clock-o"></i>
					<p>Express Your Feelings And Help Others To Cope With Their
						Daily Life Problems 24/24.</p>
				</section>
				<section class="4u 12u$(small)">
					<i class="icon big rounded fa-comments"></i>
					<p>Use Chat Rooms To Meet New People And Share Your Experience.
						This Utility Allows You Connect Our Website From Wherever You
						Want.</p>
				</section>
				<section class="4u$ 12u$(small)">
					<i class="icon big rounded fa-user"></i>
					<p>Just Like At Anonymous Meetings You Are Able To Make Video
						Conference Where You Can Honestly Tell Your Life Stories Help
						Someone Or Get It For Yourself .</p>
				</section>
			</div>
		</div>
	</section>

	<!-- Two -->
	<section id="two" class="wrapper style2 align-center">
		<div class="container">
			<header>
				<h2>Still In Doubt Whether This Is Your Place Or Not?</h2>
				<p>Then Just Click On Spectate Button To Fully Explore All The
					Benefits Of Our Website.</p>
			</header>
			<footer>
				<form action="spectateServlet" method="get">
					<ul class="actions">
						<li><input type="submit" class="button alt big" value="Spectate" ></li>
					</ul>
				</form>
			</footer>
		</div>
	</section>

	<!-- Footer -->
	<footer id="footer">
		<div class="container">
			<div class="row">
				<section class="4u 6u(medium) 12u$(small)">
					<h3>Quotes Of The Week</h3>
					<p>Look At Some 'Editors Choice' Quotes, They May Change Your
						Life</p>
					<ul class="alt">
						<li><a href="#">Failure will never overtake me if my
								determination to succeed is strong enough.</a></li>
						<li><a href="#">No bird soars too high if he soars with
								his own wings.</a></li>
						<li><a href="#">Things do not happen. Things are made to
								happen.</a></li>
						<li><a href="#">It does not matter how slowly you go as
								long as you do not stop.</a></li>
					</ul>
				</section>
				<section class="4u 6u$(medium) 12u$(small)">
					<h3>Main Purposes Of Website</h3>
					<p>What We and You Do To Change The World.</p>
					<ul class="alt">
						<li><a href="#">Connect People All Over The World.</a></li>
						<li><a href="#">Share Your Experience And Life Problems
								With Others.</a></li>
						<li><a href="#">Get Support and Become Adviser.</a></li>
						<li><a href="#">Help Others, Make People Happy and
								Revived.</a></li>
					</ul>
				</section>
				<section class="4u$ 12u$(medium) 12u$(small)">
					<h3>Contact Us</h3>
					<ul class="icons">
						<li><a href="#" class="icon rounded fa-twitter"><span
								class="label">Twitter</span></a></li>
						<li><a href="#" class="icon rounded fa-facebook"><span
								class="label">Facebook</span></a></li>
						<li><a href="#" class="icon rounded fa-google-plus"><span
								class="label">Google+</span></a></li>
					</ul>
					<ul class="tabular">
						<li>
							<h3>Address</h3> FreeUni<br> Aghmashenebeli Xeivani 11
						</li>
						<li>
							<h3>Mail</h3> <a href="#">gomia13@freeuni.edu.ge</a>
						</li>
						<li>
							<h3>Phone</h3> +995 (598) 721-434
						</li>
					</ul>
				</section>
			</div>
			<ul class="copyright">
				<li>&copy; Untitled. All rights reserved.</li>
				<li>Design: <a href="http://templated.co">GM CORP</a></li>
			</ul>
		</div>
	</footer>

</body>
</html>