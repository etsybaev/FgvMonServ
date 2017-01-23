<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

    <script src="<c:url value="/resources/script/sorttable.js" />"></script>


<style type="text/css">
    th, td {
        padding: 3px !important;
    }

    /* Sortable tables */
    table.sortable thead {
        background-color: #333;
        color: #cccccc;
        font-weight: bold;
        cursor: default;
    }
    th {
        font-size: 100%;
    }
    table#stripedemo tbody tr:nth-child(2n) td {
        background: #9a9895;
    }
    table#stripedemo tbody tr:nth-child(2n+1) td {
        background: #dcdad7;
    }
</style>


<script type="text/javascript" src="sorttable.js"></script>

<table class="sortable" id="stripedemo">
    <tr>
        <th>Name</th>
        <th>Salary</th>
        <th>Extension</th>
        <th>Start date</th>
        <th>Start date (American)</th>
    </tr>
    <tr>
        <td>Bloggs, Fred</td>
        <td>$12000.00</td>
        <td>1353</td>
        <td>18/08/2003</td>
        <td>08/18/2003</td>
    </tr>
    <tr>
        <td>Turvey, Kevin</td>
        <td>$191200.00</td>
        <td>2342</td>
        <td>02/05/1979</td>
        <td>05/02/1979</td>
    </tr>
    <tr>
        <td>Mbogo, Arnold</td>
        <td>$32010.12</td>
        <td>2755</td>
        <td>09/08/1998</td>
        <td>08/09/1998</td>
    </tr>
    <tr>
        <td>Shakespeare, Bill</td>
        <td>$122000.00</td>
        <td>3211</td>
        <td>12/11/1961</td>
        <td>11/12/1961</td>
    </tr>
    <tr>
        <td>Shakespeare, Hamnet</td>
        <td>$9000</td>
        <td>9005</td>
        <td>01/01/2002</td>
        <td>01/01/2002</td>
    </tr>
    <tr>
        <td>Fitz, Marvin</td>
        <td>$3300</td>
        <td>5554</td>
        <td>22/05/1995</td>
        <td>05/22/1995</td>
    </tr>
</table>



