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
                                        <option value="${filterByCriteria}">${filterByCriteria.getViewName()}</option>
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
                                        <option value="${rangeSearchCriteria}">${rangeSearchCriteria.getViewName()}</option>
                                    </c:forEach>
                                </form:select>
                            </td>
                        </tr>
                    </table>
                </td>
                <td>
                    <form:select path="<%=BaseTableNamesEnum.MANAGER.getJoinedIdDbName()%>">
                        <option selected value="">Show all records</option>
                        <option value="0">No manager assigned</option>
                        <c:forEach items="${allUsersList}" var="manager">
                            <option value="${manager.id}">${manager.firstName}</option>
                        </c:forEach>
                    </form:select>
                </td>
                <td>
                    <form:select path="<%=BaseTableNamesEnum.STATUS_OF_DEAL.getJoinedIdDbName()%>">
                        <option selected value="">Show all records</option>
                        <option value="0">No status assigned</option>
                        <c:forEach items="${statusOfDealList}" var="status">
                            <option value="${status.id}">${status.status}</option>
                        </c:forEach>
                    </form:select>
                </td>
                <td>
                    <form:select path="<%=BaseTableNamesEnum.IS_UNDER_CONTROL.getDbName()%>">
                        <option selected value="">Show all records</option>
                        <option value="true">Under control</option>
                        <option value="false">Is NOT under control</option>
                    </form:select>
                </td>
                <td>
                    <form:select path="<%=BaseTableNamesEnum.BANK.getDbName()%>">
                        <option selected value="">Show all records</option>
                        <c:forEach items="${allBanksList}" var="bank">
                            <option value="${bank}">${bank}</option>
                        </c:forEach>
                    </form:select>
                </td>
                <td>
                    <%--<form:select path="statusOfCall.id">--%>
                    <form:select path="<%=BaseTableNamesEnum.STATUS_OF_CALL.getJoinedIdDbName()%>">
                        <option selected value="">Show all records</option>
                        <option value="0">No status assigned</option>
                        <c:forEach items="${allCallStatusesList}" var="status">
                            <option value="${status.id}">${status.status}</option>
                        </c:forEach>
                    </form:select>
                </td>
            </tr>
        </table>
        <input type="submit" value="<spring:message text="Apply filter"/>"/>
    </form:form>
</div>



<div class="sortableTable">

    <script>
        function openEditPage(id) {
            window.location = '/basetableconroller/basetablerecorddetails/' + id;
        }
    </script>

    <script>
        function openCalcPage(id) {
            window.location = '/calc/' + id;
        }
    </script>


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
        <table class="sortable table" id="sortableTable">
            <tr>
                <th><%=BaseTableNamesEnum.ID.getViewName()%></th>
                <th><%=BaseTableNamesEnum.BANK.getViewName()%></th>
                <th><%=BaseTableNamesEnum.AUCTION_DATE.getViewName()%></th>
                <th><%=BaseTableNamesEnum.LOT_NUMBER.getViewName()%></th>
                <th><%=BaseTableNamesEnum.KD_NUMBER.getViewName()%></th>
                <th><%=BaseTableNamesEnum.ABOUT_AUCTION.getViewName()%></th>
                <th><%=BaseTableNamesEnum.START_PRICE.getViewName()%></th>
                <th><%=BaseTableNamesEnum.CALCULATOR_PAGE_TABLE.getViewName()%></th>
                <th><%=BaseTableNamesEnum.URL.getViewName()%></th>
                <th><%=BaseTableNamesEnum.PROPERTY_DETAILS.getViewName()%></th>
                <th><%=BaseTableNamesEnum.LOAN_DEBTOR_FULL_NAME.getViewName()%></th>
                <th><%=BaseTableNamesEnum.LOAN_DEBTOR_PHONE_NUMBER.getViewName()%></th>
                <th><%=BaseTableNamesEnum.LOAN_DEBTOR_IDENT_CODE.getViewName()%></th>
                <th><%=BaseTableNamesEnum.DETAILS.getViewName()%></th>
                <th><%=BaseTableNamesEnum.DATE_OF_CALL.getViewName()%></th>
                <th><%=BaseTableNamesEnum.STATUS_OF_CALL.getViewName()%></th>
                <th><%=BaseTableNamesEnum.NEW_AUCTION_DATE.getViewName()%></th>
                <th><%=BaseTableNamesEnum.MANAGERS_COMMENT.getViewName()%>r</th>
                <th><%=BaseTableNamesEnum.SYMPTOM.getViewName()%></th>
                <th><%=BaseTableNamesEnum.IS_UNDER_CONTROL.getViewName()%></th>
                <th><%=BaseTableNamesEnum.MANAGER.getViewName()%></th>
                <th><%=BaseTableNamesEnum.STATUS_OF_DEAL.getViewName()%></th>

            </tr>
            <c:forEach items="${allRecordsList}" var="allRecordsList">
                <tr ondblclick="openEditPage(${allRecordsList.id})">
                    <%--<td>${allRecordsList.id}</td>--%>
                    <td title="${allRecordsList.id}"><a href="/basetableconroller/basetablerecorddetails/${allRecordsList.id}" >${allRecordsList.id}</a></td>
                    <td title="${allRecordsList.bank}">${allRecordsList.bank}</td>
                    <td title="${allRecordsList.auctionDate}">${allRecordsList.auctionDate}</td>
                    <td title="${allRecordsList.lotNumber}">${allRecordsList.lotNumber}</td>
                    <td title="${allRecordsList.kdNumber}">${allRecordsList.kdNumber}</td>
                    <td title="${allRecordsList.aboutAuction}">${allRecordsList.aboutAuction}</td>
                    <td title="${allRecordsList.startPrice}">${allRecordsList.startPrice}</td>
                    <td onclick="openCalcPage(${allRecordsList.id})" title="${allRecordsList.calculatorPageTable.finalPrice}">${allRecordsList.calculatorPageTable.finalPrice}</td>
                    <td title="${allRecordsList.url}"><a target="_blank" href="${allRecordsList.url}">${allRecordsList.url}</a></td>
                    <td title="${allRecordsList.propertyDetails}">${allRecordsList.propertyDetails}</td>
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
        </table>
    </c:if>
</div>