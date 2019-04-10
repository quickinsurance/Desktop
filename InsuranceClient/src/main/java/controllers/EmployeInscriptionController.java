package controllers;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import entities.Agent;
import entities.Expert;
import entities.Financier;
import entities.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import services.interf.UserServiceRemote;
import util.MailVerification;

public class EmployeInscriptionController implements Initializable {
	@FXML
	private AnchorPane anchorParent;

	@FXML
	private JFXTextField txt_FirstName;

	@FXML
	private JFXTextField txt_LastName;

	@FXML
	private JFXTextField cinTxt;

	@FXML
	private JFXTextField txt_Phone;

    @FXML
    private JFXPasswordField txt_Code;

    @FXML
    private JFXPasswordField txt_Rcode;

	@FXML
	private JFXRadioButton Rmale;

	@FXML
	private ToggleGroup genderGroup;

	@FXML
	private JFXRadioButton Rfemale;

	@FXML
	private JFXDatePicker birthPicker;

	@FXML
	private JFXComboBox<String> comboRole;

	@FXML
	private Button btnRegister;

	@FXML
	private ImageView EmployeeImageView;

    @FXML
    private ImageView btnPicture;
	@FXML
	private Button btnReset;

    @FXML
    private TextArea textArea;
    @FXML
    private JFXTextField txt_Email;

    @FXML
    private JFXComboBox<String> ExpertSpecialityCombo;
    
    @FXML
    private JFXComboBox<String> FinancierServiceCombo;

    @FXML
    private JFXCheckBox FinancierAdditionalDataBox;

    @FXML
    private JFXCheckBox FinancierTransactionsBox;

    @FXML
    private JFXCheckBox FinancierManagementBox;

    @FXML
    private JFXComboBox<String> AgentAgenceCombo;
    
    @FXML
    private Label labelFirstName;

    @FXML
    private Label labelLastName;

    @FXML
    private Label labelCin;

    @FXML
    private Label labelEmail;

    @FXML
    private Label labelCode;

    @FXML
    private Label labelRcode;

    @FXML
    private Label labelBirth;

    @FXML
    private Label labelPhone;
    @FXML
    private Label labelRole;
    @FXML
    private ImageView returnImage;
	


	//User
	User user = new User();
	Expert expert = new Expert();
	Financier financier = new Financier();
	Agent agent = new Agent();
	//combo Role
	private String aRole[] = {"Financier", "Expert", "Agent"};
	private String aSpeciality[] = {"Vehicle Accidents", "Housing Accidents"};
	private String aService[] = {"Housing", "Vehicle", "Health", "Equipments"};
	private String aAgence[]={"Tunis Agence","Sousse Agence","Sfax Agence","Gafsa Agence"};
	//Upload photo
	private FileChooser fileChooser;
	private File file;
	private Desktop desktop = Desktop.getDesktop();
	private Image image;

	private ManageEmployeesDisplaysController containerParent;
	
    public void setContainer(ManageEmployeesDisplaysController container){
        this.containerParent = container;
    }

	private void initRole(){
		List<String> list = new ArrayList<String>();
		for(String content:aRole){
			list.add(content);
		}
		ObservableList oblist= FXCollections.observableArrayList(list);
		comboRole.setItems(oblist);
	}
	private void initExpertSpeciality(){
		List<String> list = new ArrayList<String>();
		for(String content:aSpeciality){
			list.add(content);
		}
		ObservableList oblist= FXCollections.observableArrayList(list);
		ExpertSpecialityCombo.setItems(oblist);
	}
	private void initFinancierSpervice(){
		List<String> list = new ArrayList<String>();
		for(String content:aService){
			list.add(content);
		}
		ObservableList oblist= FXCollections.observableArrayList(list);
		FinancierServiceCombo.setItems(oblist);
	}
	private void initAgentAgence(){
		List<String> list = new ArrayList<String>();
		for(String content:aAgence){
			list.add(content);
		}
		ObservableList oblist= FXCollections.observableArrayList(list);
		AgentAgenceCombo.setItems(oblist);
	}
	

	public int ServiceAddUser(User u) throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
		Context context = new InitialContext();
		UserServiceRemote proxy = (UserServiceRemote) context.lookup(jndiName);

		return proxy.addUser(u);
	}
	public int ServiceAddFinancier(Financier f) throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
		Context context = new InitialContext();
		UserServiceRemote proxy = (UserServiceRemote) context.lookup(jndiName);

		return proxy.addFinancier(f);
	}
	public int ServiceAddExpert(Expert e) throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
		Context context = new InitialContext();
		UserServiceRemote proxy = (UserServiceRemote) context.lookup(jndiName);

		return proxy.addExpert(e);
	}
	public int ServiceAddAgent(Agent a) throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
		Context context = new InitialContext();
		UserServiceRemote proxy = (UserServiceRemote) context.lookup(jndiName);

		return proxy.addAgent(a);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initRole();	
		initAgentAgence();
		initExpertSpeciality();
		initFinancierSpervice();

	}


	@FXML
	void RegisterEmployee(ActionEvent event) throws Exception {
		 boolean valid = true;
	        if (txt_FirstName.getText().equals("")) {
	            labelFirstName.setText("Field is empty !");
	            labelFirstName.setVisible(true);
	            valid = false;
	        } else {
	            labelFirstName.setText("");
	        }

	        if (txt_LastName.getText().equals("")) {
	            labelLastName.setText("Field is empty !");
	            labelLastName.setVisible(true);
	            valid = false;
	        } else {
	            labelLastName.setText("");
	        }

	        if (txt_Email.getText().equals("")) {
	            labelEmail.setText("Field is empty !");
	            labelEmail.setVisible(true);
	            valid = false;
	        } else {
	            labelEmail.setText("");
	        }
	        if (!MailVerification.validate(txt_Email.getText())) {
	            labelEmail.setText("E-mail is not valid !");
	            labelEmail.setVisible(true);
	            valid = false;
	        } else {
	        	labelEmail.setText("E-mail valid !");
	            labelEmail.setTextFill(Color.web("GREEN"));;
	            labelEmail.setVisible(true);
	        }
	        if (cinTxt.getText().length()!=8 || cinTxt.getText().equals("")) {
	            labelCin.setText("Invalid cin !");
	            labelCin.setVisible(true);
	            valid = false;
	        } else {
	            labelCin.setText("");
	        }
	        	        
	        if (txt_Phone.getText().length()!=8 || txt_Phone.getText().equals("")) {
	            labelPhone.setText("Invalid Phone number !");
	            labelPhone.setVisible(true);
	            valid = false;
	        } else {
	            labelPhone.setText("");
	        }
	                
	        if (txt_Code.getText().equals("")) {
	            labelCode.setText("Field is empty !");
	            labelCode.setVisible(true);
	            valid = false;
	        } else {
	            labelCode.setText("");
	        }
	        if (txt_Rcode.getText().equals("")) {
	            labelRcode.setText("Field is empty !");
	            labelRcode.setVisible(true);
	            valid = false;
	        }

	        if (!txt_Code.getText().equals(txt_Rcode.getText()) || txt_Rcode.getText().isEmpty()) {
	            labelRcode.setText("Password doesn't match !");
	            labelRcode.setVisible(true);
	            valid = false;
	        } else {
	            labelRcode.setText("Password match !");
	            labelRcode.setTextFill(Color.web("GREEN"));;
	            labelRcode.setVisible(true);
	        }
	        
	        if (comboRole.getValue() == null) {
	            labelRole.setText("Field is empty !");
	            labelRole.setVisible(true);
	            valid = false;
	        }else{
	        	labelRole.setText("");
	        }


	        if (birthPicker.getValue() == null) {
	            labelBirth.setText("Field is empty !");
	            labelBirth.setVisible(true);
	            valid = false;
	        }else{
	        	labelBirth.setText("");
	        }
	        
	        if (birthPicker.getValue()!= null &&((new Date()).getYear() - java.sql.Date.valueOf(birthPicker.getValue()).getYear()) < 18){
             birthPicker.getStyleClass().add("error");
             Alert alert = new Alert(Alert.AlertType.ERROR, "Employee must at least 18 years old!", ButtonType.OK);
             alert.show();
         return;    
	        }
	        
	        if(!valid) return;
		
		
		if(comboRole.getValue().equals("Financier")){
		financier.setFirstName(txt_FirstName.getText());
		financier.setLastName(txt_LastName.getText());
		financier.setEmail(txt_Email.getText());
		financier.setCin(Integer.parseInt(cinTxt.getText()));
		financier.setPhone(Integer.parseInt(txt_Phone.getText()));
		financier.setPhoto(textArea.getText());
		financier.setGender(Rfemale.isSelected());
		financier.setNote(0);
		financier.setBirthDate(java.sql.Date.valueOf(birthPicker.getValue()));
		financier.setCode(txt_Code.getText());
		financier.setService(FinancierServiceCombo.getValue()); 
		if(FinancierAdditionalDataBox.isSelected()){
			financier.setResponsability("Manage Additional Data");
		}
		else if(FinancierTransactionsBox.isSelected()){
			financier.setResponsability("Manage Financial Transactions");
		}
		else if(FinancierManagementBox.isSelected()){
			financier.setResponsability("Manage Financial Employees");
		}
		financier.setRole("Financier");
		ServiceAddFinancier(financier);}
		
		else if(comboRole.getValue().equals("Expert")){
		expert.setFirstName(txt_FirstName.getText());
		expert.setLastName(txt_LastName.getText());
		expert.setEmail(txt_Email.getText());
		expert.setCin(Integer.parseInt(cinTxt.getText()));
		expert.setPhone(Integer.parseInt(txt_Phone.getText()));
		expert.setPhoto(textArea.getText());
		expert.setGender(Rfemale.isSelected());
		expert.setNote(0);
		expert.setBirthDate(java.sql.Date.valueOf(birthPicker.getValue()));
		expert.setCode(txt_Code.getText());
		expert.setSpecialty(ExpertSpecialityCombo.getValue()); 
		expert.setRole("Expert");
		ServiceAddExpert(expert);}
		
		else if(comboRole.getValue().equals("Agent")){
			agent.setFirstName(txt_FirstName.getText());
			agent.setLastName(txt_LastName.getText());
			agent.setEmail(txt_Email.getText());
			agent.setCin(Integer.parseInt(cinTxt.getText()));
			agent.setPhone(Integer.parseInt(txt_Phone.getText()));
			agent.setPhoto(textArea.getText());
			agent.setGender(Rfemale.isSelected());
			agent.setNote(0);
			agent.setBirthDate(java.sql.Date.valueOf(birthPicker.getValue()));
			agent.setCode(txt_Code.getText());
			agent.setAssignment_date(java.sql.Date.valueOf(birthPicker.getValue())); //à changer...
			agent.setAgence(AgentAgenceCombo.getValue()); 
			agent.setRole("Agent");
			ServiceAddAgent(agent);}		
	
		System.out.print("User added");
		ResetAction(event);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "New " + user.getRole()+ " added successfully !", ButtonType.OK);
        alert.show();
	}

    @FXML
    void importPicture(MouseEvent event) {
    	fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(
				new ExtensionFilter("Image Files", "*.png","*.jpg"),
				new ExtensionFilter("Text Files", "*txt"),
				new ExtensionFilter("Audio Files", "*.mp3"),
				new ExtensionFilter("All Files", "*.*")
				);
		file =fileChooser.showOpenDialog(null);
		if(file != null){
			//desktop.open(file);
			textArea.setEditable(false);
			textArea.setText(file.getAbsolutePath());
			image= new Image(file.toURI().toString(), 100 ,150, true, true);
			EmployeeImageView.setFitWidth(100);
			EmployeeImageView.setFitHeight(150);
			EmployeeImageView.setPreserveRatio(true);
			EmployeeImageView.setImage(image);
		}}
	

	@FXML
	void ResetAction(ActionEvent event) {
		txt_FirstName.setText("");
		txt_LastName.setText("");
		txt_Email.setText("");
		txt_Phone.setText("");
		txt_Code.setText("");
		txt_Rcode.setText("");
		comboRole.setValue("");
		cinTxt.setText("");
		birthPicker.setValue(null);
		EmployeeImageView.setImage(null);
		ExpertSpecialityCombo.setVisible(false);
		AgentAgenceCombo.setVisible(false);
		FinancierAdditionalDataBox.setVisible(false);
		FinancierManagementBox.setVisible(false);
		FinancierTransactionsBox.setVisible(false);
		FinancierServiceCombo.setVisible(false);
		labelRcode.setVisible(false);
		labelEmail.setVisible(false);
		labelBirth.setText("");
		labelPhone.setText("");
		labelCode.setText("");
		labelFirstName.setText("");
		labelLastName.setText("");
		labelCin.setText("");
		labelRole.setText("");
		
		
	}
    @FXML
    void changeCombo(ActionEvent event) {
    	if(comboRole.getValue()=="Expert"){
    		ExpertSpecialityCombo.setVisible(true);
    		AgentAgenceCombo.setVisible(false);
    		FinancierAdditionalDataBox.setVisible(false);
    		FinancierManagementBox.setVisible(false);
    		FinancierTransactionsBox.setVisible(false);
    		FinancierServiceCombo.setVisible(false);
    	}
    	else if(comboRole.getValue()=="Financier"){
    		FinancierAdditionalDataBox.setVisible(true);
    		FinancierManagementBox.setVisible(true);
    		FinancierTransactionsBox.setVisible(true);
    		FinancierServiceCombo.setVisible(true);
    		ExpertSpecialityCombo.setVisible(false);
    		AgentAgenceCombo.setVisible(false);
    	}
    	else if(comboRole.getValue()=="Agent"){
    		AgentAgenceCombo.setVisible(true);
       		FinancierAdditionalDataBox.setVisible(false);
    		FinancierManagementBox.setVisible(false);
    		FinancierTransactionsBox.setVisible(false);
    		FinancierServiceCombo.setVisible(false);
    		ExpertSpecialityCombo.setVisible(false);
    		
    	}

    }	
    @FXML
    void checkFinancierManagementAction(ActionEvent event) {
    	FinancierAdditionalDataBox.setSelected(false);
    	FinancierTransactionsBox.setSelected(false);

    }

    @FXML
    void CheckFinancierAdditionalDataAction(ActionEvent event) {
    	FinancierManagementBox.setSelected(false);
    	FinancierTransactionsBox.setSelected(false);
    }

    @FXML
    void CheckFinancierTransactionsAction(ActionEvent event) {
    	FinancierManagementBox.setSelected(false);
    	FinancierAdditionalDataBox.setSelected(false);
    }

    @FXML
    void returnToManage(MouseEvent event) throws IOException {
        FXMLLoader loader = containerParent.switchViewTo("/views/ManageEmployeesView.fxml");
        ((ManageEmployeesController) loader.getController()).setContainer(containerParent);
    	/*Parent dialog =  FXMLLoader.load(getClass().getResource("/views/ManageEmployeesView.fxml"));
		Scene dialogScene = new Scene(dialog);
		Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
		window.setScene(dialogScene);
		window.show();*/

    }

}
