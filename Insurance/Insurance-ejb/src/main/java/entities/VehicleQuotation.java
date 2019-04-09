package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "VehicleQuotation")
public class VehicleQuotation extends Quotation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="Mark") 
	private String mark;
	@Column(name="Power") 
	private int power;
	@Column(name="CirculationDate") 
	private Date circulationDate;
	
	@Column(name="PrimeQuotation") 
	private float primeQuotation;
	
	@Column(name="LostPoints") 
	private int lostPoints;
	
	@Column(name="SuspendedLicence") 
	private boolean suspendedLicence;
	
	@Column(name="SinistersNumber") 
	private int sinistersNumber;
	
	@Column(name="PropVehicle") 
	private boolean propVehicle;
	
	@Column(name="VehicleState") 
	private boolean VehicleState;
	
	@Column(name="VehicleEdit") 
	private boolean VehicleEdit;
	
	@Column(name="VehicleUsing") 
	private boolean VehicleUsing;
	
	@Column(name="KilometersNumber") 
	private double KilometersNumber;
	
	@Column(name="UsingFrequence") 
	private boolean usingFrequence;
	
	
	@Column(name="ParkingMode") 
	private String parkingMode;
	
	@Column(name="OptionVehicle")
	private String option_vehicle;
	
	@Column(name="QuotationReaction")
	private String QuotationReaction;

	@Column(name="Commentary")
	private String commentary;
	
	

	public VehicleQuotation(){}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public Date getCirculationDate() {
		return circulationDate;
	}

	public void setCirculationDate(Date circulationDate) {
		this.circulationDate = circulationDate;
	}

	public String getOption_vehicle() {
		return option_vehicle;
	}

	public void setOption_vehicle(String option_vehicle) {
		this.option_vehicle = option_vehicle;
	}

	public float getPrimeQuotation() {
		return primeQuotation;
	}

	public void setPrimeQuotation(float primeQuotation) {
		this.primeQuotation = primeQuotation;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getLostPoints() {
		return lostPoints;
	}

	public void setLostPoints(int lostPoints) {
		this.lostPoints = lostPoints;
	}

	public boolean isSuspendedLicence() {
		return suspendedLicence;
	}

	public void setSuspendedLicence(boolean suspendedLicence) {
		this.suspendedLicence = suspendedLicence;
	}

	public int getSinistersNumber() {
		return sinistersNumber;
	}

	public void setSinistersNumber(int sinistersNumber) {
		this.sinistersNumber = sinistersNumber;
	}

	public boolean isPropVehicle() {
		return propVehicle;
	}

	public void setPropVehicle(boolean propVehicle) {
		this.propVehicle = propVehicle;
	}

	public boolean isVehicleState() {
		return VehicleState;
	}

	public void setVehicleState(boolean vehicleState) {
		VehicleState = vehicleState;
	}

	public boolean isVehicleEdit() {
		return VehicleEdit;
	}

	public void setVehicleEdit(boolean vehicleEdit) {
		VehicleEdit = vehicleEdit;
	}

	public boolean isVehicleUsing() {
		return VehicleUsing;
	}

	public void setVehicleUsing(boolean vehicleUsing) {
		VehicleUsing = vehicleUsing;
	}

	public double getKilometersNumber() {
		return KilometersNumber;
	}

	public void setKilometersNumber(double kilometersNumber) {
		KilometersNumber = kilometersNumber;
	}

	public boolean isUsingFrequence() {
		return usingFrequence;
	}

	public void setUsingFrequence(boolean usingFrequence) {
		this.usingFrequence = usingFrequence;
	}

	public String getParkingMode() {
		return parkingMode;
	}

	public void setParkingMode(String parkingMode) {
		this.parkingMode = parkingMode;
	}

	public String getQuotationReaction() {
		return QuotationReaction;
	}

	public void setQuotationReaction(String quotationReaction) {
		QuotationReaction = quotationReaction;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}
}
