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
@Table(name = "Vehicle")
public class Vehicle extends Contract implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "Matriculation", nullable = false)
	private String matriculation;
	@Column(name = "Mark")
	private String mark;
	@Column(name = "VehicleOption")
	private String vehicleOption;
	@Column(name = "Date_Of_Circulation")
	private Date date_of_circulation;
	@Column(name = "VehicleGroup")
	private String vehicleGroup;
	
	public Vehicle(){}
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Vehicle")
	private Set<Accident> Accidents;
	public String getMatriculation() {
		return matriculation;
	}

	public void setMatriculation(String matriculation) {
		this.matriculation = matriculation;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getVehicleOption() {
		return vehicleOption;
	}

	public void setVehicleOption(String vehicleOption) {
		this.vehicleOption = vehicleOption;
	}

	public Date getDate_of_circulation() {
		return date_of_circulation;
	}

	public void setDate_of_circulation(Date date_of_circulation) {
		this.date_of_circulation = date_of_circulation;
	}

	public String getVehicleGroup() {
		return vehicleGroup;
	}

	public void setVehicleGroup(String vehicleGroup) {
		this.vehicleGroup = vehicleGroup;
	}
	
}
