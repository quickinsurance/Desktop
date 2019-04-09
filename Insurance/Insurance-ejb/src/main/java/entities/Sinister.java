package entities;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Sinister")
public class Sinister implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="Sinister_ID")
	private int sinister_id;
	@Column(name = "Description", length=2000)
	private String description;
	@Column(name="refund")
	private float refund;
	
	@OneToOne
	private Report Report; 
	
	public Sinister(){}

	public int getSinister_id() {
		return sinister_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getRefund() {
		return refund;
	}

	public void setRefund(float refund) {
		this.refund = refund;
	}

	public Report getReport() {
		return Report;
	}

	public void setReport(Report report) {
		Report = report;
	}

	public void setSinister_id(int sinister_id) {
		this.sinister_id = sinister_id;
	}
	
	
}
