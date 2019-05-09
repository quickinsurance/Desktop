package managedbeans;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

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
	private List<HealthQuotation> healthQuotationList;
	private int quotation_id;
	private Date creation_date;
	private type_contract type_contract;
	private String[] options;
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
	private String option="";
	
	    // Prime pure
		float ppConsultation, ppPharmatical, ppAnalysis, ppradio, ppOptical, ppDenntal, ppSurgery;
		// Charge de sécurié
		float CSConsult, CSPharma, CSAnalys, Csradio, CsOPtical, CsdentalCare, CsSurgery;
		// Cout unitaire
		float CUConsult, CUPharma, CURadio, CUOptical, CUDentalCare, CUSurgery, CUAnaluse;
		// Surplus et reserve
		float SPRConsult, SPROptical, SPRPharma, SPRRadio, SPRDental, SPRSurgery, SPRANalys;
		// cotisation par service
		float CConsult, COptique, CRadio, CPharma, CDental, CSurgery, Canalys;
		
		float Cotisation;

   
	private HealthQuotation healthQuotation;

	@EJB
	HealthQuotationServiceImlem quotationService;
	
	User user = new User();
	@EJB
	UserServiceImpl userImpl;
	
    public float calculPrime(){
    
    			
    			
    			// Calcule du prime
    						// calcule prime pure majorée et charge de sécurité

    						if (healthcare.contains("Public")) {
    							if (option.contains("Consultations or visits")) {
    								ppConsultation = (float) ((10 * 87.9 / 100) * 1.15 * 12);
    								if (gender==false)
    									ppConsultation = (float) (ppConsultation * 1.15);
    								if (formulas.equals("economic formula"))
    									ppConsultation = ppConsultation * 50 / 100;
    								if (formulas.equals("budget formula"))
    									ppConsultation = ppConsultation * 60 / 100;
    								if (formulas.equals("comfort formula"))
    									ppConsultation = ppConsultation * 70 / 100;
    								CSConsult = (float) (ppConsultation * 0.14);

    							}
    							if (option.contains("Pharmaceuticals")) {
    								ppPharmatical = (float) ((50 * 50 / 100) * 1.15 * 12);
    								if (gender==false)
    									ppPharmatical = (float) (ppPharmatical * 1.15);
    								if (formulas.equals("economic formula"))
    									ppPharmatical = ppPharmatical * 75 / 100;
    								if (formulas.equals("budget formula"))
    									ppPharmatical = ppPharmatical * 90 / 100;
    								if (formulas.equals("comfort formula"))
    									ppPharmatical = ppPharmatical * 100 / 100;
    								CSPharma = (float) (ppPharmatical * 0.3);
    							}
    							if (option.contains("Medical analysis")) {
    								ppAnalysis = (float) ((200 * 3 / 100) * 1.15);
    								if (gender==false)
    									ppAnalysis = (float) (ppAnalysis * 1.15);
    								if (formulas.equals("economic formula"))
    									ppAnalysis = ppAnalysis * 60 / 100;
    								if (formulas.equals("budget formula"))
    									ppAnalysis = ppAnalysis * 80 / 100;
    								if (formulas.equals("comfort formula"))
    									ppAnalysis = ppAnalysis * 100 / 100;
    								CSAnalys = (float) (ppAnalysis * 0.11);
    							}
    							if (option.contains("Radiology")) {
    								ppradio = (200 * 2 / 100);
    								if (formulas.equals("economic formula"))
    									ppradio = ppradio * 60 / 100;
    								if (formulas.equals("budget formula"))
    									ppradio = ppradio * 80 / 100;
    								if (formulas.equals("comfort formula"))
    									ppradio = ppradio * 100 / 100;
    								Csradio = (float) (ppradio * 0.48);
    							}
    							if (option.contains("Optical")) {
    								ppOptical = (150 * 80 / 100);
    								if (formulas.equals("economic formula"))
    									ppOptical = ppOptical * 40 / 100;
    								if (formulas.equals("budget formula"))
    									ppOptical = ppOptical * 50 / 100;
    								if (formulas.equals("comfort formula"))
    									ppOptical = ppOptical * 60 / 100;
    								CsOPtical = (float) (ppOptical * 0.02);
    							}
    							if (option.contains("Dental care")) {
    								ppDenntal = (50 * 58 / 100) * 12;
    								if (formulas.equals("economic formula"))
    									ppDenntal = ppDenntal * 50 / 100;
    								if (formulas.equals("budget formula"))
    									ppDenntal = ppDenntal * 60 / 100;
    								if (formulas.equals("comfort formula"))
    									ppDenntal = ppDenntal * 70 / 100;
    								CsdentalCare = (float) (ppDenntal * 0.02);
    							}
    							if (option.contains("Surgery")) {
    								ppSurgery = (300 * 2 / 100);
    								if (gender==false)
    									ppSurgery = (float) (ppSurgery * 1.15);
    								if (formulas.equals("economic formula"))
    									ppSurgery = ppSurgery * 60 / 100;
    								if (formulas.equals("budget formula"))
    									ppSurgery = ppSurgery * 70 / 100;
    								if (formulas.equals("comfort formula"))
    									ppSurgery = ppSurgery * 80 / 100;

    								CsSurgery = (float) (ppSurgery * 0.01);
    							}

    						} else if (healthcare.contains("Private")) {
    							if (option.contains("Consultations or visits")) {
    								ppConsultation = (float) ((50 * 30 / 100) * 1.15 * 12);
    								if (gender==false)
    									ppConsultation = (float) (ppConsultation * 1.15);
    								if (formulas.equals("economic formula"))
    									ppConsultation = ppConsultation * 50 / 100;
    								if (formulas.equals("budget formula"))
    									ppConsultation = ppConsultation * 60 / 100;
    								if (formulas.equals("comfort formula"))
    									ppConsultation = ppConsultation * 70 / 100;

    								CSConsult = (float) (ppConsultation * 0.3);
    							}
    							if (option.contains("Pharmaceuticals")){
    								ppPharmatical = (float) ((100 * 50 / 100) * 1.15 * 12);
    								if (gender==false)
    									ppPharmatical = (float) (ppPharmatical * 1.15);
    								if (formulas.equals("economic formula"))
    									ppPharmatical = ppPharmatical * 75 / 100;
    								if (formulas.equals("budget formula"))
    									ppPharmatical = ppPharmatical * 90 / 100;
    								if (formulas.equals("comfort formula"))
    									ppPharmatical = ppPharmatical * 100 / 100;
    								CSPharma = (float) (ppPharmatical * 0.3);
    							}
    							if (option.contains("Medical analysis")) {
    								ppAnalysis = (float) ((1.1 * 1000 / 100) * 1.15);
    								if (gender==false)
    									ppAnalysis = (float) (ppAnalysis * 1.15);
    								if (formulas.equals("economic formula"))
    									ppAnalysis = ppAnalysis * 60 / 100;
    								if (formulas.equals("budget formula"))
    									ppAnalysis = ppAnalysis * 80 / 100;
    								if (formulas.equals("comfort formula"))
    									ppAnalysis = ppAnalysis * 100 / 100;
    								CSAnalys = (float) (ppAnalysis * 0.11);
    							}
    							if (option.contains("Radiology")) {
    								ppradio = (float) (1000 * 1.1 / 100);
    								if (formulas.equals("economic formula"))
    									ppradio = ppradio * 60 / 100;
    								if (formulas.equals("budget formula"))
    									ppradio = ppradio * 80 / 100;
    								if (formulas.equals("comfort formula"))
    									ppradio = ppradio * 100 / 100;
    								Csradio = (float) (ppradio * 0.48);
    							}
    							if (option.contains("Optical")) {
    								ppOptical = (300 * 80 / 100);
    								if (formulas.equals("economic formula"))
    									ppOptical = ppOptical * 40 / 100;
    								if (formulas.equals("budget formula"))
    									ppOptical = ppOptical * 50 / 100;
    								if (formulas.equals("comfort formula"))
    									ppOptical = ppOptical * 60 / 100;
    								CsOPtical = (float) (ppOptical * 0.02);
    							}
    							if (option.contains("Dental care")) {
    								ppDenntal = (300 * 50 / 100) * 12;
    								if (formulas.equals("economic formula"))
    									ppDenntal = ppDenntal * 50 / 100;
    								if (formulas.equals("budget formula"))
    									ppDenntal = ppDenntal * 60 / 100;
    								if (formulas.equals("comfort formula"))
    									ppDenntal = ppDenntal * 70 / 100;
    								CsdentalCare = (float) (ppDenntal * 0.02);
    							}
    							if (option.contains("Surgery")) {
    								ppSurgery = (2000 * 2 / 100);
    								if (gender==false)
    									ppSurgery = (float) (ppSurgery * 1.15);
    								if (formulas.equals("economic formula"))
    									ppSurgery = ppSurgery * 60 / 100;
    								if (formulas.equals("budget formula"))
    									ppSurgery = ppSurgery * 70 / 100;
    								if (formulas.equals("comfort formula"))
    									ppSurgery = ppSurgery * 80 / 100;
    								CsSurgery = (float) (ppSurgery * 0.01);
    							}
    						}
    						// calcue Cout unitaire des servives
    						CUConsult = (ppConsultation + CSConsult) * 12 / 100;
    						CUAnaluse = (ppAnalysis + CSAnalys) * 12 / 100;
    						CUDentalCare = (ppDenntal + CsdentalCare) * 12 / 100;
    						CUOptical = (ppOptical + CsOPtical) * 12 / 100;
    						CUPharma = (ppPharmatical + CSPharma) * 12 / 100;
    						CURadio = (ppradio + Csradio) * 12 / 100;
    						CUSurgery = (ppSurgery + CsSurgery) * 12 / 100;

    						// Calcule sur plus et reserve
    						SPRConsult = (ppConsultation + CSConsult + CUConsult) * 7 / 100;
    						SPRANalys = (ppAnalysis + CSAnalys + CUAnaluse) * 7 / 100;
    						SPRDental = (ppDenntal + CsdentalCare + CUDentalCare) * 7 / 100;
    						SPROptical = (ppOptical + CsOPtical + CUOptical) * 7 / 100;
    						SPRPharma = (ppPharmatical + CSPharma + CUPharma) * 7 / 100;
    						SPRRadio = (ppradio + Csradio + CURadio) * 7 / 100;
    						SPRSurgery = (ppSurgery + CsSurgery + CUSurgery) * 7 / 100;

    						// calcule cotisation par service

    						CConsult = ppConsultation + CSConsult + CUConsult + SPRConsult;
    						Canalys = ppAnalysis + CSAnalys + CUAnaluse + SPRANalys;
    						CDental = ppDenntal + CsdentalCare + CUDentalCare + SPRDental;
    						COptique = ppOptical + CsOPtical + CUOptical + SPROptical;
    						CPharma = ppPharmatical + CSPharma + CUPharma + SPRPharma;
    						CRadio = ppradio + Csradio + CURadio + SPRRadio;
    						CSurgery = ppSurgery + CsSurgery + CUSurgery + SPRSurgery;

    						/// Cotisation Individuelle totale

    						Cotisation = CConsult + Canalys + CDental + COptique + CPharma + CRadio + CSurgery;

    						/// majoration du cotisation selon l'age
    						int age = LocalDate.now().getYear() - user.getBirthDate().getYear();
    						if (age <= 29 && age >= 24)
    							Cotisation = (float) (Cotisation * 1.05);
    						if (age <= 35 && age >= 30)
    							Cotisation = (float) (Cotisation * 1.1);
    						if (age <= 41 && age >= 36)
    							Cotisation = (float) (Cotisation * 1.15);
    						if (age <= 47 && age >= 42)
    							Cotisation = (float) (Cotisation * 1.2);
    						if (age <= 53 && age >= 48)
    							Cotisation = (float) (Cotisation * 1.25);
    						if (age <= 59 && age >= 54)
    							Cotisation = (float) (Cotisation * 1.3);
    						if (age <= 65 && age >= 60)
    							Cotisation = (float) (Cotisation * 1.35);
    						if (age < 70 && age >= 66)
    							Cotisation = (float) (Cotisation * 1.4);

    						// health majoration or bonus

    						if (general_health.equals("Very good"))
    							Cotisation = Cotisation - Cotisation * 0.1f;
    						if (general_health.equals("good"))
    							Cotisation = Cotisation - Cotisation * 0.05f;
    						if (general_health.equals("bad"))
    							Cotisation = Cotisation + Cotisation * 0.05f;
    						if (general_health.equals("very bad"))
    							Cotisation = Cotisation + Cotisation * 0.1f;

    						if (chronic_health.equals("yes"))
    							Cotisation = Cotisation * 1.1f;
    						if (chronic_health.equals("don't know"))
    							Cotisation = Cotisation * 1.05f;
    						if (smoke.equals("yes"))
    							Cotisation = Cotisation * 1.2f;
    						if (alcohol.equals("yes"))
    							Cotisation = Cotisation * 1.2f;
    						if (dangerous_sport.equals("yes"))
    							Cotisation = Cotisation * 1.15f;
    						/// majoration sur nbr D'enfant

    						int enfant = nbr_child;
    						if (enfant != 0)
    							Cotisation = Cotisation + Cotisation * enfant / 2;
    						

    						final float premium = Cotisation / 12;
    					
    			
    			return premium;
    			

    }
	public void addQuotation() {
		for(String s :options)
			option+=" "+s.toString();
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
		healthQuotation.setOptions(option);
		healthQuotation.setPartner_job(partner_job);
		healthQuotation.setSmoke(smoke);
		healthQuotation.setType_contract(type_contract.health);
		healthQuotation.setUser(user);
		healthQuotation.setInsured_people(insured_people);
		healthQuotation.setPrime(calculPrime());
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

	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
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
	public List<HealthQuotation> getQuotations(){
		user= userImpl.findUserById(1);
		healthQuotationList=quotationService.getQuotationsByUser(user);
		return healthQuotationList;
		}
	public List<HealthQuotation> getHealthQuotationList() {
		return healthQuotationList;
	}
	public void setHealthQuotationList(List<HealthQuotation> healthQuotationList) {
		this.healthQuotationList = healthQuotationList;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
