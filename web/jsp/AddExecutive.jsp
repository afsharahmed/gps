<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />

<link rel="Shortcut Icon" href="/gps/images/logo_small.png"/>
<link rel="stylesheet" type="text/css" href="/gps/css/common.css" />
<link rel="stylesheet" type="text/css" href="/gps/css/page.css" />
<script type="text/javascript" src="/gps/js/common.js"></script>
<title>Add Executive</title>

<script type="text/javascript">
function validateForm()
{
	var username = document.getElementById('username').value;
	var password = document.getElementById('password').value;
	var password2 = document.getElementById('password2').value;
	var firstname = document.getElementById('firstname').value;
	var lastname = document.getElementById('lastname').value;
	var address = document.getElementById('address').value;
	var mobile = document.getElementById('mobile').value;
 	var regExAlphaNumeric = new RegExp("^[a-zA-Z0-9\\s]*$");
	var regExAlphaWithSpace = new RegExp("^[a-zA-Z\\s]+$");
		
	if(regExAlphaNumeric.test( username )!= true)
	{
		alert("Only Alphabet and number can be used. No special characters.");
		return false;
	} 
	
	if(regExAlphaWithSpace.test( firstname )!= true)
	{
		alert("Only Alphabet can be used in firstname");
		return false;
	}
	
// 	if(regExAlphaWithSpace.test( lastname )!= true)
// 	{
// 		alert("Only Alphabet can be used in lastname");
// 		return false;
// 	}
	 if(!password.trim().length)
	{
		alert('Password cannot be blank.');
		return false;
	}
	
	if(!password2.trim().length)
	{
		alert('Password confirmation input cannot be blank.');
		return false;   
	}
	if(password.trim() != password2.trim())
	{
		alert('Password values do not matah.');
		return false;
	} 
	if(mobile.trim().length!=10)
	{
	  alert('Invalid mobile number');
	  return false;
	}
	if(firstname.trim().length<=0)
	{
	   alert('first name cannot be blank');
	   return false;
	}

	return true;
}

</script>

<style type="text/css">
*{font-family: Arial;}
.leftColumn { width: 28%; /* background-color:#f0f0f0; */ border-radius: 8px; color: #444444 ; float: left; text-align: left; font-size: 14px;
				padding-top:8px; padding-left:5px; 
}
.rightColumn { width:  62%; float: left; border-radius: 12px; text-align: left; text-indent: 20px;padding-bottom: 20px;height: 30px;}
.rightColumn > input { width: 80%; height: 30px; text-indent: 10px;}
</style>

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
		<form name="input" action="/gps/secure/addExecutive/" method="POST" onsubmit="return validateForm();">
			<div class="content">
			<br>
				<span style="font: bold 20px Arial;">Add Executive</span>
				
				<h2>${errorMessage}</h2>
			
				<fieldset style="border-radius: 8px;background-color: #ffffff; width: 480px; margin-left: 210px; padding-top:20px;">
					<div class="leftColumn">User Name:* </div>
					<div class="rightColumn"><input type="text" name="username" id="username" maxlength="30"></div><br>
					<div style="clear: both;"></div>
					
					<div class="leftColumn">Password:* </div>
					<div class="rightColumn"><input type="password" name="password" id="password" maxlength="15"></div><br>
					<div style="clear: both;"></div>
					
					<div class="leftColumn">Confirm Password:* </div>
					<div class="rightColumn"><input type="password" name="password2" id="password2" maxlength="15"></div><br>
					<div style="clear: both;"></div>
					
					<div class="leftColumn">First name:* </div>
					<div class="rightColumn"><input type="text" name="firstname" id="firstname" maxlength="30"></div><br>
					<div style="clear: both;"></div>
					
					<div class="leftColumn">Last name: </div>
					<div class="rightColumn"><input type="text" name="lastname" id="lastname" value="" maxlength="30"></div><br>
					<div style="clear: both;"></div>
					
					<div class="leftColumn">Date Of Birth:* </div>
					<div class="rightColumn"><input type="date" name="dob" value=""></div><br> <!-- 1984/12/10 -->
					<div style="clear: both;"></div>
					
					<div class="leftColumn">Gender: </div>
					<div class="rightColumn">
						<table>
							<tr style="font: normal 14px Arial; text-align: left;">
							<td><input type="radio" name="gender" value="1" checked="checked">Male</td>
							<td><input type="radio" name="gender" value="2" >Female</td>
							<td><input type="radio" name="gender" value="3" >Trans-Gender</td>
							</tr>
						</table><br>
					</div>
					<div style="clear: both;"></div>
					
					<div class="leftColumn">Mobile No.*:</div>
					<div class="rightColumn"><input type="tel" name="mobile" id="mobile" value="" maxlength="10"></div><br> <!-- 9890434401 -->
					<div style="clear: both;"></div>
					
					
					<div class="leftColumn">Address: </div>
					<div class="rightColumn"><textarea rows="2" cols="36"  name="address" id="address" maxlength="200"></textarea> </div><br>
					<div style="clear: both;"></div>
				
				</fieldset>
				<div class="login_button_container" style="margin-top: 10px; margin-left: -20px;">
					<input type="submit" value="Submit" class="action_button"  onsubmit="return validateForm();"> <input type="reset" value="Reset" class="action_button">
				</div> 
				
			</div>
		</form>
	</div>

	<div class="footer full-width">
		<div class="footer-left">©2014 Antsglobe Technologies. All rights reserved.&nbsp;&nbsp; <a href="./main-panel.html">Privacy Policy</a>&nbsp; |&nbsp; <a href="./main-panel.html">Disclaimer</a></div>
		<div class="footer-right">Powered by <b>AntsGlobe Technologies</b></div>		
	</div>

</body>
</html>