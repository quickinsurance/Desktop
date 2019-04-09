package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Equipment")
public class Equipment extends Contract implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "Name_equipment", nullable = false)
	private String name_equipment;
	@Column(name = "Condition_equipment", nullable = false)
	private String condition_equipment;
	@Column(name = "Description_equipment", nullable = false)
	private String description_equipment;
	
	public Equipment(){}
	
	public String getName_equipment() {
		return name_equipment;
	}
	public void setName_equipment(String name_equipment) {
		this.name_equipment = name_equipment;
	}
	public String getCondition_equipment() {
		return condition_equipment;
	}
	public void setCondition_equipment(String condition_equipment) {
		this.condition_equipment = condition_equipment;
	}
	public String getDescription_equipment() {
		return description_equipment;
	}
	public void setDescription_equipment(String description_equipment) {
		this.description_equipment = description_equipment;
	}
	
	
}
