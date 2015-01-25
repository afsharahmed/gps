<%@ page session="false" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />

<link rel="Shortcut Icon" href="/gps/images/logo_small.png"/>
<link rel="stylesheet" type="text/css" href="/gps/css/common.css" />
<link rel="stylesheet" type="text/css" href="/gps/css/page.css" />
<script type="text/javascript" src="/gps/js/common.js"></script>

<title>Update Visitor Details</title>

<style type="text/css">
#canvasID {
	height: 150px; width: 150px; border: 1px solid #eaeaea;	
}

#videoID {
	height: 400px; width: 400px;
}
.popupContainer {
	position: absolute; height: 100%; width: 100%; top: 0px; left: 0px;	z-index: 100; background-color: #000;
	padding: 0; display: none; opacity: 0.9;
}

.popup {
	position: absolute; height: auto; width: auto; top: 0px; left: 30%;	z-index: 101; /* opacity: 1;  filter: alpha(opacity = 100); */ display: none;
}

.videoContainer {
	width: 500px; margin: 0 auto; margin-top: 20px; padding: 50px;
	border: 1px solid #CCC; text-align: center;
    -webkit-box-shadow: 2px 2px 4px 0px #999999; /* Safari 3-4, iOS 4.0.2 - 4.2, Android 2.3+ */
    box-shadow: 2px 2px 4px 0px #999999; /* Opera 10.5, IE9+, Firefox 4+, Chrome 6+, iOS 5 */
    -webkit-border-radius: 5px;
    border-radius: 5px;
    background-color: #F6F6F6;
    text-shadow: 1px 1px 1px #CCC;
}
</style>

<script type="text/javascript">
function validateForm()
{
	var gatepassnumber = document.getElementById('gatepassnumber').value;
	var visitorname = document.getElementById('nameofvisitor').value;
	var address = document.getElementById('address').value;
	var purpose= document.getElementById('purpose').value;
	/* var comingfrom = document.getElementById('comingfrom').value; */
	var contactperson = document.getElementById('contactperson').value;
	/* var vehiclenumber = document.getElementById('vehiclenumber').value; */
	var contactnumber = document.getElementById('contactnumber').value;
	var timein = document.getElementById('timein').value;
	var numberofvisitor = document.getElementById('numberofvisitor').value;
 	/* var regExAlphaNumeric = new RegExp("^[a-zA-Z0-9]*$");
	var regExAlphaWithSpace = new RegExp("^[a-zA-Z\\s]+$"); */
	if(gatepassnumber.trim().length<=0)
	{
	   alert('Gate Pass Number cannot be blank');
	   return false;
	}
	
	if(visitorname.trim().length<=0)
	{
	   alert('Visitor Name cannot be blank');
	   return false;
	}
	if(address.trim().length<=0)
	{
	   alert('Address cannot be blank');
	   return false;
	}
	if(!contactperson.trim().length)
	{
		alert('Contact person cannot be blank.');
		return false;   
	}
	
	if(!contactnumber.trim().length)
	{
		alert('Contact Number cannot be blank.');
		return false;   
	}
	if(purpose.trim().length<=0)
	{
	   alert('purpose cannot be blank');
	   return false;
	}
	if(timein.trim().length<=0)
	{
	   alert('purpose cannot be blank');
	   return false;
	}
	if(numberofvisitor.trim().length<=0)
	{
	   alert('Number Of visitor cannot be blank');
	   return false;
	}
	return true;
}

</script>

<script type="text/javascript">		
var video;

	function capture() 
	{
		var canvas = document.getElementById('canvasID');
		var context = canvas.getContext('2d');

		context.drawImage(video, 0, 0, canvas.width, canvas.height);
		document.getElementById('imageData').value = canvas.toDataURL();
		
		hideVideoPopup();
	}
/* 	
	function send()
    {
		var canvas = document.getElementById('canvasID');
		var imageData =  canvas.toDataURL();
		var xmlhttp = new XMLHttpRequest();
		xmlhttp.open("POST", "/gps/rec", true);
		xmlhttp.send(imageData);
    }
 */    
	function init()
	{ 		
 		// Set current date
 		var today = new Date();
 		var dd = today.getDate()+""; 		dd = dd.length == 1 ? "0"+dd : dd;
 		var mm = (today.getMonth()+1)+""; 	mm = mm.length == 1 ? "0"+mm : mm;
 		var dateStr = today.getFullYear()+"-"+mm+"-"+dd;
 		
 		var h = today.getHours()+""; 		h = h.length == 1 ? "0"+h : h;
 		var m = today.getMinutes()+""; 	m = m.length == 1 ? "0"+m : m;
 		document.getElementById('date').value = dateStr;
 		document.getElementById('timein').value = h+":"+m;
 		//document.getElementById('date').value = today.getFullYear()+"-"+today.getMonth()+"-"+today.getDate();
 		
 		// Now show photo 
 		var imgData = document.getElementById('imageData').value;
 		var canvas = document.getElementById("canvasID");
 		var context = canvas.getContext("2d");

 		if(imgData)
		{
 			var image = new Image();
 	 		image.src = imgData;
 	 		context.drawImage(image, 0, 0, canvas.width, canvas.height);
		}
 		else
		{
 			context.font = 'normal 16px Arial';
 			context.fillText("Visitor Photo", 70, 70, 150);
		}
 		
 	}

	function hideVideoPopup() 
	{
		document.getElementById('popupContainer').style.display = 'none';
		document.getElementById('popup').style.display = 'none';	
	}
	
	function showVideoPopup() 
	{
		document.getElementById('popupContainer').style.display = 'block';
		document.getElementById('popup').style.display = 'block';
		
		video = document.getElementById('videoID');

		// Make sure the 'window.URL' is not undefined
		window.URL = window.URL || window.webkitURL;
		
		// Make sure the 'navigator.getUserMedia' is not undefined. Since getUserMedia function currently has a different variant for different vendor.
		navigator.getUserMedia = navigator.getUserMedia || navigator.webkitGetUserMedia	|| 
                                 navigator.mozGetUserMedia || navigator.msGetUserMedia;

		// navigator.getUserMedia({video: true}, handleVideo, videoError); where 'handleVideo' & 'videoError' are success/failure callback functions
		// depending on whether you gave your web-browser permission to use your web-cam
		navigator.getUserMedia( {video : true}, 
								function(stream) { video.src = window.URL.createObjectURL(stream); }, 
								function(e) { console.log('Cannot play video: ', e); }
							  );
		
		return false;
	}
</script>
<style type="text/css">
.form_table tr {
	margin-bottom: 5px;
}

.form_table tr > td:FIRST-CHILD {
	min-width: 125px; text-align: left; font: normal 14px Arial;
}

.form_table input[type='text'] { width: 100%; height: 30px; text-indent: 10px;} 
.form_table input[type='number'] { width: 100%; height: 30px; text-indent: 10px;} 
.form_table input[type='date'] { width: 100%; height: 30px; text-indent: 10px;} 
.form_table input[type='radio'] { font: normal 14px Arial;} 
.form_table select { font: normal 14px Arial; height: 35px; }  
</style>

</head>

<body onload="init();">
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
		<form name="input" action="/gps/secure/updateVisitor/" method="POST">
			<input type="hidden" id="visitorID" name="visitorID" value="${visitorObj.visitornumber}">
			<div class="content">
			<br>
				<span style="font: bold 20px Arial;">Update Visitor Details</span><br>
				<fieldset style="border-radius: 8px;background-color: #ffffff; width: 480px; margin-left: 210px; padding-top:20px;"> 
					<table>
						<tr>
							<!-- Left part -->
							<td>
								<table class="form_table">
									<tr>
										<td>Visitor Name:</td>
										<td><input type="text" name="visitorname" id="visitorname" value="${visitorObj.visitorName}" style="width: 250px;" maxlength="20"></td>
									</tr>
									<tr>
										<td>Visitor Type:</td>
										<td>
											 <select name="visitortype" id="type" style="width: 250px;">
												<option value="Resident"<c:if test="${visitorType=='Resident'}"></c:if>>Resident</option>
												<option value="Worker"<c:if test="${visitorType=='Worker'}"></c:if>>Worker</option>
												<option value="Associate"<c:if test="${visitorType=='Associate'}"></c:if>>Associate</option>
											</select> 
										</td>
									</tr>
									<tr>
										<td>Address:</td>
										
										<td><textarea rows="4" cols="32" id="address" name="address" maxlength="60">${visitorObj.address}</textarea></td>
									</tr>
									<tr>
										<td>Purpose of Visit:</td>
										
										<td><input type="text" name="purpose" id="purpose" value="${visitorObj.purpose}" style="width: 250px;" maxlength="20"></td>
									</tr>
									<tr>
										<td>Coming From:</td>
										
										<td><input type="text" name="comingfrom" id="comingfrom" value="${visitorObj.comingFrom}" style="width: 250px;" maxlength="20"></td>
									</tr>
									<tr>
										<td>Contact Person:</td>
										
										<td><input type="text" name="contactperson" id="contactperson" value="${visitorObj.contactPerson}" style="width: 250px;"maxlength="20"></td>
									</tr>
									<tr>
										<td>Contact Number:</td>
										
										<td><input type="text" name="contactnumber" id="contactnumber" maxlength="10" value="${visitorObj.contactNumber}" style="width: 250px;" ></td>
									</tr>
									<tr>
										<td>Vehicle Number:</td>
										
										<td><input type="text" name="vehiclenumber" id="vehiclenumber" maxlength="10" value="${visitorObj.vehicleNumber}" style="width: 250px;"></td>
									</tr>
									<tr>
										<td>Time-In:</td>
										
										<td><input type="text" name="timein" id="timein" value="${visitorObj.timeIn}" style="width: 250px;"maxlength="6"></td>
									</tr>
									<tr>
										<td>Time-Out:</td>
										
										<td><input type="text" name="timeout" id="timeout" value="${visitorObj.timeOut}" style="width: 250px;"maxlength="6"></td>
									</tr>
									
									<tr>
										<td>Helmet-Issued:</td>
										
										<td style="font: normal 14px Arial; text-align: left;">
										<!-- ${helmetIssued=='yes'} -->
											Yes<input type="radio" title="Yes" value="Yes" name="helmetissued">&nbsp;
											No<input type="radio" title="No" value="No" name="helmetissued" checked="checked">
										</td>
									</tr>
									<tr>
										<td>Total Visitors:</td>
										
										<td><input type="number" name="numberofvisitors" id="numberofvisitors" value="${visitorObj.numberOfVisitors}" 
													min="1" max="9" style="width: 250px;" maxlength="10"></td>
									</tr>
									<tr>
										<td>Date:</td>
										
										<td><input type="date" name="date" id="date" style="width: 250px;" value="${visitorObj.date}"></td>
									</tr>
								</table>			
							</td>
							<!-- Right part -->
							<td valign="top">
								<table style="margin-left: 20px;">
									<tr>
										<td><canvas id="canvasID"></canvas> <input type="hidden" name="imageData" id="imageData" value="${imageData}"> </td>
									</tr>									
									<tr>
										<td><button onclick="return showVideoPopup();">Show Video</button></td>
									</tr>
								</table>
							
							</td>
						</tr>
					</table>
				</fieldset>
				
				<div style="width: 200px; margin: 0 auto; margin-top: 20px;">
					 <input type="submit" value="Submit" class="action_button" >
					 <input type="reset" value="Reset" class="action_button">
				</div> 
			</div>
		</form>
	</div>

	<div class="footer full-width">
		<div class="footer-left">©2014 Antsglobe Technologies. All rights reserved.&nbsp;&nbsp; <a href="./main-panel.html">Privacy Policy</a>&nbsp; |&nbsp; <a href="./main-panel.html">Disclaimer</a></div>
		<div class="footer-right">Powered by <b>AntsGlobe Technologies</b></div>		
	</div>
	
	<div class="popupContainer" id="popupContainer">
		<div class="popup" id="popup">
			<div class="videoContainer">
				<div>
					<video id="videoID" autoplay></video>
				</div> 
				<div> 
					<input type="button" value="Take photo" onclick="capture();" style="width: 200px; height: 30px;"/> 
					<input type="button" value="Cancel" onclick="hideVideoPopup();" style="width: 200px; height: 30px;"/> 
				</div>
			</div>
		</div>
	</div>

</body>
</html>