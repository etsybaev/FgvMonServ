<%@ page import="com.fgvmonserv.BaseTableNamesEnum" %>

<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
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
<body style="background-color: #f0f4ce">

        <div style="border-bottom: solid">
            <p><a href="/">Back to main menu</a></p>
            <table>
                <td style="border: double">
                    <form id="fileuploadForm" action="/importexport/fileupload" method="POST" enctype="multipart/form-data">
                        <label for="file">File</label>
                        <input id="file" type="file" name="file" />
                        <p><button type="submit">Upload</button></p>
                    </form>
                </td>
                <td style="border: double">
                    <p>
                        <a href="/importexport/download">Export Database to CSV</a>
                    </p>
                </td>
            </table>
        </div>


        <c:if test="${!empty message}">
            <h2 style="color:red">Important : ${message}</h2>
        </c:if>

        <div>
            <c:if test="${!empty uid}">
                <table class="sortable" id="sortableTable">
                    <tr>
                        <th width="80"><%=BaseTableNamesEnum.BANK.getViewName()%></th>
                        <th width="50"><%=BaseTableNamesEnum.AUCTION_DATE.getViewName()%></th>
                        <th width="40"><%=BaseTableNamesEnum.LOT_NUMBER.getViewName()%></th>
                        <th width="40"><%=BaseTableNamesEnum.ABOUT_AUCTION.getViewName()%></th>
                        <th width="80"><%=BaseTableNamesEnum.KD_NUMBER.getViewName()%></th>
                        <th width="70"><%=BaseTableNamesEnum.START_PRICE.getViewName()%></th>
                        <th width="100"><%=BaseTableNamesEnum.URL.getViewName()%></th>
                        <th width="100"><%=BaseTableNamesEnum.PROPERTY_DETAILS.getViewName()%></th>
                    </tr>
                    <c:forEach items="${parsedData}" var="baseTable">
                        <tr>
                            <td title="${baseTable.bank}">${baseTable.bank}</td>
                            <td title="${baseTable.auctionDate}">${baseTable.auctionDate}</td>
                            <td title="${baseTable.lotNumber}">${baseTable.lotNumber}</td>
                            <td title="${baseTable.aboutAuction}">${baseTable.aboutAuction}</td>
                            <td title="${baseTable.kdNumber}">${baseTable.kdNumber}</td>
                            <td title="${baseTable.startPrice}">${baseTable.startPrice}</td>
                            <td title="${baseTable.url}"><a target="_blank" href="${baseTable.url}">${baseTable.url}</a></td>
                            <td title="${baseTable.propertyDetails}">${baseTable.propertyDetails}</td>
                        </tr>
                    </c:forEach>
                </table>

                <form action="/importexport/doAddRecords" style="text-align: center;" method="post" modelAttribute="parsedData" enctype="application/x-www-form-urlencoded">
                    <input type="hidden" value="${uid}" name="uid">
                    <input type="submit" value="Confirm">
                </form>
            </c:if>

            <p><a href="/">Back to main menu</a></p>

        </div>
</body>
</html>
