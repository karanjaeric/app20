package com.fundmaster.mss.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table (name = "tbl_permissions")
public class Permission extends GenericModel<Permission> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public boolean isSetup() {
		return setup;
	}

	public void setSetup(boolean setup) {
		this.setup = setup;
	}

	public boolean isContent() {
		return content;
	}

	public void setContent(boolean content) {
		this.content = content;
	}

	public boolean isSchemes() {
		return schemes;
	}

	public void setSchemes(boolean schemes) {
		this.schemes = schemes;
	}

	public boolean isReceipts() {
		return receipts;
	}

	public void setReceipts(boolean receipts) {
		this.receipts = receipts;
	}

	public boolean isPayments() {
		return payments;
	}

	public void setPayments(boolean payments) {
		this.payments = payments;
	}

	public boolean isMembers() {
		return members;
	}

	public void setMembers(boolean members) {
		this.members = members;
	}

	public boolean isOperations() {
		return operations;
	}

	public void setOperations(boolean operations) {
		this.operations = operations;
	}

	public boolean isMedia() {
		return media;
	}

	public void setMedia(boolean media) {
		this.media = media;
	}

	public boolean isUac() {
		return uac;
	}

	public void setUac(boolean uac) {
		this.uac = uac;
	}

	public boolean isAnalytics() {
		return analytics;
	}

	public void setAnalytics(boolean analytics) {
		this.analytics = analytics;
	}

	public boolean isSetup_company() {
		return setup_company;
	}

	public void setSetup_company(boolean setup_company) {
		this.setup_company = setup_company;
	}

	public boolean isSetup_logo() {
		return setup_logo;
	}

	public void setSetup_logo(boolean setup_logo) {
		this.setup_logo = setup_logo;
	}

	public boolean isSetup_menu() {
		return setup_menu;
	}

	public void setSetup_menu(boolean setup_menu) {
		this.setup_menu = setup_menu;
	}

	public boolean isSetup_social() {
		return setup_social;
	}

	public void setSetup_social(boolean setup_social) {
		this.setup_social = setup_social;
	}

	public boolean isSetup_theme() {
		return setup_theme;
	}

	public void setSetup_theme(boolean setup_theme) {
		this.setup_theme = setup_theme;
	}

	public boolean isSetup_banner() {
		return setup_banner;
	}

	public void setSetup_banner(boolean setup_banner) {
		this.setup_banner = setup_banner;
	}

	public boolean isSetup_interest_rate() {
		return setup_interest_rate;
	}

	public void setSetup_interest_rate(boolean setup_interest_rate) {
		this.setup_interest_rate = setup_interest_rate;
	}

	public boolean isSetup_other() {
		return setup_other;
	}

	public void setSetup_other(boolean setup_other) {
		this.setup_other = setup_other;
	}

	public boolean isSetup_contact_reason() {
		return setup_contact_reason;
	}

	public void setSetup_contact_reason(boolean setup_contact_reason) {
		this.setup_contact_reason = setup_contact_reason;
	}

	public boolean isContent_help() {
		return content_help;
	}

	public void setContent_help(boolean content_help) {
		this.content_help = content_help;
	}

	public boolean isContent_page() {
		return content_page;
	}

	public void setContent_page(boolean content_page) {
		this.content_page = content_page;
	}

	public boolean isOperation_personal_info() {
		return operation_personal_info;
	}

	public void setOperation_personal_info(boolean operation_personal_info) {
		this.operation_personal_info = operation_personal_info;
	}

	public boolean isOperation_contribution_history() {
		return operation_contribution_history;
	}

	public void setOperation_contribution_history(
			boolean operation_contribution_history) {
		this.operation_contribution_history = operation_contribution_history;
	}

	public boolean isOperation_balance_history() {
		return operation_balance_history;
	}

	public void setOperation_balance_history(boolean operation_balance_history) {
		this.operation_balance_history = operation_balance_history;
	}

	public boolean isOperation_statement_of_account() {
		return operation_statement_of_account;
	}

	public void setOperation_statement_of_account(
			boolean operation_statement_of_account) {
		this.operation_statement_of_account = operation_statement_of_account;
	}

	public boolean isOperation_benefit_projection() {
		return operation_benefit_projection;
	}

	public void setOperation_benefit_projection(boolean operation_benefit_projection) {
		this.operation_benefit_projection = operation_benefit_projection;
	}

	public boolean isMedia_upload() {
		return media_upload;
	}

	public void setMedia_upload(boolean media_upload) {
		this.media_upload = media_upload;
	}

	public boolean isMember_edit() {
		return member_edit;
	}

	public void setMember_edit(boolean member_edit) {
		this.member_edit = member_edit;
	}


	public boolean isScheme_managers() {
		return scheme_managers;
	}

	public void setScheme_managers(boolean scheme_managers) {
		this.scheme_managers = scheme_managers;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isProfile_privileges() {
		return profile_privileges;
	}

	public void setProfile_privileges(boolean profile_privileges) {
		this.profile_privileges = profile_privileges;
	}

	public boolean isMember_edit_permissions() {
		return member_edit_permissions;
	}

	public void setMember_edit_permissions(boolean member_edit_permissions) {
		this.member_edit_permissions = member_edit_permissions;
	}

	public boolean isProfile_login_username() {
		return profile_login_username;
	}

	public void setProfile_login_username(boolean profile_login_username) {
		this.profile_login_username = profile_login_username;
	}

	public boolean isMedia_remove() {
		return media_remove;
	}

	public void setMedia_remove(boolean media_remove) {
		this.media_remove = media_remove;
	}

	public boolean isMember_view() {
		return member_view;
	}

	public void setMember_view(boolean member_view) {
		this.member_view = member_view;
	}

	private String profile;
	
	private boolean setup, content, schemes, receipts, payments, members, operations, media, uac, analytics;
	
	private boolean portal_members, portal_member_view, portal_member_process, portal_member_delete, portal_member_add;
	
	private boolean portal_sponsors, portal_sponsor_view, portal_sponsor_process, portal_sponsor_delete, portal_sponsor_add;
	
	private boolean password_policy;
	
	public boolean isPassword_policy() {
		return password_policy;
	}

	public void setPassword_policy(boolean password_policy) {
		this.password_policy = password_policy;
	}

	public boolean isPortal_members() {
		return portal_members;
	}

	public void setPortal_members(boolean portal_members) {
		this.portal_members = portal_members;
	}

	public boolean isPortal_member_view() {
		return portal_member_view;
	}

	public void setPortal_member_view(boolean portal_member_view) {
		this.portal_member_view = portal_member_view;
	}

	public boolean isPortal_member_add() {
		return portal_member_add;
	}

	public void setPortal_member_add(boolean portal_member_add) {
		this.portal_member_add = portal_member_add;
	}

	public boolean isPortal_sponsor_add() {
		return portal_sponsor_add;
	}

	public void setPortal_sponsor_add(boolean portal_sponsor_add) {
		this.portal_sponsor_add = portal_sponsor_add;
	}

	public boolean isPortal_member_process() {
		return portal_member_process;
	}

	public void setPortal_member_process(boolean portal_member_process) {
		this.portal_member_process = portal_member_process;
	}

	public boolean isPortal_member_delete() {
		return portal_member_delete;
	}

	public void setPortal_member_delete(boolean portal_member_delete) {
		this.portal_member_delete = portal_member_delete;
	}

	public boolean isPortal_sponsors() {
		return portal_sponsors;
	}

	public void setPortal_sponsors(boolean portal_sponsors) {
		this.portal_sponsors = portal_sponsors;
	}

	public boolean isPortal_sponsor_view() {
		return portal_sponsor_view;
	}

	public void setPortal_sponsor_view(boolean portal_sponsor_view) {
		this.portal_sponsor_view = portal_sponsor_view;
	}

	public boolean isPortal_sponsor_process() {
		return portal_sponsor_process;
	}

	public void setPortal_sponsor_process(boolean portal_sponsor_process) {
		this.portal_sponsor_process = portal_sponsor_process;
	}

	public boolean isPortal_sponsor_delete() {
		return portal_sponsor_delete;
	}

	public void setPortal_sponsor_delete(boolean portal_sponsor_delete) {
		this.portal_sponsor_delete = portal_sponsor_delete;
	}

	public boolean isUsers() {
		return users;
	}

	public Permission(long id, String profile, boolean setup, boolean content,
			boolean schemes, boolean receipts, boolean payments,
			boolean members, boolean operations, boolean media, boolean uac,
			boolean analytics, boolean setup_company, boolean setup_logo,
			boolean setup_menu, boolean setup_social, boolean setup_theme,
			boolean setup_banner, boolean setup_interest_rate,
			boolean setup_other, boolean setup_contact_reason,
			boolean content_help, boolean content_page,
			boolean profile_privileges, boolean member_edit_permissions,
			boolean profile_login_username, boolean scheme_managers,
			boolean users, boolean user_enable_disable, boolean audit_trail,
			boolean operation_personal_info,
			boolean operation_contribution_history,
			boolean operation_balance_history,
			boolean operation_statement_of_account,
			boolean withdrawal_statement,
			boolean withdrawal_settlements,
			boolean reports,
			boolean member_movement,
			boolean operation_benefit_projection, boolean media_upload,
			boolean media_remove, boolean member_edit, boolean member_view) {
		super();
		this.id = id;
		this.profile = profile;
		this.setup = setup;
		this.content = content;
		this.schemes = schemes;
		this.receipts = receipts;
		this.payments = payments;
		this.members = members;
		this.operations = operations;
		this.media = media;
		this.reports = reports;
		this.member_movement = member_movement;
		this.uac = uac;
		this.analytics = analytics;
		this.setup_company = setup_company;
		this.setup_logo = setup_logo;
		this.setup_menu = setup_menu;
		this.setup_social = setup_social;
		this.setup_theme = setup_theme;
		this.setup_banner = setup_banner;
		this.setup_interest_rate = setup_interest_rate;
		this.setup_other = setup_other;
		this.setup_contact_reason = setup_contact_reason;
		this.content_help = content_help;
		this.content_page = content_page;
		this.profile_privileges = profile_privileges;
		this.member_edit_permissions = member_edit_permissions;
		this.profile_login_username = profile_login_username;
		this.scheme_managers = scheme_managers;
		this.users = users;
		this.user_enable_disable = user_enable_disable;
		this.audit_trail = audit_trail;
		this.operation_personal_info = operation_personal_info;
		this.operation_contribution_history = operation_contribution_history;
		this.operation_balance_history = operation_balance_history;
		this.operation_statement_of_account = operation_statement_of_account;
		this.operation_benefit_projection = operation_benefit_projection;
		this.withdrawal_statement = withdrawal_statement;
		this.withdrawal_settlements = withdrawal_settlements;
		this.media_upload = media_upload;
		this.media_remove = media_remove;
		this.member_edit = member_edit;
		this.member_view = member_view;
	}

	public void setUsers(boolean users) {
		this.users = users;
	}

	public boolean isAudit_trail() {
		return audit_trail;
	}

	public void setAudit_trail(boolean audit_trail) {
		this.audit_trail = audit_trail;
	}

	private boolean setup_company, setup_logo, setup_menu, setup_social, setup_theme, setup_banner, setup_interest_rate, setup_other, setup_contact_reason;
	
	private boolean content_help, content_page;
	
	private boolean profile_privileges, member_edit_permissions, profile_login_username, scheme_managers, users, user_enable_disable, audit_trail;
	
	private boolean operation_personal_info, operation_contribution_history, operation_balance_history, operation_statement_of_account, operation_benefit_projection;

	private boolean withdrawal_statement;

	private boolean withdrawal_settlements;

	private boolean reports;

	private boolean member_movement;
	
	private boolean media_upload, media_remove, profile_names;

	public boolean isReports() {
		return reports;
	}

	public void setReports(boolean reports) {
		this.reports = reports;
	}

	public boolean isWithdrawal_statement() {
		return withdrawal_statement;
	}

	public void setWithdrawal_statement(boolean withdrawal_statement) {
		this.withdrawal_statement = withdrawal_statement;
	}

	public boolean isWithdrawal_settlements() {
		return withdrawal_settlements;
	}

	public void setWithdrawal_settlements(boolean withdrawal_settlements) {
		this.withdrawal_settlements = withdrawal_settlements;
	}

	public boolean isMember_movement() {
		return member_movement;
	}

	public void setMember_movement(boolean member_movement) {
		this.member_movement = member_movement;
	}

	public boolean isProfile_names() {
		return profile_names;
	}

	public void setProfile_names(boolean profile_names) {
		this.profile_names = profile_names;
	}

	public boolean isUser_enable_disable() {
		return user_enable_disable;
	}

	public void setUser_enable_disable(boolean user_enable_disable) {
		this.user_enable_disable = user_enable_disable;
	}

	public Permission() {
		super();
		// TODO Auto-generated constructor stub
	}

	private boolean member_edit, member_view;
	
}
