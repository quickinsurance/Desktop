package controllers;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import entities.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
    private JFXTextField salary;
    
    @FXML
    private JFXTextField phone;
    
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

			client.setAddress(adresseTxt.getText());
			client.setJob(comboJob.getValue().toString());
			if (proxyUser.getUserByCIN(Integer.parseInt(cintxt.getText())) == null) {
				proxyUser.addClient(client);
			} else {

				proxyUser.removeUser(proxyUser.getUserByCIN(Integer.parseInt(cintxt.getText())));
				proxyUser.addClient(client);
			}
			
			
			
			
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
