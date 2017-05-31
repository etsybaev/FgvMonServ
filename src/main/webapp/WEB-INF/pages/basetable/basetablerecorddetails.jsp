<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ page contentType="text/html; charset=UTF-8" %>--%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
  <title>Details</title>
</head>
<body>
<h1>Details:</h1>


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
        <form:input path="auctionDate"/>
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
        <form:input path="dateOfCall"/>
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
        <form:input path="newAuctionDate"/>
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

</body>
</html>