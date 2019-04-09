package entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Health")
public class Health extends Contract implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "Illness", nullable = false)
	private String illness;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Health")
	private Set<MedicalFile> MedicalFiles;
	
	public Health(){}

	public String getIllness() {
		return illness;
	}

	public void setIllness(String illness) {
		this.illness = illness;
	}

	public Set<MedicalFile> getMedicalFiles() {
		return MedicalFiles;
	}

	public void setMedicalFiles(Set<MedicalFile> medicalFiles) {
		MedicalFiles = medicalFiles;
	}
	
}
