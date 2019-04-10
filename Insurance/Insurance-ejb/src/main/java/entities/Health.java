package entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Health")
public class Health extends Contract implements Serializable{
	@Override
	public String toString() {
		return "Health [ Options "+ options+"]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "options", nullable = false)
	private String options;
	@Column(name="insured_peoples")
	private String insured_people;
	@Column(name="general_health")
	private String general_health;
	@Column(name="chronic_health")
	private String chronic_health;
	@Column(name="smoke")
	private String smoke;
	@Column(name="dangerous_sport")
	private String dangerous_sport;
	@Column(name="alcohol")
	private String alcohol;
	
	@Column(name="nbr_Child")
	private int nbr_child;
	@Column(name="birthDate_PARTNER" )
	private Date birthDate_PARTNER;
	@Column(name="partner_job" )
	private String partner_job;
	
	@Column(name="rescission")
	private boolean rescission ;
	@Column(name="formulas")
	private String formulas;
	@Column(name="healthcare")
	private String healthcare;
	
	
	
	
	
	public String getHealthcare() {
		return healthcare;
	}

	public void setHealthcare(String healthcare) {
		this.healthcare = healthcare;
	}

	public String getFormulas() {
		return formulas;
	}

	public void setFormulas(String formulas) {
		this.formulas = formulas;
	}

	public Boolean getRescission() {
		return rescission;
	}

	public void setRescission(Boolean rescission) {
		this.rescission = rescission;
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

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy="Health")
	private Set<MedicalFile> MedicalFiles;
	
	public Health(){}



	public Set<MedicalFile> getMedicalFiles() {
		return MedicalFiles;
	}

	public void setMedicalFiles(Set<MedicalFile> medicalFiles) {
		MedicalFiles = medicalFiles;
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

	public void setRescission(boolean rescission) {
		this.rescission = rescission;
	}
	
	
}
