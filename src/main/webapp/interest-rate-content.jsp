<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-dialog large-modal">
	<div class="modal-content">
		<div class="modal-body">
				<form role="form" id="form-interest-rate" method="POST">
					<h1 class="heading">${ menu.interestRatesName }</h1>
					<fieldset>
						<legend>Select a Scheme</legend>
						<div class="form-group col-md-8">
							<select class="form-control" name="scheme" id="scheme">
								<option value="">Scheme....</option>
								<c:forEach var="scheme" items="${schemes}">
						                <option value="${scheme.id}">
						                    ${scheme.name}
						                </option>
						            </c:forEach>
							</select>
						</div>
						<div class="col-md-4">
							<button class="btn btn-primary">SHOW INTEREST RATES</button>
						</div>
					</fieldset>
				</form>
			<fieldset class="pad-top">
				<legend id="result-title">Interest Rates History</legend>
					<!-- <table class="table table-responsive table-striped" id="interest-result"> -->
					<table class="table table-responsive table-striped">
					<tr><th>${ interest.accountingPeriodText }</th><th>${ interest.openingBalancesText }</th>
					<th>${ interest.pensionDrawDownText }</th><th>${ interest.contributionsText }</th><th>STATUS</th></tr>
					<tbody id="interest-result"></tbody>						
					</table>
			</fieldset>
			<table id="datatable" class="hide">
			</table>
			<div class="row  pad-top" id="bar-chart">
				
			</div>
		</div>
	</div>
</div>