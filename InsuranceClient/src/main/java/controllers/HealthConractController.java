package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Health;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.interf.IHealthInterfaceRemote;

public class HealthConractController implements Initializable {

	  @FXML
	    private AnchorPane pane;

	    @FXML
	    private Label healthcontractName;

	    @FXML
	    private Label insuredFirstName;

	    @FXML
	    private Label lastNameInsured;

	    @FXML
	    private Label birthDate;

	    @FXML
	    private Label familySituation;

	    @FXML
	    private Label profission;

	    @FXML
	    private Label adress;

	    @FXML
	    private Label phone;

	    @FXML
	    private Label email;

	    @FXML
	    private Label salary;

	    @FXML
	    private Label people;

	    @FXML
	    private Label generalHealth;

	    @FXML
	    private Label gender;

	    @FXML
	    private Label chronicHealth;

	    @FXML
	    private Label smoke;

	    @FXML
	    private Label dangerousSports;

	    @FXML
	    private Label alcohol;

	    @FXML
	    private Label options;

	    @FXML
	    private Button medicaleFile;


	    @FXML
	    private Button cancel;

	    @FXML
	    private Button print;

	    @FXML
	    private Label prime;

	    @FXML
	    private Label comission;

	    @FXML
	    private Label creationdate;

	    @FXML
	    private Label enddate;
		private ManageHealthContractsContainerController containerParent;
		
	    public void setContainer(ManageHealthContractsContainerController container){
	        this.containerParent = container;
	    }

	

	Health health;

	public void setId(int contract_id) {
		String jndiName = "Insurance-ear/Insurance-ejb/HealthServiceImplem!services.interf.IHealthInterfaceRemote";
		Context context;
		try {
			context = new InitialContext();
			IHealthInterfaceRemote proxy = (IHealthInterfaceRemote) context.lookup(jndiName);
			health = proxy.getHealthById(contract_id);
			insuredFirstName.setText(health.getClient().getFirstName());
			lastNameInsured.setText(health.getClient().getLastName());
			birthDate.setText(health.getClient().getBirthDate().toString());
			familySituation.setText(health.getClient().getFamily_situation());
			profission.setText(health.getClient().getJob());
			adress.setText(health.getClient().getAddress());
			phone.setText(health.getClient().getPhone()+"");
			email.setText(health.getClient().getEmail());
			salary.setText(health.getClient().getSalary()+" DT");
			people.setText(health.getInsured_people());
			generalHealth.setText(health.getGeneral_health());
			if(health.getClient().isGender()==true)
			gender.setText("Man");
			else gender.setText("Women");
			chronicHealth.setText(health.getChronic_health());
			smoke.setText(health.getSmoke());
			dangerousSports.setText(health.getDangerous_sport());
			alcohol.setText(health.getAlcohol());
			options.setText(health.getOptions());
			prime.setText(health.getPrime()+" DT");
			comission.setText(health.getCommission()+" DT");
			creationdate.setText(health.getDate_creation().toString());
			enddate.setText(health.getDate_end().toString());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	void cancelAction(ActionEvent event) {

		/*try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/views/HealthManage.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Manage Health");
			Stage stage = (Stage) cancel.getScene().getWindow();
			stage.close();
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
        FXMLLoader loader = containerParent.switchViewTo("/views/HealthManage.fxml");
        ((HealthManage) loader.getController()).setContainer(containerParent);
	}


	@FXML
	void medicaleFileAction(ActionEvent event) {

	   	Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Consult medical file");
				alert.setHeaderText(null);
				alert.setContentText("Are sure to consult medicals files?");

				ButtonType buttonTypeOne = new ButtonType("yes");

				ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

				alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);

				Optional<ButtonType> result = alert.showAndWait();
				if(result.get() == buttonTypeOne){
				/*	try {
						
						Stage primaryStage = new Stage();
						FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/consultMedicalFile.fxml"));
						Parent root1 = (Parent) loader.load();
						primaryStage.setTitle("Medicals Files");
						Scene scene = new Scene(root1);
						scene.getStylesheets().add("/css/application.css");
						primaryStage.setScene(scene);
						MedicalFileController mainController = loader.<MedicalFileController>getController();
						mainController.setHealth(health);
						Stage stage = (Stage) medicaleFile.getScene().getWindow();
						stage.close();
						primaryStage.show();
						}
					 catch (IOException e) {
						e.printStackTrace();
					}*/
			        FXMLLoader loader = containerParent.switchViewTo("/views/consultMedicalFile.fxml");
			        ((MedicalFileController) loader.getController()).setContainer(containerParent);
			        ((MedicalFileController) loader.getController()).setHealth(health);

				}
	}



	@FXML
	void printAction(ActionEvent event) {
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {


	}

}
