<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>
<html>
<head>
    <%--<link href="<c:url value="/resources/css/sortableTable.css" />" rel="sortableTable" type="text/css">--%>
    <script src="<c:url value="/resources/script/delConfirm.js" />"></script>
    <script src="<c:url value="/resources/script/sorttable.js" />"></script>
    <script src="<c:url value="/resources/script/jquery-1.11.1.js" />"></script>
    <script src="<c:url value="/resources/script/keepServerAlive.js" />"></script>
    <%--<script type="text/javascript" src="sorttable.js"></script>--%>
    <title>Users Page</title>

    <style type="text/css">
        @import "/resources/css/sortableTable.css";
    </style>


</head>
<body style="background-color: #f0f4ce">

    <div>
        <p><a href="../">Back to main page</a></p>
        <p><a href="/admin/">Back to Admin menu</a></p>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h3>Welcome : ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/logout" />" > Logout</a></h3>
        </c:if>

        <p style="border: double"></p>


        <h1>Add/Edit Status of Deal</h1>

        <c:url var="addStatusOfDealAction" value="/admin/statusofdealmanagement/addstatusofdeal"/>
        <form:form action="${addStatusOfDealAction}" commandName="statusOfDeal">
            <table>
                <c:if test="${!empty statusOfDeal.id}">
                    <tr>
                        <td>
                            <form:label path="id">
                                <spring:message text="ID"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="id" readonly="true" disabled="true" size="8" required="required"
                                        pattern="^[0-9]{0,10}$" title="Id must contains digits only (max.10 digits)"/>
                            <form:hidden path="id"/>
                        </td>
                    </tr>
                </c:if>
                <tr>
                    <td>
                        <form:label path="status">
                            <spring:message text="Status of Deal"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input required="required" path="status"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <c:if test="${!empty statusOfDeal.id}">
                            <input type="submit"
                                   value="<spring:message text="Save changes"/>"/>
                            <input type="button" onclick="location.href='/admin/statusofdealmanagement';"
                                   value="<spring:message text="Discard changes"/>"/>
                        </c:if>
                        <c:if test="${empty statusOfDeal.id}">
                            <input type="submit" value="<spring:message text="Add Status Of Deal"/>"/>
                        </c:if>
                    </td>
                </tr>
            </table>
        </form:form>

        <h1>Status of Deal List</h1>

        <c:if test="${!empty statusOfDealList}">
            <table class="sortable blueTable" id="sortableTable">
                <tr>
                    <th width="30">ID</th>
                    <th width="120">Status of Deal</th>
                    <th width="40">Edit</th>
                    <th width="50">Delete</th>
                </tr>
                <c:forEach items="${statusOfDealList}" var="statusOfDeal">
                    <tr>
                        <td>${statusOfDeal.id}</td>
                        <td>${statusOfDeal.status}</td>
                        <td><a href="<c:url value='/admin/statusofdealmanagement/editstatusofdeal/${statusOfDeal.id}'/>">Edit</a></td>
                        <td><a href="javascript:deleteScript.deleteStatusOfDealRecord(${statusOfDeal.id})">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</body>
</html>
