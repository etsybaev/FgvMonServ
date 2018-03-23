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

<html>
<head>
    <title>Details</title>
</head>
<body>

<div style="background-color: #f0f4ce">

    <a href="javascript: if(window.print) window.print()">Print</a>
    <p><a href="/">Back to main menu</a></p>

    <c:if test="${(pageContext.request.isUserInRole('ROLE_ADMIN') == true) and (action != 'ADD_USER')}">
        <td>
            <button type="button" onclick="javascript:deleteScript.deleteBaseTableRecord(${baseTableRecord.id})">Delete
                this record
            </button>
        </td>

        <form action="/basetableconroller/basetablerecorddetails/history/${recordId}">
            <input type="submit" value="See edit history">
        </form>

    </c:if>

    <h1>Details:</h1>

    <c:if test="${!empty message}">
        <h3 style="color: red">
                ${message}
        </h3>
    </c:if>


    <%--<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>--%>
    <script>
        function isValidValue(regexp, value, valueName) {
            if(regexp.test(value) && value!=null && value!=""){
                return true;
            }else {
                alert(valueName + " value is in unacceptable format");
                return false;
            }
        }

        window.onload = function () {
            document.getElementById("btnCalc").onclick = function () {
                var startPrice = document.getElementById("startPrice").value;
                var auctionStep = document.getElementById("auctionStep").value;
                var stockExchangeCommission= document.getElementById("stockExchangeCommission").value;
                var notaryCommission = document.getElementById("notaryCommission").value;
                var ourCommission = document.getElementById("ourCommission").value;

                var isStartPriceValid = isValidValue(/^\d{0,15}(\.\d{0,2})?$/, startPrice, "StartPrice");
                var isAuctionStepValid = isValidValue(/^\d{0,15}?$/, auctionStep, "Auction Step");
                var isStockExchangeCommissionValid = isValidValue(/^\d{0,15}?$/, stockExchangeCommission, "Stock Exchange Commission");
                var isNotaryCommissionValid = isValidValue(/^\d{0,15}(\.\d{0,2})?$/, notaryCommission, "Notary commission");
                var isOurCommissionValid = isValidValue(/^\d{0,15}(\.\d{0,2})?$/, ourCommission, "Our commission");

                if(isStartPriceValid && isAuctionStepValid && isStockExchangeCommissionValid &&
                    isNotaryCommissionValid && isOurCommissionValid){
                    $.ajax({
                        type: "POST",
                        url: "/basetableconroller/calc",
                        // The key needs to match your method's input parameter (case-sensitive).
                        data: JSON.stringify({"startPrice": startPrice, "auctionStep": auctionStep,
                            "stockExchangeCommission": stockExchangeCommission, "notaryCommission": notaryCommission,
                            "ourCommission": ourCommission}),
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        success: function(data){
                            document.getElementById('finalPrice').value = data.finalPrice;
                            document.getElementById('auctionStepUAH').value = data.auctionStepUAH;
                            document.getElementById('stockExchangeCommissionUAH').value = data.stockExchangeCommissionUAH;
                        },
                        failure: function(errMsg) {alert(errMsg);
                        }
                    });
                }
            }
        }

//        <input id="amount" maxlength="20" type="text" />
//        $("#amount").on("keyup", function(){
//            var valid = /^\d{0,15}(\.\d{0,2})?$/.test(this.value),
//                val = this.value;
//
//            if(!valid){
//                console.log("Invalid input!");
//                this.value = val.substring(0, val.length - 1);
//            }
//        });


    </script>

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
                    <form:label path="<%=BaseTableNamesEnum.ABOUT_AUCTION.getDbName()%>">
                        <spring:message text="<%=BaseTableNamesEnum.ABOUT_AUCTION.getViewName()%>"/>
                    </form:label>
                </td>
                <td>
                    <form:textarea path="<%=BaseTableNamesEnum.ABOUT_AUCTION.getDbName()%>" rows="10" cols="90"
                                   cssStyle="font-weight: normal; resize: none;overflow-y: scroll;"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="<%=BaseTableNamesEnum.START_PRICE.getDbName()%>">
                        <spring:message text="<%=BaseTableNamesEnum.START_PRICE.getViewName()%>"/>
                    </form:label>
                </td>
                <td>
                    <%--<form:input id="startPrice" onkeyup="findTotal()" path="<%=BaseTableNamesEnum.START_PRICE.getDbName()%>" type="text"--%>
                    <form:input id="startPrice" path="<%=BaseTableNamesEnum.START_PRICE.getDbName()%>" type="text"
                                pattern="[0-9]+?(\.[0-9]{0,2})?" title="This must be a number with up to 2 decimal places"/>
                </td>
            </tr>

            <tr>
                <td>
                    Calculator
                </td>
                <td>
                    <table>


                        <tr>
                            <td>
                                <form:label path="<%=BaseTableNamesEnum.AUCTION_STEP.getDbName()%>">
                                    <spring:message text="<%=BaseTableNamesEnum.AUCTION_STEP.getViewName()%>"/>
                                </form:label>
                            </td>
                            <td>
                                <%--<form:input id="auctionStep" onkeyup="findTotal()" path="<%=BaseTableNamesEnum.AUCTION_STEP.getDbName()%>"--%>
                                <form:input id="auctionStep" path="<%=BaseTableNamesEnum.AUCTION_STEP.getDbName()%>"
                                            type="text" pattern="[0-9]+" title="This must be a number of %"/>

                                <%--<form:input id="auctionStep" onkeyup="findTotal()" path="auctionStep" type="text"--%>
                                            <%--pattern="[0-9]+?(\.[0-9]{0,2})?" title="This must be a number with up to 2 decimal places"/>--%>


                                <td> , UAH= </td>
                                <td> <input id="auctionStepUAH" type="text" disabled size="15"/> </td>

                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="<%=BaseTableNamesEnum.STOCK_EXCHANGE_COMMISSION.getDbName()%>">
                                    <spring:message text="<%=BaseTableNamesEnum.STOCK_EXCHANGE_COMMISSION.getViewName()%>"/>
                                </form:label>
                            </td>
                            <td>
                                <%--<form:input id="stockExchangeCommission" onkeyup="findTotal()"--%>
                                <form:input id="stockExchangeCommission"
                                            path="<%=BaseTableNamesEnum.STOCK_EXCHANGE_COMMISSION.getDbName()%>"
                                            type="text" pattern="[0-9]+" title="This must be a number of %"/>
                                <%--<form:input id="stockExchangeCommission" onkeyup="findTotal()" path="stockExchangeCommission" type="text"--%>
                                            <%--pattern="[0-9]+?(\.[0-9]{0,2})?" title="This must be a number with up to 2 decimal places"/>--%>

                                <td> , UAH= </td>
                                <td> <input id="stockExchangeCommissionUAH" type="text" disabled size="15"/> </td>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="<%=BaseTableNamesEnum.NOTARY_COMMISSION.getDbName()%>">
                                    <spring:message text="<%=BaseTableNamesEnum.NOTARY_COMMISSION.getViewName()%>"/>
                                </form:label>
                            </td>
                            <td>
                                <%--<form:input id="notaryCommission" onkeyup="findTotal()" path="<%=BaseTableNamesEnum.NOTARY_COMMISSION.getDbName()%>"--%>
                                <form:input id="notaryCommission" path="<%=BaseTableNamesEnum.NOTARY_COMMISSION.getDbName()%>"
                                            type="text" pattern="[0-9]+?(\.[0-9]{0,2})?" title="This must be a number with up to 2 decimal places"/>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <form:label path="<%=BaseTableNamesEnum.OUR_COMMISSION.getDbName()%>">
                                    <spring:message text="<%=BaseTableNamesEnum.OUR_COMMISSION.getViewName()%>"/>
                                </form:label>
                            </td>
                            <td>
                                <%--<form:input id="ourCommission" onkeyup="findTotal()" path="<%=BaseTableNamesEnum.OUR_COMMISSION.getDbName()%>"--%>
                                <form:input id="ourCommission" path="<%=BaseTableNamesEnum.OUR_COMMISSION.getDbName()%>"
                                            type="text" pattern="[0-9]+?(\.[0-9]{0,2})?" title="This must be a number with up to 2 decimal places"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="<%=BaseTableNamesEnum.FINAL_PRICE.getDbName()%>">
                                    <spring:message text="<%=BaseTableNamesEnum.FINAL_PRICE.getViewName()%>"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input id="finalPrice" readonly="true" path="<%=BaseTableNamesEnum.FINAL_PRICE.getDbName()%>"/>
                            </td>
                        </tr>
                        <%--<tr>--%>
                            <%--<td>--%>
                                <%--<input onclick="findTotal()" type="submit" value="<spring:message text="Save changes"/>"/>--%>
                            <%--</td>--%>
                        <%--</tr>--%>
                    </table>
                    <input id="btnCalc" type="button" value="Calculate" />
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
                    <%--<form:textarea path="<%=BaseTableNamesEnum.STATUS_OF_CALL.getDbName()%>" rows="7" cols="90"--%>
                                   <%--cssStyle="font-weight: normal;resize: none;overflow-y: scroll;"/>--%>
                        <form:select path="<%=BaseTableNamesEnum.STATUS_OF_CALL.getJoinedIdDbName()%>">
                            <%--<option value="0">No status assigned</option>--%>
                            <%--<c:forEach items="${allCallStatusesList}" var="status">--%>
                                <%--<option value="${status.id}">${status.status}</option>--%>
                            <%--</c:forEach>--%>
                            <option value="0">No status assigned</option>
                            <c:forEach items="${allCallStatusesList}" var="status">
                                <c:choose>
                                    <c:when test="${status.id == baseTableRecord.statusOfCall.id}">
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
                    <form:label path="<%=BaseTableNamesEnum.MANAGERS_COMMENT.getDbName()%>">
                        <spring:message text="<%=BaseTableNamesEnum.MANAGERS_COMMENT.getViewName()%>"/>
                    </form:label>
                </td>
                <td>
                    <form:textarea path="<%=BaseTableNamesEnum.MANAGERS_COMMENT.getDbName()%>" rows="15" cols="90"
                                cssStyle="font-weight: normal; resize: none;overflow-y: scroll;"/>
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
                    <form:label path="<%=BaseTableNamesEnum.MANAGER.getJoinedIdDbName()%>"><%=BaseTableNamesEnum.MANAGER.getViewName()%></form:label>
                </td>
                <td>
                    <form:select required="required" path="<%=BaseTableNamesEnum.MANAGER.getJoinedIdDbName()%>">
                        <option value="0">No manager assigned</option>
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
                    <form:label path="<%=BaseTableNamesEnum.STATUS_OF_DEAL.getJoinedIdDbName()%>"><%=BaseTableNamesEnum.STATUS_OF_DEAL.getViewName()%></form:label>
                </td>
                <td>
                    <form:select required="required" path="<%=BaseTableNamesEnum.STATUS_OF_DEAL.getJoinedIdDbName()%>">
                        <option value="0">No status assigned</option>
                        <c:forEach items="${statusOfDealList}" var="status">
                            <c:choose>
                                <c:when test="${status.id == baseTableRecord.statusOfDeal.id}">
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