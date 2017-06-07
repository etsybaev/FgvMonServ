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

      <c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN') == true}">
          <%--<form action="/admin">--%>
              <%--<input type="submit" value="Admin panel">--%>
          <%--</form>--%>
          <td><button type="button" onclick="javascript:deleteScript.deleteBaseTableRecord(${baseTableRecord.id})">Delete this record</button></td>
          <%--<td><a href="javascript:deleteScript.deleteBaseTableRecord(${baseTableRecord.id})">Delete</a></td>--%>
      </c:if>

      <h1>Details:</h1>

      <c:if test="${!empty message}">
          <h3 style="color: red">
              ${message}
          </h3>
      </c:if>


      <c:url var="addAction" value="/basetableconroller/editbasetablerecord"/>

      <form:form action="${addAction}" commandName="baseTableRecord" acceptCharset="UTF-8" >
        <table>

            <tr>
              <td>
                <form:label path="id">
                  <spring:message text="<%=BaseTableNamesEnum.ID.getViewName()%>"/>
                </form:label>
              </td>
              <td>
                <form:input path="id" readonly="true" size="8" disabled="true"/>
                <form:hidden path="id"/>
              </td>
            </tr>

          <tr>
            <td>
              <form:label path="bank">
                <spring:message text="<%=BaseTableNamesEnum.BANK.getViewName()%>"/>
              </form:label>
            </td>
            <td>
              <form:input path="bank" size="40"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="auctionDate">
                <spring:message text="<%=BaseTableNamesEnum.AUCTION_DATE.getViewName()%>"/>
              </form:label>
            </td>
            <td>
              <form:input type="date" path="auctionDate"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="lotNumber">
                <spring:message text="<%=BaseTableNamesEnum.LOT_NUMBER.getViewName()%>"/>
              </form:label>
            </td>
            <td>
              <form:input path="lotNumber" size="40"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="kdNumber">
                <spring:message text="<%=BaseTableNamesEnum.KD_NUMBER.getViewName()%>"/>
              </form:label>
            </td>
            <td>
              <form:input path="kdNumber" size="40"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="startPrice">
                <spring:message text="<%=BaseTableNamesEnum.START_PRICE.getViewName()%>"/>
              </form:label>
            </td>
            <td>
              <form:input path="startPrice"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="url">
                <spring:message text="<%=BaseTableNamesEnum.URL.getViewName()%>"/>
              </form:label>
            </td>
            <td>
              <form:input path="url" size="90"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="propertyDetails">
                <spring:message text="<%=BaseTableNamesEnum.PROPERTY_DETAILS.getViewName()%>"/>
              </form:label>
            </td>
            <td>
              <form:textarea path="propertyDetails" rows="15" cols="90" cssStyle="font-weight: normal; resize: none;overflow-y: scroll;"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="loanDebtorFullName">
                <spring:message text="<%=BaseTableNamesEnum.LOAN_DEBTOR_FULL_NAME.getViewName()%>"/>
              </form:label>
            </td>
            <td>
              <form:input path="loanDebtorFullName" size="40"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="loanDebtorPhoneNumber">
                <spring:message text="<%=BaseTableNamesEnum.LOAN_DEBTOR_PHONE_NUMBER.getViewName()%>"/>
              </form:label>
            </td>
            <td>
              <form:input path="loanDebtorPhoneNumber"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="loanDebtorIdentCode">
                <spring:message text="<%=BaseTableNamesEnum.LOAN_DEBTOR_IDENT_CODE.getViewName()%>"/>
              </form:label>
            </td>
            <td>
              <form:input path="loanDebtorIdentCode"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="details">
                <spring:message text="<%=BaseTableNamesEnum.DETAILS.getViewName()%>"/>
              </form:label>
            </td>
            <td>
              <form:textarea path="details" rows="15" cols="90" cssStyle="font-weight: normal;resize: none;overflow-y: scroll;"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="dateOfCall">
                <spring:message text="<%=BaseTableNamesEnum.DATE_OF_CALL.getViewName()%>"/>
              </form:label>
            </td>
            <td>
              <form:input type="date" path="dateOfCall"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="statusOfCall">
                <spring:message text="<%=BaseTableNamesEnum.STATUS_OF_CALL.getViewName()%>"/>
              </form:label>
            </td>
            <td>
              <form:textarea path="statusOfCall"   rows="7" cols="90" cssStyle="font-weight: normal;resize: none;overflow-y: scroll;"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="newPrice">
                <spring:message text="<%=BaseTableNamesEnum.NEW_PRICE.getViewName()%>"/>
              </form:label>
            </td>
            <td>
              <form:input path="newPrice"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="newAuctionDate">
                <spring:message text="<%=BaseTableNamesEnum.NEW_AUCTION_DATE.getViewName()%>"/>
              </form:label>
            </td>
            <td>
              <form:input type="date" path="newAuctionDate"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="auctionNumber">
                <spring:message text="<%=BaseTableNamesEnum.AUCTION_NUMBER.getViewName()%>"/>
              </form:label>
            </td>
            <td>
              <form:input path="auctionNumber"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="symptom">
                <spring:message text="<%=BaseTableNamesEnum.SYMPTOM.getViewName()%>"/>
              </form:label>
            </td>
            <td>
              <form:input path="symptom" size="90"/>
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