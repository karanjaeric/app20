package com.fundmaster.mss.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table (name = "tbl_settings")
public class Setting  extends GenericModel<Setting> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Setting() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Long id;
	@Column (name = "xiPath", nullable = false)
	String xiPath;
	@Column (name = "username", nullable = false)
	String username;
	public String getLoginField() {
		return loginField;
	}
	public void setLoginField(String loginField) {
		this.loginField = loginField;
	}
	@Column (name = "password", nullable = false)
	String password;
	String loginField;
	boolean encrypt;
	public boolean isEncrypt() {
		return encrypt;
	}
	public void setEncrypt(boolean encrypt) {
		this.encrypt = encrypt;
	}
	public String getLogoFile() {
		return logoFile;
	}
	public void setLogoFile(String logoFile) {
		this.logoFile = logoFile;
	}
	@Column (name = "xiReportPath", nullable = false)
	String xiReportPath;
	public String getSponsorOnboading() {
		return sponsorOnboading;
	}
	public void setSponsorOnboading(String sponsorOnboading) {
		this.sponsorOnboading = sponsorOnboading;
	}
	public String getMemberOnboarding() {
		return memberOnboarding;
	}
	public void setMemberOnboarding(String memberOnboarding) {
		this.memberOnboarding = memberOnboarding;
	}
	String xiReportUsername;
	String xiReportPassword;
	String logoFile;
	String sponsorOnboading;
	String memberOnboarding;
	String portalBaseURL;
	public String getPortalBaseURL() {
		return portalBaseURL;
	}
	public void setPortalBaseURL(String portalBaseURL) {
		this.portalBaseURL = portalBaseURL;
	}
	public String getXiReportUsername() {
		return xiReportUsername;
	}
	public void setXiReportUsername(String xiReportUsername) {
		this.xiReportUsername = xiReportUsername;
	}
	public String getXiReportPassword() {
		return xiReportPassword;
	}
	public void setXiReportPassword(String xiReportPassword) {
		this.xiReportPassword = xiReportPassword;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getXiPath() {
		return xiPath;
	}
	public void setXiPath(String xiPath) {
		this.xiPath = xiPath;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getXiReportPath() {
		return xiReportPath;
	}
	public void setXiReportPath(String xiReportPath) {
		this.xiReportPath = xiReportPath;
	}

	
	
}
