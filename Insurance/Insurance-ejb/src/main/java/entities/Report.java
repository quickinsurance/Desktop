package entities;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Report")
public class Report implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="Report_ID")
	private int report_id;
	@Column(name = "Date_Report")
	private Date date_report;
	@Column(name = "Description_Report", length=2000)
	private String description_report;
	
	@OneToOne
	private Accident Accident;
	
	@OneToOne(mappedBy="Report")
	private Sinister Sinister; 
	
	public Report(){}

	public int getReport_id() {
		return report_id;
	}

	public Date getDate_report() {
		return date_report;
	}

	public void setDate_report(Date date_report) {
		this.date_report = date_report;
	}

	public String getDescription_report() {
		return description_report;
	}

	public void setDescription_report(String description_report) {
		this.description_report = description_report;
	}

	public Accident getAccident() {
		return Accident;
	}

	public void setAccident(Accident accident) {
		Accident = accident;
	}

	public Sinister getSinister() {
		return Sinister;
	}

	public void setSinister(Sinister sinister) {
		Sinister = sinister;
	}

	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}

	
	
}
