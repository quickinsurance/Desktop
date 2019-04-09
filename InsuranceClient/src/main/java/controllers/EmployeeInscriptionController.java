package controllers;

import java.awt.Desktop;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import entities.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import services.interf.UserServiceRemote;
import util.MailVerification;

public class EmployeeInscriptionController implements Initializable{

	@FXML
	private JFXTextField txt_FirstName;

	@FXML
	private JFXTextField txt_LastName;

	@FXML
	private JFXTextField txt_Email;

	@FXML
	private JFXTextField txt_Phone;

	@FXML
	private JFXComboBox<String> comboRole;

	@FXML
	private JFXDatePicker birthPicker;

	@FXML
	private JFXRadioButton Rmale;

	@FXML
	private ToggleGroup genderGroup;

	@FXML
	private JFXRadioButton Rfemale;


	@FXML
	private Button btnPicture;

	@FXML
	private Button btnAdd;

	@FXML
	private Button btnReset;

	@FXML
	private ImageView imageView;

	
    @FXML
    private TextArea textArea;
    
    @FXML
    private Label labelFirstName;

    @FXML
    private Label labelCode;

    @FXML
    private Label labelPhone;

    @FXML
    private Label labelEmail;

    @FXML
    private Label labelLastName;

    @FXML
    private Label labelRcode;

    @FXML
    private Label labelRole;

    @FXML
    private Label labelBirth;
    
    @FXML
    private Button returnBtn;
    
    @FXML
    private JFXPasswordField txt_Code;

    @FXML
    private JFXPasswordField txt_Rcode;
    


	//User
	User user = new User();
	//combo Role
	private String aRole[] = {"Financier", "Expert", "Agent"};
	//Upload photo
	private FileChooser fileChooser;
	private File file;
	private Desktop desktop = Desktop.getDesktop();
	private Image image;


	public int ServiceAddUser(User u) throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
		Context context = new InitialContext();
		UserServiceRemote proxy = (UserServiceRemote) context.lookup(jndiName);

		return proxy.addUser(u);
	}


	
	private void initRole(){
		List<String> list = new ArrayList<String>();
		for(String content:aRole){
			list.add(content);
		}
		ObservableList oblist= FXCollections.observableArrayList(list);
		comboRole.setItems(oblist);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		initRole();
	}


	@FXML
	void addUser(ActionEvent event) throws Exception {
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
	        
	        if (txt_Phone.getText().equals("")) {
	            labelPhone.setText("Field is empty !");
	            labelPhone.setVisible(true);
	            valid = false;
	        }else {
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
	        
	        if (((new Date()).getYear() - java.sql.Date.valueOf(birthPicker.getValue()).getYear()) < 18){
                birthPicker.getStyleClass().add("error");
                Alert alert = new Alert(Alert.AlertType.ERROR, "Employee must at least 18 years old!", ButtonType.OK);
                alert.show();
            return;    
	        }
	        
	        if(!valid) return;
		
		user.setFirstName(txt_FirstName.getText());
		user.setLastName(txt_LastName.getText());
		user.setEmail(txt_Email.getText());
		user.setPhone(Integer.parseInt(txt_Phone.getText()));
		user.setRole(comboRole.getValue());
		user.setPhoto(textArea.getText());
		user.setGender(Rfemale.isSelected());
		user.setNote(0);
		user.setBirthDate(java.sql.Date.valueOf(birthPicker.getValue()));
		user.setCode(txt_Code.getText());
		ServiceAddUser(user);
		System.out.print("User added");
		Reset(event);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "New " + user.getRole()+ " added successfully !", ButtonType.OK);
        alert.show();
	}

	@FXML
	void importPicture(ActionEvent event) {
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
			imageView.setFitWidth(100);
			imageView.setFitHeight(150);
			imageView.setPreserveRatio(true);
			imageView.setImage(image);
	}}

	@FXML
	void Reset(ActionEvent event) {
		txt_FirstName.setText("");
		txt_LastName.setText("");
		txt_Email.setText("");
		txt_Phone.setText("");
		txt_Code.setText("");
		txt_Rcode.setText("");
		comboRole.setValue("");
		imageView.setImage(null);
		birthPicker.setValue(null);
		labelRcode.setVisible(false);
	} 




}
