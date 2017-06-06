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
                  <spring:message text="ID"/>
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
                <spring:message text="Bank Name"/>
              </form:label>
            </td>
            <td>
              <form:input path="bank"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="auctionDate">
                <spring:message text="Auction Date"/>
              </form:label>
            </td>
            <td>
              <form:input type="date" path="auctionDate"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="lotNumber">
                <spring:message text="Lot Number"/>
              </form:label>
            </td>
            <td>
              <form:input path="lotNumber"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="kdNumber">
                <spring:message text="KD Number"/>
              </form:label>
            </td>
            <td>
              <form:input path="kdNumber"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="startPrice">
                <spring:message text="Start Price"/>
              </form:label>
            </td>
            <td>
              <form:input path="startPrice"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="url">
                <spring:message text="URL"/>
              </form:label>
            </td>
            <td>
              <form:input path="url"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="propertyDetails">
                <spring:message text="Property Details"/>
              </form:label>
            </td>
            <td>
              <form:input path="propertyDetails"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="loanDebtorFullName">
                <spring:message text="Loan Debtor Full Name"/>
              </form:label>
            </td>
            <td>
              <form:input path="loanDebtorFullName"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="loanDebtorPhoneNumber">
                <spring:message text="loan Debtor Phone Number"/>
              </form:label>
            </td>
            <td>
              <form:input path="loanDebtorPhoneNumber"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="loanDebtorIdentCode">
                <spring:message text="loan Debtor Social Code"/>
              </form:label>
            </td>
            <td>
              <form:input path="loanDebtorIdentCode"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="details">
                <spring:message text="Details"/>
              </form:label>
            </td>
            <td>
              <form:input path="details"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="dateOfCall">
                <spring:message text="Date of Call"/>
              </form:label>
            </td>
            <td>
              <form:input type="date" path="dateOfCall"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="statusOfCall">
                <spring:message text="Status of Call"/>
              </form:label>
            </td>
            <td>
              <form:input path="statusOfCall"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="newPrice">
                <spring:message text="New Price"/>
              </form:label>
            </td>
            <td>
              <form:input path="newPrice"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="newAuctionDate">
                <spring:message text="New Auction Date"/>
              </form:label>
            </td>
            <td>
              <form:input type="date" path="newAuctionDate"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="auctionNumber">
                <spring:message text="Auction number"/>
              </form:label>
            </td>
            <td>
              <form:input path="auctionNumber"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:label path="symptom">
                <spring:message text="Symptom"/>
              </form:label>
            </td>
            <td>
              <form:input path="symptom"/>
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