<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section">
				<table class="table table-responsive table-striped">
					<tr><th colspan="2"><h4 class="text-center">BASIC DETAILS</h4></th><th colspan="2"><h4 class="text-center">OTHER DETAILS</h4></th></tr>
					<tr><td class="right">NAME:</td><td class="left">${ sponsor.companyName } </td><td class="right">EMAIL ADDRESS:</td><td class="left">${sponsor.emailAddress }</td></tr>
					<tr><td class="right">DATE OFAPPLICATION:</td><td class="left">${ sponsor.applicationDate }</td><td class="right">PHONE NUMBER:</td><td class="left">${sponsor.phoneNumber }</td></tr>
					<tr><td class="right">SCHEME #:</td><td class="left">${ sponsor.scheme }</td><td class="right">RESIDENTIAL ADDRESS:</td><td class="left">${sponsor.companyAddress }</td></tr>
					<tr><td class="right">EMPLOYER REF. NO:</td><td class="left">${ sponsor.employerRefNo }</td><td class="right">CITY/TOWN:</td><td class="left">${sponsor.city }</td></tr>
					<tr><td class="right">PIN NUMBER:</td><td class="left">${ sponsor.pinNumber }</td><td class="right">COUNTRY:</td><td class="left">${sponsor.country.name }</td></tr>
					
				</table>
</div>