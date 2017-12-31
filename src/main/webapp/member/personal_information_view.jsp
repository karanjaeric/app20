<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section">
				<table class="table table-responsive table-striped">
					<tr><th colspan="2"><h4 class="text-center">PERSONAL DETAILS</h4></th><th colspan="2"><h4 class="text-center">CONTACT DETAILS</h4></th></tr>
					<tr><td class="right">NAME:</td><td class="left">${ member.name }</td><td class="right">EMAIL ADDRESS:</td><td class="left">${member.emailAddress }</td></tr>
					<tr><td class="right">DATE OF BIRTH:</td><td class="left">${ member.dateOfBirth }</td><td class="right">PHONE NUMBER:</td><td class="left">${member.phoneNumber }</td></tr>
					<tr><td class="right">GENDER:</td><td class="left">${ member.gender }</td><td class="right">POSTAL ADDRESS:</td><td class="left">${member.postalAddress }</td></tr>
					<tr><td class="right">MARITAL STATUS:</td><td class="left">${ member.maritalStatus }</td><td class="right">CITY/TOWN:</td><td class="left">${member.town }</td></tr>
					<tr><td class="right">ID/PASSPORT NO:</td><td class="left">${ member.idNumber }</td><td class="right">COUNTRY:</td><td class="left">${member.country }</td></tr>
					<tr><th colspan="4"><h4 class="text-center">OTHER DETAILS</h4></th></tr>
					<tr><td class="right">MEMBER NO:</td><td class="left">${ member.memberNo }</td><td class="right">ANNUAL PENSIONABLE SALARY:</td><td class="left">${member.annualPensionableSalary }</td></tr>
					<tr><td class="right">SOCIAL SECURITY NO:</td><td class="left">${ member.nationalPenNo }</td><td class="right">STAFF NUMBER:</td><td class="left">${member.staffNo }</td></tr>
					<tr><td class="right">PARTY REF NO:</td><td class="left">${ member.partyRefNo }</td><td class="right">POLICY NUMBER:</td><td class="left">${member.policyNo }</td></tr>
					<tr><td class="right">PIN NUMBER:</td><td class="left">${ member.pinNo }</td><td class="right"></td><td class="left"></td></tr>
				</table>
				
				<table class="table table-responsive table-striped">
					<tr><th colspan="3"><h4 class="text-center">BENEFICIARIES</h4></th></tr>
					<tr><th>NAME</th><th>RELATIONSHIP</th><th>ENTITLEMENT</th></tr>
					<c:forEach var="beneficiary" items="${ beneficiaries }">
						<tr><td> ${ beneficiary.name } </td><td>${ beneficiary.relationship }</td><td>${ beneficiary.lumpsumEntitlement }</td></tr>
					</c:forEach>
				</table>
			</div>