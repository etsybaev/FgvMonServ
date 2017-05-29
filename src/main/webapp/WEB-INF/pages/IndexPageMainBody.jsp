<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

    <script src="<c:url value="/resources/script/sorttable.js" />"></script>
    <%--<link href="<c:url value="/resources/css/sortableTable.css" />" rel="tableStyle">--%>

<style type="text/css">
    @import "/resources/css/sortableTable.css";
</style>


<%--<script type="text/javascript" src="sorttable.js"></script>--%>

<div class="sortableTable">
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
                        <%--<td>${user.id}</td>--%>
                        <%--additional code for Id param make its value a link to entrance history details--%>
                        <%--<td><a target="_blank" href="/admin/userdata/${user.id}" >${user.id}</a></td>--%>
                    <td>${allRecordsList.id}</td>
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



