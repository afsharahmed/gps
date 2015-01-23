<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Home</title>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />

<link rel="Shortcut Icon" href="images/logo_small.png"/>
<link rel="stylesheet" type="text/css" href="/gps/css/common.css" />
<link rel="stylesheet" type="text/css" href="/gps/css/page.css" />
<script type="text/javascript" src="/gps/js/common.js"></script>
</head>

<body>
	<div class="header full-width">
		<div class="header-left"></div>
		<div class="header-right">
			<div class="header-right-top">
				<div style="width: 100px; height: 100%; float: right;"></div>
				<div class="header-link" style="padding-bottom: 3px; padding-top: 1px;">
					<table onclick="document.getElementById('logoutForm').submit();">						
						<tr>
							<td><img height="20px" width="20px" src="/gps/css/theme/header-logout.png"></td>
							<td>Logout</td>
						</tr>						
					</table>
				</div>
				<div class="header-link" style="padding-bottom: 3px; padding-top: 1px;">
					<table>
						<tr><td><img height="22px" width="22px" src="/gps/css/theme/header-settings.png"></td><td>Contact us</td></tr>						
					</table>
				</div>
				<div class="header-link" style="padding-top: 4px;">
					<table>
						<tr><td><img height="16px" width="22px" src="/gps/css/theme/header-feedback.png"></td><td>Feedback</td></tr>						
					</table>
				</div>
			</div>
			<div class="header-right-bottom"><img height="27px" width="332px" src="/gps/css/theme/header-app-name.png"></div>
		</div>
	</div>
	
	<div class="page-container">
	
		<!-- #######################  ######################## -->
		
		<table class="page-top" style="">
			<tbody>
				<tr>
					<td width="100px;"><img src="/gps/images/themes/basic/logo-administrator.png"></td>
					<td width="760px;">
						<div style="color: #3473B7; font: normal 24px Arial;"><strong>Administrator</strong></div><div style="color: #FF6820; font: normal 16px Arial;"><strong>Home</strong></div>
					</td>
					<td width="100px;"><!-- <img src="/gps/images/themes/basic/back.jpg" alt="Place holder"> --></td>
				</tr>
			</tbody>	
		</table>
		<img src="/gps/images/themes/basic/page-top-border-bottom.jpg" id="Image5" alt="" style="width:960px; height:9px;">
		<table class="page" style="width: 100%; font: normal 16px Arial; margin-top: 20px;">
			<tbody>
				<tr style="height: 25px;"><td></td><td></td></tr>
				<tr>
					<td width="50%;" style="margin: auto; padding-left: 15%;">
						<div class="page-links" style="color: #FF6820; cursor: pointer;" onclick="nav('/gps/jsp/AddExecutive.jsp');"><strong><u>Add Executive</u></strong></div>
						<div class="page-links" style="color: #2F4F4F;"><strong>Add Executive for GPMS.</strong></div>
					</td>
					
					<td width="50%;" style="margin: auto;">
						<div class="page-links" style="color: #FF6820; cursor: pointer;" onclick="nav('viewExecutives');"><strong><u>View All Executives</u></strong></div>
						<div class="page-links" style="color: #2F4F4F;"><strong>View All Executive for GPMS.</strong></div>
					</td>
				</tr>
				<tr style="height: 25px;"><td></td><td></td></tr>
				<tr>
					<td width="50%;" style="margin: auto; padding-left: 15%;">
						<div class="page-links" style="color: #FF6820; cursor: pointer;" onclick="nav('/gps/jsp/AddVisitor.jsp');"><strong><u>Add Visitor</u></strong></div>
						<div class="page-links" style="color: #2F4F4F;"><strong>Add Visitor for a day.</strong></div>
					</td>
					
					<td width="50%;" style="margin: auto;">
						<div class="page-links" style="color: #FF6820; cursor: pointer;" onclick="nav('viewVisitors');"><strong><u>View All Visitors</u></strong></div>
						<div class="page-links" style="color: #2F4F4F;"><strong>View the entire Visitor List for a day.</strong></div>
					</td>
				</tr>
				<tr style="height: 25px;"><td></td><td></td></tr>
				<tr>
					<td width="50%;" style="margin: auto; padding-left: 15%;">
						<div class="page-links" style="color: #FF6820; cursor: pointer;" onclick="alert('Page under construction.');//nav('printGatePass');"><strong><u>Print Gate Pass</u></strong></div>
						<div class="page-links" style="color: #2F4F4F;"><strong>Print Gate Pass for all Visitors.</strong></div>
					</td>
					
					<td width="50%;" style="margin: auto;"></td>
				</tr>
			</tbody>	
		</table>
		
		
		<form action="/gps/logout" method="POST" id="logoutForm">
			<input type="hidden" name="csrfToken" value="" />
		</form> 
	</div>
	
	<div class="footer full-width" style="position:absolute; bottom:0; left:0;">
		<div class="footer-left">©2014 Antsglobe Technologies. All rights reserved.&nbsp;&nbsp; <a href="./main-panel.html">Privacy Policy</a>&nbsp; |&nbsp; <a href="./main-panel.html">Disclaimer</a></div>
		<div class="footer-right">Powered by <b>AntsGlobe Technologies</b></div>		
	</div>
	<%-- 
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<tr>
			<td><img height="20px" width="20px" src="css/theme/header-logout.png"></td>
			<td>Logout</td>
		</tr>
	</c:if>
	 --%>
	 		
</body>
</html>