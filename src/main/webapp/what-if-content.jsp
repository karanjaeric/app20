<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
		<form role="form" id="form-analysis">
			<h1 class="heading">${ menu.whatIfAnalysisName }</h1>
				<fieldset>
					<legend>Calculation Parameters</legend>
					<div class="col-md-3">
						<div class="form-group">
							<label for="openingBalance" class="control-label">Email</label> <input
								type="text" name="emailAddress" class="form-control" id="emailAddress"
								placeholder="Email Address">
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label for="monthlyContributions" class="control-label">Phone</label> <input
								type="text" name="phoneNumber" class="form-control" id="phoneNumber"
								placeholder="Phone Number">
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
									<label for="openingBalance" class="control-label">Opening Balance:</label> <input
										type="text" name="openingBalance" class="form-control" id="openingBalance"
										placeholder="0.00">
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
									<label for="monthlyContributions" class="control-label">Monthly Contributions:</label> <input
										type="text" name="monthlyContributions" class="form-control" id="monthlyContributions"
										placeholder="0.00">
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
									<label for="rateOfReturn" class="control-label">Current Rate Of Return (Income):</label> <input
										type="text" name="rateOfReturn" class="form-control" id="rateOfReturn"
										placeholder="0.00">
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
									<label for="annualGrowthRate" class="control-label">Salary Annual Growth Rate:</label> <input
										type="text" name="annualGrowthRate" class="form-control" id="annualGrowthRate"
										placeholder="0.00">
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
									<label for="inflationRate" class="control-label">Current Inflation Rate:</label> <input
										type="text" name="inflationRate" class="form-control" id="inflationRate"
										placeholder="0.00">
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
									<label for="yourAge" class="control-label">You Age:</label> <input
										type="text" name="yourAge" class="form-control" id="yourAge"
										placeholder="0">
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
									<label for="ageTo" class="control-label">Age to Project To:</label> <input
										type="text" name="ageTo" class="form-control" id="ageTo"
										placeholder="0">
						</div>
					</div>
					<div class="col-md-3">
									<p>&nbsp;</p>
									<button class="btn btn-primary">Calculate</button>
					</div>
				</fieldset>
				<p>&nbsp;</p>
			</form>
		<h3>PROJECTED RESULTS</h3>
		
		<table class="table table-responsive table-striped results hide">
			<tr><td class="right">PROJECTED ROR:</td><td class="left" id="projectedROR">0.00</td><td class="right">PROJECTED CONTRIBUTIONS:</td><td class="left" id="projectedContrs">0.00</td><td class="right">PROJECTED MONTHLY CONTRIBUTIONS:</td><td class="left" id="projectedMonthlyContrs">0.00</td></tr>
		</table>
</div>
	<c:if test="${ showScript }">
	<script type="text/javascript">
		$(document).ready(function(){
			$('#form-analysis')
			.bootstrapValidator(
					{
						message : 'This value is not valid',
						feedbackIcons : {
							valid : 'glyphicon glyphicon-ok',
							invalid : 'glyphicon glyphicon-remove',
							validating : 'glyphicon glyphicon-refresh'
						},
						fields : {
							monthlyContributions : {
								validators : {
									notEmpty : {
										message : 'Please enter the monthly contributions'
									},
									numeric : {
										message : 'This value can and must only be a number'
									}
								}
							},
							rateOfReturn : {
								validators : {
									notEmpty : {
										message : 'Please enter the income rate of return'
									},
									numeric : {
										message : 'This value can and must only be a number'
									}
								}
							},
							emailAddress : {
								validators : {
									notEmpty : {
										message : 'Sorry, your email address is required'
									},
									emailAddress : {
										message : 'Oops! This doesn\'t look like a valid email address'
									}
								}
							},
							phoneNumber : {
								validators : {
									notEmpty : {
										message : 'Sorry, your phone number is required'
									}
								}
							},
							annualGrowthRate : {
								validators : {
									notEmpty : {
										message : 'Please enter the annual salary growth rate'
									},
									numeric : {
										message : 'This value can and must only be a number'
									}
								}
							},
							inflationRate : {
								validators : {
									notEmpty : {
										message : 'Please enter the current inflation rate'
									},
									numeric : {
										message : 'This value can and must only be a number'
									}
								}
							},
							yourAge : {
								validators : {
									notEmpty : {
										message : 'Please enter your current age'
									},
									numeric : {
										message : 'This value can and must only be a number'
									}
								}
							},
							ageTo : {
								validators : {
									notEmpty : {
										message : 'Please enter the age to project to'
									},
									numeric : {
										message : 'This value can and must only be a number'
									}
								}
							}
						}
					})
			.on(
					'success.form.bv',
					function(e) {
						start_wait();
						// Prevent form submission
						e.preventDefault();
						// Get the form instance
						$
								.ajax({
									url : $('#base_url').val()
											+ 'what-if-analysis',
									type : 'post',
									data : {
										contributions : $(
												'#monthlyContributions')
												.val(),
										rateOfReturn : $(
												'#rateOfReturn')
												.val(),
										salaryEscalationRate : $(
												'#annualGrowthRate')
												.val(),
										inflationRate : $(
												'#inflationRate')
												.val(),
										emailAddress: $(
												'#emailAddress')
												.val(),
										phoneNumber: $(
												'#phoneNumber')
												.val(),
										yourAge: $(
												'#yourAge')
												.val(),
										yearsToProject : parseFloat($(
												'#ageTo').val())
												- parseFloat($(
														'#yourAge')
														.val())
									},
									dataType : 'json',
									success : function(json) {
										stop_wait();
										if (json.success) {

											console.log(json)

											json = $.parseJSON(json.data);

											$('.results').removeClass('hide');
											$('#projectedROR').html(format_no(json.projectedROR));
											$('#projectedContrs').html(format_no(json.projectedContrs));
											$('#projectedMonthlyContrs').html(format_no(json.projectedMonthlyContrs));
										} else {
											bootbox
													.alert(json.message);
										}
									}
								});

					});
		});
	</script>
	</c:if>