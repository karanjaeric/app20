<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="accordion-container">
     <h2 class="accordion-header">SETUP &amp; CONFIGURATION<span class="pull-right"><input type="checkbox" id="setup" class="form-control input-sm"  ${permissions.setup == 'TRUE' ? 'checked' : ''}/></span></h2>
     <div class="accordion-content">
          <p>Access the main setup &amp; configuration features</p>
          <table class="table table-responsive table-striped">
			<tr><td>COMPANY DETAILS</td><td><input type="checkbox" id="setup_company" class="form-control input-sm"  ${permissions.setup_company == 'TRUE' ? 'checked' : ''}/></td></tr>
			  <tr><td>MANAGE EMAIL ADDRESSES</td><td><input type="checkbox" id="setup_email" class="form-control input-sm"  ${permissions.setup_email == 'TRUE' ? 'checked' : ''}/></td></tr>
			<tr><td>SETUP LOGO</td><td><input type="checkbox" id="setup_logo" class="form-control input-sm"  ${permissions.setup_logo == 'TRUE' ? 'checked' : ''}/></td></tr>
			<tr><td>CONFIGURE MENU</td><td><input type="checkbox" id="setup_menu" class="form-control input-sm"  ${permissions.setup_menu == 'TRUE' ? 'checked' : ''}/></td></tr>
			<tr><td>SOCIAL NETWORK LINKS</td><td><input type="checkbox" id="setup_social" class="form-control input-sm"  ${permissions.setup_social == 'TRUE' ? 'checked' : ''}/></td></tr>
			<tr><td>THEME SETTINGS</td><td><input type="checkbox" id="setup_theme" class="form-control input-sm"  ${permissions.setup_theme == 'TRUE' ? 'checked' : ''}/></td></tr>
			<tr><td>MANAGE BANNERS</td><td><input type="checkbox" id="setup_banner" class="form-control input-sm"  ${permissions.setup_banner == 'TRUE' ? 'checked' : ''}/></td></tr>
			<tr><td>INTEREST RATE SETTINGS</td><td><input type="checkbox" id="setup_interest_rate" class="form-control input-sm"  ${permissions.setup_interest_rate == 'TRUE' ? 'checked' : ''}/></td></tr>
			<tr><td>OTHER SETTINGS</td><td><input type="checkbox" id="setup_other" class="form-control input-sm"  ${permissions.setup_other == 'TRUE' ? 'checked' : ''}/></td></tr>
			<tr><td>MANAGE CONTACT REASONS</td><td><input type="checkbox" id="setup_contact_reason" class="form-control input-sm"  ${permissions.setup_contact_reason == 'TRUE' ? 'checked' : ''}/></td></tr>
		</table>
     </div>
     <h2 class="accordion-header">CONTENT MANAGEMENT<span class="pull-right"><input type="checkbox" id="content" class="form-control input-sm"  ${permissions.content == 'TRUE' ? 'checked' : ''}/></span></h2>
     <div class="accordion-content">
          <p>Access the content management functions</p>
           <table class="table table-responsive table-striped">
			<tr><td>HELP CONTENT</td><td><input type="checkbox" id="content_help" class="form-control input-sm"  ${permissions.content_help == 'TRUE' ? 'checked' : ''}/></td></tr>
			<tr><td>PAGE CONTENT</td><td><input type="checkbox" id="content_page" class="form-control input-sm"  ${permissions.content_page == 'TRUE' ? 'checked' : ''}/></td></tr>
			</table>
     </div>
      <h2 class="accordion-header">POTENTIAL MEMBERS<span class="pull-right"><input type="checkbox" id="portal_members" class="form-control input-sm"  ${permissions.portal_members == 'TRUE' ? 'checked' : ''}/></span></h2>
     <div class="accordion-content">
          <p>Access the new potential members registered through the portal</p>
          <table class="table table-responsive table-striped">
			<tr><td>REGISTER MEMBER</td><td><input type="checkbox" id="portal_member_add" class="form-control input-sm"  ${permissions.portal_member_add == 'TRUE' ? 'checked' : ''}/></td></tr>
			<tr><td>PROCESS MEMBER</td><td><input type="checkbox" id="portal_member_process" class="form-control input-sm"  ${permissions.portal_member_process == 'TRUE' ? 'checked' : ''}/></td></tr>
			<tr><td>VIEW MEMBER</td><td><input type="checkbox" id="portal_member_view" class="form-control input-sm"  ${permissions.portal_member_view == 'TRUE' ? 'checked' : ''}/></td></tr>
			<tr><td>DELETE MEMBER</td><td><input type="checkbox" id="portal_member_delete" class="form-control input-sm"  ${permissions.portal_member_delete == 'TRUE' ? 'checked' : ''}/></td></tr>
		  </table>
     </div>
      <h2 class="accordion-header">POTENTIAL SPONSORS<span class="pull-right"><input type="checkbox" id="portal_sponsors" class="form-control input-sm"  ${permissions.portal_sponsors == 'TRUE' ? 'checked' : ''}/></span></h2>
     <div class="accordion-content">
          <p>Access the new potential sponsors registered through the portal</p>
          <table class="table table-responsive table-striped">
			<tr><td>REGISTER SPONSOR</td><td><input type="checkbox" id="portal_sponsor_add" class="form-control input-sm"  ${permissions.portal_sponsor_add == 'TRUE' ? 'checked' : ''}/></td></tr>
			<tr><td>PROCESS SPONSOR</td><td><input type="checkbox" id="portal_sponsor_process" class="form-control input-sm"  ${permissions.portal_sponsor_process == 'TRUE' ? 'checked' : ''}/></td></tr>
			<tr><td>VIEW SPONSOR</td><td><input type="checkbox" id="portal_sponsor_view" class="form-control input-sm"  ${permissions.portal_sponsor_view == 'TRUE' ? 'checked' : ''}/></td></tr>
			<tr><td>DELETE SPONSOR</td><td><input type="checkbox" id="portal_sponsor_delete" class="form-control input-sm"  ${permissions.portal_sponsor_delete == 'TRUE' ? 'checked' : ''}/></td></tr>
		  </table>
     </div>
      <h2 class="accordion-header">SCHEMES LISTING<span class="pull-right"><input type="checkbox" id="schemes" class="form-control input-sm"  ${permissions.schemes == 'TRUE' ? 'checked' : ''}/></span></h2>
     <div class="accordion-content">
          <p>Access the schemes listings</p>
     </div>
     <h2 class="accordion-header">SCHEME RECEIPTS<span class="pull-right"><input type="checkbox" id="receipts" class="form-control input-sm"  ${permissions.receipts == 'TRUE' ? 'checked' : ''}/></span></h2>
     <div class="accordion-content">
          <p>Access to the schemes receipts</p>
     </div>
      <h2 class="accordion-header">SCHEME PAYMENTS<span class="pull-right"><input type="checkbox" id="payments" class="form-control input-sm"  ${permissions.payments == 'TRUE' ? 'checked' : ''}/></span></h2>
     <div class="accordion-content">
          <p>Access to the schemes payments</p>
     </div>

	<h2 class="accordion-header">REPORTS<span class="pull-right"><input type="checkbox" id="reports" class="form-control input-sm"  ${permissions.reports == 'TRUE' ? 'checked' : ''}/></span></h2>
	<div class="accordion-content">
		<p></p>
		<table class="table table-responsive table-striped">
			<tr><td>WITHDRAWAL STATEMENT</td><td><input type="checkbox" id="withdrawal_statement" class="form-control input-sm"  ${permissions.withdrawal_statement == 'TRUE' ? 'checked' : ''}/></td></tr>
			<tr><td>WITHDRAWAL SETTLEMENTS</td><td><input type="checkbox" id="withdrawal_settlements" class="form-control input-sm"  ${permissions.withdrawal_settlements == 'TRUE' ? 'checked' : ''}/></td></tr>
			<tr><td>MEMBER MOVEMENT</td><td><input type="checkbox" id="member_movement" class="form-control input-sm"  ${permissions.member_movement == 'TRUE' ? 'checked' : ''}/></td></tr>
			<tr><td>ADMIN FEE LISTING</td><td><input type="checkbox" id="admin_fee_listing" class="form-control input-sm"  ${permissions.admin_fee_listing == 'TRUE' ? 'checked' : ''}/></td></tr>
			<tr><td>FUND MOVEMENT</td><td><input type="checkbox" id="fund_movement" class="form-control input-sm"  ${permissions.fund_movement == 'TRUE' ? 'checked' : ''}/></td></tr>
		</table>
	</div>

     <h2 class="accordion-header">SCHEME MEMBERS<span class="pull-right"><input type="checkbox" id="members" class="form-control input-sm"  ${permissions.members == 'TRUE' ? 'checked' : ''}/></span></h2>
     <div class="accordion-content">
          <p>Access to the scheme members, edit and view member details</p>
           <table class="table table-responsive table-striped">
			<tr><td>VIEW DETAILS</td><td><input type="checkbox" id="member_view" class="form-control input-sm"  ${permissions.member_view == 'TRUE' ? 'checked' : ''}/></td></tr>
			<tr><td>EDIT DETAILS</td><td><input type="checkbox" id="member_edit" class="form-control input-sm"  ${permissions.member_edit == 'TRUE' ? 'checked' : ''}/></td></tr>
			</table>
     </div>
      <h2 class="accordion-header">MEMBER OPERATIONS<span class="pull-right"><input type="checkbox" id="member_operations" class="form-control input-sm"  ${permissions.operations == 'TRUE' ? 'checked' : ''}/></span></h2>
     <div class="accordion-content">
          <p>Access to member operations, i.e. view member information and edit details</p>
           <table class="table table-responsive table-striped">
				<tr><td>VIEW PERSONAL INFORMATION</td><td><input type="checkbox" id="operation_personal_info" class="form-control input-sm"  ${permissions.operation_personal_info == 'TRUE' ? 'checked' : ''}/></td></tr>
				<tr><td>VIEW CONTRIBUTION HISTORY</td><td><input type="checkbox" id="operation_contribution_history" class="form-control input-sm"  ${permissions.operation_contribution_history == 'TRUE' ? 'checked' : ''}/></td></tr>
				<tr><td>VIEW BALANCES HISTORY</td><td><input type="checkbox" id="operation_balance_history" class="form-control input-sm"  ${permissions.operation_balance_history == 'TRUE' ? 'checked' : ''}/></td></tr>
				<tr><td>VIEW STATEMENT OF ACCOUNT</td><td><input type="checkbox" id="operation_statement_of_account" class="form-control input-sm"  ${permissions.operation_statement_of_account == 'TRUE' ? 'checked' : ''}/></td></tr>
				<tr><td>VIEW BENEFITS PROJECTIONS</td><td><input type="checkbox" id="operation_benefit_projection" class="form-control input-sm"  ${permissions.operation_benefit_projection == 'TRUE' ? 'checked' : ''}/></td></tr>
			</table>
     </div>
     <h2 class="accordion-header">MEDIA<span class="pull-right"><input type="checkbox" id="media" class="form-control input-sm"  ${permissions.media == 'TRUE' ? 'checked' : ''}/></span></h2>
     <div class="accordion-content">
          <p>Access to uploaded media and files</p>
           <table class="table table-responsive table-striped">
				<tr><td>MEDIA/FILE UPLOAD</td><td><input type="checkbox" id="media_upload" class="form-control input-sm"  ${permissions.media_upload == 'TRUE' ? 'checked' : ''}/></td></tr>
				<tr><td>REMOVE MEDIA/FILE</td><td><input type="checkbox" id="media_remove" class="form-control input-sm"  ${permissions.media_remove == 'TRUE' ? 'checked' : ''}/></td></tr>
			</table>
     </div>
      <h2 class="accordion-header">USER ACCESS CONTROL<span class="pull-right"><input type="checkbox" id="uac" class="form-control input-sm"  ${permissions.uac == 'TRUE' ? 'checked' : ''}/></span></h2>
     <div class="accordion-content">
          <p>Access to user permissions</p>
           <table class="table table-responsive table-striped">
				<tr><td>PROFILE PRIVILEGES</td><td><input type="checkbox" id="profile_privileges" class="form-control input-sm"  ${permissions.profile_privileges == 'TRUE' ? 'checked' : ''}/></td></tr>
				<tr><td>CONFIGURE PROFILE NAMES</td><td><input type="checkbox" id="profile_names" class="form-control input-sm"  ${permissions.profile_names == 'TRUE' ? 'checked' : ''}/></td></tr>
				<tr><td>MEMBER EDIT PERMISSIONS</td><td><input type="checkbox" id="member_edit_permissions" class="form-control input-sm"  ${permissions.member_edit_permissions == 'TRUE' ? 'checked' : ''}/></td></tr>
				<tr><td>PROFILE LOGIN USERNAME</td><td><input type="checkbox" id="profile_login_username" class="form-control input-sm"  ${permissions.profile_login_username == 'TRUE' ? 'checked' : ''}/></td></tr>
				<tr><td>SCHEME MANAGERS</td><td><input type="checkbox" id="scheme_managers" class="form-control input-sm"  ${permissions.scheme_managers == 'TRUE' ? 'checked' : ''}/></td></tr>
				<tr><td>PORTAL USERS</td><td><input type="checkbox" id="users" class="form-control input-sm"  ${permissions.users == 'TRUE' ? 'checked' : ''}/></td></tr>
				<tr><td>ENABLE / DISABLE PORTAL USER</td><td><input type="checkbox" id="user_enable_disable" class="form-control input-sm"  ${permissions.user_enable_disable == 'TRUE' ? 'checked' : ''}/></td></tr>
				<tr><td>PASSWORD POLICY</td><td><input type="checkbox" id="password_policy" class="form-control input-sm"  ${permissions.password_policy == 'TRUE' ? 'checked' : ''}/></td></tr>
				<tr><td>AUDIT TRAILS</td><td><input type="checkbox" id="audit_trail" class="form-control input-sm"  ${permissions.audit_trail == 'TRUE' ? 'checked' : ''}/></td></tr>
			</table>
     </div>
     <h2 class="accordion-header">ANALYTICS &amp; REPORTING<span class="pull-right"><input type="checkbox" id="analytics" class="form-control input-sm"  ${permissions.analytics == 'TRUE' ? 'checked' : ''}/></span></h2>
     <div class="accordion-content">
          <p>Access to portal analytics and reporting page</p>
     </div>
</div>
<script type="text/javascript">
	$(document).ready(function()
		{
			//Add Inactive Class To All Accordion Headers
			$('.accordion-header').toggleClass('inactive-header');
			
			//Set The Accordion Content Width
			$('.accordion-content').css({'width' : '100%' });
			
			//Open The First Accordion Section When Page Loads
			$('.accordion-header').first().toggleClass('active-header').toggleClass('inactive-header');
			$('.accordion-content').first().slideDown().toggleClass('open-content');
			
			// The Accordion Effect
			$('.accordion-header').click(function () {
				if($(this).is('.inactive-header')) {
					$('.active-header').toggleClass('active-header').toggleClass('inactive-header').next().slideToggle().toggleClass('open-content');
					$(this).toggleClass('active-header').toggleClass('inactive-header');
					$(this).next().slideToggle().toggleClass('open-content');
				}
				
				else {
					$(this).toggleClass('active-header').toggleClass('inactive-header');
					$(this).next().slideToggle().toggleClass('open-content');
				}
			});
			
			return false;
	});
</script>