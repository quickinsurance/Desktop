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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import entities.Contract.type_contract;



@Entity
@Table(name = "Quotation")
@Inheritance(strategy = InheritanceType.JOINED)
public class Quotation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Quotation_ID")
	private int quotation_id;
	@Column(name = "Creation_date", nullable = false)
	private Date creation_date;
	@Enumerated(EnumType.STRING)
	private type_contract type_contract;
	



	@ManyToOne
	User User;

	public Quotation() {
	}

	public int getQuotation_id() {
		return quotation_id;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public User getUser() {
		return User;
	}

	public void setUser(User user) {
		User = user;
	}

	public type_contract getType_contract() {
		return type_contract;
	}

	public void setType_contract(type_contract type_contract) {
		this.type_contract = type_contract;
	}


	public void setQuotation_id(int quotation_id) {
		this.quotation_id = quotation_id;
	}
	

}
