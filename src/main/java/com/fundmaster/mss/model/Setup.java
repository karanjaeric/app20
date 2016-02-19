package com.fundmaster.mss.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tbl_config")
public class Setup extends GenericModel<Setup>  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Setup() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private
	int id;
	@Column(name = "companyName", nullable = false)
	private
	String companyName;
	@Column(name = "streetAddress", nullable = false)
	private
	String streetAddress;
	@Column(name = "telephone", nullable = false)
	private
	String telephone;
	@Column(name = "fax", nullable = false)
	private
	String fax;
	@Column(name = "emailAddress", nullable = false)
	private
	String emailAddress;
	@Column(name = "city", nullable = false)
	private
	String city;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Setup(int id, String companyName, String streetAddress,
			String telephone, String fax, String emailAddress, String city) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.streetAddress = streetAddress;
		this.telephone = telephone;
		this.fax = fax;
		this.emailAddress = emailAddress;
		this.city = city;
	}

}
