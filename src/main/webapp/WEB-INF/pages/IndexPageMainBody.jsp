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

    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
    }
</style>


<%--<script type="text/javascript" src="sorttable.js"></script>--%>

<div id="timePickers" style="border: double">
    <h1>Filter result options</h1>
    <form:form action="/" commandName="baseTableDateFilter" acceptCharset="UTF-8" method="get">
        <table>
            <tr>
                <th>Date filter</th>
                <th>Manager filter</th>
                <th>Status of deal filter</th>
                <th>Is under control filter</th>
                <th>Bank filter</th>
                <th>Status of call filter</th>
            </tr>
            <tr>
                <td>
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
                                    <spring:message text="Filter by field"/>
                                </form:label>
                            </td>
                            <td>
                                <form:select required="required" path="baseTableNamesEnum">
                                    <c:forEach items="${byAuctionDate}" var="filterByCriteria">
                                        <c:choose>
                                            <c:when test="${filterByCriteria == baseTableDateFilter.baseTableNamesEnum}">
                                                <option selected value="${filterByCriteria}">${filterByCriteria.getViewName()}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${filterByCriteria}">${filterByCriteria.getViewName()}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </form:select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="searchByRangeTypeEnum">
                                    <spring:message text="Filter by range"/>
                                </form:label>
                            </td>
                            <td>
                                <form:select required="required" path="searchByRangeTypeEnum">
                                    <c:forEach items="${searchByRangeType}" var="rangeSearchCriteria">
                                        <c:choose>
                                            <c:when test="${rangeSearchCriteria == baseTableDateFilter.searchByRangeTypeEnum}">
                                                <option selected value="${rangeSearchCriteria}">${rangeSearchCriteria.getViewName()}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${rangeSearchCriteria}">${rangeSearchCriteria.getViewName()}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </form:select>
                            </td>
                        </tr>
                    </table>
                </td>
                <td>
                    <form:select path="<%=BaseTableNamesEnum.MANAGER.getJoinedIdDbName()%>">
                        <option selected value="0">Show all records</option>
                        <c:choose>
                            <c:when test="${empty baseTableDateFilter.manager.id}">
                                <option selected value="">No manager assigned</option>
                            </c:when>
                            <c:otherwise>
                                <option value="">No manager assigned</option>
                            </c:otherwise>
                        </c:choose>
                        <c:forEach items="${allUsersList}" var="manager">
                            <c:choose>
                                <c:when test="${manager.id == baseTableDateFilter.manager.id}">
                                    <option selected value="${manager.id}">${manager.firstName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${manager.id}">${manager.firstName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </form:select>
                </td>
                <td>
                    <form:select path="<%=BaseTableNamesEnum.STATUS_OF_DEAL.getJoinedIdDbName()%>">
                        <option selected value="0">Show all records</option>
                        <c:choose>
                            <c:when test="${empty baseTableDateFilter.statusOfDeal.id}">
                                <option selected value="">No status assigned</option>
                            </c:when>
                            <c:otherwise>
                                <option value="">No status assigned</option>
                            </c:otherwise>
                        </c:choose>
                        <c:forEach items="${statusOfDealList}" var="status">
                            <c:choose>
                                <c:when test="${status.id == baseTableDateFilter.statusOfDeal.id}">
                                    <option selected value="${status.id}">${status.status}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${status.id}">${status.status}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </form:select>
                </td>
                <td>
                    <form:select path="<%=BaseTableNamesEnum.IS_UNDER_CONTROL.getDbName()%>">
                        <c:choose>
                            <c:when test="${empty baseTableDateFilter.isUnderControl}">
                                <option selected value="">Show all records</option>
                            </c:when>
                            <c:otherwise>
                                <option value="">Show all records</option>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${baseTableDateFilter.isUnderControl == true}">
                                <option selected value="true">Under control</option>
                            </c:when>
                            <c:otherwise>
                                <option value="true">Under control</option>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${baseTableDateFilter.isUnderControl == false}">
                                <option selected value="false">Is NOT under control</option>
                            </c:when>
                            <c:otherwise>
                                <option value="false">Is NOT under control</option>
                            </c:otherwise>
                        </c:choose>
                    </form:select>
                </td>
                <td>
                    <form:select path="<%=BaseTableNamesEnum.BANK.getDbName()%>">
                        <option selected value="">Show all records</option>
                        <c:forEach items="${allBanksList}" var="bank">
                            <c:choose>
                                <c:when test="${bank == baseTableDateFilter.bank}">
                                    <option selected value="${bank}">${bank}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${bank}">${bank}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </form:select>
                </td>
                <td>
                    <%--<form:select path="statusOfCall.id">--%>
                    <form:select path="<%=BaseTableNamesEnum.STATUS_OF_CALL.getJoinedIdDbName()%>">
                        <option selected value="0">Show all records</option>
                        <c:choose>
                            <c:when test="${empty baseTableDateFilter.statusOfCall.id}">
                                <option selected value="">No status assigned</option>
                            </c:when>
                            <c:otherwise>
                                <option value="">No status assigned</option>
                            </c:otherwise>
                        </c:choose>
                        <c:forEach items="${allCallStatusesList}" var="status">
                            <c:choose>
                                <c:when test="${status.id == baseTableDateFilter.statusOfCall.id}">
                                    <option selected value="${status.id}">${status.status}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${status.id}">${status.status}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </form:select>
                </td>
            </tr>
        </table>
        <input type="submit" value="<spring:message text="Apply filter"/>"/>
        <input type="reset" value="<spring:message text="Reset filter"/>"/>
        <input type="button" onclick="location.href='/';" value="<spring:message text="Reset filter to default"/>"/>
    </form:form>
</div>



<div class="sortableTable">

    <script>
        function openEditPage(id) {
            window.open('/basetableconroller/basetablerecorddetails/' + id, '_blank');
        }
    </script>

    <%--<script>--%>
        <%--function openCalcPage(id) {--%>
            <%--window.open('/calc/' + id, '_blank');--%>
        <%--}--%>
    <%--</script>--%>


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

    <%--This script is for hiding columns--%>
    <script src="/resources/script/jquery-1.11.1.min.js"></script>
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


    <div id="grpChkBox">
        <p>Shown columns:</p>
        <table>
            <tr>
                <th><input type="checkbox" name="<%=BaseTableNamesEnum.ID.getDbName()%>"/><%=BaseTableNamesEnum.ID.getViewName()%></th>
                <th><input type="checkbox" name="<%=BaseTableNamesEnum.BANK.getDbName()%>"/><%=BaseTableNamesEnum.BANK.getViewName()%></th>
                <th><input type="checkbox" name="<%=BaseTableNamesEnum.AUCTION_DATE.getDbName()%>"/><%=BaseTableNamesEnum.AUCTION_DATE.getViewName()%></th>
                <th><input type="checkbox" name="<%=BaseTableNamesEnum.LOT_NUMBER.getDbName()%>"/><%=BaseTableNamesEnum.LOT_NUMBER.getViewName()%></th>
                <th><input type="checkbox" name="<%=BaseTableNamesEnum.KD_NUMBER.getDbName()%>"/><%=BaseTableNamesEnum.KD_NUMBER.getViewName()%></th>
                <th><input type="checkbox" name="<%=BaseTableNamesEnum.ABOUT_AUCTION.getDbName()%>"/><%=BaseTableNamesEnum.ABOUT_AUCTION.getViewName()%></th>
            </tr>
            <tr>
                <th><input type="checkbox" name="<%=BaseTableNamesEnum.START_PRICE.getDbName()%>"/><%=BaseTableNamesEnum.START_PRICE.getViewName()%></th>
                <th><input type="checkbox" name="<%=BaseTableNamesEnum.FINAL_PRICE.getDbName()%>"/><%=BaseTableNamesEnum.FINAL_PRICE.getViewName()%></th>
                <th><input type="checkbox" name="<%=BaseTableNamesEnum.URL.getDbName()%>"/><%=BaseTableNamesEnum.URL.getViewName()%></th>
                <th><input type="checkbox" name="<%=BaseTableNamesEnum.PROPERTY_DETAILS.getDbName()%>"/><%=BaseTableNamesEnum.PROPERTY_DETAILS.getViewName()%></th>
                <th><input type="checkbox" name="<%=BaseTableNamesEnum.LOAN_DEBTOR_FULL_NAME.getDbName()%>"/><%=BaseTableNamesEnum.LOAN_DEBTOR_FULL_NAME.getViewName()%></th>
                <th><input type="checkbox" name="<%=BaseTableNamesEnum.LOAN_DEBTOR_PHONE_NUMBER.getDbName()%>"/><%=BaseTableNamesEnum.LOAN_DEBTOR_PHONE_NUMBER.getViewName()%></th>
            </tr>
            <tr>
                <th><input type="checkbox" name="<%=BaseTableNamesEnum.LOAN_DEBTOR_IDENT_CODE.getDbName()%>"/><%=BaseTableNamesEnum.LOAN_DEBTOR_IDENT_CODE.getViewName()%></th>
                <th><input type="checkbox" name="<%=BaseTableNamesEnum.DETAILS.getDbName()%>"/><%=BaseTableNamesEnum.DETAILS.getViewName()%></th>
                <th><input type="checkbox" name="<%=BaseTableNamesEnum.DATE_OF_CALL.getDbName()%>"/><%=BaseTableNamesEnum.DATE_OF_CALL.getViewName()%></th>
                <th><input type="checkbox" name="<%=BaseTableNamesEnum.STATUS_OF_CALL.getDbName()%>"/><%=BaseTableNamesEnum.STATUS_OF_CALL.getViewName()%></th>
                <th><input type="checkbox" name="<%=BaseTableNamesEnum.NEW_AUCTION_DATE.getDbName()%>"/><%=BaseTableNamesEnum.NEW_AUCTION_DATE.getViewName()%></th>
                <th><input type="checkbox" name="<%=BaseTableNamesEnum.MANAGERS_COMMENT.getDbName()%>"/><%=BaseTableNamesEnum.MANAGERS_COMMENT.getViewName()%></th>
            </tr>
            <tr>
                <th><input type="checkbox" name="<%=BaseTableNamesEnum.SYMPTOM.getDbName()%>"/><%=BaseTableNamesEnum.SYMPTOM.getViewName()%></th>
                <th><input type="checkbox" name="<%=BaseTableNamesEnum.IS_UNDER_CONTROL.getDbName()%>"/><%=BaseTableNamesEnum.IS_UNDER_CONTROL.getViewName()%></th>
                <th><input type="checkbox" name="<%=BaseTableNamesEnum.MANAGER.getDbName()%>"/><%=BaseTableNamesEnum.MANAGER.getViewName()%></th>
                <th><input type="checkbox" name="<%=BaseTableNamesEnum.STATUS_OF_DEAL.getDbName()%>"/><%=BaseTableNamesEnum.STATUS_OF_DEAL.getViewName()%></th>
            </tr>
        </table>
    </div>


    <p>Records found by provided search criteria: ${allRecordsList.size()}</p>
    <c:if test="${!empty allRecordsList}">
        <table class="sortable table table_div_trim" id="sortableTable">
            <thead>
                <tr>
                    <th class="<%=BaseTableNamesEnum.ID.getDbName()%>"><%=BaseTableNamesEnum.ID.getViewName()%></th>
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
            <c:forEach items="${allRecordsList}" var="allRecordsList">
                <tr ondblclick="openEditPage(${allRecordsList.id})">
                    <%--<td>${allRecordsList.id}</td>--%>
                    <td title="${allRecordsList.id}"><a target="_blank" href="/basetableconroller/basetablerecorddetails/${allRecordsList.id}" >${allRecordsList.id}</a></td>
                    <td title="${allRecordsList.bank}">${allRecordsList.bank}</td>
                    <td title="${allRecordsList.auctionDate}">${allRecordsList.auctionDate}</td>
                    <td title="${allRecordsList.lotNumber}">${allRecordsList.lotNumber}</td>
                    <td title="${allRecordsList.kdNumber}"><div>${allRecordsList.kdNumber}</div></td>
                    <td title="${allRecordsList.aboutAuction}">${allRecordsList.aboutAuction}</td>
                    <td title="${allRecordsList.startPrice}">${allRecordsList.startPrice}</td>
                    <td title="${allRecordsList.finalPrice}">${allRecordsList.finalPrice}</td>
                    <td title="${allRecordsList.url}"><a target="_blank" href="${allRecordsList.url}">${allRecordsList.url}</a></td>
                    <td title="${allRecordsList.propertyDetails}"><div>${allRecordsList.propertyDetails}</div></td>
                    <td title="${allRecordsList.loanDebtorFullName}">${allRecordsList.loanDebtorFullName}</td>
                    <td title="${allRecordsList.loanDebtorPhoneNumber}">${allRecordsList.loanDebtorPhoneNumber}</td>
                    <td title="${allRecordsList.loanDebtorIdentCode}">${allRecordsList.loanDebtorIdentCode}</td>
                    <td title="${allRecordsList.details}">${allRecordsList.details}</td>
                    <td title="${allRecordsList.dateOfCall}">${allRecordsList.dateOfCall}</td>
                    <td title="${allRecordsList.statusOfCall.status}">${allRecordsList.statusOfCall.status}</td>
                    <td title="${allRecordsList.newAuctionDate}">${allRecordsList.newAuctionDate}</td>
                    <td title="${allRecordsList.managersComment}">${allRecordsList.managersComment}</td>
                    <td title="${allRecordsList.symptom}">${allRecordsList.symptom}</td>
                    <td title="${allRecordsList.isUnderControl}">${allRecordsList.isUnderControl}</td>
                    <td title="${allRecordsList.manager.firstName}">${allRecordsList.manager.firstName}</td>
                    <td title="${allRecordsList.statusOfDeal.status}">${allRecordsList.statusOfDeal.status}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>