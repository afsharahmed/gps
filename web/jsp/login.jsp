<%@ page session="false" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />

<link rel="shortcut icon" type="" 		  href="images/logo_small.png"/>
<link rel="stylesheet"	  type="text/css" href="css/login.css" />
</head>
<body>
	
<%-- 	<c:url value="/secure/home" var="loginUrl"/> --%>
	

	<div class="login-header full-width"><img alt="" src="images/logo-login.png" style="height: 90px; width: 200px;"></div>
	<div class="login-header-bottom full-width"></div>
	
	<div class="page-container">
	<form name="input" action="auth" method="POST"> 
		<div class="login-form">		
			<div class="login-form-label"><strong>Admin Login</strong></div>
			<br>
			<div class="login-form-text"><strong>User Name</strong></div>
			<div class="login-form-input"><input type="text" name="username" id="username" maxlength="40" autofocus></div>
			<br>
			<div class="login-form-text"><strong>Password</strong></div>
			<div class="login-form-input"><input type="password" name="password" id="password" maxlength="16"></div>
			<br>
			<div class="login-form-button">
				<input type="submit" value="Login" class="login-form-button">
				<input type="reset" value="Reset" class="login-form-button">
				<span style="cursor: pointer;"><strong>Forgot Password?</strong></span>			
			</div>			
		</div>
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
			
	</form>	
	</div>
	
	<div class="login-footer full-width">
		<div class="footer-left">©2014 <b>Antsglobe Technologies.</b> All rights reserved.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
			<a style="color: #fff;" href="./main-panel.html">Privacy Policy</a>&nbsp; |&nbsp; 
			<a style="color: #fff;" href="./main-panel.html">Disclaimer</a>
			
		</div>
<!-- 		<div class="footer-right"></div>		 -->
	</div>
</body>
</html>