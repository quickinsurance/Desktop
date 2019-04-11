package controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import entities.Client;
import entities.Contract;
import entities.Housing;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import tn.esprit.Test;

	public class AddUserforHousingController implements Initializable {
	    @FXML
	    private Button Adduser;

	    @FXML
	    private JFXTextField Firstname;

	    @FXML
	    private JFXTextField address;

	    @FXML
	    private JFXTextField lastname;

	    @FXML
	    private JFXTextField mail;

	    @FXML
	    private JFXTextField rib;

	    @FXML
	    private JFXTextField job;

	    @FXML
	    private JFXTextField phone;
	    @FXML
	    private JFXTextField cin;

	    @FXML
	    private Label mail1;

	    @FXML
	    private Label rib1;

	    @FXML
	    private Label name1;

	    @FXML
	    private Label job1;

	    @FXML
	    private Label address1;

	    @FXML
	    private Label phone1;

	    @FXML
	    private Label firstname1;
	    @FXML
	    private Label cin1;
	    @FXML
	    private TableView<Client> tab;

	    @FXML
	    private TableColumn<?, ?> fname;

	    @FXML
	    private TableColumn<?, ?> lname;

	    @FXML
	    private TableColumn<?, ?> job2;

	    @FXML
	    private TableColumn<?, ?> cin2;

	    @FXML
	    private TextField rechercheclient;
	    
	    void filterContract(String oldValue, String newValue) throws Exception {
	    	Test t = new Test();
	    	ObservableList<Client> filteredList = FXCollections.observableArrayList();
	        if (rechercheclient.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
	            ObservableList<Client> oblist=FXCollections.observableArrayList(t.allclient());
	            tab.setItems(oblist) ;
	        } else {

	            newValue = newValue.toUpperCase();

	            for (Client e : tab.getItems()) {

	                String filtertitre= e.getFirstName().toString();
	                String filtre2 = String.valueOf(e.getCin());

	                if (filtertitre.toUpperCase().contains(newValue)||filtre2.toUpperCase().contains(newValue)) {
	                    filteredList.add(e);
	                }
	            }
	            tab.setItems(filteredList);
	        }
	    }

	    @FXML
	    void adduser(ActionEvent event) throws Exception {
	    	
	    	  Test t = new Test();
	    	    
	    	 boolean valid = true;

             if (Firstname.getText().equals("")) {
            	 firstname1.setText("Field is empty !");
            	 firstname1.setVisible(true);
                 valid = false;
             } else {
            	 firstname1.setText("");
             }

             if (address.getText().equals("")) {
            	 address1.setText("Field is empty !");
            	 address1.setVisible(true);
                 valid = false;
             } else {
            	 address1.setText("");
             }

             if (lastname.getText().equals("")) {
            	 name1.setText("Field is empty !");
            	 name1.setVisible(true);
                 valid = false;
             } else {
            	 name1.setText("");
             }

             if (mail.getText().equals("")) {
            	 mail1.setText("Field is empty !");
            	 mail1.setVisible(true);
                 valid = false;
             } else {
            	 mail1.setText("");
             }
             if (rib.getText().equals("")) {
            	 rib1.setText("Field is empty !");
            	 rib1.setVisible(true);
                 valid = false;
             } else {
            	 rib1.setText("");
          
             } 
             
             if (job.getText().equals("")) {
            	 job1.setText("Field is empty !");
            	 job1.setVisible(true);
                 valid = false;
             } else {
            	 job1.setText("");
             }
             
             if (phone.getText().equals("")) {
            	 phone1.setText("Field is empty !");
            	 phone1.setVisible(true);
                 valid = false;
             } else {
            	 phone1.setText("");
             }
             
             if (cin.getText().equals("")) {
            	 cin1.setText("Field is empty !");
            	 cin1.setVisible(true);
                 valid = false;
             } else {
            	 cin1.setText("");
             }
             
             if (!valid) {
                 return;
             }
             
             Client c = new Client();
             
             c.setAddress(address.getText());
             c.setEmail(mail.getText());
             c.setFirstName(Firstname.getText());
             c.setLastName(lastname.getText());
             c.setJob(job.getText());
             c.setPhone(Integer.parseInt(phone.getText()));
             c.setRIB_Number(rib.getText());
             c.setCin(Integer.parseInt(cin.getText()));
             System.out.println(c.getAddress());
             System.out.println(c.toString());

             t.ServiceAddclient(c);
             
             FXMLLoader loader=new FXMLLoader(getClass().getResource("/views/AddContractHousingView.fxml"));
             
             Parent root = (Parent) loader.load();
             AddContractHousingController cd = loader.getController();
             
             cd.setclient(c);
             Stage stage=new Stage();
             stage.setScene(new Scene(root));
             stage.show();
             cd.startstage();
 			System.out.println(c.toString());

        
             
             
             
             

	    }

		@Override
		public void initialize(URL location, ResourceBundle resources) {
		Test t = new Test();
	try {
			
			
			ObservableList<Client> oblist=FXCollections.observableArrayList(t.allclient());
		String link ;
		
		fname.setCellValueFactory(new PropertyValueFactory<>("firstName"));
			lname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
			job2.setCellValueFactory(new PropertyValueFactory<>("job"));
			cin2.setCellValueFactory(new PropertyValueFactory<>("cin"));
			tab.setItems(oblist);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	rechercheclient.textProperty().addListener((observable, oldValue, newValue) -> {
		
		try {
			filterContract(oldValue, newValue);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("textfield changed from " + oldValue + " to " + newValue);
	});
			
		}
		
	    @FXML
	    void gohousing(MouseEvent event) throws IOException {
	        Client c1 = (Client) tab.getSelectionModel().getSelectedItem();
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/views/AddContractHousingView.fxml"));
            
            Parent root = (Parent) loader.load();
            AddContractHousingController cd = loader.getController();
            
            cd.setclient(c1);
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            cd.startstage();
	        
	    }
	    

	    @FXML
	    void show(ActionEvent event) {
	    	
	    	tab.setVisible(true);
	    	rechercheclient.setVisible(true);

	    }
	    public ContractHousingContainerController  Parentcontainer;
		public void setContainer(ContractHousingContainerController containerParent) {
			this.Parentcontainer=containerParent;
			
		}
		
	

	
}
