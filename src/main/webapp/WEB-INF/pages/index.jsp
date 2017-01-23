<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<style type="text/css">
	div, p {margin:0px; padding:0px;}

	#container {
		width:100%;
		height:75%;
		position:fixed;
	}
	#top {height:5%;}
	#middle {height:95%;}

	button {width:100%;height:25%;}
</style>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>My home access controller</title>
</head>
<body>

	<div id="container">
		<div id="top">
			<%--If Admin user -  show admin panel link--%>
			<c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN') == true}">
				<h2>
						<form action="/admin">
							<input type="submit" value="Admin panel">
						</form>
				</h2>
			</c:if>

			<%--If anonymus -  show login link and registration form--%>
			<c:if test="${pageContext.request.userPrincipal.name == null}">
				<a href="/login">LogIn</a>
			</c:if>

		</div>

		<div id="middle">
			<%--If logged in - show logout button and access control buttons--%>
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<h3>Welcome : ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/logout" />" > Logout</a></h3>
				<%--This is the page to control all the access points--%>
				<jsp:include page="IndexPageMainBody.jsp"/>
			</c:if>
		</div>
	</div>
</body>
</html>