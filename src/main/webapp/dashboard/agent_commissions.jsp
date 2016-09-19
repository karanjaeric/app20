<%--
  Created by IntelliJ IDEA.
  User: tony
  Date: 9/16/16
  Time: 4:19 PM
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section">
    <div class="col-md-4">
        <h3>
            <i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;COMMISSIONS
        </h3>
    </div>
    <table class="table table-responsive table-striped" id="search-results">
        <tr><th>MONTH</th><th>YEAR</th><th>CONTRIBUTION</th><th>COMMISSION</th><th>NET</th></tr>
        <c:forEach var="commission" items="${ commissions }">
            <tr><td>${commission.month }</td><td>${ commission.year }</td><td>${ commission.contr }</td>
                <td>${ commission.commission }</td><td>${ commission.net }</td></tr>
        </c:forEach>
    </table>
    <ul class="pagination pull-right">
        <c:if test="${ batch > 1 }">
            <li><a href="javascript:void(0);" onclick="load_dashboard(${ page > per_page ? page - per_page : page }, ${ batch - 1 })">&laquo;</a></li>
        </c:if>
        <c:forEach begin="${ begin }" end="${ pages > (begin + (per_page - 1)) ? (begin + (per_page - 1)) : pages }" varStatus="loop">
            <c:choose>
                <c:when test="${ page == loop.index }">
                    <li class="active"><a href="javascript:void(0);">${ loop.index }</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="javascript:void(0);" onclick="load_dashboard(${ loop.index }, ${ batch })">${ loop.index }</a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:if test="${ pages > begin + (per_page - 1)}">
            <li><a href="javascript:void(0);" onclick="load_dashboard(${ pages < page + per_page ? pages : page + per_page }, ${ batch + 1 })">&raquo;</a></li>
        </c:if>
    </ul>
</div>
