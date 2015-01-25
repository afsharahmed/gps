<%@ page session="false" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Print gps</title>
<style>
td {
	border: 1px solid black;
	width: 400px;
	margin: 0;
	padding: 0
}
.r { border-right: 1px solid black; }
#canvasID {
	height: 150px; width: 150px; border: 1px solid #eaeaea;	
}
</style>

<script type="text/javascript">
function init()
{
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

</script>
</head>
<body onload="init();">
	<!-- <form name="input" action="/gps/Print/" method="POST"> -->
	
	<table>
		<tbody>
			<tr><!-- ${visitorObj.visitornumber}  ${visitorObj.date}      -->
				<td><h5>Antsglobe Gate Pass</h5>
					<div style="display: block; float: left;"> &nbsp;&nbsp;Sr No. 0989344403</div>
					<div style="display: block; float: right;">04-12-2014&nbsp;&nbsp;</div>
				</td>
				<td><div style="float: left; height: 150px; width: 50%; background-color: #eaeaea;" >
						<canvas id="canvasID"></canvas> <input type="hidden" name="imageData" id="imageData" value="${imageData}">	
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="4"><div style="float: left; height: 30px; width: 150px;" class="r">Name of visitor:</div> 
					<div style="float: left; height: 30px; width: 50%; text-align: left;">${visitorObj.visitorName}</div></td>
			</tr>
			<tr>
				<td colspan="3"><div style="float: left; height: 30px; width: 150px;" class="r">Contact Address:</div> 
					<div style="float: left; height: 30px; width: 50%; text-align: left;">${visitorObj.address}</div></td>
			</tr>
			<tr>
				<td colspan="4"><div style="float: left; height: 30px; width: 150px;" class="r">Purpose of visit:</div>
					<div style="float: left; height: 30px; width: 50%; text-align: left;">${visitorObj.purpose}</div></td>
			</tr>
			<tr>
				<td colspan="4">
					<div style="float: left; height: 30px; width: 150px;" class="r">Coming From:</div>
					<div style="float: left; height: 30px; width: 50%; text-align: left;">${visitorObj.comingFrom}</div>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<div style="float: left; height: 30px; width: 150px;" class="r">Contact Person:</div>
					<div style="float: left; height: 30px; width: 50%; text-align: left;">${visitorObj.contactPerson}</div>
				</td>
			</tr>
			<tr>
				<td>
				 	<div style="float: left; height: 30px; width: 150px;" class="r">Contact Number:</div> 
					<div style="float: left; height: 30px; width: 150px;">${visitorObj.contactNumber}</div>
				</td>
				<td><div style="float: left; height: 30px; width: 150px;" class="r">Vehicle Number:</div> 
					<div style="float: left; height: 30px; width: 150px;">${visitorObj.vehicleNumber}</div></td>
			</tr>

			<tr>
				<td><div style="float: left; height: 30px; width: 150px;"
						class="r">Time-In:</div> <%-- 				<div style="float:left ; height: 30px;width: 150px; ">${visitorObj.timeIn}</div> --%>
					<div style="float: left; height: 30px; width: 150px;">08:30 AM</div></td>
				<%-- 			<td><div style="float:left ;  height: 30px;width: 150px;"  class="r">Time-Out: ${visitorObj.timeOut}</div> --%>
				<td><div style="float: left; height: 30px; width: 150px;" class="r">Time-Out:</div>
				<div style="float: left; height: 30px; width: 150px;">11:30 AM</div></td>
			</tr>
			<tr>
				<td><div style="float: left; height: 30px; width: 150px;"
						class="r">Helmet-Issued</div></td>
				<td><div style="float: left; height: 30px; width: 150px;"
						class="r">Total visitors:</div> <%-- 			<div style="float:left ; height: 30px;width: 150px; ">${visitorObj.numberOfVisitors}</div> --%>
					<div style="float: left; height: 30px; width: 150px;">3</div></td>
			</tr>

			<tr>
				<td><div style="float: left; height: 100px; width: 50%;">Visitor Signature:</div></td>
				<td><div style="float: left; height: 100px; width: 50%;">Security Signature</div></td>
			</tr>
		</tbody>
		<tr>
			<td colspan="4"><div style="float: left; height: 30px;" class="r">Any Suggestion :</div></td>
		</tr>
		<tr>
			<td colspan="4">Note*: Please return the gate pass at the gate before moving out</td>
		</tr>
	</table>
	<br>
	<input type="button" value="Print this page" onClick="window.print()"> &nbsp;&nbsp;&nbsp; 
	<button onclick="window.location.href='/gps/secure/viewVisitors'">Go to Visitor List</button>
	<button onclick="window.location.href='/gps/secure/home'">Go to Home</button>

</body>
</html>