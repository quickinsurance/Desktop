package tn.esprit.timesheet.managedbeans;


import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entities.User;	
import services.impl.*;


@ManagedBean(name = "loginBean") 
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String login; 
	private String code; 
	private User User; 
	private Boolean loggedIn;

	@EJB
	UserServiceImpl UserServiceImpl; 

	public String doLogin()
	{
		String navigateTo = "null"; 
		User = UserServiceImpl.getUserByEmailAndPassword(login, code); 

		if (User != null && User.getRole() == "client") {
			navigateTo = "/pages/admin/welcome?faces-redirect=true";
			loggedIn = true; 
		}
		else 
		{
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));
		}
		return navigateTo; 
	}

	public String doLogout()
	{
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}
 
	public LoginBean() {} 
	
	public String getLogin() {return login;}
	public void setLogin(String login) {this.login = login;}
	public String getPassword() {return code;}
	public void setPassword(String password) {this.code = password;}
	public User getEmploye() {return User;}
	public void setEmploye(User employe) {this.User = employe;}
	public Boolean getLoggedIn() {return loggedIn;}
	public void setLoggedIn(Boolean loggedIn) {this.loggedIn = loggedIn;}

}
