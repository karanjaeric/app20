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

						<div class="form-group col-md-8" id="sponsorField" style="display:none;">
							<select id="sponsor" name="sponsor" class="form-control">
								<option value="">--Select A Sponsor--</option>
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

<script src="static/custom/vendors/jquery-1.9.1.min.js"></script>

<script type="text/javascript">

	$(document).ready(function(){

		function drawInterestRatesGraph() {
			$('#bar-chart').highcharts(
					{
						data : {
							table : 'datatable'
						},
						chart : {
							type : 'column'
						},
						title : {
							text : 'Interest Rates History'
						},
						yAxis : {
							allowDecimals : false,
							title : {
								text : '% Interest'
							}
						},
						tooltip : {
							formatter : function() {
								return '<b>'
										+ this.series.name
										+ '</b><br/>'
										+ this.point.y
										+ ' '
										+ this.point.name
												.toLowerCase();
							}
						}
					});
		}

		function initializeSponsor()
		{
			$.ajax({
				url: $('#base_url').val() + 'admin',
				type: 'post',
				data: {ACTION:'GET_SCHEME_SPONSORS', schemeId:$('#scheme').val()},
				dataType: 'json',
				success: function(json) {
					if(json.success)
					{
						json = $.parseJSON(json.data);
						console.log(json);

						var combo = "<select id=\"sponsor\" name=\"sponsor\" class=\"form-control\"><option>--Select A Sponsor--</option>";
						$.each(json, function(key, value) {
							if(key == 'rows')
							{
								for ( var i = 0; i < json.rows.length; i++) {
									var row = json.rows[i];

									combo = combo + "<option value = " + row['sponsor.id'] + ">" + row['sponsor.name'] + "</option>";

									array = json.rows;
								}
								combo = combo + "</select>";

							}
						});
						$('#sponsorField').html(combo);
					}
					else
					{
						stop_wait();
						bootbox.alert('<p class="text-center">' + json.message + '</p>');
					}
				}
			});

			$('#form-interest-rate').bootstrapValidator(
							{
								message : 'This value is not valid',
								feedbackIcons : {
									valid : 'glyphicon glyphicon-ok',
									invalid : 'glyphicon glyphicon-remove',
									validating : 'glyphicon glyphicon-refresh'
								},
								excluded: ':disabled',
								fields : {
									scheme : {
										validators : {
											notEmpty : {
												message : 'Please select the scheme'
											}
										}
									}
								}
							}).on(
					'success.form.bv',
					function(e) {
						start_wait();
						// Prevent form submission
						e.preventDefault();
						// Get the form instance
						$.ajax({
							url : $('#base_url').val() + 'interest-rates',
							type : 'post',
							data: {ACTION:'INTEREST_BY_SPONSOR', sponsorId:$('#sponsor').val()},
							dataType : 'json',
							success : function(json) {
								console.log(json);
								stop_wait();
								var message = 'Oops! We are sorry, but something unexpected just happend and we were unable to process your request. Please try again';
								if (json.success == true) {
									var fields = [
										"ap",
										"openingBalances",
										"pensionDrawDown",
										"contributions",
										"status" ];
									var html = '';
									for ( var i = 0; i < json.rows.length; i++) {
										var row = json.rows[i];
										html = html
												+ "<tr>";
										for ( var k = 0; k < fields.length; k++) {
											for ( var key in row) {
												if (key == fields[k]) {
													html = html
															+ "<td>"
															+ row[key]
															+ "</td>";
													break;
												}
											}
										}
										html = html
												+ "</tr>";
										if (i == 10)
											break;
									}

									$('#interest-result')
											.html(html);

									var fields2 = [
										"dateDeclared",
										"registered",
										"unRegistered" ];
									var html = '<thead><tr><th></th><th>REGISTERED</th><th>UNREGISTERED</th></tr></thead><tbody>';
									for ( var i = 0; i < json.rows.length; i++) {
										var row = json.rows[i];
										html = html
												+ "<tr>";
										for ( var k = 0; k < fields2.length; k++) {
											for ( var key in row) {
												if (key == fields2[k]) {
													html = html
															+ "<td>"
															+ row[key]
															+ "</td>";
													break;
												}
											}
										}
										html = html
												+ "</tr>";
									}
									html = html
											+ "</tbody>";
									$('#datatable')
											.html(html);
									drawInterestRatesGraph();
								}

								if (!json.success)
									bootbox
											.alert('<p class="text-center">'
													+ message
													+ '</p>');
							}
						});
					});

		}

		function initializeScheme()
		{
			$('#form-interest-rate')
					.bootstrapValidator(
							{
								message : 'This value is not valid',
								feedbackIcons : {
									valid : 'glyphicon glyphicon-ok',
									invalid : 'glyphicon glyphicon-remove',
									validating : 'glyphicon glyphicon-refresh'
								},
								excluded: ':disabled',
								fields : {
									scheme : {
										validators : {
											notEmpty : {
												message : 'Please select the scheme'
											}
										}
									}
								}
							}).on(
					'success.form.bv',
					function(e) {
						start_wait();
						// Prevent form submission
						e.preventDefault();
						// Get the form instance
						$.ajax({
							//url : $('#base_url').val() + 'interest-rates',
                            url: $('#base_url').val() + 'unit-prices',

                            type : 'post',
							//data: {ACTION:'INTEREST_BY_SCHEME', scheme : $('#scheme').val()},
                            data: {ACTION: 'CURRENT_UNIT_PRICE'},

                            dataType : 'json',
							success : function(json) {
								console.log(json);
								stop_wait();
								var message = 'Oops! We are sorry, but something unexpected just happend and we were unable to process your request. Please try again';
								if (json.success == true) {
									var fields = [
										"ap",
										"openingBalances",
										"pensionDrawDown",
										"contributions",
										"status" ];
									var html = '';
									for ( var i = 0; i < json.rows.length; i++) {
										var row = json.rows[i];
										html = html
												+ "<tr>";
										for ( var k = 0; k < fields.length; k++) {
											for ( var key in row) {
												if (key == fields[k]) {
													html = html
															+ "<td>"
															+ row[key]
															+ "</td>";
													break;
												}
											}
										}
										html = html
												+ "</tr>";
										if (i == 10)
											break;
									}

									$('#interest-result')
											.html(html);

									var fields2 = [
										"dateDeclared",
										"registered",
										"unRegistered" ];
									var html = '<thead><tr><th></th><th>REGISTERED</th><th>UNREGISTERED</th></tr></thead><tbody>';
									for ( var i = 0; i < json.rows.length; i++) {
										var row = json.rows[i];
										html = html
												+ "<tr>";
										for ( var k = 0; k < fields2.length; k++) {
											for ( var key in row) {
												if (key == fields2[k]) {
													html = html
															+ "<td>"
															+ row[key]
															+ "</td>";
													break;
												}
											}
										}
										html = html
												+ "</tr>";
									}
									html = html
											+ "</tbody>";
									$('#datatable')
											.html(html);
									drawInterestRatesGraph();
								}

								if (!json.success)
									bootbox
											.alert('<p class="text-center">'
													+ message
													+ '</p>');
							}
						});
					});

		}

		$('#scheme').on('change',function(){

			var schemeSelected = $('#scheme').val();
			console.log("Scheme selected:  " + schemeSelected);

			$.ajax({
				url: $('#base_url').val() + 'admin',
				type: 'post',
				data: {ACTION:'SCHEME_MODE', scheme:schemeSelected},
				dataType: 'json',
				success: function(json) {
					if(json.success)
					{
						json = $.parseJSON(json.data);
						console.log(json);

						if(json.name === 'Umbrella'){
							$("#sponsorField").show()
							initializeSponsor()
						} else{
							$("#sponsorField").hide()
							initializeScheme()
						}
					}
					else
					{
						stop_wait();
						bootbox.alert('<p class="text-center">' + json.message + '</p>');
					}
				}
			});

		});

	});

</script>