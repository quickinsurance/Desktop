package Entities;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin extends User implements Serializable {
    private static final long serialVersionUID = 1L;

@Column(name="Grade",nullable = false) 
private String grade;

@OneToMany(cascade = CascadeType.ALL, mappedBy="Admin")
private Set<Agencies> Agencies;

@OneToMany(cascade = CascadeType.ALL, mappedBy="Admin")
private Set<Actuality> Actualities;

public Admin(){}
public String getGrade() {
	return grade;
}

public void setGrade(String grade) {
	this.grade = grade;
}

}
