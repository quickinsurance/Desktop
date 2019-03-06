package Entities;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	@Column(name = "Matriculation", nullable = false)
	private String matriculation;
	@Column(name = "Model", nullable = false)
	private String model;
	@Column(name = "Date_Of_Circulation", nullable = false)
	private Date date_of_circulation;
	
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

	public String getMatriculation() {
		return matriculation;
	}

	public void setMatriculation(String matriculation) {
		this.matriculation = matriculation;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Date getDate_of_circulation() {
		return date_of_circulation;
	}

	public void setDate_of_circulation(Date date_of_circulation) {
		this.date_of_circulation = date_of_circulation;
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
	
	
}
