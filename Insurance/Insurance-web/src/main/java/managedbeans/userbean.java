package managedbeans;


import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entities.User;
import entities.Client;
import services.impl.UserServiceImpl;


@ManagedBean(name = "userbean") 
@SessionScoped
public class userbean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String mail; 
	private String password; 
	private String Firstname; 
	private String lastname; 
	private String adress; 
	private int cin; 
	private int phone; 
	private String rib; 
	private Boolean loggedIn;

	@EJB
	services.impl.HousingContractService HousingContractService; 

	public void userregister()
	{          Client c = new Client();
    
    c.setAddress(adress);
    c.setEmail(mail);
    c.setFirstName(Firstname);
    c.setLastName(lastname);
    c.setJob("client");
    c.setPhone(phone);
    c.setRIB_Number(rib);
    c.setCin(123456);

    System.out.println(c.toString());
    HousingContractService.addclient(c);
    
	}

	public String doLogout()
	{
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}
 
	public userbean() {} 
/*	public Client returnClient(){
		return UserServiceImpl.findClientById(23);
	}*/

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getRib() {
		return rib;
	}

	public void setRib(String rib) {
		this.rib = rib;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public services.impl.HousingContractService getHousingContractService() {
		return HousingContractService;
	}

	public void setHousingContractService(services.impl.HousingContractService housingContractService) {
		HousingContractService = housingContractService;
	}


}
