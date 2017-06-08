<%@ page import="com.fgvmonserv.BaseTableNamesEnum" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
    <script src="<c:url value="/resources/script/sorttable.js" />"></script>
    <%--<link href="<c:url value="/resources/css/sortableTable.css" />" rel="tableStyle">--%>

<style type="text/css">
    @import "/resources/css/sortableTable.css";
</style>


<%--<script type="text/javascript" src="sorttable.js"></script>--%>

<div id="timePickers" style="border: double">
    <h1>Filter result options</h1>
        <form:form action="/" commandName="baseTableDateFilter" acceptCharset="UTF-8" method="get" >
            <table>
                <tr>
                    <td>
                        <form:label path="startDate">
                            <spring:message text="Start Date"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input type="date" path="startDate"/>
                    </td>
                </tr>

                <tr>
                    <td>
                        <form:label path="baseTableNamesEnum">
                            <spring:message text="Filter By"/>
                        </form:label>
                    </td>
                    <td>
                        <form:select required="required" path="baseTableNamesEnum">
                            <c:forEach items="${byAuctionDate}" var="filterByCriteria">
                                <option value="${filterByCriteria}">${filterByCriteria.getViewName()}</option>
                            </c:forEach>
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="<spring:message text="Apply filter"/>"/>
                    </td>
                </tr>
            </table>
        </form:form>
</div>



<div class="sortableTable">

    <c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN') == true}">
        <p>
            <form action="/basetableconroller/addnewbasetablerecordform">
                <input type="submit" value="Add new record">
            </form>
        </p>

        <p style="color: red">
            ${message}
        </p>
    </c:if>

    <p>Records found by provided search criteria: ${allRecordsList.size()}</p>
    <c:if test="${!empty allRecordsList}">
        <table class="sortable" id="sortableTable">
            <tr>
                <th width="10"><%=BaseTableNamesEnum.ID.getViewName()%></th>
                <th width="70"><%=BaseTableNamesEnum.BANK.getViewName()%></th>
                <th width="20"><%=BaseTableNamesEnum.AUCTION_DATE.getViewName()%></th>
                <th width="20"><%=BaseTableNamesEnum.LOT_NUMBER.getViewName()%></th>
                <th width="20"><%=BaseTableNamesEnum.KD_NUMBER.getViewName()%></th>
                <th width="20"><%=BaseTableNamesEnum.START_PRICE.getViewName()%></th>
                <th width="20"><%=BaseTableNamesEnum.URL.getViewName()%></th>
                <th width="20"><%=BaseTableNamesEnum.PROPERTY_DETAILS.getViewName()%></th>
                <th width="20"><%=BaseTableNamesEnum.LOAN_DEBTOR_FULL_NAME.getViewName()%></th>
                <th width="20"><%=BaseTableNamesEnum.LOAN_DEBTOR_PHONE_NUMBER.getViewName()%></th>
                <th width="20"><%=BaseTableNamesEnum.LOAN_DEBTOR_IDENT_CODE.getViewName()%></th>
                <th width="20"><%=BaseTableNamesEnum.DETAILS.getViewName()%></th>
                <th width="20"><%=BaseTableNamesEnum.DATE_OF_CALL.getViewName()%></th>
                <th width="20"><%=BaseTableNamesEnum.STATUS_OF_CALL.getViewName()%></th>
                <th width="20"><%=BaseTableNamesEnum.NEW_PRICE.getViewName()%></th>
                <th width="20"><%=BaseTableNamesEnum.NEW_AUCTION_DATE.getViewName()%></th>
                <th width="20"><%=BaseTableNamesEnum.AUCTION_NUMBER.getViewName()%>r</th>
                <th width="20"><%=BaseTableNamesEnum.SYMPTOM.getViewName()%></th>

            </tr>
            <c:forEach items="${allRecordsList}" var="allRecordsList">
                <tr>
                    <%--<td>${allRecordsList.id}</td>--%>
                    <td><a href="/basetableconroller/basetablerecorddetails/${allRecordsList.id}" >${allRecordsList.id}</a></td>
                    <td>${allRecordsList.bank}</td>
                    <td>${allRecordsList.auctionDate}</td>
                    <td>${allRecordsList.lotNumber}</td>
                    <td>${allRecordsList.kdNumber}</td>
                    <td>${allRecordsList.startPrice}</td>
                    <td>${allRecordsList.url}</td>
                    <td>${allRecordsList.propertyDetails}</td>
                    <td>${allRecordsList.loanDebtorFullName}</td>
                    <td>${allRecordsList.loanDebtorPhoneNumber}</td>
                    <td>${allRecordsList.loanDebtorIdentCode}</td>
                    <td>${allRecordsList.details}</td>
                    <td>${allRecordsList.dateOfCall}</td>
                    <td>${allRecordsList.statusOfCall}</td>
                    <td>${allRecordsList.newPrice}</td>
                    <td>${allRecordsList.newAuctionDate}</td>
                    <td>${allRecordsList.auctionNumber}</td>
                    <td>${allRecordsList.symptom}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>