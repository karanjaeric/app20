package com.fundmaster.mss.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "tbl_social")
public class Social extends GenericModel<Social>  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private
	Long id;
	@Column (name = "twitter", nullable = false)
	private
	String twitter;
	@Column (name = "facebook", nullable = false)
	private
	String facebook;
	@Column (name = "linkedin", nullable = false)
	private
	String linkedin;
	@Column (name = "google", nullable = false)
	private
	String google;
	@Column (name = "youtube", nullable = false)
	private
	String youtube;
	@Column (name = "pinterest", nullable = false)
	private
	String pinterest;
	public Social() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getLinkedin() {
		return linkedin;
	}
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
	public String getGoogle() {
		return google;
	}
	public void setGoogle(String google) {
		this.google = google;
	}
	public String getYoutube() {
		return youtube;
	}
	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}
	public String getPinterest() {
		return pinterest;
	}
	public void setPinterest(String pinterest) {
		this.pinterest = pinterest;
	}
	public Social(Long id, String twitter, String facebook, String linkedin,
			String google, String youtube, String pinterest) {
		super();
		this.id = id;
		this.twitter = twitter;
		this.facebook = facebook;
		this.linkedin = linkedin;
		this.google = google;
		this.youtube = youtube;
		this.pinterest = pinterest;
	}

}
