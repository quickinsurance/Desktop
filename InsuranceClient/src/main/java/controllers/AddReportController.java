package controllers;


import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Accident;
import entities.Report;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import services.interf.IAccidentInterfaceRemote;
import services.interf.IReportInterfaceRemote;

public class AddReportController implements Initializable{
	  @FXML
	    private TextArea repportDescription;
	 @FXML
	    private Label InsuredName;

	   @FXML
	    private Text description;

	    @FXML
	    private Label AccidentDate;

	    @FXML
	    private RadioButton toSupported;

	    @FXML
	    private RadioButton notSupported;

	    @FXML
	    private TextField refund;


	    @FXML
	    private Button addrepport;

	    @FXML
	    private Button cancel;
	    @FXML
		private ToggleGroup groupeSupported;
	    
	    
	    
	    @FXML
	    private CheckBox fire;

	    @FXML
	    private CheckBox waterdamage;

	    @FXML
	    private CheckBox icebreak;

	    @FXML
	    private CheckBox housebreaking;

	    @FXML
	    private CheckBox Electricaldamage;

	    @FXML
	    private CheckBox property;

	    @FXML
	    private CheckBox solarpanels;

	    @FXML
	    private CheckBox motorpool;
	    
	    
	    String descriptions="Domages:";

	    String jndiName = "Insurance-ear/Insurance-ejb/AccidentServiceImplem!services.interf.IAccidentInterfaceRemote";
		Context context;
	  int IdAccident; 
	  Accident accident;
	public void setId(int accident_id) {
		IdAccident=accident_id;
		
		try {
			context = new InitialContext();
			IAccidentInterfaceRemote proxy = (IAccidentInterfaceRemote)context.lookup(jndiName);
			 accident =  proxy.getAccidentById(IdAccident);
			String type = accident.getType_contract().toString();
			if(type.contains("Vehicle"))
			InsuredName.setText(InsuredName.getText()+" " + accident.getVehicle()
			.getClient().getFirstName()+" "+accident.getVehicle()
			.getClient().getLastName());
			if(type.contains("housing"))
				
				InsuredName.setText(InsuredName.getText()+" " + accident.getHousing()
				.getClient().getFirstName()+" "+accident.getHousing()
				.getClient().getLastName());
			    description.setText(accident.getDescription());
			    AccidentDate.setText(AccidentDate.getText()+" "+accident.getDate_of_Accident());
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}
	
	 @FXML
	    void addReportAction(ActionEvent event) {
		
			String jndiName2 = "Insurance-ear/Insurance-ejb/ReportServiceImplem!services.interf.IReportInterfaceRemote";
			Context context2;
			try {
				context2 = new InitialContext();
				IReportInterfaceRemote proxy=(IReportInterfaceRemote)context2.lookup(jndiName2);
				Report report = new Report();
				report.setAccident(accident);
				report.setDate_report(Date.valueOf(LocalDate.now()));
				report.setDescription_report(repportDescription.getText());
				
				accident.setExpert_opinion(((RadioButton) this.groupeSupported.getSelectedToggle()).getText());
				accident.setExpert_traited(true);
				accident.setExpert_refund(Float.parseFloat(refund.getText()));
				
				IAccidentInterfaceRemote proxy3 = (IAccidentInterfaceRemote)context.lookup(jndiName);
				proxy3.updateAccidentByexpert(accident);
				proxy.addReport(report);
				/*try {
		    		
					Stage primaryStage = new Stage();
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ExpertAccidentManage.fxml"));
					Parent root1 = (Parent) loader.load();
					primaryStage.setTitle("Accident");
					Scene scene = new Scene(root1);
					scene.getStylesheets().add("/css/application.css");
					primaryStage.setScene(scene);
					
					Stage stage = (Stage) cancel.getScene().getWindow();
					stage.close();
					primaryStage.show();
					}
				 catch (IOException e) {
					e.printStackTrace();
				}*/
				
				 FXMLLoader loader = containerParent.switchViewTo("/views/ExpertAccidentManage.fxml");
			        ((ExpertAccidentManageController) loader.getController()).setContainer(containerParent);

				
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	    }

	    @FXML
	    void cancelAction(ActionEvent event) {

	    	/*try {
	    		
				Stage primaryStage = new Stage();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ExpertAccidentManage.fxml"));
				Parent root1 = (Parent) loader.load();
				primaryStage.setTitle("Accident");
				Scene scene = new Scene(root1);
				scene.getStylesheets().add("/css/application.css");
				primaryStage.setScene(scene);
				
				Stage stage = (Stage) cancel.getScene().getWindow();
				stage.close();
				primaryStage.show();
				}
			 catch (IOException e) {
				e.printStackTrace();
			}*/
	    	
	    	
	    	 FXMLLoader loader = containerParent.switchViewTo("/views/ExpertAccidentManage.fxml");
		        ((ExpertAccidentManageController) loader.getController()).setContainer(containerParent);

	    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		groupeSupported = new ToggleGroup();
		toSupported.setToggleGroup(groupeSupported);
		notSupported.setToggleGroup(groupeSupported);
		
	}

		private HousingExpertManageContainerController containerParent;
		
	    public void setContainer(HousingExpertManageContainerController container){
	        this.containerParent = container;
	    }
	    
	    
	    
	    
	    
	    
	    
	    


	    @FXML
	    void alacticAction(ActionEvent event) {
	    	
	    	descriptions= descriptions+"\n"+Electricaldamage.getText();
	    	repportDescription.setText(descriptions);

	    }

	

	    @FXML
	    void fireAction(ActionEvent event) {
	    	
	    	descriptions= descriptions+"\n"+fire.getText();
	    	repportDescription.setText(descriptions);


	    }

	    @FXML
	    void housbreakingAction(ActionEvent event) {
	    	descriptions= descriptions+"\n"+housebreaking.getText();
	    	repportDescription.setText(descriptions);


	    }

	    @FXML
	    void iceAction(ActionEvent event) {
	    	
	    	descriptions= descriptions+"\n"+icebreak.getText();
	    	repportDescription.setText(descriptions);


	    }

	    @FXML
	    void poolAction(ActionEvent event) {
	    	descriptions= descriptions+"\n"+motorpool.getText();
	    	repportDescription.setText(descriptions);


	    }

	    @FXML
	    void propertyAction(ActionEvent event) {
	    	descriptions= descriptions+"\n"+property.getText();
	    	repportDescription.setText(descriptions);


	    }

	    @FXML
	    void solarpanelAcyion(ActionEvent event) {

	    	descriptions= descriptions+"\n"+solarpanels.getText();
	    	repportDescription.setText(descriptions);

	    }

	    @FXML
	    void waterAction(ActionEvent event) {
	    	
	    	descriptions= descriptions+"\n"+waterdamage.getText();
	    	repportDescription.setText(descriptions);


	    }

}
