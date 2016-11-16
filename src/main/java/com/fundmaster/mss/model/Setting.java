package com.fundmaster.mss.model;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
	private Long id;
	
	@Column (name = "xiPath", nullable = false)
	private String xiPath;
	
	@Column (name = "username", nullable = false)
	private String username;
	
	
	@Lob
	@Column (name = "logo", columnDefinition = "LONGBLOB")
	private Blob logo;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


	public Blob getLogo() {
		return logo;
	}

	public void setLogo(Blob logo) {
		this.logo = logo;
	}

	public String getLoginField() {
		return loginField;
	}
	public void setLoginField(String loginField) {
		this.loginField = loginField;
	}
	
	@Column (name = "password", nullable = false)
	private String password;
	private String loginField;
	private boolean encrypt;
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
	private
	String xiReportPath;

	public String getWhatIfAnalysisFormula() {
		return whatIfAnalysisFormula;
	}

	public void setWhatIfAnalysisFormula(String whatIfAnalysisFormula) {
		this.whatIfAnalysisFormula = whatIfAnalysisFormula;
	}

	public String getSponsorOnboarding() {
		return sponsorOnboarding;
	}
	public void setSponsorOnboarding(String sponsorOnboarding) {
		this.sponsorOnboarding = sponsorOnboarding;
	}
	public String getMemberOnboarding() {
		return memberOnboarding;
	}
	public void setMemberOnboarding(String memberOnboarding) {
		this.memberOnboarding = memberOnboarding;
	}
	private String xiReportUsername;
	private String xiReportPassword;
	private String logoFile;
	private String sponsorOnboarding;
	private String memberOnboarding;
	private String whatIfAnalysisFormula;
	private String portalBaseURL;
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
