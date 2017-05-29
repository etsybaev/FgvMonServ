<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

    <script src="<c:url value="/resources/script/sorttable.js" />"></script>
    <link href="<c:url value="/resources/css/sortableTable.css" />" rel="tableStyle">

<style type="text/css">
    @import "/resources/css/sortableTable.css";
</style>


<%--<script type="text/javascript" src="sorttable.js"></script>--%>

<div class="sortableTable">
    <c:if test="${!empty allRecordsList}">
        <table class="sortable" id="recordsList">

            <tr>
                <th width="30">Id</th>
                <th width="120">Bank Name</th>
                <th width="120">Auction Date</th>
                <th width="120">Lot Number</th>
                <th width="120">Admin Comments</th>

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
                    <td>${allRecordsList.adminComments}</td>

                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>



