

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="<c:url value="/resources/script/sorttable.js" />"></script>

<style type="text/css">
    @import "/resources/css/sortableTable.css";
</style>


<html>
<head>
    <title>Import/export files</title>
</head>
<body>
    <form id="fileuploadForm" action="/importexport/fileupload" method="POST" enctype="multipart/form-data">
        <label for="file">File</label>
        <input id="file" type="file" name="file" />
        <p><button type="submit">Upload</button></p>
    </form>


    <p><a href="/importexport/download">Download</a></p>


    <c:if test="${!empty message}">
        <h2>Message : ${message}</h2>
    </c:if>


    <div>
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
                <c:forEach items="${parsedData.getBaseTableList()}" var="baseTable">
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
            <p>
            <form action="/importexport/doAddRecords" style="text-align: center;" method="post" modelAttribute="parsedData" enctype="application/x-www-form-urlencoded">
                <input type="hidden" value="${parsedData}" name="data">
                <input type="submit" value="Confirm">
            </form>
            </p>
        </c:if>

    </div>

</body>
</html>
