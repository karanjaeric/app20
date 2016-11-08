<div class="container-fluid section">
				<h3 class="text-center main-title">
					<i class="glyphicon glyphicon-cog"></i>&nbsp;&nbsp;SETUP &amp; CONFIGURATION
				</h3>
	<div class="col-md-6">
	<h1><i class="glyphicon glyphicon-home"></i>&nbsp;&nbsp;COMPANY DETAILS</h1>
		<table class="table table-responsive table-striped">
			<tr><th>FIELD</th><th>VALUE</th></tr>
			<tr><td>COMPANY NAME</td><td>${ company.name }</td></tr>
			<tr><td>STREET ADDRESS</td><td>${ company.streetAddress }</td></tr>
			<tr><td>TELEPHONE</td><td>${ company.telephone}</td></tr>
			<tr><td>EMAIL ADDRESS</td><td>${ email.defaultEmail }</td></tr>
			<tr><td>FAX</td><td>${ company.fax }</td></tr>
			
		</table>
	</div>	
	<div class="col-md-6">
	<h1><i class="glyphicon glyphicon-pushpin"></i>&nbsp;&nbsp;MENU OPTIONS</h1>
		<table class="table table-responsive table-striped">
			<tr><th>MENU</th><th>MENU TEXT</th><th>ACTIVE</th></tr>
			<tr><td>ANNUITY QUOTATION</td><td>${ menu.annuityQuotationName }</td><td>${ menu.annuityQuotationActive == 'TRUE' ? 'YES' : 'NO' }</td></tr>
			<tr><td>POTENTIAL MEMBER</td><td>${ menu.potentialMemberName }</td><td>${ menu.potentialMemberActive == 'TRUE' ? 'YES' : 'NO' }</td></tr>
			<tr><td>POTENTIAL SPONSOR</td><td>${ menu.potentialSponsorName }</td><td>${ menu.potentialSponsorActive == 'TRUE' ? 'YES' : 'NO' }</td></tr>
			<tr><td>INTEREST RATES</td><td>${ menu.interestRatesName }</td><td>${ menu.interestRatesActive == 'TRUE' ? 'YES' : 'NO' }</td></tr>
			<tr><td>WHAT IF ANALYSIS</td><td>${ menu.whatIfAnalysisName }</td><td>${ menu.whatIfAnalysisActive == 'TRUE' ? 'YES' : 'NO' }</td></tr>
			<tr><td>CONTACT US</td><td>${ menu.contactUsName }</td><td>${ menu.contactUsActive == 'TRUE' ? 'YES' : 'NO' }</td></tr>
		</table>
	</div>
</div>