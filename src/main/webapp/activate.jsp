<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="includes/partial/header.jsp" />
<div class="container">
	<div class="main-content">
		 <div class="jumbotron">
	      <div class="container text-center">
	        <c:if test="${ success }">
	        	<h1>CONGRATULATIONS!</h1>
		        <h3>Your account has been activated. You can now proceed to login and enjoy the benefits of FundMaster Mss Portal</h3>
		        <p>&nbsp;</p>
		        <p><a class="btn btn-primary btn-lg" href="<%=request.getContextPath()%>/${ page }" role="button">Get Started Now &raquo;</a></p>
	        </c:if>
	        <c:if test="${ success == 'FALSE' }">
		        <h1>WE ARE SORRY!</h1>
		        <h3>We have reason to believe that you have arrived here in error since we did not find a valid user account to activate</h3>
		        <p>&nbsp;</p>
		        <p><a class="btn btn-primary btn-lg" href="<%=request.getContextPath()%>" role="button">Go To Home Page &raquo;</a></p>
	        </c:if>
	      </div>
	    </div>
	    </div>
	</div>

<jsp:include page="includes/partial/footer.jsp" />