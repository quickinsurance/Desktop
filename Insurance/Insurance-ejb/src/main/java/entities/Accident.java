package entities;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import entities.Contract.type_contract;

@Entity
@Table(name = "Accident")
public class Accident implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="Accident_ID")
	private int accident_id;
	@Column(name = "Date_Of_Accident")
	private Date date_of_Accident;
	@Column(name="treated")
	private boolean treated;
	@Enumerated(EnumType.STRING)
	private type_contract type_contract;
	@Column(name="expert_opinion ")
	private String expert_opinion;
	@Column(name="Description", length=2000)
	private String description;
	@Column(name="expert_Refund")
	private float expert_refund;
	@Column(name="expert_traited")
	private boolean expert_traited;
	@Column(name="sinister_traited")
	private boolean sinister_traited;
	

	@OneToOne(mappedBy="Accident")
	private Report Report;
	
	
	@ManyToOne
	Housing Housing;
	
	@ManyToOne
	Vehicle Vehicle;
	
	@ManyToOne
	Expert Expert;
	
	public Accident(){}

	public int getAccident_id() {
		return accident_id;
	}

	

	public boolean isSinister_traited() {
		return sinister_traited;
	}

	public void setSinister_traited(boolean sinister_traited) {
		this.sinister_traited = sinister_traited;
	}

	public Report getReport() {
		return Report;
	}

	public void setReport(Report report) {
		Report = report;
	}

	public Housing getHousing() {
		return Housing;
	}

	public void setHousing(Housing housing) {
		Housing = housing;
	}

	public Vehicle getVehicle() {
		return Vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		Vehicle = vehicle;
	}

	public Expert getExpert() {
		return Expert;
	}

	public void setExpert(Expert expert) {
		Expert = expert;
	}

	public Date getDate_of_Accident() {
		return date_of_Accident;
	}

	public void setDate_of_Accident(Date date_of_Accident) {
		this.date_of_Accident = date_of_Accident;
	}

	public boolean isTreated() {
		return treated;
	}

	public void setTreated(boolean treated) {
		this.treated = treated;
	}

	public type_contract getType_contract() {
		return type_contract;
	}

	public void setType_contract(type_contract type_contract) {
		this.type_contract = type_contract;
	}

	public void setAccident_id(int accident_id) {
		this.accident_id = accident_id;
	}

	public String getExpert_opinion() {
		return expert_opinion;
	}

	public void setExpert_opinion(String expert_opinion) {
		this.expert_opinion = expert_opinion;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getExpert_refund() {
		return expert_refund;
	}

	public void setExpert_refund(float expert_refund) {
		this.expert_refund = expert_refund;
	}

	public boolean isExpert_traited() {
		return expert_traited;
	}

	public void setExpert_traited(boolean expert_traited) {
		this.expert_traited = expert_traited;
	}
	
	
}
