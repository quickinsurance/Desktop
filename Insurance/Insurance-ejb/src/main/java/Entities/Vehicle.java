package Entities;
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
	@Column(name = "Model", nullable = false)
	private String model;
	@Column(name = "Date_Of_Circulation", nullable = false)
	private Date date_of_circulation;
	public Vehicle(){}
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Vehicle")
	private Set<Accident> Accidents;
}
