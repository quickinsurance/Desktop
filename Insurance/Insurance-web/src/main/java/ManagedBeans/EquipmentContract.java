package ManagedBeans;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Contract.type_contract;
import entities.ContractProperty.item;
import entities.ContractProperty.marque;
import entities.ContractProperty.option_contract;
import entities.ContractProperty.type_item;
import services.impl.ServiceEquiment;
import services.impl.UserServiceImpl;
import entities.ContractProperty;
import entities.Agent;
import entities.Category;
import entities.Client;
import entities.Contract;
import entities.Equipment;
import entities.User;

import javax.faces.context.FacesContext;

@ManagedBean(name = "equipmentcontract")
@SessionScoped
public class EquipmentContract implements Serializable{
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String email;
	private int phone;
	private int cin;
	private String job;
	private String address;
	private String RIB_Number;
	private Date creation_date;
	private type_contract type_contract;
	private double commision;
	private double premium;
	private String condition_equipment;
	private float prime;
	private type_item type_item;
	private item item;
	private marque marque;
	private String model;
	private Double value;
	private int v;
	private option_contract option_contract;
	private String Validation;
	private int duration;
	private Date date_end;
	private Contract contract;
	private String agentName;
	private String agentpic;
	private User u;
	List<ContractProperty> prop;
	private String login;
	private String password;
	private Boolean loggedIn;
	private List<Contract> cat;
	private List<Client> clients;
	@EJB
	ServiceEquiment ServiceEquiment;
	@EJB
	UserServiceImpl UserServiceImpl;	
	
	public String doLogin() {
		String navigateTo = "null";
		u = UserServiceImpl.getEmployeByEmailAndPassword(login, password);
		if (u != null  ) {
			this.getContract(u.getId());
			navigateTo = "EquipmentContract?faces-redirect=true";
			loggedIn = true;
		} else {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));
		}
		return navigateTo;
	}
	
	public Contract getContract( int id) {
		Contract contracts = ServiceEquiment.findContractByClient(id);
		creation_date=contracts.getDate_creation();
		this.duration=contracts.getDate_end().getYear()-contracts.getDate_creation().getYear();
		this.prime=contracts.getPrime();
		prop = ServiceEquiment.findCProperty(contracts.getContract_id());
		double sum=0;
		for (int i=0;i<prop.size();i++)
		{sum=sum+prop.get(i).getValue();}
		this.value=sum;
		v=(int)sum;
		Agent g=UserServiceImpl.findAgentById(contracts.getAgent().getId());
		agentName=g.getFirstName()+"  "+g.getLastName();
		agentpic="img/"+g.getPhoto();
		cat=ServiceEquiment.findByCategory(contracts.getCategory().getCategory_id(),id);
		clients=new ArrayList<>();
		for (int i=0;i<cat.size();i++)
		{clients.add(cat.get(i).getClient());
		}
		return contracts;
	}
	
	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<Contract> getCat() {
		return cat;
	}

	public void setCat(List<Contract> cat) {
		this.cat = cat;
	}

	public String getAgentpic() {
		return agentpic;
	}

	public List<ContractProperty> getProp() {
		return prop;
	}

	public void setAgentpic(String agentpic) {
		this.agentpic = agentpic;
	}

	public float getV() {
		return v;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public void setV(int v) {
		this.v = v;
	}

	public void setContract(Contract contract) {
		contract = contract;
	}
	public List<ContractProperty> getProp(int id) {
		List<ContractProperty> prop = ServiceEquiment.findCProperty(id);
		return prop;	}
	public void setProp(List<ContractProperty> prop) {
		this.prop = prop;
	}

	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
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
	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRIB_Number() {
		return RIB_Number;
	}
	public void setRIB_Number(String rIB_Number) {
		RIB_Number = rIB_Number;
	}
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	public type_contract getType_contract() {
		return type_contract;
	}
	public void setType_contract(type_contract type_contract) {
		this.type_contract = type_contract;
	}
	public double getCommision() {
		return commision;
	}
	public void setCommision(double commision) {
		this.commision = commision;
	}
	public double getPremium() {
		return premium;
	}
	public void setPremium(double premium) {
		this.premium = premium;
	}
	public String getCondition_equipment() {
		return condition_equipment;
	}
	public void setCondition_equipment(String condition_equipment) {
		this.condition_equipment = condition_equipment;
	}
	public float getPrime() {
		return prime;
	}
	public void setPrime(float prime) {
		this.prime = prime;
	}
	public type_item getType_item() {
		return type_item;
	}
	public void setType_item(type_item type_item) {
		this.type_item = type_item;
	}
	public item getItem() {
		return item;
	}
	public void setItem(item item) {
		this.item = item;
	}
	public marque getMarque() {
		return marque;
	}
	public void setMarque(marque marque) {
		this.marque = marque;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	
	public String getValidation() {
		return Validation;
	}
	public void setValidation(String validation) {
		Validation = validation;
	}
	public option_contract getOption_contract() {
		return option_contract;
	}
	public void setOption_contract(option_contract option_contract) {
		this.option_contract = option_contract;
	}
	public Date getDate_end() {
		return date_end;
	}
	public void setDate_end(Date date_end) {
		this.date_end = date_end;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public Contract getContract() {
		return contract;
	}
	
	
}
