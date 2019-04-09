package entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Housing")
public class Housing extends Contract implements Serializable{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	@Column(name = "Addresse", nullable = false)
	private String address;
	@Column(name = "Type_Housing", nullable = false)
	private String type_housing;
	@Column(name = "Area", nullable = false)
	private String area;
	@Column(name = "CodePostal", nullable = false)
	private int CodePostal;
	@Column(name = "housevalue", nullable = true)
	private int housevalue;
	@Column(name = "garage", nullable = false)
	private String garage;
	@Column(name = "houseduration", nullable = false)// combien d'année la maison a eté construite ? 
	private String houseduration;
	@Column(name = "houseownertype", nullable = false)  // owner 
	private String houseownertype;
	@Column(name = "homemainsec", nullable = false)
	private String homemainsec;
	@Column(name = "Floorapartment", nullable = true)
	private String Floorapartment;
	@Column(name = "houseProtection", nullable = true)
	private String houseProtection;
	@Column(name = "houseempty", nullable = true)
	private String houseempty;
	@Column(name = "objectsinsured", nullable = true)
	private String objectsinsured;

	
	
	
	
	@Override
	public String toString() {
		return "Housing [address=" + address + ", type_housing=" + type_housing + ", area=" + area + ", CodePostal="
				+ CodePostal + ", housevalue=" + housevalue + ", garage=" + garage + ", houseduration=" + houseduration
				+ ", houseownertype=" + houseownertype + ", homemainsec=" + homemainsec + ", Floorapartment="
				+ Floorapartment + ", houseProtection=" + houseProtection + ", houseempty=" + houseempty
				+ ", objectsinsured=" + objectsinsured + ", objectsvalue=" + objectsvalue + ", image=" + image
				+ ", guarantee=" + guarantee + ", etatdemande=" + etatdemande + ", uninhabited=" + uninhabited
				+ ", sinisternmbr=" + sinisternmbr + "]";
	}

	public String getGuarantee() {
		return guarantee;
	}

	public void setGuarantee(String guarantee) {
		this.guarantee = guarantee;
	}


	@Column(name = "objectsvalue",nullable = true)
	private int objectsvalue;
	@Column(name = "Image1",nullable = true)
	private String image;
	@Column(name = "Guarantee",nullable = true)
	private String guarantee;
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	@Column(name = "etatdemande",nullable = true)
	private String etatdemande;
	
	public String getEtatdemande() {
		return etatdemande;
	}

	public void setEtatdemande(String etatdemande) {
		this.etatdemande = etatdemande;
	}


	@Column(name = "uninhabited", nullable = true) //days par year house is inhabited in 
	private int uninhabited;
	
	@Column(name = "sinisternmbr", nullable = false)
	private int sinisternmbr;
	
	
	public enum houseownertype {
		tenant, owner, non_occupying_owner
	}
	public enum Floorapartment {
		 main_home, second_home
	}
	public enum houseProtection {
		alarme, armored_doo, smoke_detector, video_surveillance, other
	}
	
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Housing")
	private Set<Accident> Accidents;
	
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
		return CodePostal;
	}

	public void setCodePostal(int codePostal) {
		CodePostal = codePostal;
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
		return Floorapartment;
	}

	public void setFloorapartment(String floorapartment) {
		Floorapartment = floorapartment;
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

	public Set<Accident> getAccidents() {
		return Accidents;
	}

	public void setAccidents(Set<Accident> accidents) {
		Accidents = accidents;
	}
	

	public Housing(){
		super();
	}
}
