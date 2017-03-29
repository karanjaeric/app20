<div class="container-fluid section">
	<h3 class="text-center main-title">
		<i class="glyphicon glyphicon-film"></i>&nbsp;&nbsp;USER ACCESS CONTROL
	</h3>
	<table class="table table-responsive table-striped">
		<tr><th>PROFILE</th><th>DESCRIPTION</th><th>ACTIONS</th></tr>
		<tr><td>ADMINISTRATOR</td><td>SYSTEM ADMINISTRATORS PROFILE</td><td><button class="btn btn-sm btn-warning" onclick="edit_profile('ADMINISTRATOR');"><i class="glyphicon glyphicon-cog"></i>PRIVILEGES</button></td></tr>
		<tr><td>MANAGER</td><td>SCHEME MANAGERS</td><td><button class="btn btn-sm btn-warning" onclick="edit_profile('MANAGER');"><i class="glyphicon glyphicon-cog"></i>PRIVILEGES</button></td></tr>
		<tr><td>SPONSOR</td><td>SPONSORS</td><td><button class="btn btn-sm btn-warning" onclick="edit_profile('SPONSOR');"><i class="glyphicon glyphicon-cog"></i>PRIVILEGES</button></td></tr>
		<tr><td>TRUSTEE</td><td>TRUSTEES</td><td><button class="btn btn-sm btn-warning" onclick="edit_profile('TRUSTEE');"><i class="glyphicon glyphicon-cog"></i>PRIVILEGES</button></td></tr>
		<tr><td>AGENT</td><td>AGENTS</td><td><button class="btn btn-sm btn-warning" onclick="edit_profile('AGENT');"><i class="glyphicon glyphicon-cog"></i>PRIVILEGES</button></td></tr>
		<tr><td>CUSTODIAN</td><td>CUSTODIANS</td><td><button class="btn btn-sm btn-warning" onclick="edit_profile('CUSTODIAN');"><i class="glyphicon glyphicon-cog"></i>PRIVILEGES</button></td></tr>
		<tr><td>CUSTOMER RELATIONSHIP MANAGER</td><td>CUSTOMER RELATIONSHIP MANAGERS</td><td><button class="btn btn-sm btn-warning" onclick="edit_profile('CUSTOMER_RELATIONSHIP_MANAGER');"><i class="glyphicon glyphicon-cog"></i>PRIVILEGES</button></td></tr>
		<tr><td>CUSTOMER RELATIONSHIP EXECUTIVE</td><td>CUSTOMER RELATIONSHIP EXECUTIVES</td><td><button class="btn btn-sm btn-warning" onclick="edit_profile('CUSTOMER_RELATIONSHIP_EXECUTIVE');"><i class="glyphicon glyphicon-cog"></i>PRIVILEGES</button></td></tr>
		<tr><td>FUND MANAGER</td><td>FUND MANAGERS</td><td><button class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-cog" onclick="edit_profile('FUND_MANAGER');"></i>PRIVILEGES</button></td></tr>
		<tr><td>PENSIONER</td><td>PENSIONERS</td><td><button class="btn btn-sm btn-warning" onclick="edit_profile('PENSIONER');"><i class="glyphicon glyphicon-cog"></i>PRIVILEGES</button></td></tr>
	</table>
</div>
<script type="text/javascript">
var prof;
function edit_profile(profile)
{
	prof = profile;
	start_wait();
	$.ajax({
        url: $('#base_url').val() + 'admin',
        type: 'post',
        data: {ACTION:'GET_PERMISSION', profile: profile},
        dataType: 'html',
        success: function(html) {
			$('#permission-content').html(html);
			$('#modal-permission').modal('show');
			stop_wait();
        }
	});
}

$(document).ready(function(){
	$('#form-permission').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
           
        }
	})
	.on('success.form.bv', function(e) {

            // Prevent form submission
            e.preventDefault();
			start_wait();
    		$.ajax({
    	        url: $('#base_url').val() + 'admin',
    	        type: 'post',
    	        data: {ACTION: 'SAVE_PERMISSION', profile: prof, setup_company: $('#setup_company').prop('checked'), setup_email: $('#setup_email').prop('checked'), setup_logo: $('#setup_logo').prop('checked'),
					setup_menu: $('#setup_menu').prop('checked'), db_menu: $('#db_menu').prop('checked'), setup_social: $('#setup_social').prop('checked'), setup_theme: $('#setup_theme').prop('checked'),
					setup_banner: $('#setup_banner').prop('checked'), setup_interest_rate: $('#setup_interest_rate').prop('checked'), setup_other: $('#setup_other').prop('checked'),
					setup_contact_reason: $('#setup_contact_reason').prop('checked'), member_edit: $('#member_edit').prop('checked'), member_view: $('#member_view').prop('checked'),
					operation_personal_info: $('#operation_personal_info').prop('checked'), operation_contribution_history: $('#operation_contribution_history').prop('checked'),
					operation_balance_history: $('#operation_balance_history').prop('checked'), operation_statement_of_account: $('#operation_statement_of_account').prop('checked'),
					operation_benefit_projection: $('#operation_benefit_projection').prop('checked'), media_upload: $('#media_upload').prop('checked'), media_remove: $('#media_remove').prop('checked'),
					profile_names: $('#profile_names').prop('checked'), profile_privileges: $('#profile_privileges').prop('checked'), member_edit_permissions: $('#member_edit_permissions').prop('checked'), show_db_contribution_graph: $('#show_db_contribution_graph').prop('checked'),
					profile_login_username: $('#profile_login_username').prop('checked'), scheme_managers: $('#scheme_managers').prop('checked'), content_help: $('#content_help').prop('checked'),
					content_page: $('#content_page').prop('checked'), setup: $('#setup').prop('checked'), content: $('#content').prop('checked'), schemes: $('#schemes').prop('checked'), member_menu_config: $('#member_menu_config').prop('checked'), pensioner_menu_config: $('#pensioner_menu_config').prop('checked'),
					member_dashboard_items: $('#member_dashboard_items').prop('checked'), admin_dashboard_items: $('#admin_dashboard_items').prop('checked'),
					receipts: $('#receipts').prop('checked'), payments: $('#payments').prop('checked'), members: $('#members').prop('checked'), member_operations: $('#member_operations').prop('checked'),
					withdrawal_statement: $('#withdrawal_statement').prop('checked'), media: $('#media').prop('checked'), uac: $('#uac').prop('checked'), analytics: $('#analytics').prop('checked'), calculator_log: $('#calculator_log').prop('checked'),
					users: $('#users').prop('checked'), user_enable_disable: $('#user_enable_disable').prop('checked'), withdrawal_settlements: $('#withdrawal_settlements').prop('checked'), admin_fee_listing: $('#admin_fee_listing').prop('checked'),
					audit_trail: $('#audit_trail').prop('checked'), portal_member_add: $('#portal_member_add').prop('checked'), portal_member_view: $('#portal_member_view').prop('checked'),
					member_movement: $('#member_movement').prop('checked'), member_listing: $('#member_listing').prop('checked'), corporate_statement: $('#corporate_statement').prop('checked'), fund_movement: $('#fund_movement').prop('checked'), receipt_summary: $('#receipt_summary').prop('checked'), portal_member_delete: $('#portal_member_delete').prop('checked'),
					portal_member_process: $('#portal_member_process').prop('checked'), portal_sponsor_add: $('#portal_sponsor_add').prop('checked'), portal_sponsor_view: $('#portal_sponsor_view').prop('checked'), portal_sponsor_delete: $('#portal_sponsor_delete').prop('checked'),
					portal_sponsor_process: $('#portal_sponsor_process').prop('checked'), portal_members: $('#portal_members').prop('checked'), portal_sponsors: $('#portal_sponsors').prop('checked'),
					password_policy: $('#password_policy').prop('checked') },
    	        dataType: 'json',
    	        success: function(json) {
    	            if(json.success)
					{
						$('#modal-permission').modal('hide');
					}
    	            bootbox.alert(json.message);
    				stop_wait();
    	        }
    	    });
	});
});
</script>
<div class="modal fade" id="modal-permission" tabindex="-1" role="dialog" aria-labelledby="myModalLabelPermission" aria-hidden="true">
<form role="form" id="form-permission">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title" id="myModalLabelPermission">
							<i class="glyphicon glyphicon-picture"></i>&nbsp;&nbsp;EDIT PROFILE PERMISSIONS
						</h4>
					</div>
					<div class="modal-body" id="permission-content">
						
					</div>
					<div class="modal-footer">
						<a href="#" class="btn btn-warning" data-dismiss="modal">Cancel</a>
						<input class="btn btn-primary" type="submit"
							value="Save Permissions">
					</div>
				</div>
			</div>
</form>
</div>