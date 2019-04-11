package entities;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Claim")
public class Claim implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="Claim_ID")
	private int claim_id;
	@Column(name="Description",nullable = false,length=1000) 
	private String description;
	@Column(nullable = false) 
	@Enumerated(EnumType.STRING)
	private type_subject type_subject;	
	public enum type_subject{Vehicle("vehicle"),
		housing("housing"),
		health("health"),
		equipment("equipment"),
		application("application"),
		refunds("refunds"),
		report("report"),
		rescission("recscission");
		private type_subject (String name){} 
	}
	@Column(name="ref",nullable = false) 
	private int Reference_police;
	@Lob
	@Column(name="doc1",nullable = false) 
	private byte[] document;
	@Column(nullable = false) 
	private Date claim_date;
	private String insurance_response;
	@Column(nullable = false) 
	private String traitement;
	
	@ManyToOne
	User User;
	public Claim(){}
	public int getClaim_id() {
		return claim_id;
	}
	public byte[] getDocument() {
		return document;
	}
	public void setDocument(byte[] document) {
		this.document = document;
	}
	public Date getClaim_date() {
		return claim_date;
	}
	public void setClaim_date(Date claim_date) {
		this.claim_date = claim_date;
	}
	
	
	public String getInsurance_response() {
		return insurance_response;
	}
	public void setInsurance_response(String insurance_response) {
		this.insurance_response = insurance_response;
	}
	public String getTraitement() {
		return traitement;
	}
	public void setTraitement(String traitement) {
		this.traitement = traitement;
	}
	public int getReference_police() {
		return Reference_police;
	}
	public void setReference_police(int reference_police) {
		Reference_police = reference_police;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public type_subject getType_subject() {
		return type_subject;
	}
	public void setType_subject(type_subject type_subject) {
		this.type_subject = type_subject;
	}
	public User getUser() {
		return User;
	}
	public void setUser(User user) {
		User = user;
	}
	@Override
	public String toString() {
		return "Claim [claim_id=" + claim_id + ", description=" + description + ", type_subject=" + type_subject
				+ ", Reference_police=" + Reference_police +  ", claim_date=" + claim_date
				+ ", User=" + User + "]";
	}
	
	
}
