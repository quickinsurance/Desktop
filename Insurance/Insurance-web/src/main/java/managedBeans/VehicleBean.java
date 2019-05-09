package managedBeans;

import java.io.Serializable;
import java.sql.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Vehicle;
import services.impl.VehicleContractServiceImpl;

@ManagedBean(name="vehicleBean")
@SessionScoped
public class VehicleBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String matriculation;
	private String mark;
	private String vehicleOption;
	private Date date_of_circulation;
	private String vehicleGroup;
	
	
	@EJB
	VehicleContractServiceImpl vehicleService;
	public void addVehicleContract(){
		vehicleService.addVehicleContract(new Vehicle(matriculation,mark,vehicleOption,vehicleGroup, date_of_circulation));
	}
	
	public VehicleBean(){}


	public String getMatriculation() {
		return matriculation;
	}


	public void setMatriculation(String matriculation) {
		this.matriculation = matriculation;
	}


	public String getMark() {
		return mark;
	}


	public VehicleContractServiceImpl getVehicleService() {
		return vehicleService;
	}

	public void setVehicleService(VehicleContractServiceImpl vehicleService) {
		this.vehicleService = vehicleService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}


	public String getVehicleOption() {
		return vehicleOption;
	}


	public void setVehicleOption(String vehicleOption) {
		this.vehicleOption = vehicleOption;
	}


	public Date getDate_of_circulation() {
		return date_of_circulation;
	}


	public void setDate_of_circulation(Date date_of_circulation) {
		this.date_of_circulation = date_of_circulation;
	}


	public String getVehicleGroup() {
		return vehicleGroup;
	}


	public void setVehicleGroup(String vehicleGroup) {
		this.vehicleGroup = vehicleGroup;
	}
	

}
