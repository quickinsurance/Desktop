package ManagedBeans;

import java.io.Serializable;
import java.sql.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import services.impl.UserServiceImpl;
import services.impl.ServiceEquipmentQuote;
import services.impl.ServiceSinisterEquipment;
import entities.EquipmentQuote;
import entities.Property;
import entities.Equipment;
import entities.Contract;
import entities.User;
import entities.Contract.type_contract;
import entities.Property.item;
import entities.Property.marque;
import entities.Property.option_quote;
import entities.Property.type_item;


@ManagedBean(name = "equipmentbean")
@ViewScoped
public class EquipmentBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String email;
	private int phone;
	private int cin;
	private String job;
	private String address;
	private String RIB_Number;
	private Date creation_date;
	private type_contract type_contract;
	private double commision;
	private double premium;
	private String condition_equipment;
	private float prime;
	private type_item type_item;
	private item item;
	private marque marque;
	private String model;
	private Double value;
	private option_quote option_quote;
	private String Validation;

	@EJB
	UserServiceImpl UserServiceImpl;	
	@EJB
	ServiceEquipmentQuote ServiceEquipmentQuote;
	@EJB
	ServiceSinisterEquipment ServiceSinisterEquipment;
	
	public void addQuote() {
		User u=new User();
		u.setEmail(email);
		u.setFirstName(firstName);
		u.setLastName(lastName);
		u.setPhone(phone);
		u.setCin(cin);
		UserServiceImpl.addUser(u);
		User a = UserServiceImpl.getUserByCIN(cin);
		Property quote = new Property(marque);
		EquipmentQuote q = new EquipmentQuote();
		q.setType_contract(q.getType_contract().equipment);
		q.setCreation_date(new Date(System.currentTimeMillis()));
		quote.setEquipmentQuote(q);
		q.setUser(a);
		this.addQuote1(quote);
		this.CalculatePrimeOneProperty(quote,q);
		int quote_id = ServiceEquipmentQuote.addEquipmentQuote(quote);
		System.out.println(quote_id);
	}
	
	public void addQuote1(Property quote) {
		
		quote.setType_item(quote.getType_item().electronic);
		
		quote.setOption_quote(option_quote);
		quote.setItem(item);
	quote.setModel(model);
	quote.setValue(value);
	quote.setCondition_equipment(condition_equipment);

}
	public void CalculatePrimeOneProperty(Property p,EquipmentQuote q) 
	{
		
		int x=ServiceSinisterEquipment.findNumberSinister(p);
		if (x==0){ x = (int)(Math.random() * 50 + 1);
		int nbrsinistre=x;
		}
		double y=ServiceSinisterEquipment.MeanSinisterEquipment(p);
		if (y==0){ y=140;}
		float xx=x;
		float nrisque=500f;
		if (p.getItem().equals("Camera") || p.getItem().equals("Games")
				|| p.getItem().equals("MobilePhone") || p.getItem().equals("EReader")) 
		{nrisque=250f;}
		double frequence=x/nrisque;
		double tauxPrime=frequence*y;
		double Prime=tauxPrime*p.getValue()/100;
		System.out.println(tauxPrime+"/////"+Prime);
		q.setCommision((float)(Prime*0.09+5.9));
		q.setPremium((float)(Prime*1.09+5.9));
		p.setPrime((float)(Prime*1.09+5.9));
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
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


	public double getCommision() {
		return commision;
	}


	public void setCommision(double commision) {
		this.commision = commision;
	}


	public double getPremium() {
		return premium;
	}


	public void setPremium(double premium) {
		this.premium = premium;
	}


	public String getCondition_equipment() {
		return condition_equipment;
	}


	public void setCondition_equipment(String condition_equipment) {
		this.condition_equipment = condition_equipment;
	}


	public float getPrime() {
		return prime;
	}


	public void setPrime(float prime) {
		this.prime = prime;
	}


	public type_item getType_item() {
		return type_item;
	}


	public void setType_item(type_item type_item) {
		this.type_item = type_item;
	}


	public item getItem() {
		return item;
	}


	public void setItem(item item) {
		this.item = item;
	}


	public marque getMarque() {
		return marque;
	}

	public void setMarque(marque marque) {
		this.marque = marque;
	}

	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public Double getValue() {
		return value;
	}


	public void setValue(Double value) {
		this.value = value;
	}


	public option_quote getOption_quote() {
		return option_quote;
	}


	public void setOption_quote(option_quote option_quote) {
		this.option_quote = option_quote;
	}
	
}
