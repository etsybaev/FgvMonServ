<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>
<html>
<head>
    <title>Admin Page</title>
</head>
<body style="background-color: #f0f4ce">

<div>
    <p><a href="../">Back to main menu</a></p>

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h3>Welcome : ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/logout" />" > Logout</a></h3>
    </c:if>

    <p style="border: double"></p>

    <table>
        <tr>
            <th>User management</th>
            <th>Status of Deal management</th>
            <th>Status of Call management</th>
        </tr>
        <tr>
            <td><a href="/admin/usermanagement"><img src="/resources/img/usermanagement.png" style="width:250px;height:250px;"/></a></td>
            <td><a href="/admin/statusofdealmanagement"><img src="/resources/img/statusofdealmanagement.png" style="width:250px;height:250px;"/></a></td>
            <td><a href="/admin/statusofcallmanagement"><img src="/resources/img/statusofcallmanagement.png" style="width:250px;height:250px;"/></a></td>
        </tr>
    </table>

</body>
</html>
