<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Monserv</title>
</head>
<body style="background-color: #f0f4ce">

	<div id="container"  style="overflow-scrolling:auto">
		<div id="top">
			<%--If Admin user -  show admin panel link--%>
			<c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN') == true}">
				<form action="/admin/">
					<input type="submit" value="Admin panel">
				</form>
			</c:if>


			<%--If anonymus -  show login link and registration form--%>
			<c:if test="${pageContext.request.userPrincipal.name == null}">
				<div class="intro-header" >
					<a href="/login"><img src="/resources/img/login-button.png" style="width:250px;height:110px;"/></a>
						<%--<a href="/login">LogIn</a>--%>
				</div>
			</c:if>

		</div>

		<div id="middle">
			<%--If logged in - show logout button and access control buttons--%>
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<%--Show import/export DB button--%>
				<form action="/importexport">
					<input type="submit" value="Import/Export database">
				</form>

				<h3>Welcome : ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/logout" />" > Logout</a></h3>
                <p style="border: double"></p>
				<%--This is the page to control all the access points--%>
				<jsp:include page="IndexPageMainBody.jsp"/>
			</c:if>
		</div>
	</div>
</body>
</html>