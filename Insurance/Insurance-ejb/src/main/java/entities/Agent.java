package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Agent")
public class Agent extends User implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Column(name="Agence",nullable = false) 
private String agence;
@Column(name="Assignment_date",nullable = false) 
private Date assignment_date;

@OneToMany(cascade = CascadeType.ALL, mappedBy="Agent")
private Set<Contract> Contracts;

public Agent(){}
public String getAgence() {
	return agence;
}
public void setAgence(String agence) {
	this.agence = agence;
}
public Date getAssignment_date() {
	return assignment_date;
}
public void setAssignment_date(Date assignment_date) {
	this.assignment_date = assignment_date;
}


}
