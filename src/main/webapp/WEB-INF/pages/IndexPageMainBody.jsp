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
    <p>Records found by provided search criteria: ${allRecordsList.size()}</p>
    <c:if test="${!empty allRecordsList}">
        <table class="sortable" id="sortableTable">
            <tr>
                <th width="10">Id</th>
                <th width="70">Bank Name</th>
                <th width="20">Auction Date</th>
                <th width="20">Lot Number</th>
                <th width="20">KD Number</th>
                <th width="20">Start Price</th>
                <th width="20">URL</th>
                <th width="20">Property Details</th>
                <th width="20">Loan Debtor Full Name</th>
                <th width="20">loan Debtor Phone Number</th>
                <th width="20">loan Debtor Social Code</th>
                <th width="20">Details</th>
                <th width="20">Date of Call</th>
                <th width="20">Status of Call</th>
                <th width="20">New Price</th>
                <th width="20">New Auction Date</th>
                <th width="20">Auction number</th>
                <th width="20">Symptom</th>

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