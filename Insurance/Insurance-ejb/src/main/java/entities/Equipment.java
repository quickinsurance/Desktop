package entities;

import java.io.Serializable;
import java.util.Set;
import entities.ContractProperty;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Equipment")
public class Equipment extends Contract implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Validation;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Equipment")
	private Set<ContractProperty> ContractProperty;

	public Equipment() {
		super();
	}


	public String getValidation() {
		return Validation;
	}




	public void setValidation(String validation) {
		Validation = validation;
	}




	public Set<ContractProperty> getContractProperty() {
		return ContractProperty;
	}

	public void setContractProperty(Set<ContractProperty> contractProperty) {
		ContractProperty = contractProperty;
	}
	
	
}
