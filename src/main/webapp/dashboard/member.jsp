<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section">
	<div class="col-md-12">
		<h3 class=" main-title" align="center">
			<i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;MEMBERS
		</h3>
	</div>
	<div class="col-md-8">
	<br />
		<!--<form class="form-inline" id="form-search">
		     <select name="profile" id="profile" class="form-control">
		     	<option ${ profile == 'MEMBER' ? 'selected="selected"' : '' }>MEMBER</option>
		     	<option>TRUSTEE</option>
		     	<option>SPONSOR</option>
		     	<option>AGENT</option>
		     	<option>CUSTODIAN</option>
		     	<option>CRM</option>
		     	<option>CRE</option>
		     	<option>FUND_MANAGER</option>
		     	<option>PENSIONER</option>
		     </select>
			 <select name="identifier" id="identifier" class="form-control">
			 		<option value="MEMBER_NO">Member No</option>	 	
			 		<option value="VOTER">Voter No</option>	
			 		<option value="PASSPORT">Passport No</option>	
			 		<option value="PENNO">Pension No</option>	
			 		<option value="NATIONAL">National ID</option>	
			 		<option value="DRIVER">Driving Lic. No</option>	
			 		<option value="STAFF">Staff No</option>	
			 		<option value="PIN">PIN No</option>	
			 		<option value="EMAIL">Email Address</option>	
			 		<option value="NHIF">NHIF</option>	
			 		<option value="PHONE">Phone No</option>	
			 		<option value="MEMBER_ID">Member ID</option>	
			 		<option value="FIRST_NAME" ${ identifier == 'FIRST_NAME' ? 'selected="selected"' : '' }>First Name</option>	
			 		<option value="SURNAME">Surname</option>	
			 		<option value="OTHER_NAMES">Other Names</option>	
			 		<option value="NAME">Name</option>	
			 </select>
			<input type="text" class="form-control" name="search" id="search" placeholder="Search" value="${ search }"/>
			<button class="btn btn-info">Search</button>
		</form>-->
	</div>
	<div class="col-md-12">
		<table class="table table-responsive table-striped" id="search-results">
			<thead>
			<tr><th>NAME</th><th>ID/PPT NUMBER</th><th>DATE OF BIRTH</th><th>GENDER</th><th>STATUS</th><th class="right">ACTION</th></tr>
			</thead>
			<tbody>
			<c:forEach var="member" items="${members}">
				<tr><td>${ member.name }</td><td>${ member.idNumber }</td><td>${ member.dateOfBirth }</td>
					<td>${ member.gender }</td><td>${ member.mbshipStatus }</td><td class="right">
						<c:if test="${ permissions.member_edit }">
							<button class="btn btn-sm btn-warning" onclick="edit_member('${member.id}');">
								<i class="glyphicon glyphicon-pencil"></i>&nbsp;EDIT</button></c:if>&nbsp;
						<c:if test="${ permissions.member_view }"><button onclick="view_member('${member.id}');" class="btn btn-sm btn-info">
							<i class="glyphicon glyphicon-eye-open"></i>&nbsp;VIEW</button></c:if></td></tr>
			</c:forEach>
			</tbody>
		</table>
	</div>

</div>
<script type="text/javascript">

function load_dashboard(page, batch)
{
	start_wait();
	$.ajax({
        url: $('#base_url').val() + 'dashboard',
        type: 'get',
        data: {dashboard: 'MEMBER', page: page, batch: batch, profile: $('#profile').val(), identifier: $('#identifier').val(), search: $('#search').val()},
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

$(document).ready(function() {

	$('#search-results').dataTable(

	);
} );

function edit_member(id)
{
	alert(id);
	start_wait();
	$.ajax({
        url: $('#base_url').val() + 'admin',
        type: 'post',
        data: {ACTION:'GET_MEMBER', memberID: id},
        dataType: 'html',
        success: function(html) {
			$('#member-content').html(html);
			$('#title').remove();
			$('#modal-edit-member').modal('show');
			
			stop_wait();
        }
	});
}
function view_member(id)
{
	start_wait();
	$.ajax({
        url: $('#base_url').val() + 'admin',
        type: 'post',
        data: {ACTION:'VIEW_MEMBER', memberID: id},
        dataType: 'html',
        success: function(html) {
			$('#member-content2').html(html);
			$('#modal-view-member').modal('show');
			
			stop_wait();
        }
	});
}
$(document).ready(function(){
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
					<i class="glyphicon glyphicon-picture"></i>&nbsp;&nbsp;VIEW MEMBER DETAILS
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