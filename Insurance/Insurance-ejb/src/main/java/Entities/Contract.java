package Entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;


import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name = "Contract")
@Inheritance(strategy = InheritanceType.JOINED)
public class Contract implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Conract_ID")
	private int contract_id;
	@Column(name = "Date_creation", nullable = false)
	private Date date_creation;
	@Column(name = "Date_end", nullable = false)
	private Date date_end;
	@Column(name = "Commission", nullable = false)
	private float commission;
	@Column(name = "Prime", nullable = false)
	private float prime;
	// @Column(name="Type_Contract",nullable = false)
	@Enumerated(EnumType.STRING)
	private type_contract type_contract;

	public enum type_contract {
		Vehicle, housing, health, equipment
	}

	@ManyToOne
	Client Client;

	@ManyToOne
	Agent Agent;

	@ManyToOne
	Category Category;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Contract")
	private Set<Guarantee> Guarantees;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Contract")
	private Set<Transaction> Transactions;

	public Contract() {
	}

	public int getContract_id() {
		return contract_id;
	}

	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	public Date getDate_end() {
		return date_end;
	}

	public void setDate_end(Date date_end) {
		this.date_end = date_end;
	}

	public float getCommission() {
		return commission;
	}

	public void setCommission(float commission) {
		this.commission = commission;
	}

	public float getPrime() {
		return prime;
	}

	public void setPrime(float prime) {
		this.prime = prime;
	}

	public type_contract getType_contract() {
		return type_contract;
	}

	public void setType_contract(type_contract type_contract) {
		this.type_contract = type_contract;
	}

}
