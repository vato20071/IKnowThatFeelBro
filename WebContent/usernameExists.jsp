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
				<li><a href="learnMore.jsp">Learn More</a></li>
				<li><a href="contactUs.jsp">Contact Us</a></li>
			</ul>
		</nav>
	</header>

	<!-- Banner -->
	<section id="banner">
		<div class="try" >
			<h2>Username Already Taken. Please Choose Another One<br></h2>
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

</body>
</html>