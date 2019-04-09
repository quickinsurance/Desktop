package entities;

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
	public Set<Contract> getContracts() {
		return Contracts;
	}
	public void setContracts(Set<Contract> contracts) {
		Contracts = contracts;
	}
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
	@Override
	public String toString() {
		return "Client [job=" + job + ", address=" + address + ", RIB_Number=" + RIB_Number + ", Contracts=" + Contracts
				+ ", getNotifications()=" + getNotifications() + ", getClaims()=" + getClaims() + ", getQuotations()="
				+ getQuotations() + ", getCin()=" + getCin() + ", getId()=" + getId() + ", getFirstName()="
				+ getFirstName() + ", getLastName()=" + getLastName() + ", getEmail()=" + getEmail() + ", getPhone()="
				+ getPhone() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
}
