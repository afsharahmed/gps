<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Protected Page</title>
</head>
<body>
	Hello <%= request.getUserPrincipal()%>
	You are able to view this page because you are authenticated user.
</body>
</html>

