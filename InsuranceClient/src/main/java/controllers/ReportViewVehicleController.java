package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Accident;
import entities.Sinister;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.interf.IAccidentInterfaceRemote;
import services.interf.ISinisterInterfaceRemote;

public class ReportViewVehicleController implements Initializable {
	String jndiName = "Insurance-ear/Insurance-ejb/AccidentServiceImplem!services.interf.IAccidentInterfaceRemote";
	Context context;
	String jndiNameSinister = "Insurance-ear/Insurance-ejb/SinisterServiceImplem!services.interf.ISinisterInterfaceRemote";
	Context contextSinister;
	Accident accident;
	int IdAccident;




    @FXML
    private Label insuredName;

    @FXML
    private Label InsuredBirthDate;

    @FXML
    private Label InsuredPhone;

    @FXML
    private Label options;

    @FXML
    private Label prime;

    @FXML
    private Label dateAccident;

    @FXML
    private Label refund;

    @FXML
    private Label opinion;

    @FXML
    private Text reportDescription;

    @FXML
    private Label creationDate;
    
    @FXML
    private Button cancel;

    @FXML
    private Button addSinister;

    @FXML
    private Button refuse;

    @FXML
    private Button pdf;
	private VehicleSinisterContainerController containerParent;
	
    public void setContainer(VehicleSinisterContainerController container){
        this.containerParent = container;
    }
	
	public void setId(int accident_id) {
		IdAccident = accident_id;
		IdAccident = accident_id;

		try {
			context = new InitialContext();
			IAccidentInterfaceRemote proxy = (IAccidentInterfaceRemote) context.lookup(jndiName);
			accident = proxy.getAccidentById(IdAccident);
      		insuredName.setText(accident.getVehicle().getClient().getFirstName()+
					" "+ accident.getVehicle().getClient().getLastName());
			InsuredBirthDate.setText(accident.getVehicle().getClient().getBirthDate().toString());
			InsuredPhone.setText(accident.getVehicle().getClient().getPhone()+"");
			creationDate.setText(accident.getVehicle().getDate_creation().toString());
			options.setText(accident.getVehicle().getDate_end().toString());
			prime.setText(accident.getVehicle().getPrime()+"");
			dateAccident.setText(accident.getDate_of_Accident().toString());
			refund.setText(accident.getExpert_refund()+"");
			opinion.setText(accident.getExpert_opinion());
			reportDescription.setText(accident.getReport().getDescription_report());
			
			
			
			
			

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	void addSinisterAction(ActionEvent event) throws NamingException {
		

		Sinister sinister = new Sinister();
		sinister.setRefund(accident.getExpert_refund());
		sinister.setDescription(accident.getReport().getDescription_report());
		sinister.setReport(accident.getReport());
		contextSinister = new InitialContext();
		ISinisterInterfaceRemote proxySinister =(ISinisterInterfaceRemote)contextSinister.lookup(jndiNameSinister);
		proxySinister.addSinister(sinister);
		context = new InitialContext();
		IAccidentInterfaceRemote proxy = (IAccidentInterfaceRemote) context.lookup(jndiName);
		accident = proxy.getAccidentById(IdAccident);
		accident.setSinister_traited(true);
		proxy.updateAccidentAfterAddSinister(accident);
	/*	try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/views/VehicleAccidentManege.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Manage Accident");
			Stage stage = (Stage) cancel.getScene().getWindow();
			stage.close();
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}  */
		  FXMLLoader loader = containerParent.switchViewTo("/views/VehicleAccidentManege.fxml");
	        ((VehicleAccideentMAnageController) loader.getController()).setContainer(containerParent);

	}

	@FXML
	void cancelAction(ActionEvent event) {
		/*try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/views/VehicleAccidentManege.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Manage Accident");
			Stage stage = (Stage) cancel.getScene().getWindow();
			stage.close();
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		  FXMLLoader loader = containerParent.switchViewTo("/views/VehicleAccidentManege.fxml");
	        ((VehicleAccideentMAnageController) loader.getController()).setContainer(containerParent);
	}

	@FXML
	void pdfAction(ActionEvent event)  {

		
	}

	@FXML
	void refuseAction(ActionEvent event) throws NamingException {
		context = new InitialContext();
		IAccidentInterfaceRemote proxy = (IAccidentInterfaceRemote) context.lookup(jndiName);
		accident = proxy.getAccidentById(IdAccident);
		accident.setSinister_traited(true);
		proxy.updateAccidentAfterAddSinister(accident);
		/*try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/views/VehicleAccidentManege.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Manage Accident");
			Stage stage = (Stage) cancel.getScene().getWindow();
			stage.close();
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		  FXMLLoader loader = containerParent.switchViewTo("/views/VehicleAccidentManege.fxml");
	        ((VehicleAccideentMAnageController) loader.getController()).setContainer(containerParent);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
