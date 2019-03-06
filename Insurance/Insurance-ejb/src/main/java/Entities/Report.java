package Entities;

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
	@Column(name = "Date_Report", nullable = false)
	private Date date_report;
	@Column(name = "Description_Report", nullable = false)
	private String description_report;
	
	@ManyToOne
	Expert Expert;
	
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

	public Expert getExpert() {
		return Expert;
	}

	public void setExpert(Expert expert) {
		Expert = expert;
	}
	
}
