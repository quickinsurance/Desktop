package entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "EquipmentQuote")
public class EquipmentQuote extends Quotation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double commision;
	private double premium;
	
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="EquipmentQuote")
	private Set<Property> Property;
	
	public EquipmentQuote() {
		super();
	}

	public double getCommision() {
		return commision;
	}

	public void setCommision(double commision) {
		this.commision = commision;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	public Set<Property> getProperty() {
		return Property;
	}

	public void setProperty(Set<Property> property) {
		Property = property;
	}

	
}
	
