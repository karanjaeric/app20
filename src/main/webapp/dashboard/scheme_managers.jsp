<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section">
	<div class="col-md-4">
		<h3>
			<i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;SCHEME MANAGERS
		</h3>
	</div>
	<div class="col-md-8" align="right">
	<br />
		
		<form class="form-inline" id="form-search">
		     <select name="profile" id="profile" class="form-control">
		     	<option>MEMBER</option>
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
			 		<option value="FIRST_NAME">First Name</option>	
			 		<option value="SURNAME">Surname</option>	
			 		<option value="OTHER_NAMES">Other Names</option>	
			 		<option value="NAME">Name</option>	
			 </select>
			<input type="text" class="form-control" name="search" id="search" placeholder="Search"/>
			<button class="btn btn-info">Search</button>
		</form>
	</div>
				
	<table class="table table-responsive table-striped" id="search-results">
		<tr><th>NAME</th><th>PROFILE</th><th>SCHEME</th><th>ACTIONS</th></tr>
		<c:forEach var="schememanager" items="${ schememanagers }">
		<tr><td>${schememanager.name }</td><td>${ schememanager.profile }</td><td>${ schememanager.scheme }</td><td><c:if test="${ permissions.scheme_managers }"><button class="btn btn-sm btn-danger" onclick="delink('${schememanager.id}')"><i class="glyphicon glyphicon-trash"></i>&nbsp;DELINK MANAGER</button></c:if></td></tr>
		</c:forEach>
	</table>
</div>

<div class="modal fade" id="modal-view-member" tabindex="-1" role="dialog" aria-labelledby="myModalLabelViewMember" aria-hidden="true">
<form role="form" id="form-view-member">
			<div class="modal-dialog large-modal">
				<div class="modal-content">
					<div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title" id="myModalLabelViewMember">
							<i class="glyphicon glyphicon-picture"></i>&nbsp;&nbsp;SELECT MEMBER
						</h4>
					</div>
					<div class="modal-body">
						<table class="table table-responsive table-striped" id="select-results">
						</table>
					</div>
					</div>
				</div>
			</form>
</div>
<script type="text/javascript">

function load_dashboard(MODULE)
{
    start_wait();
	$.ajax({
        url: $('#base_url').val() + 'dashboard',
        type: 'get',
        data: {dashboard: MODULE},
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
function delink(id, profile, email)
{
	bootbox.confirm("<p class=\"text-center\">You are about to delink/remove the selected scheme manager. Are you sure?</p>", function(result){
		if(result)
		{
			start_wait();
			$.ajax({
		        url: $('#base_url').val() + 'admin',
		        type: 'post',
		        data: {ACTION:'DELINK_SCHEME_MANAGER', id: id},
		        dataType: 'json',
		        success: function(json) {
					stop_wait();
					if(json.success)
					{
						//load_dashboard("SCHEME_MANAGER");
					}
					bootbox.alert(json.message);
		        }
			});
		}
	});
}
function select_partner(id, profile, email)
{
	start_wait();
	$.ajax({
        url: $('#base_url').val() + 'admin',
        type: 'post',
        data: {ACTION:'ADD_SCHEME_MANAGER', id: id, profile: profile, email: email},
        dataType: 'json',
        success: function(json) {
			stop_wait();
			bootbox.alert(json.message);
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
			start_wait();
    		$.ajax({
    	        url: $('#base_url').val() + 'admin',
    	        type: 'post',
    	        data: {ACTION: 'SEARCH_MEMBER', profile: $('#profile').val(), search: $('#search').val(), identifier: $('#identifier').val()},
    	        dataType: 'json',
    	        success: function(json) {
        	        console.log(json);
    	            if($('#profile').val() == 'SPONSOR' || $('#profile').val() == 'MEMBER')
        	        {
    	            	html = "<tr><th>NAME</th><th>PROFILE</th><th>EMAIL ADDRESS</th><th>ACTION</th></tr>";
        	            if(json.success)
    					{
    						$.each(json, function(key, value) {
    				        	if(key == 'rows')
    				           	{
    				        		for ( var i = 0; i < json.rows.length; i++) {
    				            		var row = json.rows[i];
    				            		html = html + "<tr><td>" + row['name'] + "</td><td>" + $('#profile').val() + "</td><td>" + row['email'] + "</td><td><a onclick=\"select_partner('" + row['id'] + "', '" + $('#profile').val() + "', '" + row['email'] + "');\" class=\"btn btn-sm btn-primary\"><i class=\"glyphicon glyphicon-ok\"></i>&nbsp;&nbsp;SET AS SCHEME MANAGER</a></td></tr>";
    				        		}
    								stop_wait();
    				           	}
    						});
    					}
            	    }
					$('#select-results').html(html);
					stop_wait();
					$('#modal-view-member').modal('show');
    	        }
    	    });
        }
	});
});

</script>