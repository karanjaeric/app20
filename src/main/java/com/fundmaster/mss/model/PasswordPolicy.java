package com.fundmaster.mss.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tbl_password_policy")
public class PasswordPolicy extends GenericModel<PasswordPolicy> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5545494757508796863L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	private int length;
	
	private int expiry_days;
	
	private boolean uppercase;
	
	private boolean lowercase;

	private boolean numbers;
	
	private int lock_after_count_of;
	
	private boolean password_reuse;
	
	public PasswordPolicy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getExpiry_days() {
		return expiry_days;
	}

	public void setExpiry_days(int expiry_days) {
		this.expiry_days = expiry_days;
	}

	public boolean isUppercase() {
		return uppercase;
	}

	public void setUppercase(boolean uppercase) {
		this.uppercase = uppercase;
	}

	public boolean isLowercase() {
		return lowercase;
	}

	public void setLowercase(boolean lowercase) {
		this.lowercase = lowercase;
	}

	public boolean isNumbers() {
		return numbers;
	}

	public void setNumbers(boolean numbers) {
		this.numbers = numbers;
	}

	public int getLock_after_count_of() {
		return lock_after_count_of;
	}

	public void setLock_after_count_of(int lock_after_count_of) {
		this.lock_after_count_of = lock_after_count_of;
	}

	public boolean isPassword_reuse() {
		return password_reuse;
	}

	public void setPassword_reuse(boolean password_reuse) {
		this.password_reuse = password_reuse;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
