<%--
  Created by IntelliJ IDEA.
  User: tony
  Date: 6/14/17
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="includes/partial/header.jsp" />
<div class="container">
    <div class="main-content">
        <h1 class="heading">Frequently Asked Questions</h1>

    <div class="row">

        <div class="col-md-12 push-md-1">

            <ul class="pb-5">
                <li>
                    <c:forEach var="content" items="${content}">
                        <h4>${ content.title }</h4>
                        <p class="lead">${ content.text }</p>
                    </c:forEach>
                </li>

            </ul>

        </div>

    </div>

</div>
</div>
<jsp:include page="includes/partial/footer.jsp" />
