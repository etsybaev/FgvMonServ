<%@ page import="com.fgvmonserv.BaseTableNamesEnum" %>

<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="<c:url value="/resources/script/jquery-1.11.1.js" />"></script>
<script src="<c:url value="/resources/script/keepServerAlive.js" />"></script>

<style type="text/css">
    @import "/resources/css/sortableTable.css";
</style>

<%--reload page every 5 seconds--%>
<meta http-equiv="Refresh" content="5">

<html>
<head>
    <title>Import/export files</title>
</head>
<body style="background-color: #f0f4ce">

        <div style="border-bottom: solid">
            <p><a href="/">Back to main menu</a></p>


        <c:if test="${!empty message}">
            <h2 style="color:red">${message}</h2>
        </c:if>


            <p><a href="/">Back to main menu</a></p>

        </div>
</body>
</html>
