<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta content="width=device-width, initial-scale=1, maximum-scale=1"
	name="viewport" />
<title>${ company.name }</title>
<meta content="bryanitur" name="author" />
<link
	href='http://fonts.googleapis.com/css?family=${ theme.font }'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.5/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.5/css/bootstrap-multiselect.css" />
<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.5/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" type="text/css"
	href="static/font-awesome-4.3.0/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css"
	href="static/custom/css/styles.css" />
<link rel="stylesheet" type="text/css"
	href="static/custom/css/bootstrap.vertical-tabs.css" />
<link rel="icon" href="static/images/favicon.ico">

<style type="text/css">
body {
	font-family: '${theme.font}';
	font-size: 11px;
}
<c:if test="${theme.header != ''}">
.navbar-default {
	background: ${ theme.header};
}
</c:if>
<c:if test="${theme.footer != ''}">
.footer {
	background: ${ theme.footer};
}
</c:if>
<c:if test="${theme.content != ''}">
.main-content {
	background: ${ theme.content};
}
</c:if>
<c:if test="${theme.major != ''}">
.nav-pills > li.active > a, .nav-pills > li.active > a:focus, .nav-pills > li.active > a:hover {
	color: #FFF;
	background-color: ${ theme.major};
}
.tabs-left > li.active > a, .nav > li > a:focus {
	color: #ffffff;
	font-weight:Semibold;
	font-style: italic;
	background: ${theme.major};
}
	.btn-warning {
	    color: #FFF;
	    background-color: ${ theme.major};
	    border-color: ${ theme.major};
	}
	.btn-warning:hover {
	    color: #FFF;
	    background-color: ${ theme.major};
	    border-color: ${ theme.major};
	}
</c:if>
<c:if test="${theme.minor != ''}">
	.btn-success {
	    color: #FFF;
	    background-color: ${ theme.minor};
	    border-color: ${ theme.minor};
	}
	.btn-success:hover {
	    color: #FFF;
	    background-color: ${ theme.minor};
	    border-color: ${ theme.minor};
	}
	
</c:if>
<c:if test="${theme.minor != ''}">	
	.navbar-default .navbar-nav>li>a:hover {
		text-transform: uppercase;
		font-weight: bold;
		color: #ffffff;
		background: ${ theme.minor};
	}
</c:if>

<c:if test="${theme.other != ''}">
	.btn-primary {
	    color: #FFF;
	    background-color: ${ theme.other};
	    border-color: ${ theme.other};
	}
	.btn-primary:hover {
	    color: #FFF;
	    background-color: ${ theme.other};
	    border-color: ${ theme.other};
	}
</c:if>
.modal.in .modal-dialog {
    top: 30%;
}
</style>
</head>
<body oncontextmenu="return false">
<input type="hidden" name="message" id="message" value="${ message }" />
								<c:if test="${noMenu == 'FALSE'}">
		<nav id="main-nav" class="navbar navbar-default navbar-fixed-top"
			role="imageBanner">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<p class="logo">
					<!--<c:forEach var="logo" items="${logos}">-->
					<img src="${pageContext.request.contextPath}/logos/${ logo.id }" alt="logo" width="180" />
					<!--</c:forEach>-->
					</p>
				</div>
				<div class="collapse navbar-collapse navbar-right">
				
					<p class="top-contact">
						Contact Us Today! <a href="mailto:${ company.email }">${company.email}</a>
						| ${company.telephone}
						 &nbsp;
						<c:if test="${social.twitter != ''}">
						<a  href="${ social.twitter }" target="_blank">
							<img src="static/images/icons/twitter.png" alt="Twitter" width="30" />
						</a>
						&nbsp;
						</c:if>
						<c:if test="${social.facebook != ''}">
						<a  href="${ social.facebook }" target="_blank">
							<img src="static/images/icons/facebook.png" alt="Facebook" width="30" />
						</a>
						&nbsp;
						</c:if>
						<c:if test="${social.linkedin != ''}">
						<a  href="${ social.linkedin }" target="_blank">
							<img src="static/images/icons/linkedin.png" alt="LinkedIn" width="30" />
						</a>
						&nbsp;
						</c:if>
						<c:if test="${social.google != ''}">
						<a  href="${ social.google }" target="_blank">
							<img src="static/images/icons/google.png" alt="Google" width="30" />
						</a>
						&nbsp;
						</c:if>
						<c:if test="${social.youtube != ''}">
						<a  href="${ social.youtube }" target="_blank">
						<img src="static/images/icons/youtube.png" alt="Youtube" width="30" />
						</a>
						&nbsp;
						</c:if>
						<c:if test="${social.pinterest != ''}">
						<a  href="${ social.pinterest }" target="_blank">
							<img src="static/images/icons/pinterest.png" alt="Pinterest" width="30" />
						</a>
						</c:if>
					</p>
					<div class="row">
						<div class="col-md-9">
							<ul class="nav navbar-nav">
							
								<li><a href="<%=request.getContextPath()%>">Home</a></li>
								
								<c:if test="${menu.annuityQuotationActive == 'TRUE'}">
								<li><a
									href="<%=request.getContextPath()%>/annuity-quotation">${ menu.annuityQuotationName }</a></li>
								</c:if>
								
								<c:if test="${menu.whatIfAnalysisActive == 'TRUE'}">
								<li><a
									href="<%=request.getContextPath()%>/what-if-analysis">${ menu.whatIfAnalysisName }</a></li>
								</c:if>
									
								<c:if test="${menu.potentialMemberActive == 'TRUE' || menu.potentialSponsorActive == 'TRUE' || menu.interestRatesActive == 'TRUE'}">
								
								<li class="dropdown">
          						<a href="#" data-toggle="dropdown" class="dropdown-toggle">Other Options <b class="caret"></b></a>
            					<ul class="dropdown-menu">
            					
            					<c:if test="${menu.interestRatesActive == 'TRUE'}">
								<li><a href="<%=request.getContextPath()%>/interest-rates">${ menu.interestRatesName }</a></li>
								</c:if>
								
            					<c:if test="${menu.potentialMemberActive == 'TRUE'}">
								<li><a
									href="<%=request.getContextPath()%>/potential-member">${ menu.potentialMemberName }</a></li>
								</c:if>
								
								<c:if test="${menu.potentialSponsorActive == 'TRUE'}">
								<li><a
									href="<%=request.getContextPath()%>/potential-sponsor">${ menu.potentialSponsorName }</a></li>
								</c:if>

            					</ul>
        						</li>
								
								</c:if>
        								
								<c:if test="${menu.contactUsActive == 'TRUE'}">
								<li><a
									href="<%=request.getContextPath()%>/contact-us">${ menu.contactUsName }</a></li>
								</c:if>
							</ul>
						</div>
						<div class="col-md-3 calls-to-action hidden-sm hidden-xs">
							<a class="btn btn-sm btn-warning"
								href="<%=request.getContextPath()%>/sign-in"><strong>Sign
									In</strong></a> <a class="btn btn-sm btn-success"
								href="<%=request.getContextPath()%>/register"><strong>Register</strong></a>
						</div>
					</div>
				</div>
			</div>
			<!--/.container-->
		</nav>
		</c:if>
		<!--/nav-->