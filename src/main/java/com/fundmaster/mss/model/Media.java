package com.fundmaster.mss.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
@Entity
@Table (name = "tbl_media")
public class Media extends GenericModel<Media>  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "name", nullable = false)
	private String name;
	
	@Column (name = "scheme", nullable = false)
	private String schemeID;
	
	@Column (name="description", nullable = false)
	private String description;
	
	@Column (name = "access", nullable = false)
	private String access;
	
	@Lob
	@Column (name = "file", columnDefinition = "BLOB NOT NULL")
	byte[] file;
	
	String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	private	Date created;
	private boolean administrator;
	private boolean member;
	private boolean crm;
	private boolean sponsor;
	private boolean trustee;
	private boolean agent;
	private boolean custodian;
	private boolean cre;
	private boolean fundManager;
	private boolean pensioner;
	private long memberId;
	
	public Media() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getSchemeID() {
		return schemeID;
	}


	public void setSchemeID(String schemeID) {
		this.schemeID = schemeID;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public boolean isAdministrator() {
		return administrator;
	}


	public void setAdministrator(boolean administrator) {
		this.administrator = administrator;
	}


	public boolean isMember() {
		return member;
	}


	public void setMember(boolean member) {
		this.member = member;
	}


	public boolean isCrm() {
		return crm;
	}


	public void setCrm(boolean crm) {
		this.crm = crm;
	}


	public boolean isSponsor() {
		return sponsor;
	}


	public void setSponsor(boolean sponsor) {
		this.sponsor = sponsor;
	}


	public boolean isTrustee() {
		return trustee;
	}


	public void setTrustee(boolean trustee) {
		this.trustee = trustee;
	}


	public boolean isAgent() {
		return agent;
	}


	public void setAgent(boolean agent) {
		this.agent = agent;
	}


	public boolean isCustodian() {
		return custodian;
	}


	public void setCustodian(boolean custodian) {
		this.custodian = custodian;
	}


	public boolean isCre() {
		return cre;
	}


	public void setCre(boolean cre) {
		this.cre = cre;
	}


	public boolean isFundManager() {
		return fundManager;
	}


	public void setFundManager(boolean fundManager) {
		this.fundManager = fundManager;
	}


	public boolean isPensioner() {
		return pensioner;
	}


	public void setPensioner(boolean pensioner) {
		this.pensioner = pensioner;
	}

	public long getMemberId() {
		return memberId;
	}


	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAccess() {
		return access;
	}
	public void setAccess(String access) {
		this.access = access;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Media(String name, String schemeID, String description, String access, Date created) {
		super();
		this.id = null;
		this.name = name;
		this.schemeID = schemeID;
		this.description = description;
		this.access = access;
		this.created = created;
	}
	
}
