package managedbeans;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.HealthQuotation;
import entities.User;
import entities.Contract.type_contract;
import services.impl.HealthQuotationServiceImlem;
import services.impl.UserServiceImpl;

@ManagedBean(name = "healthQuotationBean")
@SessionScoped
public class HealthQuotationBean implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	private int quotation_id;
	private Date creation_date;
	private type_contract type_contract;
	private String options;
	private String insured_people;
	private String general_health;
	private String chronic_health;
	private String smoke;
	private String dangerous_sport;
	private String alcohol;
	private int nbr_child;
	private Date birthDate_PARTNER;
	private String partner_job;
	private String formulas;
	private String healthcare;
	private float prime;
	private float salary;
	private boolean gender;
   
	private HealthQuotation healthQuotation;

	@EJB
	HealthQuotationServiceImlem quotationService;
	
	User user = new User();
	@EJB
	UserServiceImpl userImpl;
	

	public void addQuotation() {
		user= userImpl.findUserById(1);

		healthQuotation = new HealthQuotation();

		healthQuotation.setCreation_date(Date.valueOf(LocalDate.now()));
		healthQuotation.setAlcohol(alcohol);
		healthQuotation.setBirthDate_PARTNER(Date.valueOf(LocalDate.now().minusYears(27)));
		healthQuotation.setChronic_health(chronic_health);
		healthQuotation.setDangerous_sport(dangerous_sport);
		healthQuotation.setFormulas(formulas);
		healthQuotation.setGeneral_health(general_health);
		healthQuotation.setHealthcare(healthcare);
		healthQuotation.setInsured_people(insured_people);
		healthQuotation.setNbr_child(nbr_child);
		healthQuotation.setOptions(options);
		healthQuotation.setPartner_job(partner_job);
		healthQuotation.setSmoke(smoke);
		healthQuotation.setType_contract(type_contract.health);
		healthQuotation.setUser(user);
		healthQuotation.setInsured_people(insured_people);
		healthQuotation.setPrime(salary);
		quotationService.addHealthQuotation(healthQuotation);
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public HealthQuotation getHealthQuotation() {
		return healthQuotation;
	}

	public void setHealthQuotation(HealthQuotation healthQuotation) {
		this.healthQuotation = healthQuotation;
	}

	public int getQuotation_id() {
		return quotation_id;
	}

	public void setQuotation_id(int quotation_id) {
		this.quotation_id = quotation_id;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public type_contract getType_contract() {
		return type_contract;
	}

	public void setType_contract(type_contract type_contract) {
		this.type_contract = type_contract;
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

	public String getHealthcare() {
		return healthcare;
	}

	public void setHealthcare(String healthcare) {
		this.healthcare = healthcare;
	}

	public float getPrime() {
		return prime;
	}

	public void setPrime(float prime) {
		this.prime = prime;
	}

}
