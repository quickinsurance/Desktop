package managedbeans;


import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entities.User;
import entities.Client;
import services.impl.UserServiceImpl;


@ManagedBean(name = "loginBean") 
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static LoginBean instance = null;
	private String login; 
	private String password; 
	private User User; 
	private Boolean loggedIn;

	@EJB
	UserServiceImpl UserServiceImpl; 

	public String doLogin()
	{
		String navigateTo = "null"; 
		getInstance().User = UserServiceImpl.getUserByEmailAndPassword(login, password); 

		if (getInstance().User != null /*&& User.getRole() == "Agent"*/) {
			System.out.println(getInstance().User.getCode());
			navigateTo = "/Template?faces-redirect=true";
			getInstance().loggedIn = true;
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
	public Client returnClient(){
		return UserServiceImpl.findClientById(23);
	}
	public String getLogin() {return login;}
	public void setLogin(String login) {this.login = login;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public User getUser() {return User;}
	public void setUser(User User) {this.User = User;}
	public Boolean getLoggedIn() {return loggedIn;}
	public void setLoggedIn(Boolean loggedIn) {this.loggedIn = loggedIn;}
	
	public static LoginBean getInstance() 
    { 
        if (instance == null) 
        	instance = new LoginBean(); 
  
        return instance; 
    }

	public static void setInstance(LoginBean instance) {
		LoginBean.instance = instance;
	}

	public UserServiceImpl getUserServiceImpl() {
		return UserServiceImpl;
	}

	public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
		UserServiceImpl = userServiceImpl;
	}

}
