package entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "HealthQuotation")
public class HealthQuotation extends Quotation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Column(name = "options", nullable = false)
	private String options;
	@Column(name="insured_peoples" ,nullable = false)
	private String insured_people;
	@Column(name="general_health", nullable = false)
	private String general_health;
	@Column(name="chronic_health", nullable = false)
	private String chronic_health;
	@Column(name="smoke", nullable = false)
	private String smoke;
	@Column(name="dangerous_sport", nullable = false)
	private String dangerous_sport;
	@Column(name="alcohol", nullable = false)
	private String alcohol;
	
	@Column(name="nbr_Child")
	private int nbr_child;
	@Column(name="birthDate_PARTNER")
	private Date birthDate_PARTNER;
	@Column(name="partner_job")
	private String partner_job;
	@Column(name="formulas")
	private String formulas;
	@Column(name="healthcare")
	private String healthcare;
	@Column(name = "Prime", nullable = false)
	private float prime;
	
	
	
	
	
	public float getPrime() {
		return prime;
	}

	public void setPrime(float prime) {
		this.prime = prime;
	}

	public String getHealthcare() {
		return healthcare;
	}

	public void setHealthcare(String healthcare) {
		this.healthcare = healthcare;
	}
	
	
	public HealthQuotation() {
	
	}
	
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public String getInsured_people() {
		return insured_people;
	}
	public void setInsured_people(String insured_people) {
		this.insured_people = insured_people;
	}
	public String getGeneral_health() {
		return general_health;
	}
	public void setGeneral_health(String general_health) {
		this.general_health = general_health;
	}
	public String getChronic_health() {
		return chronic_health;
	}
	public void setChronic_health(String chronic_health) {
		this.chronic_health = chronic_health;
	}
	public String getSmoke() {
		return smoke;
	}
	public void setSmoke(String smoke) {
		this.smoke = smoke;
	}
	public String getDangerous_sport() {
		return dangerous_sport;
	}
	public void setDangerous_sport(String dangerous_sport) {
		this.dangerous_sport = dangerous_sport;
	}
	public String getAlcohol() {
		return alcohol;
	}
	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
	}
	@Override
	public String toString() {
		return "HealthQuotation [  options=" + options + ", insured_people=" + insured_people
				+ ", general_health=" + general_health + ", chronic_health=" + chronic_health + ", smoke=" + smoke
				+ ", dangerous_sport=" + dangerous_sport + ", alcohol=" + alcohol + "]";
	}

	public int getNbr_child() {
		return nbr_child;
	}

	public void setNbr_child(int nbr_child) {
		this.nbr_child = nbr_child;
	}

	public Date getBirthDate_PARTNER() {
		return birthDate_PARTNER;
	}

	public void setBirthDate_PARTNER(Date birthDate_PARTNER) {
		this.birthDate_PARTNER = birthDate_PARTNER;
	}

	public String getPartner_job() {
		return partner_job;
	}

	public void setPartner_job(String partner_job) {
		this.partner_job = partner_job;
	}

	public String getFormulas() {
		return formulas;
	}

	public void setFormulas(String formulas) {
		this.formulas = formulas;
	}
	
	
	

}
