package entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Guarantee")
public class Guarantee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="Guarantee_ID")
	private int guarantee_id;
	@Column(name="Code_Guarantee",nullable = false) 
	private int code_guarantee;
	@Column(name="Amount_Franchise",nullable = false) 
	private float amount_franchise;
	@Column(name="Amount_Limit",nullable = false) 
	private float amount_limit;
	
	@ManyToOne
	Contract Contract;
	
	public Guarantee(){}

	public int getGuarantee_id() {
		return guarantee_id;
	}

	public int getCode_guarantee() {
		return code_guarantee;
	}

	public void setCode_guarantee(int code_guarantee) {
		this.code_guarantee = code_guarantee;
	}

	public float getAmount_franchise() {
		return amount_franchise;
	}

	public void setAmount_franchise(float amount_franchise) {
		this.amount_franchise = amount_franchise;
	}

	public float getAmount_limit() {
		return amount_limit;
	}

	public void setAmount_limit(float amount_limit) {
		this.amount_limit = amount_limit;
	}

	public Contract getContract() {
		return Contract;
	}

	public void setContract(Contract contract) {
		Contract = contract;
	}
	
}
