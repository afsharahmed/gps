<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/errorPage.css" rel="stylesheet" type="text/css" media="all">
</head>
<body>
<!-- 	<fmt:setBundle basename="resourcebundle.application"/> -->
	<!-- To show any default error message -->
	<div class="div4">
		<spring:message code="message.error.default"/>
<!-- 		<fmt:message key="message.error.default"/> -->
	</div>
</body>
</html>
