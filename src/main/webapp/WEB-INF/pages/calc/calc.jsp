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
<body onload="findTotal()">

<div style="background-color: #f0f4ce">

    <p><a href="/">Back to main menu</a></p>

    <h1>Price calculator:</h1>

    <c:if test="${!empty message}">
        <h3 style="color: red">
                ${message}
        </h3>
    </c:if>

    <script type="text/javascript">
        function findTotal(){
            var startPrice = parseFloat(document.getElementById("startPrice").value);
            var auctionStep = parseFloat(document.getElementById("auctionStep").value);
            var stockExchangeCommission= parseFloat(document.getElementById("stockExchangeCommission").value);
            var notaryCommission = parseFloat(document.getElementById("notaryCommission").value);
            var ourCommission = parseFloat(document.getElementById("ourCommission").value);
            var finalPrice = parseFloat(document.getElementById("finalPrice").value);

            auctionStep = startPrice * auctionStep;
            stockExchangeCommission = auctionStep * stockExchangeCommission;

            var totalPrice = startPrice + auctionStep + stockExchangeCommission + notaryCommission + ourCommission;

            document.getElementById('finalPrice').value = totalPrice;
        }
    </script>


    <c:url var="addAction" value="/calc/editcalcrecord"/>

    <form:form action="${addAction}" commandName="calcRecord" acceptCharset="UTF-8" method="POST">
        <table>

            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
            <tr>
                <td>
                    <%=BaseTableNamesEnum.START_PRICE.getViewName()%>
                </td>
                <td>
                    <%--${startPrice}--%>
                    <input id="startPrice" readonly="disabled" value="${startPrice}">
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="auctionStep">
                        <spring:message text="Auction step"/>
                    </form:label>
                </td>
                <td>
                    <form:input id="auctionStep" onkeyup="findTotal()" path="auctionStep" type="text"
                                pattern="[0-9]+?(\.[0-9]{0,2})?" title="This must be a number with up to 2 decimal places"/>
                        <%--<form:input id="auctionStep" onkeyup="findTotal()" path="auctionStep"--%>
                                    <%--type="text"--%>
                                    <%--pattern="[0-9]+(\.[0-9]{0,2})?%?"--%>
                                    <%--title="This must be a number with up to 2 decimal places and/or %"/>--%>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="stockExchangeCommission">
                        <spring:message text="Stock Exchange Commission"/>
                    </form:label>
                </td>
                <td>
                    <form:input id="stockExchangeCommission" onkeyup="findTotal()" path="stockExchangeCommission" type="text"
                                pattern="[0-9]+?(\.[0-9]{0,2})?" title="This must be a number with up to 2 decimal places"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="notaryCommission">
                        <spring:message text="Notary Commission"/>
                    </form:label>
                </td>
                <td>
                    <form:input id="notaryCommission" onkeyup="findTotal()" path="notaryCommission" type="text"
                                pattern="[0-9]+?(\.[0-9]{0,2})?" title="This must be a number with up to 2 decimal places"/>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="ourCommission">
                        <spring:message text="Our Commission"/>
                    </form:label>
                </td>
                <td>
                    <form:input id="ourCommission" onkeyup="findTotal()" path="ourCommission" type="text"
                                pattern="[0-9]+?(\.[0-9]{0,2})?" title="This must be a number with up to 2 decimal places"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="finalPrice">
                        <spring:message text="Final price"/>
                    </form:label>
                </td>
                <td>
                    <form:input id="finalPrice" readonly="true" path="finalPrice"/>
                </td>
            </tr>

            <tr>
                <td>
                    <input onclick="findTotal()" type="submit" value="<spring:message text="Save changes"/>"/>
                </td>
            </tr>
        </table>
    </form:form>

</div>
</body>
</html>