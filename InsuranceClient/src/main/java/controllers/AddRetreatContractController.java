package controllers;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import entities.Agent;
import entities.Client;
import entities.Contract.type_contract;
import entities.Retreat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import services.interf.IRetreatInterfaceRemote;
import services.interf.UserServiceRemote;
import services.interf.VehicleContractServiceRemote;

public class AddRetreatContractController  implements Initializable {

	private String aJob[] = {"Etudiant", "Retraité", "Artisan","Enseignant","Commerçant","Agriculteur","Chef d'entreprise","Profession libérale"};

	  @FXML
	    private JFXTextField firstNametxt;

	    @FXML
	    private JFXTextField lastNametxt;

	    @FXML
	    private JFXTextField cintxt;

	    @FXML
	    private JFXDatePicker birthDatePicker;

	    @FXML
	    private Button ValidateContractBtn;

	    @FXML
	    private ImageView penImageView;

	    @FXML
	    private JFXTextField RibNumberTxt;

	    @FXML
	    private JFXComboBox<?> comboJob;

	    @FXML
	    private JFXTextField adresseTxt;

	    @FXML
	    private JFXTextField emailtxt;

	    @FXML
	    private JFXDatePicker birthDatePicker1;

	    @FXML
	    private Button backBtn;

	    @FXML
	    private JFXTextField phone;

	    @FXML
	    private JFXTextField salary;
    
	    String errorMessage ="";
     private RetreatManageContainerController containerParent;
	
    
	public void setContainer(RetreatManageContainerController container) {
		this.containerParent = container;
		
	}

    @FXML
    void addContractAction(ActionEvent event) throws NamingException {
    	
    	String jndiNameUser = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
		Context contextUser = new InitialContext();
		UserServiceRemote proxyUser = (UserServiceRemote) contextUser.lookup(jndiNameUser);
		

		String jndiName = "Insurance-ear/Insurance-ejb/RetreatServiceImplem!services.interf.IRetreatInterfaceRemote";
		Context context = new InitialContext();
		IRetreatInterfaceRemote proxy = (IRetreatInterfaceRemote) context.lookup(jndiName);

		
		if(firstNametxt.getText()==null || firstNametxt.getText().length()==0)
			errorMessage= errorMessage+"\n  First Name  !";
		if(lastNametxt.getText()==null || lastNametxt.getText().length()==0)
			errorMessage= errorMessage+" \n  Last Name ";
		if(birthDatePicker.getValue()==null)
			errorMessage = errorMessage+"\n Birth Date";
		if(birthDatePicker1.getValue()==null)
			errorMessage=errorMessage+"\n Retirement Date ";
		if(cintxt.getText()==null || cintxt.getText().length()==0)
			errorMessage= errorMessage+"\n CIN";
		if(salary.getText().length()==0|| salary.getText()==null)
		    errorMessage=errorMessage+"\n Salary";
		if(comboJob.getValue()==null)
			errorMessage=errorMessage+"\n Job";
		if(adresseTxt.getText()==null|| adresseTxt.getText().length()==0)
			errorMessage=errorMessage+"\n address";
		if(emailtxt.getText()==null|| emailtxt.getText().length()==0)
			errorMessage=errorMessage+"\n Email";
		if(phone.getText()==null|| phone.getText().length()==0)
			errorMessage=errorMessage+"\n Phone";
		if(errorMessage.length()==0)
		{
			Retreat retreat = new Retreat();
			Agent agent = new Agent();
			agent.setId(1);
			retreat.setAgent(agent);
			retreat.setCommission((Integer.parseInt(salary.getText())*20/100)*10/100);
			retreat.setDate_creation(Date.valueOf(LocalDate.now()));
			retreat.setDate_end(Date.valueOf(LocalDate.now().plusYears(1)));
			retreat.setPrime(Integer.parseInt(salary.getText())*20/100);
			retreat.setRetreatDate(Date.valueOf(birthDatePicker1.getValue()));
			retreat.setRescission(false);
			retreat.setType_contract(type_contract.Retirement);
			
			
			
		if (proxyUser.getClientByCIN(Integer.parseInt(cintxt.getText())) == null) {
			Client client = new Client();
			client.setBirthDate(Date.valueOf(birthDatePicker.getValue()));
			client.setCin(Integer.parseInt(cintxt.getText()));
			client.setEmail(emailtxt.getText());
			client.setFamily_situation("married");
			client.setFirstName(firstNametxt.getText());
			client.setLastName(lastNametxt.getText());
			
			client.setGender(true);
		
			client.setPhone(Integer.parseInt(phone.getText()));
			client.setSalary(Float.parseFloat(salary.getText()));
			client.setRIB_Number(RibNumberTxt.getText());

			client.setAddress(adresseTxt.getText());
			client.setJob(comboJob.getValue().toString());
			if (proxyUser.getUserByCIN(Integer.parseInt(cintxt.getText())) == null) {
				proxyUser.addClient(client);
				retreat.setClient(proxyUser.getClientByCIN(Integer.parseInt(cintxt.getText())));
				proxy.addRetreat(retreat);
				FXMLLoader loader = containerParent.switchViewTo("/views/RetreatContractManageView.fxml");
		        ((RetreatContractManageController) loader.getController()).setContainer(containerParent);
				
			} else {

				proxyUser.removeUser(proxyUser.getUserByCIN(Integer.parseInt(cintxt.getText())));
				proxyUser.addClient(client);
				retreat.setClient(client);
				proxy.addRetreat(retreat);
				FXMLLoader loader = containerParent.switchViewTo("/views/RetreatContractManageView.fxml");
		        ((RetreatContractManageController) loader.getController()).setContainer(containerParent);
			}
			
			
			
			
			
			
		}
		
    }else {
    	
    	
    	
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Invalid fields");
			alert.setHeaderText("Please fill in the fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();

	
    }

		
    }

    
    private void initJob(){
		List<String> list = new ArrayList<String>();
		for(String content:aJob){
			list.add(content);
		}
		ObservableList oblist= FXCollections.observableArrayList(list);
		comboJob.setItems(oblist);
	}
    @FXML
    void backAction(ActionEvent event) {
        FXMLLoader loader = containerParent.switchViewTo("/views/RetreatContractManageView.fxml");
        ((RetreatContractManageController) loader.getController()).setContainer(containerParent);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initJob();
		
	}



}
