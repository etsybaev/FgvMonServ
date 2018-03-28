<%@ page import="com.fgvmonserv.BaseTableNamesEnum" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<script src="<c:url value="/resources/script/jquery-1.11.1.js" />"></script>
<script src="<c:url value="/resources/script/keepServerAlive.js" />"></script>
<script src="<c:url value="/resources/script/delConfirm.js" />"></script>

<style type="text/css">
    @import "/resources/css/sortableTable.css";

    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
    }
</style>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Monserv</title>
</head>
<body style="background-color: #f0f4ce">

<div id="container">
	<%--<div id="left" style="display: inline-flex">--%>
	<%--aaaa--%>
	<%--</div>--%>
	<%--<div id="right" style="display: inline-flex">--%>
	<%--sdfsdf--%>
	<%--</div>--%>

	<div id="left" style="display: inline-block">
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

				<h3 style="text-shadow: 2px 2px 2px #1C6EA4;">
                    Welcome : ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/logout" />" > Logout</a>
                </h3>
			</c:if>
		</div>

		<div id="globalSerach">
			<form action="/">
				Search through all database:<br>
				<input type="text" name="searchForText">
				<input type="submit" value="Search">
			</form>
		</div>
	</div>

    <%--if it's admin user then we will have one more reminder, so indentation should be smaller--%>
    <%--this is cheat to move a bit divs below, have no idea how to it with ccs and no time to identify now--%>
    <c:choose>
        <c:when test="${pageContext.request.isUserInRole('ROLE_ADMIN') == true}">
            <div style="display: inline-block; width: 55px"></div>
        </c:when>
        <c:otherwise>
            <div style="display: inline-block; width: 370px"></div>
        </c:otherwise>
    </c:choose>

    <c:if test="${remindersList != null && remindersList.size() > 0}">
        <div id="right" style="display: inline-block; border: double; width: 450px;">
            <p style="color: #dc090d" align="center">Deals for you to check today:</p>
            <div style="height: 150px; overflow-y: scroll">
                <table class="sortable table table_div_trim blueTable" id="sortableTable1">
                    <thead>
                    <tr>
                        <th class="<%=BaseTableNamesEnum.ID.getDbName()%>"><%=BaseTableNamesEnum.ID.getViewName()%></th>
                        <th class="<%=BaseTableNamesEnum.REMINDER_TEXT.getDbName()%>"><%=BaseTableNamesEnum.REMINDER_TEXT.getViewName()%></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${remindersList}" var="remindersList">
                        <tr ondblclick="openEditPage(${remindersList.id})">
                            <td title="${remindersList.id}"><div>${remindersList.id}</div></td>
                            <td title="${remindersList.reminderText}"><div>${remindersList.reminderText}</div></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </c:if>

    <%--this block is supposed to be shown for admins only. Show all missed reminders till today--%>
    <c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN') == true && missedRemindersList != null && missedRemindersList.size() > 0}">
        <div id="right" style="display: inline-block; border: double; width: 550px;">
            <p style="color: #dc090d" align="center">All deals till today:</p>
            <div style="height: 150px; overflow-y: scroll">
                <table class="sortable table table_div_trim blueTable" id="sortableTable2">
                    <thead>
                        <tr>
                            <th class="<%=BaseTableNamesEnum.ID.getDbName()%>"><%=BaseTableNamesEnum.ID.getViewName()%></th>
                            <th class="<%=BaseTableNamesEnum.MANAGER.getDbName()%>"><%=BaseTableNamesEnum.MANAGER.getViewName()%></th>
                            <th class="<%=BaseTableNamesEnum.REMINDER_TEXT.getDbName()%>"><%=BaseTableNamesEnum.REMINDER_TEXT.getViewName()%></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${missedRemindersList}" var="missedReminder">
                            <tr ondblclick="openEditPage(${missedReminder.id})">
                                <td title="${missedReminder.id}"><div>${missedReminder.id}</div></td>
                                <td title="${missedReminder.manager.firstName}"><div>${missedReminder.manager.firstName}</div></td>
                                <td title="${missedReminder.reminderText}"><div>${missedReminder.reminderText}</div></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </c:if>

	<div id="middle1">
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<jsp:include page="IndexPageMainBody.jsp"/>
		</c:if>
	</div>

</div>
</body>
</html>