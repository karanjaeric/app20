<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tony
  Date: 11/4/16
  Time: 9:48 AM
  To change this template use File | Settings | File Templates.
--%>
<div class="container-fluid section">
    <h3 class="text-center main-title">
        <i class="glyphicon glyphicon-folder-close"></i>&nbsp;&nbsp;CLAIMS
    </h3>

    <table class="table table-responsive table-striped" id="claim-results">
        <tr><th>MEMBER NUMBER</th><th>DATE OF EXIT</th><th>REASON FOR EXIT</th><th>CLAIM STATUS</th><th>PROCESSED</th></tr>
        <c:forEach var="claims" items="${ claims }">
            <tr><td>${claims.memberNo }</td><td>${claims.dateOfExit }</td><td>${ claims.reasonForExit }</td><td>${ claims.currentStatus }</td><td>${ claims.processed }</td></tr>
        </c:forEach>
    </table>


</div>