package entities;

import java.io.Serializable;
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
@Table(name="User")
@Inheritance(strategy = InheritanceType.JOINED)

public class User implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
@Id
@GeneratedValue( strategy = GenerationType.IDENTITY )
@Column(name="User_ID")
private int id;
@Column(name="first_name",nullable = false) 
private String firstName;
@Column(name="last_name",nullable = false)
private String lastName;
@Column(name="Email",nullable = false)
private String email;
public int getCin() {
	return cin;
}
public void setCin(int cin) {
	this.cin = cin;
}
@Column(name="Phone",nullable = false,unique=true,length=8)
private int phone;
@Column(name="Cin",nullable = true,unique=true,length=8)
private int cin;

@OneToMany(cascade = CascadeType.ALL, mappedBy="User")
private Set<Notification> Notifications;

@OneToMany(cascade = CascadeType.ALL, mappedBy="User")
private Set<Claim> Claims;

@OneToMany(cascade = CascadeType.ALL, mappedBy="User")
private Set<Quotation> Quotations;

public User() {}
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

}