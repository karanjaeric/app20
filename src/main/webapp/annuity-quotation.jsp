<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="includes/partial/header.jsp" />
<div class="container">
<div class="main-content">
		<c:if test="${ content.publish }">
			<c:if test="${content.position == 'LEFT' }">
				<div class="col-md-4 col-sm-6">
					${ content.text }
				</div>
				<div class="col-md-8 col-sm-6">
					<jsp:include page="annuity-quote.jsp" />
				</div>
			</c:if>
			<c:if test="${content.position == 'RIGHT' }">
				<div class="col-md-8 col-sm-6">
					<jsp:include page="annuity-quote.jsp" />
				</div>
				<div class="col-md-4 col-sm-6">
					${ content.text }				
				</div>
			</c:if>
			<c:if test="${content.position == 'TOP' }">
				<div class="row">
					${ content.text }	
				</div>
				<div class="row">
					<jsp:include page="annuity-quote.jsp" />				
				</div>
			</c:if>
			<c:if test="${content.position == 'BOTTOM' }">
				<div class="row">
					<jsp:include page="annuity-quote.jsp" />
				</div>
				<div class="row">	
					${ content.text }				
				</div>
			</c:if>
		</c:if>
		<c:if test="${ content.publish == 'FALSE' }">
			<jsp:include page="annuity-quote.jsp" />
		</c:if>
	</div>
</div>
<jsp:include page="includes/partial/footer.jsp" />