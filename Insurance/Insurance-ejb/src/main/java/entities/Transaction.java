package entities;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Transaction")
public class Transaction implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="Transaction_ID")
	private int transaction_id;
	@Column(name="Type_Transaction",nullable = false) 
	private String type_transaction;
	@Column(name="Date_Transaction",nullable = false) 
	private Date date_transaction;
	@Column(name="Amount",nullable = false) 
	private float amount;
	
	@ManyToOne
	Contract Contract;
	
}
