<%@ page session="false" %> 
<!DOCTYPE html >
<html>
<head>

<title>Executive Login</title>
<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1 " />
<link rel="stylesheet" type="text/css" href="../css/Login.css" />
<link rel="stylesheet" type="text/css" href="../css/common.css" />

<style type="text/css">
.leftColumn {
	width: 40%;
	background-color: #f0f0f0;
	color: #444444;
	float: left;
	text-align: left;
	padding-top: 8px;
	height: 30px;
}

.rightColumn {
	width: 100%;
	float: left;
	text-align: left;
	text-indent: 20px;
	padding-bottom: 20px;
	height: 30px;
	padding-left: 50px;
	padding-right: 100px;
	font-size: 16px;
	font-size: 16px;
}

.rightColumn>input {
	width: 40%;
	height: 30px;
	border-radius: 4px;
	border-color: #54aaec;
	border-width: thin;
	padding-left: 10px;
}

.button {
	background-color: #54aaec;
	width: 70px;
	height: 28px;
	color: #fff;
	border-radius: 4px;
	border: 1px solid #3333ff;
	font: bold 14px Arial;
	margin-left: 68px;
	margin-top: 50px;
	padding-right: 2px;
	padding-top: 10px;
	padding-left: 10px;
}

.button:visited: {
	color: #666666
}

.button:hover {
	background-color: #cddbea;
	text-decoration: none;
}

.text {
	margin-left: 250px;
	height: 28px;
	width: 200px;
	position: absolute;
	top: 315px;
	left: 300px;
	font-size: 14px;
	color: #2ba4de;
}

.text:visited {
	color: #666666;
}

.text:hover {
	color: #2ba4de;
}

</style>

</head>

<body>
	<input type="hidden" id="msg" name="msg">
	<form name="input" action="/gps/executiveLogin/" method="POST">
		<div class="bannerarea">
			<div class="container">
				
				<div class="toplogo">
					<img src="../images/antsglobe-logo.png" border="0" />
				</div>
				<div style="clear: both;"></div>
			</div>
		</div>

		<div class="contentArea" style="padding: 5% 0 0 0;">
		
				<!-- InstanceBeginEditable name="content" -->
				<fieldset style="border-color: #f4ffff; border-radius: 4px; width: 50%; margin-left: 100px;">
					<div class="contentcentre">

						<h3>Executive Log In</h3>
						<h2 style="color: red;"> In correct User Name Or Password!!!</h2>
						<div class="rightColumn">
							<input type="text" name="username" id="username" maxlength="30" placeholder="Username" value="">
						</div>
						<br>
						<div style="clear: both;"></div>

						<div class="rightColumn">
							<input type="password" name="password" id="password" maxlength="30" placeholder="Password" value="">
						</div>
						
						<br>
						<div class="action_button_container" >
							<input type="submit" value="Submit" class="action_button"> <input type="reset" value="Reset" class="action_button">
							<a href="jsp/RegisterationPage.jsp" style="margin-left: 10px;">forgot password?</a>
						</div> 
						
						<!-- <div class="button">Sign In</div> -->
						<div class="text">
							
						</div>
						<br>


						<div class="contentbottom">
							New User?<a href="jsp/AddExecutive.jsp">Register Now >></a><br>
						</div>
					</div>
				</fieldset>
			
		</div>

		<div class="footerArea">
			<div class="container" style="background-color: #cfcfcf;">
				<div class="copyright">
					&copy; 2014 Our Company. All rights reserved.&bull; 
					<!-- <a
						href="jsp/privacypolicy.jsp">Privacy Policy</a> &bull; <a
						href="jsp/ContactUs.jsp">Contact Us</a> &bull; <a
						href="/MilesOnMap/feedback/">FeedBack</a> &bull;
 -->
				</div>
			</div>
		</div>


	</form>

</body>
</html>
