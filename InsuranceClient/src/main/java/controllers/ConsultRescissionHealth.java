package controllers;

import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import services.interf.IHealthInterfaceRemote;

public class ConsultRescissionHealth implements Initializable {

	  @FXML
	    private Button cancelButton;

	    @FXML
	    private Label insuredName;

	    @FXML
	    private Label InsuredBirthDate;

	    @FXML
	    private Label InsuredPhone;

	    @FXML
	    private Label creationDate;

	    @FXML
	    private Label endDate;

	    @FXML
	    private Label options;

	    @FXML
	    private Label prime;

	    @FXML
	    private Label formule;

	    @FXML
	    private Label nbrchid;

	    @FXML
	    private Label agent;
	    
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
			insuredName.setText(health.getClient().getFirstName()+ " " + health.getClient().getLastName());

			InsuredBirthDate.setText(health.getClient().getBirthDate()+"");

		   
		    InsuredPhone.setText(health.getClient().getPhone()+"");
		    

		   creationDate.setText(health.getDate_creation()+"");
		   

		   endDate.setText(health.getDate_end()+"");

		    options.setText(health.getOptions());

		    prime.setText(health.getPrime()+"");

		     formule.setText(health.getFormulas());

		    nbrchid.setText(health.getNbr_child()+"");

		    agent.setText(health.getAgent().getFirstName()+" "+health.getAgent().getLastName());

			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


    @FXML
    void cancelAction(ActionEvent event) {
    	
    	/*try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/views/healthRescission.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Manage Health");
			Stage stage = (Stage) cancelButton.getScene().getWindow();
			stage.close();
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
        FXMLLoader loader = containerParent.switchViewTo("/views/healthRescission.fxml");
        ((HealthRecissionController) loader.getController()).setContainer(containerParent);
        
        

    }
    
    

    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
