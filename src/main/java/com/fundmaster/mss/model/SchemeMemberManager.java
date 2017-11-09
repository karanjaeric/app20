package com.fundmaster.mss.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "tbl_scheme_member_managers")
public class SchemeMemberManager extends GenericModel<SchemeMemberManager> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9094623503938354022L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUser_id() {
		return user_id;
	}

	public SchemeMemberManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SchemeMemberManager(long id, long user_id, String profile,
			String schemeID, String name, String scheme) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.profile = profile;
		this.schemeID = schemeID;
		this.name = name;
		this.scheme = scheme;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private long user_id;
	
	private String profile;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String schemeID;
	
	private String name;
	
	private String scheme;

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public String getSchemeID() {
		return schemeID;
	}

	public void setSchemeID(String schemeID) {
		this.schemeID = schemeID;
	}

}
