<%--
  Created by IntelliJ IDEA.
  User: tony
  Date: 9/21/16
  Time: 12:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section">

<c:forEach var="ben" items="${ beneficiaries }">
    <c:if test="${ben.id == beneficiary_id }">
        <input type="hidden" id="beneficiary_id" value="${ ben.id }"/>
    <table class="table table-responsive table-striped">
        <tr><td>FIRST NAME:</td><td>${ ben.firstname }</td>
        <tr><td>SURNAME:</td><td>${ ben.surname }</td>
        <tr><td>OTHER NAMES:</td><td>${ ben.othernames }</td>
        <tr><td>LUMPSUM ENTITLEMENT:</td><td>${ ben.lumpsumEntitlement }</td>
        <tr><td>GENDER:</td><td>${ ben.gender }</td>
        <tr><td>RELATIONSHIP:</td><td>${ ben.relationship }</td>
        <tr><td>RELATIONSHIP CATEGORY:</td><td>${ ben.relShipCategory }</td>
        <tr><td>MARITAL STATUS:</td><td>${ ben.mstatus }</td>
        <tr><td>STATUS:</td><td>${ ben.status }</td>
    </table>
    </c:if>
</c:forEach>
</div>
