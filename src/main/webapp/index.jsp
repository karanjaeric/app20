<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="includes/partial/header.jsp" />
<div class="banner-image container">
<div id="myCarousel" class="carousel slide" data-ride="carousel">

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
  <c:set var="count" value="0" scope="page" />
  <c:forEach var="banner" items="${banners}">
  <c:if test="${ count == 0 }">  
    <div class="item active">
      <img src="<%=request.getContextPath()%>/static/images/banner/${ banner.name }" style="float:center;">
      <c:set var="count" value="${count + 1}" scope="page"/>
    </div>
  </c:if>
   <c:if test="${ count > 0 }">  
    <div class="item">
      <img src="<%=request.getContextPath()%>/static/images/banner/${ banner.name }" style="float:center;">
      <c:set var="count" value="${count + 1}" scope="page"/>
    </div>
  </c:if>
  </c:forEach>
  </div>
</div>
	<div class="col-sm-7 hidden-md hidden-lg ">
		<div class="register-box-mobile">
			<h3>You can now access your personalized pension information</h3>
			<h4>Enter your details below to get started</h4>
			<hr>
			<form class="register-form"
				action="<%=request.getContextPath()%>/sign-in" method="post"
				id="form-sign-in-mobile">
				<div class="form-group">
					<label class="control-label">${ plf }</label> <input
						class="form-control" type="text" placeholder="${ plf }"
						name="usernameMobile" id="usernameMobile">
				</div>
				<div class="form-group">
					<label class="control-label">Password</label> <input
						class="form-control" type="password" placeholder="Password" id="passwordMobile"
						name="passwordMobile">
				</div>
			<img src="<%=request.getContextPath() %>/static/images/logo-brand.png" class="img-brand"/>
				<button class="btn btn-sm btn-warning btn-block" type="submit">
					<strong>SIGN IN</strong>
				</button>
				<p class="br-separator">-- OR --</p>
				<a class="btn btn-sm btn-success btn-block"
					href="<%=request.getContextPath()%>/register"><strong>REGISTER</strong></a>
			</form>
		</div>
	</div>
	<div class="col-sm-7  hidden-sm hidden-xs">
	</div>
	<div class="col-sm-5 register-box-container hidden-sm hidden-xs">
		<div class="register-box-normal">
			<h3>You can now access your personalized pension information</h3>
			<h4>Enter your details below to get started</h4>
			<hr>
			<form class="register-form"
				action="<%=request.getContextPath()%>/sign-in" method="post"
				id="form-sign-in">
				<div class="form-group">
					<label class="control-label">${ plf }</label> <input
						class="form-control" type="text" placeholder="${ plf }"
						name="username" id="username">
				</div>
				<div class="form-group">
					<label class="control-label">Password</label> <input
						class="form-control" type="password" placeholder="Password" id="password"
						name="password">
				</div>
			<img src="<%=request.getContextPath() %>/static/images/logo-brand.png" class="img-brand"/>
				<button class="btn btn-sm btn-warning btn-block" type="submit">
					<strong>SIGN IN</strong>
				</button>
				<p class="br-separator">&nbsp;</p>
				<a class="btn btn-sm btn-info col-md-7" href="javascript:void(0);" id="pwd-reset-btn" ><strong>Forgot your password?</strong>
				</a>
				<div class="col-md-1">
				</div>
				<a class="btn btn-sm btn-success col-md-4"
					href="<%=request.getContextPath()%>/register"><strong>REGISTER</strong>
				</a>
			</form>
		</div>
	</div>
</div>
<div class="container how-it-works">
	${ content.text }
</div>
<jsp:include page="includes/partial/footer.jsp" />

