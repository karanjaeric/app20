<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section">
	<div class="col-md-6">
		<h3 class=" main-title">
			<i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;POTENTIAL SPONSORS
		</h3>
	</div>
	<div class="col-md-6" align="right">
	<br />
		<form class="form-inline" id="form-search">
			<input type="text" class="form-control" name="search" id="search" placeholder="Search" value="${ search }"/>
			<button class="btn btn-info">Search</button>&nbsp; 
			<c:if test="${ permissions.portal_sponsor_add }">
				<a href="javascript:void(0);" class="btn btn-success" id="new-sponsor-btn">NEW SPONSOR</a>
			</c:if>
		</form>
	</div>
	<table class="table table-responsive table-striped" id="search-results">
		<tr><th>NAME</th><th>PIN NUMBER</th><th>DATE OF APPLICATION</th><th>EMPLOYER REF #</th><th>PHONE NUMBER</th><th class="right">ACTION</th></tr>
		<c:forEach var="sponsor" items="${sponsors}">
		<tr><td>${ sponsor.companyName }</td><td>${ sponsor.pinNumber }</td><td>${ sponsor.applicationDate }</td><td>${ sponsor.employerRefNo }</td><td>${ sponsor.phoneNumber }</td><td class="right">&nbsp;<c:if test="${ permissions.portal_sponsor_view }"><button onclick="view_sponsor('${sponsor.id}');" class="btn btn-sm btn-info"><i class="glyphicon glyphicon-eye-open"></i>&nbsp;VIEW</button></c:if>&nbsp;<c:if test="${ sponsor.posted == 'FALSE' }"><c:if test="${ permissions.portal_sponsor_process }"><button class="btn btn-sm btn-warning" onclick="post_sponsor('${sponsor.id}');"><i class="glyphicon glyphicon-pencil"></i>&nbsp;POST TO FUNDMASTER</button></c:if>&nbsp;</c:if><c:if test="${ permissions.portal_sponsor_view }"><button onclick="delete_sponsor('${sponsor.id}');" class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-eye-open"></i>&nbsp;DELETE</button></c:if></td></tr>
		</c:forEach>
	</table>
	 <ul class="pagination pull-right">
		 <c:if test="${ batch > 1 }">
		 	<li><a href="javascript:void(0);" onclick="load_dashboard(${ page > per_page ? page - per_page : page }, ${ batch - 1 })">&laquo;</a></li>
		 </c:if>
		 <c:forEach begin="${ begin }" end="${ pages > (begin + (per_page - 1)) ? (begin + (per_page - 1)) : pages }" varStatus="loop">
		  <c:choose>
		  	<c:when test="${ page == loop.index }">
		  		<li class="active"><a href="javascript:void(0);">${ loop.index }</a></li>
		  	</c:when>
		  	<c:otherwise>
		  		<li><a href="javascript:void(0);" onclick="load_dashboard(${ loop.index }, ${ batch })">${ loop.index }</a></li>
		  	</c:otherwise>
		  </c:choose>
		</c:forEach>
		<c:if test="${ pages > begin + (per_page - 1)}">
			<li><a href="javascript:void(0);" onclick="load_dashboard(${ pages < page + per_page ? pages : page + per_page }, ${ batch + 1 })">&raquo;</a></li>
		</c:if>
	</ul>
</div>
<script type="text/javascript">

function load_dashboard(page, batch)
{
	start_wait();
	$.ajax({
        url: $('#base_url').val() + 'dashboard',
        type: 'get',
        data: {dashboard: 'SPONSOR', page: page, batch: batch},
        dataType: 'html',
        success: function(html) {
            $('#dashboard').fadeOut('slow', function() {
            	$('#dashboard').html(html);
            	$('#dashboard').fadeIn('slow');
            	stop_wait();
            });
        }
    });
}
function delete_sponsor(id)
{
	bootbox.confirm("<p class='text-center'>You have requested to delete the potential sponsor. Are you sure?</p>", function(result){
		if(result)
		{
			start_wait();
			$.ajax({
		        url: $('#base_url').val() + 'admin',
		        type: 'POST',
		        data: {ACTION: 'DELETE_PORTAL_SPONSOR', id: id},
		        dataType: 'json',
		        success: function(json) {
		            
					stop_wait();
					bootbox.alert(json.message);
		            load_dashboard(1, 0);
		            $('.modal-backdrop').remove();
		        }
		    });
		}
	});
}
function post_sponsor(id)
{
	bootbox.confirm("<p class='text-center'>You have requested to submit sponsor to FundMaster Xi. Are you sure?</p>", function(result){
		if(result)
		{
		start_wait();
		$.ajax({
	        url: $('#base_url').val() + 'admin',
	        type: 'post',
	        data: {ACTION:'FORWARD_PORTAL_SPONSOR', id: id},
	        dataType: 'json',
	        success: function(json) {
				stop_wait();
				bootbox.alert(json.message);
	            load_dashboard(1, 0);
	            $('.modal-backdrop').remove();
	        }
		});
		}
	});
}
function view_sponsor(id)
{
	start_wait();
	$.ajax({
        url: $('#base_url').val() + 'dashboard',
        type: 'get',
        data: {dashboard:'VIEW_SPONSOR', id: id},
        dataType: 'html',
        success: function(html) {
			$('#sponsor-content2').html(html);
			$('#modal-view-sponsor').modal('show');
			
			stop_wait();
        }
	});
}
$(document).ready(function(){

	$('#new-sponsor-btn').click(function(){
		$('#modal-new-sponsor').modal('show');
	});
	$('#form-search').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            search: {
                validators: {
                    notEmpty: {
                        message: 'Please enter the search criterion'
                    }
                }
            }
           
        }
	})
	.on('success.form.bv', function(e) {


        if($('#search').val() != '' && $('#profile').val() != '')
        {
            // Prevent form submission
            e.preventDefault();
			load_dashboard(1, 0);
        }
	});
});

</script>
<div class="modal fade" id="modal-view-sponsor" tabindex="-1" role="dialog" aria-labelledby="myModalLabelViewMember" aria-hidden="true">
<form role="form" id="form-view-sponsor">
	<div class="modal-dialog large-modal">
		<div class="modal-content">
			<div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title" id="myModalLabelViewMember">
					<i class="glyphicon glyphicon-picture"></i>&nbsp;&nbsp;SPONSOR DETAILS
				</h4>
			</div>
			<div class="modal-body" id="sponsor-content2">
							
				</div>
			</div>
		</div>
	</form>
</div>
<div class="modal fade" id="modal-new-sponsor" tabindex="-1" role="dialog" aria-labelledby="myModalLabelNewSponsor" aria-hidden="true">
<form role="form" id="form-new-sponsor">
	<div class="modal-dialog large-modal">
		<div class="modal-content">
			<div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title" id="myModalLabelNewSponsor">
					<i class="glyphicon glyphicon-picture"></i>&nbsp;&nbsp;NEW SPONSOR
				</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" method="post" id="form-new-sponsor">
												<div class="row">
														<div class="col-md-6">
														<fieldset>
															<legend>
																<i class="fa fa-user"></i> &nbsp;Company Information
															</legend>
															<div class="form-group">
																<label for="companyName" class="control-label">Company Name:</label> <input
																	type="text" name="companyName" class="form-control" id="companyName"
																	placeholder="Company Name">
															</div>
															<div class="form-group">
																<label for="companyApplicationDate" class="control-label">Application Date:</label> <input type="text" readonly="readonly" name="companyApplicationDate"
																	class="form-control datepicker" id="companyApplicationDate"
																	placeholder="Application Date">
															</div>
															<div class="form-group">
																<label for="pinNumber" class="control-label">PIN Number:</label> <input type="text" name="pinNumber" class="form-control"
																	id="pinNumber" placeholder="PIN Number">
															</div>
															<div class="form-group">
																<label for="employerNumber" class="control-label">Employer Ref/No:</label> <input type="text" name="employerNumber" class="form-control"
																	id="employerNumber" placeholder="Employer Number">
															</div>
															<div class="form-group">
																<label for="sector" class="control-label">Sector:</label> <select
																	name="sector" id="sector" class="form-control">
																	<option value="">Select sector...</option>
																	<c:forEach var="sector" items="${sectors}">
														                <option value="${sector.id}">
														                    ${sector.name}
														                </option>
														            </c:forEach>
																</select>
															</div>
														</fieldset>
													</div>
													<div class="col-md-6">
														<fieldset>
															<legend>
																<i class="fa fa-phone"></i> &nbsp;Contact Information
															</legend>
															<div class="form-group">
																<label for="companyEmail" class="control-label">Email
																	Address:</label> <input type="text" name="companyEmail"
																	class="form-control" id="companyEmail"
																	placeholder="Email Address">
															</div>
															<div class="form-group">
																<label for="companyPhone" class="control-label">Phone
																	Number:</label> <input type="text" name="companyPhone"
																	class="form-control" id="companyPhone" placeholder="Phone Number">
															</div>
															<div class="form-group">
																<label for="companyAddress" class="control-label">Company
																	Address:</label> <input type="text" name="companyAddress"
																	class="form-control" id="companyAddress"
																	placeholder="Company Address">
															</div>
															<div class="form-group">
																<label for="companyCity" class="control-label">City Or Town:</label> <input
																	type="text" name="companyCity" class="form-control" id="companyCity"
																	placeholder="City or Town">
															</div>
															<div class="form-group">
																<label for="country" class="control-label">Country:</label> <select
																	name="companyCountry" id="companyCountry" class="form-control">
																	<option value="">Select country...</option>
																	<c:forEach var="country" items="${countries}">
														                <option value="${country.id}">
														                    ${country.name}
														                </option>
														            </c:forEach>
																</select>
															</div>
														</fieldset>
													</div>
												</div>
												<div class="row">
													<fieldset>
														<legend>
															<i class="glyphicon glyphicon-th"></i>&nbsp; Pension Plan
														</legend>
														<div class="form-group col-md-6">
															<label for="pension_scheme" class="control-label">Preferred
																Pension Product:</label> <select name="pension_scheme" id="pension_scheme"
																class="form-control" >
																<option value="">Select pension product...</option>
																<c:forEach var="scheme" items="${sponsorSchemes}">
													                <option value="${scheme.id}">
													                    ${scheme.name}
													                </option>
													            </c:forEach>
															</select>
														</div>
														<div class="col-md-6">
															<p>&nbsp;</p>
															<button class="btn btn-primary btn-block">REGISTER</button>
														</div>
													</fieldset>
												</div>
											</form>
			</div>
			</div>
		</div>
	</form>
</div>
<script type="text/javascript">
$('#companyApplicationDate')
.datetimepicker({
	 language:  'en',
     weekStart: 1,
     todayBtn:  1,
     autoclose: 1,
     todayHighlight: 1,
     startView: 2,
     minView: 2,
     forceParse: 0,
     format: 'dd-mm-yyyy'
})
.on('changeDate', function(e) {
    // Revalidate the date field
    $('#form-new-sponsor').bootstrapValidator('revalidateField', 'companyApplicationDate');
});
$('#form-new-sponsor')
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
						companyName : {
							validators : {
								notEmpty : {
									message : 'Sorry, company name is required'
								},
								regexp : {
									regexp : /^[a-z\s]+$/i,
									message : 'Sorry, company name can only consist of alphabetical letters & spaces'
								}
							}
						},
						companyApplicationDate : {
							validators : {
								notEmpty : {
									message : 'Sorry, the application date is required'
								}
							}
						},
						companyEmail : {
							validators : {
								notEmpty : {
									message : 'Sorry, company email address is required'
								},
								emailAddress : {
									message : 'Oops! This doesn\'t look like a valid email address'
								}
							}
						},
						companyPhone : {
							validators : {
								notEmpty : {
									message : 'Sorry, the phone number is required'
								}
							}
						},
						companyAddress : {
							validators : {
								notEmpty : {
									message : 'Sorry, the company address is required'
								}
							}
						},
						companyCity : {
							validators : {
								notEmpty : {
									message : 'Sorry, the company town or city is required'
								}
							}
						},
						companyCountry : {
							validators : {
								notEmpty : {
									message : 'Sorry, the company country is required'
								}
							}
						},
						pinNumber : {
							validators : {
								notEmpty : {
									message : 'Sorry, the company PIN number is required'
								}
							}
						},
						sector : {
							validators : {
								notEmpty : {
									message : 'Sorry, please select the company sector'
								}
							}
						},
						employerNumber : {
							validators : {
								notEmpty : {
									message : 'Sorry, the company\'s employer number is required'
								}
							}
						},
						pension_scheme : {
							validators : {
								notEmpty : {
									message : 'Sorry, please select your prefered pension scheme'
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
					
					//var btn = "btn-media";
	                var form = "form-new-sponsor";
	                var modal = "modal-new-sponsor";
					
					// Get the form instance
					$
							.ajax({
								url : $('#base_url').val()
										+ 'admin',
								type : 'post',
								data : {
									ACTION: 'ADD_SPONSOR',
									name: $('#companyName').val(),
									applicationDate: $('#companyApplicationDate').val(),
									pinNo: $('#pinNumber').val(),
									employerNo: $('#employerNumber').val(),
									sector: $('#sector').val(),
									email: $('#companyEmail').val(),
									phone: $('#companyPhone').val(),
									address: $('#companyAddress').val(),
									city: $('#companyCity').val(),
									country: $('#companyCountry').val(),
									scheme: $('#pension_scheme').val(),
									type : 'sponsor'
								}
									
									,
								dataType : 'json',
								
									success: function(json) {
				        	            stop_wait();
				        	            if(json.success)
				        	            {
				        	                $('#' + form)[0].reset();
				        	                $('#' + modal).modal('hide');
				        	            }
				        	            bootbox.alert(json.message);
				        	        }
							});

				});
</script>