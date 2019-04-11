package entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Retreat")
public class Retreat extends Contract implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "retreatDate")
	private Date retreatDate;
	@Column(name = "rescission")
	private boolean rescission;
	public Date getRetreatDate() {
		return retreatDate;
	}
	public void setRetreatDate(Date retreatDate) {
		this.retreatDate = retreatDate;
	}
	public boolean isRescission() {
		return rescission;
	}
	public void setRescission(boolean rescission) {
		this.rescission = rescission;
	}

}
