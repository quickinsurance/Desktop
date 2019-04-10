package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import java.sql.Date;

@Entity
@Table(name = "SinisterEquipment")
public class SinisterEquipment implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="sinister_ID")
	private int id;
	@ManyToOne
	ContractProperty ContractProperty;
	private float bill;
	private String validation;
	private double payement;
	private Date date_siniter;
	@Lob
	@Column(name="doc2") 
	private byte[] document;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private cause cause;
	public  enum cause {broken("broken"),
		theft("theft"),;
		private cause (String name){} 
	}
	public SinisterEquipment() {
		super();
	}
	
	public String getValidation() {
		return validation;
	}

	public void setValidation(String validation) {
		this.validation = validation;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getBill() {
		return bill;
	}
	public void setBill(float bill) {
		this.bill = bill;
	}
	public Date getDate_siniter() {
		return date_siniter;
	}
	public void setDate_siniter(Date date_siniter) {
		this.date_siniter = date_siniter;
	}
	public cause getCause() {
		return cause;
	}
	public void setCause(cause cause) {
		this.cause = cause;
	}

	public ContractProperty getContractProperty() {
		return ContractProperty;
	}

	public void setContractProperty(ContractProperty contractProperty) {
		ContractProperty = contractProperty;
	}

	public byte[] getDocument() {
		return document;
	}

	public void setDocument(byte[] document) {
		this.document = document;
	}

	public double getPayement() {
		return payement;
	}

	public void setPayement(double payement) {
		this.payement = payement;
	}
	
	
}
