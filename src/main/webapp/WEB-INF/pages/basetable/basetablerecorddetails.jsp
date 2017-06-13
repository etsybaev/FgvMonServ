<%@ page import="com.fgvmonserv.BaseTableNamesEnum" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ page contentType="text/html; charset=UTF-8" %>--%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<script src="<c:url value="/resources/script/delConfirm.js" />"></script>

<html>
<head>
    <title>Details</title>
</head>
<body>

<div style="background-color: #f0f4ce">

    <p><a href="/">Back to main menu</a></p>

    <c:if test="${(pageContext.request.isUserInRole('ROLE_ADMIN') == true) and (action != 'ADD_USER')}">
        <td>
            <button type="button" onclick="javascript:deleteScript.deleteBaseTableRecord(${baseTableRecord.id})">Delete
                this record
            </button>
        </td>
    </c:if>

    <h1>Details:</h1>

    <c:if test="${!empty message}">
        <h3 style="color: red">
                ${message}
        </h3>
    </c:if>


    <c:url var="addAction" value="/basetableconroller/addeditbasetablerecord"/>

    <form:form action="${addAction}" commandName="baseTableRecord" acceptCharset="UTF-8">
        <table>

            <tr>
                <td>
                    <form:label path="<%=BaseTableNamesEnum.ID.getDbName()%>">
                        <spring:message text="<%=BaseTableNamesEnum.ID.getViewName()%>"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="<%=BaseTableNamesEnum.ID.getDbName()%>" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="<%=BaseTableNamesEnum.BANK.getDbName()%>">
                        <spring:message text="<%=BaseTableNamesEnum.BANK.getViewName()%>"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="<%=BaseTableNamesEnum.BANK.getDbName()%>" size="40"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="<%=BaseTableNamesEnum.AUCTION_DATE.getDbName()%>">
                        <spring:message text="<%=BaseTableNamesEnum.AUCTION_DATE.getViewName()%>"/>
                    </form:label>
                </td>
                <td>
                    <form:input type="date" path="<%=BaseTableNamesEnum.AUCTION_DATE.getDbName()%>"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="<%=BaseTableNamesEnum.LOT_NUMBER.getDbName()%>">
                        <spring:message text="<%=BaseTableNamesEnum.LOT_NUMBER.getViewName()%>"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="<%=BaseTableNamesEnum.LOT_NUMBER.getDbName()%>" size="40"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="<%=BaseTableNamesEnum.KD_NUMBER.getDbName()%>">
                        <spring:message text="<%=BaseTableNamesEnum.KD_NUMBER.getViewName()%>"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="<%=BaseTableNamesEnum.KD_NUMBER.getDbName()%>" size="40"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="<%=BaseTableNamesEnum.START_PRICE.getDbName()%>">
                        <spring:message text="<%=BaseTableNamesEnum.START_PRICE.getViewName()%>"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="<%=BaseTableNamesEnum.START_PRICE.getDbName()%>"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="<%=BaseTableNamesEnum.URL.getDbName()%>">
                        <spring:message text="<%=BaseTableNamesEnum.URL.getViewName()%>"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="<%=BaseTableNamesEnum.URL.getDbName()%>" size="90"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="<%=BaseTableNamesEnum.PROPERTY_DETAILS.getDbName()%>">
                        <spring:message text="<%=BaseTableNamesEnum.PROPERTY_DETAILS.getViewName()%>"/>
                    </form:label>
                </td>
                <td>
                    <form:textarea path="<%=BaseTableNamesEnum.PROPERTY_DETAILS.getDbName()%>" rows="15" cols="90"
                                   cssStyle="font-weight: normal; resize: none;overflow-y: scroll;"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="<%=BaseTableNamesEnum.LOAN_DEBTOR_FULL_NAME.getDbName()%>">
                        <spring:message text="<%=BaseTableNamesEnum.LOAN_DEBTOR_FULL_NAME.getViewName()%>"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="<%=BaseTableNamesEnum.LOAN_DEBTOR_FULL_NAME.getDbName()%>" size="40"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="<%=BaseTableNamesEnum.LOAN_DEBTOR_PHONE_NUMBER.getDbName()%>">
                        <spring:message text="<%=BaseTableNamesEnum.LOAN_DEBTOR_PHONE_NUMBER.getViewName()%>"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="<%=BaseTableNamesEnum.LOAN_DEBTOR_PHONE_NUMBER.getDbName()%>"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="<%=BaseTableNamesEnum.LOAN_DEBTOR_IDENT_CODE.getDbName()%>">
                        <spring:message text="<%=BaseTableNamesEnum.LOAN_DEBTOR_IDENT_CODE.getViewName()%>"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="<%=BaseTableNamesEnum.LOAN_DEBTOR_IDENT_CODE.getDbName()%>"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="<%=BaseTableNamesEnum.DETAILS.getDbName()%>">
                        <spring:message text="<%=BaseTableNamesEnum.DETAILS.getViewName()%>"/>
                    </form:label>
                </td>
                <td>
                    <form:textarea path="<%=BaseTableNamesEnum.DETAILS.getDbName()%>" rows="15" cols="90"
                                   cssStyle="font-weight: normal;resize: none;overflow-y: scroll;"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="<%=BaseTableNamesEnum.DATE_OF_CALL.getDbName()%>">
                        <spring:message text="<%=BaseTableNamesEnum.DATE_OF_CALL.getViewName()%>"/>
                    </form:label>
                </td>
                <td>
                    <form:input type="date" path="<%=BaseTableNamesEnum.DATE_OF_CALL.getDbName()%>"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="<%=BaseTableNamesEnum.STATUS_OF_CALL.getDbName()%>">
                        <spring:message text="<%=BaseTableNamesEnum.STATUS_OF_CALL.getViewName()%>"/>
                    </form:label>
                </td>
                <td>
                    <form:textarea path="<%=BaseTableNamesEnum.STATUS_OF_CALL.getDbName()%>" rows="7" cols="90"
                                   cssStyle="font-weight: normal;resize: none;overflow-y: scroll;"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="<%=BaseTableNamesEnum.NEW_PRICE.getDbName()%>">
                        <spring:message text="<%=BaseTableNamesEnum.NEW_PRICE.getViewName()%>"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="<%=BaseTableNamesEnum.NEW_PRICE.getDbName()%>"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="<%=BaseTableNamesEnum.NEW_AUCTION_DATE.getDbName()%>">
                        <spring:message text="<%=BaseTableNamesEnum.NEW_AUCTION_DATE.getViewName()%>"/>
                    </form:label>
                </td>
                <td>
                    <form:input type="date" path="<%=BaseTableNamesEnum.NEW_AUCTION_DATE.getDbName()%>"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="<%=BaseTableNamesEnum.AUCTION_NUMBER.getDbName()%>">
                        <spring:message text="<%=BaseTableNamesEnum.AUCTION_NUMBER.getViewName()%>"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="<%=BaseTableNamesEnum.AUCTION_NUMBER.getDbName()%>"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="<%=BaseTableNamesEnum.SYMPTOM.getDbName()%>">
                        <spring:message text="<%=BaseTableNamesEnum.SYMPTOM.getViewName()%>"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="<%=BaseTableNamesEnum.SYMPTOM.getDbName()%>" size="90"/>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="<%=BaseTableNamesEnum.IS_UNDER_CONTROL.getDbName()%>">
                        <spring:message text="<%=BaseTableNamesEnum.IS_UNDER_CONTROL.getViewName()%>"/>
                    </form:label>
                </td>
                <td>
                    <form:checkbox path="<%=BaseTableNamesEnum.IS_UNDER_CONTROL.getDbName()%>" value="true" size="90"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="manager.Id">User Role</form:label>
                </td>
                <td>
                    <form:select required="required" path="manager.Id">
                        <option value="-1">No manager assigned</option>
                        <c:forEach items="${allUsersList}" var="manager">
                            <c:choose>
                                <c:when test="${manager.id == baseTableRecord.manager.id}">
                                    <option selected value="${manager.id}">${manager.firstName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${manager.id}">${manager.firstName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </form:select>
                </td>
            </tr>

            <tr>
                <td>
                    <input type="submit" value="<spring:message text="Save changes"/>"/>
                </td>
            </tr>
        </table>
    </form:form>

</div>
</body>
</html>