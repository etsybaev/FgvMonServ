<%@ page import="com.fgvmonserv.BaseTableNamesEnum" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ page contentType="text/html; charset=UTF-8" %>--%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<script src="<c:url value="/resources/script/delConfirm.js" />"></script>

<html>
<head>
    <title>Calculator</title>
</head>
<body>

<div style="background-color: #f0f4ce">

    <p><a href="/">Back to main menu</a></p>

    <h1>Price calculator:</h1>

    <c:if test="${!empty message}">
        <h3 style="color: red">
                ${message}
        </h3>
    </c:if>


    <c:url var="addAction" value="/calc/addeditcalcrecord"/>

    <form:form action="${addAction}" commandName="calcRecord" acceptCharset="UTF-8">
        <table>

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

            <tr>
                <td>
                    <%=BaseTableNamesEnum.START_PRICE.getViewName()%>
                </td>
                <td>
                    <%--${startPrice}--%>
                    <input disabled="disabled" value="${startPrice}">
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="auctionStep">
                        <spring:message text="Auction step"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="auctionStep"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="stockExchangeCommission">
                        <spring:message text="Stock Exchange Commission"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="stockExchangeCommission"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="notaryCommission">
                        <spring:message text="Notary Commission"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="notaryCommission"/>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="ourCommission">
                        <spring:message text="Our Commission"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="ourCommission"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="finalPrice">
                        <spring:message text="Final price"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="finalPrice" disabled="true"/>
                </td>
            </tr>


            <tr>
                <td>
                    <input type="submit" value="<spring:message text="Save changes"/>"/>
                </td>
            </tr>
        </table>
    </form:form>

</div>
</body>
</html>