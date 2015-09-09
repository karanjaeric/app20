<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section">
				<table class="table table-responsive table-striped">
					<tr><th colspan="2"><h4 class="text-center">PERSONAL DETAILS</h4></th><th colspan="2"><h4 class="text-center">OTHER DETAILS</h4></th></tr>
					<tr><td class="right">NAME:</td><td class="left">${ member.name } ${ member.lastname }  ${ member.othernames }</td><td class="right">EMAIL ADDRESS:</td><td class="left">${member.emailAddress }</td></tr>
					<tr><td class="right">DATE OF BIRTH:</td><td class="left">${ member.dateOfBirth }</td><td class="right">PHONE NUMBER:</td><td class="left">${member.phoneNumber }</td></tr>
					<tr><td class="right">GENDER:</td><td class="left">${ member.gender.name }</td><td class="right">RESIDENTIAL ADDRESS:</td><td class="left">${member.residentialAddress }</td></tr>
					<tr><td class="right">MARITAL STATUS:</td><td class="left">${ member.maritalStatus.name }</td><td class="right">CITY/TOWN:</td><td class="left">${member.city }</td></tr>
					<tr><td class="right">ID/PASSPORT NO:</td><td class="left">${ member.idNumber }</td><td class="right">COUNTRY:</td><td class="left">${member.country.name }</td></tr>
					<tr><th colspan="4"><h4 class="text-center">OTHER DETAILS</h4></th></tr>
					<tr><td class="right">SCHEME #:</td><td class="left">${ member.scheme }</td></tr>
					
				</table>
</div>