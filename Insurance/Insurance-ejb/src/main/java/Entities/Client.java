package Entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Client")
public class Client extends User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "Job", nullable = false)
	private String job;
	@Column(name = "Adress", nullable = false)
	private String address;
	@Column(name = "RIB_Number", nullable = false)
	private String RIB_Number;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Client")
	private Set<Contract> Contracts;
	
	public Client(){}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRIB_Number() {
		return RIB_Number;
	}
	public void setRIB_Number(String rIB_Number) {
		RIB_Number = rIB_Number;
	}
	
}
