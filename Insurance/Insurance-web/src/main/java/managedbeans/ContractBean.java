package managedbeans;




import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.security.auth.login.LoginContext;

import  entities.User;
import entities.Contract.type_contract;
import entities.Guarantee;
import entities.Client;
import  entities.Housing;
import services.impl.*;


@ManagedBean(name = "ContractBean") 
@SessionScoped
public class ContractBean implements Serializable {
	Client client;
	type_contract tc ;
	private static final long serialVersionUID = 1L;
	String address;
	String type_housing;
	String area;
	int codePostal;
	int housevalue;
	String garage;
	String houseduration;
	String houseownertype;
	String homemainsec;
	String floorapartment;
    float prime ;
	String houseProtection; 
	String houseempty;
	String objectsinsured;
	int objectsvalue;
	String image;
	String guarantee;
	String etatdemande;
	int uninhabited;
float Prime1 = 100f;

	int sinisternmbr;


	@EJB
	HousingContractService HousingContractService; 
	UserServiceImpl UserServiceImpl ;
	public ContractBean() {}
	
	public String addcontract()
	{    
		 User user = HousingContractService.getUserByCIN(LoginBean.getInstance().getUser().getCin());
		Housing h = new Housing();
		h.setAddress(area);
		h.setArea(address);
		h.setCodePostal(codePostal);
		h.setFloorapartment(floorapartment);
		h.setHouseownertype(houseownertype);
		h.setGuarantee("HO-2");
		h.setHomemainsec("homemainsec");
		h.setHouseduration(houseduration);
		h.setType_housing(type_housing);
        h.setGarage(garage);
		h.setHouseProtection(houseProtection);
		h.setHousevalue(housevalue);
		h.setImage("image");
		h.setObjectsinsured(objectsinsured);//objectsBox.getValue()
		h.setObjectsvalue(objectsvalue);
		h.setSinisternmbr(sinisternmbr);
		h.setUninhabited(uninhabited);
		Date today = new Date();
		today.setHours(0);
        
		h.setCommission(200);
		h.setDate_end(java.sql.Date.valueOf(java.time.LocalDate.now()));
		/*   h.setDate_end(java.sql.Date.valueOf(date.getValue()));*/
		h.setEtatdemande("on hold");
		h.setType_contract(tc.housing);
		h.setHouseempty("empty");
		h.setDate_creation(java.sql.Date.valueOf(java.time.LocalDate.now()));
 
		h.setClient((Client) user);
		float prime =calculerprime(h);
		h.setPrime(prime);
		

HousingContractService.addContracthouse(h);
		
		
		String navigateTo = "null"; 
		navigateTo = "/Template?faces-redirect=true";
        return navigateTo ;
	}
	public void removeEmploye(int employeId)
	{
		//
	}
	public void displayprime(Housing h)
	{

this.prime=(h.getPrime());
		
		
	}
	public float calculerprime(Housing h){
		float prime;
		float expense_per_exposure_unit1 =25; //
		float expense_per_exposure_unit2 =310;//

		float exposure_unit = 100000;

		float exposure_unit2 = 100000;//every insurance company set exposure unit which depends on the risk 

		float housevaluee=0;

		float objectsvalue=0;

		float protect =1.05f;

		float  unhabited =1.03f;

		float sinistercoff=0;

		float guranteevalue=0;

		float houseage =1.1f;

		float b = 0;
		if (h.getObjectsvalue()==0){
			objectsvalue=	h.getObjectsvalue()/exposure_unit2*expense_per_exposure_unit2;
			housevaluee =h.getHousevalue()/exposure_unit*expense_per_exposure_unit1;
			b = housevaluee;


		}else if(h.getHousevalue()==0)
		{   objectsvalue=	h.getObjectsvalue()/exposure_unit2*expense_per_exposure_unit2;
		housevaluee =h.getHousevalue()/exposure_unit*expense_per_exposure_unit1;
		b = objectsvalue;

		}else{
			objectsvalue=	h.getObjectsvalue()/exposure_unit2*expense_per_exposure_unit2;
			housevaluee =h.getHousevalue()/exposure_unit*expense_per_exposure_unit1;
			b = objectsvalue+ housevaluee;
		}

		HashMap<Double, String> hmap = new HashMap<Double, String>();

		double  franchise = 0.3;
		if (h.getSinisternmbr()==0)
		{ sinistercoff= 0;	
		}else if(h.getSinisternmbr()==1)
		{ sinistercoff=(float) (housevaluee*0.1+objectsvalue*0.01);
		}
		else if(h.getSinisternmbr()==2)
		{ sinistercoff=(float) (housevaluee*0.15+objectsvalue*0.015);

		} else 
		{sinistercoff=(float) (housevaluee*0.2+objectsvalue*0.02);

		}



		if (h.getHouseProtection()=="none")
		{
			protect=1;  
		}

		if (h.getUninhabited()<180)
		{
			unhabited =1;
		}

	if(h.getGuarantee()=="HO-2"){//11
			guranteevalue =1;
		}
		if(h.getGuarantee()=="HO-3"){//16
			guranteevalue=  1.2f;
		}
		if(h.getGuarantee()=="HO-5"){//16 and covers personal property from almost every peri
			guranteevalue = 1.4f;
		}
		if(h.getGuarantee()=="HO-8"){ //only 11 and low prime cost in gurantee not all the amount refunded
			guranteevalue = 0.9f;
		}

		if(h.getHouseduration().equals("new"))
		{
			houseage=1;
		}

		prime=((((b+sinistercoff)*protect)*unhabited)*houseage)*guranteevalue;



		System.out.print("prime");



		return prime;



	}
	
	
	public float showdevis()
	{
		List<Housing> h =HousingContractService.findHouseContractsbyclient(LoginBean.getInstance().getUser().getCin());
		Prime1 =h.get(0).getPrime();
		return Prime1;
	}
	public List<Housing> showcontract()
	{
		List<Housing> h =HousingContractService.findHouseContractsbyclient(LoginBean.getInstance().getUser().getCin());

		return h;
	}
	public List<Guarantee> showGurantee()
	{
		List<Guarantee> h =HousingContractService.findHouseguranteebycontractid(LoginBean.getInstance().getUser().getCin());

		return h;
	}

	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public type_contract getTc() {
		return tc;
	}
	public void setTc(type_contract tc) {
		this.tc = tc;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getType_housing() {
		return type_housing;
	}
	public void setType_housing(String type_housing) {
		this.type_housing = type_housing;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	public int getHousevalue() {
		return housevalue;
	}
	public void setHousevalue(int housevalue) {
		this.housevalue = housevalue;
	}
	public String getGarage() {
		return garage;
	}
	public void setGarage(String garage) {
		this.garage = garage;
	}
	public String getHouseduration() {
		return houseduration;
	}
	public void setHouseduration(String houseduration) {
		this.houseduration = houseduration;
	}
	public String getHouseownertype() {
		return houseownertype;
	}
	public void setHouseownertype(String houseownertype) {
		this.houseownertype = houseownertype;
	}
	public String getHomemainsec() {
		return homemainsec;
	}
	public void setHomemainsec(String homemainsec) {
		this.homemainsec = homemainsec;
	}
	public String getFloorapartment() {
		return floorapartment;
	}
	public void setFloorapartment(String floorapartment) {
		this.floorapartment = floorapartment;
	}
	public String getHouseProtection() {
		return houseProtection;
	}
	public void setHouseProtection(String houseProtection) {
		this.houseProtection = houseProtection;
	}
	public String getHouseempty() {
		return houseempty;
	}
	public void setHouseempty(String houseempty) {
		this.houseempty = houseempty;
	}
	public String getObjectsinsured() {
		return objectsinsured;
	}
	public void setObjectsinsured(String objectsinsured) {
		this.objectsinsured = objectsinsured;
	}
	public int getObjectsvalue() {
		return objectsvalue;
	}
	public void setObjectsvalue(int objectsvalue) {
		this.objectsvalue = objectsvalue;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getGuarantee() {
		return guarantee;
	}
	public void setGuarantee(String guarantee) {
		this.guarantee = guarantee;
	}
	public String getEtatdemande() {
		return etatdemande;
	}
	public void setEtatdemande(String etatdemande) {
		this.etatdemande = etatdemande;
	}
	public int getUninhabited() {
		return uninhabited;
	}
	public void setUninhabited(int uninhabited) {
		this.uninhabited = uninhabited;
	}
	public int getSinisternmbr() {
		return sinisternmbr;
	}
	public void setSinisternmbr(int sinisternmbr) {
		this.sinisternmbr = sinisternmbr;
	}
	public HousingContractService getHousingContractService() {
		return HousingContractService;
	}
	public void setHousingContractService(HousingContractService housingContractService) {
		HousingContractService = housingContractService;
	}

	public float getPrime() {
		return prime;
	}

	public void setPrime(float prime) {
		this.prime = prime;
	}

	public float getPrime1() {
		return Prime1;
	}

	public void setPrime1(float prime1) {
		Prime1 = prime1;
	}

	public UserServiceImpl getUserServiceImpl() {
		return UserServiceImpl;
	}

	public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
		UserServiceImpl = userServiceImpl;
	}

	/*	public void displayEmploye(Employe empl) 
		{
			this.setPrenom(empl.getPrenom());
			this.setNom(empl.getNom());
			this.setIsActif(empl.getIsActif()); 
			this.setEmail(empl.getEmail());
			this.setRole(empl.getRole());
			this.setEmail(empl.getEmail());
			this.setPassword(empl.getPassword());
			this.setEmployeIdToBeUpdated(empl.getId());
		}

		public void updateEmploye()
		{
			employeService.updateEmploye(new Employe(employeIdToBeUpdated, nom, prenom, email, password, isActif, role));
		}

		public List<Employe> getEmployes() {
			employes = employeService.getAllEmployes(); 
			return employes;
		} 

		public void setEmployes(List<Employe> employes) {
			this.employes = employes;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Boolean getIsActif() {
			return isActif;
		}

		public void setIsActif(Boolean isActif) {
			this.isActif = isActif;
		}

		public Role getRole() {
			return role;
		}

		public void setRole(Role role) {
			this.role = role;
		}

		public EmployeService getEmployeService() {
			return employeService;
		}

		public void setEmployeService(EmployeService employeService) {
			this.employeService = employeService;
		}

		public Integer getEmployeIdToBeUpdated() {
			return employeIdToBeUpdated;
		}

		public void setEmployeIdToBeUpdated(Integer employeIdToBeUpdated) {
			this.employeIdToBeUpdated = employeIdToBeUpdated;
		}*/



}
