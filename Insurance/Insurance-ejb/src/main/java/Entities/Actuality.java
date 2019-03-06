package Entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Actuality")
public class Actuality  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="Actuality_ID")
	private int actuality_id;
	@Column(name="Title",nullable = false) 
	private String title;
	@Column(name="Description",nullable = false) 
	private String description;
	@Column(name="Picture",nullable = false) 
	private String picture;
	@ManyToOne
	Admin Admin;
	public Actuality(){}
	public int getActuality_id() {
		return actuality_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Admin getAdmin() {
		return Admin;
	}
	public void setAdmin(Admin admin) {
		Admin = admin;
	}
	
}
