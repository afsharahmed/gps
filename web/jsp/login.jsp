<%@ page session="false" import = "java.util.Enumeration;"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />

<link rel="shortcut icon" type="" 		  href="../images/logo_small.png"/>
<link rel="stylesheet"	  type="text/css" href="../css/login.css" />
<link rel="stylesheet"	  type="text/css" href="../css/theme/theme-basic.css" />
</head>
<body>
	<div class="login-header full-width"><img alt="" src="../images/logo-login.png" style="height: 90px; width: 200px;"></div>
	<div class="login-header-bottom full-width"></div>
	
	<div class="page-container">
	<form name="input" action="<c:url value="/loginProcess" />" method="POST"> 
		<div class="login-form">		
			<div class="login-form-label"><strong>Admin Login</strong></div>
			<br>
			<div class="login-form-text"><strong>User Name</strong></div>
			<div class="login-form-input"><input type="text" name="j_username" id="username" maxlength="40" value="${SPRING_SECURITY_LAST_USERNAME}" autofocus></div>
			<br>
			<div class="login-form-text"><strong>Password</strong></div>
			<div class="login-form-input"><input type="password" name="j_password" id="password" maxlength="16" value=""></div>
			<br>
			<div class="login-form-button">
				<input type="submit" value="Login" class="login-form-button">
				<input type="reset" value="Reset" class="login-form-button">
				<span style="cursor: pointer;"><strong>Forgot Password?</strong></span>			
			</div>
			<br>
			<!-- 
			<div class="login-form-button">
				<input type="checkbox" name="_spring_security_remember_me" id="remember_me" />
				<label for="remember_me" style="text-decoration: none; cursor: pointer; font: normal 15px Arial;"><strong>Remember me</strong></label>
			</div> -->				
		</div>
		
		<!-- ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} -->
		<c:if test="${not empty param.login_error}">
			<div class="error-msg">Invalid credentials</div>
		</c:if>
		<c:if test="${not empty param.logged_out}">
			<div class="msg">You have logged out successfully.</div>
		</c:if>
	</form>	
	</div>
	
	<div class="login-footer full-width">
		<div class="footer-left">©2014 <b>Antsglobe Technologies.</b> All rights reserved.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
			<a style="color: #fff;" href="./main-panel.html">Privacy Policy</a>&nbsp; |&nbsp; 
			<a style="color: #fff;" href="./main-panel.html">Disclaimer</a>
			
		</div>
		<%-- <div>
			<c:forEach var="par" items="${paramValues}">${par.key} = ${par.value[0]};</c:forEach>
		</div> --%>
	</div>
</body>
</html>