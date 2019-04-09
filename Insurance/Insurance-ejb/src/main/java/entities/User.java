package entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Table(name = "User")
@Inheritance(strategy = InheritanceType.JOINED)

public class User implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_ID")
	private int id;
	@Column(name = "first_name", nullable = false)
	private String firstName;
	@Column(name = "last_name", nullable = false)
	private String lastName;
	@Column(name = "Email")
	private String email;
	@Column(name = "Phone")
	private int phone;
	@Column(name = "salary")
	private float salary;
	@Column(name = "BirthDate")
	private Date birthDate;
	@Column(name = "family_situation")
	private String family_situation;
	@Column(name="Gender")
	private boolean gender;
	@Column(name = "Cin", nullable = false)
	private int cin;
	
	
	
	@Column(name="Role")
	private String role;
	@Column(name="Note")
	private int note;
	@Column(name="Photo")
	private String photo;
	
	@Column(name="Code")
	private String code;


	@OneToMany(cascade = CascadeType.ALL, mappedBy = "User")
	private Set<Notification> Notifications;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "User")
	private Set<Claim> Claims;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "User")
	private Set<Quotation> Quotations;

	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getFamily_situation() {
		return family_situation;
	}

	public void setFamily_situation(String family_situation) {
		this.family_situation = family_situation;
	}

	

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public Set<Notification> getNotifications() {
		return Notifications;
	}

	public void setNotifications(Set<Notification> notifications) {
		Notifications = notifications;
	}

	public Set<Claim> getClaims() {
		return Claims;
	}

	public void setClaims(Set<Claim> claims) {
		Claims = claims;
	}

	public Set<Quotation> getQuotations() {
		return Quotations;
	}

	public void setQuotations(Set<Quotation> quotations) {
		Quotations = quotations;
	}
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
	


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	

}