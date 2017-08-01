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
                <%--<ul class="pb-5">--%>
                <div class="panel-group" id="faqAccordion">
                    <c:forEach var="content" items="${content}">
                        <div class="panel panel-default ">
                            <div class="panel-heading accordion-toggle question-toggle collapsed" data-toggle="collapse" data-parent="#faqAccordion" data-target="#faq_answer${ content.id }">
                                <h4 class="panel-title">
                                    <span style="cursor: pointer;" class="ing">Q: ${ content.title }</span>
                                </h4>
                            </div>
                            <div id="faq_answer${ content.id }" class="panel-collapse collapse" style="height: 0px;">
                                <div class="panel-body">
                                    <h5><span class="label label-primary">Answer</span></h5>
                                    <p>${ content.text }</p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <%--</ul>--%>
                </div>
            </div>

        </div>

    </div>
</div>
<jsp:include page="includes/partial/footer.jsp" />
