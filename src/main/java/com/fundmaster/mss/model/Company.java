package com.fundmaster.mss.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "tbl_company")
public class Company extends GenericModel<Company> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private
	Long id;
	@Column (name = "name", nullable = false)
	private
	String name;
	@Column (name = "streetAddress", nullable = false)
	private
	String streetAddress;
	@Column (name = "telephone", nullable = false)
	private
	String telephone;
	@Column (name = "fax", nullable = false)
	private
	String fax;
	/*@Column (name = "email", nullable = false)
	private
	String email;
	private String emailAddress;*/
	@Column (name = "city", nullable = false)
	private
	String city;
	@OneToOne(fetch = FetchType.EAGER)
	private
	Country country;
	@Column (name = "geolocation", nullable = false)
	private
	String geolocation;
	public Company() {
		// TODO Auto-generated constructor stub
	}
	/*public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}*/
	public Company(Long id, String name, String streetAddress,
			String telephone, String fax, String city, Country country, String geolocation) {
		super();
		this.id = id;
		this.name = name;
		this.streetAddress = streetAddress;
		this.telephone = telephone;
		this.fax = fax;
		/*this.email = email;
		this.emailAddress = emailAddress;*/
		this.city = city;
		this.country = country;
		this.geolocation = geolocation;
	}
	public Long getId() {
		return id;
	}
	public String getGeolocation() {
		return geolocation;
	}
	public void setGeolocation(String geolocation) {
		this.geolocation = geolocation;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	/*public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}*/

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}

}
