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
@Table(name = "Parameters")
public class Parameters implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="Parameter_ID")
	private int parameter_id;
	@Column(name="Name_parameter",nullable = false) 
	private String name_parameter;
	@Column(name="value",nullable = false) 
	private int value;
	@ManyToOne
	Financier Financier;
	public Parameters(){} 
	public int getParameter_id() {
		return parameter_id;
	}
	public String getName_parameter() {
		return name_parameter;
	}
	public void setName_parameter(String name_parameter) {
		this.name_parameter = name_parameter;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Financier getFinancier() {
		return Financier;
	}
	public void setFinancier(Financier financier) {
		Financier = financier;
	}
	
}
