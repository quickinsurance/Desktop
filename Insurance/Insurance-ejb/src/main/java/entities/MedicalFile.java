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
@Table(name = "MedicalFile")
public class MedicalFile implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="MedicalFile_ID")
	private int MedicalFile_id;
	@Column(name="Description",nullable = false) 
	private String Description;
	@Column(name="Bill",nullable = false) 
	private float bill;
	
	@ManyToOne
	Health Health;
	
	public MedicalFile(){}

	public int getMedicalFile_id() {
		return MedicalFile_id;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public float getBill() {
		return bill;
	}

	public void setBill(float bill) {
		this.bill = bill;
	}

	public Health getHealth() {
		return Health;
	}

	public void setHealth(Health health) {
		Health = health;
	}
	
	
}
