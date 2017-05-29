<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="<c:url value="/resources/script/sorttable.js" />"></script>

<style type="text/css">
    @import "/resources/css/sortableTable.css";
</style>


<html>
<body>
    <h1>Upload Status</h1>
    <h2>Message : ${message}</h2>

    <c:if test="${!empty parsedData}">
        <table class="sortable" id="sortableTable">
            <tr>
                <th width="80">Bank Name</th>
                <th width="50">Auction Date</th>
                <th width="40">Lot Number</th>
                <th width="40">About Auction</th>
                <th width="80">KD Number</th>
                <th width="70">Start Price</th>
                <th width="100">URL</th>
                <th width="100">Property Details</th>
            </tr>
            <c:forEach items="${parsedData}" var="baseTable">
                <tr>
                    <td>${baseTable.bank}</td>
                    <td>${baseTable.auctionDate}</td>
                    <td>${baseTable.lotNumber}</td>
                    <td>${baseTable.aboutAuction}</td>
                    <td>${baseTable.kdNumber}</td>
                    <td>${baseTable.startPrice}</td>
                    <td>${baseTable.url}</td>
                    <td>${baseTable.propertyDetails}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <p>
        <form action="/importexport/doAddRecords" style="text-align: center;">
            <input type="submit" value="Confirm">
        </form>
    </p>



</body>
</html>