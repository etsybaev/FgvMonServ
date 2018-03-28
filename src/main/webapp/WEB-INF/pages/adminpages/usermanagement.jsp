<%@ page import="com.fgvmonserv.model.userauth.UserRoles" %>
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
        <h1>Add new user</h1>

        <c:url var="addAction" value="/admin/usermanagement/adduser"/>

        <form:form action="${addAction}" commandName="user">
            <table>
                <c:if test="${!empty user.firstName}">
                    <tr>
                        <td>
                            <form:label path="id">
                                <spring:message text="ID"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="id" readonly="true" size="8" disabled="true"/>
                            <form:hidden path="id"/>
                        </td>
                    </tr>
                </c:if>

                <tr>
                    <td>
                        <form:label path="firstName">
                            <spring:message text="First name"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input required="required" pattern="[A-Za-z]{1,15}" path="firstName"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="lastName">
                            <spring:message text="Last Name"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input required="required" pattern="[A-Za-z]{1,15}" path="lastName"/>
                    </td>
                </tr>

                <tr>
                    <td>
                        <form:label path="contactPhoneNumber">
                            <spring:message text="Phone Number"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input maxlength="12"  pattern="^[0-9]{12,12}$"  required="required"
                                    title="Phone number must be in international format and contains digits only. Ex. 380441234567"
                                    path="contactPhoneNumber"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="password">
                            <spring:message text="Password"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input required="required" pattern=".{4,60}"
                                    title="Password must be from 4 to 10 characters" maxlength="15"
                                    path="password"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="enabled">
                            <spring:message text="Enable user"/>
                        </form:label>
                    </td>
                    <td>
                        <form:checkbox path="enabled" value="true" size="90"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="userRoles.Id">User Role</form:label>
                    </td>
                    <td>
                        <form:select required="required" path="userRoles.Id">
                            <option value="-1">Select a type</option>
                            <c:forEach items="${userRolesList}" var="role">
                                <%--<option value="${role.id}">${role.role}</option>--%>
                                <c:choose>
                                    <c:when test="${role.id == user.userRoles.id}">
                                        <option selected value="${role.id}">${role.role}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${role.id}">${role.role}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <c:if test="${!empty user.firstName}">
                            <input type="submit"
                                   value="<spring:message text="Save changes"/>"/>
                            <input type="button" onclick="location.href='/admin/usermanagement';"
                                   value="<spring:message text="Discard changes"/>"/>
                        </c:if>
                        <c:if test="${empty user.firstName}">
                            <input type="submit"
                                   value="<spring:message text="Add user"/>"/>
                        </c:if>
                    </td>
                </tr>
            </table>
        </form:form>

        <h1>User List</h1>

        <c:if test="${!empty listUsers}">
            <table class="sortable blueTable" id="sortableTable">
                <tr>
                    <th width="30">ID</th>
                    <th width="120">First Name</th>
                    <th width="120">Last Name</th>
                    <th width="120">Phone number</th>
                    <th width="70">Is Active</th>
                    <th width="70">Role</th>
                    <th width="40">Edit</th>
                    <th width="50">Delete</th>
                    <th width="60">User details</th>
                </tr>
                <c:forEach items="${listUsers}" var="user">
                    <tr>
                            <%--<td>${user.id}</td>--%>
                            <%--additional code for Id param make its value a link to entrance history details--%>
                        <td><a target="_blank" href="/admin/userdata/${user.id}" >${user.id}</a></td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.contactPhoneNumber}</td>
                        <td>${user.enabled}</td>
                        <td>${user.userRoles.role}</td>

                        <td><a href="<c:url value='/admin/usermanagement/edituser/${user.id}'/>">Edit</a></td>
                        <td><a href="javascript:deleteScript.deleteUser(${user.id})">Delete</a></td>
                        <td><a target="_blank" href="<c:url value='/admin/usermanagement/userdata/${user.id}'/>">See user details</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</body>
</html>