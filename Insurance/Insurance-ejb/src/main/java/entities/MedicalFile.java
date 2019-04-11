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
@Table(name = "MedicalFile")
public class MedicalFile implements Serializable{
	public void setMedicalFile_id(int medicalFile_id) {
		MedicalFile_id = medicalFile_id;
	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="MedicalFile_ID")
	private int MedicalFile_id;
	@Column(name="Description",nullable = false) 
	private String Description;
	@Column(name="Bill",nullable = false) 
	private float bill;
	@Column(name="type")
	private String type;
	@Column(name="image")
	private String image;
	@Column(name="treated")
	private boolean treated;
	@Column(name="consultation_date")
	private Date consultation_date;
	@Column(name="total_refund")
	private float total_refund;
	
	

	public Date getConsultation_date() {
		return consultation_date;
	}

	public void setConsultation_date(Date consultation_date) {
		this.consultation_date = consultation_date;
	}

	public float getTotal_refund() {
		return total_refund;
	}

	public void setTotal_refund(float total_refund) {
		this.total_refund = total_refund;
	}

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

	@Override
	public String toString() {
		return "MedicalFile [MedicalFile_id=" + MedicalFile_id + ", Description=" + Description + ", bill=" + bill
				+ ", Health=" + Health + "]";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isTreated() {
		return treated;
	}

	public void setTreated(boolean treated) {
		this.treated = treated;
	}
	
	
}
