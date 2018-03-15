<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<script src="<c:url value="/resources/script/jquery-1.11.1.js" />"></script>
<script src="<c:url value="/resources/script/keepServerAlive.js" />"></script>

<html>
<head>
  <title>UserData</title>

  <style type="text/css">
    .tg {
      border-collapse: collapse;
      border-spacing: 0;
      border-color: #ccc;
    }

    .tg td {
      font-family: Arial, sans-serif;
      font-size: 14px;
      padding: 10px 5px;
      border-style: solid;
      border-width: 1px;
      overflow: hidden;
      word-break: normal;
      border-color: #ccc;
      color: #333;
      background-color: #fff;
    }

    .tg th {
      font-family: Arial, sans-serif;
      font-size: 14px;
      font-weight: normal;
      padding: 10px 5px;
      border-style: solid;
      border-width: 1px;
      overflow: hidden;
      word-break: normal;
      border-color: #ccc;
      color: #333;
      background-color: #f0f0f0;
    }

    .tg .tg-4eph {
      background-color: #f9f9f9
    }
  </style>

</head>
<body>

<div style="background-color: #f0f4ce">
  <h1>User Details</h1>

  <table class="tg">
    <tr>
      <th width="80">ID</th>
      <th width="120">First name</th>
      <th width="120">Last name</th>
      <th width="120">Phone number</th>
      <th width="120">Is enabled</th>
      <th width="120">User role</th>
      <th width="120">Created</th>
      <th width="120">Updated</th>
    </tr>
    <tr>
      <td>${user.id}</td>
      <td>${user.firstName}</td>
      <td>${user.lastName}</td>
      <td>${user.contactPhoneNumber}</td>
      <td>${user.enabled}</td>
      <td>${user.userRoles.role}</td>
      <td>${user.createdtime}</td>
      <td>${user.updatedtime}</td>
    </tr>
  </table>

  <br>
  <br>

  <h1>Here could be some user's activity details</h1>

  <%--<c:choose>--%>
    <%--<c:when test="${!empty accessHistoryList}">--%>
      <%--<table class="tg">--%>
        <%--<tr>--%>
          <%--<th width="120">Access point</th>--%>
          <%--<th width="120">Date and time</th>--%>
        <%--</tr>--%>
        <%--<c:forEach items="${accessHistoryList}" var="accessHistory">--%>
          <%--<tr>--%>
            <%--<td>${accessHistory.accessPoints.description}</td>--%>
            <%--<td>${accessHistory.datetime}</td>--%>
          <%--</tr>--%>
        <%--</c:forEach>--%>
      <%--</table>--%>
    <%--</c:when>--%>
    <%--<c:otherwise>--%>
        <%--<p>No Data found</p>--%>

    <%--</c:otherwise>--%>
  <%--</c:choose>--%>
</div>
</body>
</html>