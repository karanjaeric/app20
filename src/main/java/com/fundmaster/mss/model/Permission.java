package com.fundmaster.mss.model;

import javax.persistence.*;
import java.io.Serializable;

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

	public boolean isMemberpayments() {
		return memberpayments;
	}

	public void setMemberpayments(boolean memberpayments) {
		this.memberpayments = memberpayments;
	}

	public boolean isMembers() {
		return members;
	}

	public void setMembers(boolean members) {
		this.members = members;
	}

	public boolean isMember_listing() {
		return member_listing;
	}

	public void setMember_listing(boolean member_listing) {
		this.member_listing = member_listing;
	}

	public boolean isCorporate_statement() {
		return corporate_statement;
	}

	public void setCorporate_statement(boolean corporate_statement) {
		this.corporate_statement = corporate_statement;
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
	public boolean isDocument() {
		return document;
	}

	public void setMedia(boolean media) {
		this.media = media;
	}

	public void setDocument(boolean document) {
		this.document = document;
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

	public boolean isBenefitProjectionPage() {
		return benefitProjectionPage;
	}

	public void setBenefitProjectionPage(boolean benefitProjectionPage) {
		this.benefitProjectionPage = benefitProjectionPage;
	}

	public boolean isSponsorBenefitProjectionPage() {
		return sponsorBenefitProjectionPage;
	}

	public void setSponsorBenefitProjectionPage(boolean sponsorBenefitProjectionPage) {
		this.sponsorBenefitProjectionPage = sponsorBenefitProjectionPage;
	}

	public boolean isCalculator_log() {
		return calculator_log;
	}

	public void setCalculator_log(boolean calculator_log) {
		this.calculator_log = calculator_log;
	}

	public boolean isSetup_company() {
		return setup_company;
	}

	public void setSetup_company(boolean setup_company) {
		this.setup_company = setup_company;
	}

	public boolean isSetup_email() {
		return setup_email;
	}

	public void setSetup_email(boolean setup_email) {
		this.setup_email = setup_email;
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

	public boolean isEnable_acc_recovery() {
		return enable_acc_recovery;
	}

	public void setEnable_acc_recovery(boolean enable_acc_recovery) {
		this.enable_acc_recovery = enable_acc_recovery;
	}

	public boolean isDb_menu() {
		return db_menu;
	}

	public void setDb_menu(boolean db_menu) {
		this.db_menu = db_menu;
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

	public boolean isFaq_page() {
		return faq_page;
	}

	public void setFaq_page(boolean faq_page) {
		this.faq_page = faq_page;
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

	public boolean isOperation_unitized_statement() {
		return operation_unitized_statement;
	}

	public void setOperation_unitized_statement(boolean operation_unitized_statement) {
		this.operation_unitized_statement = operation_unitized_statement;
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

	public boolean isOperation_claim_status() {
		return operation_claim_status;
	}

	public void setOperation_claim_status(boolean operation_claim_status) {
		this.operation_claim_status = operation_claim_status;
	}

	public boolean isOperation_annual_contribution() {
		return operation_annual_contribution;
	}

	public void setOperation_annual_contribution(boolean operation_annual_contribution) {
		this.operation_annual_contribution = operation_annual_contribution;
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

	public boolean isShow_db_contribution_graph() {
		return show_db_contribution_graph;
	}

	public void setShow_db_contribution_graph(boolean show_db_contribution_graph) {
		this.show_db_contribution_graph = show_db_contribution_graph;
	}

	public boolean isMember_menu_config() {
		return member_menu_config;
	}

	public void setMember_menu_config(boolean member_menu_config) {
		this.member_menu_config = member_menu_config;
	}

	public boolean isPensioner_menu_config() {
		return pensioner_menu_config;
	}

	public void setPensioner_menu_config(boolean pensioner_menu_config) {
		this.pensioner_menu_config = pensioner_menu_config;
	}

	public boolean isMember_dashboard_items() {
		return member_dashboard_items;
	}

	public void setMember_dashboard_items(boolean member_dashboard_items) {
		this.member_dashboard_items = member_dashboard_items;
	}

	public boolean isAdmin_dashboard_items() {
		return admin_dashboard_items;
	}

	public void setAdmin_dashboard_items(boolean admin_dashboard_items) {
		this.admin_dashboard_items = admin_dashboard_items;
	}

	public boolean isProfile_login_username() {
		return profile_login_username;
	}

	public void setProfile_login_username(boolean profile_login_username) {
		this.profile_login_username = profile_login_username;
	}

	public boolean isClient_setup_config() {
		return client_setup_config;
	}

	public void setClient_setup_config(boolean client_setup_config) {
		this.client_setup_config = client_setup_config;
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
	
	private boolean setup, content, schemes, receipts, payments,memberpayments, members, member_listing, corporate_statement, operations, media,document, uac, analytics,benefitProjectionPage, sponsorBenefitProjectionPage,calculator_log ;
	
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
			boolean schemes, boolean receipts, boolean payments,boolean memberpayments,
			boolean members, boolean member_listing, boolean corporate_statement, boolean operations, boolean media,boolean document, boolean uac,
			boolean analytics, boolean benefitProjectionPage, boolean sponsorBenefitProjectionPage,boolean calculator_log, boolean setup_company, boolean setup_email, boolean setup_logo,
			boolean setup_menu, boolean enable_acc_recovery,boolean db_menu, boolean setup_social, boolean setup_theme,
			boolean setup_banner, boolean setup_interest_rate,
			boolean setup_other, boolean setup_contact_reason,
			boolean content_help, boolean content_page, boolean faq_page,
			boolean profile_privileges, boolean member_edit_permissions, boolean show_db_contribution_graph,
			boolean profile_login_username, boolean client_setup_config,boolean scheme_managers, boolean member_menu_config, boolean pensioner_menu_config, boolean member_dashboard_items, boolean admin_dashboard_items,
			boolean users, boolean user_enable_disable, boolean audit_trail,
			boolean operation_personal_info,
			boolean operation_contribution_history,
			boolean operation_balance_history,
			boolean operation_statement_of_account,
			boolean operation_unitized_statement,
			boolean withdrawal_statement,
			boolean withdrawal_settlements,
			boolean admin_fee_listing,
			boolean reports,
			boolean member_movement,
			boolean fund_movement,
			boolean receipt_summary,
			boolean operation_benefit_projection,
			boolean pending_contribution,
			boolean operation_annual_contribution,
			boolean operation_claim_status,
			boolean media_upload,
			boolean media_remove, boolean member_edit, boolean member_view) {
		super();
		this.id = id;
		this.profile = profile;
		this.setup = setup;
		this.content = content;
		this.schemes = schemes;
		this.receipts = receipts;
		this.payments = payments;
		this.memberpayments =memberpayments;
		this.members = members;
		this.member_listing = member_listing;
		this.corporate_statement = corporate_statement;
		this.operations = operations;
		this.media = media;
		this.document = document;
		this.reports = reports;
		this.member_movement = member_movement;
		this.fund_movement = fund_movement;
		this.receipt_summary = receipt_summary;
		this.pending_contribution = pending_contribution;
		this.uac = uac;
		this.analytics = analytics;
		this.benefitProjectionPage =benefitProjectionPage;
		this.sponsorBenefitProjectionPage =sponsorBenefitProjectionPage;
		this.calculator_log = calculator_log;
		this.setup_company = setup_company;
		this.setup_email = setup_email;
		this.setup_logo = setup_logo;
		this.setup_menu = setup_menu;
		this.enable_acc_recovery=enable_acc_recovery;
		this.db_menu = db_menu;
		this.setup_social = setup_social;
		this.setup_theme = setup_theme;
		this.setup_banner = setup_banner;
		this.setup_interest_rate = setup_interest_rate;
		this.setup_other = setup_other;
		this.setup_contact_reason = setup_contact_reason;
		this.content_help = content_help;
		this.content_page = content_page;
		this.faq_page = faq_page;
		this.profile_privileges = profile_privileges;
		this.member_edit_permissions = member_edit_permissions;
		this.show_db_contribution_graph = show_db_contribution_graph;
		this.member_menu_config = member_menu_config;
		this.pensioner_menu_config = pensioner_menu_config;
		this.member_dashboard_items = member_dashboard_items;
		this.admin_dashboard_items =admin_dashboard_items;
		this.profile_login_username = profile_login_username;
		this.client_setup_config =client_setup_config;
		this.scheme_managers = scheme_managers;
		this.users = users;
		this.user_enable_disable = user_enable_disable;
		this.audit_trail = audit_trail;
		this.operation_personal_info = operation_personal_info;
		this.operation_contribution_history = operation_contribution_history;
		this.operation_balance_history = operation_balance_history;
		this.operation_statement_of_account = operation_statement_of_account;
		this.operation_unitized_statement=operation_unitized_statement;
		this.operation_benefit_projection = operation_benefit_projection;
		this.operation_annual_contribution = operation_annual_contribution;
		this.operation_claim_status = operation_claim_status;
		this.withdrawal_statement = withdrawal_statement;
		this.withdrawal_settlements = withdrawal_settlements;
		this.admin_fee_listing = admin_fee_listing;
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

	private boolean setup_company, setup_email, setup_logo, setup_menu, enable_acc_recovery,db_menu, setup_social, setup_theme, setup_banner, setup_interest_rate, setup_other, setup_contact_reason;
	
	private boolean content_help, content_page, faq_page;
	
	private boolean profile_privileges, member_edit_permissions, show_db_contribution_graph, member_menu_config, pensioner_menu_config, member_dashboard_items, admin_dashboard_items,  profile_login_username, client_setup_config, scheme_managers, users, user_enable_disable, audit_trail;
	
	private boolean operation_personal_info, operation_contribution_history, operation_balance_history, operation_statement_of_account,operation_unitized_statement, operation_benefit_projection, operation_claim_status, operation_annual_contribution;

	private boolean withdrawal_statement;

	private boolean withdrawal_settlements;

	private boolean admin_fee_listing;

	private boolean reports;

	private boolean member_movement;

	private boolean fund_movement;

	private boolean receipt_summary;

	private boolean pending_contribution;

	
	private boolean media_upload, media_remove, profile_names,client_names;

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

	public boolean isAdmin_fee_listing() {
		return admin_fee_listing;
	}

	public void setAdmin_fee_listing(boolean admin_fee_listing) {
		this.admin_fee_listing = admin_fee_listing;
	}

	public boolean isMember_movement() {
		return member_movement;
	}

	public void setMember_movement(boolean member_movement) {
		this.member_movement = member_movement;
	}

	public boolean isFund_movement() {
		return fund_movement;
	}

	public void setFund_movement(boolean fund_movement) {
		this.fund_movement = fund_movement;
	}

	public boolean isReceipt_summary() {
		return receipt_summary;
	}

	public void setReceipt_summary(boolean receipt_summary) {
		this.receipt_summary = receipt_summary;
	}

	public boolean isPending_contribution() {
		return pending_contribution;
	}

	public void setPending_contribution(boolean pending_contribution) {
		this.pending_contribution = pending_contribution;
	}

	public boolean isProfile_names() {
		return profile_names;
	}

	public void setProfile_names(boolean profile_names) {
		this.profile_names = profile_names;
	}

	public boolean isClient_names() {
		return client_names;
	}

	public void setClient_names(boolean client_names) {
		this.client_names = client_names;
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
