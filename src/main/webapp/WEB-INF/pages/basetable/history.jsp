<%@ page import="com.fgvmonserv.BaseTableNamesEnum" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ page contentType="text/html; charset=UTF-8" %>--%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<script src="<c:url value="/resources/script/delConfirm.js" />"></script>
<script src="<c:url value="/resources/script/jquery-1.11.1.js" />"></script>
<script src="<c:url value="/resources/script/keepServerAlive.js" />"></script>

<style type="text/css">
    @import "/resources/css/sortableTable.css";
</style>

<html>
<head>
    <title>Details</title>
</head>
<body style="background-color: #f0f4ce">

<div>

    <p><a href="/">Back to main menu</a></p>
    <p><a href="/basetableconroller/basetablerecorddetails/${recordId}">Back to details page</a></p>

    <div class="sortableTable">
        <%--This script is for hiding columns--%>
        <%--<script src="/resources/script/jquery-1.11.1.min.js"></script>--%>
        <script>
            $(function () {
                var $chk = $("#grpChkBox input:checkbox");
                var $tbl = $("#sortableTable");
                var $tblhead = $("#sortableTable th");

                $chk.prop('checked', true);

                $chk.click(function () {
                    var colToHide = $tblhead.filter("." + $(this).attr("name"));
                    var index = $(colToHide).index();
                    $tbl.find('tr :nth-child(' + (index + 1) + ')').toggle();
                });
            });
        </script>

        <script>
            $(document).ready(function(){
                $("#hide").click(function(){
                    $("#grpChkBox").slideUp("slow");
                });
                $("#show").click(function(){
                    $("#grpChkBox").slideDown("slow");
                });
            });
        </script>

        <p>Records edit count: ${baseTableRecordHistory.size()-1}</p>
        <c:if test="${!empty baseTableRecordHistory}">
            <button id="show">Add/Hide shown columns</button>
            <div id="grpChkBox" style="display:none">
                <table>
                    <tr>
                        <th><input type="checkbox" name="managerUpdatedBy"/>Updated By</th>
                        <th><input type="checkbox" name="updatedTime"/>Updated time</th>
                        <th><input type="checkbox" name="<%=BaseTableNamesEnum.BANK.getDbName()%>"/><%=BaseTableNamesEnum.BANK.getViewName()%></th>
                        <th><input type="checkbox" name="<%=BaseTableNamesEnum.AUCTION_DATE.getDbName()%>"/><%=BaseTableNamesEnum.AUCTION_DATE.getViewName()%></th>
                        <th><input type="checkbox" name="<%=BaseTableNamesEnum.LOT_NUMBER.getDbName()%>"/><%=BaseTableNamesEnum.LOT_NUMBER.getViewName()%></th>
                        <th><input type="checkbox" name="<%=BaseTableNamesEnum.KD_NUMBER.getDbName()%>"/><%=BaseTableNamesEnum.KD_NUMBER.getViewName()%></th>
                    </tr>
                    <tr>
                        <th><input type="checkbox" name="<%=BaseTableNamesEnum.ABOUT_AUCTION.getDbName()%>"/><%=BaseTableNamesEnum.ABOUT_AUCTION.getViewName()%></th>
                        <th><input type="checkbox" name="<%=BaseTableNamesEnum.START_PRICE.getDbName()%>"/><%=BaseTableNamesEnum.START_PRICE.getViewName()%></th>
                        <th><input type="checkbox" name="<%=BaseTableNamesEnum.FINAL_PRICE.getDbName()%>"/><%=BaseTableNamesEnum.FINAL_PRICE.getViewName()%></th>
                        <th><input type="checkbox" name="<%=BaseTableNamesEnum.URL.getDbName()%>"/><%=BaseTableNamesEnum.URL.getViewName()%></th>
                        <th><input type="checkbox" name="<%=BaseTableNamesEnum.PROPERTY_DETAILS.getDbName()%>"/><%=BaseTableNamesEnum.PROPERTY_DETAILS.getViewName()%></th>
                        <th><input type="checkbox" name="<%=BaseTableNamesEnum.LOAN_DEBTOR_FULL_NAME.getDbName()%>"/><%=BaseTableNamesEnum.LOAN_DEBTOR_FULL_NAME.getViewName()%></th>
                    </tr>
                    <tr>
                        <th><input type="checkbox" name="<%=BaseTableNamesEnum.LOAN_DEBTOR_PHONE_NUMBER.getDbName()%>"/><%=BaseTableNamesEnum.LOAN_DEBTOR_PHONE_NUMBER.getViewName()%></th>
                        <th><input type="checkbox" name="<%=BaseTableNamesEnum.LOAN_DEBTOR_IDENT_CODE.getDbName()%>"/><%=BaseTableNamesEnum.LOAN_DEBTOR_IDENT_CODE.getViewName()%></th>
                        <th><input type="checkbox" name="<%=BaseTableNamesEnum.DETAILS.getDbName()%>"/><%=BaseTableNamesEnum.DETAILS.getViewName()%></th>
                        <th><input type="checkbox" name="<%=BaseTableNamesEnum.DATE_OF_CALL.getDbName()%>"/><%=BaseTableNamesEnum.DATE_OF_CALL.getViewName()%></th>
                        <th><input type="checkbox" name="<%=BaseTableNamesEnum.STATUS_OF_CALL.getDbName()%>"/><%=BaseTableNamesEnum.STATUS_OF_CALL.getViewName()%></th>
                        <th><input type="checkbox" name="<%=BaseTableNamesEnum.NEW_AUCTION_DATE.getDbName()%>"/><%=BaseTableNamesEnum.NEW_AUCTION_DATE.getViewName()%></th>
                    </tr>
                    <tr>
                        <th><input type="checkbox" name="<%=BaseTableNamesEnum.MANAGERS_COMMENT.getDbName()%>"/><%=BaseTableNamesEnum.MANAGERS_COMMENT.getViewName()%></th>
                        <th><input type="checkbox" name="<%=BaseTableNamesEnum.SYMPTOM.getDbName()%>"/><%=BaseTableNamesEnum.SYMPTOM.getViewName()%></th>
                        <th><input type="checkbox" name="<%=BaseTableNamesEnum.IS_UNDER_CONTROL.getDbName()%>"/><%=BaseTableNamesEnum.IS_UNDER_CONTROL.getViewName()%></th>
                        <th><input type="checkbox" name="<%=BaseTableNamesEnum.MANAGER.getDbName()%>"/><%=BaseTableNamesEnum.MANAGER.getViewName()%></th>
                        <th><input type="checkbox" name="<%=BaseTableNamesEnum.STATUS_OF_DEAL.getDbName()%>"/><%=BaseTableNamesEnum.STATUS_OF_DEAL.getViewName()%></th>
                    </tr>
                </table>
                <button id="hide">Hide selector</button>
            </div>

            <table class="sortable table table_div_trim" id="sortableTable">
                <thead>
                <tr>
                    <th class="managerUpdatedBy">Updated By</th>
                    <th class="updatedTime">Updated time</th>
                    <th class="<%=BaseTableNamesEnum.BANK.getDbName()%>"><%=BaseTableNamesEnum.BANK.getViewName()%></th>
                    <th class="<%=BaseTableNamesEnum.AUCTION_DATE.getDbName()%>"><%=BaseTableNamesEnum.AUCTION_DATE.getViewName()%></th>
                    <th class="<%=BaseTableNamesEnum.LOT_NUMBER.getDbName()%>"><%=BaseTableNamesEnum.LOT_NUMBER.getViewName()%></th>
                    <th class="<%=BaseTableNamesEnum.KD_NUMBER.getDbName()%>"><%=BaseTableNamesEnum.KD_NUMBER.getViewName()%></th>
                    <th class="<%=BaseTableNamesEnum.ABOUT_AUCTION.getDbName()%>"><%=BaseTableNamesEnum.ABOUT_AUCTION.getViewName()%></th>
                    <th class="<%=BaseTableNamesEnum.START_PRICE.getDbName()%>"><%=BaseTableNamesEnum.START_PRICE.getViewName()%></th>
                    <th class="<%=BaseTableNamesEnum.FINAL_PRICE.getDbName()%>"><%=BaseTableNamesEnum.FINAL_PRICE.getViewName()%></th>
                    <th class="<%=BaseTableNamesEnum.URL.getDbName()%>"><%=BaseTableNamesEnum.URL.getViewName()%></th>
                    <th class="<%=BaseTableNamesEnum.PROPERTY_DETAILS.getDbName()%>"><%=BaseTableNamesEnum.PROPERTY_DETAILS.getViewName()%></th>
                    <th class="<%=BaseTableNamesEnum.LOAN_DEBTOR_FULL_NAME.getDbName()%>"><%=BaseTableNamesEnum.LOAN_DEBTOR_FULL_NAME.getViewName()%></th>
                    <th class="<%=BaseTableNamesEnum.LOAN_DEBTOR_PHONE_NUMBER.getDbName()%>"><%=BaseTableNamesEnum.LOAN_DEBTOR_PHONE_NUMBER.getViewName()%></th>
                    <th class="<%=BaseTableNamesEnum.LOAN_DEBTOR_IDENT_CODE.getDbName()%>"><%=BaseTableNamesEnum.LOAN_DEBTOR_IDENT_CODE.getViewName()%></th>
                    <th class="<%=BaseTableNamesEnum.DETAILS.getDbName()%>"><%=BaseTableNamesEnum.DETAILS.getViewName()%></th>
                    <th class="<%=BaseTableNamesEnum.DATE_OF_CALL.getDbName()%>"><%=BaseTableNamesEnum.DATE_OF_CALL.getViewName()%></th>
                    <th class="<%=BaseTableNamesEnum.STATUS_OF_CALL.getDbName()%>"><%=BaseTableNamesEnum.STATUS_OF_CALL.getViewName()%></th>
                    <th class="<%=BaseTableNamesEnum.NEW_AUCTION_DATE.getDbName()%>"><%=BaseTableNamesEnum.NEW_AUCTION_DATE.getViewName()%></th>
                    <th class="<%=BaseTableNamesEnum.MANAGERS_COMMENT.getDbName()%>"><%=BaseTableNamesEnum.MANAGERS_COMMENT.getViewName()%>r</th>
                    <th class="<%=BaseTableNamesEnum.SYMPTOM.getDbName()%>"><%=BaseTableNamesEnum.SYMPTOM.getViewName()%></th>
                    <th class="<%=BaseTableNamesEnum.IS_UNDER_CONTROL.getDbName()%>"><%=BaseTableNamesEnum.IS_UNDER_CONTROL.getViewName()%></th>
                    <th class="<%=BaseTableNamesEnum.MANAGER.getDbName()%>"><%=BaseTableNamesEnum.MANAGER.getViewName()%></th>
                    <th class="<%=BaseTableNamesEnum.STATUS_OF_DEAL.getDbName()%>"><%=BaseTableNamesEnum.STATUS_OF_DEAL.getViewName()%></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${baseTableRecordHistory}" var="history">
                    <tr>
                        <td title="${history.managerUpdatedBy}">${history.managerUpdatedBy}</td>
                        <td title="${history.updatedTime}">${history.updatedTime}</td>
                        <td title="${history.bank}">${history.bank}</td>
                        <td title="${history.auctionDate}">${history.auctionDate}</td>
                        <td title="${history.lotNumber}">${history.lotNumber}</td>
                        <td title="${history.kdNumber}"><div>${history.kdNumber}</div></td>
                        <td title="${history.aboutAuction}">${history.aboutAuction}</td>
                        <td title="${history.startPrice}">${history.startPrice}</td>
                        <td title="${history.finalPrice}">${history.finalPrice}</td>
                        <td title="${history.url}"><a target="_blank" href="${history.url}">${history.url}</a></td>
                        <td title="${history.propertyDetails}"><div>${history.propertyDetails}</div></td>
                        <td title="${history.loanDebtorFullName}">${history.loanDebtorFullName}</td>
                        <td title="${history.loanDebtorPhoneNumber}">${history.loanDebtorPhoneNumber}</td>
                        <td title="${history.loanDebtorIdentCode}">${history.loanDebtorIdentCode}</td>
                        <td title="${history.details}">${history.details}</td>
                        <td title="${history.dateOfCall}">${history.dateOfCall}</td>
                        <td title="${history.statusOfCall.status}">${history.statusOfCall.status}</td>
                        <td title="${history.newAuctionDate}">${history.newAuctionDate}</td>
                        <td title="${history.managersComment}">${history.managersComment}</td>
                        <td title="${history.symptom}">${history.symptom}</td>
                        <td title="${history.isUnderControl}">${history.isUnderControl}</td>
                        <td title="${history.manager.firstName}">${history.manager.firstName}</td>
                        <td title="${history.statusOfDeal.status}">${history.statusOfDeal.status}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
</body>
</html>