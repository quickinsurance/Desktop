package Entities;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Expert")
public class Expert extends User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="Specialty",nullable = false) 
	private String specialty;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Expert")
	private Set<Accident> Accidents;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Expert")
	private Set<Report> Reports;
	
    public Expert(){}
	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public Set<Accident> getAccidents() {
		return Accidents;
	}
	public void setAccidents(Set<Accident> accidents) {
		Accidents = accidents;
	}
	
}
