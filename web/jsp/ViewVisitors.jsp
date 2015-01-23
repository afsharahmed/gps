<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<title>View Visitor</title>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />

<link rel="Shortcut Icon" href="/gps/images/logo_small.png"/>
<link rel="stylesheet" type="text/css" href="/gps/css/common.css" />
<link rel="stylesheet" type="text/css" href="/gps/css/page.css" />
<script type="text/javascript" src="/gps/js/common.js"></script>

<style type="text/css" title="currentStyle">
			@import "/gps/css/jqueryDataTable/demo_page.css";
			@import "/gps/css/jqueryDataTable/jquery.dataTables_themeroller.css";
			@import "/gps/css/jqueryDataTable/jquery-ui-1.8.4.custom.css";
</style>
		
<script type="text/javascript" src="/gps/js/jquery.js"></script>
<script type="text/javascript" src="/gps/js/jqueryDataTable/jquery.dataTables.js"></script>
<script type="text/javascript">

var lastRowEl;
var lastVisitor;

//Function to populate list
function populateTable() 
{
	var listTable = $('#table_list').dataTable();
	listTable.fnSort( [ [0,'desc'] ] );  // 'asc' will sort in ascending order
}

function selectRow(elem)
{
	if(lastRowEl) // If lastRow element is undefined -- In case of first time user click
	lastRowEl.style.backgroundColor = "";
	
	var rowEl = elem.parentElement; // HTML Table Row element 	
	rowEl.style.backgroundColor = "#AAEAFA";
	
	lastVisitor = elem;
	lastRowEl = rowEl;
}

function updateRow()
{
	if(lastVisitor)
	{
		document.getElementById('visitorID').value = lastVisitor.innerHTML; // This is the TD element that has the visitor record's id
		document.getElementById('hiddenForm').action = "getVisitorDetails/";
		document.getElementById('hiddenForm').submit();	
	}
	else
		alert("Please select a record to update.");
}

function deleteRow()
{
	if(lastVisitor)
	{
		if(confirm("Are you sure you want to delete this record?"))
		{
			document.getElementById('visitorID').value = lastVisitor.innerHTML; // This is the TD element that has the visitor record's id
			document.getElementById('hiddenForm').action = "deleteVisitor/";
			document.getElementById('hiddenForm').submit();
		}
			
	}
	else
		alert("Please select a record to update.");
}
</script>
<style type="text/css">
#table_list > table, #table_list td, #table_list th
{
border:1px solid black;
}

#table_list  th { font: bold 15px calibri; }
#table_list  td { font: normal 14px calibri; }

</style>

</head>

<body onload="populateTable();">
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
					<td width="100px;"><img src="/gps/images/themes/basic/back.jpg" alt="Place holder"  onclick="nav('home');" style="cursor: pointer;"></td>
				</tr>
			</tbody>	
		</table>
		<img src="/gps/images/themes/basic/page-top-border-bottom.jpg" id="Image5" alt="" style="width:960px; height:9px;">
		<table class="page" style="width: 100%; font: normal 16px Arial; margin-top: 20px;">
			<tbody>
				<tr>
					<td width="100%;" style="margin: auto;">
					
						
						<div style="width: 90%; margin: 0 auto;">
							<div style="margin: 0 auto; text-align: center; font: bold 18px Arial;"><br>Visitor List</div>
							<%-- <div style="height: 20px; line-height: 20px; color:#444;">${viewVisitorPageMessage}</div> --%>
							<div id="empty_list" style="height: 20px; line-height: 20px; color:#444; display: none;">No items found in DB</div>
				
							<table class="list_table" id="table_list">
								<thead>
									<tr style="color: #f4f4f4;">
										<th width="100px;">Visitor Id</th>
										<th width="150px;">Name</th>
										<th width="50px;">Type</th>
<!-- 										<th width="150px;">Address</th> -->
										<th width="50px;">Purpose</th>
<!-- 										<th width="100px;">Coming From</th> -->
										<th width="150px;">Contact Person</th>
<!-- 										<th width="100px;">Contact Number</th> -->
<!-- 										<th width="150px;">Vehicle Number</th> -->
										<th width="70px;">Time-In</th>
										<th width="70px;">Time-Out</th>
										<th width="50px;">Total Visitors</th>
										<th width="50px;">Helmet Issued</th>
										<th width="100px;">Date</th>
									</tr>
								</thead>
					
								<tbody class="list_table_body" id="table_list_body">
									<c:forEach items="${visitors}" var="v">
										<tr> <!-- updateVisitor(this); -->
											<td onclick="selectRow(this);" style="cursor: pointer;">${v.visitornumber}</td>
											<td>${v.visitorName}</td>
											<td>${v.visitorType}</td>
<%-- 											<td>${v.address}</td> --%>
											<td>${v.purpose}</td>
<%-- 											<td>${v.comingFrom}</td> --%>
											<td>${v.contactPerson}</td>
<%-- 											<td>${v.contactNumber}</td> --%>
<%-- 											<td>${v.vehicleNumber}</td> --%>
											<td>${v.timeIn}</td>
											<td>${v.timeOut}</td>
											<td>${v.numberOfVisitors}</td>
											<td>${v.helmetIssued}</td>
											<td>${v.date}</td>									
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					
						<div align="center" style="clear: both; height: 50px; width: auto; padding: 20px 0px 5px 0px;" >
							<button class="button_" onclick="window.location.href='/gps/jsp/AddVisitor.jsp';"title="To add new visitor">Add New Visitor</button>
							<button class="button_" style="margin-left: 20px;" onclick="updateRow();" title="Updates selected visitor's record">Update</button>
							<button class="button_" style="margin-left: 20px;" onclick="deleteRow();"title="Delete selected visitor's record">Delete</button>
						</div>		
						
					</td>
				</tr>
			</tbody>	
		</table>
		
		
		<form action="/gps/logout" method="POST" id="logoutForm">
			<input type="hidden" name="csrfToken" value="" />
		</form>
		<form action="" id="hiddenForm" method="POST" >
			<input type="hidden" name="visitorID" id="visitorID">
			<input type="hidden" id="msg" name="msg">
		</form> 
	</div>
	
	<div class="footer full-width">
		<div class="footer-left">©2014 Antsglobe Technologies. All rights reserved.&nbsp;&nbsp; <a href="./main-panel.html">Privacy Policy</a>&nbsp; |&nbsp; <a href="./main-panel.html">Disclaimer</a></div>
		<div class="footer-right">Powered by <b>AntsGlobe Technologies</b></div>		
	</div>


</body>
</html>
