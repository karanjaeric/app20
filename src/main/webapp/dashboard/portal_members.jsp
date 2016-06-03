<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section">
	<div class="col-md-6">
		<h3 class=" main-title">
			<i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;POTENTIAL MEMBERS
		</h3>
	</div>
	<div class="col-md-6" align="right">
	<br />
		<form class="form-inline" id="form-search">
			<input type="text" class="form-control" name="search" id="search" placeholder="Search" value="${ search }"/>
			<button class="btn btn-info">Search</button>&nbsp; 
			<c:if test="${ permissions.portal_member_add }">
				<a href="javascript:void(0);" class="btn btn-success" id="new-member-btn" >NEW MEMBER</a>
			</c:if>
		</form>
	</div>
	<table class="table table-responsive table-striped" id="search-results">
		<tr><th>NAME</th><th>ID/PPT NUMBER</th><th>DATE OF BIRTH</th><th>GENDER</th><th>PHONE NUMBER</th><th class="right">ACTION</th></tr>
		<c:forEach var="member" items="${members}">
		<tr><td>${ member.name }</td><td>${ member.idNumber }</td><td>${ member.dateOfBirth }</td><td>${ member.gender.name }</td><td>${ member.phoneNumber }</td><td class="right">&nbsp;<c:if test="${ permissions.portal_member_view }"><button onclick="view_member('${member.id}');" class="btn btn-sm btn-info"><i class="glyphicon glyphicon-eye-open"></i>&nbsp;VIEW</button></c:if>&nbsp;<c:if test="${ member.posted == 'FALSE' }"><c:if test="${ permissions.portal_member_process }"><button class="btn btn-sm btn-warning" onclick="post_member('${member.id}');"><i class="glyphicon glyphicon-pencil"></i>&nbsp;POST TO FUNDMASTER</button></c:if>&nbsp;</c:if><c:if test="${ permissions.portal_member_view }"><button onclick="delete_member('${member.id}');" class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-eye-open"></i>&nbsp;DELETE</button></c:if></td></tr>
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
        data: {dashboard: 'PORTAL_MEMBER', page: page, batch: batch, search: $('#search').val()},
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

function view_member(id)
{

	start_wait();
	$.ajax({
        url: $('#base_url').val() + 'dashboard',
        type: 'get',
        data: {dashboard: 'VIEW_POTENTIAL_MEMBER', id: id},
        dataType: 'html',
        success: function(html) {
            $('#member-content2').html(html);
            $('#modal-view-member').modal('show');
            stop_wait();
        }
    });
	
}
function delete_member(id)
{
	bootbox.confirm("<p class='text-center'>You have requested to delete the potential member. Are you sure?</p>", function(result){
		if(result)
		{
		start_wait();
		$.ajax({
	        url: $('#base_url').val() + 'admin',
	        type: 'post',
	        data: {ACTION:'DELETE_PORTAL_MEMBER', id: id},
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
function post_member(id)
{
	bootbox.confirm("<p class='text-center'>You have requested to submit member to FundMaster Xi. Are you sure?</p>", function(result){
		if(result)
		{
		start_wait();
		$.ajax({
	        url: $('#base_url').val() + 'admin',
	        type: 'post',
	        data: {ACTION:'FORWARD_PORTAL_MEMBER', id: id},
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
$(document).ready(function(){

	$('#new-member-btn').click(function(){
		$('#modal-new-member').modal('show');
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
<div class="modal fade" id="modal-view-member" tabindex="-1" role="dialog" aria-labelledby="myModalLabelViewMember" aria-hidden="true">
<form role="form" id="form-view-member">
	<div class="modal-dialog large-modal">
		<div class="modal-content">
			<div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title" id="myModalLabelViewMember">
					<i class="glyphicon glyphicon-picture"></i>&nbsp;&nbsp;VIEW POTENTIAL MEMBER DETAILS
				</h4>
			</div>
			<div class="modal-body" id="member-content2">
							
				</div>
			</div>
		</div>
	</form>
</div>
<div class="modal fade" id="modal-edit-member" tabindex="-1" role="dialog" aria-labelledby="myModalLabelEditMember" aria-hidden="true">
<form role="form" id="form-edit-member">
			<div class="modal-dialog large-modal">
				<div class="modal-content">
					<div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title" id="myModalLabelEditMember">
							<i class="glyphicon glyphicon-picture"></i>&nbsp;&nbsp;EDIT MEMBER DETAILS
						</h4>
					</div>
					<div class="modal-body" id="member-content">
									
						</div>
					</div>
				</div>
			</form>
</div>
<div class="modal fade" id="modal-new-member" tabindex="-1" role="dialog" aria-labelledby="myModalLabelEditMember" aria-hidden="true">
<form role="form" id="form-new-member">
			<div class="modal-dialog large-modal">
				<div class="modal-content">
					<div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title" id="myModalLabelEditMember">
							<i class="glyphicon glyphicon-picture"></i>&nbsp;&nbsp;NEW MEMBER
						</h4>
					</div>
					<div class="modal-body large-modal">
									<div class="row">
														<div class="col-md-6">
														<fieldset>
															<legend>
																<i class="fa fa-user"></i> &nbsp;Personal Information
															</legend>
															<div class="form-group">
																<label for="firstName" class="control-label">First Name:</label> <input
																	type="text" name="firstName" class="form-control" id="firstName"
																	placeholder="First Name">
															</div>
															<div class="form-group">
																<label for="lastName" class="control-label">Last Name:</label> <input
																	type="text" name="lastName" class="form-control" id="lastName"
																	placeholder="Last Name">
															</div>
															<div class="form-group">
																<label for="otherName" class="control-label">Other Name:</label> <input
																	type="text" name="otherName" class="form-control" id="otherName"
																	placeholder="Other Names">
															</div>
															<div class="form-group">
																<label for="dateOfBirth" class="control-label">Date Of
																	Birth:</label> <input type="text" readonly="readonly" name="dateOfBirth"
																	class="form-control datepicker" id="dateOfBirth"
																	placeholder="Date Of Birth">
															</div>
															<div class="form-group">
																<label for="gender" class="control-label">Gender:</label> <select
																	name="gender" id="gender" class="form-control">
																	<option value="">Select gender...</option>
																	<c:forEach var="gender" items="${genders}">
														                <option value="${gender.id}">
														                    ${gender.name}
														                </option>
														            </c:forEach>
																</select>
															</div>
															<div class="form-group">
																<label for="maritalStatus" class="control-label">Marital
																	Status:</label> <select name="maritalStatus" id="maritalStatus"
																	class="form-control">
																	<option value="">Select marital status...</option>
																	<c:forEach var="maritalStatus" items="${maritalStatuses}">
														                <option value="${maritalStatus.id}">
														                    ${maritalStatus.name}
														                </option>
														            </c:forEach>
																</select>
															</div>
														</fieldset>
													</div>
													<div class="col-md-6">
														<fieldset>
															<legend>
																<i class="fa fa-phone"></i> &nbsp;Other Information
															</legend>
															<div class="form-group">
																		<label for="IdNumber" class="control-label">ID/PPT Number</label>
																		<input type="text" name="IdNumber" class="form-control input-sm"
																			id="IdNumber" placeholder="ID/PPT Number">
															</div>
															<div class="form-group">
																<label for="emailAddress" class="control-label">Email
																	Address:</label> <input type="text" name="emailAddress"
																	class="form-control" id="emailAddress"
																	placeholder="Email Address">
															</div>
															<div class="form-group">
																<label for="phoneNumber" class="control-label">Phone
																	Number:</label> <input type="text" name="phoneNumber"
																	class="form-control" id="phoneNumber" placeholder="Phone Number">
															</div>
															<div class="form-group">
																<label for="residentialAddress" class="control-label">Residential
																	Address:</label> <input type="text" name="residentialAddress"
																	class="form-control" id="residentialAddress"
																	placeholder="Residential Address">
															</div>
															<div class="form-group">
																<label for="city" class="control-label">City Or Town:</label> <input
																	type="text" name="city" class="form-control" id="city"
																	placeholder="City or Town">
															</div>
															<div class="form-group">
																<label for="country" class="control-label">Country:</label> <select
																	name="country" id="country" class="form-control">
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
																			Pension Plan:</label> <select name="pension_scheme" id="pension_scheme"
																			class="form-control" >
																			<option value="">Select pension product...</option>
																			<c:forEach var="scheme" items="${memberSchemes}">
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
					</div>
					</div>
				</div>
			</form>
</div>
<script type="text/javascript">
$(document).ready(function(){
	$('#dateOfBirth')
	.datetimepicker({
	    format: 'dd-mm-yyyy'
	})
	.on('changeDate', function(e) {
	    // Revalidate the date field
	    $('#form-new-member').bootstrapValidator('revalidateField', 'dateOfBirth');
	});
	$('#form-new-member')
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
							firstName : {
								validators : {
									notEmpty : {
										message : 'Sorry, your first name is required'
									},
									regexp : {
										regexp : /^[a-z\s]+$/i,
										message : 'Sorry, your first name can only consist of alphabetical letters & spaces'
									}
								}
							},
							lastName : {
								validators : {
									notEmpty : {
										message : 'Sorry, your last name is required'
									},
									regexp : {
										regexp : /^[a-z\s]+$/i,
										message : 'Sorry, your last name can only consist of alphabetical letters & spaces'
									}
								}
							},
							dateOfBirth : {
								validators : {
									notEmpty : {
										message : 'Sorry, your date of birth is required'
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
							residentialAddress : {
								validators : {
									notEmpty : {
										message : 'Sorry, your residential address is required'
									}
								}
							},
							city : {
								validators : {
									notEmpty : {
										message : 'Sorry, please tell us your home town'
									}
								}
							},
							country : {
								validators : {
									notEmpty : {
										message : 'Sorry, your country is required'
									}
								}
							},
							IdNumber : {
								validators : {
									notEmpty : {
										message : 'Sorry, your ID/Passport number is required'
									}
								}
							},
							gender : {
								validators : {
									notEmpty : {
										message : 'Sorry, please select your gender'
									}
								}
							},
							maritalStatus : {
								validators : {
									notEmpty : {
										message : 'Sorry, please select your marital status'
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
						// Get the form instance
						$
								.ajax({
									url : $('#base_url').val()
											+ 'admin',
									type : 'post',
									data : { ACTION: 'ADD_MEMBER',
										city : $('#city').val(),
										country : $(
												'#country')
												.val(),
										dateOfBirth : $(
												'#dateOfBirth')
												.val(),
										emailAddress : $(
												'#emailAddress')
												.val(),
										firstName : $(
												'#firstName')
												.val(),
										lastName : $(
												'#lastName')
												.val(),
										otherName : $(
												'#otherName')
												.val(),
										gender : $('#gender')
												.val(),
										idNumber : $(
												'#IdNumber')
												.val(),
										maritalStatus : $(
												'#maritalStatus')
												.val(),
										memberPassword : $(
												'#memberPassword')
												.val(),
										pension_scheme : $(
												'#pension_scheme')
												.val(),
										phoneNumber : $(
												'#phoneNumber')
												.val(),
										residentialAddress : $(
												'#residentialAddress')
												.val(),
										scheme: $('#pension_scheme').val(),
										type : 'member'
										
									},
									dataType : 'json',
									success : function(json) {
										stop_wait();
										
										if(json.success)
										{
											$("form#form-new-member")[0].reset();
											setTimeout(
													function() {
														window.location.href = $('#base_url').val();
													}, 5000)
										}
										
										bootbox.alert('<p class="text-center">'+ json.message + '</p>');
									  //load_dashboard("PORTAL_MEMBER");
									  //load_dashboard(1, 0);$('.modal-backdrop').remove();
									}
								});

					});
});
</script>