package entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Financier")
public class Financier extends User implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name="Service",nullable = false) 
	private String service;
	@Column(name="Responsability",nullable = false) 
	private String responsability;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Financier")
	private Set<Parameters> Parameters;
	
	public Financier(){}
	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getResponsability() {
		return responsability;
	}

	public void setResponsability(String responsability) {
		this.responsability = responsability;
	}
	
}
