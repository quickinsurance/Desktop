package managedBeans;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;





import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.component.export.ExcelOptions;
import org.primefaces.component.export.PDFOptions;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.event.MoveEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;

import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Vehicle;
import services.impl.VehicleContractServiceImpl;

@ManagedBean(name="vehicleRequestBean")
@SessionScoped
public class VehicleRequestsBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String matriculation;
	private String mark;
	private String vehicleOption;
	private Date date_of_circulation;
	private String vehicleGroup;
	
	
	
	@EJB VehicleContractServiceImpl vehicleService;
	private List<Vehicle> vehicles;
	public List<Vehicle> getVehicles(){
		vehicles = vehicleService.findAllVehicleContracts();
		return vehicles;
	}
	
	public void removeEmploye(int requestId) {
		vehicleService.removeVehicleContract(requestId);
	}
	public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
		Document pdf = (Document) document;
		pdf.open();
		pdf.setPageSize(PageSize.A4);

		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		String logo = externalContext.getRealPath("") + File.separator + "resources" + File.separator + "demo"
				+ File.separator + "images" + File.separator + "logo.png";

		pdf.add(Image.getInstance(logo));
	}
	
	public VehicleRequestsBean(){}



	public String getMatriculation() {
		return matriculation;
	}



	public void setMatriculation(String matriculation) {
		this.matriculation = matriculation;
	}



	public String getMark() {
		return mark;
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

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
}
