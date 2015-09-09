package com.fundmaster.mss.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tbl_theme")
public class Theme extends GenericModel<Theme> implements Serializable{ 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Theme() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Long id;
	@Column (name = "major", nullable = false)
	String major;
	@Column (name = "minor", nullable = false)
	String minor;
	@Column (name = "font", nullable = false)
	String font;
	@Column (name = "other", nullable = false)
	String other;
	@Column (name = "header", nullable = false)
	String header;
	@Column (name = "content", nullable = false)
	String content;
	@Column (name = "footer", nullable = false)
	String footer;
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFooter() {
		return footer;
	}
	public void setFooter(String footer) {
		this.footer = footer;
	}
	
	public Theme(Long id, String major, String minor, String font,
			String other, String header, String content, String footer) {
		super();
		this.id = id;
		this.major = major;
		this.minor = minor;
		this.font = font;
		this.other = other;
		this.header = header;
		this.content = content;
		this.footer = footer;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getMinor() {
		return minor;
	}
	public void setMinor(String minor) {
		this.minor = minor;
	}
	public String getFont() {
		return font;
	}
	public void setFont(String font) {
		this.font = font;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
