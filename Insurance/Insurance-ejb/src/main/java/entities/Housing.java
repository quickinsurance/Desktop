package entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Housing")
public class Housing extends Contract implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "Addresse", nullable = false)
	private String address;
	@Column(name = "Type_Housing", nullable = false)
	private String type_housing;
	@Column(name = "Area", nullable = false)
	private String area;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Housing")
	private Set<Accident> Accidents;
	
	public Housing(){}
}
